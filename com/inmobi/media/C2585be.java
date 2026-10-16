package com.inmobi.media;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.be, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2585be {

    /* renamed from: a, reason: collision with root package name */
    public final Sd f2528a;
    public final Oc b;
    public final C2602ce c;

    public C2585be(Sd telemetryConfigMetaData, List samplingEvents) {
        Intrinsics.checkNotNullParameter(telemetryConfigMetaData, "telemetryConfigMetaData");
        Intrinsics.checkNotNullParameter(samplingEvents, "samplingEvents");
        this.f2528a = telemetryConfigMetaData;
        double random = Math.random();
        this.b = new Oc(telemetryConfigMetaData, random, samplingEvents);
        this.c = new C2602ce(telemetryConfigMetaData, random);
    }

    public final int a(Td telemetryEventType, String eventType) {
        Intrinsics.checkNotNullParameter(telemetryEventType, "telemetryEventType");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        int ordinal = telemetryEventType.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            C2602ce c2602ce = this.c;
            c2602ce.getClass();
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            if (c2602ce.b >= c2602ce.f2539a.g) {
                return 0;
            }
            Pd pd = Pd.f2401a;
            return 2;
        }
        Oc oc = this.b;
        oc.getClass();
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (!oc.c.contains(eventType)) {
            return 1;
        }
        if (oc.b >= oc.f2386a.g) {
            return 0;
        }
        Pd pd2 = Pd.f2401a;
        return 2;
    }
}
