public class Cat extends Pet {
    // variables
    int miceCaught;

    // constructors
    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        if (miceCaught < 0) {
            miceCaught = 0;
        }
        this.miceCaught = miceCaught;
    }

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0);
    }

    // methods
    public int getMiceCaught() {
        return miceCaught;
    }

    @Override
    public int treat() {
        heal();

        int timeTaken;
        if (miceCaught < 4) {
            timeTaken = (int)Math.ceil((painLevel*2)/health);
        } else if(miceCaught > 7) {
            timeTaken = (int)Math.ceil(painLevel/(2*health));
        } else {
            timeTaken = (int)Math.ceil(painLevel/health);
        }

        return timeTaken;
    }

    @Override
    public void speak() {
        super.speak();

        if (painLevel > 5) {
            for (int i = 0; i < painLevel; i++) {
                System.out.print("MEOW ");
            }
        } else {
            for (int i = 0; i < painLevel; i++) {
                System.out.print("meow ");
            }
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o){
        try {
            Cat another = (Cat)o;
            if (super.equals(another)) {
                if (miceCaught == another.getMiceCaught()) {
                    return true;
                }
            }
        } catch (Exception e){
            return false;
        }

        return false;
    }
}
