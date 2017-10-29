import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.net.*;
import java.io.BufferedOutputStream;

public class ftpclient {
	public static void main(String[] args) throws IOException {
		InetAddress local = InetAddress.getByName(args[0]);
		int port = Integer.parseInt(args[1]);
		Socket s = new Socket(local,port);
                byte[] contents = new byte[10000];
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.home")+"/Desktop/con1.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		InputStream is = s.getInputStream();

		int abyte = 0;

		while((abyte = is.read(contents)) != -1){
			bos.write(contents,0,abyte);
		}

		bos.flush();
		s.close();
	}
}

