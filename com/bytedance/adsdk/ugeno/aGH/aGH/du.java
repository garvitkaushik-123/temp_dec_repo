package com.bytedance.adsdk.ugeno.aGH.aGH;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.kb.FC;

/* loaded from: classes3.dex */
public class du extends Os implements FC.eli {
    private Handler NU;
    private int du;
    private boolean nlS;

    public du(Context context) {
        super(context);
        this.du = 500;
        this.NU = new com.bytedance.adsdk.ugeno.kb.FC(Looper.getMainLooper(), this);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.aGH.Os
    public boolean eli(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        this.du = com.bytedance.adsdk.ugeno.kb.Os.eli(this.ui.get("delay"), 500);
        return eli(this.DbA, motionEvent);
    }

    private boolean eli(com.bytedance.adsdk.ugeno.DbA.Os os, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.NU.sendEmptyMessageDelayed(1102, this.du);
        } else {
            if (action == 1) {
                if (this.nlS && this.eli != null) {
                    this.eli.eli(this.DbA, this.MGA, this.Os.DbA());
                    this.nlS = false;
                    Handler handler = this.NU;
                    if (handler != null) {
                        handler.removeMessages(1102);
                    }
                    return true;
                }
                Handler handler2 = this.NU;
                if (handler2 != null) {
                    handler2.removeMessages(1102);
                }
                this.nlS = false;
                return false;
            }
            if (action == 3) {
                Handler handler3 = this.NU;
                if (handler3 != null) {
                    handler3.removeMessages(1102);
                }
                this.nlS = false;
            }
        }
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.kb.FC.eli
    public void eli(Message message) {
        if (message.what != 1102) {
            return;
        }
        this.nlS = true;
        Handler handler = this.NU;
        if (handler != null) {
            handler.removeMessages(1102);
        }
    }
}
