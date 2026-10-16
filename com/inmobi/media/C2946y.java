package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.AdEvents;
import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.media.MediaEvents;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.y, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2946y {

    /* renamed from: a, reason: collision with root package name */
    public final AdEvents f2757a;
    public final MediaEvents b;

    public C2946y(AdSession adSession, String str) {
        Intrinsics.checkNotNullParameter(adSession, "adSession");
        if (!Intrinsics.areEqual(str, "native_video_ad")) {
            this.f2757a = AdEvents.createAdEvents(adSession);
        } else {
            this.b = MediaEvents.createMediaEvents(adSession);
            this.f2757a = AdEvents.createAdEvents(adSession);
        }
    }
}
