package com.inmobi.media;

import android.content.Context;
import com.inmobi.commons.core.configs.CrashConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class H3 {

    /* renamed from: a, reason: collision with root package name */
    public volatile CrashConfig f2302a;
    public final H7 b;
    public final List c;

    public H3(Context context, CrashConfig crashConfig, H7 eventBus) {
        H3 h3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(crashConfig, "crashConfig");
        Intrinsics.checkNotNullParameter(eventBus, "eventBus");
        this.f2302a = crashConfig;
        this.b = eventBus;
        List synchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(...)");
        this.c = synchronizedList;
        if (this.f2302a.getCrashConfig().getEnabled()) {
            synchronizedList.add(new C2741l3(Thread.getDefaultUncaughtExceptionHandler(), this));
        }
        if (this.f2302a.getAnr().getAppExitReason().getEnabled() && L3.f2348a.z()) {
            h3 = this;
            synchronizedList.add(new C2589c1(context, h3, this.f2302a.getAnr().getAppExitReason().getIncidentWaitInterval(), this.f2302a.getAnr().getAppExitReason().getMaxNumberOfLines()));
        } else {
            h3 = this;
        }
        if (h3.f2302a.getAnr().getWatchdog().getEnabled()) {
            synchronizedList.add(new C2570b(h3.f2302a.getAnr().getWatchdog().getInterval(), this));
        }
    }

    public final void a(T5 incidentEvent) {
        int i;
        Intrinsics.checkNotNullParameter(incidentEvent, "incidentEvent");
        if ((incidentEvent instanceof C2606d1) && this.f2302a.getAnr().getAppExitReason().getEnabled()) {
            i = 152;
        } else if ((incidentEvent instanceof C2757m3) && this.f2302a.getCrashConfig().getEnabled()) {
            i = 150;
        } else if (!(incidentEvent instanceof mf) || !this.f2302a.getAnr().getWatchdog().getEnabled()) {
            return;
        } else {
            i = 151;
        }
        this.b.b(new C2607d2(i, incidentEvent.f2446a, MapsKt.mapOf(TuplesKt.to("data", incidentEvent))));
    }
}
