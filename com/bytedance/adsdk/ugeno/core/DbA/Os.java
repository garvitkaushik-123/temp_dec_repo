package com.bytedance.adsdk.ugeno.core.DbA;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.bytedance.adsdk.ugeno.core.Dfc;
import com.bytedance.adsdk.ugeno.core.NU;

/* loaded from: classes3.dex */
public class Os {
    private float DbA;
    private final int MGA;
    private NU Os;
    private Context aGH;
    private float eli;
    private boolean ui;

    public Os(Context context, NU nu) {
        this.aGH = context;
        this.Os = nu;
        this.MGA = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean eli(Dfc dfc, com.bytedance.adsdk.ugeno.DbA.Os os, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.eli = motionEvent.getX();
            this.DbA = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.eli) >= this.MGA || Math.abs(y - this.DbA) >= this.MGA) {
                    this.ui = true;
                }
            } else if (action == 3) {
                this.ui = false;
            }
        } else {
            if (this.ui) {
                this.ui = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.eli) >= this.MGA || Math.abs(y2 - this.DbA) >= this.MGA) {
                this.ui = false;
            } else if (dfc != null) {
                dfc.eli(this.Os, os, os);
                return true;
            }
        }
        return true;
    }
}
