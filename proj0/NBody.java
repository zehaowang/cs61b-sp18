public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        Integer count = in.readInt();
        in.readDouble();
        Planet[] pList = new Planet[count];
        int i = 0;
        while (i < count && !in.isEmpty()) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            pList[i] = new Planet(xP, yP, xV, yV, m, img);
            i++;
        }
        return pList;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] pList = readPlanets(filename);
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();
        StdDraw.picture(0,0,"images/starfield.jpg");
        for(Planet p: pList) {
            p.draw();
        }
        StdDraw.enableDoubleBuffering();
        double time = 0;
        for(double tt = 0; tt < T; tt = tt + dt) {
            double[] xForces = new double[pList.length];
            double[] yForces = new double[pList.length];
            for(int i = 0; i < pList.length; i++) {
                xForces[i] = pList[i].calcNetForceExertedByX(pList);
                yForces[i] = pList[i].calcNetForceExertedByY(pList);
            }
            for(int i = 0; i < pList.length; i++) {
                pList[i].update(dt, xForces[i],yForces[i]);
            }            
            StdDraw.clear();
            StdDraw.picture(0,0,"images/starfield.jpg");
            for(Planet p: pList) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        
        }
        StdOut.printf("%d\n", pList.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < pList.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          pList[i].xxPos, pList[i].yyPos, pList[i].xxVel,
                          pList[i].yyVel, pList[i].mass, pList[i].imgFileName);   
        }
    }
}
