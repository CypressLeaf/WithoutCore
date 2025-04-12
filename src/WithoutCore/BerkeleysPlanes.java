package WithoutCore;

import WithoutCore.libs.Unit.UnpeoplePlane;
import WithoutCore.libs.ai.DefensePlaneAI;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.Sounds;
import mindustry.type.Weapon;

public class BerkeleysPlanes {
    //玩家
    //public static UnpeoplePlane breeze_Spy_lock,breeze_Spy_passive;
    //public static void load(){
        public static UnpeoplePlane breeze_Spy = new UnpeoplePlane("breezeSpy"){{
            controller = u -> new DefensePlaneAI(){{
                lockTarget = true;
                circleRadius = 240f;
                fogRadius = 80f;
            }};
            hitSize = 8f;
            health = 650;
            speed = 4f;
            rotateSpeed = 4;
            groundLayer = 150;
            range = 0;
            maxRange = 120f;
            airLevel = 0;
            targetGround = true;
            engineSize = 0.2f;
            useUnitCap = false;
            createWreck = false;
            flying = true;
            targetable = false;
            outlines = false;
            weapons.add(new Weapon("") {
                {
                    x = 2f;
                    y = 0f;
                    rotate = false;
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
                    bullet = new BasicBulletType(){{
                        range = 0f;
                        maxRange = 120f;
                        width = 1f;
                        height= 2f;
                        speed = 4;
                        homingPower = 0f;
                        damage = 20f;
                        pierceArmor = false;
                        lifetime = 20f;
                        trailEffect = Fx.missileTrail;
                        backColor = Color.valueOf("C0ECFFFF");
                        trailColor = Color.valueOf("C0ECFFFF");
                        frontColor = Color.valueOf("C0ECFFFF");
                        shootEffect = Fx.none;
                        smokeEffect = Fx.none;
                        despawnEffect = Fx.none;
                        hitEffect = Fx.none;
                        trailWidth = 0.25f;
                        trailLength = 7;
                    }};

                    shoot = new ShootAlternate(){{
                        shots = 4;
                        shotDelay = 2f;
                        spread = 3.5f;
                        barrels = 3;
                    }};
                }
            });
        }};
        public static UnpeoplePlane breeze_Spy_passive = new UnpeoplePlane("breezeSpy_passive"){{
            controller = u -> new DefensePlaneAI(){{
                lockTarget = false;
                circleRadius = 80f;
                fogRadius = 60f;
            }};
            hitSize = 6f;
            health = 650;
            speed = 4f;
            rotateSpeed = 4;
            groundLayer = 150;
            range = 0;
            maxRange = 80f;
            airLevel = 0;
            targetGround = true;
            engineSize = 0.2f;
            useUnitCap = false;
            createWreck = false;
            flying = true;
            targetable = false;
            outlines = false;
            weapons.add(new Weapon("") {
                {
                    x = 2f;
                    y = 0f;
                    rotate = false;
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
                    bullet = new BasicBulletType(){{
                        range = 0f;
                        maxRange = 800f;
                        width = 1f;
                        height= 2f;
                        speed = 4;
                        homingPower = 0f;
                        damage = 20f;
                        pierceArmor = false;
                        lifetime = 20f;
                        trailEffect = Fx.missileTrail;
                        backColor = Color.valueOf("C0ECFFFF");
                        trailColor = Color.valueOf("C0ECFFFF");
                        frontColor = Color.valueOf("C0ECFFFF");
                        shootEffect = Fx.none;
                        smokeEffect = Fx.none;
                        despawnEffect = Fx.none;
                        hitEffect = Fx.none;
                        trailWidth = 0.25f;
                        trailLength = 7;
                    }};

                    shoot = new ShootAlternate(){{
                        shots = 4;
                        shotDelay = 2f;
                        spread = 3.5f;
                        barrels = 3;
                    }};
                }
            });
        }};
    //}
}