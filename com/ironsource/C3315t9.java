package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.InterstitialAdListener;

/* renamed from: com.ironsource.t9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3315t9 extends AbstractC3225o3<I0> implements InterstitialAdListener {
    public C3315t9(InterfaceC3012bd interfaceC3012bd, C3171l0 c3171l0, BaseAdAdapter<?, AdapterAdInteractionListener> baseAdAdapter, C3207n2 c3207n2, I0 i0) {
        super(interfaceC3012bd, c3171l0, baseAdAdapter, new C3000b1(c3171l0.g(), c3171l0.g().getInterstitialSettings(), IronSource.AD_UNIT.INTERSTITIAL), c3207n2, i0);
    }
}
