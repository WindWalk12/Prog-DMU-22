package Student;


public class Student {
    private String name;
    private boolean active;
    private int age;
    
    private int[] grades; // indeholder den studerendes karakterer
    private int numberOfGrades;
    
    private static final int MAX_NUMBER_OF_GRADES = 10;
    // det hoejeste antal karakterer en studerende kan have
    
    /*
     * Constructor, naar den studerende oprettes, skal den have et navn. Ved
     * oprettelse er den studerende ikke aktiv
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.active = false;
        
        numberOfGrades = 0;
        grades = new int[MAX_NUMBER_OF_GRADES];
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public boolean isActive() {
        return active;
    }
    
    /*
     * Tilføjer en karakter til den studerende. Hvis den studerende allerede har
     * 10 karakterer registreres intet
     */
    public void addGrade(int grade) {
        if (numberOfGrades < MAX_NUMBER_OF_GRADES) {
            grades[numberOfGrades] = grade;
            numberOfGrades++;
        }
    }

    public double averageGrade() {
        int sum = 0;
        double average = 0.0;
        for (int i = 0; i < numberOfGrades; i++) {
            sum = sum + grades[i];
        }
        if (numberOfGrades > 0) {
            average = (double) sum / numberOfGrades;
        }
        return average;
    }
    
    /*
     * Returnerer alle de karakterer den studerende har opnået
     */
    public int[] getGrades() {
        return grades;
    }
    
    /*
     * Returnerer antallet af karakterer den studerende har fået
     */
    public int getNumberOfGrades() {
        return numberOfGrades;
    }

    public int maxGrade() {
        int highestGrade = 0;
        for (int i = 0; i < numberOfGrades; i++) {
            if (grades[i] > highestGrade) {
                highestGrade = grades[i];
            }
        }
        return highestGrade;
    }

    public int minGrade() {
        int lowestGrade = grades[0];
        for (int i = 0; i < numberOfGrades; i++) {
            if (grades[i] < lowestGrade) {
                lowestGrade = grades[i];
            }
        }
        return lowestGrade;
    }
}
