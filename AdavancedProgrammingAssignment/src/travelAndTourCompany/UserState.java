package travelAndTourCompany;

public interface UserState 
{
	void setContext(Context context);
	void login();
	void check(String usn, String pw);
	void showOperations();
}
