package WithoutCore.libs.bullet;
import WithoutCore.libs.Unit.UnitCreate.UnpeoplePlaneEntity;
import WithoutCore.libs.Unit.UnpeoplePlane;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.*;
import mindustry.graphics.*;

public class PulseBulletType extends BulletType {
    public Color[] colors = {Pal.lancerLaser.cpy().mul(1f, 1f, 1f, 0.4f), Pal.lancerLaser, Color.red};
    public float length = 160f;
    public float width = 15f;
    public float lengthFalloff = 0.5f;
    public float sideLength = 29f, sideWidth = 0.7f;
    public float sideAngle = 90f;
    public float lightningSpacing = -1, lightningDelay = 0.1f, lightningAngleRand;
    public boolean largeHit = false;

    public int defendAirLevel = 0;
    public void defendAirLevel(int level){
        this.defendAirLevel = level;
    };

    public PulseBulletType(float damage){
        this.damage = damage;
        this.speed = 0f;

        hitEffect = Fx.hitLaserBlast;
        hitColor = colors[2];
        despawnEffect = Fx.none;
        shootEffect = Fx.hitLancer;
        smokeEffect = Fx.none;
        hitSize = 4;
        lifetime = 16f;
        impact = true;
        keepVelocity = false;
        collides = false;
        pierce = true;
        hittable = false;
        absorbable = false;
        removeAfterPierce = false;
    }

    public PulseBulletType(){
        this(1f);
    }

    //assume it pierces at least 3 blocks
    @Override
    public float estimateDPS(){
        return super.estimateDPS() * 3f;
    }

    @Override
    public void init(){
        super.init();

        drawSize = Math.max(drawSize, length*2f);
    }

    @Override
    public void hit(Bullet b, float x, float y) {
        // 获取攻击方 airLevel
        int AirLevel = b.owner instanceof UnpeoplePlane ? ((UnpeoplePlane) b.owner).airLevel : 0;

        // 计算调整系数并限制范围
        float damageMultiplier = 1 - 0.05f * (AirLevel - defendAirLevel);
        damageMultiplier = Mathf.clamp(damageMultiplier, 0.65f, 1.35f);

        // 调整伤害
        float trueDamage = damage;
        damage *= damageMultiplier;

        // 应用伤害
        super.hit(b, x, y);

        // 恢复原始伤害值，防止多个实例造成的伤害错乱
        damage = trueDamage;
        //调试代码，检测伤害倍率
        //Log.info(damageMultiplier);
    }


    @Override
    protected float calculateRange(){
        return Math.max(length, maxRange);
    }

    @Override
    public void init(Bullet b){
        float resultLength = Damage.collideLaser(b, length, largeHit, laserAbsorb, pierceCap), rot = b.rotation();

        //laserEffect.at(b.x, b.y, rot, resultLength * 0.4f);

        if(lightningSpacing > 0){
            int idx = 0;
            for(float i = 0; i <= resultLength; i += lightningSpacing){
                float cx = b.x + Angles.trnsx(rot,  i),
                        cy = b.y + Angles.trnsy(rot, i);

                int f = idx++;

                for(int s : Mathf.signs){
                    Time.run(f * lightningDelay, () -> {
                        if(b.isAdded() && b.type == this){
                            Lightning.create(b, lightningColor,
                                    lightningDamage < 0 ? damage : lightningDamage,
                                    cx, cy, rot + 90*s + Mathf.range(lightningAngleRand),
                                    lightningLength + Mathf.random(lightningLengthRand));
                        }
                    });
                }
            }
        }
    }
    @Override
    public void draw(Bullet b){
        float realLength = b.fdata;

        float f = Mathf.curve(b.fin(), 0f, 0.2f);
        float baseLen = realLength * f;
        float cwidth = width;
        float compound = 0.1f;

        for(Color color : colors){
            Draw.color(color);
            Lines.stroke((cwidth *= lengthFalloff) * b.fout());
            Lines.lineAngle(b.x, b.y, b.rotation(), baseLen, false);
            Tmp.v1.trns(b.rotation(), baseLen);
            Drawf.tri(b.x + Tmp.v1.x, b.y + Tmp.v1.y, Lines.getStroke(), cwidth * 2f + width / 2f, b.rotation());

            Fill.circle(b.x, b.y, 0.4f * cwidth * b.fout());
            for(int i : Mathf.signs){
                Drawf.tri(b.x, b.y, sideWidth * b.fout() * cwidth, sideLength * compound, b.rotation() + sideAngle * i);
            }

            compound *= lengthFalloff;
        }
        Draw.reset();

        Tmp.v1.trns(b.rotation(), baseLen * 1.1f);
        Drawf.light(b.x, b.y, b.x + Tmp.v1.x, b.y + Tmp.v1.y, width * 0.4f * b.fout(), colors[0], 0f);
    }

    @Override
    public void drawLight(Bullet b){
        //no light drawn here
    }
}
