package pojo;

public class UserInfo {
	private int id;
	private String name;
	private String pwd;
	private int age;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// return super.toString();
		return "UserInfo [id=" + id + ", name=" + name + ", pwd=" + pwd + ", age=" + age + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
