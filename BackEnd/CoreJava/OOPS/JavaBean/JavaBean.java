import java.io.Serializable;

public class JavaBean implements Serializable {
	
	private int age;
	private String name;
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}

}
