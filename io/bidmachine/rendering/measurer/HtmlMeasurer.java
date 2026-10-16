package io.bidmachine.rendering.measurer;

import android.webkit.WebView;

/* loaded from: classes8.dex */
public interface HtmlMeasurer extends Measurer<WebView> {
    String prepareCreativeForMeasure(String html);
}
