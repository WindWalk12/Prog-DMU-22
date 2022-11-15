package Exercise2;

public abstract class GeometricalFigure {
    private int x;
    private int y;

    public GeometricalFigure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract double areal();

    public final void parallelShiftX(int shiftX) {
        setX(this.x + shiftX);
    }

    public final void parallelShiftY(int shiftY) {
        setY(this.y + shiftY);
    }
}
