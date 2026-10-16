package com.bytedance.adsdk.ugeno.core.DbA;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.core.Dfc;
import com.bytedance.adsdk.ugeno.core.NU;
import com.bytedance.adsdk.ugeno.kb.wC;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class ui {
    private String FC;
    private eli NU;
    private Context aAs;
    private boolean du;
    private NU kb;
    private boolean nlS;
    private NU wC;
    private float eli = Float.MIN_VALUE;
    private float DbA = Float.MIN_VALUE;
    private int Os = 0;
    private int aGH = Integer.MAX_VALUE;
    private int ui = Integer.MAX_VALUE;
    private AtomicBoolean MGA = new AtomicBoolean(true);

    public ui(Context context, NU nu, boolean z, boolean z2) {
        this.aAs = context;
        this.kb = nu;
        this.du = z;
        this.nlS = z2;
        Os();
    }

    public ui(Context context, NU nu, NU nu2, boolean z, boolean z2) {
        this.aAs = context;
        this.kb = nu;
        this.wC = nu2;
        this.du = z;
        this.nlS = z2;
        Os();
    }

    private void Os() {
        if (this.nlS) {
            this.NU = new eli();
        }
        NU nu = this.kb;
        if (nu == null) {
            return;
        }
        this.Os = nu.Os().optInt("slideThreshold");
        this.FC = this.kb.Os().optString("slideDirection");
        this.aGH = this.kb.Os().optInt("frequency", Integer.MAX_VALUE);
        this.ui = this.kb.Os().optInt("effectiveDuration", Integer.MAX_VALUE);
        Log.d("GesThrough_UGSREvent", "mFrequency: " + this.aGH + ", mEffectiveDuration: " + this.ui + ", inEffectiveDuation: " + this.MGA.get());
    }

    public void eli() {
        if (this.ui == Integer.MAX_VALUE) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.core.DbA.ui.1
            @Override // java.lang.Runnable
            public void run() {
                ui.this.MGA.set(false);
                Log.d("GesThrough_UGSREvent", "inEffectiveDuation -> false");
            }
        }, this.ui);
    }

    public void DbA() {
        this.eli = Float.MIN_VALUE;
        this.DbA = Float.MIN_VALUE;
    }

    public boolean eli(Dfc dfc, com.bytedance.adsdk.ugeno.DbA.Os os, MotionEvent motionEvent, boolean z) {
        eli eliVar = this.NU;
        if (eliVar != null) {
            if (eliVar.eli(motionEvent)) {
                Log.d("GesThrough_UGSREvent", "mockEvent，skip");
                return false;
            }
            this.NU.eli(os, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.eli = motionEvent.getX();
            this.DbA = motionEvent.getY();
        } else {
            if (action != 1) {
                if (action == 3) {
                    if (this.eli == Float.MIN_VALUE || this.DbA == Float.MIN_VALUE) {
                        Log.d("GesThrough_UGSREvent", "Sequence CANCEL, don't handle");
                        return false;
                    }
                    Log.d("GesThrough_UGSREvent", "Sequence CANCEL, processed as UP event");
                }
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.du && Math.abs(x - this.eli) <= 10.0f && Math.abs(y - this.DbA) <= 10.0f && dfc != null) {
                DbA();
                dfc.eli(this.wC, os, os);
                return true;
            }
            if (this.Os == 0 && dfc != null) {
                DbA();
                eli(dfc, this.kb, os);
                return true;
            }
            int DbA = wC.DbA(this.aAs, x - this.eli);
            int DbA2 = wC.DbA(this.aAs, y - this.DbA);
            if (TextUtils.equals(this.FC, "up")) {
                DbA = -DbA2;
            } else if (TextUtils.equals(this.FC, "down")) {
                DbA = DbA2;
            } else if (TextUtils.equals(this.FC, "left")) {
                DbA = -DbA;
            } else if (!TextUtils.equals(this.FC, "right")) {
                DbA = (int) Math.abs(Math.sqrt(Math.pow(DbA, 2.0d) + Math.pow(DbA2, 2.0d)));
            }
            if (DbA >= this.Os) {
                Log.d("GesThrough_UGSREvent", "Right-slide event, direct handling");
                if (dfc != null) {
                    DbA();
                    eli(dfc, this.kb, os);
                    return true;
                }
                DbA();
            } else {
                DbA();
                Log.d("GesThrough_UGSREvent", "Non-right-slide event");
                eli(os);
                return false;
            }
        }
        return true;
    }

    private void eli(com.bytedance.adsdk.ugeno.DbA.Os os) {
        if (this.NU != null) {
            Log.d("GesThrough_UGSREvent", "need gesture through, replayGestureMotions");
            this.NU.eli(os);
        }
    }

    private void eli(Dfc dfc, NU nu, com.bytedance.adsdk.ugeno.DbA.Os os) {
        if (this.aGH <= 0) {
            Log.d("GesThrough_UGSREvent", "frequency <= 0, no trigger slide");
            eli(os);
        } else {
            if (!this.MGA.get()) {
                Log.d("GesThrough_UGSREvent", "not in effective duration, no trigger slide");
                eli(os);
                return;
            }
            dfc.eli(nu, os, os);
            int i = this.aGH;
            if (i != Integer.MAX_VALUE) {
                this.aGH = i - 1;
            }
        }
    }
}
