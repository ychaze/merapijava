import merapi.Bridge;
import merapi.messages.IMessage;
import merapi.messages.IMessageHandler;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;


public class DataSourceHandler implements IMessageHandler {
	private Object ds;
	@Override
	public void handleMessage(IMessage message) {
		try{
			System.out.println("Try to handle messeage...");
		//	this.ds = message.getData();
			System.out.println("Recieve an object");
			//System.out.println(o.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main( String args[] )
	{
		System.out.println( "Merapi Started\n" );
		
		//  Register MerapiHelloWorld as a listener for messages of type "helloWorldType"
		Bridge.getInstance().registerMessageHandler( "dataSoruce", new DataSourceHandler() );
	}
}
