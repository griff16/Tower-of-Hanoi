import java.awt.TexturePaint;
import java.security.spec.DSAGenParameterSpec;
import java.util.NoSuchElementException;

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
public class Rod implements Comparable<Rod>{
	private int numberOfDisks; // tracks the number of disks on this rod
	private Disk[] disks;      // stores references to the disks on this rod
	                           // index 0: bottom, index discNumber-1: top
	 
	/**
	 * Constructs a new rod that can hold a maximum of maxHeight Disks. The
	 * numberOfDisks new Disks will be created with sizes between 1 and 
	 * numberOfDisks (inclusive), and arranged from largest (on bottom) to the
	 * smallest (on top) on this Rod.
	 * @param maxHeight is the capacity or max number of Disks a rod can hold.
	 * @param numberOfDiscs is the initial number of Disks created on this rod.
	 */
	public Rod(int maxHeight, int numberOfDisks) { 
		this.disks = new Disk[maxHeight];
		this.numberOfDisks = numberOfDisks;
		int count = 0;
		for (int i = numberOfDisks; i >=1; i--) {
            disks[count] = new Disk(i); 
            count++;
		}
	}
	 
	/**
	 * Adds one new Disk to the top of this rod.
	 * @param disk is a reference to the Disk being added to this rod.
	 * @throws IllegalStateException when this rod is already full to capacity.
	 */
	public void push(Disk disk) throws IllegalStateException { 
		if (disks.length == numberOfDisks) {
			throw new IllegalStateException();
		}
		disks[numberOfDisks] = disk;
		numberOfDisks++;
	}
	 
	/**
	 * Removes and returns one Disk from the top of this rod.
	 * @return a reference to the Disk that is being removed.
	 * @throws NoSuchElementException when this rod is empty.
	 */
	public Disk pop() throws NoSuchElementException { 
		if (numberOfDisks ==0) {
			throw new NoSuchElementException();
		}
		Disk disk = disks[numberOfDisks-1];
		disks[numberOfDisks-1]=null;
		numberOfDisks--;
		return disk; 
	}
	 
	/**
	 * Returns (without removing) one Disk from the top of this rod.
	 * @return a reference to the Disk that is being returned.
	 * @throws NoSuchElementException when this rod is empty.
	 */
	public Disk peek() throws NoSuchElementException { 
		if (numberOfDisks==0) {
			throw new NoSuchElementException();
		}
		return disks[numberOfDisks-1]; 
	}
	 
	/**
	 * Indicates whether this rod is currently holding zero Disks.
	 * @return true when there are no Disks on this rod.
	 */
	public boolean isEmpty() { 
		if (numberOfDisks==0) {
			return true;
		}
		return false; 
	}
	 
	/**
	 * Indicates whether this rod is currently full to its capacity with disks.
	 * @return true when the number of Disks on this rod equals its max height.
	 */
	public boolean isFull() { 
		if (numberOfDisks==disks.length) return true;
		return false; 
	} 
	 
	/**
	 * Compares one rod to another to determine whether it's legal to move the
	 * top disk from this rod onto the other.
	 * @param other is the destination rod we are considering moving a disk to.
	 * @return +1 when moving a disk from this rod to other is legal,
	 *         -1 when moving a disk from this rod to other is illegal,
	 *         or 0 when this rod is empty and there are no disks to move.
	 */
	@Override
	public int compareTo(Rod other) { 
	    if (numberOfDisks==0) {
	        return 0;
	    }
	    if (other.isEmpty()) {
            return 1;
        }
	    int compare = disks[numberOfDisks-1].compareTo(other.peek());		
	    if (compare >0 ) {
	        return -1;
	    }else if (compare <=0) {
            return 1;
        }
	    return 1;
	}

	/**
	 * The string representation of this rod includes its max height number
	 * of rows separated by and ending with newline characters (\n).  Rows 
	 * occupied by a disk will include that disk's string representation, and 
	 * other rows instead contain a single vertical bar character (|).  All 
	 * rows are centered by surrounding both sides with spaces until they are 
	 * each capacity*2+1 characters wide.  Example of 5 capacity rod w\3 disks:
	 * "     |     \n" +
	 * "     |     \n" +
	 * "   <=2=>   \n" +
	 * "  <==3==>  \n" +
	 * "<====5====>\n"
	 * @return the string representation of this rod based on its contents.
	 */
	@Override
	public String toString() { 
		String string ="";
		int temp = numberOfDisks;
		for (int i = disks.length-1; i >=0; i--) {
			if (i+1<=numberOfDisks) {// when the row has a disk
			    int count = ((disks.length*2+1)-disks[temp-1].toString().length())/2;
			    for (int j = 0; j < count; j++) {
                    string +=" ";
                }
			    string += disks[temp-1].toString();
			    for (int j = 0; j < count; j++) {
                    string +=" ";
                }
			    temp--;
				string += "\n";
			} else {// when the row does not have a disk
				for (int j = 0; j < disks.length*2+1; j++) {
					if (j==disks.length) {
						string +="|"; 
					} else {
						string += " ";
					}
				}
				string +="\n";
			}
		}
		return string; 
	}

}
