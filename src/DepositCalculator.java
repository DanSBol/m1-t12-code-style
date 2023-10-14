import java.util.Scanner;

public class DepositCalculator {
    private final double YEAR_RATE = 0.06;

    double calculateWithCapitalization(int amount, int depositPeriod) {
        double pay = amount * Math.pow((1 + YEAR_RATE / 12), 12 * depositPeriod);

        return round(pay);
    }

    double calculateWithoutCapitalization(double amount, int depositPeriod) {
        return round(amount + amount * YEAR_RATE * depositPeriod);
    }

    double round(double value) {
        int EXPONENT = 2;
        double scale = Math.pow(10, EXPONENT);

        return Math.round(value * scale) / scale;
    }

    void getFinResult() {
        int depositPeriod;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double finResult = 0;

        if (action == 1) {
            finResult = calculateWithoutCapitalization(amount, depositPeriod);
        } else if (action == 2) {
            finResult = calculateWithCapitalization(amount, depositPeriod);
        }

        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + finResult);
    }

    public static void main(String[] args) {
        new DepositCalculator().getFinResult();
    }
}
