package model.vo;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private int point;
	private int cash;
	private int interestCategery;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	//selectPayBook
	public Member(String id, int point, int cash) {
        this.name = id;
        this.point = point;
        this.cash = cash;
  	}	//selectPayBook


	public Member(String id, String pass, String ename, String email, int point, int cash, int interestCategory,
			String passQ, String passA) {
		super();
		this.id = id;
		this.pwd = pass;
		this.name = ename;
		this.email = email;
		this.point = point;
		this.cash = cash;
		this.interestCategery = interestCategory;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getInterestCategory() {
		return interestCategery;
	}

	public void setInterestCategory(int interestCategory) {
		this.interestCategery = interestCategory;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email +", interest_category=" + interestCategery
				+ ", point=" + point + ", cash=" + cash  + "]";
	}


}
