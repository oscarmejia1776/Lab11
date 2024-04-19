import java.text.DecimalFormat;

public class Person implements Comparable<Person>{
	
	private int age = 0;
	private String name = null;
	private String address = null;
	private int zip = 0;
	private double salary = 0;
	
	public Person(){
		age = 50;
		name = "John Smith";
		address = "201 Oak Street";
		zip = 20123;
		salary = 100000.00;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int newAge) {
		age = newAge;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		name = newName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String newAddress) {
		address = newAddress;
	}
	
	public int getZip() {
		return zip;
	}
	public void setZip(int newZip) {
		zip = newZip;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double newSalary) {
		salary = newSalary;
	}
	
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("#,###.00");
		return String.format("%d %s %s %d %.2f", age, name, address, zip, formatter.format(salary));
	}
	
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
