import java.util.Scanner;

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i, n, time = 0, remain, flag = 0, tq;
        int wt = 0, tat = 0;

        int[] at = new int[10];
        int[] bt = new int[10];
        int[] rt = new int[10];

        System.out.print("Enter Total Process: ");
        n = sc.nextInt();
        remain = n;

        for (i = 0; i < n; i++) {
            System.out.print("Enter Arrival Time and Burst Time for Process P" + (i + 1) + ": ");
            at[i] = sc.nextInt();
            bt[i] = sc.nextInt();
            rt[i] = bt[i];
        }

        System.out.print("Enter Time Quantum: ");
        tq = sc.nextInt();

        System.out.println("\n\nProcess\t|Turnaround Time|Waiting Time\n");

        for (time = 0, i = 0; remain != 0;) {
            if (rt[i] > 0 && at[i] <= time) {
                if (rt[i] <= tq) {
                    time += rt[i];
                    rt[i] = 0;
                    flag = 1;
                } else {
                    rt[i] -= tq;
                    time += tq;
                }

                if (rt[i] == 0 && flag == 1) {
                    remain--;

                    System.out.println("P[" + (i + 1) + "]\t|\t" +
                            (time - at[i]) + "\t|\t" +
                            (time - at[i] - bt[i]));

                    wt += time - at[i] - bt[i];
                    tat += time - at[i];
                    flag = 0;
                }
            }

            if (i == n - 1)
                i = 0;
            else if (at[i + 1] <= time)
                i++;
            else
                i = 0;
        }

        System.out.printf("\nAverage Waiting Time = %.2f\n", wt * 1.0 / n);
        System.out.printf("Average Turnaround Time = %.2f\n", tat * 1.0 / n);

        sc.close();
    }
}