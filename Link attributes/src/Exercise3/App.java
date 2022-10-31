package Exercise3;

public class App {
    public static void main(String[] args) {
        Car c1 = new Car("Car1234", 1993);
        Car c2 = new Car("Cbr1234", 2002);
        Car c3 = new Car("Ccr1234", 2022);
        Car c4 = new Car("Cdr1234", 2003);
        Car c5 = new Car("Cer1234", 2012);

        c1.setPricePerDay(60.40);
        c2.setPricePerDay(30.56);
        c3.setPricePerDay(100.12);
        c4.setPricePerDay(120.74);
        c5.setPricePerDay(50.98);

        Rental r1 = new Rental(2, 364, "20-12-2000");
        Rental r2 = new Rental(4, 236, "10-01-2022");

        r1.addCar(c2);
        r1.addCar(c4);
        r2.addCar(c1);
        r2.addCar(c3);
        r2.addCar(c5);

        System.out.println("Prices for Rental 1");
        System.out.println(r1.getPrice());
        System.out.println();

        System.out.println("Prices for Rental 2");
        System.out.println(r2.getPrice());
    }
}
