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


public class Deposit {
    Scene scene; 
    SecondScene homeScreen ;
    Stage stage;
         Logic amounte ;

     

    public Deposit(Stage stage) {
        this.stage = stage;
    }
    public void prepareScene(){ 
        //Creating Text Filed for cardnum        
      TextField amount = new TextField();
      
      //creating label  
      Text text1 = new Text("add amount to deposit:"); 
       //Creating Buttons 
      Button submit = new Button("Submit");
      
                  Label label=new Label();

       //Creating Buttons 
       
      Button back = new Button("back");
      GridPane gridPane=new GridPane();
          gridPane.setMinSize(250, 350);
              //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(15); 
      gridPane.setHgap(15);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER);
     
      //Arranging all the nodes in the grid 
      gridPane.add(amount, 1, 2); 
      gridPane.add(text1, 1, 1); 
      gridPane.add(label, 1, 6); 

      gridPane.add(submit, 1, 3);
      gridPane.add(back, 1, 4);
       submit.setOnAction((ActionEvent event) -> {
           double quan = Double.parseDouble(amount.getText());
           amounte.credit(quan);
           String x = Double.toString(amounte.getBalance());
           label.setText(x);
           
      });
      
      
      back.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            stage.setScene(homeScreen.getScene());
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
     void setAmount(Logic m) {
this.amounte=m;
    }
}