public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double g = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		xxVel = p.xxVel;
		yyPos = p.yyPos;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		return Math.sqrt((this.xxPos - p.xxPos)*(this.xxPos - p.xxPos) + 
		(this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
	}

	public double calcForceExertedBy(Planet p) {
		return (g * this.mass * p.mass)/(calcDistance(p) * calcDistance(p));
	}

	public double calcForceExertedByX(Planet p) {
		return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
	}

	public double calcForceExertedByY(Planet p) {
		return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] pList) {
		double res = 0;
		for(Planet p : pList) {
			if(!this.equals(p)) {
				res += calcForceExertedByX(p);
			}
		}
		return res;
	}

	public double calcNetForceExertedByY(Planet[] pList) {
		double res = 0;
		for(Planet p : pList) {
			if(!this.equals(p)) {
				res += calcForceExertedByY(p);
			}
		}
		return res;
	}

	public void update(double dt, double fX, double fY) {
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel += aX * dt;
		yyVel += aY * dt;
		xxPos += xxVel * dt;
		yyPos += yyVel * dt;
	}

	public void draw() {
		StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
	}

}