import java.util.Random;

public abstract class BattleLocation extends Location {

    private Monster monster;
    private String award;

    private int maxMonster;
    public BattleLocation(Player player, String name,Monster monster,String award,int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomMonsterNumber();
        System.out.println("You are here now : "+this.getName());
        System.out.println("Be careful "+ obsNumber+" "+this.getMonster().getName()+" live here.");
        System.out.println("W - war  |  E - escape");
        String selectCase = scanner.nextLine().toUpperCase();
        if(selectCase.equals("W")){
            //war
            if(combat(obsNumber)){
                System.out.println("You defeated the "+this.getMonster().getName()+" in the "+this.getName());
                return true;
            }
        }

        if (this.getPlayer().getHealth() <= 0 ){
            System.out.println("You are die!");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber){
        for(int i=1 ;i <=obsNumber;i++){
            this.getMonster().setHealth(this.getMonster().getOrjHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth()>0 && this.getMonster().getHealth() > 0){
                System.out.println("K - Kick  |  E - Escape" );
                String selectCombat = scanner.nextLine().toUpperCase();
                if(selectCombat.equals("K")){
                    System.out.println("You kick");
                    this.getMonster().setHealth(this.getMonster().getHealth()-this.getPlayer().getTotalDamage());
                    afetKick();
                    if(this.getMonster().getHealth() > 0){
                        System.out.println();
                        System.out.println(this.getMonster().getName()+ " kick you");
                        int obstacleDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afetKick();
                    }
                }
                else {
                    return false;
                }
            }
            if(this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("You defeated the "+this.getMonster().getName());
                System.out.println("You have earned "+this.getMonster().getAward() + " coins ");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getMonster().getAward());
                System.out.println("You current money is "+ this.getPlayer().getMoney()+" coins");
            }
            else {
                return false;
            }
        }
        return true;
    }

    public void afetKick(){
        System.out.println("Health : "+ this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + " health : "+this.getMonster().getHealth());
        System.out.println();
    }

    public void playerStats(){
        System.out.println("Player values :");
        System.out.println("--------------");
        System.out.println("Health : "+this.getPlayer().getHealth());
        System.out.println("Weapon : "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage : "+this.getPlayer().getTotalDamage());
        System.out.println("Armor : "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block : "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money : "+this.getPlayer().getMoney());
    }

    public void monsterStats(int i){
        System.out.println(i+"."+this.getMonster().getName()+ " values :");
        System.out.println("-----------------");
        System.out.println("Health : "+this.getMonster().getHealth());
        System.out.println("Damage : "+this.getMonster().getDamage());
        System.out.println("Award : "+this.getMonster().getAward());
    }
    public int randomMonsterNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster())+1;
    }
    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
