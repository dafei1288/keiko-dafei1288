package basic.knowledge.algorithm.baidu.ant;

public class CannotUnderstand {
	private static int LONG = 27;
	private int[] a = { 3, 7, 11, 17, 23 };
	private int min = 0, max = 0;

	public void gogogo() {
		for (int i = 0; i < a.length; i++) {
			min = Math.max(min, Math.min(a[i], LONG - a[i]));
			max = Math.max(max, Math.max(a[i], LONG - a[i]));
		}
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		CannotUnderstand client = new CannotUnderstand();
		client.gogogo();
		System.out.println(client.getMax());
		System.out.println(client.getMin());
	}
}