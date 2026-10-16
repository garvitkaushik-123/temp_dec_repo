package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.view.Window;
import com.bytedance.sdk.openadsdk.ApmHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class eli implements Application.ActivityLifecycleCallbacks {
    public static long DbA = 0;
    public static long Os = 0;
    public static boolean eli = false;
    private final aGH FC;
    private volatile WeakReference<Activity> nn;
    private final aGH wC;
    private final AtomicBoolean aGH = new AtomicBoolean(false);
    private final RunnableC0214eli ui = new RunnableC0214eli();
    private final MGA MGA = new MGA();
    private final ui kb = new ui();
    private int aAs = 0;
    private volatile CopyOnWriteArrayList<WeakReference<com.bytedance.sdk.component.adexpress.eli>> du = new CopyOnWriteArrayList<>();
    private HandlerThread nlS = null;
    private Handler NU = null;
    private final LinkedList<Activity> Dfc = new LinkedList<>();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public eli() {
        this.wC = new DbA();
        this.FC = new Os();
        Os();
    }

    private void Os() {
        this.nlS = com.bytedance.sdk.component.utils.wC.eli("lifecycle", 10);
        this.NU = new Handler(this.nlS.getLooper());
    }

    private void eli(Runnable runnable) {
        if (!this.nlS.isAlive()) {
            Os();
        }
        this.NU.postDelayed(runnable, 1000L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.Dfc.addFirst(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(final Activity activity) {
        Window window;
        try {
            if (SSo.DbA() && (window = activity.getWindow()) != null) {
                final View decorView = window.getDecorView();
                decorView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.eli.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        decorView.removeOnAttachStateChangeListener(this);
                        if (SSo.aGH(activity)) {
                            SSo.eli(true);
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        decorView.removeOnAttachStateChangeListener(this);
                    }
                });
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.eli("TTAD.ActivityLifecycle", th);
        }
        this.aAs++;
        if (this.aGH.get()) {
            this.NU.removeCallbacks(this.FC);
            this.NU.removeCallbacks(this.wC);
            eli(this.FC);
        }
        this.aGH.set(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        eli(this.MGA);
        if (!eli) {
            DbA = System.currentTimeMillis();
            eli = true;
        }
        this.nn = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        int i = this.aAs - 1;
        this.aAs = i;
        if (i < 0) {
            this.aAs = 0;
        }
        if (ApmHelper.isIsInit()) {
            eli(this.kb);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.utils.eli$eli, reason: collision with other inner class name */
    static class RunnableC0214eli implements Runnable {
        RunnableC0214eli() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cyF.Os(new com.bytedance.sdk.component.wC.wC("reportPvFromBackGround") { // from class: com.bytedance.sdk.openadsdk.utils.eli.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    ApmHelper.reportPvFromBackGround();
                }
            });
        }
    }

    class MGA implements Runnable {
        MGA() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.nn.DbA().removeMessages(1001);
            com.bytedance.sdk.openadsdk.core.dV.eli();
        }
    }

    class ui implements Runnable {
        ui() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ApmHelper.isIsInit()) {
                Handler DbA = com.bytedance.sdk.openadsdk.core.nn.DbA();
                Message obtain = Message.obtain(DbA, eli.this.ui);
                obtain.what = 1001;
                DbA.sendMessageDelayed(obtain, 30000L);
            }
        }
    }

    private static class aGH implements Runnable {
        private aGH() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.aGH.eli.nn yKf = com.bytedance.sdk.openadsdk.core.settings.NU.nY().yKf();
            if (yKf == null || yKf.eli() || !com.bytedance.sdk.component.utils.nGm.wC(com.bytedance.sdk.openadsdk.core.dV.eli())) {
                return;
            }
            com.bytedance.sdk.openadsdk.aGH.eli.aGH.eli(com.bytedance.sdk.openadsdk.core.nlS.eli(com.bytedance.sdk.openadsdk.core.dV.eli()));
        }
    }

    private static class Os extends aGH {
        private Os() {
            super();
        }

        @Override // com.bytedance.sdk.openadsdk.utils.eli.aGH, java.lang.Runnable
        public void run() {
            super.run();
            com.bytedance.sdk.openadsdk.utils.ui.eli();
        }
    }

    private static class DbA extends aGH {
        private DbA() {
            super();
        }

        @Override // com.bytedance.sdk.openadsdk.utils.eli.aGH, java.lang.Runnable
        public void run() {
            super.run();
            com.bytedance.sdk.openadsdk.MGA.DbA.eli().DbA();
            com.bytedance.sdk.openadsdk.utils.ui.DbA();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.aAs <= 0) {
            this.aGH.set(true);
        }
        if (eli()) {
            eli = false;
            com.bytedance.sdk.openadsdk.core.nn.DbA.set(false);
            Os = System.currentTimeMillis();
            this.NU.removeCallbacks(this.FC);
            this.NU.removeCallbacks(this.wC);
            eli(this.wC);
        }
        eli(new kb(DbA, Os, eli()));
    }

    public class kb implements Runnable {
        private long DbA;
        private long Os;
        private boolean aGH;

        public kb(long j, long j2, boolean z) {
            this.DbA = j;
            this.Os = j2;
            this.aGH = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.aGH) {
                com.bytedance.sdk.openadsdk.Dfc.Os.eli().eli(this.DbA / 1000, this.Os / 1000);
            }
            eli.this.aGH();
        }
    }

    public void eli(com.bytedance.sdk.component.adexpress.eli eliVar) {
        this.du.add(new WeakReference<>(eliVar));
    }

    public boolean DbA(com.bytedance.sdk.component.adexpress.eli eliVar) {
        return this.du.remove(new WeakReference(eliVar));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.du != null && this.du.size() > 0) {
            Iterator<WeakReference<com.bytedance.sdk.component.adexpress.eli>> it = this.du.iterator();
            while (it.hasNext()) {
                WeakReference<com.bytedance.sdk.component.adexpress.eli> next = it.next();
                if (next != null && next.get() != null) {
                    try {
                        next.get().eli(activity);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        if (this.nn != null && this.nn.get() == activity) {
            this.nn = null;
        }
        this.Dfc.remove(activity);
    }

    public boolean eli() {
        return this.aGH.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH() {
        com.bytedance.sdk.openadsdk.aGH.eli.eli.eli();
    }

    public boolean eli(boolean z) {
        Activity activity;
        Window window;
        return (this.nn == null || (activity = this.nn.get()) == null || (window = activity.getWindow()) == null) ? z : window.getDecorView().hasWindowFocus();
    }

    public Activity DbA() {
        if (this.Dfc.isEmpty()) {
            return null;
        }
        return this.Dfc.getFirst();
    }
}
