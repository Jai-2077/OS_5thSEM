import java.util.Scanner;

public class SRTF {
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

            rt[i] = bt[i];
        }

        int completed = 0;
        int time = 0;

        while (completed < n) {
            int shortest = -1;

            for (int i = 0; i < n; i++) {
                if (at[i] <= time && rt[i] > 0) {
                    if (shortest == -1 || rt[i] < rt[shortest])
                        shortest = i;
                }
            }

            if (shortest == -1) {
                time++;
                continue;
            }

            rt[shortest]--;
            time++;

            if (rt[shortest] == 0) {
                completed++;
                ct[shortest] = time;
                tat[shortest] = ct[shortest] - at[shortest];
                wt[shortest] = tat[shortest] - bt[shortest];
            }
        }

        float totalWT = 0, totalTAT = 0;

        System.out.println("\nProcess\tAT\tBT\tWT\tTAT");

        for (int i = 0; i < n; i++) {
            totalWT += wt[i];
            totalTAT += tat[i];

            System.out.println(p[i] + "\t" + at[i] + "\t" + bt[i] + "\t" +
                    wt[i] + "\t" + tat[i]);
        }

        System.out.printf("\nAverage Waiting Time = %.2f", totalWT / n);
        System.out.printf("\nAverage Turnaround Time = %.2f\n", totalTAT / n);

        sc.close();
    }
}
