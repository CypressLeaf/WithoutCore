package WithoutCore.libs.Bundle;

import arc.*;
import arc.util.*;
import mindustry.gen.*;

import java.util.*;

public class BundleUnit {
    public static final BundleUnit

    dps = new BundleUnit("perSecond",false),

    none = new BundleUnit("none");

    public final boolean space;
    public final String name;
    public @Nullable String icon;

    public BundleUnit(String name, boolean space){
        this.name = name;
        this.space = space;
    }

    public BundleUnit(String name){
        this(name, true);
    }

    public BundleUnit(String name, String icon){
        this(name, true);
        this.icon = icon;
    }

    public String localized(){
        if(this == none) return "";
        return Core.bundle.get("unit." + name.toLowerCase(Locale.ROOT));
    }
}
