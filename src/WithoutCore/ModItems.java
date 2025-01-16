package WithoutCore;

import WithoutCore.libs.MatterLib;
import arc.struct.*;
import mindustry.type.Item;
import arc.graphics.Color;

public class ModItems {
    public static MatterLib iron, chromium;

    public static final Seq<MatterLib> BerkeleysItem = new Seq<>();

    public static void load() {
        iron = new MatterLib() {
            {
                MatterLib.staticItem("iron", Color.valueOf("989AA4FF"), true, true, 0, 0, 0, 0, 0);
            }
        };
        chromium = new MatterLib() {
            {
                MatterLib.staticItem("chromium", Color.valueOf("768A9AFF"), true, true, 0, 0, 0, 0, 0);
            }
        };

        BerkeleysItem.addAll(iron, chromium);
    };
}