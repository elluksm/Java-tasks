//17.mâjasdarbs - Elîna Mûrniece
//metodes no 5 daþâdâm java.net pakotnes klasçm

import java.net.*;
import java.util.Date;
import java.io.*;

public class Md_17 {

	public static void main(String[] args) throws UnknownHostException, MalformedURLException, Exception {
		
		//InetAddress klase
	      InetAddress y = InetAddress.getLocalHost();
	      System.out.println(y);
	      
	      y = InetAddress.getByName("apollo.tvnet.lv");
	      System.out.println(y);
	      System.out.println("Host name: " + y.getHostName());
	      System.out.println("Host address: " + y.getHostAddress());

		//URL klase
	      URL y2 = new URL("http://www.archdaily.com/search/projects/categories/houses");
	      System.out.println("Protokols: " + y2.getProtocol());
	      System.out.println("Hosts: " + y2.getHost());
	      System.out.println("Fails: " + y2.getFile());

		//URL Connection klase
	      URLConnection y2con = y2.openConnection();
	      System.out.println("Datums: " + new Date(y2con.getDate()));
	      System.out.println("Satura tips: " + y2con.getContentType());
	      System.out.println("Pedejas izmainas: " + new Date(y2con.getLastModified()));
	      
	    //Socket klase
	      Socket y3 = new Socket(y, 80);
	      int z;
	      InputStream in = y3.getInputStream();
	      OutputStream out = y3.getOutputStream();
	      System.out.println("Soket-objekta InetAdress: " + y3.getInetAddress());
	      System.out.println("Soket-objekta Ports: " + y3.getPort());
	      y3.close();
	      
	      //DatagramPacket klase
	      byte buffer[] = new byte[1024] ;
	      DatagramPacket y4 = new DatagramPacket(buffer, buffer.length);
	      System.out.println(y4.getLength());
	      System.out.println(y4.getPort());
	      System.out.println(y4.getAddress());

	}

}

