class P {
	public int calc(int n) {
		if (n <= 1) return n;
		return calc(n - 1) + calc(n - 2);
	}
}
class C extends P {
	public int calc(int n) {
		if (n <= 1) return n;
		return calc(n - 1) + calc(n - 3);
	}
}
public class Test {
	public static void main(String[] args) {
		P obj = new C();
		System.out.print(obj.calc(7));
	}
}