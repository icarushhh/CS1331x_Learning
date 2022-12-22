import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Clinic {
    // variables
    File patientFile;
    int day;

    // constructors
    public Clinic(File file) {
        patientFile = file;
        day = 1;
    }

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    // methods
    public String nextDay(File f) throws FileNotFoundException, InvalidPetException {
        day++;
        Scanner fileScanner = null;
        Scanner userscanner = new Scanner(System.in);

        fileScanner = new Scanner(f);
        String[] splitedLine;
        String currLine;
        String promptMsg1;
        String promptMsg2;
        boolean validInput = false;
        double inputHealth = 0;
        int inputPainLevel = 0;
        int timeTaken = 0;

        String name;
        String kind;
        String specificAttribute;
        String timeIn;

        String timeOut;
        String patientInfo = "";

        while (fileScanner.hasNextLine()) {
            currLine = fileScanner.nextLine();
            splitedLine = currLine.split(",");

            name = splitedLine[0];
            kind = splitedLine[1];
            specificAttribute = splitedLine[2];
            timeIn = splitedLine[3];

            if (!kind.equals("Dog") && !kind.equals("Cat")) {
                throw new InvalidPetException();
            }

            promptMsg1 = String.format("Consultation for %s the %s at %s.\nWhat is the health of %s?\n",
                    name, kind, timeIn, name);
            System.out.print(promptMsg1);

            while (!validInput) {
                try {
                    inputHealth = userscanner.nextDouble();
                    validInput = true;
                } catch (Exception e){
                    userscanner.nextLine();
                    System.out.println("Please enter a number");
                }
            }
            userscanner.nextLine();

            promptMsg2 = String.format("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
            System.out.print(promptMsg2);

            validInput = false;
            while (!validInput) {
                try {
                     inputPainLevel = userscanner.nextInt();
                    validInput = true;
                } catch (Exception e){
                    userscanner.nextLine();
                    System.out.println("Please enter a number");
                }
            }
            userscanner.nextLine();

            if (kind.equals("Cat")) {
                Cat patientCat = new Cat(name, inputHealth, inputPainLevel, Integer.parseInt(specificAttribute));
                patientCat.speak();
                timeTaken = patientCat.treat();
                timeOut = addTime(timeIn, timeTaken);
                patientInfo += String.format("%s,%s,%d,Day %d,%d,%d,%f,%d\n",
                                            name, kind, specificAttribute, day, Integer.parseInt(timeIn), Integer.parseInt(timeOut), inputHealth, inputPainLevel);
            }
            else {
                Dog patientDog = new Dog(name, inputHealth, inputPainLevel, Double.parseDouble(specificAttribute));
                patientDog.speak();
                timeTaken = patientDog.treat();
                timeOut = addTime(timeIn, timeTaken);
                patientInfo += String.format("%s,%s,%f,Day %d,%d,%d,%f,%d\n",
                        name, kind, specificAttribute, day, Integer.parseInt(timeIn), Integer.parseInt(timeOut), inputHealth, inputPainLevel);
            }
        }

        if (fileScanner != null) {
            fileScanner.close();
        }
        if (userscanner != null) {
            userscanner.close();
        }

        return patientInfo.trim();
    }

    public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException {
        return nextDay(new File(fileName));
    }

    public boolean addToFile(String patientInfo) {
        String[] splitedInfo = patientInfo.split(",");

        String name = splitedInfo[0];
        String addInfo = "";
        for (int i = 2; i < splitedInfo.length; i++) {
            addInfo += ",";
            addInfo += splitedInfo[i];
        }

        String[] linesInTheFile = new String[100];
        int index = 0;
        Scanner fileScanner = null;

        try {
            fileScanner = new Scanner(patientFile);
            while (fileScanner.hasNextLine()) {
                linesInTheFile[index++] = fileScanner.nextLine();
            }
        } catch (FileNotFoundException fnfe) {
            return false;
        }
        if (fileScanner != null) {
            fileScanner.close();
        }

        PrintWriter fileWriter = null;
        boolean written = false;
        try {
            fileWriter = new PrintWriter(patientFile);
            for (int i = 0; i < index; i++) {
                if (name.equals(linesInTheFile[index].split(",")[0])) {
                    linesInTheFile[index] = linesInTheFile[index] + addInfo;
                    written = true;
                }
            }
            if (!written) {
                linesInTheFile[index++] = patientInfo;
                written = true;
            }

            for (int i = 0; i < index; i++) {
                fileWriter.println(linesInTheFile[index]);
            }
        } catch (FileNotFoundException fnfe) {
            return false;
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }

        return written;
    }


    private static String addTime(String timeIn, int treatmentTime){
        String timeOut;
        int intTimeIn = Integer.parseInt(timeIn);

        int minutes = intTimeIn % 100;
        minutes += treatmentTime;
        int hours = minutes / 60;
        minutes -= hours*60;

        timeOut = "" + (intTimeIn + minutes + hours*100);

        return timeOut;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("aba.c".split("\\.")));
    }
}