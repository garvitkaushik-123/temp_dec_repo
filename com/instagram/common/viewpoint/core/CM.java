package com.instagram.common.viewpoint.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class CM implements InterfaceC1923gc {
    public final EnumC1915gU A00;
    public final AbstractC06702d A01;

    public CM(AbstractC06702d abstractC06702d, EnumC1915gU enumC1915gU) {
        this.A01 = abstractC06702d;
        this.A00 = enumC1915gU;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1923gc
    public void A4D(Map<InterfaceC1905gK, EnumC1928gh> map, Map<SyncModifiableBundle, EnumC1915gU> map2) {
        map2.put(null, this.A00);
    }
}
