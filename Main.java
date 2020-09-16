package sample;
import javafx.scene.effect.Glow;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
//import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import static javafx.scene.paint.Color.BROWN;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

import javax.swing.*;

public class Main extends Application {
    private static int clickCount = 0;
    private Glow glow = new Glow();
    private StackPane forTheWinner = new StackPane();
    private Label winnerName;
    private Button startOver = new Button("Restart Game");
    private TextField player1 = new TextField("Player 1");
    private TextField player2 = new TextField("Player 2");
    private Rectangle box = new Rectangle(150, 150, BROWN);
    private Rectangle box1 = new Rectangle(150, 150, BROWN);
    private Rectangle box2 = new Rectangle(150, 150, BROWN);
    private Rectangle box3 = new Rectangle(150, 150, BROWN);
    private Rectangle box4 = new Rectangle(150, 150, BROWN);
    private Rectangle box5 = new Rectangle(150, 150, BROWN);
    private Rectangle box6 = new Rectangle(150, 150, BROWN);
    private Rectangle box7 = new Rectangle(150, 150, BROWN);
    private Rectangle box8 = new Rectangle(150, 150, BROWN);

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Tic-Tac-Toe");
        startOver.setStyle("-fx-background-color: #45788b");
        //Scene scene = new Scene(root, 300, 275);
        Label label1 = new Label("Player 1:");
        Label label2 = new Label("Player 2:");
        //player1 = new TextField("Player 1 Name");
        //player2 = new TextField("Player 2 Name");
        BorderPane bP = new BorderPane();
        GridPane ticTacToeBox = new GridPane();
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        ticTacToeBox.setGridLinesVisible(true);
        ticTacToeBox.setHgap(10);
        ticTacToeBox.setVgap(10);

        ticTacToeBox.add(box, 1, 1);
        ticTacToeBox.add(box1, 2, 1);
        ticTacToeBox.add(box2, 3, 1);
        ticTacToeBox.add(box3, 1, 2);
        ticTacToeBox.add(box4, 2,2);
        ticTacToeBox.add(box5, 3, 2);
        ticTacToeBox.add(box6, 1,3);
        ticTacToeBox.add(box7, 2, 3);
        ticTacToeBox.add(box8, 3,3);
        forTheWinner.getChildren().add(ticTacToeBox);
        bP.setCenter(forTheWinner);
        RestartTheGame rS = new RestartTheGame();
        startOver.setOnAction(rS);
        hBox.getChildren().addAll(label1, player1, label2, player2, startOver);
        bP.setBottom(hBox);
        BoxHandler handle = new BoxHandler();
        box.setOnMousePressed(handle);
        box1.setOnMousePressed(handle);
        box2.setOnMousePressed(handle);
        box3.setOnMousePressed(handle);
        box4.setOnMousePressed(handle);
        box5.setOnMousePressed(handle);
        box6.setOnMousePressed(handle);
        box7.setOnMousePressed(handle);
        box8.setOnMousePressed(handle);
        primaryStage.setScene(new Scene(bP, 300, 300));
        primaryStage.show();
    }


        class BoxHandler implements EventHandler<MouseEvent> {
            public void handle(MouseEvent e) {
                if(clickCount == 0) {
                    // write a helper method
                    Object source = e.getSource();
                    if (source instanceof Shape) {
                        Shape src = (Shape) source;
                        clickCount++;
                        if (clickCount == 9) {
                            src.setFill(Color.RED);
                        } else if (clickCount % 2 != 0) {
                            src.setFill(Color.RED);
                        } else {
                            src.setFill(Color.CORNFLOWERBLUE);
                        }
                        if (isMatch()) {
                            return;
                        }
                    }
                } else {
                    if(isMatch()) {
                        return;
                    } else {
                        Object source = e.getSource();
                        if (source instanceof Shape) {
                            Shape src = (Shape) source;
                            clickCount++;
                            if (clickCount == 9) {
                                src.setFill(Color.RED);
                            } else if (clickCount % 2 != 0) {
                                src.setFill(Color.RED);
                            } else {
                                src.setFill(Color.CORNFLOWERBLUE);
                            }
                            if (isMatch()) {
                                if(clickCount % 2 != 0) {
                                    winnerName = new Label(player1.getText() + " WON!");
                                } else {
                                    winnerName = new Label(player2.getText() + " WON!");
                                }
                                winnerName.setStyle("-fx-font-size: 30 px; -fx-font-family: 'Times New Roman'");
                                winnerName.setEffect(glow);
                                forTheWinner.getChildren().add(winnerName);
                            } else {
                                if(clickCount == 9) {
                                    winnerName = new Label("DRAW");
                                    winnerName.setStyle("-fx-font-size: 50 px");
                                    winnerName.setEffect(glow);
                                    forTheWinner.getChildren().add(winnerName);
                                }
                            }
                        }
                    }
                }
            }
        }

        class RestartTheGame implements EventHandler<ActionEvent> {
            public void handle(ActionEvent e) {
                clickCount = 0;
                box.setFill(BROWN);
                box1.setFill(BROWN);
                box2.setFill(BROWN);
                box3.setFill(BROWN);
                box4.setFill(BROWN);
                box5.setFill(BROWN);
                box6.setFill(BROWN);
                box7.setFill(BROWN);
                box8.setFill(BROWN);
                forTheWinner.getChildren().remove(winnerName);

            }
        }


    private boolean isMatch() {
            //same color column 1
        if((box.getFill().equals(Color.RED) || box.getFill().equals(Color.CORNFLOWERBLUE)) && box.getFill().equals(box3.getFill()) && box.getFill().equals(box6)) {
            return true;
            //same color row 1
        } else if((box.getFill().equals(Color.RED) || box.getFill().equals(Color.CORNFLOWERBLUE)) && box.getFill().equals(box1.getFill()) && box.getFill().equals(box2.getFill())) {
            return true;
        } else if((box1.getFill().equals(Color.RED) || box1.getFill().equals(Color.CORNFLOWERBLUE)) && box1.getFill().equals(box4.getFill()) && box1.equals(box7.getFill())) {
            //same color column 2
            return true;
        } else if((box3.getFill().equals(Color.RED) || box3.getFill().equals(Color.CORNFLOWERBLUE)) && box3.getFill().equals(box4.getFill()) && box3.getFill().equals(box5.getFill())) {
            //same color row 2
            return true;
        } else if((box2.getFill().equals(Color.RED) || box2.getFill().equals(Color.CORNFLOWERBLUE)) && box2.getFill().equals(box5.getFill()) && box2.getFill().equals(box8.getFill())) {
            //same color column 3
            return true;
        } else if((box6.getFill().equals(Color.RED) || box6.getFill().equals(Color.CORNFLOWERBLUE)) && box6.getFill().equals(box7.getFill()) && box6.getFill().equals(box8.getFill())) {
            //same color row 3
            return true;
        } else if((box.getFill().equals(Color.RED)|| box.getFill().equals(Color.CORNFLOWERBLUE)) && box.getFill().equals(box4.getFill()) && box.getFill().equals(box8.getFill())) {
            //same color right diagonal
            return true;
        } else if((box2.getFill().equals(Color.RED)|| box2.getFill().equals(Color.CORNFLOWERBLUE)) && box2.getFill().equals(box4.getFill()) && box2.getFill().equals(box6.getFill())) {
            //same color left diagonal
            return true;
        }  else {
        return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

