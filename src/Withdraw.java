
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Withdraw {
    Scene scene; 
    SecondScene homeScreen ;
    Stage stage;
    Logic logic;

     

    public Withdraw(Stage stage) {
        this.stage = stage;
    }
    public void prepareScene(){ 
                
      TextField amount = new TextField();
      Text text1 = new Text("add amount to withdraw:"); 
      Button submit = new Button("Submit");
      Label label=new Label();
      Button back = new Button("back");
      GridPane gridPane=new GridPane();
      gridPane.setMinSize(250, 350);
            
      gridPane.setVgap(15); 
      gridPane.setHgap(15);       
      
      
      gridPane.setAlignment(Pos.CENTER);
     
      //Arranging all the nodes in the grid 
      gridPane.add(amount, 1, 2); 
      gridPane.add(text1, 1, 1); 
      gridPane.add(label, 1, 6); 
      gridPane.add(submit, 1, 3);
      gridPane.add(back, 2, 3);
      
      
      back.setOnAction((ActionEvent event) -> {
          stage.setScene(homeScreen.getScene());
      });
       submit.setOnAction((ActionEvent event) -> {
            double d = Double.parseDouble(amount.getText());
           
           if (logic.getBalance()<d)
               label.setText("There is no enough money");
           else {
           logic.debit(d);
           String x = Double.toString(logic.getBalance());
           label.setText(x);
           
           }
      });
        
        scene=new Scene(gridPane);
     }

    public Scene getScene() {
        return scene;
    }

    public void setHomeScreen(SecondScene homeScreen) {
        this.homeScreen = homeScreen;
    }

    void setAmount(Logic logic) {
this.logic=logic;
    }
}
