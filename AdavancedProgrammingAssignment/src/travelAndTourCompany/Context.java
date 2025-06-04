package travelAndTourCompany;

public class Context 
{
	private UserState state;
	
	public Context() {
		state = null;
	}

	public UserState getState() {
		return state;
	}

	public void setState(UserState state) {
		this.state = state;
	}
}
