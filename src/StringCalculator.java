import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private String[] tokens;
    private int[] numbers;

    public StringCalculator(String text) {
        tokens = parse(text);
        numbers = convert(tokens);
        validate(numbers);
    }

    public int add() {
        return Arrays.stream(numbers).sum();
    }

    private String[] parse(String text) {
        String[] tokens;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = "[" + m.group(1) + "]";
            tokens = m.group(2).split(customDelimiter);
        } else {
            tokens = text.split(",|:");
        }
        return tokens;
    }

    private int[] convert(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
    }

    private void validate(int[] numbers) {
        Arrays.stream(numbers).forEach(number -> {
            if (number < 0) {
                throw new RuntimeException("음수가 포함되어 있습니다");
            }
        });
    }
}
