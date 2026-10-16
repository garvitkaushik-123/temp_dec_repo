package com.inmobi.ads;

import com.inmobi.ads.InMobiBanner;
import com.inmobi.media.A5;
import com.inmobi.media.InterfaceC2971z5;
import com.inmobi.media.R1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class d extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InMobiBanner f2220a;
    public final /* synthetic */ byte[] b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(InMobiBanner inMobiBanner, byte[] bArr) {
        super(0);
        this.f2220a = inMobiBanner;
        this.b = bArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        InMobiBanner.a aVar;
        InterfaceC2971z5 p;
        R1 mAdManager = this.f2220a.getMAdManager();
        if (mAdManager != null && (p = mAdManager.p()) != null) {
            String access$getTAG$cp = InMobiBanner.access$getTAG$cp();
            Intrinsics.checkNotNullExpressionValue(access$getTAG$cp, "access$getTAG$cp(...)");
            ((A5) p).c(access$getTAG$cp, "load with response");
        }
        R1 mAdManager2 = this.f2220a.getMAdManager();
        if (mAdManager2 != null) {
            byte[] bArr = this.b;
            aVar = this.f2220a.e;
            mAdManager2.a(bArr, aVar);
        }
        return Unit.INSTANCE;
    }
}
