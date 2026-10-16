package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class K extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final InMobiAdRequestStatus f2330a;
    public final short b;

    public K(InMobiAdRequestStatus status, short s) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.f2330a = status;
        this.b = s;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f2330a.getMessage();
    }
}
