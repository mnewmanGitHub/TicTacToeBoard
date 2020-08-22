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
     * Find a way for the winner to be displayed immediately when they win
     * Use images instead of colors, Use Text instead of colors
     * Try out animations
     */
    private static int clickCount = 0;
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
        Handler handle = new Handler();
        box.setOnMousePressed(handle);
        box1.setOnMousePressed(handle);
        box2.setOnMousePressed(handle);
        box3.setOnMousePressed(handle);
        box4.setOnMousePressed(handle);
        box5.setOnMousePressed(handle);
        box6.setOnMousePressed(handle);
        box7.setOnMousePressed(handle);
        box8.setOnMousePressed(handle);
        primaryStage.setScene(new Scene(ticTacToeBox, 300, 300));
        primaryStage.show();
    }

    /**private Rectangle createRec(int width, int height, Color desiredColor) {
        return new Rectangle(width, height, BROWN);
    }*/
        class Handler implements EventHandler<MouseEvent> {
            public void handle(MouseEvent e) {
                //same color column 1
                if((box.getFill().equals(Color.RED) || box.getFill().equals(Color.CORNFLOWERBLUE)) && box.getFill().equals(box3.getFill()) && box.getFill().equals(box6)) {
                    System.out.println(box.getFill().toString() + " Won!");
        //same color row 1
                } else if((box.getFill().equals(Color.RED) || box.getFill().equals(Color.CORNFLOWERBLUE)) && box.getFill().equals(box1.getFill()) && box.getFill().equals(box2.getFill())) {
                    System.out.println(box.getFill().toString() + " Won!");
                } else if((box1.getFill().equals(Color.RED) || box1.getFill().equals(Color.CORNFLOWERBLUE)) && box1.getFill().equals(box4.getFill()) && box1.equals(box7.getFill())) {
                    //same color column 2
                    System.out.println(box1.getFill().toString() + " Won!");
                } else if((box3.getFill().equals(Color.RED) || box3.getFill().equals(Color.CORNFLOWERBLUE)) && box3.getFill().equals(box4.getFill()) && box3.getFill().equals(box5.getFill())) {
                    //same color row 2
                    System.out.println(box3.getFill().toString() + " Won!");
                } else if((box2.getFill().equals(Color.RED) || box2.getFill().equals(Color.CORNFLOWERBLUE)) && box2.getFill().equals(box5.getFill()) && box2.getFill().equals(box8.getFill())) {
                    //same color column 3
                    System.out.println(box2.getFill().toString() + " Won!");
                } else if((box6.getFill().equals(Color.RED) || box6.getFill().equals(Color.CORNFLOWERBLUE)) && box6.getFill().equals(box7.getFill()) && box6.getFill().equals(box8.getFill())) {
                    System.out.println(box6.getFill().toString() + " Won!");
                } else {
                Object source = e.getSource();
                if(source instanceof Shape) {
                    Shape src = (Shape) source;
                    clickCount++;
                    if (clickCount % 2 != 0) {
                        src.setFill(Color.RED);
                    } else {
                        src.setFill(Color.CORNFLOWERBLUE);
                    }
                }
                }

        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
