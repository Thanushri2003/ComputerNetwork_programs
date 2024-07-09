import java.net.*;
import java.io.*;
class TestSendertcp
{
	public static void main(String ar[])
	{
		try
		{

			
			
			ServerSocket ss=new ServerSocket(2000);
			System.out.println("Waiting for providing service....");
			Socket s=ss.accept();
			PrintStream netout=new PrintStream(s.getOutputStream());
			DataInputStream netin=new DataInputStream(s.getInputStream());
			System.out.println("Connection Established");
				
			netout.write("TestReceiver.java".getBytes());
			netout.write("\n".getBytes());
			System.out.println("Successfully sent...");


			System.out.println("Received Msg:"+netin.readLine());
			
			
	
			
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}