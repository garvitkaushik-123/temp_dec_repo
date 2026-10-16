package com.inmobi.media;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* loaded from: classes4.dex */
public final class D implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        B4 b4 = (B4) obj2;
        B4 b42 = (B4) obj;
        return ComparisonsKt.compareValues(Integer.valueOf(b4.c * b4.d), Integer.valueOf(b42.c * b42.d));
    }
}
