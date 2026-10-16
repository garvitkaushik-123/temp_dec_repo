package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class pg {
    public static final a c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final C3205n0 f3644a;
    private final Fc b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final pg a(V0 adTools, AbstractC3340v0 adUnitData, Fc outcomeReporter, kg waterfallInstances, F adInstanceLoadStrategy) {
            Intrinsics.checkNotNullParameter(adTools, "adTools");
            Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
            Intrinsics.checkNotNullParameter(outcomeReporter, "outcomeReporter");
            Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
            Intrinsics.checkNotNullParameter(adInstanceLoadStrategy, "adInstanceLoadStrategy");
            return adUnitData.q() ? new We(adTools, outcomeReporter, waterfallInstances, adInstanceLoadStrategy) : new N4(adTools, outcomeReporter, waterfallInstances);
        }

        private a() {
        }
    }

    public pg(C3205n0 adTools, Fc outcomeReporter) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(outcomeReporter, "outcomeReporter");
        this.f3644a = adTools;
        this.b = outcomeReporter;
    }

    private final void b(AbstractC3407z abstractC3407z, List<? extends AbstractC3407z> list) {
        for (AbstractC3407z abstractC3407z2 : list) {
            if (abstractC3407z2 == abstractC3407z) {
                abstractC3407z.a(true);
                return;
            }
            abstractC3407z2.a(false);
            IronLog.INTERNAL.verbose(C3205n0.a(this.f3644a, abstractC3407z2.q() + " - not ready to show", (String) null, 2, (Object) null));
        }
    }

    public abstract void a();

    public abstract void a(AbstractC3407z abstractC3407z);

    public final void a(AbstractC3407z instanceToShow, List<? extends AbstractC3407z> orderedInstances) {
        Intrinsics.checkNotNullParameter(instanceToShow, "instanceToShow");
        Intrinsics.checkNotNullParameter(orderedInstances, "orderedInstances");
        b(instanceToShow, orderedInstances);
        c(instanceToShow);
    }

    public abstract void b(AbstractC3407z abstractC3407z);

    public abstract void c(AbstractC3407z abstractC3407z);

    public final void a(AbstractC3407z instance, String str, Z9 publisherDataHolder) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(publisherDataHolder, "publisherDataHolder");
        this.b.a(instance, str, publisherDataHolder);
    }
}
