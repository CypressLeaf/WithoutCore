package WithoutCore.libs.blocks;

import arc.Core;
import mindustry.gen.Iconc;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.ui.Fonts;
import mindustry.world.blocks.units.UnitFactory;

import arc.struct.Seq;

import java.util.HashSet;
import java.util.Set;

import static arc.input.KeyCode.e;

/*public class UnitConstrcuctor extends UnitBlock {
    public int[] capacities = {};

    public Seq<UnitFactory.UnitPlan> plans = new Seq<>(16);

    public int baseMaxUnitCap = 2;

    public UnitConstrcuctor(String name) {
        super(name);
        update = true;
        hasPower = true;
        hasItems = true;
        solid = true;
        configurable = true;
        clearOnDoubleTap = true;
        outputsPayload = true;
        rotate = true;
        regionRotated1 = 1;
        commandable = true;
        ambientSound = Sounds.respawning;

        config(Integer.class, (UnitFactory.UnitFactoryBuild tile, Integer i) -> {
            if(!configurable) return;

            if(tile.currentPlan == i) return;
            tile.currentPlan = i < 0 || i >= plans.size ? -1 : i;
            tile.progress = 0;
        });

        config(UnitType.class, (UnitFactory.UnitFactoryBuild tile, UnitType val) -> {
            if(!configurable) return;

            int next = plans.indexOf(p -> p.unit == val);
            if(tile.currentPlan == next) return;
            tile.currentPlan = next;
            tile.progress = 0;
        });
        consume(new ConsumeItemDynamic((UnitFactory.UnitFactoryBuild e) -> e.currentPlan != -1 ? plans.get(Math.min(e.currentPlan, plans.size - 1)).requirements : ItemStack.empty));
    };
    @Override
    public void init(){
        capacities = new int[Vars.content.items().size];
        for(UnitFactory.UnitPlan plan : plans){
            for(ItemStack stack : plan.requirements){
                capacities[stack.item.id] = Math.max(capacities[stack.item.id], stack.amount * 2);
                itemCapacity = Math.max(itemCapacity, stack.amount * 2);
            }
        }

        consumeBuilder.each(c -> c.multiplier = b -> state.rules.unitCost(b.team));

        super.init();
    }

    @Override
    public boolean outputsItems(){
        return false;
    }//禁止输出物品。
    //以上取自Anuken源代码，不知道其实际功能。
    protected Set<Integer> units = new HashSet<>();
    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{region, outRegion, topRegion};
    }
    public class UnitConstrcuctorBuild extends UnitBuild {
        public void updateTile() {
            // 清理无效单位（死亡或未加入游戏）
            units.removeIf(id -> {
                Unit unit = Groups.unit.getByID(id);
                return unit == null || unit.dead || !unit.isAdded();
            });
        };
    }
}*/
public class UnitConstrcuctor extends UnitFactory {
    //存储单位id
    protected Set<Integer> units = new HashSet<>();
    //基础的单位上限
    public int baseMaxUnitCap = 2;
    //多个不同的选择
    public Seq<UnitFactory.UnitPlan> Plans = new Seq<>(16);

    //构造一下
    public UnitConstrcuctor(String name) {
        super(name);
    }

    //重载初始化
    @Override
    public void init() {
        //初始化
        super.init();
        plans.clear();
    }

    ;

    @Override
    public void setBars() {
        super.setBars();
        //移除原版单位限制条
        removeBar("units");
        //添加自定义容量条}
        class UnitConstrcuctoBuild extends UnitFactory.UnitFactoryBuild {
            @Override
            public void updateTile() {
                super.updateTile();
            }
        }
    }
}