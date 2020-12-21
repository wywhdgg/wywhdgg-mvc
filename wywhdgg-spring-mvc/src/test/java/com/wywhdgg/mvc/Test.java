package com.wywhdgg.mvc;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public Test(String a, int b, char... c) {
		System.out.println(a + b + c);
	}

	public static void main(String[] args) throws Exception {
		Class<?> c = Test.class;
//		Constructor ct = c.getConstructor(new Class<?>[] { String.class, int.class, char[].class });
//
//		System.out.println(ct);
//
//		Object instance = ct.newInstance(new Object[] { "aaaa", 4, new char[] { 'c' } });
		List<String> list = new ArrayList<>();
		String[] imageList = new String[list.size()];
		if(null!=imageList&&imageList.length>0){
			System.out.println("有数据");
		}
		System.out.println("无数据");
	}
}
