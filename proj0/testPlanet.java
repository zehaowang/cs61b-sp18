public class testPlanet {
	public static void main(String[] args) {
		Planet p1 = new Planet(0,0,1,1,5,"1.img");
		Planet p2 = new Planet(3,5,3,3,10,"2.img");
		System.out.println(p1.calcForceExertedBy(p2));
		System.out.println(p1.calcForceExertedByX(p2));
		System.out.println(p2.calcForceExertedByX(p1));
	}
}