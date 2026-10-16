package com.bytedance.sdk.openadsdk.core.wC;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.nlS;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class ev extends GestureDetector {
    private final com.bytedance.sdk.openadsdk.core.DbA.MGA DbA;
    private final eli eli;

    public ev(Context context) {
        this(context, new eli());
    }

    public ev(Context context, eli eliVar) {
        super(context, eliVar);
        this.eli = eliVar;
        this.DbA = new com.bytedance.sdk.openadsdk.core.DbA.MGA();
        setIsLongpressEnabled(false);
    }

    void eli() {
        this.eli.eli();
    }

    public boolean DbA() {
        return this.eli.DbA();
    }

    public com.bytedance.sdk.openadsdk.core.model.nlS eli(Context context, View view, View view2) {
        if (this.DbA == null) {
            return new nlS.eli().eli();
        }
        return new nlS.eli().MGA(this.DbA.eli).ui(this.DbA.DbA).aGH(this.DbA.Os).Os(this.DbA.aGH).DbA(this.DbA.ui).eli(this.DbA.MGA).DbA(SSo.eli(view)).eli(SSo.eli(view2)).Os(SSo.Os(view)).aGH(SSo.Os(view2)).aGH(this.DbA.kb).ui(this.DbA.wC).MGA(this.DbA.FC).eli(this.DbA.nlS).DbA(com.bytedance.sdk.openadsdk.core.FC.DbA().eli() ? 1 : 2).eli("vessel").eli(SSo.wC(context)).Os(SSo.aAs(context)).DbA(SSo.FC(context)).eli();
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.DbA.eli(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    static class eli extends GestureDetector.SimpleOnGestureListener {
        boolean eli = false;

        eli() {
        }

        void eli() {
            this.eli = false;
        }

        boolean DbA() {
            return this.eli;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.eli = true;
            return super.onSingleTapUp(motionEvent);
        }
    }
}
