package com.bytedance.adsdk.ugeno.aGH.aGH;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;

/* loaded from: classes3.dex */
public class FC extends Os {
    private boolean NU;
    private float du;
    private float nlS;
    private com.bytedance.adsdk.ugeno.core.DbA.eli nn;

    public FC(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.aGH.Os
    public boolean eli(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        if (this.DbA != null && this.DbA.QI() && this.nn == null) {
            this.nn = new com.bytedance.adsdk.ugeno.core.DbA.eli();
        }
        return eli(this.DbA, (MotionEvent) objArr[0]);
    }

    public boolean eli(com.bytedance.adsdk.ugeno.DbA.Os os, MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.core.DbA.eli eliVar = this.nn;
        if (eliVar != null) {
            if (eliVar.eli(motionEvent)) {
                Log.d("GesThrough_UGTapEvent", "mockEvent，skip");
                return false;
            }
            this.nn.eli(os, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.du = motionEvent.getRawX();
            this.nlS = motionEvent.getRawY();
        } else if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (Math.abs(rawX - this.du) >= 15.0f || Math.abs(rawY - this.nlS) >= 15.0f) {
                    this.NU = true;
                }
            } else if (action == 3) {
                this.NU = false;
            }
        } else {
            if (this.NU) {
                this.NU = false;
                this.du = 0.0f;
                this.nlS = 0.0f;
                if (this.nn != null) {
                    Log.d("GesThrough_UGTapEvent", "Non-tap event, need gesture through");
                    this.nn.eli(os);
                }
                return false;
            }
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            if (Math.abs(rawX2 - this.du) >= 15.0f || Math.abs(rawY2 - this.nlS) >= 15.0f) {
                this.NU = false;
                if (this.nn != null) {
                    Log.d("GesThrough_UGTapEvent", "Non-tap event, need gesture through");
                    this.nn.eli(os);
                }
            } else {
                Log.d("GesThrough_UGTapEvent", "Tap event, direct handling");
                if (this.eli != null) {
                    this.eli.eli(os, this.MGA, this.Os.DbA());
                    this.du = 0.0f;
                    this.nlS = 0.0f;
                    return true;
                }
            }
        }
        return true;
    }
}
