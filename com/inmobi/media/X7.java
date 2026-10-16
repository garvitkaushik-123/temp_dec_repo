package com.inmobi.media;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class X7 implements ff {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f2481a = new Rect();

    @Override // com.inmobi.media.ff
    public final boolean a(View rootView, View adView, int i) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(adView, "adView");
        return true;
    }

    @Override // com.inmobi.media.ff
    public final boolean a(View view, View view2, int i, Object obj) {
        G8 mediaPlayer;
        if (!(obj instanceof T7) || ((T7) obj).t) {
            return false;
        }
        if ((!(view2 instanceof C2747l9) || (mediaPlayer = ((C2747l9) view2).getMediaPlayer()) == null || 3 == mediaPlayer.f2294a) && view2 != null && view2.isShown()) {
            if ((view != null ? view.getParent() : null) == null || !view2.getGlobalVisibleRect(this.f2481a)) {
                return false;
            }
            long height = this.f2481a.height() * this.f2481a.width();
            long width = view.getWidth() * view.getHeight();
            if (width > 0 && 100 * height >= i * width) {
                return true;
            }
        }
        return false;
    }
}
