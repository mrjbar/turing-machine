
public class TuringTester {

	public static void main(String[] args) {
		
		String tape = "1100000";
		/* Add tape into the constructor */
		TuringMachine tm1 = new TuringMachine(tape);

		// Add "f(n) = 2 * n" 
		tm1.addInstruction(0, "0", 5, "0", "0");
		tm1.addInstruction(0, "1", 1, "B", "1");
		tm1.addInstruction(1, "1", 1, "X", "1");
		tm1.addInstruction(1, "0", 2, "0", "-1");
		tm1.addInstruction(2, "X", 3, "1", "1");
		tm1.addInstruction(2, "1", 2, "1", "-1");
		tm1.addInstruction(2, "B", 4, "1", "1");
		tm1.addInstruction(3, "0", 2, "1", "-1");
		tm1.addInstruction(3, "1", 3, "1", "1");
		tm1.addInstruction(4, "1", 4, "1", "1");
		tm1.addInstruction(4, "0", 5, "1", "0");
		
		/* Final state */
		tm1.addFinalState(5);
		
		/* Error state */
		tm1.addErrorState(6);
		
		/* Run Turing Machine */
		System.out.println("f(n) = 2 * n");
		tm1.run();
		
		tape = "11011000";
		/* Add tape into the constructor */
		TuringMachine tm2 = new TuringMachine(tape);
		
		// TM Instructions
		tm2.addInstruction(0, "0", 4, "0", "1");
		tm2.addInstruction(0, "1", 1, "X", "1");
		tm2.addInstruction(1, "0", 2, "0", "1");
		tm2.addInstruction(1, "1", 1, "1", "1");
		tm2.addInstruction(1, "Y", 1, "Y", "1");
		tm2.addInstruction(2, "0", 6, "0", "0");
		tm2.addInstruction(2, "1", 3, "Y", "-1");
		tm2.addInstruction(2, "Y", 2, "Y", "1");
		tm2.addInstruction(3, "0", 3, "0", "-1");
		tm2.addInstruction(3, "1", 3, "1", "-1");
		tm2.addInstruction(3, "X", 0, "X", "1");
		tm2.addInstruction(3, "Y", 3, "Y", "-1");
		tm2.addInstruction(4, "Y", 4, "Y", "1");
		tm2.addInstruction(4, "1", 6, "1", "0");
		tm2.addInstruction(4, "0", 5, "0", "0");

		// Final state
		tm2.addFinalState(5);
		
		// Error state
		tm2.addErrorState(6);

		System.out.println("h(w) halts if w = 1^n01^n");
		/* Run Turing Machine */
		tm2.run();
		
		tape = "1111000";
		int auxilaryTapes = 2;
		TuringMachine tm3 = new TuringMachine(tape, auxilaryTapes);
		
		// TM Instructions
		tm3.addInstruction(0, "1,0,0", 1, "0,1,B", "1,1,1");
		tm3.addInstruction(1, "1,0,0", 1, "0,1,1", "1,1,1");
		tm3.addInstruction(1, "0,0,0", 2, "0,0,0", "-1,-1,-1");
		tm3.addInstruction(2, "0,1,1", 2, "0,1,1", "-1,-1,-1");
		tm3.addInstruction(2, "0,1,B", 3, "1,1,B", "1,0,1");
		tm3.addInstruction(3, "0,1,B", 3, "1,1,B", "1,0,1");
		tm3.addInstruction(3, "0,1,1", 3, "1,1,1", "1,0,1");
		tm3.addInstruction(3, "0,1,0", 4, "0,1,0", "0,0,-1");
		tm3.addInstruction(4, "0,1,1", 4, "0,1,1", "0,0,-1");
		tm3.addInstruction(4, "0,1,B", 3, "0,1,B", "0,1,0");
		tm3.addInstruction(3, "0,0,B", 5, "0,0,0", "0,0,0");

		// Final state
		tm3.addFinalState(5);
		
		// Error state
		tm3.addErrorState(6);
		
		System.out.println("g(n) = n^2");
		// Run Turing Machine
		tm3.run();
		System.out.println();
		/*Trigger t = new Trigger();
		t.state = 0;
		t.bit.add('1');
		
		Trigger s = new Trigger();
		s.state = 3;
		s.bit.add('1');
		
		Map<Trigger,Integer> program = new HashMap<Trigger,Integer>();
		program.put(t, 50);
		program.put(s, 14);
		

		Trigger r = new Trigger();
		r.state = 3;
		r.bit.add('1');

		
		System.out.println("t hashCode = " + t.hashCode());
		System.out.println("s hashCode = " + s.hashCode());
		System.out.println("r hashCode = " + r.hashCode());

		System.out.println("t == s ? " + t.equals(s));
		System.out.println("hashMap look up " + program.get(r));*/

	}
}
