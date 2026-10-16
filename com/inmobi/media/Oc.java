package com.inmobi.media;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Oc {

    /* renamed from: a, reason: collision with root package name */
    public final Sd f2386a;
    public final double b;
    public final List c;

    public Oc(Sd telemetryConfigMetaData, double d, List samplingEvents) {
        Intrinsics.checkNotNullParameter(telemetryConfigMetaData, "telemetryConfigMetaData");
        Intrinsics.checkNotNullParameter(samplingEvents, "samplingEvents");
        this.f2386a = telemetryConfigMetaData;
        this.b = d;
        this.c = samplingEvents;
        Intrinsics.checkNotNullExpressionValue("Oc", "getSimpleName(...)");
    }
}
