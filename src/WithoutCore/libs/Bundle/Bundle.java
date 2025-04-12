package WithoutCore.libs;

import arc.Core;
import arc.struct.Seq;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatCat;

import java.util.Locale;

public class Bundle implements Comparable<Stat>{
    public static final Seq<Bundle> all = new Seq<>();

    public static final Bundle

    plane = new Bundle("plane"),
    dps = new Bundle("perSecond");

    public final StatCat category;
    public final String name;
    public final int id;

    public Bundle(String name, StatCat category){
        this.category = category;
        this.name = name;
        id = all.size;
        all.add(this);
    }

    public Bundle(String name){
        this(name, StatCat.general);
    }

    public String localized(){
        return Core.bundle.get("Bundle." + name.toLowerCase(Locale.ROOT));
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(Stat i){
        return id - i.id;
    }
}
