package ImageHoster.service;

import ImageHoster.model.User;
import ImageHoster.repository.UserRepository;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Call the registerUser() method in the UserRepository class to persist the user record in the database
    public void registerUser(User newUser) {
        userRepository.registerUser(newUser);
    }

    //Since we did not have any user in the database, therefore the user with username 'upgrad' and password 'password' was hard-coded
    //This method returned true if the username was 'upgrad' and password is 'password'
    //But now let us change the implementation of this method
    //This method receives the User type object
    //Calls the checkUser() method in the Repository passing the username and password which checks the username and password in the database
    //The Repository returns User type object if user with entered username and password exists in the database
    //Else returns null
    public User login(User user) {
        User existingUser = userRepository.checkUser(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return existingUser;
        } else {
            return null;
        }
    }
    String specialCharacters=" !#$%&'()*+,-./:;<=>?@[]^_`{|}~";
   public boolean passwordCheck(User user){
	   boolean alpha = false;
       boolean isDigit = false;
       boolean spChar = false;
	   System.out.println("Checking strength of password");
	   for (int i = 0; i < user.getPassword().length(); i++)
       {
        if (Character.isAlphabetic(user.getPassword().charAt(i)))
        {
        	alpha = true;
        }
       }
	   for (int i = 0; i < user.getPassword().length(); i++)
			   {
        if (Character.isDigit(user.getPassword().charAt(i)))
        {
            isDigit = true;
        }
			   }
	   Pattern regex = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]");
	   if (regex.matcher(user.getPassword()).find()) {
		   spChar = true;
	   } 
	   /*for (int i = 0; i < user.getPassword().length() - 1; i++){
        if (specialCharacters.contains(user.getPassword().toString()))
        {
            spChar = true;
        }}*/
       	
  System.out.println(alpha + " " + isDigit +" "+ spChar);       
return (alpha && isDigit && spChar);
	   
   }
}
