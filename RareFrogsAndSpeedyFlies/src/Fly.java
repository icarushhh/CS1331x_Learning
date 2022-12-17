import java.text.DecimalFormat;

public class Fly {
    // instance variables
    private double mass;
    private double speed;

    // constructors
    public Fly(double mass, double speed){
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass){
        this(mass, 10);
    }

    public Fly(){
        this(5, 10);
    }

    // methods
    public double getMass(){
        return mass;
    }

    public double getSpeed(){
        return speed;
    }

    public void setMass(double mass){
        this.mass = mass;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public String toString(){
        DecimalFormat format1 = new DecimalFormat("0.00");
        if (isDead()){
            return "I’m dead, but I used to be a fly with a speed of " + format1.format(speed);
            // or use
//            return String.format("I’m dead, but I used to be a fly with a speed of %.2f", speed);
        }
        else {
            return "I’m a speedy fly with " + format1.format(speed) + " speed and " + format1.format(mass) + " mass.";
        }
    }

    public void grow(int growth){
        if (mass >= 20){
            mass += growth;
            speed -= 0.5 * growth;
        } else if (mass + growth > 20) {
            speed += 20-mass;
            speed -= 0.5 * (mass+growth-20);
            mass += growth;
        }else {
            mass += growth;
            speed += growth;
        }
    }

    public boolean isDead(){
        return mass == 0;
    }

    // test code
    public static void main(String[] args) {
        Fly aTestFly = new Fly(1,1);
        aTestFly.grow(10);
        System.out.println(aTestFly);
        aTestFly.grow(15);
        System.out.println(aTestFly);
    }
}