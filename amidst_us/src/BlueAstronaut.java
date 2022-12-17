import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate{
    // variables
    private int numTasks;
    private int taskSpeed;

    // constructors
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public BlueAstronaut(String name){
        this(name, 15, 6, 10);
    }

    // methods
    @Override
    public void completeTask() {
        if (isFrozen() || numTasks == 0){
            if (!isFrozen()){
                setSusLevel((int)(0.5*getSusLevel()));
            }
            return;
        }

        if (taskSpeed > 20){
            numTasks -= 2;
        }
        else {
            numTasks -= 1;
        }
        if (numTasks < 0){
            numTasks = 0;
        }

        if (numTasks == 0){
            System.out.println("I have completed all my tasks");
            setSusLevel((int)(0.5*getSusLevel()));
        }
    }

    public int getNumTasks(){
        return numTasks;
    }

    public int getTaskSpeed(){
        return taskSpeed;
    }

    public boolean equals(Object o){
        if (o instanceof Crewmate){
            BlueAstronaut another = (BlueAstronaut) o;
            return this.compareTo(another) == 0 &&
                    this.getName().equals(another.getName()) &&
                    this.getTaskSpeed() == another.getTaskSpeed() &&
                    this.getNumTasks() == another.getNumTasks() &&
                    this.isFrozen() == another.isFrozen();
        }

        return false;
    }

    @Override
    public void emergencyMeeting(){
        if (this.isFrozen()){
            return;
        }
        else {
            Player[] ptr = Player.getPlayers();
            Arrays.sort(ptr);
            for (int i = ptr.length-1; i >= 0 ; i--) {
                if (ptr[i].isFrozen()){
                    continue;
                }
                else {
                    int maxNotFrozen = i;
                    while (i > 0 && ptr[maxNotFrozen].compareTo(ptr[--i]) == 0){
                        if (!ptr[i].isFrozen()){
                            return;
                        }
                    }

                    ptr[maxNotFrozen].setFrozen(true);
                    break;
                }
            }
        }

        gameOver();
    }

    @Override
    public String toString(){
        String lowercase = super.toString() + "I have " + numTasks + " left over.";
        if (getSusLevel() > 15){
            return lowercase.toUpperCase();
        }
        else
            return lowercase;
    }

    // test code
    public static void main(String args[]){
        BlueAstronaut test = new BlueAstronaut("lla", 7, 0, 10);
        System.out.println(test);
        test.completeTask();
        System.out.println(test);



    }


}
