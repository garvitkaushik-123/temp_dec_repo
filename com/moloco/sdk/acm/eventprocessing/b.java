package com.moloco.sdk.acm.eventprocessing;

import com.moloco.sdk.MetricsRequest;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b implements com.moloco.sdk.acm.eventprocessing.a {

    /* renamed from: a, reason: collision with root package name */
    public final f f5329a;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5330a;

        static {
            int[] iArr = new int[com.moloco.sdk.acm.db.c.values().length];
            try {
                iArr[com.moloco.sdk.acm.db.c.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.moloco.sdk.acm.db.c.f5316a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f5330a = iArr;
        }
    }

    public b(f dataAgeChecker) {
        Intrinsics.checkNotNullParameter(dataAgeChecker, "dataAgeChecker");
        this.f5329a = dataAgeChecker;
    }

    @Override // com.moloco.sdk.acm.eventprocessing.a
    public com.moloco.sdk.acm.http.d a(List<com.moloco.sdk.acm.db.b> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.moloco.sdk.acm.db.b bVar : events) {
            if (!this.f5329a.a(bVar)) {
                int i = a.f5330a[bVar.h().ordinal()];
                if (i == 1) {
                    MetricsRequest.PostMetricsRequest.CountEvent.Builder addAllTags = MetricsRequest.PostMetricsRequest.CountEvent.newBuilder().setName(bVar.j()).addAllTags(bVar.k());
                    Long g = bVar.g();
                    if (g != null) {
                        addAllTags.setCount((int) g.longValue());
                    }
                    MetricsRequest.PostMetricsRequest.CountEvent build = addAllTags.build();
                    Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                    arrayList2.add(build);
                } else {
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    MetricsRequest.PostMetricsRequest.TimerEvent.Builder addAllTags2 = MetricsRequest.PostMetricsRequest.TimerEvent.newBuilder().setName(bVar.j()).addAllTags(bVar.k());
                    Long g2 = bVar.g();
                    if (g2 != null) {
                        addAllTags2.setElapsedTimeMillis(g2.longValue());
                    }
                    MetricsRequest.PostMetricsRequest.TimerEvent build2 = addAllTags2.build();
                    Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
                    arrayList.add(build2);
                }
            }
        }
        return new com.moloco.sdk.acm.http.d(arrayList2, arrayList);
    }
}
