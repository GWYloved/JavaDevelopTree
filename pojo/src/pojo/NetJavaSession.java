package pojo;

import java.awt.List;
import java.awt.image.RescaleOp;
import java.beans.Statement;
import java.lang.Thread.State;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class NetJavaSession {
	public static String getSaveObjectSql(Object object) {
		String sql = "inset into ";
		Class class1 = object.getClass();
		Method[] methods = class1.getMethods();
		Field[] fields = class1.getFields();
		String cName = class1.getName();
		String tableName = cName.substring(cName.lastIndexOf(".") + 1, cName.length());
		sql += tableName + "(";
		ArrayList<String> mList = new ArrayList<String>();
		ArrayList vList = new ArrayList();
		for (Method method : methods) {
			String mName = method.getName();
			if (mName.startsWith("get") && !mName.startsWith("getClass")) {
				String fieldName = mName.substring(3, mName.length());
				mList.add(fieldName);
				System.out.println("字段名字 ----------->" + fieldName);
				try {
					Object value = method.invoke(object, null);
					System.out.println("执行方法返回的值 ------->" + value);
					if (value instanceof String) {
						vList.add("\"" + value + "\"");
						System.out.println("字段值----->" + value);
					} else {
						vList.add(value);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		for (int i = 0; i < mList.size(); i++) {
			if (i < mList.size() - 1) {
				sql += mList.get(i) + ",";
			} else {
				sql += mList.get(i) + ")";
			}
		}
		for (int i = 0; i < vList.size(); i++) {
			if (i < vList.size() - 1) {
				sql += vList.get(i) + ",";
			} else {
				sql += vList.get(i) + ")";
			}
		}
		return sql;
	}

	public static List getDataFromDB(String tableName, int Id) {
		return null;
	}

	public int saveObject(Object object) {
		Connection connection = Connect2DBfactory.getDBconnection();
		String sql = getSaveObjectSql(object);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
			// TODO: handle exception
		}
	}

	public Object getObject(String className, int Id) {
		String tableName = className.substring(className.lastIndexOf(".") + 1, className.length());
		Class class1 = null;
		try {
			class1 = Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		String sql = "select * from "+tableName +" where Id="+Id;
		System.out.println("查找Sql语句："+sql);
		Connection connection = Connect2DBfactory.getDBconnection();
		Object object = null;
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet set = ((java.sql.Statement) statement).executeQuery(sql);
			Method[] methods = class1.getMethods();
			while (set.next()) {
				object = class1.newInstance();
				for(Method method:methods){
					String methodName = method.getName();
					if (methodName.startsWith("set")) {
						String columeName = methodName.substring(3, methodName.length());
						Class[] parmts = method.getParameterTypes();
						if (parmts[0] == String.class) {
							method.invoke(object, set.getString(columeName));
						}
						if (parmts[0] == int.class) {
							method.invoke(object, set.getInt(columeName));
						}
					}
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return object;
	}

}
