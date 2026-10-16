package com.bytedance.sdk.component.FC;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.utils.Xb;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH extends Os {
    private final int DbA;
    private float FC;
    private View.OnTouchListener MGA;
    private final long Os;
    private String aAs;
    private final Context aGH;
    private final View.OnTouchListener eli;
    private long kb = -1;
    private final MGA ui;
    private float wC;

    public aGH(Context context, View.OnTouchListener onTouchListener, int i, long j, MGA mga) {
        this.aGH = context;
        this.eli = onTouchListener;
        this.DbA = i;
        this.Os = j;
        this.ui = mga;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        aGH agh;
        int action = motionEvent.getAction();
        new Object[]{"action: ", Integer.valueOf(action), ", x: ", Float.valueOf(motionEvent.getX()), ",y: ", Float.valueOf(motionEvent.getY())};
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            agh = this;
            agh.wC = x;
            agh.FC = y;
        } else if (action != 1) {
            agh = this;
        } else {
            agh = this;
            if (agh.eli(x, y, this.wC, this.FC, this.aGH)) {
                if (eli(SystemClock.elapsedRealtime())) {
                    motionEvent.setAction(3);
                    eli(1, x, y);
                } else {
                    eli(0, x, y);
                }
            }
        }
        View.OnTouchListener onTouchListener = agh.eli;
        if (onTouchListener != null) {
            onTouchListener.onTouch(view, motionEvent);
        }
        View.OnTouchListener onTouchListener2 = agh.MGA;
        if (onTouchListener2 != null) {
            onTouchListener2.onTouch(view, motionEvent);
        }
        return false;
    }

    private boolean eli(long j) {
        long j2 = this.kb;
        if (j2 == -1) {
            this.kb = j;
            return false;
        }
        int i = this.DbA;
        if (i == 1) {
            if (j - j2 <= this.Os) {
                return true;
            }
            this.kb = j;
            return false;
        }
        if (i == 2) {
            if (j - j2 <= this.Os) {
                this.kb = j;
                return true;
            }
            this.kb = j;
        }
        return false;
    }

    private void eli(int i, float f, float f2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("is_interceptor", i);
            jSONObject2.put("click_x", f);
            jSONObject2.put("click_y", f2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("lp_click_type", this.DbA);
            jSONObject3.put("lp_click_interval", this.Os);
            jSONObject2.put("pag_json_data", jSONObject3.toString());
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Throwable th) {
            Xb.eli("LpClickIntervalTouchListener", "sendLpClickInterceptEvent", th);
        }
        if (com.bytedance.sdk.component.FC.eli.eli.eli().DbA() != null) {
            com.bytedance.sdk.component.FC.eli.DbA DbA = com.bytedance.sdk.component.FC.eli.eli.eli().DbA();
            MGA mga = this.ui;
            DbA.eli(mga != null ? mga.getMaterialMeta() : null, this.aAs, "click_interval_intercept", jSONObject);
        }
    }

    public void eli(String str) {
        this.aAs = str;
    }

    @Override // com.bytedance.sdk.component.FC.Os
    public void eli(View.OnTouchListener onTouchListener) {
        this.MGA = onTouchListener;
    }
}
