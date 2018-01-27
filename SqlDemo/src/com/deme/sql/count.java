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
		System.out.println("�����м���Keyֵ(�������֣�����Ĭ��Ϊ0)");
		Scanner scForKeyIndex=new Scanner(System.in);
		keyIndex = scForKeyIndex.hasNextInt() ? scForKeyIndex.nextInt() : 0;
//		System.out.println("keyIndex = "+keyIndex); // put keyIndex
		if(keyIndex==0){
			System.out.println("key��0�����ñ���Ч");
			return;
		}
		String [] key = new String [keyIndex];//default length + 1;
		for (int i=0;i<=key.length-1;i++){//default length;
			int id=i+1;
			System.out.println("�����"+id+"��Key������");
			Scanner scForKeyName = new Scanner(System.in);
			key[i]=scForKeyName.nextLine();
		}
		for (int i=0;i<=key.length-1;i++){
			
		}
		
	}
	

}
