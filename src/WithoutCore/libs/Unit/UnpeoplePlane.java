package WithoutCore.libs.Units;

import WithoutCore.libs.ai.DefensePlaneAI;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.world.meta.Env;

public class UnpeoplePlane extends UnitType {
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
}