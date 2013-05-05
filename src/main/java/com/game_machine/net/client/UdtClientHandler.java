package com.game_machine.net.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import io.netty.channel.udt.UdtMessage;
import io.netty.channel.udt.nio.NioUdtProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.game_machine.ProtobufMessages.ClientMessage;
import com.google.protobuf.ByteString;

public class UdtClientHandler extends ChannelInboundMessageHandlerAdapter<UdtMessage> {

	private static final Logger log = Logger.getLogger(UdtClientHandler.class.getName());

	private ChannelHandlerContext ctx = null;
	private UdtClient client;
	private int messageCount = 0;

	public UdtClientHandler(UdtClient client) {
		this.client = client;
		log.setLevel(UdtClient.logLevel);
	}

	public Boolean send(byte[] bytes) {
		ClientMessage.Builder builder = ClientMessage.newBuilder();
		ByteString reply = ByteString.copyFrom(bytes);
		builder.setBody(reply);
		ctx.channel().write(builder.build().toByteArray());
		ClientMessage clientMessage = builder.build();

		ByteBuf buf = Unpooled.copiedBuffer(clientMessage.toByteArray());
		UdtMessage message = new UdtMessage(buf);
		this.ctx.channel().write(message);

		return true;
	}

	@Override
	public void channelActive(final ChannelHandlerContext ctx) throws Exception {
		log.warning("CLIENT ECHO active " + NioUdtProvider.socketUDT(ctx.channel()).toStringOptions());
		this.ctx = ctx;
		this.client.callable.send("READY".getBytes());

	}

	public void messageReceived(final ChannelHandlerContext ctx, final UdtMessage m) {
		log.info("CLIENT messageReceived " + messageCount);
		byte[] bytes = new byte[m.data().readableBytes()];
		m.data().readBytes(bytes);
		this.client.callable.send(bytes);

	}

	@Override
	public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) {
		log.log(Level.WARNING, "close the connection when an exception is raised", cause);
		ctx.close();
	}

}