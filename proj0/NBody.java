public class NBody{
	public static double readRadius(String fileName){
		In in = new In(fileName);
		in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String fileName){
		In in = new In(fileName);
		int num = in.readInt();
		in.readDouble();
		Planet[] planets = new Planet[num];
		for (int i=0; i<planets.length;i++){
			double xxP = in.readDouble();
			double yyP = in.readDouble();
			double xxV = in.readDouble();
			double yyV = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xxP,yyP,xxV,yyV,mass,img);
		}
		return planets;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double uniRadius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		StdDraw.setScale(-uniRadius,uniRadius);
		StdDraw.clear();
		StdDraw.picture(0,0,"images/starfield.jpg");
		StdDraw.show();


		planets = readPlanets(filename);
		for(Planet k: planets){
			k.draw();
		}

		StdDraw.enableDoubleBuffering();

		double time = 0;
		while(time < T){
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for (int k=0; k<planets.length; k++){
				xForces[k] = planets[k].calcNetForceExertedByX(planets);
				yForces[k] = planets[k].calcNetForceExertedByY(planets);

			}
			for (int k=0; k<planets.length; k++){
				planets[k].update(dt, xForces[k], yForces[k]);
			}

			StdDraw.picture(0,0,"images/starfield.jpg");

			for (Planet p : planets) {
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);

			time += dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", uniRadius);
		for (int i = 0; i < planets.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}