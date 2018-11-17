package q4;

public class Salary {
	
	String id;
	String salary;
	String bonus;
	
	public Salary(String id, String salary, String bonus) {
		this.id = id;
		this.salary = salary;
		this.bonus = bonus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	
	
}
