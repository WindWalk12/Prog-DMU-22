package Child;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(4, true);// boy 4 years old
		Child c2 = new Child(2, false);// girl 2 years old
		Child c3 = new Child(9, true);
		Child c4 = new Child(10, false);

		System.out.println("Et barn på " + c1.getAge() + " Går i " + c1.institution() + " Og skal gå på spring hold: " + c1.team());
		System.out.println("Barnet er en " + c1.gender2());
		System.out.println("");

		System.out.println("Et barn på " + c2.getAge() + " Går i " + c2.institution() + " Og skal gå på spring hold: " + c2.team());
		System.out.println("Barnet er en " + c2.gender());
		System.out.println("");

		System.out.println("Et barn på " + c3.getAge() + " Går i " + c3.institution() + " Og skal gå på spring hold: " + c3.team());
		System.out.println("Barnet er en " + c3.gender());
		System.out.println("");

		System.out.println("Et barn på " + c4.getAge() + " Går i " + c4.institution() + " Og skal gå på spring hold: " + c4.team());
		System.out.println("Barnet er en " + c4.gender());
		System.out.println("");

	}

}
