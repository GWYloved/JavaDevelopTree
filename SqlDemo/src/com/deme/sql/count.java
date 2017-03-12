package com.deme.sql;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * for count on 
 * @author Administrator
 *
 */
public class count {
	public static void main(String [] args){
		Map<String,String> keyMap = new HashMap<String,String>();
		int keyIndex ;
		System.out.println("输入有几个Key值(输入数字，否则默认为0)");
		Scanner scForKeyIndex=new Scanner(System.in);
		keyIndex = scForKeyIndex.hasNextInt() ? scForKeyIndex.nextInt() : 0;
//		System.out.println("keyIndex = "+keyIndex); // put keyIndex
		if(keyIndex==0){
			System.out.println("key有0个，该表无效");
			return;
		}
		String [] key = new String [keyIndex];//default length + 1;
		for (int i=0;i<=key.length-1;i++){//default length;
			int id=i+1;
			System.out.println("输入第"+id+"个Key的名字");
			Scanner scForKeyName = new Scanner(System.in);
			key[i]=scForKeyName.nextLine();
		}
		for (int i=0;i<=key.length-1;i++){
			
		}
		
	}
	

}
