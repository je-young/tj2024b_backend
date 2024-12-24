package day12.boardprogram7;

public class MemberDto { // class s
	
	// 1.멤버변수
	private String id;
	private String pwd;
	private String name;
	
	// 2.생성자
	public MemberDto() { }

	public MemberDto(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}

	// 3.메소드 : getter, setter
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
	
} // class end