package WithoutCore.libs.Unit.UnitCreate;

import WithoutCore.libs.Unit.UnpeoplePlane;
import mindustry.gen.UnitEntity;

public class UnpeoplePlaneEntity extends UnitEntity {
    public void airLevel(int airLevel){
        airLevel = ((UnpeoplePlane) type).airLevel;
    };
}
