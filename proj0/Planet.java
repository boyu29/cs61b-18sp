 /**  @author Boyu Chen
 */

public class Planet{

	/**
	 * 	double xxPos: Its current x position
	 *	double yyPos: Its current y position
	 *	double xxVel: Its current velocity in the x direction
	 *	double yyVel: Its current velocity in the y direction
	 *	double mass: Its mass
	 *	String imgFileName: The name of the file that corresponds to the image that depicts the planet 	
	 *  public static final double G: Universal gravitational constant
	 */

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		// p.xxPos = this.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	/**
	 *  Calculate the distance between the current and the given Planets. 
	 *  @param Planet to be calculated
	 *  @return a double describing the distance between two Planets
	 */
	public double calcDistance(Planet p){
		double dx = this.xxPos-p.xxPos;
		double dy = this.yyPos-p.yyPos;
		return Math.sqrt(dx*dx + dy*dy);
	}

	/** Calculate the total force between the two planets.
	* @param Planet to be calculated
	* @return a double reflecting the force between the two planets.
	*/
	public double calcForceExertedBy(Planet p){
		double distance = this.calcDistance(p);
		double f = G * this.mass * p.mass / (distance*distance);
		return f;
	}

	/** Calculate the force between the planet in X direction.
	* @param Planet to be calculated
	* @return a double reflecting the force between the two planets in X direction.
	*/
	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos - this.xxPos;
		double f_x = calcForceExertedBy(p)*dx/calcDistance(p);
		return f_x;
	}

	/** Calculate the force between the planet in Y direction.
	* @param Planet to be calculated
	* @return a double reflecting the force between the two planets in Y direction.
	*/
	public double calcForceExertedByY(Planet p){
		double dy = p.yyPos - this.yyPos;
		double f_y = calcForceExertedBy(p)*dy/calcDistance(p);
		return f_y;
	}


	public double calcNetForceExertedByX(Planet[] planets){
		double net_f_x = 0.0;
		for (Planet p: planets){
			if (!this.equals(p)){
			net_f_x += calcForceExertedByX(p);
			}
		}
		return net_f_x;
	}

	public double calcNetForceExertedByY(Planet[] planets){
		double net_f_y = 0.0;
		for (Planet p: planets){
			if (!this.equals(p)){
			net_f_y += calcForceExertedByY(p);
			}
		}
		return net_f_y;
	}

	public void update(double dt, double fX, double fY){
		double a_x = fX / this.mass;
		double a_y = fY / this.mass;
		this.xxVel = this.xxVel + dt * a_x;
		this.yyVel = this.yyVel + dt * a_y;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;
	}

	public void draw(){
		String filename = "images/" + imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos, filename);
	}

}