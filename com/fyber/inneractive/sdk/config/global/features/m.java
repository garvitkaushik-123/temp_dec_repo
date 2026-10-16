package com.fyber.inneractive.sdk.config.global.features;

import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class m extends h implements o {
    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        timeUnit.toMillis(45L);
        timeUnit.toMillis(5L);
        timeUnit.toMillis(5L);
        timeUnit.toMillis(45L);
        timeUnit.toMillis(10L);
        timeUnit.toMillis(2L);
        timeUnit.toMillis(15L);
        timeUnit.toMillis(8L);
    }

    public m() {
        super("bid_net");
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.h
    public final h b() {
        m mVar = new m();
        a(mVar);
        return mVar;
    }
}
