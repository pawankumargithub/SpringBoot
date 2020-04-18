package com.util;

import java.util.List;

public class UtilApp {

	public  static <T> void iterateAllType(List<T> obj) {
		for (T t : obj) {
			System.out.println(t);
		}
	}
}
