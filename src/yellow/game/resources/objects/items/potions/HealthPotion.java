package yellow.game.resources.objects.items.potions;

import yellow.game.resources.objects.PlayerCharacter;

public class HealthPotion extends Potion {

    public void takePotion(){
        PlayerCharacter.setHP((int)(PlayerCharacter.getHP() * 0.2));
    }
}
