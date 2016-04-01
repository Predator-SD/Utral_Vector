package UV.EX;
import UV.API.Transform;
public class Welcome {
	public static void main(String[] args) {
		System.out.println("====================");
		System.out.println("|   Utral Vector   |");
		System.out.println("====================");
		System.out.println("Debug Area Below:");
		double test=2.12756;
		System.out.println(test);
		double[] a=new double[4];
		a[0]=2;
		a[1]=3;
		a[2]=3;
		a[3]=3;
		Transform.Show(Transform.Plus(a, a));
	}
}
