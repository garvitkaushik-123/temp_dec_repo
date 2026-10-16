package io.bidmachine.iab.vast.tags;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class VideoClicksTag extends VastXmlTag {
    private String c;
    private List<String> d;
    private List<String> e;

    VideoClicksTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
        xmlPullParser.require(2, null, "VideoClicks");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, "ClickThrough")) {
                    n(VastXmlTag.c(xmlPullParser));
                } else if (VastXmlTag.a(name, "ClickTracking")) {
                    l(VastXmlTag.c(xmlPullParser));
                } else if (VastXmlTag.a(name, "CustomClick")) {
                    m(VastXmlTag.c(xmlPullParser));
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "VideoClicks");
    }

    private void l(String clickTrackingUrl) {
        if (TextUtils.isEmpty(clickTrackingUrl)) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(clickTrackingUrl);
    }

    private void m(String customClickUrl) {
        if (TextUtils.isEmpty(customClickUrl)) {
            return;
        }
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(customClickUrl);
    }

    private void n(String clickThroughUrl) {
        this.c = clickThroughUrl;
    }

    public String getClickThroughUrl() {
        return this.c;
    }

    public List<String> getClickTrackingUrlList() {
        return this.d;
    }
}
