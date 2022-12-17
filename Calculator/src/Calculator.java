import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");

        String currentOp = input.next().toLowerCase();
        int intOp1 = 0;
        int intOp2 = 0;
        double doubleOp1 = 0;
        double doubleOp2  = 0;
        String strOp1;
        String strOp2;
        int strCmp = 0;

        switch (currentOp){
            case "add":
                System.out.println("Enter two integers:");

                try{
                    intOp1 = input.nextInt();
                    intOp2 = input.nextInt();
                }catch (java.util.InputMismatchException e){
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }

                System.out.printf("Answer: %d\n", intOp1+intOp2);
                break;

            case "subtract":
                System.out.println("Enter two integers:");
                try{
                    intOp1 = input.nextInt();
                    intOp2 = input.nextInt();
                }catch (java.util.InputMismatchException e){
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                System.out.printf("Answer: %d\n", intOp1-intOp2);
                break;

            case "multiply":
                System.out.println("Enter two doubles:");
                try{
                    doubleOp1 = input.nextDouble();
                    doubleOp2 = input.nextDouble();
                }catch (java.util.InputMismatchException e){
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                System.out.printf("Answer: %.2f\n", doubleOp1*doubleOp2);
                break;

            case "divide":
                System.out.println("Enter two doubles:");
                try{
                    doubleOp1 = input.nextDouble();
                    doubleOp2 = input.nextDouble();
                }catch (java.util.InputMismatchException e){
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                if (doubleOp2 == 0){
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                System.out.printf("Answer: %.2f\n", doubleOp1 / doubleOp2);
                break;

            case "alphabetize":
                System.out.println("Enter two words:");
                try{
                    strOp1 = input.next();
                    strOp2 = input.next();
                }catch (java.util.InputMismatchException e){
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                strCmp = strOp1.compareToIgnoreCase(strOp2);
                if (strCmp ==0){
                    System.out.println("Answer: Chicken or Egg.");
                }
                else if(strCmp < 0){
                    System.out.printf("Answer: %s comes before %s alphabetically.", strOp1, strOp2);
                }
                else {
                    System.out.printf("Answer: %s comes before %s alphabetically.", strOp2, strOp1);
                }
                break;

            default:
                System.out.println("Invalid input entered. Terminating...");
        }
    }
}