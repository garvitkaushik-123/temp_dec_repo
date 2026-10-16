package com.bytedance.sdk.openadsdk.core.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class nGm {
    private int MGA;
    private float aGH;
    private boolean du;
    private final eli eli;
    private int kb;
    private float ui;
    private final boolean DbA = false;
    private boolean Os = false;
    private boolean wC = true;
    private boolean FC = false;
    private final View.OnTouchListener aAs = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.nGm.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (nGm.this.eli.ev()) {
                return !nGm.this.Os;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                nGm ngm = nGm.this;
                ngm.du = ngm.eli(motionEvent);
                nGm.this.aGH = x;
                nGm.this.ui = y;
                nGm.this.MGA = (int) x;
                nGm.this.kb = (int) y;
                nGm.this.wC = true;
                if (nGm.this.eli != null && nGm.this.Os) {
                    nGm.this.eli.eli(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - nGm.this.MGA) > 20.0f || Math.abs(y - nGm.this.kb) > 20.0f) {
                    nGm.this.wC = false;
                }
                nGm.this.wC = true;
                nGm.this.FC = false;
                nGm.this.aGH = 0.0f;
                nGm.this.ui = 0.0f;
                nGm.this.MGA = 0;
                if (nGm.this.eli != null) {
                    nGm.this.eli.eli(view, nGm.this.wC);
                }
                nGm.this.du = false;
            } else if (action == 3) {
                nGm.this.du = false;
            }
            return !nGm.this.Os;
        }
    };

    public interface eli {
        void eli(View view, boolean z);

        boolean ev();
    }

    public nGm(eli eliVar) {
        this.eli = eliVar;
    }

    public void eli(View view) {
        if (view != null) {
            view.setOnTouchListener(this.aAs);
        }
    }

    public void eli(boolean z) {
        this.Os = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eli(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int Os = SSo.Os(com.bytedance.sdk.openadsdk.core.dV.eli().getApplicationContext());
        int ui = SSo.ui(com.bytedance.sdk.openadsdk.core.dV.eli().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = Os;
        if (rawX <= f * 0.01f || rawX >= f * 0.99f) {
            return true;
        }
        float f2 = ui;
        return rawY <= 0.01f * f2 || rawY >= f2 * 0.99f;
    }
}
