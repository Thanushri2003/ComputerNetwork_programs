import java.io.*;
import java.net.*;

public class Sender {
    public static void main(String[] args) {
        try {
            InetAddress receiverAddress = InetAddress.getByName("localhost");
            int receiverPort = 12345;
            int windowSize = 4;
            int counter = windowSize;
            
            DatagramSocket socket = new DatagramSocket();
            
            for (int sequenceNumber = 0; sequenceNumber < 20; sequenceNumber++) {
                if (counter > 0) {
                    String message = "Message " + sequenceNumber;
                    byte[] sendData = message.getBytes();
                    DatagramPacket packet = new DatagramPacket(sendData, sendData.length, receiverAddress, receiverPort);
                    socket.send(packet);
                    System.out.println("Sent: " + message);
                    counter--;
                }
                
                if (counter == 0 || sequenceNumber == 19) {
                    byte[] receiveData = new byte[1024];
                    DatagramPacket ackPacket = new DatagramPacket(receiveData, receiveData.length);
                    socket.receive(ackPacket);
                    String ackMessage = new String(ackPacket.getData(), 0, ackPacket.getLength());
                    System.out.println("Received: " + ackMessage);
                    counter += Integer.parseInt(ackMessage.split(" ")[1]);
                }
            }
            
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
///////////////////////////


import java.io.*;
import java.net.*;

public class Receiver {
    public static void main(String[] args) {
        try {
            int receiverPort = 12345;
            int expectedSequenceNumber = 0;
            
            DatagramSocket socket = new DatagramSocket(receiverPort);
            
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                int receivedSequenceNumber = Integer.parseInt(message.split(" ")[1]);
                
                if (receivedSequenceNumber == expectedSequenceNumber) {
                    System.out.println("Received: " + message);
                    expectedSequenceNumber++;
                }
                
                String ackMessage = "ACK " + receivedSequenceNumber;
                byte[] sendData = ackMessage.getBytes();
                DatagramPacket ackPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                socket.send(ackPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



////////////////////////