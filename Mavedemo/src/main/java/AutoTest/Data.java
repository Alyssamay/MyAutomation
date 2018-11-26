package AutoTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Data {
	static void main(String args[]) {
	try {
		String pathname="C:\\demo\\MyAutomation\\Mavedemo\\src\\main\\resources\\Data.case";
		File filename =new  File(pathname);//读取以上路径的文件
		InputStreamReader reader=new InputStreamReader(new FileInputStream(filename));
		BufferedReader br=new BufferedReader(reader); 
		String line="";
		line=br.readLine();
		while(line!=null) {
			line=br.readLine();
		}
		
	} catch (IOException e) {
		// TODO: handle exception
	}finally {
		if (in!=null) {
			
			
		}
	}
}
}
