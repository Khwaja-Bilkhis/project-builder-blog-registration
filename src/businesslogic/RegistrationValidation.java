package businesslogic;



public class RegistrationValidation{
	public boolean checkUserDetails(String email, String password, String confirmPassword) {
	
		return validPassword(password, confirmPassword)&&validEmail(email);
	
	}
	private boolean validPassword(String password, String confirmPassword) {
		boolean flag=true;
		if(password==null) flag=false;
		else if(!password.equals(confirmPassword)) flag=false;
		else if(!(password.length()>=8&& password.length()<=20)) flag=false;
		else if(!password.matches("(.)*[A-Z](.)*")) {
			flag=false;
		}
		else if(!password.matches("(.)*[a-z](.)*")) {
			flag=false;
		}
		else if(!password.matches("(.)*[0-9](.)*")) {
			flag=false;
		}
		
		
		return flag;
	}
	private boolean validEmail(String email) {
		boolean flag=true;
		if(email==null) flag=false;
		else if(email.equals("")) flag=false;
		else if(!(email.contains("@")&&(email.contains(".")))) {
			flag=false;
			//System.out.println("@.");
		}
		else {
		
			for(int i=0;i<email.length();i++) {
				char c=email.charAt(i);
				if(!(Character.isAlphabetic(c)||Character.isDigit(c)||c=='_'||c=='@'||c=='.')) {
					flag=false;
					//System.out.println(c);
				}
			}
			
			
		}
		if(!flag) System.out.println("email faulty");
		return flag;
	}
}