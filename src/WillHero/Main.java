package WillHero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    private Group g;
    public Group getg(){
        return g;
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game1.fxml")));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("page1.fxml")));
        primaryStage.setTitle(" WILL HERO GAME");
        primaryStage.setScene(new Scene(root,900,490, Color.SKYBLUE)); //root,1100,690, Color.SKYBLUE remember these
        primaryStage.setResizable(false);
        Image icon = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\icon.jpg");
        primaryStage.getIcons().add(icon);
        //primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args); // or Application.launch(args)
    }
}
