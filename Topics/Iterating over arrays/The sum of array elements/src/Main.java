import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines;

        scanner.nextLine();

        String[] input = scanner.nextLine().split(" ");

        int sum = 0;

        for(int i = 0; i < input.length; i++) {
            try {
                sum += Integer.parseInt(input[i]);
            }
            catch (Exception e) {
                System.out.println("input: bad format. Integers only");
            }
        }

        System.out.println(sum);

    }
}