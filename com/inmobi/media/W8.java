package com.inmobi.media;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class W8 extends C2672h {

    /* renamed from: a, reason: collision with root package name */
    public final String f2470a;
    public final String b;
    public final String c;
    public final ArrayList d;
    public final ArrayList e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W8(C2672h ad, JSONArray jSONArray, String videoUrl, String videoDuration, String str, ArrayList trackers, ArrayList companionAds) {
        super(ad, jSONArray);
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        Intrinsics.checkNotNullParameter(videoDuration, "videoDuration");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(companionAds, "companionAds");
        this.f2470a = videoUrl;
        this.b = videoDuration;
        this.c = str;
        this.d = trackers;
        this.e = companionAds;
    }
}
