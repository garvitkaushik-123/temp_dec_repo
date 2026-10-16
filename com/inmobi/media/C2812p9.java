package com.inmobi.media;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.TextView;

/* renamed from: com.inmobi.media.p9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2812p9 extends TextView {
    public C2812p9(Context context) {
        super(context);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int lineHeight = getLineHeight() > 0 ? i2 / getLineHeight() : 0;
        if (lineHeight > 0) {
            setSingleLine(false);
            setLines(lineHeight);
        }
        if (lineHeight == 1) {
            setSingleLine();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
