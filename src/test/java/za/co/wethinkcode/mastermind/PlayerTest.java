package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    @Test
    public void getPlayerInput(){
        byte[] inputStreamData = "1234\n".getBytes();
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);

        Player player = new Player(inputStream);
        assertEquals("1234", player.getGuess());
    }
    @Test
    public void playerInputIsFourCharacters() {
        byte[] inputStreamData = "1234\n".getBytes();
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);

        Player player = new Player(inputStream);
        assertEquals(player.getGuess().length(), 4);
    }
    @Test
    public void playerPlayerInputIsDigits() {
        for (int i = 0; i < 4; i++) {
            byte[] inputStreamData = "1234\n".getBytes();
            InputStream inputStream = new ByteArrayInputStream(inputStreamData);

            Player player = new Player(inputStream);
            boolean itsANumber = Character.isDigit(player.getGuess().charAt(i));
            assertTrue(itsANumber);
        }
    }
//    @Test
//    public void playerIsQuittingWithExit() {
//        byte[] inputStreamData = "exit\n".getBytes();
//        InputStream inputStream = new ByteArrayInputStream(inputStreamData);
//
//        Player player = new Player(inputStream);
//        player.getGuess();
//        boolean quitting =  player.wantsToQuit();
//        assertTrue(quitting);
//    }
//    @Test
//    public void playerIsQuittingWithQuit() {
//        byte[] inputStreamData = "quit\n".getBytes();
//        InputStream inputStream = new ByteArrayInputStream(inputStreamData);
//
//        Player player = new Player(inputStream);
//        player.getGuess();
//        boolean quitting =  player.wantsToQuit();
//        assertTrue(quitting);
//    }
    @Test
    public void checkCorrectPositions() {
        byte[] inputStreamData = "1234\n".getBytes();
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);

        Player player = new Player(inputStream);
        int[] arr = {0,0};
        assertEquals(arr[0], player.evaluateCode("5678")[0]);
    }
    @Test
    public void checkCorrectDigits() {
        byte[] inputStreamData = "1234\n".getBytes();
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);

        Player player = new Player(inputStream);
        int[] arr = {0,0};
        assertEquals(arr[1], player.evaluateCode("5678")[1]);
    }
    @Test
    public void codeCracked() {
        byte[] inputStreamData = "1234\n".getBytes();
        InputStream inputStream = new ByteArrayInputStream(inputStreamData);

        Player player = new Player(inputStream);
        assertEquals(4, player.evaluateCode("1234")[0]);
    }
//    @Test
//    public void printInputMessage() {
//        Player player = new Player();
//        assertEquals("Please enter exactly 4 digits (each from 1 to 8)", player.inputMessage());
//    }
//    @Test
//    public void printCongratulations() {
//        int generateCode = 1234;
//        Player player = new Player();
//
//        assertEquals(String.format("Congratulations! You are a codebreaker!\nThe code was: %d", generateCode), player.gameWonMessage(generateCode));
//    }
//    @Test
//    public void printPositions() {
//        Player player = new Player();
//        assertEquals("Number of correct digits in correct place:     0\nNumber of correct digits not in correct place: 0",
//                player.gamePlayOutput(0,0));
//    }
//    @Test
//    public void printTurnsLeft(){
//        Player player = new Player();
//        int count = 12;
//        player.printTurnsLeft(count);
//        assertEquals("Turns left: 12", outputStreamCaptor.toString().trim());
//    }
//    @Test
//    public void printIntro() {
//        CodeGenerator codeGenerator = new CodeGenerator();
//        assertEquals("4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it",
//                codeGenerator.printIntro());
//    }
    @Test
    public void turnsLeftCounter() {
        boolean numberWithinRange = false;
        Player player = new Player();
        if (0 > player.turnsLeftCounter(1) || player.turnsLeftCounter(7) < 13) {
            numberWithinRange = true;
        }
        assertTrue(numberWithinRange);
    }
}
