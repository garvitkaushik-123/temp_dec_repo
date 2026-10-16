package com.inmobi.media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.v4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2903v4 {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f2730a = LazyKt.lazy(C2887u4.f2719a);

    public static final void a(N9 mRequest, C2871t4 listener, C2854s4 eventPayload, int i, String str, int i2, long j, C2897ue c2897ue, boolean z) {
        Intrinsics.checkNotNullParameter(mRequest, "$request");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(eventPayload, "$eventPayload");
        Intrinsics.checkNotNullParameter(mRequest, "mRequest");
        P9 b = mRequest.b();
        if (b.b()) {
            boolean z2 = T9.f2439a;
            I9 i9 = b.d;
            EnumC2790o4 enumC2790o4 = i9 != null ? i9.f2315a : null;
            if (T9.f2439a && (enumC2790o4 == EnumC2790o4.q || enumC2790o4 == EnumC2790o4.p || enumC2790o4 == EnumC2790o4.o || enumC2790o4 == EnumC2790o4.n || enumC2790o4 == EnumC2790o4.r)) {
                listener.a(eventPayload, false);
                return;
            } else {
                if (i <= 1) {
                    listener.a(eventPayload, true);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue("v4", "TAG");
                b.a();
                a(eventPayload, str, i2, i - 1, j, c2897ue, listener, z);
                return;
            }
        }
        listener.getClass();
        Intrinsics.checkNotNullParameter(eventPayload, "eventPayload");
        String TAG = listener.d;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        listener.f2709a.a(eventPayload.f2701a);
        listener.f2709a.a(System.currentTimeMillis());
        if (listener.c != null) {
            ArrayList eventIds = eventPayload.f2701a;
            Intrinsics.checkNotNullParameter(eventIds, "eventIds");
            Integer num = Ud.c;
            if (num != null && eventIds.contains(Integer.valueOf(num.intValue()))) {
                Ud.b = 0;
                C6 c6 = Ud.f2454a;
                if (c6 != null) {
                    C6.a(c6, "count", 0, false, 4, (Object) null);
                }
                Ud.c = null;
            }
        }
        listener.e.set(false);
    }

    public static void a(final C2854s4 c2854s4, final String str, final int i, final int i2, final long j, final C2897ue c2897ue, final C2871t4 c2871t4, final boolean z) {
        long j2;
        long j3;
        HashMap hashMapOf;
        HashMap hashMap;
        Intrinsics.checkNotNullExpressionValue("v4", "TAG");
        boolean z2 = T9.f2439a;
        if (T9.a(false) == null && Uc.m()) {
            final N9 n9 = new N9("POST", str, c2897ue, false, (InterfaceC2971z5) null, (String) null, 104);
            HashMap hashMapOf2 = MapsKt.hashMapOf(TuplesKt.to("payload", c2854s4.b));
            if (hashMapOf2 != null && (hashMap = n9.k) != null) {
                hashMap.putAll(hashMapOf2);
            }
            int i3 = i - i2;
            if (i3 > 0 && (hashMapOf = MapsKt.hashMapOf(TuplesKt.to("X-im-retry-count", String.valueOf(i3)))) != null) {
                n9.i.putAll(hashMapOf);
            }
            n9.x = false;
            n9.t = false;
            n9.u = false;
            if (z) {
                if (i2 != i) {
                    j3 = ((long) Math.pow(2.0d, i3)) * j;
                    j2 = j3;
                    Object value = f2730a.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                    ((ScheduledExecutorService) value).schedule(new Runnable() { // from class: com.inmobi.media.v4$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            AbstractC2903v4.a(N9.this, c2871t4, c2854s4, i2, str, i, j, c2897ue, z);
                        }
                    }, j2, TimeUnit.SECONDS);
                    return;
                }
            } else if (i2 != i) {
                j2 = j;
                Object value2 = f2730a.getValue();
                Intrinsics.checkNotNullExpressionValue(value2, "getValue(...)");
                ((ScheduledExecutorService) value2).schedule(new Runnable() { // from class: com.inmobi.media.v4$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC2903v4.a(N9.this, c2871t4, c2854s4, i2, str, i, j, c2897ue, z);
                    }
                }, j2, TimeUnit.SECONDS);
                return;
            }
            j3 = 0;
            j2 = j3;
            Object value22 = f2730a.getValue();
            Intrinsics.checkNotNullExpressionValue(value22, "getValue(...)");
            ((ScheduledExecutorService) value22).schedule(new Runnable() { // from class: com.inmobi.media.v4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC2903v4.a(N9.this, c2871t4, c2854s4, i2, str, i, j, c2897ue, z);
                }
            }, j2, TimeUnit.SECONDS);
            return;
        }
        Intrinsics.checkNotNullExpressionValue("v4", "TAG");
        c2871t4.a(c2854s4, false);
    }
}
