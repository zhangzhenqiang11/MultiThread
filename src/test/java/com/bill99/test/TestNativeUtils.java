package com.bill99.test;

public class TestNativeUtils {
	public static void main(String args[]) {
		 
		Object o = new Object();
		 
		long nptr = NativeUtils.getNativePointer(o);
		 
		long hash = o.hashCode();
		 
		System.out.println(String.format("hash: %x, nptr: %x", hash, nptr));
		 
		}
}
