package binary;

public class InfiniteLoop {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            i++;
            Thread.sleep(1000);
            System.out.println(i);
        }
    }
}
