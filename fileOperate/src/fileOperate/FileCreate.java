package fileOperate;

import java.io.File;
import java.io.IOException;

public class FileCreate {
	static String path = "G://3//2//1.txt";
	public static void main(String[] args) throws IOException{
		boolean isCreate = false;
		File file = new File(path);
		if(!file.exists()){
			isCreate = file.createNewFile();
			
		}
		System.out.println(isCreate);
	}

}
