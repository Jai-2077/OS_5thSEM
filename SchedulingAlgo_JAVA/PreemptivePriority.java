import java.util.Scanner;

public class PreemptivePriority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] p = new int[n], at = new int[n], bt = new int[n], rt = new int[n],
              wt = new int[n], tat = new int[n], ct = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Process ID: ");
            p[i] = sc.nextInt();

            System.out.print("Enter Arrival Time: ");
            at[i] = sc.nextInt();

            System.out.print("Enter Burst Time: ");
            bt[i] = sc.nextInt();

            System.out.print("Enter Priority: ");
            pr[i] = sc.nextInt();

            rt[i] = bt[i];
        }

        int completed = 0;
        int time = 0;

        while (completed < n) {
            int highest = -1;

            for (int i = 0; i < n; i++) {
                if (at[i] <= time && rt[i] > 0) {
                    if (highest == -1 || pr[i] > pr[highest])
                        highest = i;
                }
            }

            if (highest == -1) {
                time++;
                continue;
            }

            rt[highest]--;
            time++;

            if (rt[highest] == 0) {
                completed++;
                ct[highest] = time;
                tat[highest] = ct[highest] - at[highest];
                wt[highest] = tat[highest] - bt[highest];
            }
        }

        float totalWT = 0, totalTAT = 0;

        System.out.println("\nProcess\tAT\tBT\tPriority\tWT\tTAT");

        for (int i = 0; i < n; i++) {
            totalWT += wt[i];
            totalTAT += tat[i];

            System.out.println(p[i] + "\t" + at[i] + "\t" + bt[i] + "\t" +
                    pr[i] + "\t\t" + wt[i] + "\t" + tat[i]);
        }

        System.out.printf("\nAverage Waiting Time = %.2f", totalWT / n);
        System.out.printf("\nAverage Turnaround Time = %.2f\n", totalTAT / n);

        sc.close();
    }
}