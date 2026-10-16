package io.bidmachine.rendering.measurer;

import android.webkit.WebView;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class CompositeHtmlMeasurer extends BaseCompositeMeasurer<HtmlMeasurer, WebView> implements HtmlMeasurer {
    public CompositeHtmlMeasurer(List<HtmlMeasurer> measurerList) {
        super(measurerList);
    }

    @Override // io.bidmachine.rendering.measurer.HtmlMeasurer
    public String prepareCreativeForMeasure(String html) {
        Iterator it = this.measurerList.iterator();
        while (it.hasNext()) {
            html = ((HtmlMeasurer) it.next()).prepareCreativeForMeasure(html);
        }
        return html;
    }
}
