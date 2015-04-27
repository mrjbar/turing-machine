import java.util.*;

public class TuringMachine {
	
	private ArrayList<Tape> tapeDeck;
	private Tape tape;
	private Map<Trigger,Action> program = new HashMap<Trigger,Action>();
	private Set<Integer> finalStates = new HashSet<Integer>(); // run halts when state is a member
	private int state; // the current state
	private int errorState;
	
	public TuringMachine(String defaultTape)
	{
		tapeDeck = new ArrayList<Tape>();
		tape = new Tape(defaultTape);
		tapeDeck.add(tape);
	}
	
	public TuringMachine(String defaultTape, int extraTapes)
	{
		tapeDeck = new ArrayList<Tape>();
		tape = new Tape(defaultTape);
		tapeDeck.add(tape);
		for(int i=0; i<extraTapes; i++)
			tapeDeck.add(new Tape("0000"));
	}
	
	/**
	 * Add a transition to the transition table(HashMap) of the finite state machine
	 * @param token - transition input
	 * @param state - current state
	 * @param newState - new state
	 */
	public void addInstruction(int current_state, String current_bits, int new_state, String new_bits, String directions)
	{
		String[] currentBits;
		String[] newBits;
		String[] direction;
		
		Trigger currentState = new Trigger();
		currentState.state = current_state;
		
		Action newState = new Action();
		newState.state = new_state;
		
		currentBits = current_bits.split(",");
		newBits = new_bits.split(",");
		direction = directions.split(",");

		for(int i=0; i<currentBits.length; i++)
		{
			currentState.bit.add(currentBits[i].charAt(0));
			newState.bit.add(newBits[i].charAt(0));
			newState.direction.add(Integer.parseInt(direction[i]));
		}
		
		program.put(currentState, newState);
	}
	
   /**
	 * Add one or more final states to the finite state machine
	 * @param finalState
	 */
	public void addFinalState(int finalState)
	{
		finalStates.add(finalState);
	}
	
	/**
	 * Add one or more final states to the finite state machine
	 * @param finalState
	 */
	public void addErrorState(int errorState)
	{
		this.errorState = errorState;
	}
		
   public void run() 
   {
	   		// Set start state
			state = 0;
			
			// Set start bit
			ArrayList<Character> currentBits = new ArrayList<Character>();
			
			// Iterate through each tape in the tapeDeck
			// Add the first bit in each tape into currentBits
			for(Tape t : tapeDeck) {
				currentBits.add(t.read());
			}
			
			// Create a Trigger with the starting state
			// and the current bits
			Trigger cs = new Trigger();
			cs.state = state;
			cs.bit = currentBits;

			// Setup directions
			ArrayList<Integer> directions = new ArrayList<Integer>();
			Action ns = new Action();
			
			boolean done = false;
			// Iterate through the tokens
			while(!done)
			{
				String result = String.format("state = %s, %s", state, tape);
				System.out.println(result);
				
				if(state == errorState) { 	
					System.out.println("Error");
					return;
				}
				
				// Look up the current state in the program HashMap
				// Retrieve the new state from the HashMap
				ns = program.get(cs);
				
				// UPDATE THE  STATE OF THE TURING MACHINE

				// Update the current state
				state = ns.state;
				
				// Update the current set of bits
				currentBits = ns.bit;
				
				directions = ns.direction;
				
				// Update state
				cs.state = state;
				
				// UPDATE THE TAPES 
				for(int i=0; i<tapeDeck.size(); i++)
				{
					Tape currentTape = tapeDeck.get(i);
					currentTape.write(currentBits.get(i));
					currentTape.moveHead(directions.get(i));
					cs.bit.set(i, currentTape.read());
				}
				
				for(Integer finalState: finalStates)
				{
					if(state == finalState)
					{
						result = String.format("state = %s, %s", state, tape);
						System.out.println(result);
						System.out.println("Halted\n");
						done = true;
					}
				}
			} 
   }
}