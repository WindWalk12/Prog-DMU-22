package Exercise5;

public class App {
    public void printFibonacciNumbers(int n) {
        int firstNumber = 0;
        int secondNumber = 1;
        int fibonacciNumber = 1;
        for (int i = 0; i < n; i++) {
            System.out.println(fibonacciNumber);
            fibonacciNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = fibonacciNumber;
        }
    }
}
