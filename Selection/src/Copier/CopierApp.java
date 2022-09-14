package Copier;

public class CopierApp {
    public static void main(String[] args) {
        Copier c1 = new Copier(0);
        System.out.println("");

        System.out.println("Testing insertPaper");
        c1.insertPaper(600);
        c1.insertPaper(-2);
        c1.insertPaper(2);
        System.out.println("");

        System.out.println("Testing makeCopy with paper");
        c1.makeCopy(2);
        System.out.println("");

        System.out.println("Testing makeCopy without paper");
        c1.makeCopy(2);
        System.out.println("");

        System.out.println("Testing makePaperJam");
        c1.makePaperJam();
        c1.insertPaper(200);
        c1.makeCopy(2);
        System.out.println("");

        System.out.println("Testing fixJam");
        c1.fixJam();
        c1.makeCopy(2);
    }
}
