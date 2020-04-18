package pawan;

public class Student {

	private int sid;
	private String sname;
	private int sage;
	private String course;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", course=" + course + "]";
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Student() {
		super();
	}
	public Student(int sid, String sname, int sage, String course) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.course = course;
	}
}
