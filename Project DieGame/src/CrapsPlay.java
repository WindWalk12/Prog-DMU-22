import java.util.Scanner;

public class CrapsPlay {

    private Die die1;
    private Die die2;
    private Scanner scan;
    private int countThrown = 0;
    private boolean finished = false;
    private boolean won = false;
    private boolean thrown = false;
    private int winningNumber = 0;

    public CrapsPlay() {
        die1 = new Die();
        die2 = new Die();
        scan = new Scanner(System.in);
    }

    public int sumOfDices() {
        return die1.getFaceValue() + die2.getFaceValue();
    }

    public void rollBothDices() {
        die1.roll();
        die2.roll();
    }

    public void welcomeToGame() {
        System.out.println("Velkommen til Craps spillet");
    }

    public void gameOver() {
        if (this.won) {
            System.out.println("Du har vundet");
        }
        else {
            System.out.println("Du har tabt");
        }
        scan.close();
    }

    private void takeTurn() {
        rollBothDices();
        System.out.println("Du har slået: " + sumOfDices());
        System.out.println();
        if (!thrown && (sumOfDices() == 7 || sumOfDices() == 11)) {
            this.finished = true;
            this.won = true;
        }
        else if (sumOfDices() == 2 || sumOfDices() == 3 || sumOfDices() == 12) {
            this.finished = true;
        }
        else if (this.thrown && sumOfDices() == this.winningNumber) {
            this.finished = true;
            this.won = true;
        } else if (!this.thrown) {
            this.winningNumber = sumOfDices();
            this.thrown = true;
        }
        this.countThrown++;
    }

    public void startGame() {
        welcomeToGame();
        while (!this.finished || this.countThrown == 7) {
            System.out.print("Vil du kaste en terning? Angiv Ja eller Nej: ");
            String goOn = scan.nextLine();
            if (goOn.equalsIgnoreCase("Nej")) {
                this.finished = true;
            } else {
                takeTurn();
            }
        }
        gameOver();
    }
}
