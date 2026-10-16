package com.fyber.inneractive.sdk.player.exoplayer2.video;

import android.view.WindowManager;
import com.fyber.inneractive.sdk.config.IAConfigManager;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final g f1607a;
    public final boolean b;
    public final long c;
    public final long d;
    public long e;
    public long f;
    public long g;
    public boolean h;
    public long i;
    public long j;
    public long k;

    public h() {
        double refreshRate = ((WindowManager) IAConfigManager.O.v.a().getSystemService("window")).getDefaultDisplay().getRefreshRate();
        this.b = true;
        this.f1607a = g.e;
        long j = (long) (1.0E9d / refreshRate);
        this.c = j;
        this.d = (j * 80) / 100;
    }
}
