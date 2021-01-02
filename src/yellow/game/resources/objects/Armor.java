package yellow.game.resources.objects;

public class Armor extends Item {

    @Override public int isMagical() { return 0; }
    @Override public int getDamage() { return 0; }
    @Override public int getMagicDamage() { return 0; }
    @Override public String getMagicType() { return null; }
    @Override public boolean isTwoHanded() { return false; }
    @Override public boolean isRanged() { return false; }
    @Override public String getAttackName(int ix, boolean layout) { return null; }
    @Override public int getAttackNRGY(int attack) { return 0; }

    @Override public int getDefence() { return 0; }
    @Override public int getMagicDefence() { return 0; }
}
