package elasticSearchUpdated.Model;

public class Employee {
	public String name;
	public String id;
	public String age;

	public Employee(String name, String id, String age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", age=" + age + "]";
	}

}
