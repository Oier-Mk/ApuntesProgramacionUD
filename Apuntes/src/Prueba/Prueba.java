package Prueba;

public class Prueba{
	public static void main(String[] args) {
		System.out.println(f(5));
		System.out.println(combinatoria(90,5));
	}	 
	static int combinatoria(int a, int b){
		return (f(a)/(f(b)*f(a-b)));
	}
	static int f(int n) {
		if(n==0)return 1;
		else {
			return n*f(n-1);
		}
	}
}
