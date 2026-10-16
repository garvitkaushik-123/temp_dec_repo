package com.ironsource;

import com.ironsource.U0;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.HashMap;

/* renamed from: com.ironsource.r3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3275r3<Listener extends U0> extends AbstractC3225o3<Listener> implements AdapterAdRewardListener {
    private C3126i5 r;

    /* renamed from: com.ironsource.r3$a */
    class a extends Pd {
        a() {
        }

        @Override // com.ironsource.Pd
        public void a() {
            C3275r3.this.U();
        }
    }

    public C3275r3(InterfaceC3012bd interfaceC3012bd, C3171l0 c3171l0, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, C3000b1 c3000b1, C3207n2 c3207n2, Listener listener) {
        super(interfaceC3012bd, c3171l0, baseAdAdapter, c3000b1, c3207n2, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.g == null) {
            IronLog.INTERNAL.verbose(a("placement is null "));
            D0 d0 = this.d;
            if (d0 != null) {
                d0.j.g("mCurrentPlacement is null state = " + this.e);
                return;
            }
            return;
        }
        IronLog.INTERNAL.verbose(a("placement name = " + j()));
        if (this.d != null) {
            HashMap hashMap = new HashMap();
            if (com.ironsource.mediationsdk.p.j().p() != null) {
                for (String str : com.ironsource.mediationsdk.p.j().p().keySet()) {
                    hashMap.put("custom_" + str, com.ironsource.mediationsdk.p.j().p().get(str));
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.d.i.a(j(), this.g.getRewardName(), this.g.getRewardAmount(), currentTimeMillis, IronSourceUtils.getTransId(currentTimeMillis, c()), C3126i5.a(this.r), hashMap, com.ironsource.mediationsdk.p.j().i());
        }
        ((U0) this.b).a((C3275r3<?>) this, this.g);
    }

    @Override // com.ironsource.AbstractC3225o3, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdClosed() {
        this.r = new C3126i5();
        super.onAdClosed();
    }

    @Override // com.ironsource.AbstractC3292s3, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        this.r = null;
        super.onAdOpened();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener
    public void onAdRewarded() {
        if (u().e()) {
            u().a(new a());
        } else {
            U();
        }
    }
}
