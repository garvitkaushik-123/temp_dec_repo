package io.bidmachine.iab.vast.tags;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class TrackingTag extends VastXmlTag {
    private static final String[] c = {"event"};

    TrackingTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return c;
    }
}
