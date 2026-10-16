package com.inmobi.media;

import android.media.MediaPlayer;
import kotlin.Unit;

/* loaded from: classes4.dex */
public final class G8 extends MediaPlayer {
    public static final Object d = new Object();
    public static G8 e;
    public static int f;

    /* renamed from: a, reason: collision with root package name */
    public int f2294a;
    public int b;
    public G8 c;

    public final void a() {
        if (3 == this.f2294a) {
            return;
        }
        synchronized (d) {
            int i = f;
            if (i < 5) {
                this.c = e;
                e = this;
                f = i + 1;
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
