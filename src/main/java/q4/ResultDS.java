package q4;

public class ResultDS {

	String id;
	String first_name;
	String last_name;
	String salary;
	String bonus;
	public ResultDS(String id, String first_name, String last_name, String salary, String bonus) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.salary = salary;
		this.bonus = bonus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
	
	@Override
	public String toString() {
		return " " + id + ", " + first_name + ", " + last_name + ", " + salary + ", " + bonus + " ";
	}
	/*
	@Override
	public String toString() {
		return "ResultDS [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", salary=" + salary
				+ ", bonus=" + bonus + "]";
	}
	*/
}
