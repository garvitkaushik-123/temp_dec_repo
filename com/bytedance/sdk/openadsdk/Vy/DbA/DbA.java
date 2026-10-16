package com.bytedance.sdk.openadsdk.Vy.DbA;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.core.model.ev;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public abstract class DbA {
    protected ev DbA;
    private volatile boolean FC = false;
    private final ui.eli MGA;
    protected final AtomicBoolean Os;
    private final AtomicLong aGH;
    protected WeakReference<View> eli;
    private final int kb;
    private final AtomicBoolean ui;
    private final Integer wC;

    protected abstract void DbA(int i);

    public abstract int MGA();

    protected abstract boolean Os();

    public static DbA eli(boolean z, Integer num, View view, ev evVar, ui.eli eliVar) {
        return z ? new wC(num, view, evVar, eliVar) : new Os(num, view, evVar, eliVar);
    }

    public DbA(Integer num, View view, ev evVar, int i, ui.eli eliVar) {
        this.wC = num;
        this.kb = i;
        this.DbA = evVar;
        this.MGA = eliVar;
        eli(view);
        this.Os = new AtomicBoolean(false);
        this.aGH = new AtomicLong(-1L);
        this.ui = new AtomicBoolean(false);
    }

    public void eli() {
        if (this.Os.compareAndSet(false, true)) {
            kb.eli(this);
        }
    }

    public int DbA() {
        if (FC()) {
            return 1;
        }
        WeakReference<View> weakReference = this.eli;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null || this.FC) {
            return 3;
        }
        if (du().equals(view.getTag(InputDeviceCompat.SOURCE_HDMI))) {
            return (du().equals(view.getTag(InputDeviceCompat.SOURCE_HDMI)) && Os()) ? 1 : 2;
        }
        aAs();
        ui.DbA(du());
        return 3;
    }

    protected void aGH() {
        if (this.ui.compareAndSet(false, true)) {
            aGH.eli(this.DbA, ui(), this.MGA);
        }
    }

    protected eli ui() {
        WeakReference<View> weakReference = this.eli;
        if (weakReference == null) {
            return new eli(-1, -1, -1.0f);
        }
        View view = weakReference.get();
        if (view == null) {
            return new eli(0, 0, 0.0f);
        }
        return new eli(view.getWidth(), view.getHeight(), view.getAlpha());
    }

    public void kb() {
        if (FC()) {
            return;
        }
        if (!this.Os.get()) {
            wC();
        } else if (!this.aGH.compareAndSet(-1L, System.currentTimeMillis()) && System.currentTimeMillis() - this.aGH.get() >= this.kb) {
            aGH();
        }
    }

    public void wC() {
        this.aGH.set(-1L);
    }

    public boolean FC() {
        return this.ui.get();
    }

    public void aAs() {
        this.FC = true;
        kb.DbA(this);
    }

    public void eli(int i) {
        if (i == 4) {
            eli();
            return;
        }
        if (i == 8) {
            NU();
        } else if (i == 9) {
            aGH();
        } else {
            DbA(i);
        }
    }

    public Integer du() {
        return this.wC;
    }

    public boolean nlS() {
        return this.Os.get();
    }

    public void NU() {
        this.Os.set(false);
        wC();
    }

    public void eli(View view) {
        if (view != null) {
            view.setTag(InputDeviceCompat.SOURCE_HDMI, du());
        }
        this.eli = new WeakReference<>(view);
    }
}
