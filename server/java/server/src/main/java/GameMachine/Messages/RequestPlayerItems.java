
package GameMachine.Messages;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.io.UnsupportedEncodingException;

import com.dyuproject.protostuff.ByteString;
import com.dyuproject.protostuff.GraphIOUtil;
import com.dyuproject.protostuff.Input;
import com.dyuproject.protostuff.Message;
import com.dyuproject.protostuff.Output;
import com.dyuproject.protostuff.ProtobufOutput;

import java.io.ByteArrayOutputStream;
import com.dyuproject.protostuff.JsonIOUtil;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import com.game_machine.util.LocalLinkedBuffer;

import java.nio.charset.Charset;

import org.javalite.activejdbc.Model;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.UninitializedMessageException;

@SuppressWarnings("unused")
public final class RequestPlayerItems implements Externalizable, Message<RequestPlayerItems>, Schema<RequestPlayerItems>
{

    public static Schema<RequestPlayerItems> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static RequestPlayerItems getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final RequestPlayerItems DEFAULT_INSTANCE = new RequestPlayerItems();
    static final String defaultScope = RequestPlayerItems.class.getSimpleName();

		public Boolean catalog;

    public RequestPlayerItems()
    {
        
    }

	public static void clearModel(Model model) {

    	model.set("request_player_items_catalog",null);
    	
    }
    
	public void toModel(Model model) {

    	if (catalog != null) {
    		model.setBoolean("request_player_items_catalog",catalog);
    	}

    }
    
	public static RequestPlayerItems fromModel(Model model) {
		boolean hasFields = false;
    	RequestPlayerItems message = new RequestPlayerItems();

    	Boolean catalogField = model.getBoolean("request_player_items_catalog");
    	if (catalogField != null) {
    		message.setCatalog(catalogField);
    		hasFields = true;
    	}

    	if (hasFields) {
    		return message;
    	} else {
    		return null;
    	}
    }

    public Boolean hasCatalog()  {
        return catalog == null ? false : true;
    }

	public Boolean getCatalog() {
		return catalog;
	}
	
	public RequestPlayerItems setCatalog(Boolean catalog) {
		this.catalog = catalog;
		return this;
	}

    // java serialization

    public void readExternal(ObjectInput in) throws IOException
    {
        GraphIOUtil.mergeDelimitedFrom(in, this, this);
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        GraphIOUtil.writeDelimitedTo(out, this, this);
    }

    // message method

    public Schema<RequestPlayerItems> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public RequestPlayerItems newMessage()
    {
        return new RequestPlayerItems();
    }

    public Class<RequestPlayerItems> typeClass()
    {
        return RequestPlayerItems.class;
    }

    public String messageName()
    {
        return RequestPlayerItems.class.getSimpleName();
    }

    public String messageFullName()
    {
        return RequestPlayerItems.class.getName();
    }

    public boolean isInitialized(RequestPlayerItems message)
    {
        return true;
    }

    public void mergeFrom(Input input, RequestPlayerItems message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                
            	case 1:

                	message.catalog = input.readBool();
                	break;

                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }

    public void writeTo(Output output, RequestPlayerItems message) throws IOException
    {

    	if(message.catalog != null)
            output.writeBool(1, message.catalog, false);

    }

    public String getFieldName(int number)
    {
        switch(number)
        {
        	
        	case 1: return "catalog";
        	
            default: return null;
        }
    }

    public int getFieldNumber(String name)
    {
        final Integer number = __fieldMap.get(name);
        return number == null ? 0 : number.intValue();
    }

    private static final java.util.HashMap<String,Integer> __fieldMap = new java.util.HashMap<String,Integer>();
    static
    {
    	
    	__fieldMap.put("catalog", 1);
    	
    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = RequestPlayerItems.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static RequestPlayerItems parseFrom(byte[] bytes) {
	RequestPlayerItems message = new RequestPlayerItems();
	ProtobufIOUtil.mergeFrom(bytes, message, RequestPlayerItems.getSchema());
	return message;
}

public static RequestPlayerItems parseFromJson(String json) throws IOException {
	byte[] bytes = json.getBytes(Charset.forName("UTF-8"));
	RequestPlayerItems message = new RequestPlayerItems();
	JsonIOUtil.mergeFrom(bytes, message, RequestPlayerItems.getSchema(), false);
	return message;
}

public RequestPlayerItems clone() {
	byte[] bytes = this.toByteArray();
	RequestPlayerItems requestPlayerItems = RequestPlayerItems.parseFrom(bytes);
	return requestPlayerItems;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public String toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, RequestPlayerItems.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	String json = new String(out.toByteArray(), Charset.forName("UTF-8"));
	return json;
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<RequestPlayerItems> schema = RequestPlayerItems.getSchema();
    
	final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final ProtobufOutput output = new ProtobufOutput(buffer);
    try
    {
    	schema.writeTo(output, this);
        final int size = output.getSize();
        ProtobufOutput.writeRawVarInt32Bytes(out, size);
        final int msgSize = LinkedBuffer.writeTo(out, buffer);
        assert size == msgSize;
        
        buffer.clear();
        return out.toByteArray();
    }
    catch (IOException e)
    {
        throw new RuntimeException("Serializing to a byte array threw an IOException " + 
                "(should never happen).", e);
    }
 
}

public byte[] toProtobuf() {
	LinkedBuffer buffer = LocalLinkedBuffer.get();
	byte[] bytes = null;

	try {
		bytes = ProtobufIOUtil.toByteArray(this, RequestPlayerItems.getSchema(), buffer);
		buffer.clear();
	} catch (Exception e) {
		buffer.clear();
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bytes;
}

public ByteBuf toByteBuf() {
	ByteBuf bb = Unpooled.buffer(512, 2048);
	LinkedBuffer buffer = LinkedBuffer.use(bb.array());

	try {
		ProtobufIOUtil.writeTo(buffer, this, RequestPlayerItems.getSchema());
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bb;
}

}
