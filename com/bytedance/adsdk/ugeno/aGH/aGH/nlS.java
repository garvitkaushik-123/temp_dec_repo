package com.bytedance.adsdk.ugeno.aGH.aGH;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.kb.FC;
import io.bidmachine.protobuf.EventTypeExtended;

/* loaded from: classes3.dex */
public class nlS extends Os implements FC.eli {
    private int du;
    private Handler nlS;

    public nlS(Context context) {
        super(context);
        this.du = 500;
        this.nlS = new com.bytedance.adsdk.ugeno.kb.FC(Looper.getMainLooper(), this);
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
            this.nlS.sendEmptyMessageDelayed(EventTypeExtended.EVENT_TYPE_CLICK_BY_SOURCE_VALUE, this.du);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        this.nlS.removeMessages(EventTypeExtended.EVENT_TYPE_CLICK_BY_SOURCE_VALUE);
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.kb.FC.eli
    public void eli(Message message) {
        if (message.what != 1101) {
            return;
        }
        if (this.eli != null) {
            this.eli.eli(this.DbA, this.MGA, this.Os.DbA());
        }
        Handler handler = this.nlS;
        if (handler != null) {
            handler.removeMessages(EventTypeExtended.EVENT_TYPE_CLICK_BY_SOURCE_VALUE);
        }
    }
}
