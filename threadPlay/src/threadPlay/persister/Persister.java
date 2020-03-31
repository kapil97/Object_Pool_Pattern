package threadPlay.persister;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

public class Persister implements PersisterI{
	String fileOutName;
	List<String> numList=new ArrayList<>();
	public Persister(String outNumStream)
	{	
		fileOutName = outNumStream;
	}
	public void persisterServer(String port)
	{ 
		try
		{
				ServerSocket server = new ServerSocket(Integer.parseInt(port));
				Socket socket = server.accept();
				DataInputStream dataIn = new DataInputStream(socket.getInputStream());
				BufferedWriter b;
				FileWriter f;
				f = new FileWriter(fileOutName);
				b = new BufferedWriter(f);
			 	String str="";
			 	while(!str.equals("STOP")) {
					str = dataIn.readUTF();
					numList.add(str);
				}
			 	numList.remove(numList.indexOf("STOP"));
				for(String s: numList)
					b.write(s + "\n");
				if(str.equals("STOP"))
				{	System.out.println("Written to file Successfully");
					b.close();
					dataIn.close();
					socket.close();
					server.close();
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}