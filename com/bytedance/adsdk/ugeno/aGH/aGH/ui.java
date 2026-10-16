package com.bytedance.adsdk.ugeno.aGH.aGH;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class ui extends Os {
    private int Dfc;
    private int NU;
    private AtomicBoolean aqO;
    private String dV;
    private float du;
    private com.bytedance.adsdk.ugeno.core.DbA.eli nGm;
    private float nlS;
    private int nn;

    public ui(Context context) {
        super(context);
        this.NU = 0;
        this.nn = Integer.MAX_VALUE;
        this.Dfc = Integer.MAX_VALUE;
        this.aqO = new AtomicBoolean(true);
        this.dV = "up";
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.aGH.Os
    public boolean eli(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        if (this.ui != null) {
            this.dV = TextUtils.isEmpty(this.ui.get("direction")) ? "all" : this.ui.get("direction");
            this.NU = com.bytedance.adsdk.ugeno.kb.Os.eli(this.ui.get("distance"), 0);
            if (this.nn == Integer.MAX_VALUE) {
                this.nn = com.bytedance.adsdk.ugeno.kb.Os.eli(this.ui.get("frequency"), Integer.MAX_VALUE);
            }
            if (this.Dfc == Integer.MAX_VALUE) {
                this.Dfc = com.bytedance.adsdk.ugeno.kb.Os.eli(this.ui.get("effectiveDuration"), Integer.MAX_VALUE);
            }
            Log.d("GesThrough_UGSlideEvent", "mFrequency: " + this.nn + ", mEffectiveDuration: " + this.Dfc + ", inEffectiveDuation: " + this.aqO.get());
        }
        if (this.DbA != null && this.DbA.QI() && this.nGm == null) {
            this.nGm = new com.bytedance.adsdk.ugeno.core.DbA.eli();
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        eli();
        return eli(this.DbA, motionEvent);
    }

    private void eli() {
        if (this.Dfc == Integer.MAX_VALUE || this.DbA == null || System.currentTimeMillis() - this.DbA.gG() < this.Dfc) {
            return;
        }
        this.aqO.set(false);
        Log.d("GesThrough_UGSlideEvent", "inEffectiveDuation -> false");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean eli(com.bytedance.adsdk.ugeno.DbA.Os os, MotionEvent motionEvent) {
        char c;
        com.bytedance.adsdk.ugeno.core.DbA.eli eliVar = this.nGm;
        if (eliVar != null) {
            if (eliVar.eli(motionEvent)) {
                Log.d("GesThrough_UGSlideEvent", "mockEvent，skip");
                return false;
            }
            this.nGm.eli(os, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.du = motionEvent.getX();
            this.nlS = motionEvent.getY();
        } else if (action == 1 || action == 3) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.NU == 0 && this.eli != null) {
                Os(os);
                return true;
            }
            int DbA = com.bytedance.adsdk.ugeno.kb.wC.DbA(this.aAs, x - this.du);
            int DbA2 = com.bytedance.adsdk.ugeno.kb.wC.DbA(this.aAs, y - this.nlS);
            String str = this.dV;
            switch (str.hashCode()) {
                case 3739:
                    if (str.equals("up")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 96673:
                    if (str.equals("all")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3089570:
                    if (str.equals("down")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                DbA = -DbA2;
            } else if (c == 1) {
                DbA = DbA2;
            } else if (c == 2) {
                DbA = -DbA;
            } else if (c != 3) {
                DbA = (int) Math.abs(Math.sqrt(Math.pow(DbA, 2.0d) + Math.pow(DbA2, 2.0d)));
            }
            if (DbA >= this.NU) {
                Log.d("GesThrough_UGSlideEvent", "Slide event, direct handling");
                if (this.eli != null) {
                    this.du = 0.0f;
                    this.nlS = 0.0f;
                    Os(os);
                    return true;
                }
            } else {
                Log.d("GesThrough_UGSlideEvent", "Non-slide event");
                DbA(os);
                return false;
            }
        }
        return true;
    }

    private void DbA(com.bytedance.adsdk.ugeno.DbA.Os os) {
        if (this.nGm != null) {
            Log.d("GesThrough_UGSlideEvent", "need gesture through, replayGestureMotions");
            this.nGm.eli(os);
        }
    }

    private void Os(com.bytedance.adsdk.ugeno.DbA.Os os) {
        if (this.nn <= 0) {
            Log.d("GesThrough_UGSlideEvent", "frequency <= 0, no trigger slide");
            DbA(os);
        } else {
            if (!this.aqO.get()) {
                Log.d("GesThrough_UGSlideEvent", "not in effective duration, no trigger slide");
                DbA(os);
                return;
            }
            this.eli.eli(os, this.MGA, this.Os.DbA());
            int i = this.nn;
            if (i != Integer.MAX_VALUE) {
                this.nn = i - 1;
            }
        }
    }
}
