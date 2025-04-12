package WithoutCore.libs;

import WithoutCore.libs.Bundle.*;
import WithoutCore.libs.Unit.UnpeoplePlane;
import WithoutCore.libs.ai.DefensePlaneAI;
import arc.scene.ui.Image;
import arc.scene.ui.layout.Table;
import arc.util.Log;
import arc.util.Scaling;
import arc.util.Time;
import mindustry.entities.units.WeaponMount;
import mindustry.gen.Groups;
import mindustry.gen.Unit;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.world.meta.Stat;

import java.util.ArrayList;


public class PlaneEjector extends Weapon {
    //设置编队最大数量
    public int maxPlane;
    //起飞的飞机
    public UnpeoplePlane plane;

    public PlaneEjector(String name) {
        super(name);
        initializePlane();
        }

    {{mountType = PlaneEjectorMount::new;}}
    // 自定义 WeaponMount 类
    public static class PlaneEjectorMount extends WeaponMount {
        public ArrayList<Integer> planes = new ArrayList<>();

        public PlaneEjectorMount(Weapon weapon) {
            super(weapon);
        }
    }

    public WeaponMount createMount() {
        return new PlaneEjectorMount(this);
    }

    //初始化plane方法
    private void initializePlane(){
        if(plane == null){
            Log.err("检测到plane为空，请正确设置plane对应的对象");
        };
    };
    @Override
    public void init(){}

    @Override
    public void addStats(UnitType unit, Table table) {
        table.row();
        table.add(new Image(plane.fullIcon)).size(32).scaling(Scaling.fit).left();
        table.row();
        table.add("[lightgray]" + Bundle.plane.localized() + ": " + "[white]" + plane.localizedName);
        table.row();
        table.add("[lightgray]" + Bundle.maxPlane + ": " + "[stat]" + maxPlane);
        table.row();
        table.add("[lightgray]" + Stat.damage.localized() + ": " + plane.getTotalDPS() + "[lightgray]" + BundleUnit.dps.localized());
    }

    @Override
    public void update(Unit unit, WeaponMount mount) {
        super.update(unit, mount);
        PlaneEjectorMount customMount = (PlaneEjectorMount) mount;
        ArrayList<Integer> planes = customMount.planes;

        // 清理无效单位ID
        for (int i = 0; i < planes.size(); i++) {
            int id = planes.get(i);
            Unit spawnedUnit = Groups.unit.getByID(id);
            if (spawnedUnit == null || spawnedUnit.dead || !spawnedUnit.isAdded()) {
                planes.remove(i);
                i--; // 调整索引
            }
        }

        //等待reload次刷新后
        mount.reload = Math.max(mount.reload - Time.delta * unit.reloadMultiplier, 0);
        // 检查是否允许生成新单位
        if (planes.size() < maxPlane && mount.reload <= 0) {
            if (bullet != null && maxPlane - planes.size() > 0 && plane != null) {
                for (int a = 0; a <= maxPlane - planes.size(); a++) {
                    Unit spawnedUnit = plane.create(unit.team);
                    spawnedUnit.set(unit.x+x+shootX, unit.y+y+shootY); // 设置生成位置
                    spawnedUnit.rotation = unit.rotation;
                    spawnedUnit.add();
                    spawnedUnit.move(unit.rotation,4f);
                    planes.add(spawnedUnit.id); // 记录ID
                    /*调试代码，检查功能是否正常
                    Log.info("Spawning unit: @, shooter: @", spawnedUnit, unit);
                    Log.info("编队数量：", planes.size());
                    mount.reload = reload; // 重置装填*/
                    //单位生成时初始化DefensePlaneAI中的shooter
                    if (spawnedUnit.controller() instanceof DefensePlaneAI ai) {
                        //((DefensePlaneAI) spawnedUnit.controller()).shooter = unit;
                        ai.shooter = unit;
                        ai.init();
                    }
                }
        }else if(planes.size() >= maxPlane) {}
        }
    }
}