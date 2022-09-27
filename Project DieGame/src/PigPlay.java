import java.util.Scanner;

public class PigPlay {

    private Die die1;
    private Scanner scan;
    private boolean finished = false;
    private boolean player1Won = false;
    private boolean player1Turn = true;
    private boolean vsComputer = false;
    private int player1Points = 0;
    private int player2Points = 0;
    private int computerPoints = 0;
    private int currentPoints = 0;
    private int pointsToWin = 100;
    private int player1Throws = 0;
    private int player2Throws = 0;
    private int computerThrows = 0;

    public PigPlay() {
        die1 = new Die();
        scan = new Scanner(System.in);
    }

    public PigPlay(int pointsToWin) {
        die1 = new Die();
        scan = new Scanner(System.in);
        this.pointsToWin = pointsToWin;
    }

    public int dieEyes() {
        return die1.getFaceValue();
    }

    public void rollDie() {
        die1.roll();
    }

    public void welcomeToGame() {
        System.out.println("Velkommen til Pig spillet");
        System.out.print("Vil du gerne spille imod computeren? Ja eller nej: ");
        String goOn = scan.nextLine();
        if (goOn.equalsIgnoreCase("Ja")) {
            this.vsComputer = true;
        }
    }

    public void computerTurn() {
        System.out.println("Computeren er oppe på " + this.currentPoints + " points");
        for (int i = 0; i < (int)(Math.random()*10)+1; i++) {
            rollDie();
            this.currentPoints += dieEyes();
            System.out.println();
            System.out.println("Computeren har slået: " + dieEyes());
            System.out.println();
            if (dieEyes() == 1) {
                System.out.println("Computeren har mistet sine points svarende til " + (this.currentPoints - 1));
                System.out.println();
                this.player1Turn = true;
                this.currentPoints = 0;
                break;
            }
            else if (this.computerPoints + this.currentPoints >= this.pointsToWin) {
                this.player1Won = false;
                this.finished = true;
                break;
            }
        }
        if (dieEyes() > 1) {
            this.computerPoints += this.currentPoints;
        }
        this.currentPoints = 0;
        this.computerThrows++;
        this.player1Turn = true;
        System.out.println("Computeren er oppe på " + this.computerPoints + " points");
        System.out.println();
        if (!this.finished) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Det er nu spiller et til at kaste som er på " + this.player1Points);
            System.out.println();
        }
    }

    public void gameOver() {
        if (this.player1Won) {
            System.out.println("Spiller et har vundet");
            System.out.println();
        } else if (!this.player1Turn && !this.vsComputer) {
            System.out.println("Spiller to har vundet");
            System.out.println();
        } else {
            System.out.println("Computeren har vundet");
            System.out.println();
        }
        System.out.println("Spiller et har kastet: " + player1Throws + " gange");
        System.out.println("Spiller to har kastet: " + player2Throws + " gange");
        System.out.println("Computeren har kastet: " + computerThrows + " gange");
    }

    private void takeTurn() {
        rollDie();
        this.currentPoints += dieEyes();
        System.out.println();
        System.out.println("Du har slået: " + dieEyes());
        System.out.println();
        if (this.player1Turn) {
            if (dieEyes() == 1) {
                System.out.println("Du har mistet dine points svarende til " + (this.currentPoints - 1));
                System.out.println();
                this.player1Turn = false;
                this.currentPoints = 0;
                if (vsComputer) {
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("Det er nu computeren til at kaste som er på " + this.computerPoints);
                    System.out.println();
                    computerTurn();
                } else {
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("Det er nu spiller to til at kaste som er på " + this.player2Points);
                    System.out.println();
                }
            }
            else if (this.player1Points + this.currentPoints >= this.pointsToWin) {
                this.player1Won = true;
                this.finished = true;
            } else {
                System.out.println("Du er oppe på " + this.currentPoints + " points");
                System.out.println();
            }
            this.player1Throws++;
        } else {
            if (dieEyes() == 1) {
                System.out.println("Du har mistet dine points svarende til " + (this.currentPoints - 1));
                System.out.println();
                this.player1Turn = true;
                this.currentPoints = 0;
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("Det er nu spiller et til at kaste som er på " + this.player1Points);
                System.out.println();
            }
            else if (this.player2Points + this.currentPoints >= this.pointsToWin) {
                this.player1Won = false;
                this.finished = true;
            } else {
                System.out.println("Du er oppe på " + this.currentPoints + " points");
            }
            this.player2Throws++;
        }
    }

    public void startGame() {
        welcomeToGame();
        System.out.println();
        System.out.println("Spiller et starter");
        System.out.println();
        while (!this.finished) {
            System.out.print("Vil du kaste en terning? Eller stoppe og beholde dine points. Angiv Ja eller Nej: ");
            String goOn = scan.nextLine();
            if (goOn.equalsIgnoreCase("Nej")) {
                if (this.player1Turn) {
                    this.player1Points += this.currentPoints;
                    this.player1Turn = false;
                    System.out.println();
                    System.out.println("Spiller et er på " + this.player1Points + " points");
                    System.out.println();
                    if (!vsComputer) {
                        System.out.println("-------------------------------------------------------------------------------");
                        System.out.println("Det er nu spiller to til at kaste som er på " + this.player2Points);
                    } else {
                        System.out.println("-------------------------------------------------------------------------------");
                        System.out.println("Det er nu computeren til at kaste som er på " + this.computerPoints);
                    }
                    System.out.println();
                    this.currentPoints = 0;
                    if (vsComputer) {
                        computerTurn();
                    } else {
                        takeTurn();
                    }
                } else if (!this.player1Turn && !vsComputer) {
                    this.player2Points += this.currentPoints;
                    this.player1Turn = true;
                    System.out.println();
                    System.out.println("Spiller to er på " + this.player2Points + " points");
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("Det er nu spiller et til at kaste som er på " + this.player1Points);
                    System.out.println();
                    this.currentPoints = 0;
                    takeTurn();
                } else {
                    computerTurn();
                }
            } else {
                takeTurn();
            }
        }
        gameOver();
    }
}
