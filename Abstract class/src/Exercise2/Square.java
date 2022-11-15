package Exercise2;

public class Square extends GeometricalFigure{
    private int s;

    public Square(int x, int y, int s) {
        super(x, y);
        this.s = s;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    @Override
    public double areal() {
        return Math.pow(s, 2);
    }

    /*
    @Override
    public void parallelShiftX(int shiftX) {
        super.setX(super.getX() + shiftX);
    }

    @Override
    public void parallelShiftY(int shiftY) {
        super.setY(super.getY() + shiftY);
    }
    */
}
