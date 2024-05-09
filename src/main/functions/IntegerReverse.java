package main.functions;

public class IntegerReverse {
    public static void main(String[] args) {
        System.out.println(execute(2147483641));
    }

    public static int execute(int x) {
        int result = 0;
        while (x != 0) {
            int mod = x % 10;
            int temp = result;
            result = result * 10 + mod;
            if (temp != result/10) {
                return 0;
            }
            x /= 10;
        }
        return result;
    }
}
