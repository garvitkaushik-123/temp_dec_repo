package com.instagram.common.viewpoint.core;

import java.util.Objects;

/* renamed from: com.facebook.ads.redexgen.X.2A, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2A extends BP<Object> {
    public final transient int A00;
    public final transient int A01;
    public final transient Object[] A02;

    public C2A(Object[] alternatingKeysAndValues, int offset, int size) {
        this.A02 = alternatingKeysAndValues;
        this.A00 = offset;
        this.A01 = size;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2372oO
    public final boolean A0K() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int index) {
        AbstractC2159ki.A00(index, this.A01);
        return Objects.requireNonNull(this.A02[(index * 2) + this.A00]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.A01;
    }
}
