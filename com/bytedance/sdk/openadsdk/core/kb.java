package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.component.utils.Ue;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class kb extends View implements Ue.eli {
    private boolean DbA;
    private final Handler FC;
    private List<View> MGA;
    private boolean NU;
    private eli Os;
    private final AtomicBoolean aAs;
    private View aGH;
    private ViewTreeObserver.OnGlobalLayoutListener du;
    private boolean eli;
    private boolean kb;
    private boolean nlS;
    private final Runnable nn;
    private List<View> ui;
    private int wC;

    public interface eli {
        void DbA();

        void eli();

        void eli(View view);

        void eli(boolean z);
    }

    public kb(Context context, View view, boolean z) {
        super(dV.eli());
        this.FC = new com.bytedance.sdk.component.utils.Ue(nn.DbA().getLooper(), this);
        this.aAs = new AtomicBoolean(true);
        this.NU = false;
        this.nn = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.3
            @Override // java.lang.Runnable
            public void run() {
                if (kb.this.Os != null) {
                    kb.this.Os.eli(kb.this.aGH);
                }
            }
        };
        this.nlS = z;
        this.aGH = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.du = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.kb.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (kb.this.NU) {
                    return;
                }
                kb.this.ui();
                kb.this.aGH();
            }
        };
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        eli eliVar = this.Os;
        if (eliVar != null) {
            eliVar.eli(z);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.kb = false;
        DbA();
        if (this.du != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.du);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        DbA();
    }

    private void DbA() {
        eli eliVar;
        if (!this.aAs.getAndSet(false) || (eliVar = this.Os) == null) {
            return;
        }
        eliVar.eli();
    }

    private void Os() {
        eli eliVar;
        if (this.aAs.getAndSet(true) || (eliVar = this.Os) == null) {
            return;
        }
        eliVar.DbA();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ui();
        this.kb = true;
        Os();
        eli(false);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Os();
    }

    public void setRefClickViews(List<View> list) {
        this.ui = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.MGA = list;
    }

    public void eli() {
        eli(this.ui, (com.bytedance.sdk.openadsdk.core.DbA.Os) null);
        eli(this.MGA, (com.bytedance.sdk.openadsdk.core.DbA.Os) null);
    }

    public void eli(List<View> list, com.bytedance.sdk.openadsdk.core.DbA.Os os) {
        if (com.bytedance.sdk.component.utils.NU.DbA(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(os);
                    view.setOnTouchListener(os);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH() {
        if (!this.DbA || this.eli) {
            return;
        }
        this.eli = true;
        this.FC.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui() {
        if (this.eli) {
            this.FC.removeCallbacksAndMessages(null);
            this.eli = false;
        }
    }

    public void setNeedCheckingShow(boolean z) {
        this.DbA = z;
        if (!z && this.eli) {
            ui();
        } else {
            if (!z || this.eli) {
                return;
            }
            aGH();
        }
    }

    public void setCallback(eli eliVar) {
        this.Os = eliVar;
    }

    public void setAdType(int i) {
        this.wC = i;
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        if (message.what == 1 && this.eli) {
            if (MGA() && nro.eli(this.aGH, 20, this.wC, this.nlS)) {
                ui();
                this.NU = true;
                nn.Os().post(this.nn);
                eli(true);
                return;
            }
            this.FC.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private boolean MGA() {
        View view = this.aGH;
        if (view instanceof com.bytedance.sdk.openadsdk.core.wC.Xb) {
            return ((com.bytedance.sdk.openadsdk.core.wC.Xb) view).ev();
        }
        return true;
    }

    private void eli(final boolean z) {
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        com.bytedance.sdk.component.utils.FC.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.2
            @Override // java.lang.Runnable
            public void run() {
                ViewTreeObserver viewTreeObserver2;
                if (kb.this.du != null && (viewTreeObserver2 = viewTreeObserver) != null) {
                    try {
                        viewTreeObserver2.removeOnGlobalLayoutListener(kb.this.du);
                    } catch (Exception unused) {
                    }
                }
                if (z) {
                    kb.this.du = null;
                }
            }
        });
    }
}
