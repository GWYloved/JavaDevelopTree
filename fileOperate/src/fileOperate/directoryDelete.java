package fileOperate;

import java.io.File;

public class directoryDelete {
	public static void main(String[] args){
		String path = "G://3";
		if(directoryDelete(path)){
			System.out.println("not exist or deleted succeed!");
		}else{
			System.out.println("errorQ!!!!");
		}
	}
	public static boolean directoryDelete(String path){
		File file = new File (path);
		if(file.exists()){
			file.deleteOnExit();
			return true;
		}else{
			return true;
		}
	}
}
