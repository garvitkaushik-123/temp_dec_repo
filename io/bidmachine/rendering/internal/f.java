package io.bidmachine.rendering.internal;

import android.content.Context;
import io.bidmachine.rendering.utils.DailyCleanStrategy;
import io.bidmachine.rendering.utils.FileUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f7060a = new AtomicBoolean(false);
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final Object c = new Object();

    private static void a(Context context) {
        new DailyCleanStrategy().clean(FileUtils.getExternalDir(context));
    }

    public static void b(Context context) {
        AtomicBoolean atomicBoolean = b;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (c) {
            if (f7060a.compareAndSet(false, true)) {
                a(context);
                c(context);
                atomicBoolean.set(true);
            }
        }
    }

    private static void c(Context context) {
        FileUtils.clearTempFiles(context);
    }
}
