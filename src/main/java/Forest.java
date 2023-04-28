public class Forest extends BattleLocation{
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "firewood",3);
    }

    @Override
    public void award() {
        super.getPlayer().getAward().setFirewood(true);
    }
}
