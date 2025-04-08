package chapter06_vo;

public class InfinityObjectArray {
	private Object[] objs;

	public InfinityObjectArray() {
		objs = new Object[3];
	}

	int i = 0;

	public void add(Object s) {
		if (i == objs.length - 1) {
			Object[] temp = new Object[objs.length + 3];

			for (int j = 0; j < objs.length; j++) {
				temp[j] = objs[j];
			}

			objs = temp;
		}
		objs[i] = s;
		i++;
	}

	public void showArray() {
		for (int j = 0; j < i; j++) {
			System.out.print(objs[j] + " ");
		}
	}
}
