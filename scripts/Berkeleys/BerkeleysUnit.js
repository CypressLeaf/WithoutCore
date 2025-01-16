function mareNubium(UnitLocalizedName, UnitDescription, UnitDetails, UnitDamage) {
    //function mareNubium() {
    var mareNubium = extend(UnitType, "云海", {
        description: UnitDescription,
        details: UnitDetails,
        localizedName: UnitLocalizedName,
    });
    Object.assign(mareNubium, {
        //description: UnitDescription,
        //details: UnitDetails,
        hitsize: 12,
        speed: 1,
        groundLayer: 50,
        health: 600,
        rotateSpeed: 3,
        itemCapacity: 0,
        trailScl: 0.75,
        waveTrailY: -10,
        trailLength: 25,
        range: 120,
        outlines: false,
        faceTarget: false,
        playerControllable: true,
        logicControllable: false,
        constructor: () => new UnitWaterMove.create(),
        //localizedName: UnitLocalizedName,
        //localizedName: "云海",
    });
    mareNubium.weapons.add((() => {
        var mareNubiumWeapon = extend(Weapon, "云海副炮", { damage: UnitDamage });
        Object.assign(mareNubiumWeapon, {
            x: 3.5,
            y: -6,
            rotate: true,
            mirror: true,
            rotateSpeed: 8,
            reload: 15,
            recoil: 0,
            shake: 0.5,
            shootOnDeath: true,
            alternate: true,
            top: false,
            ejectEffect: Fx.none,
            shootSound: Sounds.bolt,
            heatColor: Color.valueOf("6586B0F0"),
            bullet: extend(LaserBulletType, {
                collidesGround: false,
                collidesTiles: false,
                pierceCap: 1,
                range: 120,
                width: 5,
                length: 120,
                damage: 10,
                //damage: WeaponDamage,
                shake: 0,
                lifetime: 15,
                pierceArmor: false,
                hitSize: 0,
                sideLength: 0,
                sideWidth: 0,
                sideAngle: 1,
                shootEffect: Fx.none,
                backLength: 1,
                buildingDamageMultiplier: 0.01,
                colors: [Color.valueOf("B7EEFFFF"), Color.valueOf("85D5FFFF"), Color.valueOf("59BBFFFF"), Color.valueOf("919FE700")],
            }),
        })
        return mareNubiumWeapon
    })());
    exports.mareNubium = mareNubium;
    return mareNubium;
};
const mareNubium_Tout = mareNubium("云海-侦察型", "", "", 10);