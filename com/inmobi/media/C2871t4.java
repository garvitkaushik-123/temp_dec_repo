package com.inmobi.media;

import android.content.Context;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.t4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2871t4 {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC2838r4 f2709a;
    public final InterfaceC2909va b;
    public final Db c;
    public final String d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;
    public final LinkedList g;
    public ScheduledExecutorService h;
    public C2823q4 i;

    public C2871t4(AbstractC2838r4 mEventDao, InterfaceC2909va mPayloadProvider, C2823q4 eventConfig, Db db) {
        Intrinsics.checkNotNullParameter(mEventDao, "mEventDao");
        Intrinsics.checkNotNullParameter(mPayloadProvider, "mPayloadProvider");
        Intrinsics.checkNotNullParameter(eventConfig, "eventConfig");
        this.f2709a = mEventDao;
        this.b = mPayloadProvider;
        this.c = db;
        this.d = "t4";
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new LinkedList();
        this.i = eventConfig;
    }

    public final void a(long j, final boolean z) {
        if (this.g.contains(EventTaskParams.STATE_GROUP_DEFAULT)) {
            return;
        }
        this.g.add(EventTaskParams.STATE_GROUP_DEFAULT);
        if (this.h == null) {
            String TAG = this.d;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            this.h = Executors.newSingleThreadScheduledExecutor(new K5(TAG));
        }
        Intrinsics.checkNotNullExpressionValue(this.d, "TAG");
        ScheduledExecutorService scheduledExecutorService = this.h;
        if (scheduledExecutorService != null) {
            final C2897ue c2897ue = null;
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.t4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C2871t4.a(C2871t4.this, c2897ue, z);
                }
            };
            C2823q4 c2823q4 = this.i;
            AbstractC2838r4 abstractC2838r4 = this.f2709a;
            abstractC2838r4.getClass();
            Context d = Uc.d();
            long j2 = -1;
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6 a2 = B6.a(d, "batch_processing_info");
                String key = abstractC2838r4.f2433a.concat("_last_batch_process");
                Intrinsics.checkNotNullParameter(key, "key");
                j2 = a2.f2249a.getLong(key, -1L);
            }
            if (((int) j2) == -1) {
                this.f2709a.a(System.currentTimeMillis());
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            scheduledExecutorService.scheduleAtFixedRate(runnable, Math.max(0L, (timeUnit.toSeconds(j2) + (c2823q4 != null ? c2823q4.c : 0L)) - timeUnit.toSeconds(System.currentTimeMillis())), j, TimeUnit.SECONDS);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e4 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(C2871t4 listener, C2897ue c2897ue, boolean z) {
        int i;
        long j;
        boolean z2;
        ArrayList b;
        boolean z3;
        C2854s4 payload;
        Intrinsics.checkNotNullParameter(listener, "this$0");
        C2823q4 c2823q4 = listener.i;
        if (listener.f.get() || listener.e.get() || c2823q4 == null) {
            return;
        }
        String TAG = listener.d;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        AbstractC2838r4 abstractC2838r4 = listener.f2709a;
        long j2 = c2823q4.b;
        abstractC2838r4.getClass();
        abstractC2838r4.a("ts<?", new String[]{String.valueOf(System.currentTimeMillis() - (j2 * 1000))});
        Intrinsics.checkNotNullExpressionValue("r4", "TAG");
        AbstractC2838r4 abstractC2838r42 = listener.f2709a;
        abstractC2838r42.getClass();
        int a2 = T1.a(abstractC2838r42, null, null, 63);
        int p = L3.f2348a.p();
        C2823q4 c2823q42 = listener.i;
        if (c2823q42 == null) {
            i = 0;
        } else if (p == 0) {
            i = c2823q42.g;
        } else if (p != 1) {
            i = c2823q42.g;
        } else {
            i = c2823q42.e;
        }
        if (c2823q42 == null) {
            j = 0;
        } else if (p == 0) {
            j = c2823q42.j;
        } else if (p != 1) {
            j = c2823q42.j;
        } else {
            j = c2823q42.i;
        }
        AbstractC2838r4 abstractC2838r43 = listener.f2709a;
        long j3 = c2823q4.d;
        ArrayList b2 = abstractC2838r43.b(1);
        if (!b2.isEmpty()) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long currentTimeMillis = System.currentTimeMillis();
            Object obj = b2.get(0);
            Intrinsics.checkNotNull(obj);
            if (timeUnit.toSeconds(currentTimeMillis - ((U1) obj).b) > j3) {
                z2 = true;
                AbstractC2838r4 abstractC2838r44 = listener.f2709a;
                long j4 = c2823q4.c;
                long j5 = c2823q4.d;
                abstractC2838r44.getClass();
                Intrinsics.checkNotNullExpressionValue("r4", "TAG");
                TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
                long seconds = timeUnit2.toSeconds(System.currentTimeMillis()) + j4;
                b = abstractC2838r44.b(1);
                if (!b.isEmpty()) {
                    Object obj2 = b.get(0);
                    Intrinsics.checkNotNull(obj2);
                    if (seconds - timeUnit2.toSeconds(((U1) obj2).b) >= j5) {
                        z3 = true;
                        if ((i > a2 || z2 || z3) && (payload = listener.b.a()) != null) {
                            listener.e.set(true);
                            Lazy lazy = AbstractC2903v4.f2730a;
                            String str = c2823q4.k;
                            int i2 = c2823q4.f2679a + 1;
                            Intrinsics.checkNotNullParameter(payload, "payload");
                            Intrinsics.checkNotNullParameter(listener, "listener");
                            AbstractC2903v4.a(payload, str, i2, i2, j, c2897ue, listener, z);
                        }
                        return;
                    }
                }
                z3 = false;
                if (i > a2) {
                }
                listener.e.set(true);
                Lazy lazy2 = AbstractC2903v4.f2730a;
                String str2 = c2823q4.k;
                int i22 = c2823q4.f2679a + 1;
                Intrinsics.checkNotNullParameter(payload, "payload");
                Intrinsics.checkNotNullParameter(listener, "listener");
                AbstractC2903v4.a(payload, str2, i22, i22, j, c2897ue, listener, z);
            }
        }
        z2 = false;
        AbstractC2838r4 abstractC2838r442 = listener.f2709a;
        long j42 = c2823q4.c;
        long j52 = c2823q4.d;
        abstractC2838r442.getClass();
        Intrinsics.checkNotNullExpressionValue("r4", "TAG");
        TimeUnit timeUnit22 = TimeUnit.MILLISECONDS;
        long seconds2 = timeUnit22.toSeconds(System.currentTimeMillis()) + j42;
        b = abstractC2838r442.b(1);
        if (!b.isEmpty()) {
        }
        z3 = false;
        if (i > a2) {
        }
        listener.e.set(true);
        Lazy lazy22 = AbstractC2903v4.f2730a;
        String str22 = c2823q4.k;
        int i222 = c2823q4.f2679a + 1;
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(listener, "listener");
        AbstractC2903v4.a(payload, str22, i222, i222, j, c2897ue, listener, z);
    }

    public final void a(C2854s4 eventPayload, boolean z) {
        Intrinsics.checkNotNullParameter(eventPayload, "eventPayload");
        String TAG = this.d;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        eventPayload.getClass();
        this.f2709a.a(System.currentTimeMillis());
        if (this.c != null) {
            ArrayList eventIds = eventPayload.f2701a;
            Intrinsics.checkNotNullParameter(eventIds, "eventIds");
            Integer num = Ud.c;
            if (num != null && eventIds.contains(Integer.valueOf(num.intValue()))) {
                Ud.c = null;
            }
        }
        this.e.set(false);
    }
}
