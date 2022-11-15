package Exercise2;

public class Ellipse extends Circle{
    private int r2;

    public Ellipse(int x, int y, int r, int r2) {
        super(x, y, r);
        this.r2 = r2;
    }

    @Override
    public double areal() {
        return Math.PI * Math.pow(super.getR(), 2) * Math.pow(r2, 2);
    }
}
