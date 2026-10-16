package com.fyber.inneractive.sdk.player.exoplayer2.mediacodec;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f1516a;
    public final boolean b;

    public e(boolean z, String str) {
        this.f1516a = str;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == e.class) {
            e eVar = (e) obj;
            if (TextUtils.equals(this.f1516a, eVar.f1516a) && this.b == eVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f1516a;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.b ? 1231 : 1237);
    }
}
