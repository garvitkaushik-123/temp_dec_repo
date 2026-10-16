package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;
import android.widget.FrameLayout;

/* loaded from: classes7.dex */
public final class B extends AbstractC3553w {
    public boolean h;
    public Handler i;
    public RunnableC3559z j;

    @Override // com.unity3d.player.AbstractC3553w, com.unity3d.player.a.r
    public final boolean isConsumeOutsideTouchesEnabled() {
        return false;
    }

    public B(Context context, UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        super(context, unityPlayerForActivityOrService);
        this.h = false;
    }

    @Override // com.unity3d.player.a.r
    public final void a() {
        if (this.h) {
            return;
        }
        FrameLayout frameLayout = this.b.getFrameLayout();
        frameLayout.addView(this.c);
        frameLayout.bringChildToFront(this.c);
        this.c.setVisibility(0);
        this.c.requestFocus();
        this.j = new RunnableC3559z(this);
        Handler handler = new Handler(Looper.getMainLooper());
        this.i = handler;
        handler.postDelayed(this.j, 400L);
        this.h = true;
    }

    @Override // com.unity3d.player.a.r
    public final void hide() {
        RunnableC3559z runnableC3559z;
        Handler handler = this.i;
        if (handler != null && (runnableC3559z = this.j) != null) {
            handler.removeCallbacks(runnableC3559z);
        }
        this.b.getFrameLayout().removeView(this.c);
        this.h = false;
        invokeOnClose();
    }

    @Override // com.unity3d.player.AbstractC3553w
    public EditText createEditText(AbstractC3553w abstractC3553w) {
        return new A(this.f6582a, abstractC3553w);
    }

    @Override // com.unity3d.player.AbstractC3553w, com.unity3d.player.a.r
    public final void setHideInputField(boolean z) {
        this.d = z;
        if (z) {
            this.c.setVisibility(4);
        } else {
            this.c.setVisibility(0);
        }
        this.c.invalidate();
        this.c.requestLayout();
    }
}
