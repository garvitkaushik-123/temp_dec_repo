package com.unity3d.player;

import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.unity3d.player.a.AbstractC3495c;

/* renamed from: com.unity3d.player.c0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3515c0 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            ProgressBar progressBar = AbstractC3495c.b;
            if (progressBar != null) {
                if (AbstractC3495c.c != null) {
                    ViewGroup viewGroup = (ViewGroup) progressBar.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(AbstractC3495c.b);
                        viewGroup.removeView(AbstractC3495c.c);
                    }
                    AbstractC3495c.b = null;
                    AbstractC3495c.c = null;
                }
                AbstractC3495c.d = -1;
            }
        } catch (Exception e) {
            com.unity3d.player.a.t.Log(6, "Exception when hiding Activity Indicator " + e);
        }
    }
}
