import java.util.Scanner;

public class PriorityScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Enter the number of processes: ");
        n = sc.nextInt();

        int[] p = new int[n];
        int[] bt = new int[n];
        int[] pr = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Process ID: ");
            p[i] = sc.nextInt();

            System.out.print("Enter Burst Time for Process " + p[i] + ": ");
            bt[i] = sc.nextInt();

            System.out.print("Enter Priority for Process " + p[i] + ": ");
            pr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pr[i] < pr[j]) {
                    int temp;

                    temp = pr[i];
                    pr[i] = pr[j];
                    pr[j] = temp;

                    temp = bt[i];
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

        System.out.println("\nProcess\tPriority\tBurst Time\tWaiting Time\tTurnaround Time");

        for (int i = 0; i < n; i++) {
            System.out.println(p[i] + "\t\t" + pr[i] + "\t\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }

        System.out.printf("\nAverage Waiting Time = %.2f", total_wt / n);
        System.out.printf("\nAverage Turnaround Time = %.2f\n", total_tat / n);

        sc.close();
    }
}