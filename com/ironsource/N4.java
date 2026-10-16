package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class N4 extends pg {
    private final Fc d;
    private final kg e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N4(V0 adTools, Fc outcomeReporter, kg waterfallInstances) {
        super(adTools, outcomeReporter);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(outcomeReporter, "outcomeReporter");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
        this.d = outcomeReporter;
        this.e = waterfallInstances;
    }

    @Override // com.ironsource.pg
    public void a() {
    }

    @Override // com.ironsource.pg
    public void a(AbstractC3407z instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // com.ironsource.pg
    public void b(AbstractC3407z instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.d.a(this.e.b(), instance);
    }

    @Override // com.ironsource.pg
    public void c(AbstractC3407z instanceToShow) {
        Intrinsics.checkNotNullParameter(instanceToShow, "instanceToShow");
    }
}
