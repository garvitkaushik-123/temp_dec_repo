package com.moloco.sdk.internal.publisher.nativead;

import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.ortb.model.r;
import com.moloco.sdk.internal.publisher.A;
import com.moloco.sdk.internal.publisher.j;
import com.moloco.sdk.internal.publisher.nativead.model.b;
import com.moloco.sdk.internal.publisher.y;
import com.moloco.sdk.internal.services.InterfaceC3442f;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d {
    public static final int l = 8;

    /* renamed from: a, reason: collision with root package name */
    public final String f5543a;
    public final com.moloco.sdk.internal.ortb.model.c b;
    public final com.moloco.sdk.internal.publisher.nativead.model.b c;
    public final InterfaceC3442f d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a e;
    public final AdFormatType f;
    public final i g;
    public final InterfaceC3463m h;
    public final MetricsRecorder i;
    public final y j;
    public final a k;

    public d(String adUnitId, com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.internal.publisher.nativead.model.b ortbResponse, InterfaceC3442f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, AdFormatType adFormatType, i persistentHttpRequest, InterfaceC3463m externalLinkHandler, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(ortbResponse, "ortbResponse");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5543a = adUnitId;
        this.b = bid;
        this.c = ortbResponse;
        this.d = appLifecycleTrackerService;
        this.e = customUserEventBuilderService;
        this.f = adFormatType;
        this.g = persistentHttpRequest;
        this.h = externalLinkHandler;
        this.i = metricsRecorder;
        this.j = a();
        this.k = b();
    }

    public final y a() {
        final com.moloco.sdk.internal.ortb.model.c cVar = this.b;
        return A.a(null, this.d, this.e, new Function0() { // from class: com.moloco.sdk.internal.publisher.nativead.d$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d.a(com.moloco.sdk.internal.ortb.model.c.this);
            }
        }, new Function0() { // from class: com.moloco.sdk.internal.publisher.nativead.d$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d.a(d.this);
            }
        }, null, null, this.f, this.i, 96, null);
    }

    public final a b() {
        com.moloco.sdk.internal.publisher.nativead.model.b bVar = this.c;
        return new a(bVar.c(), bVar.b(), this.g);
    }

    public final void c() {
        b.c d = this.c.d();
        if (d != null) {
            this.k.a(d.a());
            this.h.a(d.c());
        }
        this.j.onAdClicked(MolocoAdKt.createAdInfo$default(this.f5543a, null, 2, null));
    }

    public final void d() {
        this.k.a();
        this.j.onAdShowSuccess(MolocoAdKt.createAdInfo$default(this.f5543a, null, 2, null));
    }

    public static final r a(com.moloco.sdk.internal.ortb.model.c cVar) {
        return cVar.e().i();
    }

    public static final j a(d dVar) {
        String c = dVar.b.c();
        if (c != null) {
            return new j(c, Float.valueOf(dVar.b.g()));
        }
        return null;
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public List<String> f5544a;
        public List<b.C0449b> b;
        public final i c;
        public final Set<String> d;

        /* renamed from: com.moloco.sdk.internal.publisher.nativead.d$a$a, reason: collision with other inner class name */
        public static final class C0446a {

            /* renamed from: a, reason: collision with root package name */
            public static final C0446a f5545a = new C0446a();
            public static final int b = 1;
            public static final int c = 0;
        }

        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public static final b f5546a = new b();
            public static final int b = 1;
            public static final int c = 0;
        }

        public a(List<String> list, List<b.C0449b> list2, i persistentHttpRequest) {
            Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
            this.f5544a = list;
            this.b = list2;
            this.c = persistentHttpRequest;
            this.d = new LinkedHashSet();
        }

        public final void a() {
            List<String> list = this.f5544a;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    this.c.a((String) it.next());
                }
            }
            this.f5544a = null;
            List<b.C0449b> list2 = this.b;
            if (list2 != null) {
                for (b.C0449b c0449b : list2) {
                    if (c0449b.c() != null && c0449b.a() == 1 && c0449b.b() == 1) {
                        this.c.a(c0449b.c());
                    }
                }
            }
            this.b = null;
        }

        public final void a(List<String> urls) {
            Intrinsics.checkNotNullParameter(urls, "urls");
            for (String str : urls) {
                if (!this.d.contains(str)) {
                    this.c.a(str);
                    this.d.add(str);
                }
            }
        }
    }
}
