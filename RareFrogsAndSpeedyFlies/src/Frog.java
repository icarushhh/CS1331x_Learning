import java.text.DecimalFormat;

public class Frog {
    //  instance variables
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;

    // stactic variables
    private static String species = "Rare Pepe";

    // constructors
    public Frog(String name, int age, double tongueSpeed){
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        isFroglet = (age > 1 && age < 7) ? true : false;
    }

    public Frog(String name){
        this(name, 5, 5.0);
    }

    public Frog(String name, double ageInYears, double tongueSpeed){
        this(name, (int)(12*ageInYears), tongueSpeed);
    }

    // methods
    public void grow(int growMonth){
        if (age < 12) {
            if (age + growMonth >= 12) {
                tongueSpeed += 12 - age;
            } else {
                tongueSpeed += growMonth;
            }
        }

        if (age + growMonth > 30) {
            if (age >= 30){
                tongueSpeed -= growMonth;
            }
            else {
                tongueSpeed -= age + growMonth -30;
            }

            if (tongueSpeed < 5){
                tongueSpeed = 5;
            }
        }

        age += growMonth;
        isFroglet = (age > 1 && age < 7) ? true : false;
    }

    public void grow(){
        grow(1);
    }

    public void eat(Fly aFly){
        if (aFly.isDead()){
            return;
        }

        if (tongueSpeed > aFly.getSpeed()){
            if (aFly.getMass() >= 0.5*age){
                grow(1);
            }

            aFly.setMass(0);
        }
        else {
            aFly.grow(1);
        }
    }

    public String toString(){
        DecimalFormat format1 = new DecimalFormat("0.00");
        if (isFroglet){
            return "My name is "+name+" and I’m a rare froglet! I’m "+age+" months old and my tongue has a speed of "+format1.format(tongueSpeed)+".";
        }
        else {
            return "My name is "+name+" and I’m a rare frog. I’m "+age+" months old and my tongue has a speed of "+format1.format(tongueSpeed)+".";
        }
    }

    public static String getSpecies(){
        return species;
    }

    public static void setSpecies(String speciesToSet){
        species = speciesToSet;
    }

    // test code
    public static void main(String[] args){
        Frog aTestFrog = new Frog("lalal", 5, 10.0);
        aTestFrog.grow();
        System.out.println(aTestFrog);
        aTestFrog.grow(50);
        System.out.println(aTestFrog);
    }
}
