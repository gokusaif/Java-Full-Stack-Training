package objectclass;

public class Employee1 {
	int id;
	String name;
	public Employee1(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Employee1 other = (Employee1) obj;
//		if (id != other.id)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
	public boolean equals(Object obj) {
		
		Employee1 e1= (Employee1) obj;
		
		if(e1.id==this.id && e1.name.equals(this.name))
		{
			return true;
		}
		else {
			return false;
		}
		
		
	}


	
	
	
	
}
