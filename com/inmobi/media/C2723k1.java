package com.inmobi.media;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.k1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2723k1 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2723k1 f2618a = new C2723k1();
    public static LinkedHashSet b;
    public static boolean c;

    public static final boolean a(C2723k1 c2723k1, Context context) {
        c2723k1.getClass();
        try {
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                String packageName = context.getPackageName();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (packageName.equals(runningAppProcessInfo.processName)) {
                        return runningAppProcessInfo.importance == 100;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("k1", "TAG");
            return false;
        }
    }

    public static final /* synthetic */ String b() {
        return "k1";
    }

    public final void c() {
        c = true;
    }

    public final void d() {
        c = false;
    }

    public static final void a(C2723k1 c2723k1, boolean z) {
        LinkedHashSet linkedHashSet;
        c2723k1.getClass();
        if (Uc.d() == null || (linkedHashSet = b) == null) {
            return;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            try {
                ((Ce) ((InterfaceC2690i1) it.next())).a(z);
            } catch (Exception unused) {
                Intrinsics.checkNotNullExpressionValue("k1", "TAG");
            }
        }
    }

    public final void a(Context context, InterfaceC2690i1 listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (b == null) {
            b = new LinkedHashSet();
            Context applicationContext = context.getApplicationContext();
            Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
            if (application != null) {
                try {
                    application.registerActivityLifecycleCallbacks(new C2707j1(context));
                } catch (Throwable unused) {
                }
            }
        }
        LinkedHashSet linkedHashSet = b;
        if (linkedHashSet != null) {
            linkedHashSet.add(listener);
        }
    }
}
