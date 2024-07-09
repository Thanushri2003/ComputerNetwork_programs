import java.io.*;
import java.net.*;
class TestSenderupd
{
	public static void main(String ar[])
	{
		try
		{
			DatagramSocket ds=new DatagramSocket(3000);
			
			DatagramPacket dp=new DatagramPacket("welcome".getBytes(),7,InetAddress.getByName("127.0.0.1"),4000);
			
			ds.send(dp);
			System.out.println("Successfully sent...");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}