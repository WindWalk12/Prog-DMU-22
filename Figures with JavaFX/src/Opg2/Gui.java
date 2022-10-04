package Opg2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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
    Color yellow = Color.YELLOW;
    private void drawShapes(Pane pane) {
        Circle circle = new Circle(70 + right, 70, 30);
        // Circle centrum 70,70 og radius 30
        pane.getChildren().add(circle);
        circle.setFill(yellow);
        circle.setStroke(Color.BLACK);


        Line line = new Line(200 + right, 70, 300 + right, 70);
        pane.getChildren().add(line);
        line.setStroke(yellow);

        // Rectangle from (100,40) width 75 and height 25
        Rectangle rektangel = new Rectangle(150 + right, 40, 75, 25);
        pane.getChildren().add(rektangel);
        rektangel.setFill(yellow);
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

