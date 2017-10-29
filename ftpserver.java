import java.nio.file.*;
import java.io.*;
import java.net.*;

public class ftpserver {
	public static void main(String[] args) throws IOException {
		int port = Integer.parseInt(args[0]);
		ServerSocket s = new ServerSocket(port);
		Socket conn = s.accept();
		File file = new File(System.getProperty("user.home")+"/Desktop/Driver.java");

		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);

		OutputStream os = conn.getOutputStream();

		byte[] contents;
		long fileLength = file.length();
		long current = 0;

		while(current != fileLength){
			int size = 10000;
			if(fileLength-current >= size){
				current += size;

			}
			else{
				size = (int)(fileLength - current);
				current = fileLength;
			}
			contents = new byte[size];
			bis.read(contents,0,size);
			os.write(contents);
			System.out.println("File printed sucessfully");
			conn.close();
			s.close();
		}
	}
}