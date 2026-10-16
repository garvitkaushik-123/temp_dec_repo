package io.bidmachine.iab.vast.tags;

import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class VastTag extends VastXmlTag {
    private static final String[] d = {"version"};
    private final List<AdTag> c;

    VastTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
        this.c = new ArrayList();
        xmlPullParser.require(2, null, VastTagName.VAST);
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (VastXmlTag.a(xmlPullParser.getName(), "Ad")) {
                    this.c.add(new AdTag(xmlPullParser));
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, VastTagName.VAST);
    }

    public List<AdTag> getAdTagList() {
        return this.c;
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return d;
    }

    public boolean hasAd() {
        return !this.c.isEmpty();
    }
}
