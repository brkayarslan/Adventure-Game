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

        Location location = null;

        while (true){
            player.printInfo();
            System.out.println("Locations:");
            System.out.println("1 - Safe House");
            System.out.println("2 - Tool Store");
            System.out.println("3 - Cave");
            System.out.println("4 - Forest");
            System.out.println("5 - River");
            System.out.println("6 - Coal");
            System.out.println("0 - Log Out");
            System.out.print("Please choise a location:");

            int chooseLocation = scanner.nextInt();

            while(player.getAward().getFood() == true && chooseLocation == 3){
                System.out.println("Received awards in this region. Please select another region.");
                chooseLocation = scanner.nextInt();
            }
            while(player.getAward().getFirewood() == true && chooseLocation == 3){
                System.out.println("Received awards in this region. Please select another region.");
                chooseLocation = scanner.nextInt();
            }
            while(player.getAward().getWater() == true && chooseLocation == 3){
                System.out.println("Received awards in this region. Please select another region.");
                chooseLocation = scanner.nextInt();
            }
            switch (chooseLocation){
                case 0:
                    location = null;
                    break;
                case 1: {
                    location = new SafeHouse(player);
                    break;
                }
                case 2: {
                    location = new ToolStore(player);
                    break;
                }
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Coal(player);
                    break;
                default:{
                    location = new SafeHouse(player);
                }
            }

            if(player.getAward().getWater() == true && player.getAward().getFirewood() == true && player.getAward().getFood() == true){
                System.out.println("!! YOU ARE WİN THE GAME  !!");
                break;
            }
            if(location == null){
                System.out.println("See you later comander.");
                break;
            }
            if (!location.onLocation() ){
                System.out.println("Game Over");
                break;
            }
        }

    }
}
