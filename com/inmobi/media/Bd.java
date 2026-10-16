package com.inmobi.media;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes4.dex */
public final class Bd {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC2971z5 f2246a;
    public int b = 101;
    public final ArrayList c = CollectionsKt.arrayListOf(101);
    public final LinkedHashMap d;

    public Bd(InterfaceC2971z5 interfaceC2971z5) {
        this.f2246a = interfaceC2971z5;
        List listOf = CollectionsKt.listOf((Object[]) new C2848re[]{new C2848re(101, 1, 102, new C2863sd(this)), new C2848re(101, 4, 104, new C2880td(this)), new C2848re(102, 2, 103, new C2896ud(this)), new C2848re(102, 3, 104, new C2912vd(this)), new C2848re(102, 4, 104, new C2928wd(this)), new C2848re(102, 8, 107, new C2944xd(this)), new C2848re(102, 5, 105, new C2963yd(this)), new C2848re(103, 5, 105, new C2979zd(this)), new C2848re(106, 5, 105, new Ad(this)), new C2848re(106, 7, 105, new C2703id(this)), new C2848re(103, 8, 107, new C2719jd(this)), new C2848re(103, 4, 104, new C2735kd(this)), new C2848re(106, 2, 106, new C2751ld(this)), new C2848re(106, 4, 104, new C2767md(this)), new C2848re(106, 8, 107, new C2783nd(this)), new C2848re(104, 8, 107, new C2799od(this)), new C2848re(105, 7, 106, new C2816pd(this)), new C2848re(105, 4, 104, new C2832qd(this)), new C2848re(105, 2, 105, new C2847rd(this))});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listOf, 10)), 16));
        for (Object obj : listOf) {
            C2848re c2848re = (C2848re) obj;
            linkedHashMap.put(TuplesKt.to(Integer.valueOf(c2848re.f2698a), Integer.valueOf(c2848re.b)), obj);
        }
        this.d = linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public final Integer a(int i) {
        String str;
        C2848re c2848re = (C2848re) this.d.get(TuplesKt.to(Integer.valueOf(this.b), Integer.valueOf(i)));
        if (c2848re == null) {
            return Integer.valueOf(this.b);
        }
        c2848re.d.invoke();
        StringBuilder sb = new StringBuilder("Transition: ");
        Map map = Cd.f2255a;
        int i2 = this.b;
        Map map2 = Cd.f2255a;
        StringBuilder append = sb.append((String) map2.get(Integer.valueOf(i2))).append(" --[");
        switch (i) {
            case 1:
                str = "IMRAID_LOAD_WEBVIEW";
                break;
            case 2:
                str = "FIRE_AD_READY";
                break;
            case 3:
                str = "FIRE_AD_FAILED";
                break;
            case 4:
                str = "ON_RENDER_PROCESS_GONE";
                break;
            case 5:
                str = "SHOW_WEBVIEW";
                break;
            case 6:
                str = "IMRAID_RENDERED";
                break;
            case 7:
                str = "IMRAID_FOCUS_CHANGE";
                break;
            case 8:
                str = "IMRAID_DESTROY_WEBVIEW";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        System.out.println((Object) append.append(str).append("]--> ").append((String) map2.get(Integer.valueOf(c2848re.c))).toString());
        this.c.add(Integer.valueOf(c2848re.c));
        InterfaceC2971z5 interfaceC2971z5 = this.f2246a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("StateMachine", "history - " + this.c);
        }
        this.b = c2848re.c;
        return null;
    }
}
