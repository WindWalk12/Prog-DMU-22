package Modelwhile;

public class Loekker {
	public void udskriv1_10() {
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
		System.out.println("7");
		System.out.println("8");
		System.out.println("9");
		System.out.println("10");

	}

	public void udskriv1_10_iteration() {
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}
	}

	public int summer() {
		int sum = 0;
		int i = 1;
		while (i <= 10) {
			sum = sum + i;
			i++;
			
		}
		return sum;

	}

	public int summer(int n) {
		int sum = 0;
		int i = 1;
		while (i <= n) {
			sum = sum + i;
			i++;
		}
		return sum;

	}

	public int multiplum(int a, int b) {
		int resultat = 0;
		int i = 0;
		while (i < a) {
			resultat = resultat + b;
			i++;
		}
		return resultat;

	}

	public int summerEven(int n) {
		int sum = 0;
		int i = 2;
		while (i <= n) {
			sum = sum + i;
			i += 2;
		}
		return sum;
	}

	public int summerSquare(int n) {
		int sum = 0;
		int i = 1;
		while (i <= n) {
			sum += i*i;
			i++;
		}
		return sum;
	}

	public void allPowers() {
		int i = 0;
		while (i <= 20) {
			System.out.println(Math.pow(2, i));
			i++;
		}
	}

	public int sumOdd(int a, int b) {
		int sum = 0;
		if (a%2 == 0) {
			a++;
		}
		while (a <= b) {
			sum = sum + a;
			a+=2;
		}
		return sum;
	}

	public int sumOfOddDigits(int number) {
		int sum = 0;
		int i = 0;
		while (i < String.valueOf(number).length()) {
			if (Integer.parseInt(Integer.toString(number).substring(i, i + 1))%2 != 0) {
				sum += Integer.parseInt(Integer.toString(number).substring(i, i + 1));
			}
			i++;
		}
		return sum;
	}
}
