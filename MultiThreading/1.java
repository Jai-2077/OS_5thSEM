import java.util.Scanner;

class A1 extends Thread {
    int i, j;

    A1(int x, int y) {
        i = x;
        j = y;
    }

    public void run() {
        System.out.println("THREAD A:: ARITHMETIC OPERATIONS");
        System.out.println("SUM: " + (i + j));
        System.out.println("DIFFERENCE: " + (i - j));
        System.out.println("PRODUCT: " + (i * j));

        if (j != 0) {
            System.out.println("RATIO: " + ((double) i / j));
        } else {
            System.out.println("RATIO: Division by zero error");
        }

        System.out.println("POWER: " + Math.pow(i, j));
        System.out.println("END OF A");
    }
}

class B1 extends Thread {
    int i;

    B1(int x) {
        i = x;
    }

    public void run() {
        System.out.println("THREAD B:: TRIGONOMETRIC OPERATIONS");

        double radians = Math.toRadians(i);

        System.out.println("SINE of " + i + " degrees: " + Math.sin(radians));
        System.out.println("COSINE of " + i + " degrees: " + Math.cos(radians));
        System.out.println("TAN of " + i + " degrees: " + Math.tan(radians));
        System.out.println("SQUARE ROOT of " + i + ": " + Math.sqrt(i));
        System.out.println("END OF B");
    }
}

public class Operate {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        System.out.println("ENTER TWO VALUES FOR ARITHMETIC OPERATIONS");
        int x = s.nextInt();
        int y = s.nextInt();

        System.out.println("ENTER A VALUE FOR TRIGONOMETRIC OPERATIONS (in degrees)");
        int z = s.nextInt();

        A1 a = new A1(x, y);
        B1 b = new B1(z);

        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        s.close();
    }
}
