package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class ig {
    public static final a d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final V0 f3364a;
    private final AbstractC3340v0 b;
    private final Fc c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ig a(V0 adTools, AbstractC3340v0 adUnitData) {
            Intrinsics.checkNotNullParameter(adTools, "adTools");
            Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
            return adUnitData.t() ? new C3258q2(adTools, adUnitData) : new C3217nc(adTools, adUnitData);
        }

        private a() {
        }
    }

    public static final class b implements Fc {
        b() {
        }
    }

    public ig(V0 adTools, AbstractC3340v0 adUnitData) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        this.f3364a = adTools;
        this.b = adUnitData;
        this.c = new b();
    }

    public Fc a() {
        return this.c;
    }

    public abstract void a(C c, jg jgVar);

    public final kg a(List<? extends C3207n2> waterfallItems, Map<String, G> adInstancePayloads, C3156k2 auctionData, C adInstanceFactory) {
        Intrinsics.checkNotNullParameter(waterfallItems, "waterfallItems");
        Intrinsics.checkNotNullParameter(adInstancePayloads, "adInstancePayloads");
        Intrinsics.checkNotNullParameter(auctionData, "auctionData");
        Intrinsics.checkNotNullParameter(adInstanceFactory, "adInstanceFactory");
        IronLog.INTERNAL.verbose(C3205n0.a(this.f3364a, "waterfall.size() = " + waterfallItems.size(), (String) null, 2, (Object) null));
        ArrayList arrayList = new ArrayList();
        int size = waterfallItems.size();
        for (int i = 0; i < size; i++) {
            C3207n2 c3207n2 = waterfallItems.get(i);
            AbstractC3407z a2 = a(c3207n2, auctionData, adInstanceFactory, adInstancePayloads.get(c3207n2.c()));
            if (a2 != null && a2.g() != null) {
                arrayList.add(a2);
            }
        }
        kg kgVar = new kg(arrayList);
        IronLog.INTERNAL.verbose(C3205n0.a(this.f3364a, "updateWaterfall() - next waterfall is " + kgVar + ".toWaterfallString()", (String) null, 2, (Object) null));
        return kgVar;
    }

    private final AbstractC3407z a(C3207n2 c3207n2, C3156k2 c3156k2, C c, G g) {
        AbstractC3340v0 abstractC3340v0 = this.b;
        String c2 = c3207n2.c();
        Intrinsics.checkNotNullExpressionValue(c2, "item.instanceName");
        NetworkSettings a2 = abstractC3340v0.a(c2);
        if (a2 == null) {
            String c3 = c3207n2.c();
            Intrinsics.checkNotNullExpressionValue(c3, "item.instanceName");
            a("Could not find matching provider settings for auction response item", c3);
            return null;
        }
        if (g == null) {
            String c4 = c3207n2.c();
            Intrinsics.checkNotNullExpressionValue(c4, "item.instanceName");
            a("Could not find matching adInstancePayload for auction response item", c4);
            return null;
        }
        com.ironsource.mediationsdk.c.b().b(a2, this.b.b().a(), this.b.b().b());
        int f = this.f3364a.f();
        AbstractC3340v0 abstractC3340v02 = this.b;
        return c.a(new A(abstractC3340v02, a2, c3156k2, new C3000b1(a2, abstractC3340v02.b(a2), this.b.b().a()), c3207n2, f), g);
    }

    private final void a(String str, String str2) {
        String str3 = str + " - item = " + str2;
        IronLog.INTERNAL.error(C3205n0.a(this.f3364a, str3, (String) null, 2, (Object) null));
        this.f3364a.e().h().i(str3);
    }
}
