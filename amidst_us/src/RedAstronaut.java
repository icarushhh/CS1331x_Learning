import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    // variables
    private String skill;

    // constructors
    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    public RedAstronaut(String name){
        this(name, 15, "experienced");
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
                    int maxNotFrozen;
                    if (ptr[i].equals(this)){
                        maxNotFrozen = i-1;
                    }
                    else
                        maxNotFrozen = i;

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
    public void freeze(Player p) {
        if (isFrozen() || p instanceof Impostor || p.isFrozen()){
            return;
        }

        if (this.compareTo(p) < 0){
            p.setFrozen(true);
        }
        else {
            setSusLevel(2*getSusLevel());
        }
        gameOver();
    }

    @Override
    public void sabotage(Player p) {
        if (isFrozen() || p instanceof Impostor || p.isFrozen()){
            return;
        }

        if (getSusLevel() < 20){
            p.setSusLevel((int) (1.5*p.getSusLevel()));
        }
        else {
            p.setSusLevel((int) (1.25*p.getSusLevel()));
        }
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Impostor){
            RedAstronaut another = (RedAstronaut) o;
            return this.compareTo(another) == 0 &&
                    this.getName().equals(another.getName()) &&
                    this.skill.equals(another.getSkill()) &&
                    this.isFrozen() == another.isFrozen();
        }

        return false;
    }

    @Override
    public String toString(){
        String lowercase = super.toString() + "I am an " + skill + " player!";
        if (getSusLevel() > 15){
            return lowercase.toUpperCase();
        }
        else
            return lowercase;
    }

    public String getSkill(){
        return skill;
    }

    // test code
    public static void main(String args[]){


    }
}
