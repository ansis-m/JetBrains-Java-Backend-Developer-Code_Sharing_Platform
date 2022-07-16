import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = Integer.parseInt(scanner.nextLine());
        LocalDate date = LocalDate.ofYearDay(year, 1);

        for (int i = 0; i < 3; i++) {
            System.out.println(date.plusDays(Integer.parseInt(scanner.nextLine()) - 1));
        }


    }
}