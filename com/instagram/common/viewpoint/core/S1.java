package com.instagram.common.viewpoint.core;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import com.facebook.ads.AudienceNetworkActivity;

/* loaded from: assets/audience_network/classes2.dex */
public final class S1 {
    public final AudienceNetworkActivity A00;
    public final C1929gi A01;

    public S1(C1929gi c1929gi, AudienceNetworkActivity audienceNetworkActivity) {
        this.A01 = c1929gi;
        this.A00 = audienceNetworkActivity;
    }

    private int A00() {
        Rect rect = new Rect();
        Window window = this.A00.getWindow();
        if (window == null) {
            return 2;
        }
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        if (rect.top < 200 && rect.left < 200) {
            return 1;
        }
        return 0;
    }

    public final void A01() {
        if ((this.A01.A0H().A01() || C1379Up.A25(this.A01)) && Build.VERSION.SDK_INT >= 24) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.S0
                @Override // java.lang.Runnable
                public final void run() {
                    S1.this.A02();
                }
            }, 1000L);
        }
    }

    public final /* synthetic */ void A02() {
        if (this.A00.isInMultiWindowMode()) {
            this.A01.A0F().AC4(A00());
        }
    }
}
