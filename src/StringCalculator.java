import java.util.ArrayList;
import java.util.StringTokenizer;

public class StringCalculator {
    private ArrayList<Integer> numbers;

    public StringCalculator(String expression) {
        if (expression.startsWith("//")) {
            StringTokenizer stringTokenizer = new StringTokenizer(expression);
            char delimiter = stringTokenizer.nextToken().charAt(2);
            String numberString = stringTokenizer.nextToken();

            numberString = numberString.replace(delimiter, ' ');
            stringTokenizer = new StringTokenizer(numberString);
            while (stringTokenizer.hasMoreTokens()) {
                int number = Integer.parseInt(stringTokenizer.nextToken());
                if (number < 0) {
                    throw new RuntimeException("음수가 포함되어 있습니다.");
                }
                numbers.add(number);
            }
        } else {
            String numberString = expression;
            numberString = numberString.replace(';', ' ');
            numberString = numberString.replace(',', ' ');

            StringTokenizer stringTokenizer = new StringTokenizer(numberString);
            while (stringTokenizer.hasMoreTokens()) {
                int number = Integer.parseInt(stringTokenizer.nextToken());
                if (number < 0) {
                    throw new RuntimeException("음수가 포함되어 있습니다.");
                }
                numbers.add(number);
            }
        }
    }

    public int sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
