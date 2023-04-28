public class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player, "Cave", new Zombie(),"food",3);
    }

    @Override
    public void award() {
        super.getPlayer().getAward().setFood(true);
    }
}
