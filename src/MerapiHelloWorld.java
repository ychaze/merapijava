import merapi.Bridge;
import merapi.messages.IMessage;
import merapi.messages.IMessageHandler;
import merapi.messages.Message;

/**
 *  MerapiHelloWorld is a Merapi sample application that receives and sends a simple message 
 *  of String data via the Merapi bridge. MerapiHelloWorld serves as a bootstrap to start the
 *  Merapi process as well as an IMessageHandler to receive message of type "helloWorldType"
 *  from the Merapi Flex process.
 */
public class MerapiHelloWorld implements IMessageHandler 
{
	
	public MerapiHelloWorld(){
		super();
	}
	/**
	 *  This main method provides a bootstrap for executing MerapiHelloWorld as a process
	 *  that starts the bridge. 
	 */
	public static void main( String args[] )
	{
		System.out.println( "Merapi Started\n" );
		
		//  Register MerapiHelloWorld as a listener for messages of type "helloWorldType"
		Bridge.getInstance().registerMessageHandler( "helloWorldType", new MerapiHelloWorld() );
	}
 
	/**
	 *  Required by the interface IMessageHandler. Messages of type "helloWorldType" are
	 *  delivered to handleMessage() via the Merapi Bridge.
	 */
	public void handleMessage( IMessage message )
	{
		try 
		{
			System.out.println( "Received \"" + message.getData() + "\" from Merapi Flex" );
			System.out.println( "Responding with \"Hello Merapi Flex\"\n" );
			
			//  Instantiate a Message to respond to Merapi Flex
			Message response = new Message( "helloWorldType", null, "Hello Merapi Flex" );
			
			//  Send message to Merapi Flex
			Bridge.getInstance().sendMessage( response );
		}
		catch( Exception exception )
		{
			exception.printStackTrace();
		}
	}
	
}
