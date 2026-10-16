package com.instagram.common.viewpoint.core;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* renamed from: com.facebook.ads.redexgen.X.i8, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2014i8<K, V> extends PC<K, V> {
    public final /* synthetic */ C2013i7 A00;

    public C2014i8(C2013i7 c2013i7) {
        this.A00 = c2013i7;
    }

    @Override // com.instagram.common.viewpoint.core.PC
    public final int A04() {
        return ((PF) this.A00).A00;
    }

    @Override // com.instagram.common.viewpoint.core.PC
    public final int A05(Object obj) {
        return this.A00.A08(obj);
    }

    @Override // com.instagram.common.viewpoint.core.PC
    public final int A06(Object obj) {
        return this.A00.A07(obj);
    }

    @Override // com.instagram.common.viewpoint.core.PC
    public final Map<K, V> A07() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.PC
    public final Object A0B(int i, int i2) {
        return this.A00.A02[(i << 1) + i2];
    }

    @Override // com.instagram.common.viewpoint.core.PC
    public final V A0C(int i, V value) {
        return this.A00.A0C(i, value);
    }

    @Override // com.instagram.common.viewpoint.core.PC
    public final void A0D() {
        this.A00.clear();
    }

    @Override // com.instagram.common.viewpoint.core.PC
    public final void A0E(int i) {
        this.A00.A0A(i);
    }

    @Override // com.instagram.common.viewpoint.core.PC
    public final void A0F(K key, V value) {
        this.A00.put(key, value);
    }
}
