public class Dog extends Pet{
    // variables
    double droolRate;

    // constructors
    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            this.droolRate = 0.5;
        } else {
            this.droolRate = droolRate;
        }
    }

    public Dog(String name, double health, int painLevel){
        this(name, health, painLevel, 5.0);
    }

    // methods
    public double getDroolRate(){
        return droolRate;
    }

    @Override
    public int treat() {
        heal();
        int timeTaken;
        if (droolRate < 3.5){
            timeTaken = (int)Math.ceil((painLevel*2)/health);
        } else if(droolRate > 7.5) {
            timeTaken = (int)Math.ceil(painLevel/(2*health));
        } else {
            timeTaken = (int)Math.ceil(painLevel/health);
        }

        return timeTaken;
    }

    @Override
    public void speak(){
        super.speak();

        if (painLevel > 5) {
            for (int i = 0; i < painLevel; i++) {
                System.out.print("BARK ");
            }
        } else {
            for (int i = 0; i < painLevel; i++) {
                System.out.print("bark ");
            }
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o){
        try {
            Dog another = (Dog)o;
            if (super.equals(another)) {
                if (droolRate == another.getDroolRate()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }
}
