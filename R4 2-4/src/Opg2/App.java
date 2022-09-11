package Opg2;

public class App {
    public static void main(String[] args) {
        // What is the value of mystery after this sequence of statements?
        //
        // It gives 0
        int mystery = 1;
        mystery = 1 - 2 * mystery;
        mystery = mystery + 1;
        System.out.println(mystery);
    }
}
