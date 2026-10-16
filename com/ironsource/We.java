package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public class We extends pg {
    private final Fc d;
    private final kg e;
    private final F f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public We(V0 adTools, Fc outcomeReporter, kg waterfallInstances, F adInstanceLoadStrategy) {
        super(adTools, outcomeReporter);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(outcomeReporter, "outcomeReporter");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
        Intrinsics.checkNotNullParameter(adInstanceLoadStrategy, "adInstanceLoadStrategy");
        this.d = outcomeReporter;
        this.e = waterfallInstances;
        this.f = adInstanceLoadStrategy;
    }

    @Override // com.ironsource.pg
    public void a(AbstractC3407z instance) {
        AbstractC3407z a2;
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (this.f.a(instance)) {
            this.d.a(this.e.b(), instance);
        } else {
            if (!this.f.a() || (a2 = this.f.c().a()) == null) {
                return;
            }
            this.d.a(this.e.b(), a2);
        }
    }

    @Override // com.ironsource.pg
    public void b(AbstractC3407z instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // com.ironsource.pg
    public void c(AbstractC3407z instanceToShow) {
        Intrinsics.checkNotNullParameter(instanceToShow, "instanceToShow");
        this.d.a(this.e.b(), instanceToShow);
    }

    @Override // com.ironsource.pg
    public void a() {
        AbstractC3407z a2 = this.f.c().a();
        if (a2 != null) {
            this.d.a(this.e.b(), a2);
        }
    }
}
