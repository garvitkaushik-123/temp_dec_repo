package com.fyber.inneractive.sdk.renderers;

import android.graphics.Rect;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.flow.o0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.x0;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class d {
    public final RelativeLayout b;
    public final f i;
    public float c = 0.0f;
    public int d = 1;
    public float e = 0.0f;
    public long f = 0;
    public boolean g = false;
    public boolean h = false;
    public final b j = new b(this);

    /* renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.util.j f1714a = new com.fyber.inneractive.sdk.util.j(4, new c());

    public d(com.fyber.inneractive.sdk.response.f fVar, RelativeLayout relativeLayout, f fVar2) {
        this.b = relativeLayout;
        this.i = fVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        boolean z;
        String str;
        IAlog.a("IAVisibilityTracker: onCheckVisibility", new Object[0]);
        float f = this.d / 100.0f;
        com.fyber.inneractive.sdk.util.j jVar = this.f1714a;
        Object poll = jVar.f1761a.poll();
        if (poll == null) {
            poll = jVar.b.a();
        }
        Rect rect = (Rect) poll;
        RelativeLayout relativeLayout = this.b;
        float width = (relativeLayout.getParent() != null && relativeLayout.isShown() && relativeLayout.hasWindowFocus() && relativeLayout.getGlobalVisibleRect(rect)) ? (rect.width() * rect.height()) / (relativeLayout.getWidth() * relativeLayout.getHeight()) : 0.0f;
        this.f1714a.f1761a.offer(rect);
        this.c = width;
        if (width >= f) {
            float f2 = this.e * 1000.0f;
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f;
            if (f2 < currentTimeMillis - j && j != 0) {
                z = true;
                IAlog.a("BannerVisibilityTracker | visible = %s, minVis = %f", Boolean.valueOf(z), Float.valueOf(f));
                if (z || !this.g) {
                    if (this.g) {
                        return;
                    }
                    float f3 = this.c;
                    if (f3 < f) {
                        this.f = 0L;
                    } else if (f3 >= f && this.f == 0) {
                        this.f = System.currentTimeMillis();
                    }
                    Handler handler = com.fyber.inneractive.sdk.util.r.b;
                    handler.removeCallbacks(this.j);
                    handler.postDelayed(this.j, 50L);
                    return;
                }
                if (this.i == null || this.h) {
                    return;
                }
                this.h = true;
                IAlog.a("BannerVisibilityTracker | firing viewable", new Object[0]);
                k kVar = this.i.f1715a;
                kVar.getClass();
                try {
                    x xVar = kVar.b;
                    if (xVar == null || ((o0) xVar).b == null || (str = ((com.fyber.inneractive.sdk.response.f) ((o0) xVar).b).x) == null || str.trim().length() <= 0) {
                        return;
                    }
                    IAlog.e("%sfiring banner mrc visibility impression!", IAlog.a(kVar));
                    IAlog.d("MRC_VISIBILITY_IMPRESSION", new Object[0]);
                    x0.b(str);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
        }
        z = false;
        IAlog.a("BannerVisibilityTracker | visible = %s, minVis = %f", Boolean.valueOf(z), Float.valueOf(f));
        if (z) {
        }
        if (this.g) {
        }
    }
}
