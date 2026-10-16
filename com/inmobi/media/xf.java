package com.inmobi.media;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class xf {
    public static boolean a(WebView view, RenderProcessGoneDetail renderProcessGoneDetail, String source) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(source, "source");
        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("source", source), TuplesKt.to("isCrashed", Boolean.valueOf(renderProcessGoneDetail != null ? renderProcessGoneDetail.didCrash() : false)));
        Pd pd = Pd.f2401a;
        Pd.b("WebViewRenderProcessGoneEvent", mutableMapOf, Td.f2443a);
        view.destroy();
        return true;
    }
}
