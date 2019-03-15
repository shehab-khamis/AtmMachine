
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.text.Font;

public class SecondScene {

    Scene scene;

    LoginForm loginform;
    Withdraw withdraw;
    Deposit deposit;
    Stage stage;
    Balance balance;
    Logic m = new Logic();

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
        this.deposit.setAmount(m);
    }

    public void setWithdraw(Withdraw withdraw) {
        this.withdraw = withdraw;
        this.withdraw.setAmount(m);
    }

    public SecondScene(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {

        //Creating Buttons
        Button Withdrawal = new Button("Withdrawal");
        Button Deposit = new Button("Deposit");
        Button Balance = new Button("Balance");
        Button next = new Button("next");
        next.setDisable(true);
        Button previous = new Button("previous");

        //creating label 
        Text text1 = new Text("Welcome");
        text1.setFont(new Font("verdana",25));
        GridPane gridPane = new GridPane();
        scene = new Scene(gridPane);
        gridPane.setMinSize(360, 250);
        
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        gridPane.setAlignment(Pos.CENTER_LEFT);

        
        gridPane.add(text1, 4, 1);
        gridPane.add(Withdrawal, 1, 4);
        gridPane.add(Deposit, 5, 4);
        gridPane.add(Balance, 4, 4);
        gridPane.add(next, 5, 8);
        gridPane.add(previous, 1, 8);
        
        Withdrawal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(withdraw.getScene());
            }
        });
        Deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(deposit.getScene());
            }
        });
        Balance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //    stage.setScene(balance.getScene());
                text1.setText(m.getBalance2() + "");
            }
        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               String cat= m.next();
               text1.setText(cat );
               
               previous.setDisable(false);
              if (m.getIndex()==m.getTrans()-1)
               next.setDisable(true);
            }
        });

        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                next.setDisable(false);
                 String cat= m.previous();
               text1.setText(cat );
              if (m.getIndex()==0)
                previous.setDisable(true);
                
            }
        });

    }

    public Scene getScene() {
        return scene;
    }

    public void setLoginform(LoginForm loginform) {
        this.loginform = loginform;
    }

}
