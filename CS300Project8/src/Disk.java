//Title:  Monthly Account Book        (descriptive title of the program making use of this file)
//Files:  SwimSim.jarS         (a list of all source files used by that program)
//Course:CS300, fall, 2017
//
//Author:Xiao(Griff) Zhang
//Email: xzhang953@wisc.edu
//Lecturer's Name: Gary Dahl
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//__X_ Write-up states that pair programming is allowed for this assignment.
//__X_ We have both read and understand the course Pair Programming Policy.
//__X_ We have registered our team prior to the team registration deadline.
public class Disk implements Comparable<Disk> {

	private int size; // 1-9: restricts disk movement, and used for drawing
	 
	/**
	 * Constructs a new immutable disk object with the specified size.
	 * @param size is used for drawing and comparing against other disks.
	 * @throws IllegalArgumentException when size is not between 1 and 9.
	 */
	public Disk(int size) throws IllegalArgumentException{ 
		if (size<1 || size>9) {
			throw new IllegalArgumentException();
		}
		this.size = size;
	}
	 
	/**
	 * Compares one disk to another to determine which is larger, and therefore
	 * which can be moved on top of the other.
	 * @param other is a reference to the disk we are comparing this one to.
	 * @return a positive number when this.size > other.size,
	 *         a negative number when this.size < other.size, or
	 *         zero when this.size == other.size, or other is null.
	 */
	@Override
	public int compareTo(Disk other) { 
		return this.size-other.size; 
	}
	 
	/**
	 * The string representation of this disk object includes its integer size
	 * surrounded by size-1 equals characters (=) on each side, and enclosed 
	 * within angle brackets (<>).  For example:
	 *     size 1: "<1>"
	 *     size 2: "<=2=>"
	 *     size 3: "<==3==>"
	 * @return the string representation of this disk object based on its size.
	 */
	@Override
	public String toString() {
		String string="<";
		for (int i = 0; i < this.size-1; i++) {
			string = string+"=";
		}
		string +=size+"";
		for (int i = 0; i < this.size-1; i++) {
			string = string + "=";
		}
		return string+">"; 
	}
	
}
