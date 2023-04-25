import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.println("Wellcome to Adventure Game");
        System.out.print("Please enter your character name:");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println("Wellcome "+player.getName());
        System.out.println("You can choose your character..");
        player.selectChar();
    }
}
