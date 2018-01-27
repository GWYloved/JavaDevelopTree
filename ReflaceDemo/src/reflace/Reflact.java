package reflace;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflact {
    public static void main(String[] args) {
//        getSuperClass();
//        getInterfaces();
//        getClassObject();
//        getCallMethodCostTime(1000);
//        getCallFieldCostTime(1000);
//        compareCallMethodAndField();
        getCurrentClassFields();
        getCurrentClassMethod();
    }
    private static void getClassObject(){
        Class<?> classObject = null;
        classObject = getClassObject_1();
        System.out.println("classobject_1 name : " + classObject.getName());
        classObject = getClassObject_2();
        System.out.println("classobject_2 name : "+classObject.getName());
        classObject = getClassObject_3();
        System.out.println("classobject_3 name : "+classObject.getName());

    }
    private static void getSuperClass(){
        ProgramMonkey programMonkey = new ProgramMonkey("小明", "男", 12);
        Class<?> superClass = programMonkey.getClass().getSuperclass();
        while (superClass != null){
            System.out.println("programMonkey`s super class is : "+superClass.getName());
            superClass = superClass.getSuperclass();
        }
    }
    private static void getInterfaces(){
        ProgramMonkey programMonkey = new ProgramMonkey("小明","男",12);
        Class<?>[] interfaces = programMonkey.getClass().getInterfaces();
        for (Class<?> clas: interfaces){
            System.out.println("programMonkey`s interfaces is : "+clas.getName());
        }
    }
    private static void compareCallMethodAndField(){
        long callMethodCostTime = getCallMethodCostTime(10);
        System.out.println("callMethodCostTime == " + callMethodCostTime);
        long callFieldCostTime = getCallFieldCostTime(10000);
        System.out.println("callFieldCostTime == " + callFieldCostTime);
    }
    private static long getCallMethodCostTime(int count){
        long startTime = System.currentTimeMillis();
        for (int index = 0; index < count; index ++){
            ProgramMonkey programMonkey = new ProgramMonkey("小明", "男", 12);
            try {
                Method setmLanguageMethod = programMonkey.getClass().getMethod("setmLanguage", String.class);
                setmLanguageMethod.setAccessible(true);
                setmLanguageMethod.invoke(programMonkey, "Java");
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }catch (InvocationTargetException e){
                e.printStackTrace();
            }catch (NoSuchMethodException e){
                e.printStackTrace();
            }
        }
        return System.currentTimeMillis() - startTime;
    }
    private static long getCallFieldCostTime(int count){
        long startTime = System.currentTimeMillis();
        for (int index = 0; index < count; index++){
            ProgramMonkey programMonkey = new ProgramMonkey("小明","男", 12);
            try {
                Field ageField = programMonkey.getClass().getDeclaredField("mLanguage");
                ageField.set(programMonkey,"Java");
            }catch (NoSuchFieldException e){
                e.printStackTrace();
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }
        return System.currentTimeMillis() - startTime;
    }

    private static void getCurrentClassMethod(){
        ProgramMonkey programMonkey = new ProgramMonkey("小明","男",12);
        Method[] methods = programMonkey.getClass().getDeclaredMethods();
        for (Method method : methods){
            System.out.println("declared method name : "+method.getName());
        }
        try {
            Method getSalaryPerMonthMethod = programMonkey.getClass().getDeclaredMethod("getSalaryPerMonth");
            getSalaryPerMonthMethod.setAccessible(true);
            Class<?> returnType = getSalaryPerMonthMethod.getReturnType();
            System.out.println("getSalaryPerMonth 方法返回类型："+ returnType.getName());
            Class<?>[] paramClasses = getSalaryPerMonthMethod.getParameterTypes();
            for (Class<?> clas : paramClasses){
                System.out.println("getSalaryPerMonth 方法的参数类型"+clas.getName());
            }
            System.out.println(getSalaryPerMonthMethod.getName() + "is private ? "+ Modifier.isPrivate(getSalaryPerMonthMethod.getModifiers()));
            Object result = getSalaryPerMonthMethod.invoke(programMonkey);
            System.out.println("getSalaryPerMonth 方法的返回结果: "+result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void getAllMethods(){
        ProgramMonkey programMonkey = new ProgramMonkey("小明","男",12);
        Method[] methods = programMonkey.getClass().getMethods();
        for (Method method : methods){
            System.out.println("method name : "+ method.getName());
        }
        try {
            Method setLanguageMethod = programMonkey.getClass().getMethod("setmLanguage", String.class);
            setLanguageMethod.setAccessible(true);
            Class<?> returnType = setLanguageMethod.getReturnType();
            System.out.println("setLanguage 方法的返回类型: "+returnType.getName());
            Class<?>[] paramClasses = setLanguageMethod.getParameterTypes();
            for (Class<?> clas : paramClasses){
                System.out.println("setLanguage 方法的参数类型 ： "+clas.getName());
            }
            System.out.println(setLanguageMethod.getName() + "is private " +Modifier.isPrivate(returnType.getModifiers()));
            Object result = setLanguageMethod.invoke(programMonkey, "Java");
            System.out.println("setlanage方法的返回结果: "+result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Class<?> getClassObject_1(){
        return ProgramMonkey.class;
    }
    private static Class<?> getClassObject_2(){
        ProgramMonkey programMonkey = new ProgramMonkey("小明","男",12);
        return programMonkey.getClass();
    }
    private static Class<?> getClassObject_3(){
        try {
            return Class.forName("reflace.ProgramMonkey");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    private static void getCurrentClassFields(){
        ProgramMonkey programMonkey = new ProgramMonkey("小明","男",12);
        Field[] publicFields = programMonkey.getClass().getDeclaredFields();
        for (Field field : publicFields){
            System.out.println("declared field name : "+ field.getName());
        }
        try {
            Field ageField = programMonkey.getClass().getDeclaredField("");
            System.out.println("my age is : "+ageField.getInt(programMonkey));
            ageField.set(programMonkey, 10);
            System.out.println("my age is : "+ageField.getInt(programMonkey));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void getAllFields(){
        ProgramMonkey programMonkey = new ProgramMonkey("小明","男",12);
        Field[] publicFields = programMonkey.getClass().getFields();
        for (Field field : publicFields){
            System.out.println("field name : "+field.getName());
        }
        try {
            Field ageField = programMonkey.getClass().getField("mAge");
            System.out.println("age is "+ageField.getInt(programMonkey));
            ageField.set(programMonkey,8);
            System.out.println("my age is :" + ageField.getInt(programMonkey));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
