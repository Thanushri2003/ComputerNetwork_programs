import java.net.*;
class MultiReceiver
{
	public static void main(String are[])
	{
		try
		{
			byte[] buffer=new byte[1024];
			MulticastSocket socket=new MulticastSocket(4321);
			InetAddress group=InetAddress.getByName("230.1.1.1");
			socket.joinGroup(group);
			DatagramPacket dp=new DatagramPacket(buffer,buffer.length);
			socket.receive(dp);
			String msg=new String(dp.getData(),0,dp.getLength());
			System.out.println("\n Received msg :"+msg);
			socket.leaveGroup(group);
			socket.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
