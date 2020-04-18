package pawan.api;

import java.util.Comparator;

import pawan.Student;

public class SortingStudentIdComparator implements Comparator<Student> {
public int compare(Student sidone, Student sidtwo) {
	
	if(sidone.getSid()>sidtwo.getSid()) {
		return 1;
	}
	if(sidone.getSid()<sidtwo.getSid()) {
		return -1;
	}
	return 0;
}
}
