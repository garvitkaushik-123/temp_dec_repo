package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.google.firebase.sessions.settings.RemoteSettings;

/* loaded from: classes4.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f1484a;
    public final int b;
    public final int c;
    public int d;
    public String e;

    public e0(int i, int i2, int i3) {
        this.f1484a = i != Integer.MIN_VALUE ? i + RemoteSettings.FORWARD_SLASH_STRING : "";
        this.b = i2;
        this.c = i3;
        this.d = Integer.MIN_VALUE;
    }

    public final void a() {
        int i = this.d;
        this.d = i == Integer.MIN_VALUE ? this.b : i + this.c;
        this.e = this.f1484a + this.d;
    }

    public final void b() {
        if (this.d == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }
}
