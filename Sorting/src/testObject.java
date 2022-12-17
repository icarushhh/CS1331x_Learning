public class testObject implements Comparable<testObject> {
    // instance variables
    int id;

    // constructors
    public testObject(int id){
        this.id = id;
    }

    // compareTo method
    public int compareTo(testObject o){
        return this.id - o.id;
    }

    // toString method
    public String toString(){
        return "the id is: " + id;
    }

    // test code
    public static void main(String args[]){
        testObject testObject1 = new testObject(1);
        testObject testObject2 = new testObject(2);
        System.out.println(testObject1);
        System.out.println(testObject2);
        System.out.println(testObject1.compareTo(testObject1));
        System.out.println(testObject1.compareTo(testObject2));
    }
}
