import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class test2 implements ActionListener
{
    JFrame f;
    JLabel l1, l2;
    JTextArea ta1;
    JTextField tf1, tf2;
    JButton b2;
    Font f1;

    test2()
    {
        f = new JFrame("CHATapp");
        l1 = new JLabel("Welcome to CHATapp");
        l2 = new JLabel("To");
 f.setLayout(null);
        f1 = new Font("Arial", Font.BOLD, 24);

        b2 = new JButton("send");

        ta1 = new JTextArea();

        tf1 = new JTextField();
        tf2 = new JTextField();

        l1.setBounds(700, 50, 300, 150);
        l2.setBounds(650, 100, 300, 150);

        b2.setBounds(1020, 600, 80, 30);

        tf1.setBounds(700, 160, 300, 30); // Adjusted position
        tf2.setBounds(720, 600, 300, 30); // Adjusted position

        ta1.setBounds(650, 250, 500, 250);

        b2.addActionListener(this);
        f.add(ta1);
        f.add(l1);
        f.add(l2);
        f.add(tf1);
	
        f.add(b2);
        f.add(tf2);
        l1.setFont(f1);

        f.setVisible(true);
       f.setSize(1200, 800);  // Increased width to accommodate adjusted positions
       
try{
			Socket s1=new Socket("192.168.43.78",2000);
			InputStream in=s1.getInputStream();
			byte b[]=new byte[100];
			
			in.read(b,0,100);
			ta1.setText(new String(b));
			System.out.println(new String(b));
}
catch(Exception e)
{
	System.out.println(e);
}
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getActionCommand().equals("send"))
        {
            String mess = tf1.getText();

		try
		{
			ta1.setText(mess);
			tf1.setText("");
			ServerSocket ss=new ServerSocket(2000);
			System.out.println("waiting to provide services");
			Socket s=ss.accept();
			System.out.println("Connection Establised");

			OutputStream out=s.getOutputStream();
			out.write(mess.getBytes());
			

			System.out.println("successfully sent"); 

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
        }
    }
}

class chatapp_se
{
    public static void main(String ar[])
    {
        test2 t = new test2();
    }
}
