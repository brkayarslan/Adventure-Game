public class Armor {

    private int id;
    private String Name;
    private int block;
    private int price;

    public Armor(int id, String name, int block, int price) {
        this.id = id;
        Name = name;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1,"Light", 1,15);
        armorList[1] = new Armor(2,"Medium",3,25);
        armorList[2] = new Armor(3,"Heavy",5,40);
        return armorList;
    }

    public static Armor getArmorObjById(int id){
        Armor armor = null;
        for (Armor a: Armor.armors()){
            if(a.getId() == id){
                return a;
            }
        }
        return armor;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
