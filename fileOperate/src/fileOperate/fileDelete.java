package fileOperate;

import java.io.File;

public class fileDelete {
	public static void main(String[] args){
		String path = "G://1.txt";
		if(fileDelete(path)){
			System.out.println("not exist or deleted succeed!");
		}
	}
	public static boolean fileDelete(String path){
		File file = new File(path);
		if(!file.exists()){
			return true;
		}else{
			return file.delete();
		}
	}
}
