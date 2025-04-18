package chapter04;

enum Animal {
	DOG, CAT
}

enum Person {
	MAN, WOMAN
}

public class NonSafeConst {
	public static void main(String[] args) {
		who(Person.MAN);
		who(Animal.DOG);
	}

	private static void who(Animal dog) {
		switch (dog) {
		case Animal.DOG:
			System.out.println("강아지입니다.");
			break;
		case Animal.CAT:
			System.out.println("고양이입니다.");
			break;
		}
	}

	public static void who(Person man) {
		switch (man) {
		case Person.MAN:
			System.out.println("남성 손님입니다.");
			break;
		case Person.WOMAN:
			System.out.println("여성 손님입니다.");
			break;
		}

	}

}
