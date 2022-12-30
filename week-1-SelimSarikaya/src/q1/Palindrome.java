package q1;


public class Palindrome {

    public static void main(String[] args) {

        addForPolindrome(10, 100);

    }

    static boolean isPalindrome(long num) {
        long reverse = reverseMethod(num);
        if (reverse == num) {
            return true;
        } else {
            return false;
        }
    }

    private static long reverseMethod(long num) {
        long reverse = 0;
        long temp = 0;
        while (num != 0) {
            temp = num % 10;
            reverse = (reverse * 10) + temp;
            num = num / 10;
        }
        return reverse;
    }

    static void addForPolindrome(long start, long end) {
        int maxCyle = 1;
        long temp = 0;
        for (long i = start; i <= end; i++) {
            int counter = 0;
            search: while (!isPalindrome(i)) {
                long j = i;
                while (!isPalindrome(j)) {
                    counter++;
                    long reverse = reverseMethod(j);
                    long sum = j + reverse;
                    if (isPalindrome(sum)) {
                        break search;
                    } else {
                        j = sum;
                    }
                }
            }
            if (maxCyle < counter) {
                maxCyle = counter;
                temp = i;
            }
        }

        System.out.println("En uzun zincirin olustugu sayi :" + temp);
        searchlong: while (!isPalindrome(temp)) {

            long reverse = reverseMethod(temp);
            long sum = temp + reverse;
            if (isPalindrome(sum)) {
                System.out.println(temp + " + " + reverse + " = " + sum);
                // counter++;
                break searchlong;
            } else {
                System.out.println(temp + " + " + reverse + " = " + sum);
                temp = sum;
            }
            // counter++;

        }
        System.out.println("Max Cycle : " + maxCyle);

    }
}
