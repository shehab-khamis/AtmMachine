import com.sun.javafx.charts.ChartLayoutAnimator;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import javafx.application.Application;  
import javafx.stage.Stage; 

public class ATM extends Application { 
      public static void main(String args[]){ 
      launch(args); 
   }
    
   @Override
   public void start(Stage stage) {
   
       LoginForm LoginForm=new LoginForm(stage);
       LoginForm.prepareScene();
       SecondScene homeScreen= new SecondScene(stage);
       homeScreen.prepareScene();
       LoginForm.setHomeScreen(homeScreen);
       homeScreen.setLoginform(LoginForm);
       Withdraw withdraw=new Withdraw(stage);
       withdraw.setHomeScreen(homeScreen);
       withdraw.prepareScene();
       Deposit deposit =new Deposit(stage);
       deposit.setHomeScreen(homeScreen);
       homeScreen.setWithdraw(withdraw);
       deposit.prepareScene();
       homeScreen.setDeposit(deposit);
       
       Balance balance=new Balance(stage);
       balance.setHomeScreen(homeScreen);
       balance.prepareScene(); 
       homeScreen.setBalance(balance);
      //Setting title to the Stage 
      stage.setTitle("ATM"); 
         
      //Adding scene to the stage 
         stage.setScene(LoginForm.getScene());
         
      //Displaying the contents of the stage 
      stage.show(); 
   
   
   }
}
