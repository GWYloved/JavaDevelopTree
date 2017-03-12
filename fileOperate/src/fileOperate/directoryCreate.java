package fileOperate;

import java.io.File;

public class directoryCreate {
	public static void main(String[] args){
		String path = "G://3//2";
		if(directoryCreate(path)){
			System.out.println("创建成功");
		}
	}
	public static boolean directoryCreate(String path){
		boolean isCreate = false;
		File file = new File(path);
		if(!file.exists()){
			isCreate = file.mkdirs();
		}
		return isCreate;
		
	}
}
