package com.inmobi.media;

import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.controllers.PublisherCallbacks;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.t5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2872t5 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InMobiBanner f2710a;
    public final /* synthetic */ PublisherCallbacks b;
    public final /* synthetic */ boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2872t5(InMobiBanner inMobiBanner, PublisherCallbacks publisherCallbacks, boolean z) {
        super(0);
        this.f2710a = inMobiBanner;
        this.b = publisherCallbacks;
        this.c = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        R1 mAdManager;
        String frameSizeString;
        this.f2710a.a();
        if (InMobiBanner.access$checkForRefreshRate(this.f2710a) && (mAdManager = this.f2710a.getMAdManager()) != null) {
            PublisherCallbacks publisherCallbacks = this.b;
            frameSizeString = this.f2710a.getFrameSizeString();
            mAdManager.a(publisherCallbacks, frameSizeString, this.c);
        }
        return Unit.INSTANCE;
    }
}
