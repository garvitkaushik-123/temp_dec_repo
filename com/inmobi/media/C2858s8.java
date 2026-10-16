package com.inmobi.media;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.s8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2858s8 extends C2613d8 {
    public final String x;
    public final Lazy y;

    public /* synthetic */ C2858s8(String str, String str2, C2630e8 c2630e8, String str3, String str4, JSONObject jSONObject) {
        this(str, str2, c2630e8, str3, new ArrayList(), str4, jSONObject);
    }

    public static final I4 a(C2858s8 c2858s8, String str) {
        c2858s8.getClass();
        return new X0(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2858s8(String assetId, String assetName, C2630e8 assetStyle, final String url, List trackers, final String interactionMode, final JSONObject jSONObject) {
        super(assetId, assetName, "GIF", assetStyle, trackers);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(interactionMode, "interactionMode");
        this.x = "s8";
        this.y = LazyKt.lazy(new C2842r8(this, url));
        Uc.a(new Runnable() { // from class: com.inmobi.media.s8$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2858s8.a(url, this, jSONObject, interactionMode);
            }
        });
    }

    public static final void a(String url, C2858s8 this$0, JSONObject jSONObject, String interactionMode) {
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(interactionMode, "$interactionMode");
        C2705j b = Nc.a().b(url);
        this$0.e = b != null ? b.c : null;
        if (jSONObject != null) {
            Intrinsics.checkNotNullParameter(interactionMode, "<set-?>");
            this$0.g = interactionMode;
        }
    }
}
