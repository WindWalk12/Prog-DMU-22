/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private String name;
	private boolean trainee;
	private int age;
	private String lastname;

	/*
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved
	 * oprettelse er den ansatte en trainee
	 */
	public Employee(String inputName, String inputLastname, int inputAge) {
		name = inputName;
		lastname = inputLastname;
		trainee = true;
		age = inputAge;
	}

	/*
	 * Den ansattes navn kan ændres ved kald af setName metoden
	 */
	public void setName(String inputName) {
		name = inputName;
	}

	/*
	 * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
	 */
	public String getName() {
		return name;
	}

	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean isTrainee) {
		trainee = isTrainee;
	}

	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {
		return trainee;
	}

	/*
		Får oplyst den ansattes alder
	 */
	public int getAge() {
		return age;
	}

	/*
		Ændre en ansats alder
	 */
	public void setAge(int inputAge) {
		age = inputAge;
	}

	public void birthday() {
		age += 1;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String inputLastname) {
		lastname = inputLastname;
	}

	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("Name " + name);
		System.out.println("Lastname " + lastname);
		System.out.println("Trainee " + trainee);
		System.out.println("Age " + age);
		System.out.println();
	}
}
