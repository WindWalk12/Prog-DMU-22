package Child;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public String institution() {
		if (this.age == 0) {
			return "Home";
		} else if (this.age <= 2 && this.age > 0) {
			return "Nursery";
		} else if (this.age <= 5 && this.age > 2) {
			return "Kindergarten";
		} else if (this.age <= 16 && this.age > 5) {
			return "School";
		} else {
			return "Out of school";
		}
	}

	public String gender() {
		if (boy) {
			return "Boy";
		} else {
			return "Girl";
		}
	}

	public String gender2() {
		return boy ? "Boy" : "Girl";
	}

	public String team() {
		if (!boy && this.age < 8) {
			return "Tumbling girls";
		} else if (!boy && this.age >= 8) {
			return "Springy girls";
		} else if (boy && this.age < 8) {
			return "Young cubs";
		} else {
			return "Cool boys";
		}
	}

}
