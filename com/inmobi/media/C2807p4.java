package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* renamed from: com.inmobi.media.p4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2807p4 implements O9 {

    /* renamed from: a, reason: collision with root package name */
    public final EnumC2758m4 f2668a;

    public C2807p4(String url, EnumC2758m4 errorCode) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.f2668a = errorCode;
        ByteString byteString = ByteString.EMPTY;
    }

    @Override // com.inmobi.media.O9
    public final int a() {
        return this.f2668a.f2638a;
    }

    @Override // com.inmobi.media.O9
    public final String b() {
        return this.f2668a.name();
    }
}
