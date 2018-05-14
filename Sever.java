package chatclientsever;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
public static void main(String[] args) {
try {	//tao cong port phia server
	ServerSocket server = new ServerSocket(8003);
	System.out.println("sever start");
	//tao socket
	Socket serversocket = server.accept();
	System.out.println("writing");
	//tao datainputstream de nhan du lieu tu client

	DataInputStream inputserver = new DataInputStream(serversocket.getInputStream());
	String so1 = inputserver.readLine();
    DataOutputStream outputserver = new DataOutputStream(serversocket.getOutputStream());
    outputserver.writeBytes(String.valueOf(so1));
     outputserver.writeBytes("hi");
     
	inputserver.close();
	outputserver.close();
	
	}
catch (Exception e) {
	// TODO: handle exception
}
}
}
	

