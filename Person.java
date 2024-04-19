
public class Person implements Comparable <Person> {
private int age,zipCode;
private String name = "",address = "";
private double Salary;

Person (){
		
}

Person(int age, String name,String address, int zipCode, double Salary ){
	setAge(age);
	setName(name);
	setAddress(address);
	setZipCode(zipCode);
	setSalary(Salary);
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getZipCode() {
	return zipCode;
}
public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public double getSalary() {
	return Salary;
}
public void setSalary(double salary) {
	Salary = salary;
}
@Override
public int compareTo(Person o) {
	// TODO Auto-generated method stub
	return 0;
}

}
