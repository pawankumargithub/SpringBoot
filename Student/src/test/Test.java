package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.sname.SortByName;
import com.util.UtilApp;

import pawan.Student;
import pawan.api.SortingStudentIdComparator;

public class Test {

	public static void main(String[] args) {

		List<Student> studentlist=new ArrayList();
		studentlist.add(new Student(104,"pawan",25,"java"));
		studentlist.add(new Student(108,"subu",23,"python"));
		studentlist.add(new Student(105,"giri",24,".net"));
		studentlist.add(new Student(106,"buti",20,"sql"));
		
		Integer i1=new Integer(10);
		Integer i2=new Integer(20);
		Integer i3=new Integer(30);
		Integer i4=new Integer(40);
		
		List<Integer> integerlist=Arrays.asList(i1,i2,i3,i4);
		UtilApp.iterateAllType(integerlist);
		UtilApp.iterateAllType(studentlist);
		
		Collections.sort(studentlist, new SortingStudentIdComparator());
		
		
		  for (Student student : studentlist) {
			System.out.println(student);
		}
		  System.out.println("----------------------------");
		  Collections.sort(studentlist, new SortByName());

		  for (Student student : studentlist) {
			System.out.println(student);
		}
	}

}
