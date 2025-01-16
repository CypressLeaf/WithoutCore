package WithoutCore.libs;

import mindustry.type.Item;
import arc.graphics.Color;

//interface staticItem(){};
public class MatterLib {
    public static void staticItem(String name, Color color, boolean unlock, boolean canbuild, float expAbility,
            float flaAbility,
            float radAbility, float chaAbility, int ness) {
        new Item(name, color) {
            {
                alwaysUnlocked = unlock;
                buildable = canbuild;
                explosiveness = expAbility;
                flammability = flaAbility;
                radioactivity = radAbility;
                charge = chaAbility;
                hardness = ness;
            }
        };
    };

    public void dynamicItem() {
    };
}
