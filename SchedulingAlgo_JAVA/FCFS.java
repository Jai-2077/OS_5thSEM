import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Enter no. of processes: ");
        n = sc.nextInt();

        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Burst time for process " + (i + 1) + ": ");
            bt[i] = sc.nextInt();
        }

        wt[0] = 0;

        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        int total_wt = 0, total_tat = 0;

        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
            total_wt += wt[i];
            total_tat += tat[i];
        }

        System.out.println("\nProcess\tBurstTime\tWaitingTime\tTAT");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }

        float avg_wt = (total_wt * 1.0f) / n;
        float avg_tat = (total_tat * 1.0f) / n;

        System.out.printf("Average Waiting time: %.2f\n", avg_wt);
        System.out.printf("Average TAT: %.2f\n", avg_tat);

        sc.close();
    }
}