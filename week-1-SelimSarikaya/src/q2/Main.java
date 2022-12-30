package q2;

public class Main {
	
    public static void main(String[] args) {
        leftTriangle(5);
        rightTriangle(5);
    }

    private static void rightTriangle(int y) {
        for (int i = 0; i < y; i++) {
            for (int l = 0; l < y; l++) {
                if (l < y - i - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }

            }
            System.out.println();
        }
    }

    private static void leftTriangle(int k) {

        for (int i = 0; i < k; i++) {
            for (int l = 0; l < i + 1; l++) {
                System.out.print("*");

            }
            System.out.println();
        }
    }
}
