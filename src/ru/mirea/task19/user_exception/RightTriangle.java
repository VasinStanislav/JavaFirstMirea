package ru.mirea.task19.user_exception;

public class RightTriangle {
    private double hypotenuse;
    private double leg1, leg2;
    private double alpha, beta;

    public RightTriangle(double alpha, double beta) {
        this.hypotenuse = 5;
        this.alpha = Math.toRadians(alpha);
        this.beta = Math.toRadians(beta);

        leg1 = Math.cos(this.alpha)*hypotenuse;
        leg2 = Math.cos(this.beta)*hypotenuse;
    }

    public void setHypotenuse(double hypotenuse)    {
        double quotient = hypotenuse/this.hypotenuse;

        this.hypotenuse = hypotenuse;
        this.leg1 = leg1*quotient;
        this.leg2 = leg2*quotient;
    }

    public void setAngels(double alpha, double beta) {
        this.alpha = Math.toRadians(alpha);
        this.beta = Math.toRadians(beta);

        leg1 = Math.cos(this.alpha)*hypotenuse;
        leg2 = Math.cos(this.beta)*hypotenuse;
    }

    public double getLeg1() {
        return leg1;
    }

    public double getLeg2() {
        return leg2;
    }

    public double getHypotenuse() {
        return hypotenuse;
    }

    public double getAlpha() {
        return alpha;
    }

    public double getBeta() {
        return beta;
    }

    public double getSquare() {
        return leg1*leg2/2.0;
    }

    public double getPerimeter() {
        return leg1 + leg2 + hypotenuse;
    }

    @Override
    public String toString() {
        return "RightTriangle{" +
                "hypotenuse=" + hypotenuse +
                ", leg1=" + leg1 +
                ", leg2=" + leg2 +
                ", alpha=" + alpha +
                ", beta=" + beta +
                ", square=" + getSquare() +
                ", perimeter=" + getPerimeter() +
                '}';
    }
}
