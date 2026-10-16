package io.bidmachine.media3.exoplayer;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes7.dex */
public final /* synthetic */ class ExoPlayerImplInternal$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ AtomicBoolean f$0;

    public /* synthetic */ ExoPlayerImplInternal$$ExternalSyntheticLambda0(AtomicBoolean atomicBoolean) {
        this.f$0 = atomicBoolean;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        boolean z;
        z = this.f$0.get();
        return Boolean.valueOf(z);
    }
}
