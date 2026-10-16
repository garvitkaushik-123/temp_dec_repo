package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.xb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2942xb {

    /* renamed from: a, reason: collision with root package name */
    public final byte f2753a;
    public final String b;

    public C2942xb(byte b, String assetUrl) {
        Intrinsics.checkNotNullParameter(assetUrl, "assetUrl");
        this.f2753a = b;
        this.b = assetUrl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2942xb)) {
            return false;
        }
        C2942xb c2942xb = (C2942xb) obj;
        return this.f2753a == c2942xb.f2753a && Intrinsics.areEqual(this.b, c2942xb.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Byte.hashCode(this.f2753a) * 31);
    }

    public final String toString() {
        return "RawAsset(mRawAssetType=" + ((int) this.f2753a) + ", assetUrl=" + this.b + ')';
    }
}
