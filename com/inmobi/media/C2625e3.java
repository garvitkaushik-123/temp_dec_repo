package com.inmobi.media;

import android.content.Context;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.e3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2625e3 {

    /* renamed from: a, reason: collision with root package name */
    public final C2672h f2555a;
    public final long b;
    public final String c = "e3";
    public final C2692i3 d = new C2692i3();
    public long e = -1;
    public final AtomicBoolean f = new AtomicBoolean();
    public final AtomicBoolean g = new AtomicBoolean();

    public C2625e3(C2672h c2672h, long j) {
        this.f2555a = c2672h;
        this.b = j;
    }

    public final void a() {
        C2672h c2672h;
        C2672h c2672h2;
        Long m;
        String h;
        Boolean C;
        Intrinsics.checkNotNull(this.c);
        C2672h c2672h3 = this.f2555a;
        if (c2672h3 != null && (C = c2672h3.C()) != null) {
            boolean booleanValue = C.booleanValue();
            C2676h3 c2676h3 = C2676h3.f2585a;
            Context d = Uc.d();
            if (d != null) {
                Intrinsics.checkNotNull("h3");
                if (booleanValue != C2676h3.d()) {
                    Intrinsics.checkNotNull("h3");
                    ConcurrentHashMap concurrentHashMap = C6.b;
                    C6.a(B6.a(d, "c_data_store"), "isEnabled", booleanValue, false, 4, (Object) null);
                    if (!booleanValue) {
                        c2676h3.e();
                    }
                }
            }
        }
        C2676h3 c2676h32 = C2676h3.f2585a;
        if (C2676h3.d() && !this.f.getAndSet(true)) {
            this.e = System.currentTimeMillis();
            if (!this.g.get()) {
                C2672h c2672h4 = this.f2555a;
                if ((c2672h4 != null ? c2672h4.h() : null) != null && (h = this.f2555a.h()) != null) {
                    C2692i3 c2692i3 = this.d;
                    c2692i3.getClass();
                    Intrinsics.checkNotNullParameter(h, "<set-?>");
                    c2692i3.f2594a = h;
                    Intrinsics.checkNotNull(this.c);
                }
            }
            if (!this.g.get() && (c2672h2 = this.f2555a) != null && (m = c2672h2.m()) != null) {
                this.d.b = m.longValue();
                Intrinsics.checkNotNull(this.c);
            }
            if (!this.g.get()) {
                this.d.e = this.b;
                Intrinsics.checkNotNull(this.c);
            }
            if (!this.g.get() && (c2672h = this.f2555a) != null) {
                this.d.f = c2672h.n();
                Intrinsics.checkNotNull(this.c);
            }
            long j = this.e / 1000;
            if (this.g.get()) {
                return;
            }
            this.d.c = j;
            Intrinsics.checkNotNull(this.c);
        }
    }

    public final void b() {
        C2676h3 c2676h3 = C2676h3.f2585a;
        if (!C2676h3.d()) {
            Intrinsics.checkNotNull(this.c);
            return;
        }
        if (!this.f.get()) {
            Intrinsics.checkNotNull(this.c);
            return;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.e);
        if (!this.g.get()) {
            this.d.d = currentTimeMillis;
            Intrinsics.checkNotNull(this.c);
        }
        if (this.g.getAndSet(true)) {
            Intrinsics.checkNotNull(this.c);
        } else {
            Intrinsics.checkNotNull(this.c);
            Uc.a(new Runnable() { // from class: com.inmobi.media.e3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C2625e3.a(C2625e3.this);
                }
            });
        }
    }

    public static final void a(C2625e3 this$0) {
        List<String> emptyList;
        AdConfig.ContextualDataConfig contextualData;
        AdConfig.ContextualDataConfig contextualData2;
        AdConfig.ContextualDataConfig contextualData3;
        AdConfig.ContextualDataConfig contextualData4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C2676h3 c2676h3 = C2676h3.f2585a;
        C2692i3 contextualDataModel = this$0.d;
        Intrinsics.checkNotNullParameter(contextualDataModel, "contextualDataModel");
        synchronized (c2676h3) {
            Intrinsics.checkNotNull("h3");
            long currentTimeMillis = System.currentTimeMillis();
            AdConfig adConfig = C2676h3.e;
            int i = 0;
            long expiryTime = currentTimeMillis - (((adConfig == null || (contextualData4 = adConfig.getContextualData()) == null) ? 0 : contextualData4.getExpiryTime()) * 1000);
            AdConfig adConfig2 = C2676h3.e;
            C2676h3.a(expiryTime, ((adConfig2 == null || (contextualData3 = adConfig2.getContextualData()) == null) ? 0 : contextualData3.getMaxAdRecords()) - 1);
            AdConfig adConfig3 = C2676h3.e;
            if (adConfig3 == null || (contextualData2 = adConfig3.getContextualData()) == null || (emptyList = contextualData2.getSkipFields()) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            String jSONArray = AbstractC2709j3.a(contextualDataModel, emptyList).toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray, "toString(...)");
            C2693i4 c2693i4 = new C2693i4(AbstractC2710j4.a(jSONArray, C2676h3.f), currentTimeMillis);
            C2676h3.b.add(c2693i4);
            Object clone = C2676h3.b.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.LinkedList<com.inmobi.signals.contextualdata.EncryptedContextualData>");
            C2676h3.c = (LinkedList) clone;
            AdConfig adConfig4 = C2676h3.e;
            if (adConfig4 != null && (contextualData = adConfig4.getContextualData()) != null) {
                i = contextualData.getMaxAdRecords();
            }
            Intrinsics.checkNotNull("h3");
            C2608d3 c2608d3 = (C2608d3) Nc.d.getValue();
            c2608d3.getClass();
            Objects.toString(c2693i4);
            c2608d3.a(c2693i4);
            c2608d3.a("id NOT IN (SELECT id FROM ( SELECT id FROM c_data WHERE timestamp > " + expiryTime + " ORDER BY timestamp DESC LIMIT " + i + ") foo);", null);
            Unit unit = Unit.INSTANCE;
        }
    }
}
