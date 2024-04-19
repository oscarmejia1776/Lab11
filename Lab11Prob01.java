/**
 * File: Lab11Prob01.java
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
import java.io.ObjectInputStream;

public class Lab11Prob01 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try ( // Create an input stream for file people.dat
				DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				) {

			// Print info from the file
			while (true)
				System.out.printf("%d %s %s %d %.2f\n", input.readInt(), input.readUTF(), input.readUTF(), input.readInt(), input.readDouble());
		} catch (EOFException ex) {
			//System.out.println("Reached end of file");
		}
		
		try ( // Create an input and output stream for file people.dat
				DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));
			) {
			// Make copy of file.
			while (true) {
				output.writeInt(input.readInt());
				output.writeUTF(input.readUTF());
				output.writeUTF(input.readUTF());
				output.writeInt(input.readInt());
				output.writeDouble(input.readDouble());
			}
			}
			catch (EOFException ex) {
				//System.out.println("Finished Copying");
			}
	

}}
