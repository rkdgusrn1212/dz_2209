package model.vo;

public class Member {
	private String id;
	private String pass;
	private String ename;
	private String email;
	private int grade; // high <- 1,2,3 <- low
	private int point;
	private int cash;
	private String genre;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String ename, int grade, int point, int cash) {
		this.ename = ename;
		this.grade = grade;
		this.point = point;
		this.cash = cash;
	}


	public Member(String id, String pass, String ename, String email, int grade, int point, int cash, String genre,
			String passQ, String passA) {
		super();
		this.id = id;
		this.pass = pass;
		this.ename = ename;
		this.email = email;
		this.grade = grade;
		this.point = point;
		this.cash = cash;
		this.genre = genre;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pass=" + pass + ", ename=" + ename + ", email=" + email + ", grade=" + grade
				+ ", point=" + point + ", cash=" + cash + ", genre=" + genre + "]";
	}


}
