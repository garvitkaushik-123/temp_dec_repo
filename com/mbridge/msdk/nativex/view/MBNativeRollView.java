package com.mbridge.msdk.nativex.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;

/* loaded from: classes6.dex */
public class MBNativeRollView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private RollingBCView f4598a;
    private Context b;
    private NativeListener.FilpListener c;

    public interface a {
    }

    public MBNativeRollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f4598a.dispatchTouchEvent(motionEvent);
    }

    public void setData(List<Frame> list, Context context, String str, a aVar) {
        this.f4598a.setData(list, context, str, aVar);
    }

    public void setFilpListening(NativeListener.FilpListener filpListener) {
        if (filpListener != null) {
            this.c = filpListener;
            this.f4598a.setFilpListening(filpListener);
        }
    }

    public void setFrameWidth(int i) {
        this.f4598a.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
    }

    public MBNativeRollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        RollingBCView rollingBCView = new RollingBCView(context);
        this.f4598a = rollingBCView;
        addView(rollingBCView);
        this.f4598a.setLayoutParams(new LinearLayout.LayoutParams((int) (u0.j(context) * 0.9d), -2));
        setClipChildren(false);
    }

    public MBNativeRollView(Context context) {
        this(context, null);
    }
}
