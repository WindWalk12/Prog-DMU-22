package Exercise1;

public class App {
    public static void main(String[] args) {
        Gift g1 = new Gift("Den bedste gave fra gaveboden");
        Gift g2 = new Gift("Den mindre gode gave fra gaveboden");
        Gift g3 = new Gift("Den væreste gave fra gaveboden");

        g1.setPrice(999.99);
        g2.setPrice(399.99);
        g3.setPrice(1);

        Person p = new Person("Dennis", 20);

        p.addGift(g1);
        p.addGift(g2);
        p.addGift(g3);

        System.out.println(p.valueOfGifts());
    }

}
