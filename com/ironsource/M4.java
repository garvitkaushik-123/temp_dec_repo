package com.ironsource;

import com.ironsource.AbstractC3292s3;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class M4<Smash extends AbstractC3292s3<?>> extends sg<Smash> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M4(int i, boolean z, List<? extends Smash> waterfall) {
        super(i, z, waterfall);
        Intrinsics.checkNotNullParameter(waterfall, "waterfall");
    }

    @Override // com.ironsource.sg
    public void c(Smash smash) {
        Intrinsics.checkNotNullParameter(smash, "smash");
        IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " is ready to load");
        smash.a(true);
        c().add(smash);
    }
}
