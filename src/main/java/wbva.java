
public class wbva {
    public  static void wbva(int t, int v, String[] x){
        int r[] = new int[100];
        int s[] = new int[50];
        int e[] = new int[50];
        int i,k=1;
        for (i = 1; i <= v; i++) {
            if (x[i].startsWith("(")) {
                s[i] = 1;
            } else
                s[i] = 0;
            if (x[i].endsWith(")")) {
                e[i] = 1;
            } else
                e[i] = 0;
            x[i] = x[i].replaceAll("[()]", "").replace("[", "").replace(" ", "").replace("]", "");
            String[] w = x[i].split(",");
            for (String j : w) {
                r[k] = Integer.parseInt(j);
                k++;
            }
        }
        int n = k;
        int rl[] = new int[100]; // Lower range
        int ru[] = new int[100]; // Upper range
        int b[][] = new int[100][10]; // for bva and wbva
        i = 1;
        for (k = 1; k < n; k = k + 2) {
            if (s[i] == 1)
                rl[i] = r[k] + 1;
            else
                rl[i] = r[k];

            if (e[i] == 1)
                ru[i] = r[k + 1] - 1;
            else
                ru[i] = r[k + 1];

            i++;
        }

        for (i = 1; i <= v; i++) {
            b[i][0] = rl[i] - 1;//min -
            b[i][1] = rl[i];// min
            b[i][2] = rl[i] + 1; // min +
            b[i][3] = ru[i] - 1; //max -
            b[i][4] = ru[i];//max
            b[i][5] = ru[i] + 1; //max +
        }
        int nom[] = new int[50];
        //nom
        for (i = 1; i <= v; i++) {
            nom[i] = (rl[i] + ru[i]) / 2;
        }
        //printing values
        System.out.println("Inputs for Worst-case Robustness are:");
        for (i = 1; i <= v; i++) {
            for (int j = 0; j < 6; j++) {
                for (k = 0; k < i; k++) {
                    if (k > 0) {
                        System.out.print(nom[k] + "\t");
                    }
                }
                System.out.print(b[i][j] + "\t");
                for (int l = i + 1; l <= v; l++) {
                    System.out.print(nom[l] + "\t");
                }

                System.out.print("\n");


            }
        }
        //print nom nom values
        for (int l = 1; l <= v; l++) {
            System.out.print(nom[l] + "\t");
        }

    }
}
