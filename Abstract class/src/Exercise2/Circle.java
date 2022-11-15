package Exercise2;

public class Circle extends GeometricalFigure{
    private int r;

    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public double areal() {
        return Math.PI * Math.pow(r, 2);
    }
}
