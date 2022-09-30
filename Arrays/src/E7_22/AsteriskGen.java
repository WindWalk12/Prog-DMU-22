package E7_22;

public class AsteriskGen {
    private int[] inputs = {3,4,7,4,44,39};
    private String[] countries = {"Denmark", "Germany", "Egypt", "US", "Canada", "Neverland"};
    private final int maxValue = 40;
    private int count = 1;

    public void Gen() {
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(countries[i] + " ");
            for (int j = 0; j < inputs[i]; j++) {
                if (count <= maxValue) {
                    System.out.print("*");
                    count++;
                }
            }
            count = 1;
            System.out.println();
        }
    }
}
