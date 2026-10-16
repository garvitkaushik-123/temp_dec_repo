package com.instagram.common.viewpoint.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class CL implements InterfaceC1923gc {
    public final C0907Cb A00;
    public final EnumC1928gh A01;

    public CL(C0907Cb c0907Cb, EnumC1928gh enumC1928gh) {
        this.A00 = c0907Cb;
        this.A01 = enumC1928gh;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1923gc
    public void A4D(Map<InterfaceC1905gK, EnumC1928gh> map, Map<SyncModifiableBundle, EnumC1915gU> map2) {
        map.put(this.A00, this.A01);
    }
}
