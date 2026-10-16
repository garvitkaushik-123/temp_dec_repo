package com.ironsource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Ve extends J4 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ve(AbstractC3340v0 adUnitData, kg waterfallInstances) {
        super(adUnitData, waterfallInstances);
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
    }

    private final int b(AbstractC3407z abstractC3407z) {
        return abstractC3407z.h().l();
    }

    @Override // com.ironsource.F
    protected boolean a(AbstractC3407z instance, kg waterfallInstances) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
        return a(waterfallInstances) < b(instance);
    }

    private final int a(kg kgVar) {
        Integer num;
        List<AbstractC3407z> b = kgVar.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : b) {
            if (((AbstractC3407z) obj).w()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Integer valueOf = Integer.valueOf(b((AbstractC3407z) it.next()));
            while (it.hasNext()) {
                Integer valueOf2 = Integer.valueOf(b((AbstractC3407z) it.next()));
                if (valueOf.compareTo(valueOf2) > 0) {
                    valueOf = valueOf2;
                }
            }
            num = valueOf;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return Integer.MAX_VALUE;
    }
}
