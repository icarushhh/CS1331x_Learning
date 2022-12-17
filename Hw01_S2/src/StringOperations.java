public class StringOperations {
    public static void main(String[] args) {

    String myName = "Lucas Zhu";
    System.out.println(myName);

    myName = 'A' + myName.substring(1,8) + 'Z';
    System.out.println(myName);

    String anURL = new String("www.ustc.life");
    System.out.println(anURL);

    String nameOfURL = anURL.substring(4,8) + 1331;
    System.out.println(nameOfURL);

    }
}