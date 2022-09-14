package Copier;

public class Copier {
    private int paper;
    private boolean paperJam = false;

    public Copier(int paper) {
        if (paper <= 500 && paper >= 0){
            this.paper = paper;
        } else if (paper < 0) {
            System.out.println("There can't be a negative number of papers");
        } else {
            System.out.println("Error, there is only space for 500");
        }
    }

    public void insertPaper(int paper) {
        if (paper < 0) {
            System.out.println("Error, you can't take paper out with this function");
        } else if (paper == 0) {
            System.out.println("Nice try not putting anything into the tray");
        } else if (this.paper + paper > 500) {
            System.out.println("The tray can only hold 500 papers. You can only put in " + (500 - this.paper));
        } else if (this.paper + paper <= 500) {
            this.paper += paper;
        }
    }

    public int getPaper() {
        return paper;
    }

    public void makeCopy(int copies) {
        for (int i = 0; i < copies; i++) {
            if (this.paper == 0) {
                System.out.println("Paper is missing");
                break;
            } else if (paperJam) {
                System.out.println("Error paper is jammed");
            } else {
                this.paper--;
                System.out.println("Making a copy");
            }
        }
    }

    public void makePaperJam() {
        this.paperJam = true;
    }

    public void fixJam() {
        this.paperJam = false;
    }
}
