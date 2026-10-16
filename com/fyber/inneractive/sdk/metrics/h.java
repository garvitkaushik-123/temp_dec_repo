package com.fyber.inneractive.sdk.metrics;

import java.util.UUID;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f1278a = UUID.randomUUID().toString();
    public final String b;

    public h(String str) {
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return this.f1278a.equals(((h) obj).f1278a);
    }

    public final int hashCode() {
        return this.f1278a.hashCode();
    }
}
