package sample;
import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
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
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class Main extends Application {
    /**
     * Along with changing the color, use a picture
     * Try using one event handler w/ inner class to alternate colors/images
     * Use if '.getSource instanceof Shape' to determine changes
     */
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
        //Scene scene = new Scene(root, 300, 275);
        GridPane ticTacToeBox = new GridPane();
        ticTacToeBox.setGridLinesVisible(true);
        ticTacToeBox.setHgap(15);
        ticTacToeBox.setVgap(15);

        /**VBox vbox = new VBox();
        VBox vbox1 = new VBox();
        vbox.setSpacing(1000);
        vbox.getChildren().addAll(box, box1, box2);
        vbox1.getChildren().addAll(box,box1, box2);
        ticTacToeBox.addColumn(1, vbox);
        ticTacToeBox.addColumn(2, vbox1);*/
        ticTacToeBox.add(box, 1, 1);
        ticTacToeBox.add(box1, 2, 1);
        ticTacToeBox.add(box2, 3, 1);
        ticTacToeBox.add(box3, 1, 2);
        ticTacToeBox.add(box4, 2,2);
        ticTacToeBox.add(box5, 3, 2);
        ticTacToeBox.add(box6, 1,3);
        ticTacToeBox.add(box7, 2, 3);
        ticTacToeBox.add(box8, 3,3);
        //Handler handle = new Handler();
        box.setOnMousePressed(e -> box.setFill(javafx.scene.paint.Color.RED));
        box1.setOnMousePressed(e -> box1.setFill(javafx.scene.paint.Color.RED));
        box2.setOnMousePressed(e -> box2.setFill(javafx.scene.paint.Color.RED));
        box3.setOnMousePressed(e -> box3.setFill(javafx.scene.paint.Color.RED));
        box4.setOnMousePressed(e -> box4.setFill(javafx.scene.paint.Color.RED));
        box5.setOnMousePressed(e -> box5.setFill(javafx.scene.paint.Color.RED));
        box6.setOnMousePressed(e -> box6.setFill(javafx.scene.paint.Color.RED));
        box7.setOnMousePressed(e -> box7.setFill(javafx.scene.paint.Color.RED));
        box8.setOnMousePressed(e -> box8.setFill(javafx.scene.paint.Color.RED));
        primaryStage.setScene(new Scene(ticTacToeBox, 300, 300));
        primaryStage.show();
    }

    /**private Rectangle createRec(int width, int height, Color desiredColor) {
        return new Rectangle(width, height, BROWN);
    }
        class Handler implements EventHandler<MouseEvent> {
            public void handle(MouseEvent e) {
               box8.setFill(javafx.scene.paint.Color.RED);
        }
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}
