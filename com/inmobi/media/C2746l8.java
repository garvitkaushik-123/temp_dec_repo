package com.inmobi.media;

import io.bidmachine.iab.vast.tags.VastTagName;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.l8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2746l8 extends N8 {
    public /* synthetic */ C2746l8(String str, String str2, C2730k8 c2730k8, String str3, String str4) {
        this(str, str2, c2730k8, str3, new ArrayList(), str4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2746l8(String assetId, String assetName, C2730k8 assetStyle, String str, List trackers, String interactionMode) {
        super(assetId, assetName, VastTagName.CTA, assetStyle, str);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(interactionMode, "interactionMode");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        this.s.addAll(trackers);
        Intrinsics.checkNotNullParameter(interactionMode, "<set-?>");
        this.g = interactionMode;
    }
}
