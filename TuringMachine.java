import java.util.*;

public class TuringMachine {
	
	private ArrayList<ArrayList> tapeDeck;
	private ArrayList<String> tape = new ArrayList<String>();
	private Map<String,String> program = new HashMap<String,String>();
	private Set<String> finalStates = new HashSet<String>(); // run halts when state is a member
	private String state; // the current state
	private int[] indices; // the current position of the R/W head
	private int index = 0; // the current position of the R/W head
	private String errorState;
	
	public TuringMachine()
	{
		indices = new int[1];
		tapeDeck = new ArrayList<ArrayList>();
		tapeDeck.add(tape);
	}
	
	public TuringMachine(int numOfTapes)
	{
		int size = 100;
		indices = new int[numOfTapes + 1];
		tapeDeck = new ArrayList<ArrayList>();
		tapeDeck.add(tape);
		for(int i=0; i<numOfTapes; i++)
		{
			ArrayList<String> auxiliaryTape = new ArrayList<String>();
			for(int j=0; j<size; j++) auxiliaryTape.add("0");
			tapeDeck.add(auxiliaryTape);
		}
	}

	/**
	 * Add a transition to the transition table(HashMap) of the finite state machine
	 * @param t - tape
	 */
	public void addTape(String t)
	{
		for(int i=0; i<t.length(); i++)
		{
			tape.add(String.format("%s",t.charAt(i)));
		}
	}
	
	/**
	 * Add a transition to the transition table(HashMap) of the finite state machine
	 * @param token - transition input
	 * @param state - current state
	 * @param newState - new state
	 */
	public void addProgram(int current_tape, char current_state, char current_bit, int new_tape, char new_state, char new_bit, int direction)
	{
		String cs = String.format("%s%s%s", current_tape, current_state, current_bit);
		String ns = String.format("%s%s%s%s", new_tape, new_state, new_bit, direction);
		program.put(cs, ns);
	}
	
   /**
	 * Add one or more final states to the finite state machine
	 * @param finalState
	 */
	public void addFinalState(String finalState)
	{
		finalStates.add(finalState);
	}
	
	/**
	 * Add one or more final states to the finite state machine
	 * @param finalState
	 */
	public void addErrorState(String errorState)
	{
		this.errorState = errorState;
	}
		
   public void run() 
   {
	// Set the current state the startState
	   		int direction;
			state = "0";
			String currentBit;
			String newState = "";
			String cs = "";
			boolean done = false;
			int tapeIndex = 0;
			ArrayList<String> currentTape = tapeDeck.get(tapeIndex);
			
			// Iterate through the tokens
			while(!done)
			{
				String result = String.format("tape = %s, state = %s, index = %s, tape = %s", tapeIndex, state, indices[0], tape);
				System.out.println(result);
				
				if(state.equals(errorState)) { 	
					System.out.println("Error");
					return;
				}
				
				if(indices[tapeIndex] < 0 || indices[tapeIndex] > currentTape.size()) {
					System.out.println("Halted");
					return;
				}
				
				currentBit = currentTape.get(indices[tapeIndex]);
				cs = String.format("%s%s%s", tapeIndex, state, currentBit);
				
				// Get new states
				newState = program.get(cs);
				
				// Get new tape index
				tapeIndex = Integer.parseInt(newState.substring(0,1));
				
				// Get new state
				state = newState.substring(1,2);
				
				// Get new bit
				currentBit = newState.substring(2, 3);
				
				// Get new direction
				// Fix this later
				direction = Character.getNumericValue(newState.charAt(3));
				
				// Change tape
				currentTape = tapeDeck.get(tapeIndex);
				
				// Change the the value on the tape at the specified index
				currentTape.set(indices[tapeIndex], currentBit);
				indices[tapeIndex] = indices[tapeIndex] + direction;
				
				for(String finalState: finalStates)
				{
					if(state.equals(finalState))
					{
						result = String.format("tape = %s, state = %s, index = %s, tape = %s", tapeIndex, state, index, tape);
						System.out.println(result);
						System.out.println("Halted");
						done = true;
					}
				}
			} 
   }
}