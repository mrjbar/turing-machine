import java.util.ArrayList;

public class Trigger {
	public int state;
	public ArrayList<Character> bit = new ArrayList<Character>();
	
	public int compareTo(Trigger other) {
		if(this.state != other.state) 
			return 0;
		
		for(int i=0; i< other.bit.size(); i++) {
			if(this.bit.get(i) != other.bit.get(i))
				return 0;
			}
				
		return 1;
	}
	
	@Override
	public int hashCode() {
		int hash = this.state;
		for(int i=0; i< bit.size(); i++)
			hash = hash + bit.get(i);
		return hash;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Trigger) 
		{
			Trigger other = (Trigger) o;
		    if(this.state != other.state)
		    	return false;
		    
		    for(int i=0; i< other.bit.size(); i++) {
				if(this.bit.get(i) != other.bit.get(i))
					return false;
				}
		    
		}
		return true;
	}
}
