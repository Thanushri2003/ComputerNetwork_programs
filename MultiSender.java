import java.net.*;
class MultiSender
{
	public static void main(String are[])
	{
		try
		{
			DatagramSocket socket=new DatagramSocket();
			InetAddress group=InetAddress.getByName("230.1.1.1");
			byte[] msg="welcome to SASTRA".getBytes();
			DatagramPacket dp=new DatagramPacket(msg,msg.length,group,4321);
			socket.send(dp);
			socket.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}