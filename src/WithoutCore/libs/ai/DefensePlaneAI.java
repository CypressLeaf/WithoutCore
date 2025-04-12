package WithoutCore.libs.ai;

import arc.math.Mathf;
import arc.util.Log;
import arc.util.Nullable;

import mindustry.entities.units.*;
import mindustry.gen.*;

public class DefensePlaneAI extends AIController {
    public @Nullable Unit shooter;
    @Override
    public void init() {
        super.init();
    }
    // 环绕母舰半径
    public float circleRadius = 120f;
    // 环绕目标半径
    public float circleTargetRadius = 10f;
    // 格斗模式
    public boolean lockTarget;
    @Override
    public void updateMovement() {
        unloadPayloads();
        if (shooter != null && !shooter.dead()) {
            if (shooter.controller() instanceof AIController shooterAI){
                try {
                    java.lang.reflect.Field targetField = AIController.class.getDeclaredField("target");
                    targetField.setAccessible(true); // 访问母舰的目标
                    this.target = (Unit) targetField.get(shooter.controller());
                }catch (Exception e){
                    //Log.err("Failed to get shooter's target: " + e);
                };
            }
            // 确保面朝的方向与环绕的圆相切
            if (unit.vel().len() > 0.1f) { // 确保有有效速度
                unit.rotation = Mathf.angle(unit.vel().x, unit.vel().y);
            }
            if (target == null) {
                // 围绕shooter做圆周运动，半径为circleRadius
                circle(shooter, circleRadius);
            } else if (target != null && unit.hasWeapons() && !lockTarget) {
                //围绕target做圆周运动
                circle(target,circleTargetRadius);
                // 确保有有效速度
                if (unit.vel().len() > 0.1f) {
                    unit.rotation = Mathf.angle(unit.vel().x, unit.vel().y);
                }
            } else if (target != null && unit.hasWeapons() && lockTarget) {
                unit.lookAt(target.x(),target.y());
                unit.moveAt(vec.trns(unit.rotation,unit.speed()));
            }
        }else if (shooter == null || shooter.dead()){unit.kill();}
    }
}
