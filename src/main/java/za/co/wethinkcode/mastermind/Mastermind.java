package za.co.wethinkcode.mastermind;

public class Mastermind {
    private final String code;
    private final Player player;

    public Mastermind(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;
    }
    public Mastermind(){
        this(new CodeGenerator(), new Player());
    }

    public void runGame(){
        //TODO: implement the main run loop logic
        /**
         * Runs the game
         */
        String generatedCode = code;
        int count = 11;
        player.printIntro();
        int[] inputCode = player.evaluateCode(generatedCode);
        player.gamePlayOutput(inputCode[0], inputCode[1]);
        if(inputCode[0] == 4) {
            System.out.println("Number of correct digits in correct place: 4\nNumber of correct digits not in correct place: 0");
            player.gameWonMessage(code);
        }
        while(!(player.turnsLeftCounter(count) == 0) ) {
            player.printTurnsLeft(player.turnsLeftCounter(count));
            inputCode = player.evaluateCode(generatedCode);
            if(inputCode[0] == 4) {
                System.out.println("Number of correct digits in correct place: 4\nNumber of correct digits not in correct place: 0");
                player.gameWonMessage(code);
                break;
            }
            player.gamePlayOutput(inputCode[0], inputCode[1]);
            count--;
        }
        if(count <= 0){
            System.out.printf("No more turns left.\nThe code was: %s%n", generatedCode);
        }
    }

    public static void main(String[] args){
        /**
         * Starts the game
         */
        Mastermind game = new Mastermind();
        game.runGame();
    }
}
