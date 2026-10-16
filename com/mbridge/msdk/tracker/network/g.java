package com.mbridge.msdk.tracker.network;

import android.text.TextUtils;
import com.ironsource.C3040d4;

/* compiled from: Header.java */
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final String f4943a;
    private final String b;

    public g(String str, String str2) {
        this.f4943a = str;
        this.b = str2;
    }

    public final String a() {
        return this.f4943a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            g gVar = (g) obj;
            if (TextUtils.equals(this.f4943a, gVar.f4943a) && TextUtils.equals(this.b, gVar.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f4943a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f4943a + ",value=" + this.b + C3040d4.i.e;
    }
}
