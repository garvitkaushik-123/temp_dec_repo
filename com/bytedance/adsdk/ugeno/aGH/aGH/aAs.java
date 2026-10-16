package com.bytedance.adsdk.ugeno.aGH.aGH;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.bytedance.adsdk.ugeno.kb.FC;

/* loaded from: classes3.dex */
public class aAs extends Os implements FC.eli {
    private Handler NU;
    private int du;
    private int nlS;
    private int nn;

    public aAs(Context context) {
        super(context);
        this.nlS = 0;
        this.NU = new com.bytedance.adsdk.ugeno.kb.FC(Looper.getMainLooper(), this);
        this.nn = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.aGH.Os
    public boolean eli(Object... objArr) {
        if (this.ui != null) {
            int eli = com.bytedance.adsdk.ugeno.kb.Os.eli(this.ui.get("loop"), 0);
            this.du = eli;
            if (eli <= 0) {
                this.nn = -1;
            } else {
                this.nn = eli;
            }
            this.nlS = com.bytedance.adsdk.ugeno.kb.Os.eli(this.ui.get("duration"), 0);
        }
        this.NU.sendEmptyMessageDelayed(1001, this.nlS);
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.kb.FC.eli
    public void eli(Message message) {
        int i;
        int i2;
        if (message.what != 1001) {
            return;
        }
        Log.d("UGBaseEventMonitor", "handleMsg: execute timer event" + this.nn);
        this.eli.eli(this.DbA, this.MGA, this.Os.DbA());
        int i3 = this.nn - 1;
        this.nn = i3;
        if (i3 < 0 && (i2 = this.nlS) != 0) {
            this.NU.sendEmptyMessageDelayed(1001, i2);
        } else if (i3 > 0 && (i = this.nlS) != 0) {
            this.NU.sendEmptyMessageDelayed(1001, i);
        } else {
            this.NU.removeMessages(1001);
        }
    }
}
