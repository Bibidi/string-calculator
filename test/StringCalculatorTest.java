import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    public void 지정구분자가_없는_문자열_계산() {
        //given
        String text = "1,3,5:7:9";
        StringCalculator stringCalculator = new StringCalculator(text);

        //when
        int sum = stringCalculator.add();

        //then
        assertEquals(25, sum);
    }

    @Test
    public void 지정구분자가_있는_문자열_계산() {
        //given
        String text = "//!\n1!3!5!7!9";
        StringCalculator stringCalculator = new StringCalculator(text);

        //when
        int sum = stringCalculator.add();

        //then
        assertEquals(25, sum);
    }

    @Test
    public void 구분자가_점인_경우_계산() {
        //given
        String text = "//.\n1.3.5.7.9";
        StringCalculator stringCalculator = new StringCalculator(text);

        //when
        int sum = stringCalculator.add();

        //then
        assertEquals(25, sum);
    }

    @Test
    public void 음수가_포함되어_있으면_오류가_발생해야한다() {
        //given
        String text = "-1,10,5,7,9";

        //when
        Exception exception = assertThrows(Exception.class,
                () -> new StringCalculator(text));

        //then
        assertEquals("음수가 포함되어 있습니다", exception.getMessage());
    }
}