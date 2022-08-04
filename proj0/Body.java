import examples.StdDraw;

/**
 * @Auther: stc66@qq.com
 * @Date: 2022/7/3
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    final double G = 6.67E-11;
    public String imgFileName;
    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP; yyPos = yP; xxVel = xV; yyVel = yV;
        mass = m; imgFileName = img;
    }
    public Body(Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Body other) {
        return Math.sqrt(Math.pow(xxPos-other.xxPos, 2) + Math.pow(yyPos-other.yyPos, 2));
    }

    public double calcForceExertedBy(Body other) {
        if(this.equals(other)){
            return 0;
        }
        return (G*mass*other.mass)/Math.pow(calcDistance(other), 2);
    }
    public double calcForceExertedByX(Body other) {
        if(xxPos - other.xxPos > 0) {
            return calcForceExertedBy(other)*(xxPos-other.xxPos)/calcDistance(other);
        } else {
            return calcForceExertedBy(other)*(other.xxPos-xxPos)/calcDistance(other);
        }
    }
    public double calcForceExertedByY(Body other) {
        if(yyPos - other.yyPos > 0) {
            return calcForceExertedBy(other)*(yyPos-other.yyPos)/calcDistance(other);
        }else {
            return calcForceExertedBy(other)*(other.yyPos-yyPos)/calcDistance(other);
        }

    }
    public double calcNetForceExertedByX(Body[] all_other) {
        double result = 0;
        for(Body other: all_other) {
            if(this.equals(other)) result += 0;
            else result += calcForceExertedBy(other)*(other.xxPos-xxPos)/calcDistance(other);
        }
        return result;
    }
    public double calcNetForceExertedByY(Body[] all_other) {
        double result = 0;
        for(Body other: all_other) {
            if(this.equals(other)) result += 0;
            else result += calcForceExertedBy(other)*(other.yyPos-yyPos)/calcDistance(other);
        }
        return result;
    }
    public void update(double dt, double fx, double fy) {
        double ax = fx/mass;
        double ay = fy/mass;
        double new_xxVel = xxVel + ax*dt;
        double new_yyVel = yyVel + ay*dt;
        xxPos += new_xxVel*dt;
        yyPos += new_yyVel*dt;
        xxVel = new_xxVel;
        yyVel = new_yyVel;
    }
    public void draw() {
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }
    public static double readRadius(String FileName) {
        In in = new In(FileName);
        String useless = in.readLine();
        double Radius = in.readDouble();
        in.close();
        return Radius;
    }
    public static Body[] readBodies(String FileName) {
        In in = new In(FileName);
        int total_plants = in.readInt();
        Body[] all_Body = new Body[total_plants];
        in.readLine();in.readLine();
        for(int i = 0;i<total_plants;i++) {
            all_Body[i] = new Body(in.readDouble(),in.readDouble(), in.readDouble(), in.readDouble(),in.readDouble(),in.readString());
        }
        return all_Body;
    }
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] all_body = readBodies(filename);
        double[] xForces = new double[all_body.length];
        double[] yForces = new double[all_body.length];

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();
        for(int t = 0; t <= T; t += dt) {
            StdDraw.picture(0,0,"images/starfield.jpg");
            for (int i = 0; i < all_body.length; i++) {
                xForces[i] = all_body[i].calcNetForceExertedByX(all_body);
                yForces[i] = all_body[i].calcNetForceExertedByY(all_body);
            }
            for (int i = 0; i < all_body.length; i++) {
                all_body[i].update(dt, xForces[i], yForces[i]);
            }
            for (Body each_body : all_body) {
                each_body.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
    }
}
