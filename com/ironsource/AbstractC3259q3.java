package com.ironsource;

import com.ironsource.C3275r3;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;

/* renamed from: com.ironsource.q3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC3259q3<Smash extends C3275r3<?>> extends AbstractC3208n3<Smash, AdapterAdRewardListener> implements U0 {
    public AbstractC3259q3(U u, Z9 z9, IronSourceSegment ironSourceSegment) {
        super(u, z9, ironSourceSegment);
    }

    @Override // com.ironsource.U0
    public void a(C3275r3<?> c3275r3, Placement placement) {
        IronLog.INTERNAL.verbose(b(c3275r3.k()));
        this.t.b(placement, c3275r3.f());
    }
}
