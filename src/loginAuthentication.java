
import java.util.HashMap;


public class loginAuthentication {

   HashMap userDictionary;

    public loginAuthentication( ) {
        userDictionary =new HashMap();
        userDictionary.put("shehab","1111");
        userDictionary.put("ramy","2222");
        userDictionary.put("fawzy","3333");
        
        
         
    }
   

   
    
    public boolean validate(String cardnum, String pass ){
        boolean checker =false;
        String fetched =(String) userDictionary.get(cardnum);
        if(fetched!=null){
            checker=fetched.equals(pass);    
        
        }
   return checker;
    }
    
}
