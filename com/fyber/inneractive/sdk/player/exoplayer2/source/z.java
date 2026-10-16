package com.fyber.inneractive.sdk.player.exoplayer2.source;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class z {
    public static final /* synthetic */ int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f1544a;
    public final y[] b;
    public int c;

    static {
        new z(new y[0]);
    }

    public z(y... yVarArr) {
        this.b = yVarArr;
        this.f1544a = yVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && z.class == obj.getClass()) {
            z zVar = (z) obj;
            if (this.f1544a == zVar.f1544a && Arrays.equals(this.b, zVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b);
        }
        return this.c;
    }
}
