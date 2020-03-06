public class Planet {
	
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
				  double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	 public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /** calcualte the distance between two planets.*/
    public double calcDistance(Planet p) {
    	double sqrtdist = (this.xxPos - p.xxPos)*(this.xxPos - p.xxPos) + (this.yyPos - p.yyPos)*(this.yyPos - p.yyPos);
    	return Math.sqrt(sqrtdist);
    }
    /** calculate force exerted on this planet by the given planet.*/
    public double calcForceExertedBy(Planet p) {
    	double G = 6.67e-11;
    	return (G * this.mass * p.mass)/(this.calcDistance(p) * this.calcDistance(p));
    }
    /** calculate force exerted on this planet by the given planet in x direction.*/
    public double calcForceExertedByX(Planet p) {
    	double F = this.calcForceExertedBy(p);
    	double R = this.calcDistance(p);
    	double dx = p.xxPos - this.xxPos;
    	return (F * dx) / R;
    }
    /** calculate force exerted on this planet by the given planet in y direction.*/
    public double calcForceExertedByY(Planet p) {
    	double F = this.calcForceExertedBy(p);
    	double R = this.calcDistance(p);
    	double dy = p.yyPos - this.yyPos;
    	return (F * dy) / R;
    }

    public double calcNetForceExertedByX(Planet[] ps) {
    	int i = 0;
    	double Fx = 0;
    	while (i < ps.length) {
    		if (!this.equals(ps[i])) {
    			Fx += this.calcForceExertedByX(ps[i]);
    		}
    		i = i + 1;
    	}
    	return Fx;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
    	int i = 0;
    	double Fy = 0;
    	while (i < ps.length) {
    		if (!this.equals(ps[i])) {
    			Fy += this.calcForceExertedByY(ps[i]);
    		}
    		i = i + 1;
    	}
    	return Fy;
    }

    public void update(double dt, double fX, double fY) {
    	/** calculate the acceleration.*/
    	double aX = fX/this.mass;
    	double aY = fY/this.mass;
    	/** calculate the new velocity.*/
    	this.xxVel = this.xxVel + dt * aX;
    	this.yyVel = this.yyVel + dt * aY;
    	/** calculate the new position.*/
    	this.xxPos = this.xxPos + dt * this.xxVel;
    	this.yyPos = this.yyPos + dt * this.yyVel;

    }

    public void draw() {
    	String imgpath = "./images/" + this.imgFileName;
    	StdDraw.picture(this.xxPos, this.yyPos, imgpath);
    }

}