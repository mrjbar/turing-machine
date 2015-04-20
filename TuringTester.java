
public class TuringTester {

	public static void main(String[] args) {
		TuringMachine tm = new TuringMachine(2);
		
		/*tm.addProgram('0', '1', '0', '1', 1);
		tm.addProgram('0', '0', '1', '0', 1);
		tm.addProgram('1', '0', '3', '0', 0);
		tm.addProgram('1', '1', '2', '0', -1);
		tm.addProgram('2', '0', '0', '1', 1);
		tm.addProgram('2', '1', '4', '1', 0);
		
		// Final state
		tm.addFinalState(3);
		
		// Error state
		tm.addErrorState('4');
		
		// Add Tape
		tm.addTape("1111101111110");*/
		
		// TM Instructions
		/*tm.addProgram('0', '0', '5', '0', 0);
		tm.addProgram('0', '1', '1', 'B', 1);
		tm.addProgram('1', '1', '1', 'X', 1);
		tm.addProgram('1', '0', '2', '0', -1);
		tm.addProgram('2', 'X', '3', '1', 1);
		tm.addProgram('2', '1', '2', '1', -1);
		tm.addProgram('2', 'B', '4', '1', 1);
		tm.addProgram('3', '0', '2', '1', -1);
		tm.addProgram('3', '1', '3', '1', 1);
		tm.addProgram('4', '1', '4', '1', 1);
		tm.addProgram('4', '0', '5', '1', 0);

		
		// Final state
		tm.addFinalState("5");
		
		// Error state
		tm.addErrorState("6");
		
		// Add Tape
		tm.addTape("0000000");
		
		// TM Instructions
		tm.addProgram(0, '0', '0', 0, '4', '0', 1);
		tm.addProgram(0, '0', '1', 0, '1', 'X', 1);
		tm.addProgram(0, '1', '0', 0, '2', '0', 1);
		tm.addProgram(0, '1', '1', 0, '1', '1', 1);
		tm.addProgram(0, '1', 'Y', 0, '1', 'Y', 1);
		tm.addProgram(0, '2', '0', 0, '6', '0', 0);
		tm.addProgram(0, '2', '1', 0, '3', 'Y', -1);
		tm.addProgram(0, '2', 'Y', 0, '2', 'Y', 1);
		tm.addProgram(0, '3', '0', 0, '3', '0', -1);
		tm.addProgram(0, '3', '1', 0, '3', '1', -1);
		tm.addProgram(0, '3', 'X', 0, '0', 'X', 1);
		tm.addProgram(0, '3', 'Y', 0, '3', 'Y', -1);
		tm.addProgram(0, '4', 'Y', 0, '4', 'Y', 1);
		tm.addProgram(0, '4', '1', 0, '6', '1', 0);
		tm.addProgram(0, '4', '0', 0, '5', '0', 0);

		// Final state
		tm.addFinalState("5");
		
		// Error state
		tm.addErrorState("6");
		
		// Add Tape
		tm.addTape("1101100000");
		*
		*
		*
		*/
		
		// TM Instructions
		tm.addProgram(0, '0', '1', 1, '0', '1', 1);
		tm.addProgram(1, '0', '0', 0, '0', '0', 1);

		

		// Final state
		tm.addFinalState("5");
		
		// Error state
		tm.addErrorState("6");
		
		// Add Tape
		tm.addTape("111100000");
		
		// Run Turing Machine
		tm.run();
		//System.out.println(Character.getNumericValue("-3".charAt(0)));
	}
}
