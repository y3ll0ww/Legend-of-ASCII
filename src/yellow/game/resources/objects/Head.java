package yellow.game.resources.objects;

public class Head extends Item {
    @Override public String getName() { return null; }
    @Override public int getLevel() { return 0; }
    @Override public int getDamage() { return 0; }
    @Override public int getMagicDamage() { return 0; }
    @Override public String getMagicType() { return null; }
    @Override public int getMatClass() { return 0; }
    @Override public int getTypeClass() { return 0; }
    @Override public boolean isTwoHanded() { return false; }
    @Override public boolean isRanged() { return false; }
    @Override public int isMagical() { return 0; }
    @Override public int getDefence() { return 0; }
    @Override public int getMagicDefence() { return 0; }

    public Head(int level, String name){
        setLevel(level);
        if (name == "no" || name == "false" || name == "none" || name == " " || name == ""){

        } else {
            setName(name);
        }
        makeHead(true);
    }
}
