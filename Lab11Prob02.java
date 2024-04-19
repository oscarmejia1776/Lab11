//package lab11;

/**
 * File: Lab11Prob02.java
 * @author Dalton Hall, Oscar Mejia, Alejandro Giron
 * Created on: Apr 17, 2024
 * Modified on: Apr 18, 2024
 * Description:  Reading and writing a copy of people.dat.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob02 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Create array list
		ArrayList<Person> people = new ArrayList<>();

		try ( // Create an input stream for file people.dat
				DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				) {


			// Print info from the file
			while (true) {
				int age = input.readInt();
				String name = input.readUTF();
				String address = input.readUTF();
				int zipCode = input.readInt();
				double salary = input.readDouble();

				Person newPerson = new Person(age, name, address, zipCode, salary);
				people.add(newPerson);
			}
		} catch (EOFException ex) {


			// Sort array list
			Collections.sort(people);


			try ( 
					DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));
					) {

				for (Person person : people) {
					output.writeInt(person.getAge());
					output.writeUTF(person.getName());
					output.writeUTF(person.getAddress());
					output.writeInt(person.getZip());
					output.writeDouble(person.getSalary());
				}
			}
			catch (EOFException e) {
				System.out.println("Finished Copying");
			}

		}
	}}
