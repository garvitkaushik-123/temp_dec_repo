package com.bytedance.sdk.component.FC;

import android.content.Context;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes3.dex */
public abstract class Os implements View.OnTouchListener {
    private int DbA = -1;
    private ViewConfiguration eli;

    abstract void eli(View.OnTouchListener onTouchListener);

    boolean eli(float f, float f2, float f3, float f4, Context context) {
        if (this.eli == null) {
            this.eli = ViewConfiguration.get(context);
        }
        if (this.DbA == -1) {
            this.DbA = this.eli.getScaledTouchSlop();
        }
        new Object[]{"mTouchSlop is: ", Integer.valueOf(this.DbA)};
        if (Math.abs(f - f3) <= this.DbA && Math.abs(f2 - f4) <= this.DbA) {
            new Object[]{"isClick", "upX: ", Float.valueOf(f), " ,downX: ", Float.valueOf(f3), " ,upY: ", Float.valueOf(f2), "downY: ", Float.valueOf(f4)};
            return true;
        }
        new Object[]{"notClick", "upX: ", Float.valueOf(f), " ,downX: ", Float.valueOf(f3), " ,upY: ", Float.valueOf(f2), "downY: ", Float.valueOf(f4)};
        return false;
    }
}
