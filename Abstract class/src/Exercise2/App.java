package Exercise2;

public class App {
    public static void main(String[] args) {
        Square s1 = new Square(10, 10, 5);
        Rectangle r1 = new Rectangle(25, 20, 5, 10);
        Circle c1 = new Circle(50, 20, 20);
        Ellipse e1 = new Ellipse(100, 100, 30, 40);

        System.out.println("The square is on x-coordinate: " + s1.getX() + " and on y-coordinate: " + s1.getY() + " with the areal of : " + s1.areal());
        System.out.println();

        System.out.println("The rectangle is on x-coordinate: " + r1.getX() + " and on y-coordinate: " + r1.getY() + " with the areal of : " + r1.areal());
        System.out.println();

        System.out.println("The circle is on x-coordinate: " + c1.getX() + " and on y-coordinate: " + c1.getY() + " with the areal of : " + c1.areal());
        System.out.println();

        System.out.println("The ellipse is on x-coordinate: " + e1.getX() + " and on y-coordinate: " + e1.getY() + " with the areal of : " + e1.areal());
        System.out.println();

        r1.parallelShiftX(5);
        r1.parallelShiftY(5);
        System.out.println("The rectangle is on x-coordinate: " + r1.getX() + " and on y-coordinate: " + r1.getY() + " with the areal of : " + r1.areal());
    }
}
