package WillHero;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.Objects;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {

    @FXML
    private ImageView willhero;
    @FXML
    private ImageView orc1;
    @FXML
    private ImageView orc2;
    @FXML
    private ImageView orc3;
    @FXML
    private ImageView orc4;
    @FXML
    private ImageView bossOrc;
    @FXML
    private ImageView knife;
    @FXML
    private Button gamemenubutton;
    @FXML
    private Button forwardbutton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translateTransition ;
        translateTransition = new TranslateTransition();
        translateTransition.setNode(willhero);
        translateTransition.setAutoReverse(true);
        translateTransition.setDuration(Duration.millis(500));
        translateTransition.setByY(-30);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.play();

        TranslateTransition translateTransition1 = new TranslateTransition();
        translateTransition1.setNode(orc1);
        translateTransition1.setAutoReverse(true);
        translateTransition1.setDuration(Duration.millis(1000));
        translateTransition1.setByY(-30);
        translateTransition1.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition1.play();

        TranslateTransition translateTransition2 = new TranslateTransition();
        translateTransition2.setNode(orc2);
        translateTransition2.setAutoReverse(true);
        translateTransition2.setDuration(Duration.millis(1100));
        translateTransition2.setByY(-30);
        translateTransition2.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition2.play();

        TranslateTransition translateTransition3 = new TranslateTransition();
        translateTransition3.setNode(orc3);
        translateTransition3.setAutoReverse(true);
        translateTransition3.setDuration(Duration.millis(800));
        translateTransition3.setByY(-30);
        translateTransition3.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition3.play();

        TranslateTransition translateTransition4 = new TranslateTransition();
        translateTransition4.setNode(orc4);
        translateTransition4.setAutoReverse(true);
        translateTransition4.setDuration(Duration.millis(1500));
        translateTransition4.setByY(-30);
        translateTransition4.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition4.play();

        TranslateTransition translateTransition5 = new TranslateTransition();
        translateTransition5.setNode(bossOrc);
        translateTransition5.setAutoReverse(true);
        translateTransition5.setDuration(Duration.millis(400));
        translateTransition5.setByY(-20);
        translateTransition5.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition5.play();

    }

    public void InGameMenu(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("page4.fxml"))));
        Stage stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.show();
    }
    public void ForwardMove(ActionEvent e) throws IOException{
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(willhero);
        translateTransition.setAutoReverse(true);
        translateTransition.setDuration(Duration.millis(900));
        translateTransition.setByX(+30);
        translateTransition.setCycleCount(1);
        translateTransition.play();

        TranslateTransition translateTransition6 = new TranslateTransition();
        translateTransition6.setNode(knife);
        translateTransition6.setAutoReverse(true);
        translateTransition6.setDuration(Duration.millis(900));
        translateTransition6.setByX(+30);
        translateTransition6.setRate(2);
        translateTransition6.setCycleCount(1);
        translateTransition6.play();
    }

}
