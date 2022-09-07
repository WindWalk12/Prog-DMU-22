package Opg6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

        Circle circle = new Circle(170, 170, 40);
        // Circle centrum 70,70 og radius 30
        pane.getChildren().add(circle);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLUE);
        circle.setStrokeWidth(5);

        Circle circle2 = new Circle(250, 170, 40);
        // Circle centrum 70,70 og radius 30
        pane.getChildren().add(circle2);
        circle2.setFill(Color.TRANSPARENT);
        circle2.setStroke(Color.BLACK);
        circle2.setStrokeWidth(5);

        Circle circle3 = new Circle(330, 170, 40);
        // Circle centrum 70,70 og radius 30
        pane.getChildren().add(circle3);
        circle3.setFill(Color.TRANSPARENT);
        circle3.setStroke(Color.RED);
        circle3.setStrokeWidth(5);

        Circle circle4 = new Circle(210, 210, 40);
        // Circle centrum 70,70 og radius 30
        pane.getChildren().add(circle4);
        circle4.setFill(Color.TRANSPARENT);
        circle4.setStroke(Color.YELLOW);
        circle4.setStrokeWidth(5);

        Circle circle5 = new Circle(290, 210, 40);
        // Circle centrum 70,70 og radius 30
        pane.getChildren().add(circle5);
        circle5.setFill(Color.TRANSPARENT);
        circle5.setStroke(Color.GREEN);
        circle5.setStrokeWidth(5);
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

