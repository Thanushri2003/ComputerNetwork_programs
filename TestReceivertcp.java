import java.net.*;
import java.io.*;
class TestReceivertcp
{
	public static void main(String ar[])
	{
		try
		{
			Socket s1=new Socket("127.0.0.1",2000);
			
			
			
			PrintStream netout=new PrintStream(s1.getOutputStream());
			
			DataInputStream netin=new DataInputStream(s1.getInputStream());

			String x=netin.readLine();		
			System.out.println("Received Filename :"+x);

			FileInputStream fin=new FileInputStream(x);	
			byte b;
			String y="";
			while((b=(byte)fin.read())!=-1)
			{
				System.out.print((char)b);	
				y=y+(char)b;
			}		

			netout.write(y.getBytes());
			
			System.out.println("Successfully sent...");			
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}