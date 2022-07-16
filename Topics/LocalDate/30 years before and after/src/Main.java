import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int year = Integer.parseInt(scanner.nextLine());
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.println(date.minusYears(30));
        System.out.println(date.plusYears(30));
    }
}