public class InvalidPetException extends Exception{
    public InvalidPetException(){
        super("Your pet is invalid!");
    }

    public InvalidPetException(String msg) {
        super(msg);
    }
}
