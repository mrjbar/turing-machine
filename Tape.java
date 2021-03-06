import java.util.*;

public class Tape {
	   private static int BLOCK_SIZE = 100;
	   private ArrayList<Character> cells;
	   private int head; 
	   
	   public Tape(String input) {
	      cells = new ArrayList<Character>();
	      growTape();
	      for(int i = 0; i < input.length(); i++) {
	         cells.set(i,  input.charAt(i));
	      }
	      head = 0;
	   }
	   
	   private void growTape() {
	      int excess = head - cells.size();
	      if (0 <= excess) {
	         for(int i = 0; i < BLOCK_SIZE + excess; i++) {
	            cells.add('0');
	         }
	      }
	   }
	   
	   public char read() { return cells.get(head); }
	   public void write(char c) { cells.set(head, c); }
	   public String toString() {
		   String result = String.format("head = %s, tape = %s", head, cells.toString());
	      return result;
	   }

	   public void moveHead(int steps) {
	      head += steps;
	      if (head < 0) head = 0;
	      growTape();
	   }
}
