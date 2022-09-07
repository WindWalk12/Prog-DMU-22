package Opg7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;

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
    private void drawShapes(Pane pane) {

        // Rectangle from (100,40) width 75 and height 25
        Rectangle rektangel = new Rectangle(250, 250, 100, 110);
        pane.getChildren().add(rektangel);
        rektangel.setFill(Color.RED);

        Rectangle rektangel2 = new Rectangle(260, 270, 30, 30);
        pane.getChildren().add(rektangel2);
        rektangel2.setFill(Color.BLACK);

        // Polygon with 3 points (100,100)(200,100)(150,150)
        Polygon polygon = new Polygon(240, 250, 300, 100, 360, 250);
        pane.getChildren().add(polygon);
        polygon.setFill(Color.BLACK);

        Circle circle4 = new Circle(450, 50, 100);
        // Circle centrum 70,70 og radius 30
        pane.getChildren().add(circle4);
        circle4.setFill(Color.YELLOW);
        circle4.setStroke(Color.YELLOW);
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

