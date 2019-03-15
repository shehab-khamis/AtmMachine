import com.sun.javafx.charts.ChartLayoutAnimator;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import javafx.application.Application; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage; 

public class LoginForm { 
    loginAuthentication authentication;
    Scene scene;
    Stage stage;
    SecondScene HomeScreen;

    public LoginForm(Stage stage) {
        this.stage = stage;
    }
    

   public void prepareScene() { 
   authentication=new loginAuthentication();

      //creating label email 
      Text usernametext = new Text("Username:");       
      Text passwordtext = new Text("Passcode:");       
      
     
	  
      //Creating Text Filed for cardnum        
      TextField Username = new TextField();       
       PasswordField PassWord = new PasswordField();      
      Label validationLabel=new Label();
      Button enter = new Button("enter"); 
        
      GridPane grid = new GridPane();    
       scene = new Scene(grid);
             grid.setMinSize(350, 250);  
      grid.setVgap(15); 
      grid.setHgap(15);       
      
      grid.setAlignment(Pos.CENTER); 
       
      
      grid.add(usernametext, 0, 2); 
      grid.add(passwordtext, 0, 4); 
      grid.add(Username, 1, 2);
      grid.add(PassWord, 1, 4);
      grid.add(enter, 1, 5); 
      grid.add(validationLabel, 1, 6); 
       
      enter.setOnAction((ActionEvent event) -> {
          String UserName = Username.getText();
          String Code = PassWord.getText();
         boolean valid= authentication.validate(UserName,Code);
         if (valid){
          validationLabel.setText("welcome "+Code);
          stage.setScene(HomeScreen.getScene());
         }
         else
          validationLabel.setText("Wrong username or Passcode");
      }
     );
              }

    public Scene getScene() {
        return scene;
    }

    public void setHomeScreen(SecondScene HomeScreen) {
        this.HomeScreen = HomeScreen;
    }
            

  
   }
     