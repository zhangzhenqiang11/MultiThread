package com.bill99.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestString   {
    
	public static void main(String[] args) throws Exception {         
//	    test01();     
//		test02();
//		test03();
//		test04();  
//		
//		test05();  
		
//		testReflection();
		
		
//		test07();
		
		System.out.println(10 << 1);
//		Map map = new HashMap();
		
	  }
	public static void test07() {
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
	}
	public static void testReflection() throws Exception {  
	      
	    test06();
	}
	public static void test06() throws NoSuchFieldException,
			IllegalAccessException {
		//创建字符串"Hello World"， 并赋给引用s  
	    String s = "Hello World";   
	      
	    System.out.println("s = " + s); //Hello World  
	      
	    //获取String类中的value字段  
	    Field valueFieldOfString = String.class.getDeclaredField("value");  
	      
	    //改变value属性的访问权限  
	    valueFieldOfString.setAccessible(true);  
	      
	    //获取s对象上的value属性的值  
	    char[] value = (char[]) valueFieldOfString.get(s);  
	      
	    //改变value所引用的数组中的第5个字符  
	    value[5] = '_';  
	      
	    System.out.println("s = " + s);  //Hello_World  
	}  

	public static void test05() {
		
		String a = "ABCAAc";  
		System.out.println("a = " + a);  
		a = a.replace('A', 'a');  
		System.out.println("a = " + a);
	}
	
	public static void test04() {
		String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("str1 and str2 are created by using string literal.");
        System.out.println("    str1 == str2 is " + (str1 == str2));
        System.out.println("    str1.equals(str2) is " + str1.equals(str2));  
        String str3 = new String("Hello");
        String str4 = new String("Hello");
        System.out.println("str3 and str4 are created by using new operator.");
        System.out.println("    str3 == str4 is " + (str3 == str4));
        System.out.println("    str3.equals(str4) is " + str3.equals(str4));  
        String str5 = "Hel" + "lo";
        String str6 = "He" + "llo";
        System.out.println("str5 and str6 are created by using string constant expression.");
        System.out.println("    str5 == str6 is " + (str5 == str6));
        System.out.println("    str5.equals(str6) is " + str5.equals(str6));  
        
        
        //在运行时通过连接计算出的字符串是新创建的，因此是不同的；
        String s = "lo";
        String str7 = "Hel" + s;
        String str8 = "He" + "llo";
        System.out.println("str7 is computed at runtime.");
        System.out.println("str8 is created by using string constant expression.");
        System.out.println("    str7 == str8 is " + (str7 == str8));
        System.out.println("    str7.equals(str8) is " + str7.equals(str8));
	}

	public static void test03() {
		String str1 = "abcef";
		String str3 = new String("abcef");
		String str4 = "abc"+"ef";
		
		System.out.println(str1 == str4);
		System.out.println(str1 == str3);
		System.out.println(str3 == str4);
	}

	public static void test02() {
		String str1 = new String("abc");
		System.out.println(str1.hashCode());
	    String str2 = "abc";
		System.out.println(str2.hashCode());
		System.out.println(str1==str2);  
		
		//查下hashcode 在一般的应用中你不需要了解hashcode的用法，但当你用到hashmap，hashset等集合类时要注意下hashcode。
	}

	public static void test01() {
		String str1 = "abc";         
	    String str2 = new String("abc").intern();         
	    String str3 = new String("abc").intern() ;         
	    String str4 = new String("abc") ;         

	    System.out.println(str1==str2);     
	    System.out.println(str3==str2);
	} 
}
