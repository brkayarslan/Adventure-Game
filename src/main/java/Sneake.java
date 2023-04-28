import java.util.Random;

public class Sneake extends Monster{
    private static int randomDamage = randomDamage();
    private Inventory inventory;
    public Sneake() {
        super("Sneake",4,randomDamage,12,0);
    }
    public static int randomDamage(){
        Random random = new Random();
        return random.nextInt(3,7);
    }

}
