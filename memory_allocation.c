#include <stdio.h>

int main() {
    int block[20], process[20], allocation[20];
    int nb, np, choice;
    int i, j, best, worst;

    printf("Enter number of memory blocks: ");
    scanf("%d", &nb);

    printf("Enter size of each block:\n");
    for (i = 0; i < nb; i++)
        scanf("%d", &block[i]);

    printf("Enter number of processes: ");
    scanf("%d", &np);

    printf("Enter size of each process:\n");
    for (i = 0; i < np; i++)
        scanf("%d", &process[i]);

    printf("\n1. First Fit");
    printf("\n2. Best Fit");
    printf("\n3. Worst Fit");
    printf("\nEnter your choice: ");
    scanf("%d", &choice);

    for (i = 0; i < np; i++)
        allocation[i] = -1;

    if (choice == 1) {
        for (i = 0; i < np; i++) {
            for (j = 0; j < nb; j++) {
                if (block[j] >= process[i]) {
                    allocation[i] = j;
                    block[j] -= process[i];
                    break;
                }
            }
        }
    }

    else if (choice == 2) {
        for (i = 0; i < np; i++) {
            best = -1;

            for (j = 0; j < nb; j++) {
                if (block[j] >= process[i]) {
                    if (best == -1 || block[j] < block[best])
                        best = j;
                }
            }

            if (best != -1) {
                allocation[i] = best;
                block[best] -= process[i];
            }
        }
    }

    else if (choice == 3) {
        for (i = 0; i < np; i++) {
            worst = -1;

            for (j = 0; j < nb; j++) {
                if (block[j] >= process[i]) {
                    if (worst == -1 || block[j] > block[worst])
                        worst = j;
                }
            }

            if (worst != -1) {
                allocation[i] = worst;
                block[worst] -= process[i];
            }
        }
    }

    else {
        printf("Invalid choice\n");
        return 0;
    }

    printf("\nProcess\tSize\tBlock\n");

    for (i = 0; i < np; i++) {
        printf("P%d\t%d\t", i + 1, process[i]);

        if (allocation[i] != -1)
            printf("B%d\n", allocation[i] + 1);
        else
            printf("Not Allocated\n");
    }

    printf("\nUnused space in each block:\n");

    for (i = 0; i < nb; i++) {
        printf("B%d = %d\n", i + 1, block[i]);
    }

    return 0;
}