public abstract class Pet {
    // variables
    String name;
    double health;
    int painLevel;

    // constructors
    public Pet(String name, double health, int painLevel){
        this.name = name;

        if (health > 1.0){
            this.health = 1.0;
        } else if (health < 0.0) {
            this.health = 0.0;
        } else {
            this.health = health;
        }

        if (painLevel > 10){
            this.painLevel = 10;
        } else if (painLevel < 1) {
            this.painLevel = 1;
        } else {
            this.painLevel = painLevel;
        }
    }

    // methods
    public String getName(){
        return name;
    }

    public double getHealth(){
        return health;
    }

    public int getPainLevel(){
        return painLevel;
    }

    public abstract int treat();

    public void speak(){
        String message = "Hello! My name is " + name;
        if (painLevel > 5){
            System.out.println(message.toUpperCase());
        } else {
            System.out.println(message);
        }
    }

    @Override
    public boolean equals(Object o){
        try {
            Pet another = (Pet)o;
            if (another.name.equals(name)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }

    protected void heal(){
        health = 1.0;
        painLevel = 1;
    }
}
