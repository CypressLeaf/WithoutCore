package WithoutCore.libs.ai;

import arc.util.Nullable;

import arc.math.*;
import arc.util.*;
import mindustry.entities.units.*;
import mindustry.gen.*;

public class AirCraftAI extends AIController {
    public @Nullable Unit shooter;

    public void updateMovement() {
        unloadPayloads();
        if (shooter != null && !shooter.dead()) {
            unit.lookAt(shooter.aimX, shooter.aimY);
        }
        ;
    };

    {
        if (shooter != null) {
        } else {
        }
        ;
    }
}
