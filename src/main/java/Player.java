import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private int damage;
    private int health;
    private int money;
    private String name;

    private Scanner scanner = new Scanner(System.in);

    public Player(String name){
        this.name=name;
        this.inventory = new Inventory();
    }

    public void selectChar(){
        GameCharacter [] characters = {new Samurai(),new Archer(),new Knight()};
        System.out.println("---------------------------");
        for (GameCharacter gameChracter: characters) {
            System.out.println("Id:"+gameChracter.getId()+
                               "\tName:"+gameChracter.getName()+
                               "\tDamage: "+gameChracter.getDamage()+
                               "\tHealth: "+gameChracter.getHealth()+
                               "\tMoney: "+gameChracter.getMoney());
        }

        System.out.println("---------------------------");
        int selectCharacter = scanner.nextInt();
        switch (selectCharacter){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;

        }
        System.out.println("Character : "+this.name+
                           " Damage : "+ this.damage+
                           " Health : "+this.health+
                           " Money : "+this.money);
    }

    public void initPlayer(GameCharacter gameCharacter){
        this.damage = gameCharacter.getDamage();
        this.health = gameCharacter.getHealth();
        this.money = gameCharacter.getMoney();
        this.name = gameCharacter.getName();
    }

    public void printInfo(){
        System.out.println("Your Weapon : "+this.getInventory().getWeapon().getName()+
                " | Your armor : "+this.getInventory().getArmor().getName()+
                " | Block : "+this.getInventory().getArmor().getBlock()+
                " | Damage : "+ this.getTotalDamage()+
                " | Health : "+this.getHealth()+
                " | Money : "+this.getMoney());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }
}

