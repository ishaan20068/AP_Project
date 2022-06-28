package WillHero;
//you were changing font outline of text in textfield
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;

import java.io.*;
import java.net.URL;

import java.util.Objects;
import java.util.ResourceBundle;

import javafx.scene.shape.Line;

public class GameController implements Initializable {
    private Group g = new Group(); // Global --- Main
    private Image hero = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\hero.jpg");
    private ImageView heroImg = new ImageView(hero);
    private final int[] count = {1};
    private Group g1 = new Group();
    private Location[] locList = new Location[123];
    private Location heroloc = new Location(0,true);

    ImageView sword = new ImageView(new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\swordicon.jpg"));
    ImageView knife = new ImageView("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\knifeicon.jpg");
    Button swordb = new Button();
    Image img2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\savenexit.jpg");
    ImageView i2 = new ImageView(img2);
    private Hero willhero = new Hero(heroloc,heroImg);
    public void save() throws IOException{
        ObjectOutputStream out = null;
        //ObjectOutputStream locout = null;
        try {
            out = new ObjectOutputStream (new FileOutputStream("out.txt"));
            out.writeObject(willhero);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            assert out != null;
            out.close();
        }
    }
    private Helmet helmet = new Helmet();
    private boolean flagfall=true;
    private boolean flagfall2=true;
    private boolean flagcoinintersect=false;
    private boolean flagchestintersect=false;
    private boolean resurrectflag=true;
    private boolean sidecol=false;
    private boolean upcol=false;
    private boolean downcol=false;
    private int numknife=1;
    private int numsword=1;
    @FXML
    private AnchorPane gameScreenFixed1;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image x=new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\swordicon.jpg");
        ImageView x1=new ImageView(x);
        x1.setFitHeight(70);
        x1.setFitWidth(70);
        x1.setX(40);
        x1.setY(400);
        x1.setPreserveRatio(true);
        x1.setSmooth(true);
        x1.setCache(true);
        x1.setOpacity(0.0);
        g1.getChildren().add(x1);
        Image x2=new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\knifeicon.jpg");
        ImageView x3=new ImageView(x2);
        x3.setFitHeight(70);
        x3.setFitWidth(70);
        x3.setX(40);
        x3.setY(400);
        x3.setPreserveRatio(true);
        x3.setSmooth(true);
        x3.setCache(true);
        x3.setOpacity(1.0);
        x3.setOpacity(0.0);
        g1.getChildren().add(x3);
        Text ltext = new Text("LEVEL: "+0);//Show on screen
        ltext.setX(110);
        ltext.setY(450);
        ltext.setFont(Font.font ("Arial", FontWeight.BLACK,22));
        ltext.getStyleClass().add("outline");
        ltext.setStroke(Color.BLACK);
        ltext.setStrokeWidth(1.0);
        ltext.setFill(Color.BLACK);
        ltext.setOpacity(0.0);
        g1.getChildren().add(ltext);
        Text t = new Text("Location: "+1);
        t.setX(50);
        t.setY(50);
        t.setFont(Font.font ("Arial", FontWeight.BLACK,32));
        t.getStyleClass().add("outline");
        t.setStroke(Color.BLACK);
        t.setStrokeWidth(1.0);
        t.setFill(Color.WHITE);
        g1.getChildren().add(t);
        Text cointext = new Text("Coins: "+0);//Show on screen
        cointext.setX(700);
        cointext.setY(450);
        cointext.setFont(Font.font ("Arial", FontWeight.BLACK,32));
        cointext.getStyleClass().add("outline");
        cointext.setStroke(Color.BLACK);
        cointext.setStrokeWidth(1.0);
        cointext.setFill(Color.WHITE);
        g1.getChildren().add(cointext);
        Button ingamemenub = new Button();
        Image menuimg = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\settings.jpg");
        ImageView inmenu = new ImageView(menuimg);
        ingamemenub.setGraphic(inmenu);
        ingamemenub.setLayoutX(790);
        ingamemenub.setLayoutY(30);
        ingamemenub.setMinHeight(50);
        ingamemenub.setMinWidth(50);
        inmenu.setFitHeight(50);
        inmenu.setFitWidth(60);
        g1.getChildren().add(ingamemenub);
        ingamemenub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage s = new Stage();
                Group g2 = new Group();

                Button continueb = new Button();
                Image img1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\continue.jpg");
                ImageView i1 = new ImageView(img1);
                continueb.setGraphic(i1);
                i1.setFitWidth(50);
                i1.setFitHeight(50);
                continueb.setLayoutX(20);
                continueb.setLayoutY(10);
                continueb.setBorder(new Border(new BorderStroke(Color.SKYBLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
                continueb.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        s.close();
                    }
                });
                g2.getChildren().add(continueb);

                Button saveb = new Button();
                Image img2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\savenexit.jpg");
                ImageView i2 = new ImageView(img2);
                saveb.setGraphic(i2);
                i2.setFitWidth(50);
                i2.setFitHeight(50);
                saveb.setLayoutX(120);
                saveb.setLayoutY(10);
                saveb.setBorder(new Border(new BorderStroke(Color.SKYBLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
                g2.getChildren().add(saveb);
                //Adding Button
                saveb.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                            try {
                                save();
                                System.out.println("save Complete");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("page1.fxml"));
                            Parent root1 = fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1,900,490));
                            stage.show();
                            s.close();
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                });


                Button soundb = new Button();
                Image img3 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\sound.jpg");
                ImageView i3 = new ImageView(img3);
                soundb.setGraphic(i3);
                i3.setFitWidth(50);
                i3.setFitHeight(50);
                soundb.setLayoutX(230);
                soundb.setLayoutY(10);
                soundb.setBorder(new Border(new BorderStroke(Color.SKYBLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
                g2.getChildren().add(soundb);

                Scene s2 = new Scene(g2,330,90);
                s.setScene(s2);
                s.setResizable(false);
                s2.setFill(Color.SKYBLUE);
                Image icon = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\icon.jpg");
                s.getIcons().add(icon);
                s.setTitle("Pause Menu");
                s.show();
            }
        });
        Button button = new Button("Move Forward");
        button.setLayoutX(385);
        button.setLayoutY(400);
        button.setBorder(new Border(new BorderStroke(Color.LIGHTPINK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,new BorderWidths(4))));
        Button resurrectb = new Button("Resurrect");
        resurrectb.setLayoutX(190);
        resurrectb.setLayoutY(40);
        resurrectb.setBorder(new Border(new BorderStroke(Color.LIGHTPINK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
        int flag = 0 ; //
        int flagCoin = 0;
        int flagChest = 0;
        int flagChest2 = 0;
        int flagweapon = 0;
        Stage reliveStage = new Stage();
        Button exitb = new Button("Exit");
        //////////////////////////////////////////////////////////////////////////////////////
        button.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                upcol=false;
                downcol=false;
                sidecol=false;
                TranslateTransition tt = new TranslateTransition();
                tt.setNode(g);
                tt.setDuration(Duration.millis(50));
                tt.setByX(-200);
                tt.setRate(5);
                count[0]++;
                willhero.setLocation1(locList[count[0]]);
                tt.play();

                t.setText("Location: "+(willhero.getLocation1().getNumber()));
                if(willhero.getLocation1().getNumber()==122){ // Player Reached the end
                    Stage s=new Stage();
                    Group g4=new Group();
                    Scene scn=new Scene(g4,900,490);
                    Button btn=new Button();
                    ImageView img =new ImageView(new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\savenexit.jpg"));
                    btn.setGraphic(img);
                    img.setFitWidth(90);
                    img.setFitHeight(90);
                    btn.setLayoutX(405);
                    btn.setLayoutY(350);
                    btn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("page1.fxml"));
                                Parent root1 = fxmlLoader.load();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root1,900,490));
                                stage.show();
                                s.close();
                            } catch(Exception e) {
                                e.printStackTrace();
                            }


                        }
                    });
                    g4.getChildren().add(btn);
                    scn.setFill(Color.SKYBLUE);
                    Text text = new Text(100, 250, "YOU WON");
                    //Setting the font
                    Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 150);
                    text.setFont(font);
                    //Setting the color of the text
                    text.setFill(Color.YELLOW);
                    //Setting the width
                    text.setStrokeWidth(2);
                    //Setting the stroke color
                    text.setStroke(Color.YELLOW);
                    s.setResizable(false);
                    s.getIcons().add(new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\icon.jpg"));
                    g4.getChildren().add(text);
                    s.setScene(scn);
                    s.setTitle("YOU WON");
                    s.show();
                }
                if(!willhero.getLocation1().isHas_platform()){
                    flagfall=true;
                    flagfall2=true;
                }
                if(willhero.getLocation1().isHas_coin()){
                    flagcoinintersect=true;
                }
                else{
                    flagcoinintersect=false;
                }
                if(willhero.getLocation1().isHas_chest()){
                    flagchestintersect=true;
                }
                else{
                    flagchestintersect=false;
                }
                if(willhero.getLocation1().isHas_orc() ){
                    double heroup=willhero.getObjectImg().getBoundsInParent().getMaxY();         // Y MAX hero
                    double herodown=willhero.getObjectImg().getBoundsInParent().getMinY();       // Y MIN hero
                    double orcup=willhero.getLocation1().getOrc().getObjectImg().getBoundsInParent().getMaxY();  // Y MAX orc
                    double orcdown=willhero.getLocation1().getOrc().getObjectImg().getBoundsInParent().getMinY();// Y MIN orc
                    if((heroup>=orcdown-6) && (herodown-6<=orcup)){
                        sidecol=true;
                        Orc orcobj=willhero.getLocation1().getOrc();
                        int xte=orcobj.getLocation1().getNumber();
                        ImageView orctemp=willhero.getLocation1().getOrc().getObjectImg();
                        if(willhero.getWeapon_flag()==0){
                            TranslateTransition t1=new TranslateTransition();
                            t1.setNode(orctemp);
                            t1.setDuration(Duration.millis(800));
                            t1.setByX(200);
                            t1.setRate(4);
                            t1.play();
                            orcobj.setLocation1(locList[xte+1]);
                            locList[xte].setOrc(null);
                            locList[xte+1].setOrc(orcobj);
                            locList[xte+1].setHas_orc(true);
                            locList[xte].setHas_orc(false);
                            if(!orcobj.getLocation1().isHas_platform()){
                                willhero.increasecoins(2);
                                locList[xte+1].setHas_orc(false);
                                orcobj.getTt().stop();
                                TranslateTransition orcdo=new TranslateTransition();
                                orcdo.setNode(orcobj.getObjectImg());
                                orcdo.setDuration(Duration.millis(1000));
                                orcdo.setByY(400);
                                orcdo.setRate(1);
                                orcdo.play();
                                g.getChildren().remove(orcobj);}
                        }
                        else if(willhero.getWeapon_flag()==1){
                            orctemp.setOpacity(0.0);
                            willhero.increasecoins(2);
                            locList[xte].setHas_orc(false);
                            locList[xte].setOrc(null);
                        }
                        else{
                            orctemp.setOpacity(0.0);
                            willhero.increasecoins(2);
                            locList[xte].setHas_orc(false);
                            locList[xte].setOrc(null);
                        }
                    }
                    else if(orcdown>heroup+6){
                        upcol=true;
                        willhero.getLocation1().getOrc().getObjectImg().setOpacity(0.0);
                    }
                    else{
                        downcol=true;
                        gameScreenFixed1.setVisible(false);
                        resurrectb.setLayoutX(190);
                        resurrectb.setLayoutY(40);
                        resurrectb.setBorder(new Border(new BorderStroke(Color.LIGHTPINK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
                        exitb.setLayoutX(50);
                        exitb.setLayoutY(40);
                        exitb.setBorder(new Border(new BorderStroke(Color.LIGHTPINK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
                        exitb.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                reliveStage.close();
                                gameScreenFixed1.setVisible(false);
                                try {
                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("page1.fxml"));
                                    Parent root1 = fxmlLoader.load();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(root1,900,490));
                                    stage.getIcons().add(new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\icon.jpg"));
                                    stage.show();
                                } catch(Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        resurrectb.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                if(resurrectflag && willhero.getCoins()>=15){
                                    resurrectflag=false;
                                    gameScreenFixed1.setVisible(true);
                                    willhero.increasecoins(-15);
                                    cointext.setText("Coins :"+willhero.getCoins());
                                    willhero.getObjectImg().setY(-25);
                                    willhero.getLocation1().setHas_platform(true);
                                    Image island = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
                                    ImageView islandImg = new ImageView(island);
                                    islandImg.setFitHeight(100);
                                    islandImg.setFitWidth(200);
                                    islandImg.setX((willhero.getLocation1().getNumber()) * 200);
                                    islandImg.setY(250);
                                    islandImg.setPreserveRatio(true);
                                    islandImg.setSmooth(true);
                                    islandImg.setCache(true);
                                    g.getChildren().add(islandImg);
                                    TranslateTransition fall1=new TranslateTransition();
                                    fall1.setNode(willhero.getObjectImg());
                                    fall1.setDuration(Duration.millis(800));
                                    fall1.setByY(-250);
                                    fall1.setCycleCount(1);
                                    fall1.play();

                                    TranslateTransition translateTransition = new TranslateTransition();
                                    translateTransition.setNode(willhero.getObjectImg());
                                    translateTransition.setAutoReverse(true);
                                    translateTransition.setDuration(Duration.millis(1500));
                                    translateTransition.setByY(-60);
                                    translateTransition.setRate(3);
                                    translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
                                    translateTransition.play();
                                    reliveStage.close();}

                            }
                        });
                        Group relivegroup = new Group(); // Separate group being created every time
                        relivegroup.getChildren().add(exitb);
                        relivegroup.getChildren().add(resurrectb);
                        Scene reliveScene = new Scene(relivegroup, 300, 100);
                        reliveScene.setFill(Color.SKYBLUE);
                        reliveStage.setScene(reliveScene);
                        reliveStage.setTitle("You Lose");
                        reliveStage.show();
                        if(resurrectflag==false){
                            //close the back screen
                            gameScreenFixed1.setVisible(false);
                        }
                    }
                }
            }
        });
        g1.getChildren().add(button);
        willhero.getObjectImg().setFitHeight(25);
        willhero.getObjectImg().setFitWidth(25);
        willhero.getObjectImg().setX(300);
        willhero.getObjectImg().setY(225);
        willhero.getObjectImg().setPreserveRatio(true);
        willhero.getObjectImg().setSmooth(true);
        willhero.getObjectImg().setCache(true);


        willhero.setHelmet(helmet);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(willhero.getObjectImg());
        translateTransition.setAutoReverse(true);
        translateTransition.setDuration(Duration.millis(1500));
        translateTransition.setByY(-60);
        translateTransition.setRate(3);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.play();
        Line fallLine = new Line(5.0f, 2.5f, 320.0f, 2.5f);
        fallLine.setOpacity(0.0);
        fallLine.setTranslateX(275);
        fallLine.setTranslateY(248);
        g1.getChildren().add(fallLine);
        Line rescrnline = new Line(5.0f, 2.5f, 320.0f, 2.5f);
        rescrnline.setOpacity(0.0);
        rescrnline.setTranslateX(275);
        rescrnline.setTranslateY(482);
        g1.getChildren().add(rescrnline);

        resurrectb.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(resurrectflag && willhero.getCoins()>=15){
                        resurrectflag=false;
                        willhero.increasecoins(-15);
                        cointext.setText("Coins :"+willhero.getCoins());
                        willhero.getObjectImg().setY(-25);
                        willhero.getLocation1().setHas_platform(true);
                        Image island = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
                        ImageView islandImg = new ImageView(island);
                        islandImg.setFitHeight(100);
                        islandImg.setFitWidth(200);
                        islandImg.setX((willhero.getLocation1().getNumber()) * 200);
                        islandImg.setY(250);
                        islandImg.setPreserveRatio(true);
                        islandImg.setSmooth(true);
                        islandImg.setCache(true);
                        g.getChildren().add(islandImg);
                        TranslateTransition fall1=new TranslateTransition();
                        fall1.setNode(willhero.getObjectImg());
                        fall1.setDuration(Duration.millis(800));
                        fall1.setByY(-250);
                        fall1.setCycleCount(1);
                        fall1.play();

                        TranslateTransition translateTransition = new TranslateTransition();
                        translateTransition.setNode(willhero.getObjectImg());
                        translateTransition.setAutoReverse(true);
                        translateTransition.setDuration(Duration.millis(1500));
                        translateTransition.setByY(-60);
                        translateTransition.setRate(3);
                        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
                        translateTransition.play();
                        reliveStage.close();}

                }
            });
        willhero.getObjectImg().translateYProperty().addListener((obs, old, newValue) -> {
            if(willhero.getWeapon_flag()!=0){
                if(willhero.getWeapon_flag()==1){
                    x1.setOpacity(1.0);
                    x3.setOpacity(0.0);
                    ltext.setText("LEVEL: "+willhero.getHelmet().getSword().getLevel());
                    ltext.setOpacity(1.0);
                }
                else{
                    x1.setOpacity(0.0);
                    x3.setOpacity(1.0);
                    ltext.setText("LEVEL: "+willhero.getHelmet().getKnife().getLevel());
                }
            }
            else{
                ltext.setOpacity(0.0);
                x1.setOpacity(0.0);
                x3.setOpacity(0.0);
            }
            if(flagfall && (!willhero.getLocation1().isHas_platform() && !willhero.getLocation1().isHas_falling_platform()) && willhero.getObjectImg().getBoundsInParent().intersects(fallLine.getBoundsInParent())){
                flagfall=false;
                translateTransition.stop();

                TranslateTransition fall=new TranslateTransition();
                fall.setNode(willhero.getObjectImg());
                fall.setDuration(Duration.millis(800));
                fall.setByY(250);
                fall.setCycleCount(1);
                fall.play();
                System.out.println("you lost");
                //System.out.println(heroImg.getBoundsInParent() +" prob "+rescrnline.getBoundsInParent());
            }
            if(flagfall2 && willhero.getObjectImg().getBoundsInParent().intersects(rescrnline.getBoundsInParent())) {
                flagfall2 = false;
                System.out.println("ok");
                exitb.setLayoutX(50);
                exitb.setLayoutY(40);
                exitb.setBorder(new Border(new BorderStroke(Color.LIGHTPINK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
                exitb.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        reliveStage.close();
                        gameScreenFixed1.setVisible(false);
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("page1.fxml"));
                            Parent root1 = fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1,900,490));
                            stage.getIcons().add(new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\icon.jpg"));
                            stage.show();
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                Group relivegroup = new Group(); // Separate group being created every time
                relivegroup.getChildren().add(exitb);
                relivegroup.getChildren().add(resurrectb);
                Scene reliveScene = new Scene(relivegroup, 300, 100);
                reliveScene.setFill(Color.SKYBLUE);
                reliveStage.setScene(reliveScene);
                reliveStage.setTitle("You Lose");
                reliveStage.show();
                if(resurrectflag==false){
                    //close the back screen
                    gameScreenFixed1.setVisible(false);
                }
            }
            if(flagcoinintersect && willhero.getLocation1().isHas_coin() ){
                if(willhero.getObjectImg().getBoundsInParent().getMinY()<230 && willhero.getObjectImg().getBoundsInParent().getMaxY()>210){
                    willhero.increasecoins(1);
                    cointext.setText("Coins: "+willhero.getCoins());
                    willhero.getLocation1().getCoinhere().setOpacity(0.0);
                    flagcoinintersect=false;}
            }
            if(flagchestintersect && willhero.getLocation1().isHas_chest()){
                if(willhero.getObjectImg().getBoundsInParent().getMaxY()>200 && willhero.getObjectImg().getBoundsInParent().getMinY()<226){
                    if(willhero.getLocation1().getChest().getType().equals("Coin")){
                        willhero.increasecoins(10);
                        cointext.setText("Coins: "+willhero.getCoins());
                        willhero.getLocation1().getChest().getObjectImg().setOpacity(0.0);
                        Image chest1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\ChestOpen.jpg");
                        ImageView Imgchest1 = new ImageView(chest1);
                        Imgchest1.setFitWidth(40);
                        Imgchest1.setFitHeight(50);
                        Imgchest1.setX((willhero.getLocation1().getNumber()) * 200 + 100);
                        Imgchest1.setY(225);
                        Imgchest1.setPreserveRatio(true);
                        Imgchest1.setSmooth(true);
                        Imgchest1.setCache(true);
                        g.getChildren().add(Imgchest1);
                        flagchestintersect=false;
                    }
                    if(willhero.getLocation1().getChest().getType().equals("Weapon")){
                        willhero.getLocation1().getChest().getObjectImg().setOpacity(0.0);
                        Image chest1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\ChestOpen.jpg");
                        ImageView Imgchest1 = new ImageView(chest1);
                        Imgchest1.setFitWidth(40);
                        Imgchest1.setFitHeight(50);
                        Imgchest1.setX((willhero.getLocation1().getNumber()) * 200 + 100);
                        Imgchest1.setY(225);
                        Imgchest1.setPreserveRatio(true);
                        Imgchest1.setSmooth(true);
                        Imgchest1.setCache(true);
                        g.getChildren().add(Imgchest1);
                        flagchestintersect=false;
                        Weapon_Chest chestem= (Weapon_Chest) willhero.getLocation1().getChest();
                        String typeches=chestem.getWeapon().getWname();
                        if (typeches.equals("Knife")){
                            willhero.setWeapon_flag(2);
                            willhero.getHelmet().setKnife(chestem.getWeapon());
                            if(numknife==2){
                                willhero.getHelmet().getKnife().setLevel(2);

                            }
                            numknife++;
                        }
                        else{
                            willhero.setWeapon_flag(1);
                            willhero.getHelmet().setSword(chestem.getWeapon());
                            if(numsword==2){
                                willhero.getHelmet().getSword().setLevel(2);
                            }
                            numsword++;
                        }
                    }
                }
            }
            if(willhero.getLocation1().isHas_falling_platform()){
                if(willhero.getObjectImg().getBoundsInParent().intersects(fallLine.getBoundsInParent())){
                    willhero.getLocation1().setHas_falling_platform(false);
                    TranslateTransition tfp=new TranslateTransition();
                    tfp.setNode(willhero.getLocation1().getFallingplatform());
                    tfp.setDuration(Duration.millis(800));
                    tfp.setByY(250);
                    tfp.setCycleCount(1);
                    tfp.play();
                }
            }
            if(sidecol){
                System.out.println("sidecollision");
                cointext.setText("Coins: "+willhero.getCoins());
                sidecol=false;
            }
            if(downcol){
                System.out.println("downcollision");
                cointext.setText("Coins: "+willhero.getCoins());
                downcol=false;
            }
            if(upcol){
                System.out.println("upcollision");
                cointext.setText("Coins: "+willhero.getCoins());
                upcol=false;
            }
        });
        g1.getChildren().add(willhero.getObjectImg());
        // Normal with island1 image Platforms
        for (int i = 0; i < 81;) {   // Creating Islands...
            Image island = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg = new ImageView(island);
            islandImg.setFitHeight(100);
            islandImg.setFitWidth(200);
            islandImg.setX((i+1) * 200);
            islandImg.setY(250);
            islandImg.setPreserveRatio(true);
            islandImg.setSmooth(true);
            islandImg.setCache(true);
            g.getChildren().add(islandImg);

            Location islandloc = new Location(i+1,true);
            locList[i+1] = islandloc;
            if(flag==1){
                Image orc = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\greenorc.jpg");
                ImageView orcImg1 = new ImageView(orc);
                orcImg1.setFitHeight(25);
                orcImg1.setFitWidth(25);
                orcImg1.setX((i+1) * 200 + 100);
                orcImg1.setY(225);
                orcImg1.setPreserveRatio(true);
                orcImg1.setSmooth(true);
                orcImg1.setCache(true);
                TranslateTransition translateOrc = new TranslateTransition();
                translateOrc.setNode(orcImg1);
                translateOrc.setAutoReverse(true);
                translateOrc.setDuration(Duration.millis(1500));
                translateOrc.setByY(-60);
                translateOrc.setRate(3);
                translateOrc.setCycleCount(TranslateTransition.INDEFINITE);
                translateOrc.play();
                g.getChildren().add(orcImg1);

                Green_Orc greenOrc = new Green_Orc(locList[i+1],orcImg1);
                greenOrc.setTt(translateOrc);
                locList[i+1].setHas_orc(true);
                locList[i+1].setOrc(greenOrc);

            }
            i++;
            Image island1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg1 = new ImageView(island1);
            islandImg1.setFitHeight(100);
            islandImg1.setFitWidth(200);
            islandImg1.setX((i+1) * 200);
            islandImg1.setY(250);
            islandImg1.setPreserveRatio(true);
            islandImg1.setSmooth(true);
            islandImg1.setCache(true);
            g.getChildren().add(islandImg1);
            // hasPlatform[i+1] = 1;
            Location islandloc1 = new Location(i+1,true);
            locList[i+1] = islandloc1;
            if(flag==0){
                Image orc = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\RedOrc.jpg");
                ImageView orcImg1 = new ImageView(orc);
                orcImg1.setFitHeight(25);
                orcImg1.setFitWidth(25);
                orcImg1.setX((i+1) * 200 + 100);
                orcImg1.setY(225);
                orcImg1.setPreserveRatio(true);
                orcImg1.setSmooth(true);
                orcImg1.setCache(true);
                TranslateTransition translateOrc = new TranslateTransition();
                translateOrc.setNode(orcImg1);
                translateOrc.setAutoReverse(true);
                translateOrc.setDuration(Duration.millis(1500));
                translateOrc.setByY(-60);
                translateOrc.setRate(3);
                translateOrc.setCycleCount(TranslateTransition.INDEFINITE);
                translateOrc.play();
                g.getChildren().add(orcImg1);

                Red_Orc red_orc = new Red_Orc(locList[i+1],orcImg1);
                red_orc.setTt(translateOrc); // Changed
                locList[i+1].setHas_orc(true);
                locList[i+1].setOrc(red_orc);
            }
            if(flagCoin==1){
                Image coin = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
                ImageView coinImg = new ImageView(coin);
                coinImg.setFitHeight(20);
                coinImg.setFitWidth(20);
                coinImg.setX((i+1)*200+100);
                coinImg.setY(210);
                locList[i+1].setCoinhere(coinImg);
                locList[i+1].setHas_coin(true);
                g.getChildren().add(coinImg);
            }
            // Tree1
            Image tree2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\tree1.jpg");
            ImageView Imgtree2 = new ImageView(tree2);
            Imgtree2.setFitWidth(30);
            Imgtree2.setFitHeight(50);
            Imgtree2.setX((i+1) * 200);
            Imgtree2.setY(210);
            Imgtree2.setPreserveRatio(true);
            Imgtree2.setSmooth(true);
            Imgtree2.setCache(true);
            g.getChildren().add(Imgtree2);

            i++;
            Location islandloc2 = new Location(i+1,false);
            locList[i+1] = islandloc2;
            i++;
            Image island2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg2 = new ImageView(island2);
            islandImg2.setFitHeight(100);
            islandImg2.setFitWidth(200);
            islandImg2.setX((i+1) * 200);
            islandImg2.setY(250);
            islandImg2.setPreserveRatio(true);
            islandImg2.setSmooth(true);
            islandImg2.setCache(true);
            g.getChildren().add(islandImg2);
            //hasPlatform[i+1] = 1;
            Location islandloc3 = new Location(i+1,true);
            locList[i+1] = islandloc3;
            //Tree2
            Image tree3 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\tree2.jpg");
            ImageView Imgtree3 = new ImageView(tree3);
            Imgtree3.setFitWidth(30);
            Imgtree3.setFitHeight(50);
            Imgtree3.setX((i+1) * 200);
            Imgtree3.setY(205);
            Imgtree3.setPreserveRatio(true);
            Imgtree3.setSmooth(true);
            Imgtree3.setCache(true);
            g.getChildren().add(Imgtree3);
            //Chest

            if(flagChest==1){
                Image chest1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\ChestClosed.jpg");
                ImageView Imgchest1 = new ImageView(chest1);
                Imgchest1.setFitWidth(40);
                Imgchest1.setFitHeight(50);
                Imgchest1.setX((i+1) * 200 + 100);
                Imgchest1.setY(225);
                Imgchest1.setPreserveRatio(true);
                Imgchest1.setSmooth(true);
                Imgchest1.setCache(true);
                g.getChildren().add(Imgchest1);
                if(flagChest2==1){

                    Coin_Chest coin_chest = new Coin_Chest(locList[i+1],Imgchest1);
                    locList[i+1].setHas_chest(true);
                    locList[i+1].setChest(coin_chest);
                    flagChest2 = 0;
                }
                else{
                    if(flagweapon==0){
                        Sword sword = new Sword();
                        Weapon_Chest wc = new Weapon_Chest(locList[i+1],Imgchest1,sword);
                        locList[i+1].setHas_chest(true);
                        locList[i+1].setChest(wc);
                        flagweapon=1;
                    }
                    else{
                        knife knife = new knife();
                        Weapon_Chest wc = new Weapon_Chest(locList[i+1],Imgchest1,knife);
                        locList[i+1].setHas_chest(true);
                        locList[i+1].setChest(wc);
                        flagweapon=0;
                    }
                    flagChest2 = 0;
                }
            }

            i++;
            Location islandloc4 = new Location(i+1,false);
            locList[i+1] = islandloc4;
            i++;
            Image island3 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg3 = new ImageView(island3);
            islandImg3.setFitHeight(100);
            islandImg3.setFitWidth(200);
            islandImg3.setX((i+1) * 200);
            islandImg3.setY(250);
            islandImg3.setPreserveRatio(true);
            islandImg3.setSmooth(true);
            islandImg3.setCache(true);
            g.getChildren().add(islandImg3);
            Location islandloc5 = new Location(i+1,true);
            locList[i+1] = islandloc5;
            //hasPlatform[i+1] = 1;
            //Tree1
            Image tree1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\tree1.jpg");
            ImageView Imgtree1 = new ImageView(tree1);
            Imgtree1.setFitWidth(30);
            Imgtree1.setFitHeight(50);
            Imgtree1.setX((i+1) * 200);
            Imgtree1.setY(210);
            Imgtree1.setPreserveRatio(true);
            Imgtree1.setSmooth(true);
            Imgtree1.setCache(true);
            g.getChildren().add(Imgtree1);
            i++;
            Image island4 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg4 = new ImageView(island4);
            islandImg4.setFitHeight(100);
            islandImg4.setFitWidth(200);
            islandImg4.setX((i+1) * 200);
            islandImg4.setY(250);
            islandImg4.setPreserveRatio(true);
            islandImg4.setSmooth(true);
            islandImg4.setCache(true);
            g.getChildren().add(islandImg4);

            //hasPlatform[i+1] = 1;
            Image tree4 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\tree2.jpg");
            ImageView Imgtree4 = new ImageView(tree4);
            Imgtree4.setFitWidth(30);
            Imgtree4.setFitHeight(50);
            Imgtree4.setX((i+1) * 200);
            Imgtree4.setY(205);
            Imgtree4.setPreserveRatio(true);
            Imgtree4.setSmooth(true);
            Imgtree4.setCache(true);
            g.getChildren().add(Imgtree4);
            Location islandloc6 = new Location(i+1,true);
            locList[i+1] = islandloc6;
            if(flag==1){
                Image orc = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\RedOrc.jpg");
                ImageView orcImg1 = new ImageView(orc);
                orcImg1.setFitHeight(25);
                orcImg1.setFitWidth(25);
                orcImg1.setX((i+1) * 200 + 100);
                orcImg1.setY(225);
                orcImg1.setPreserveRatio(true);
                orcImg1.setSmooth(true);
                orcImg1.setCache(true);
                TranslateTransition translateOrc = new TranslateTransition();
                translateOrc.setNode(orcImg1);
                translateOrc.setAutoReverse(true);
                translateOrc.setDuration(Duration.millis(1500));
                translateOrc.setByY(-60);
                translateOrc.setRate(3);
                translateOrc.setCycleCount(TranslateTransition.INDEFINITE);
                translateOrc.play();
                g.getChildren().add(orcImg1);

                Red_Orc red_orc = new Red_Orc(locList[i+1],orcImg1);
                red_orc.setTt(translateOrc);
                locList[i+1].setHas_orc(true);
                locList[i+1].setOrc(red_orc);
            }
            if(flagCoin==0){
                Image coin = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
                ImageView coinImg = new ImageView(coin);
                coinImg.setFitHeight(20);
                coinImg.setFitWidth(20);
                coinImg.setX((i+1)*200+100);
                coinImg.setY(210);
                locList[i+1].setHas_coin(true);
                locList[i+1].setCoinhere(coinImg);
                g.getChildren().add(coinImg);
            }

            i++;
            Image island5 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg5 = new ImageView(island5);
            islandImg5.setFitHeight(100);
            islandImg5.setFitWidth(200);
            islandImg5.setX((i+1) * 200);
            islandImg5.setY(250);
            islandImg5.setPreserveRatio(true);
            islandImg5.setSmooth(true);
            islandImg5.setCache(true);
            g.getChildren().add(islandImg5);
            //hasPlatform[i+1] = 1;
            Location islandloc7 = new Location(i+1,true);
            locList[i+1] = islandloc7;
            if(flag==0){
                Image orc = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\greenorc.jpg");
                ImageView orcImg1 = new ImageView(orc);
                orcImg1.setFitHeight(25);
                orcImg1.setFitWidth(25);
                orcImg1.setX((i+1) * 200 + 100);
                orcImg1.setY(225);
                orcImg1.setPreserveRatio(true);
                orcImg1.setSmooth(true);
                orcImg1.setCache(true);
                TranslateTransition translateOrc = new TranslateTransition();
                translateOrc.setNode(orcImg1);
                translateOrc.setAutoReverse(true);
                translateOrc.setDuration(Duration.millis(1500));
                translateOrc.setByY(-60);
                translateOrc.setRate(3);
                translateOrc.setCycleCount(TranslateTransition.INDEFINITE);
                translateOrc.play();
                g.getChildren().add(orcImg1);

                Green_Orc greenOrc = new Green_Orc(locList[i+1],orcImg1);
                greenOrc.setTt(translateOrc);   //Changed
                locList[i+1].setHas_orc(true);
                locList[i+1].setOrc(greenOrc);
            }
            if(flagCoin==1){
                Image coin = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
                ImageView coinImg = new ImageView(coin);
                coinImg.setFitHeight(20);
                coinImg.setFitWidth(20);
                coinImg.setX((i+1)*200+100);
                coinImg.setY(210);
                locList[i+1].setHas_coin(true);
                locList[i+1].setCoinhere(coinImg);
                g.getChildren().add(coinImg);
            }
            i++;
            Location islandloc8 = new Location(i+1,false);
            locList[i+1] = islandloc8;
            i++;
            if(flag==0){
                flag=1;
            }
            else{
                flag=0;
            }
            flagCoin=(flagCoin+1)%2;
            flagChest=(flagChest+1)%2;
        }
        for(int i=81;i<88;){//Add falling platforms also!!!!!!!!! and coin chest 3 more
            Image coin2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
            ImageView coinImg2 = new ImageView(coin2);
            coinImg2.setFitHeight(20);
            coinImg2.setFitWidth(20);
            coinImg2.setX((i+1)*200+100);
            coinImg2.setY(210);
            Location islandloc = new Location(i+1,false);
            islandloc.setHas_falling_platform(true);
            Image platfall=new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\fallPlat.jpg");
            ImageView fallplat=new ImageView(platfall);
            fallplat.setX(200*(i+1));
            fallplat.setY(260);
            fallplat.setFitWidth(200);
            fallplat.setFitHeight(10);
            islandloc.setFallingplatform(fallplat);
            locList[i+1] = islandloc;
            locList[i+1].setCoinhere(coinImg2);
            locList[i+1].setHas_coin(true);
            g.getChildren().add(fallplat);
            g.getChildren().add(coinImg2);//Add falling platform...
            i++;
        }
        for(int i=88;i<99;){//Add 2 more chests
            Image island = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands1.jpg");
            ImageView islandImg = new ImageView(island);
            islandImg.setFitHeight(100);
            islandImg.setFitWidth(200);
            islandImg.setX((i+1) * 200);
            islandImg.setY(250);
            islandImg.setPreserveRatio(true);
            islandImg.setSmooth(true);
            islandImg.setCache(true);
            g.getChildren().add(islandImg);
            Location islandloc = new Location(i+1,true);
            locList[i+1] = islandloc;
            //hasPlatform[i+1] = 1;
            if(i==90){
                Image chest = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\ChestClosed.jpg");
                ImageView Imgchest = new ImageView(chest);
                Imgchest.setFitWidth(40);
                Imgchest.setFitHeight(50);
                Imgchest.setX((i+1) * 200 + 100);
                Imgchest.setY(220);
                Imgchest.setPreserveRatio(true);
                Imgchest.setSmooth(true);
                Imgchest.setCache(true);
                Coin_Chest coin_chest = new Coin_Chest(locList[i+1],Imgchest);
                locList[i+1].setHas_chest(true);
                locList[i+1].setChest(coin_chest);
                g.getChildren().add(Imgchest);
            }
            if(i==95){
                Image chest = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\ChestClosed.jpg");
                ImageView Imgchest = new ImageView(chest);
                Imgchest.setFitWidth(40);
                Imgchest.setFitHeight(50);
                Imgchest.setX((i+1) * 200 + 100);
                Imgchest.setY(220);
                Imgchest.setPreserveRatio(true);
                Imgchest.setSmooth(true);
                Imgchest.setCache(true);
                Coin_Chest coin_chest = new Coin_Chest(locList[i+1],Imgchest);
                locList[i+1].setHas_chest(true);
                locList[i+1].setChest(coin_chest);
                g.getChildren().add(Imgchest);
            }
            //Confirm it here (i+1) ??
            //hasPlatform[i+1] = 1;
            i++;
        }
        for(int i = 99;i<107;){//Falling platform to be added between this range . . .
            Image coin2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\Coin.jpg");
            ImageView coinImg2 = new ImageView(coin2);
            coinImg2.setFitHeight(20);
            coinImg2.setFitWidth(20);
            coinImg2.setX((i+1)*200+100);
            coinImg2.setY(210);
            g.getChildren().add(coinImg2);
            Location islandloc = new Location(i+1,false);
            islandloc.setHas_falling_platform(true);
            Image platfall=new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\fallPlat.jpg");
            ImageView fallplat=new ImageView(platfall);
            fallplat.setX(200*(i+1));
            fallplat.setY(260);
            fallplat.setFitWidth(200);
            fallplat.setFitHeight(10);
            islandloc.setFallingplatform(fallplat);
            locList[i+1] = islandloc;
            locList[i+1].setHas_coin(true);
            locList[i+1].setCoinhere(coinImg2);
            g.getChildren().add(fallplat);
            i++;
        }

        for(int j=107;j<113;){ // Normal with different image Platforms(island2)
            Image island = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands2.jpg");
            ImageView islandImg = new ImageView(island);
            islandImg.setFitHeight(100);
            islandImg.setFitWidth(200);
            islandImg.setX((j+1) * 200);
            islandImg.setY(250);
            islandImg.setPreserveRatio(true);
            islandImg.setSmooth(true);
            islandImg.setCache(true);
            g.getChildren().add(islandImg);
            Image tree2 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\tree1.jpg");
            ImageView Imgtree2 = new ImageView(tree2);
            Imgtree2.setFitWidth(30);
            Imgtree2.setFitHeight(50);
            Imgtree2.setX((j+1) * 200);
            Imgtree2.setY(210);
            Imgtree2.setPreserveRatio(true);
            Imgtree2.setSmooth(true);
            Imgtree2.setCache(true);
            g.getChildren().add(Imgtree2);
            //hasPlatform[j+1] = 1;
            Location islandloc = new Location(j+1,true);
            locList[j+1] = islandloc;
            j++;
        }
        for(int k=113;k<122;){ // PLayer has won and meeting the love of her life...
            Image island = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\islands2.jpg");
            ImageView islandImg = new ImageView(island);
            islandImg.setFitHeight(100);
            islandImg.setFitWidth(200);
            islandImg.setX((k+1) * 200); //
            islandImg.setY(250);
            islandImg.setPreserveRatio(true);
            islandImg.setSmooth(true);
            islandImg.setCache(true);
            g.getChildren().add(islandImg);
            //hasPlatform[k+1] = 1;
            Location islandloc = new Location(k+1,true);
            locList[k+1] = islandloc;
            k++;
        }

        //Placing the Boss Orc . . .
        Image orc = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\bossOrc.jpg");
        ImageView orcImg1 = new ImageView(orc);
        orcImg1.setFitHeight(75);
        orcImg1.setFitWidth(75);
        orcImg1.setX(22500);//Notice
        orcImg1.setY(175);
        orcImg1.setPreserveRatio(true);
        orcImg1.setSmooth(true);
        orcImg1.setCache(true);
        TranslateTransition translateOrc = new TranslateTransition();
        translateOrc.setNode(orcImg1);
        translateOrc.setAutoReverse(true);
        translateOrc.setDuration(Duration.millis(1500));
        translateOrc.setByY(-80);
        translateOrc.setRate(3);
        translateOrc.setCycleCount(TranslateTransition.INDEFINITE);
        translateOrc.play();
        g.getChildren().add(orcImg1);
        Boss_Orc bossOrc = new Boss_Orc(locList[112],orcImg1); //hardcoded value
        bossOrc.setTt(translateOrc);
        locList[112].setHas_orc(true);
        locList[112].setOrc(bossOrc);

        //Placing the Queen . . .
        Image queen = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\queen.jpg");
        ImageView queenImg = new ImageView(queen);
        queenImg.setFitHeight(25);
        queenImg.setFitWidth(25);
        queenImg.setX(24300);//Notice
        queenImg.setY(225);
        queenImg.setPreserveRatio(true);
        queenImg.setSmooth(true);
        queenImg.setCache(true);
        g.getChildren().add(queenImg);

        // add one chest on falling platform

        //Clouds ... Of no use...
        int i = 1;
        while(i<122){
            Image island = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\cloud.jpeg");
            ImageView CloudImg = new ImageView(island);
            CloudImg.setFitHeight(100);
            CloudImg.setFitWidth(200);
            CloudImg.setSmooth(true);
            CloudImg.setCache(true);
            CloudImg.setX((i) * 100);
            CloudImg.setY(50);
            g.getChildren().add(CloudImg);
            i+=2;
            Image island1 = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\cloud.jpeg");
            ImageView CloudImg1 = new ImageView(island1);
            CloudImg1.setFitHeight(100);
            CloudImg1.setFitWidth(200);
            CloudImg1.setSmooth(true);
            CloudImg1.setCache(true);
            CloudImg.setX((i) * 100);
            CloudImg.setY(40);
            i+=3;
        }
        //Image fallPlat0 = new Image("C:\\Users\\ishaan\IdeaProjects\\Group_20\\src\\GameAssets\\fallPlat.jpg");
        gameScreenFixed1.getChildren().add(g);
        gameScreenFixed1.getChildren().add(g1);
    }
}