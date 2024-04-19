package lab11;

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
import java.io.Serializable;

public class Lab11Prob01 implements Serializable {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try ( // Create an input stream for file people.dat
				DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));
				) {

			// Make copy of file.
			while (input.read() != - 1) {
				output.writeInt(input.readInt());
				output.writeUTF(input.readUTF());
				output.writeUTF(input.readUTF());
				output.writeInt(input.readInt());
				output.writeDouble(input.readDouble());
			}

		} catch (EOFException ex) {
			//System.out.println("Reached end of file");
		}

		try ( // Create an input  people.dat
				DataInputStream newInput = new DataInputStream(new FileInputStream("src/people-copy.dat"));
				) {
			// Print out results from copied file
			while (newInput.read() != - 1)
				System.out.printf("%d %s %s %d %.2f\n", newInput.readInt(), newInput.readUTF(), newInput.readUTF(), newInput.readInt(), newInput.readDouble());
		}
		catch (EOFException ex) {
			//System.out.println("Finished Copying");
		}
	}}
