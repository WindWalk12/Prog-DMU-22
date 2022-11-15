package Exercise2;

public class Rectangle extends Square{
    private int s2;

    public Rectangle(int x, int y, int s, int s2) {
        super(x, y, s);
        this.s2 = s2;
    }

    @Override
    public double areal() {
        return super.getS() * s2;
    }
}
