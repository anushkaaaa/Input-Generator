import java.io.*;
import java.util.Scanner;

public class InputG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select one of the 4 options:\n" +
            "1. Boundary Value Analysis\n" +
            "2. Worst-case Robustness\n" +
            "3. Weak Normal Equivalence Class\n" +
            "4. Weak Robust Equivalence Class \n");
        int a = Integer.parseInt(sc.nextLine());// type of input generator
        System.out.println("Select the number of variables\n");
        int b = Integer.parseInt(sc.nextLine());// no. of. variables
        String x[] = new String[100];
        System.out.println("Enter the range of the variables");
        int i;
        for (i = 1; i <= b; i++) {
            x[i] = sc.nextLine();}
        if (a == 1)
            bva.bva(a, b, x);
        if (a == 2)
            wbva.wbva(a, b, x);
        if (a == 3)
            wet.wet(a, b, x);
        if (a == 4)
            wret.wret(a, b, x);
}
       /*
        //Read from a text file

        int i = 1;
        String x[] = new String[50];
        try {
            File file = new File("test.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int a = Integer.parseInt(bufferedReader.readLine()); //type of input generator
            int b = Integer.parseInt(bufferedReader.readLine());//no.of variable
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                x[i] = line;
                i++;
            }
            fileReader.close();

            if(a==1)
                bva.bva(a , b, x);
            if(a==2)
                wbva.wbva(a , b, x);
            if(a==3)
                wet.wet(a , b, x);
            if(a==4)
                wret.wret(a , b, x);
        } catch (IOException z) {
            z.printStackTrace();
        }*/
    }



