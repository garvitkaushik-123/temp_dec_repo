package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import com.iab.omid.library.inmobi.adsession.ImpressionType;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.ja, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2716ja {
    public static C2667ga a(String creativeType, GestureDetectorOnGestureListenerC2634ec webView, boolean z, String str, byte b, String str2) {
        AdSessionContext adSessionContext;
        Intrinsics.checkNotNullParameter(creativeType, "creativeType");
        if (webView != null) {
            C2796oa c2796oa = AbstractC2780na.f2651a;
            c2796oa.getClass();
            Intrinsics.checkNotNullParameter(webView, "webView");
            adSessionContext = AdSessionContext.createHtmlAdSessionContext(c2796oa.b, webView, str, str2);
            Intrinsics.checkNotNullExpressionValue(adSessionContext, "createHtmlAdSessionContext(...)");
        } else {
            adSessionContext = null;
        }
        ImpressionType impressionType = b == 1 ? ImpressionType.DEFINED_BY_JAVASCRIPT : b == 2 ? ImpressionType.UNSPECIFIED : b == 3 ? ImpressionType.LOADED : b == 4 ? ImpressionType.BEGIN_TO_RENDER : b == 5 ? ImpressionType.ONE_PIXEL : b == 6 ? ImpressionType.VIEWABLE : b == 7 ? ImpressionType.AUDIBLE : b == 0 ? ImpressionType.OTHER : ImpressionType.OTHER;
        int hashCode = creativeType.hashCode();
        if (hashCode != -284840886) {
            if (hashCode != 93166550) {
                if (hashCode != 112202875) {
                    if (hashCode == 1425678798 && creativeType.equals("nonvideo")) {
                        return new C2667ga("html_display_ad", impressionType, adSessionContext, false);
                    }
                } else if (creativeType.equals("video")) {
                    return new C2667ga("html_video_ad", impressionType, adSessionContext, z);
                }
            } else if (creativeType.equals("audio")) {
                return new C2667ga("html_audio_ad", impressionType, adSessionContext, z);
            }
        } else if (creativeType.equals("unknown")) {
            Intrinsics.checkNotNullExpressionValue("ka", "access$getTAG$cp(...)");
            return null;
        }
        Intrinsics.checkNotNullExpressionValue("ka", "access$getTAG$cp(...)");
        return null;
    }
}
