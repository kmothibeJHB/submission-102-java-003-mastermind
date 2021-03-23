package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CodeGeneratorTest {
    @Test
    public void generatedFourNumbers() {

        CodeGenerator generated_code = new CodeGenerator();
        String result = generated_code.generateCode();
        int length = result.length();
        assertEquals(4, length);
    }

    @Test
    public void generatedFourNumbersIsDigit() {

        CodeGenerator generated_code = new CodeGenerator();
        String result = generated_code.generateCode();
        for (int i = 0; i < 4; i++) {
            assertTrue(Character.isDigit(result.charAt(i)));
        }
    }

    @Test
    public void generatedFourNumbersIsDigitNot9() {

        CodeGenerator generated_code = new CodeGenerator();
        String result = generated_code.generateCode();
        for (int i = 0; i < 4; i++) {
            assertNotEquals(9, result.charAt(i));
        }
    }
    @Test
    public void generatedFourNumbersIsDigitNot0() {

        CodeGenerator generated_code = new CodeGenerator();
        String result = generated_code.generateCode();
        for (int i = 0; i < 4; i++) {
            assertNotEquals(0, result.charAt(i));
        }
    }

}