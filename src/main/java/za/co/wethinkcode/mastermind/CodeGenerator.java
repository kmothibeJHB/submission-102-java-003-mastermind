package za.co.wethinkcode.mastermind;

import javax.management.openmbean.ArrayType;
import java.util.Random;
import java.util.ArrayList;

public class CodeGenerator {
    private final Random random;

    public CodeGenerator(){
        this.random = new Random();
    }

    public CodeGenerator(Random random){
        this.random = random;
    }

    /**
     * Generates a random 4 digit code, using this.random, where each digit is in the range 1 to 8 only.
     * Duplicated digits are allowed.
     * @return the generated 4-digit code
     */
    public String generateCode(){
        //TODO: implement using this.random
//        CodeGenerator generated_digit = new CodeGenerator();
        int first_digit = 0;
        int second_digit = 0;
        int third_digit = 0;
        int fourth_digit = 0;
        while( first_digit == second_digit ||
                first_digit == third_digit ||
                first_digit == fourth_digit ||
                second_digit == third_digit ||
                second_digit == fourth_digit ||
                third_digit == fourth_digit) {
            first_digit = random.nextInt(8) + 1;
            second_digit = random.nextInt(8) + 1;
            third_digit = random.nextInt(8) + 1;
            fourth_digit = random.nextInt(8) + 1;
        }
        int results = (first_digit * 1000) + (second_digit * 100) + (third_digit * 10) + fourth_digit;
        return Integer.toString(results);
    }

}
