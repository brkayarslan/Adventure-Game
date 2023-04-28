import java.util.Random;

public class Coal extends BattleLocation{

    public Coal(Player player) {
        super(player, "Coal",new Sneake(),"random",5);
    }

    @Override
    public void award() {
        Random random = new Random();
        int randomNumber = random.nextInt(0,100);
        if(randomNumber<15){
            winWeapon(randomNumber);
        } else if (randomNumber<30) {
            winArmor(randomNumber);
        } else if (randomNumber<55) {
            winMoney(randomNumber);
        }
    }

    public void winWeapon(int randomNumber){

        if(randomNumber<3){
            System.out.println("You win "+Weapon.getWeaponObjById(1).getName()+" Add this weapon to your inventory? Y-yes N-no");
            String ans = scanner.nextLine().toUpperCase();
            if(ans.equals("Y")){
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(1));
            }
        } else if (randomNumber<7) {
            System.out.println("You win "+Weapon.getWeaponObjById(2).getName()+" Add this weapon to your inventory? Y-yes N-no");
            String ans = scanner.nextLine().toUpperCase();
            if(ans.equals("Y")){
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(2));
            }
        }else {
            System.out.println("You win "+Weapon.getWeaponObjById(3).getName()+" Add this weapon to your inventory? Y-yes N-no");
            String ans = scanner.nextLine().toUpperCase();
            if(ans.equals("Y")){
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(3));
            }
        }
    }

    public void winArmor(int randomNumber){
        if(randomNumber<18){
            System.out.println("You win "+Armor.getArmorObjById(1).getName()+" Add this armor to your inventory? Y-yes N-no\"");
            String ans = scanner.nextLine();
            if(ans.equals("Y")){
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(1));
            }
        } else if (randomNumber<22) {
            System.out.println("You win "+Armor.getArmorObjById(2).getName()+" Add this armor to your inventory? Y-yes N-no\"");
            String ans = scanner.nextLine();
            if(ans.equals("Y")){
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(2));
            }
        }else {
            System.out.println("You win "+Armor.getArmorObjById(3).getName()+" Add this armor to your inventory? Y-yes N-no\"");
            String ans = scanner.nextLine();
            if(ans.equals("Y")){
                this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(3));
            }
        }
    }

    public void winMoney(int randomNumber){
        if(randomNumber <35){
            System.out.println("10$ added to your account.");
            this.getPlayer().setMoney(this.getPlayer().getMoney()+10);
        }else if(randomNumber <42){
            System.out.println("5$ added to your account.");
            this.getPlayer().setMoney(this.getPlayer().getMoney()+5);
        }else {
            System.out.println("1$ added to your account.");
            this.getPlayer().setMoney(this.getPlayer().getMoney()+1);
        }
    }

}
