
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
public final class Statistics implements Externalizable, Message<Statistics>, Schema<Statistics>
{

    public static Schema<Statistics> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static Statistics getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final Statistics DEFAULT_INSTANCE = new Statistics();
    static final String defaultScope = Statistics.class.getSimpleName();

    public List<Statistic> statistic;

    public Statistics()
    {
        
    }

	public static void clearModel(Model model) {

    }
    
	public void toModel(Model model) {

    }
    
	public static Statistics fromModel(Model model) {
		boolean hasFields = false;
    	Statistics message = new Statistics();

    	if (hasFields) {
    		return message;
    	} else {
    		return null;
    	}
    }

    public Boolean hasStatistic()  {
        return statistic == null ? false : true;
    }

	public List<Statistic> getStatisticList() {
		if(this.statistic == null)
            this.statistic = new ArrayList<Statistic>();
		return statistic;
	}

	public Statistics setStatisticList(List<Statistic> statistic) {
		this.statistic = statistic;
		return this;
	}

	public Statistic getStatistic(int index)  {
        return statistic == null ? null : statistic.get(index);
    }

    public int getStatisticCount()  {
        return statistic == null ? 0 : statistic.size();
    }

    public Statistics addStatistic(Statistic statistic)  {
        if(this.statistic == null)
            this.statistic = new ArrayList<Statistic>();
        this.statistic.add(statistic);
        return this;
    }

    public Statistics removeStatisticByName(Statistic statistic)  {
    	if(this.statistic == null)
           return this;
            
       	Iterator<Statistic> itr = this.statistic.iterator();
       	while (itr.hasNext()) {
    	Statistic obj = itr.next();

    		if (statistic.name.equals(obj.name)) {
    	
      			itr.remove();
    		}
		}
        return this;
    }

    public Statistics removeStatisticByValue(Statistic statistic)  {
    	if(this.statistic == null)
           return this;
            
       	Iterator<Statistic> itr = this.statistic.iterator();
       	while (itr.hasNext()) {
    	Statistic obj = itr.next();

    		if (statistic.value.equals(obj.value)) {
    	
      			itr.remove();
    		}
		}
        return this;
    }

    public Statistics removeStatisticByType(Statistic statistic)  {
    	if(this.statistic == null)
           return this;
            
       	Iterator<Statistic> itr = this.statistic.iterator();
       	while (itr.hasNext()) {
    	Statistic obj = itr.next();

    		if (statistic.type.equals(obj.type)) {
    	
      			itr.remove();
    		}
		}
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

    public Schema<Statistics> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public Statistics newMessage()
    {
        return new Statistics();
    }

    public Class<Statistics> typeClass()
    {
        return Statistics.class;
    }

    public String messageName()
    {
        return Statistics.class.getSimpleName();
    }

    public String messageFullName()
    {
        return Statistics.class.getName();
    }

    public boolean isInitialized(Statistics message)
    {
        return true;
    }

    public void mergeFrom(Input input, Statistics message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                
            	case 1:
            	
            		if(message.statistic == null)
                        message.statistic = new ArrayList<Statistic>();
                    
                    message.statistic.add(input.mergeObject(null, Statistic.getSchema()));
                    
                    break;

                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }

    public void writeTo(Output output, Statistics message) throws IOException
    {

    	if(message.statistic != null)
        {
            for(Statistic statistic : message.statistic)
            {
                if(statistic != null) {
                   	
    				output.writeObject(1, statistic, Statistic.getSchema(), true);
    				
    			}
            }
        }

    }

    public String getFieldName(int number)
    {
        switch(number)
        {
        	
        	case 1: return "statistic";
        	
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
    	
    	__fieldMap.put("statistic", 1);
    	
    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = Statistics.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static Statistics parseFrom(byte[] bytes) {
	Statistics message = new Statistics();
	ProtobufIOUtil.mergeFrom(bytes, message, Statistics.getSchema());
	return message;
}

public static Statistics parseFromJson(String json) throws IOException {
	byte[] bytes = json.getBytes(Charset.forName("UTF-8"));
	Statistics message = new Statistics();
	JsonIOUtil.mergeFrom(bytes, message, Statistics.getSchema(), false);
	return message;
}

public Statistics clone() {
	byte[] bytes = this.toByteArray();
	Statistics statistics = Statistics.parseFrom(bytes);
	return statistics;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public String toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, Statistics.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	String json = new String(out.toByteArray(), Charset.forName("UTF-8"));
	return json;
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<Statistics> schema = Statistics.getSchema();
    
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
		bytes = ProtobufIOUtil.toByteArray(this, Statistics.getSchema(), buffer);
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
		ProtobufIOUtil.writeTo(buffer, this, Statistics.getSchema());
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bb;
}

}
