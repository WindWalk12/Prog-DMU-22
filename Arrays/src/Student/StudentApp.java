package Student;

public class StudentApp {

	public static void main(String[] args) {
		Student peter = new Student("Peter", 20);
		Student jens = new Student("Jens", 22);
		jens.setActive(true);

		System.out.println(peter.getName() + " " + peter.getAge());
		System.out.println(jens.getName() + " " + jens.getAge());

		jens.addGrade(7);
		jens.addGrade(12);
		jens.addGrade(10);

		System.out.println(jens.getName() + " har et gennemsnit paa: " + jens.averageGrade());
		System.out.println(peter.getName() + " har et gennemsnit paa: " + peter.averageGrade());

		System.out.println("Karaktererne for " + jens.getName());
		for (int i = 0; i < jens.getNumberOfGrades(); i++) {
			System.out.println(jens.getGrades()[i]);
		}

		System.out.println("Højeste karakter for " + jens.getName() + " er " + jens.maxGrade());
		System.out.println("Mindste karakter for " + jens.getName() + " er " + jens.minGrade());
	}

}
