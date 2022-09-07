package Opg3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Gui extends Application {

    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    @Override
    public void start(Stage stage) {
        Pane root = initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();

    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------
    int right = 100;
    Color blue = Color.BLUE;
    private void drawShapes(Pane pane) {

        // Rectangle from (100,40) width 75 and height 25
        Rectangle rektangel = new Rectangle(100 + right, 40, 125, 75);
        pane.getChildren().add(rektangel);
        rektangel.setFill(blue);

        // Text Datamatiker placed at 100,350
        Text text = new Text(250, 75, "Mads");
        text.setFill(Color.RED);
        pane.getChildren().add(text);
    }
/*
        // Polygon with 3 points (100,100)(200,100)(150,150)
        Polygon polygon = new Polygon(100, 100, 200, 100, 150, 150);
        pane.getChildren().add(polygon);
        polygon.setFill(Color.PINK);

        // Ellipse with centrum (70,230) radius1 50 and radius2 100
        Ellipse ellipse = new Ellipse(70, 230, 50, 100);
        pane.getChildren().add(ellipse);
        ellipse.setFill(Color.YELLOW);
        ellipse.setStroke(Color.GREEN);
        ellipse.setStrokeWidth(5);

        // Text Datamatiker placed at 100,350
        Text text = new Text(100, 350, "Datamatiker");
        text.setFill(Color.BLUEVIOLET);
        pane.getChildren().add(text);

*/


}

