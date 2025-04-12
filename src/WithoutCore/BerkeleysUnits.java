package WithoutCore;

import WithoutCore.libs.PlaneEjector;
import WithoutCore.libs.ai.DefensePlaneAI;
import WithoutCore.libs.bullet.PulseBulletType;
import arc.graphics.Color;
import mindustry.ai.types.MissileAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.*;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.MissileUnitType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static mindustry.content.UnitTypes.alpha;

public class BerkeleysUnits {

    @Retention(RetentionPolicy.SOURCE)
    public @interface EntityDef {
        /**
         * 组件接口列表
         */
        Class[] value();

        /**
         * 是否终结
         */
        boolean isFinal() default true;

        /**
         * 如果为True,实体将会回收
         */
        boolean pooled() default false;

        /**
         * Whether to serialize (makes the serialize method return this value).
         * If true, this entity is automatically put into save files.
         * If false, no serialization code is generated at all.
         */
        boolean serialize() default true;

        /**
         * Whether to generate IO code. This is for advanced usage only.
         */
        boolean genio() default true;

        /**
         * Whether I made a massive mistake by merging two different class branches
         */
        boolean legacy() default false;
        // 取自Anuken.Mindustry源代码
    }


        //public static UnitType MareNubium_Spy;
        public static @EntityDef({ Unitc.class, WaterMovec.class }) UnitType MareNubium_Spy;

    public static void load(){
        MareNubium_Spy = new UnitType("MareNubium_Spy") {
            {
                hitSize = 12f;
                speed = 1.75f;
                groundLayer = 50f;
                health = 850f;
                rotateSpeed = 4f;
                itemCapacity = 0;
                trailScl = 0.75f;
                waveTrailY = -10f;
                trailLength = 25;
                range = 240f;
                outlines = false;
                faceTarget = false;
                playerControllable = true;
                logicControllable = false;
                constructor = () -> UnitWaterMove.create();
                weapons.add(new PlaneEjector("withoutcore-MareNubium_Spy_Ejector") {
                    {
                            x = 0f;
                            y = 2f;
                            rotate = false;
                            reload = 60f * 3f;
                            recoil = 0f;
                            shootOnDeath = true;
                            shootCone = -1;
                            top = true;
                            ejectEffect = Fx.none;
                            maxPlane = 4;
                            mirror = false;
                            plane = BerkeleysPlanes.breeze_Spy;
                            bullet = new BulletType(0f,0f){{
                                range = 0;
                                maxRange = 200;
                                fragBullets = 4;
                                lifetime = 0;
                                damage = 0;
                            }};
                        }
                });
                weapons.add(new Weapon("withoutcore-MareNubium_Sub") {
                    {
                        x = 3.5f;
                        y = -5f;
                        rotate = true;
                        mirror = true;
                        rotateSpeed = 8;
                        reload = 15;
                        recoil = 0;
                        shake = 0.5f;
                        shootOnDeath = true;
                        alternate = true;
                        top = false;
                        ejectEffect = Fx.none;
                        shootSound = Sounds.bolt;
                        heatColor = Color.valueOf("6586B0F0");
                        bullet = new PulseBulletType(20f) {
                            {
                                collidesGround = false;
                                collidesTiles = false;
                                pierceCap = 1;
                                range = 240f;
                                width = 2f;
                                length = 160f;
                                damage = 10f;
                                shake = 0;
                                lifetime = 15;
                                pierceArmor = false;
                                hitSize = 1f;
                                shootEffect = Fx.none;
                                buildingDamageMultiplier = 0.01f;
                                defendAirLevel = 1;
                                // colors = new Color[]{Color.valueOf("B7EEFFFF"), Color.valueOf("85D5FFFF"),
                                // Color.valueOf("59BBFFFF"), Color.valueOf("919FE700")}
                                colors = new Color[] { Color.valueOf("B7EEFFFF"), Color.valueOf("85D5FFFF"), Color.valueOf("59BBFFFF") };
                            }
                        };
                    }
                });
            }
        };
    };
}
