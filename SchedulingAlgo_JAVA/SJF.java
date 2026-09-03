import java.util.Scanner;

public class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("No of Process = ");
        int n = sc.nextInt();

        int[] bt = new int[n];
        int[] p = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter process ID: ");
            p[i] = sc.nextInt();

            System.out.print("Enter Burst Time: ");
            bt[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (bt[i] > bt[j]) {
                    int temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;

                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }

        wt[0] = 0;

        float total_wt = 0, total_tat = 0;

        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
            total_wt += wt[i];
        }

        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
            total_tat += tat[i];
        }

        System.out.println("\nProcess\tBurstTime\tWaitingTime\tTAT");

        for (int i = 0; i < n; i++) {
            System.out.println(p[i] + "\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }

        System.out.printf("Average Waiting Time: %.2f\n", total_wt / n);
        System.out.printf("Average TAT: %.2f\n", total_tat / n);

        sc.close();
    }
}