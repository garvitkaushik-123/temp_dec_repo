package com.bytedance.sdk.openadsdk.core.Os;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.nro;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class MGA extends com.bytedance.adsdk.ugeno.MGA.eli<View> implements Ue.eli {
    private eli FC;
    private boolean MGA;
    private final Runnable aAs;
    private final Handler aGH;
    private final ViewTreeObserver.OnScrollChangedListener du;
    private boolean kb;
    private long ui;
    private DbA wC;

    public interface DbA {
        void eli(boolean z);
    }

    public interface eli {
        void eli(boolean z);
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        if (message.what == 1) {
            kb();
        }
    }

    private void kb() {
        boolean eli2 = nro.eli(this, 50, -1, false);
        this.kb = eli2;
        if (eli2 == this.MGA) {
            return;
        }
        this.MGA = eli2;
        cyF.eli(this.aAs);
    }

    public MGA(Context context) {
        super(context);
        this.aGH = new Ue(nn.DbA().getLooper(), this);
        this.MGA = true;
        this.kb = true;
        this.aAs = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Os.MGA.1
            @Override // java.lang.Runnable
            public void run() {
                if (MGA.this.FC != null) {
                    MGA.this.FC.eli(MGA.this.kb);
                }
            }
        };
        this.du = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.Os.MGA.2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - MGA.this.ui > 500) {
                    MGA.this.ui = elapsedRealtime;
                    MGA.this.aGH.sendEmptyMessageDelayed(1, 500L);
                }
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.du);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.du);
        }
    }

    public void setSwiperWindowFocusChangedListener(DbA dbA) {
        this.wC = dbA;
    }

    public void setSwiperVisibleChangeListener(eli eliVar) {
        this.FC = eliVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        DbA dbA = this.wC;
        if (dbA != null) {
            dbA.eli(z);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MGA.eli
    public View aAs(int i) {
        return (View) this.eli.get(i);
    }
}
