package pojo;

import java.sql.SQLClientInfoException;

public class tester {
	public static void main(String args[]) {
		NetJavaSession session = new NetJavaSession();
		UserInfo userInfo = new UserInfo();
		userInfo.setId(6988);
		userInfo.setAge(44);
		userInfo.setPwd("pwd");
		userInfo.setName("champion");
		String sql = session.getSaveObjectSql(userInfo);
		System.out.println("sql = "+sql);
		UserInfo userInfo2 = (UserInfo)session.getObject("cn.netjava.pojo.UserInfo2", 6988);
		System.out.println("获取到的信息 = "+userInfo2);
	}
}
