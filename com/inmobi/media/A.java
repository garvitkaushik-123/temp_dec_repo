package com.inmobi.media;

import android.os.Looper;
import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    public static final A f2225a = new A();
    public static final SparseArray b = new SparseArray();
    public static final ThreadPoolExecutor c;

    public static void a(final int i, final G1 task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            c(i, task);
            return;
        }
        ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.A$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                A.b(i, task);
            }
        };
        executorC2793o7.getClass();
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        executorC2793o7.f2659a.post(runnable);
    }

    public static final void b(int i, G1 task) {
        Intrinsics.checkNotNullParameter(task, "$task");
        c(i, task);
    }

    public static void c(int i, G1 g1) {
        try {
            SparseArray sparseArray = b;
            Queue queue = (Queue) sparseArray.get(i);
            if (queue == null) {
                queue = new LinkedList();
                sparseArray.put(i, queue);
            }
            queue.add(g1);
            G1 g12 = (G1) queue.peek();
            if (queue.size() != 1 || g12 == null) {
                return;
            }
            try {
                c.execute(g12);
            } catch (OutOfMemoryError unused) {
                g12.c();
            }
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    static {
        LinkedHashMap linkedHashMap = O2.f2380a;
        AdConfig adConfig = (AdConfig) AbstractC2808p5.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(adConfig.getMaxPoolSize(), adConfig.getMaxPoolSize(), 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new K5(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS.concat("-AD")));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        c = threadPoolExecutor;
    }
}
