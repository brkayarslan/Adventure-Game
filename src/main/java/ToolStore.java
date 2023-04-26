public class ToolStore extends NormalLocation{
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        while (showMenu){
            System.out.println("Wellcome to Tool Store");
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Log out");
            System.out.print("Choose :");

            int selectCase = Location.scanner.nextInt();
            while (selectCase < 1 ||selectCase>3){
                System.out.println("Please choose new");
                selectCase = scanner.nextInt();
            }

            switch (selectCase){
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapons(){
        System.out.println("---------Weapons------ ");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId()+"-"+w.getName()+" Price : "+ w.getMoney()+ " Damage : "+w.getDamage());
        }
        System.out.println("0 - Back");
    }

    public void buyWeapon(){

        System.out.println("Choose a weapon:");
        int selectWeaponId = scanner.nextInt();
        while (selectWeaponId < 0 ||selectWeaponId> Weapon.weapons().length){
            System.out.println("Please choose new");
            selectWeaponId = scanner.nextInt();
        }

        if (selectWeaponId != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponId);
            if(selectedWeapon != null){
                if(selectedWeapon.getMoney() > this.getPlayer().getMoney()){
                    System.out.println("You don't have enough money.");
                }
                else{
                    //place of purchase.
                    System.out.println("you bought the"+selectedWeapon.getName());
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getMoney();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your remaining money : "+this.getPlayer().getMoney());
                    System.out.println("Your previous weapon :"+this.getPlayer().getInventory().getWeapon().getName());;
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("New weapon :"+this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }


    }
    public void printArmors(){
        System.out.println("-----------Armors--------");
        for (Armor a: Armor.armors()){
            System.out.println(a.getId() +" - "+ a.getName()+ " Price : "+a.getPrice()+" Armor : "+a.getBlock());
        }
        System.out.println("0 - Back");
    }

    public void buyArmor(){

        System.out.println("Choose a armor");
        int selectArmorId = scanner.nextInt();
        while (selectArmorId<0 || selectArmorId> Armor.armors().length){
            System.out.println("Please choose new");
            selectArmorId = scanner.nextInt();
        }

        if(selectArmorId != 0){
            Armor selectArmor = Armor.gerArmorObjById(selectArmorId);
            if(selectArmor != null){
                if(selectArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("You don't have enough money.");
                }
                else {
                    System.out.println("You bought the "+ selectArmor.getName());
                    int balance = this.getPlayer().getMoney() - selectArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your remaining money : "+this.getPlayer().getMoney());
                    System.out.println("Your previous armor : "+this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectArmor);
                    System.out.println("New armor : "+this.getPlayer().getInventory().getArmor().getName());

                }
            }
        }

    }
}
