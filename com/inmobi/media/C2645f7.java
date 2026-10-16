package com.inmobi.media;

import android.content.Context;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.f7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2645f7 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2568a;
    public final long b;
    public final long c;
    public final int d;
    public final int e;
    public final WeakReference f;
    public final AtomicBoolean g;

    public C2645f7(Context context, String url, long j, long j2, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f2568a = url;
        this.b = j;
        this.c = j2;
        this.d = i;
        this.e = i2;
        this.f = new WeakReference(context);
        this.g = new AtomicBoolean(false);
        a();
    }

    public final void a() {
        final Context context = (Context) this.f.get();
        if (context != null) {
            ScheduledExecutorService scheduledExecutorService = AbstractC2745l7.f2631a;
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.f7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C2645f7.a(C2645f7.this, context);
                }
            };
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            AbstractC2745l7.f2631a.submit(runnable);
        }
    }

    public static final void a(C2645f7 this$0, Context context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (this$0.g.get()) {
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this$0.g.get()) {
            int a2 = T1.a(Nc.d(), null, null, 63);
            Z6 d = Nc.d();
            d.getClass();
            ArrayList a3 = T1.a(d, "hasLoggerFinished=1", null, null, null, null, Integer.valueOf(a2), 30);
            C2629e7 action = new C2629e7(this$0, context);
            Intrinsics.checkNotNullParameter(a3, "<this>");
            Intrinsics.checkNotNullParameter(action, "action");
            Iterator it = CollectionsKt.filterNotNull(a3).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
        }
        ScheduledExecutorService scheduledExecutorService = AbstractC2745l7.f2631a;
        AbstractC2729k7.a(Nc.d(), Calendar.getInstance().getTimeInMillis() - this$0.c, this$0.e);
    }

    public final void a(final Context context, final String str, Y6 y6) {
        List<String> emptyList;
        int i;
        if (this.g.get()) {
            return;
        }
        if (y6.d == 0 || System.currentTimeMillis() - y6.d >= this.b) {
            P9 b = new C2664g7(str, y6).b();
            if (b.b() && (i = y6.c + 1) < this.d) {
                I9 i9 = b.d;
                if ((i9 != null ? i9.f2315a : null) != EnumC2790o4.s) {
                    final Y6 y62 = new Y6(y6.f2492a, y6.b, i, System.currentTimeMillis(), false, 0, 48);
                    Nc.d().b(y62);
                    ScheduledExecutorService scheduledExecutorService = AbstractC2745l7.f2631a;
                    long j = this.b;
                    Runnable runnable = new Runnable() { // from class: com.inmobi.media.f7$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            C2645f7.a(C2645f7.this, context, str, y62);
                        }
                    };
                    Intrinsics.checkNotNullParameter(runnable, "runnable");
                    AbstractC2745l7.f2631a.schedule(runnable, j, TimeUnit.MILLISECONDS);
                    return;
                }
            }
            AbstractC2761m7.a(y6.f2492a);
            Nc.d().a(y6);
            Context context2 = (Context) this.f.get();
            if (context2 != null) {
                ScheduledExecutorService scheduledExecutorService2 = AbstractC2745l7.f2631a;
                Intrinsics.checkNotNullParameter(context2, "context");
                String directoryPath = context2.getFilesDir() + "/logging";
                Intrinsics.checkNotNullParameter(directoryPath, "directoryPath");
                File file = new File(directoryPath);
                if (file.exists() && file.isDirectory()) {
                    String[] list = file.list();
                    if (list == null || (emptyList = ArraysKt.toList(list)) == null) {
                        emptyList = CollectionsKt.emptyList();
                    }
                } else {
                    emptyList = CollectionsKt.emptyList();
                }
                for (String fileName : emptyList) {
                    Z6 d = Nc.d();
                    d.getClass();
                    Intrinsics.checkNotNullParameter(fileName, "fileName");
                    if (T1.a(d, "filename=\"" + fileName + '\"', null, null, null, null, null, 62).isEmpty()) {
                        AbstractC2761m7.a(fileName);
                    }
                }
            }
        }
    }

    public static final void a(C2645f7 this$0, Context context, String url, Y6 updatedData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(updatedData, "$updatedData");
        this$0.a(context, url, updatedData);
    }
}
