package com.bytedance.adsdk.DbA;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class nlS<V> {
    private final Throwable DbA;
    private final V eli;

    public nlS(V v) {
        this.eli = v;
        this.DbA = null;
    }

    public nlS(Throwable th) {
        this.DbA = th;
        this.eli = null;
    }

    public V eli() {
        return this.eli;
    }

    public Throwable DbA() {
        return this.DbA;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nlS)) {
            return false;
        }
        nlS nls = (nlS) obj;
        if (eli() != null && eli().equals(nls.eli())) {
            return true;
        }
        if (DbA() == null || nls.DbA() == null) {
            return false;
        }
        return DbA().toString().equals(DbA().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{eli(), DbA()});
    }
}
