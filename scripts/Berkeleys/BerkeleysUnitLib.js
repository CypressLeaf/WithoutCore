function mareNubium(nameI, localizedNameI, descriptionI, detailsI) {
    var i = Object.assign(UnitType, nameI, {
        description: descriptionI,
        details: detailsI,
        hitsize: 12,
        speed: 1.2,
        groundLayer: 50,
        health: 600,
        rotateSpeed: 3,
        itemCapacity: 0,
        trailScl: 0.75,
        waveTrailY: -10,
        trailLength: 25,
        range: 160,
        maxRange: 160,
        outlines: false,
        faceTarget: false,
        constructor: () => new UnitWaterMove.create(),
        localizedName: localizedNameI
    })
    return i = i;
    exports.i = i;
};
exports.mareNubium = mareNubium;
function mareNubiumSWeapon(nameI, damageI) {
    var i = extend(Weapon, nameI, {});
    Object.assign(i, {
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
            range: 160,
            maxRange: 160,
            width: 6,
            length: 160,
            damage: damageI,
            shake: 0,
            lifetime: 15,
            pierceArmor: true,
            hitSize: 0,
            sideLength: 0,
            sideWidth: 0,
            sideAngle: 1,
            shootEffect: Fx.none,
            backLength: 1,
            buildingDamageMultiplier: 0,
            colors: [Color.valueOf("B7EEFFFF"), Color.valueOf("85D5FFFF"), Color.valueOf("59BBFFFF"), Color.valueOf("919FE700")],
        }),
    })
    return i = i;
};
exports.mareNubiumSWeapon = mareNubiumSWeapon;