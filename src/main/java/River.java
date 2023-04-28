public class River  extends BattleLocation{
    public River(Player player) {
        super(player, "River", new Bear(), "water",3);
    }

    @Override
    public void award() {
        super.getPlayer().getAward().setWater(true);
    }
}
