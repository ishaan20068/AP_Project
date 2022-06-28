package WillHero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;


public class Controller {

    @FXML
    private Button startGame ;
    @FXML
    private Label labelText;
    @FXML
    private Button nameSubmit;
    @FXML
    private TextField userName;
    @FXML
    private Button exitButton;
    @FXML
    private Button loadbutton;

    public void ButtonHandler(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("page2.fxml")));
        Stage stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.show();
    }
    public void NameButtonSubmitted(ActionEvent e) throws IOException{
        labelText.setText("     Hello ! "+userName.getText()+"\n\n"+"... STARTING A NEW GAME ...");
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game1.fxml")));
        Stage stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(parent,900,490));
        stage.show();
    }
    @FXML
    void load_screen(ActionEvent event) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game1.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1,900,490));
                stage.show();
                ObjectInputStream in = null;
                try {
                    in = new ObjectInputStream(new FileInputStream("out.txt"));
                    Hero h1 = (Hero)in.readObject();
                    System.out.println("location of hero saved: "+h1.getLocation1().getNumber());
                    System.out.println("coins of hero saved: "+h1.getCoins());

                }
                catch(Exception e){
                    System.out.println(e.getMessage());}
                finally {
                    assert in != null;
                    in.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    @FXML
    public void ExitApplication(ActionEvent e) throws IOException{
        System.out.println("Exiting the Application");
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }

}
// #FFC0CB for pink
