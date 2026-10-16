package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class FC implements nn, Runnable {
    private final Activity DbA;
    private boolean MGA;
    private long aGH;
    private final eli kb;
    private long ui;
    private boolean wC;
    private final AtomicBoolean FC = new AtomicBoolean(false);
    private final Handler Os = new Handler(Looper.getMainLooper());
    private View eli = aGH();

    public interface eli {
        void DbA();

        View eli();
    }

    public static nn eli(Activity activity, eli eliVar) {
        int HN = com.bytedance.sdk.openadsdk.core.settings.NU.nY().HN();
        if (HN < 0) {
            return new nn() { // from class: com.bytedance.sdk.openadsdk.utils.FC.1
                @Override // com.bytedance.sdk.openadsdk.utils.nn
                public void DbA() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.nn
                public void Os() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.nn
                public void eli() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.nn
                public void eli(long j) {
                }
            };
        }
        return new FC(activity, Math.min(HN, 50) * 1000, eliVar);
    }

    private FC(Activity activity, int i, eli eliVar) {
        this.kb = eliVar;
        this.DbA = activity;
        this.aGH = i;
    }

    private View aGH() {
        eli eliVar = this.kb;
        if (eliVar != null) {
            return eliVar.eli();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.nn
    public void eli(long j) {
        if (this.FC.compareAndSet(false, true)) {
            if (j < 0) {
                j = 0;
            }
            this.aGH += j;
            ui();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.nn
    public void eli() {
        if (this.ui == 0 || !this.wC) {
            return;
        }
        ui();
    }

    private void ui() {
        this.wC = false;
        this.ui = SystemClock.elapsedRealtime();
        Handler handler = this.Os;
        if (handler != null) {
            handler.postDelayed(this, this.aGH);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.nn
    public void DbA() {
        if (this.ui <= 0 || this.MGA) {
            return;
        }
        if (!this.wC) {
            this.aGH -= SystemClock.elapsedRealtime() - this.ui;
        }
        this.wC = true;
        if (this.aGH <= 0) {
            MGA();
            return;
        }
        Handler handler = this.Os;
        if (handler != null) {
            try {
                handler.removeCallbacks(this);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.Os(th.getMessage(), new Object[0]);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        MGA();
    }

    private void MGA() {
        Activity activity;
        View childAt;
        if (this.MGA || (activity = this.DbA) == null || activity.isFinishing() || this.DbA.isDestroyed()) {
            return;
        }
        if (this.eli == null) {
            this.eli = aGH();
        }
        View view = this.eli;
        if (view != null) {
            if (DbA(view)) {
                eli(this.eli);
                View view2 = this.eli;
                if ((view2 instanceof ViewGroup) && ((ViewGroup) view2).getChildCount() > 0 && (childAt = ((ViewGroup) this.eli).getChildAt(0)) != null && DbA(childAt)) {
                    eli(childAt);
                }
                eli eliVar = this.kb;
                if (eliVar != null) {
                    eliVar.DbA();
                }
            }
            kb();
        }
        this.MGA = true;
    }

    private void kb() {
        ViewParent parent = this.eli.getParent();
        if (parent instanceof ViewGroup) {
            if (((ViewGroup) parent).indexOfChild(this.eli) != r0.getChildCount() - 1) {
                this.eli.bringToFront();
            }
        }
    }

    private void eli(View view) {
        view.setVisibility(0);
        view.setAlpha(1.0f);
    }

    private boolean DbA(View view) {
        if (view == null) {
            return true;
        }
        return !view.isShown() || ((double) view.getAlpha()) <= 0.9d;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.nn
    public void Os() {
        if (this.MGA) {
            return;
        }
        this.MGA = true;
        Handler handler = this.Os;
        if (handler != null) {
            try {
                handler.removeCallbacks(this);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.Os(th.getMessage(), new Object[0]);
            }
        }
    }
}
