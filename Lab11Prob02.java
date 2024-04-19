import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob02 {

    public static void main(String[] args) {
        // ArrayList to store Person objects
        ArrayList<Person> people = new ArrayList<>();

        try {
            // Open input file
            DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));

            // Read data from input file and create Person objects
            while (true) {
                int age = input.readInt();
                String name = input.readUTF();
                String address = input.readUTF();
                int zipCode = input.readInt();
                double salary = input.readDouble();

                // Create Person object and add it to the ArrayList
                Person person = new Person(age, name,address, zipCode, salary);
                people.add(person);
            }
        } catch (EOFException e) {
            System.out.println("End of file reached.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Sort ArrayList by salary in descending order
        Collections.sort(people);

        // Write sorted data to a new binary file
        try {
            // Open output file
            DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-salary-sorted.dat"));

            // Write sorted data to the output file
            for (Person person : people) {
                output.writeInt(person.getAge());
                output.writeUTF(person.getName());
                output.writeUTF(person.getAddress());
                output.writeInt(person.getZipCode());
                output.writeDouble(person.getSalary());
            }

            // Close output stream
            output.close();

            System.out.println("Sorted data written to people-salary-sorted.dat.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
