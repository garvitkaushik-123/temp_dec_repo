package com.fyber.inneractive.sdk.player.exoplayer2;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes4.dex */
public final class s {
    public static final s d = new s(1.0f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final float f1525a;
    public final float b;
    public final int c;

    public s(float f, float f2) {
        this.f1525a = f;
        this.b = f2;
        this.c = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && s.class == obj.getClass()) {
            s sVar = (s) obj;
            if (this.f1525a == sVar.f1525a && this.b == sVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.b) + ((Float.floatToRawIntBits(this.f1525a) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31);
    }
}
