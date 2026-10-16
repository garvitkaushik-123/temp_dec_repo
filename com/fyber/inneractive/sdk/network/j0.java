package com.fyber.inneractive.sdk.network;

import java.util.Comparator;

/* loaded from: classes4.dex */
public final class j0 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((s0) obj).m().ordinal() - ((s0) obj2).m().ordinal();
    }
}
