package com.sname;

import java.util.Comparator;

import pawan.Student;

public class SortByName implements Comparator<Student> {

	@Override
	public int compare(Student name1, Student name2) {
		
		return name1.getSname().compareTo(name2.getSname());
	}

}
