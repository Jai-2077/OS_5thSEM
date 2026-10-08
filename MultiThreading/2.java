public class ThreadSum extends Thread {
    private int upper;
    public static int sum = 0;

    public ThreadSum(int upper) {
        this.upper = upper;
    }

    public void run() {
        for (int i = 1; i <= upper; i++) {
            sum += i;
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java ThreadSum <integer value>");
            return;
        }

        int upper = Integer.parseInt(args[0]);

        if (upper < 0) {
            System.err.println(upper + " must be >= 0");
            return;
        }

        ThreadSum t = new ThreadSum(upper);
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("argc = " + args.length);
        System.out.println("Sum = " + sum);
    }
}
