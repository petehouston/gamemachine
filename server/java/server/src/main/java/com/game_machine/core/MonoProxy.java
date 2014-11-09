package com.game_machine.core;

import com.game_machine.net.udp.UdpClient;

import GameMachine.Messages.Entity;
import GameMachine.Messages.MonoMessage;

public class MonoProxy {

	private static class LazyHolder {
		private static final MonoProxy INSTANCE = new MonoProxy();
	}

	public static MonoProxy getInstance() {
		return LazyHolder.INSTANCE;
	}

	private MonoProxy() {
		udpClient = new UdpClient(24320, 1);
		if (!udpClient.connect()) {
			throw new RuntimeException("Unable to connect to mono");
		}
	}

	private UdpClient udpClient;

	public Entity call(String klass, Entity entity) {
		MonoMessage message = new MonoMessage();
		message.setKlass(klass);
		message.setEntity(entity);
		byte[] bytes = udpClient.sendReceive(message.toByteArray());
		if (bytes == null) {
			return null;
		} else {
			message = MonoMessage.parseFrom(bytes);
			return message.entity;
		}
	}

}
