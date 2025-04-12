package WithoutCore.libs.Unit;

import WithoutCore.libs.ai.DefensePlaneAI;
import arc.scene.ui.layout.Table;
import mindustry.core.UI;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.world.meta.Env;

public class UnpeoplePlane extends UnitType {
    public int airLevel = 0;
    public UnpeoplePlane(String name) {
        super(name);
        playerControllable = false;
        logicControllable = false;
        useUnitCap = false;
        allowedInPayloads = false;
        flying = true;
        hoverable = false;
        outlines = false;
        fogRadius = 2f;
        envEnabled = Env.any;
        envDisabled = Env.none;
        trailLength = 8;
        controller = u -> new DefensePlaneAI();
        constructor = () -> UnitEntity.create();
    }
    public float getTotalDPS() {
        if (weapons.isEmpty()) return 0f;
        float totalDPS = 0f;
        for (Weapon weapon : weapons) {
            if (weapon.bullet != null && weapon.reload > 0) {
                totalDPS += weapon.bullet.damage * (60f / weapon.reload);
            }
        }
        return totalDPS;
    }
}