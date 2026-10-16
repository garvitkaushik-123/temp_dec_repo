package com.fyber.inneractive.sdk.cache.session;

import java.util.Comparator;

/* loaded from: classes4.dex */
public final class l implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        g gVar = (g) obj;
        g gVar2 = (g) obj2;
        if (gVar == null || gVar2 == null) {
            return 0;
        }
        return gVar.d < gVar2.d ? -1 : 1;
    }
}
