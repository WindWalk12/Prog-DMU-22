package Exercise1;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Gift> gifts;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.gifts = new ArrayList<>();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addGift(Gift g) {
        if (!gifts.contains(g)) {
            gifts.add(g);
        }
    }

    public ArrayList<Gift> getGifts() {
        return new ArrayList<>(gifts);
    }

    public double valueOfGifts() {
        double value = 0;
        for (Gift g :gifts) {
            value += g.getPrice();
        }
        return value;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
