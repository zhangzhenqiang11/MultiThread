package com.bill99.test;

import java.util.ArrayList;

/**
 * 构造器Constructor是否可被override
 * @author Administrator
 *
 */
public class TestSub extends TetSuper {

	@Override
	public void TestSuper(){
		System.out.println("sub");
	}
	
	public static void main(String[] args) {
//		test01();
		
		ArrayList a = new ArrayList();
		ArrayList b = new ArrayList();
//		a.add(1);
//		b.add(1);
		System.out.println(a.equals(b));
		System.out.println("###"+(a==b));
		
		Object o = new Object();
		Object o2 = new Object();
		System.out.println(o.equals(o2));
//		sub.TestSuper();
		
		
		String as = new String("aa");
		String as2 = new String("aa");
		System.out.println(as.equals(as2));
		
		
		StringBuffer buf = new StringBuffer("aa");
		StringBuffer buf2 = new StringBuffer("aa");
		System.out.println(buf.equals(buf2));
		
		StringBuilder builder = new StringBuilder("aa");
		StringBuilder builder2 = new StringBuilder("aa");
		System.out.println(builder.equals(builder2));
		
		
		Double d = 2D;
		Double d2 = 2D;
		System.out.println(d.equals(d2));
		
		Integer in = 3;
		Integer in2 = 3;
		System.out.println(in.equals(in2));
		
		
		String ss = "de";
		String str = "abcde";
		String str2 = new String("abcde");
		String str5 = new String("abcde");
		String str3 = "abc"+ss;
		String str4 = "abc"+"de";
		
		System.out.println(str == str2);//false
		System.out.println(str == str3);//false
		System.out.println(str3 == str4);//false
		System.out.println(str == str4);//true
		
		
		System.out.println("hashcode "+str2.hashCode());
		System.out.println("hashcode "+str5.hashCode());
		
//		test05();
		
	}

	public static void test01() {
		TestSub  sub = new TestSub();
		TestSub  sub2 = new TestSub();
		
		System.out.println(sub.hashCode());
		System.out.println(sub2.hashCode());
		System.out.println(sub.equals(sub2));
	}

	public static void test05() {
		String arr1[] =new String[3];
		String arr2[] =new String[3];
		init(  arr1);
		init(  arr2);
//		arr1 = arr2;
		System.out.println(arr1.equals(arr2));
	}

	private static void init(String[] arr1) {
		String [] arr = {"A","B","C"};
		for(int i=0; i<arr1.length;i++){
			arr1[i] = arr[i];
		}
	}
	
	
	
}
