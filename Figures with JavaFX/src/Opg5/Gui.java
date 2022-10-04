package Opg5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
    private void drawShapes(Pane pane) {

        Circle circle = new Circle(170, 170, 100);
        // Circle centrum 70,70 og radius 30
        pane.getChildren().add(circle);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(20);

        Circle circle2 = new Circle(170, 170, 60);
        // Circle centrum 70,70 og radius 30
        pane.getChildren().add(circle2);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);
        circle2.setStrokeWidth(20);

        Circle circle3 = new Circle(170, 170, 20);
        // Circle centrum 70,70 og radius 30
        pane.getChildren().add(circle3);
        circle3.setFill(Color.BLACK);
        circle3.setStroke(Color.BLACK);
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

