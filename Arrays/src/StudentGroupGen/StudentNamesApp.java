package StudentGroupGen;

public class StudentNamesApp {
    public static void main(String[] args) {
        StudentNames s = new StudentNames(5);
        s.genGroups2();
        s.printGroups();
        System.out.println(s.findNotNull());
    }
}
