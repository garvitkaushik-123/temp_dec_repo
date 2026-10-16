package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;

/* loaded from: classes6.dex */
public class Ed extends C3275r3<U0> implements RewardedVideoAdListener {
    public Ed(InterfaceC3012bd interfaceC3012bd, C3171l0 c3171l0, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, C3207n2 c3207n2, U0 u0) {
        super(interfaceC3012bd, c3171l0, baseAdAdapter, new C3000b1(c3171l0.g(), c3171l0.g().getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), c3207n2, u0);
    }
}
