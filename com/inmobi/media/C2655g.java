package com.inmobi.media;

import com.inmobi.ads.AdMetaInfo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2655g extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2672h f2573a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2655g(C2672h c2672h) {
        super(0);
        this.f2573a = c2672h;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new AdMetaInfo(this.f2573a.o(), this.f2573a.E());
    }
}
