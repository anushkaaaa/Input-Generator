
public class wet {
    public  static void wet(int t, int v, String[] x){
        String p[] = new String[100];
        int partition_count[] = new int[20];
        int sum = 0;
        int i ,k =1;
        partition_count[0] = 0;
        for (i = 1; i <= v; i++) {
            String[] w = x[i].split(";");
            for (String j : w) {
                p[k] = j;
                k++;
            }
            // To count the no.of partitions for each variable
            partition_count[i] = k - sum - 1;
            sum = partition_count[i] + sum;
        }
        int count = k - 1;
        int r[] = new int[100];
        int z = 1;
        int s[] = new int[50];
        int e[] = new int[50];
        for (k = 1; k <= count; k++) {
            if (p[k].startsWith("(")) {
                s[k] = 1;
            } else {
                s[k] = 0;
            }
            if (p[k].endsWith(")")) {
                e[k] = 1;

            } else {
                e[k] = 0;
            }
        }
        for (k = 1; k <= count; k++) {
            p[k] = p[k].replaceAll("[()]", "").replace("[", "").replace(" ", "").replace("]", "");
            String[] w = p[k].split(",");
            for (String j : w) {
                r[z] = Integer.parseInt(j);
                z++;
            }
        }
        int n = z;

        int rl[][] = new int[100][100]; // Lower range
        int ru[][] = new int[100][100]; // Upper range
        int j = 1;
        k = 1;
        i = 1;
        for (z = 1; z < n; z = z + 2) {
            if (j <= partition_count[k]) {
                if (s[i] == 1) {
                    rl[k][j] = r[z] + 1;
                } else {
                    rl[k][j] = r[z];
                }
                if (e[i] == 1) {
                    ru[k][j] = r[z + 1] - 1;
                } else {
                    ru[k][j] = r[z + 1];
                }
                i++;
                j++;
            } else {
                j = 1;
                k++;
                z = z - 2;
            }
        }

            int nom[][] = new int[50][50];
            for (k = 1; k <= v; k++) {
                for (i = 1; i <= partition_count[k]; i++) {
                    nom[k][i] = (rl[k][i] + ru[k][i]) / 2;
                }
            }
            //printing
            System.out.println("Inputs for Weak Normal Equivalence Class are:");
            int maxp = partition_count[1];
            for (k = 1; k <= v; k++) {
                if (partition_count[k] >= maxp) {
                    maxp = partition_count[k];//maximum partition
                }
            }
            for (i = 1; i <= maxp; i++) {
                for (j = 1; j <= v; j++) {
                    if (i <= partition_count[j]) {
                        System.out.print(nom[j][i] + "\t");
                    } else {
                        System.out.print(nom[j][1] + "\t");
                    }
                }
                System.out.print("\n");
            }

    }
}
