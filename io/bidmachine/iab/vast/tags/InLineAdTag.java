package io.bidmachine.iab.vast.tags;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class InLineAdTag extends AdContentTag {
    InLineAdTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
        xmlPullParser.require(2, null, "InLine");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, "Creatives")) {
                    a(e(xmlPullParser));
                } else if (VastXmlTag.a(name, VastTagName.EXTENSIONS)) {
                    b(g(xmlPullParser));
                } else if (VastXmlTag.a(name, "Impression")) {
                    m(VastXmlTag.c(xmlPullParser));
                } else if (VastXmlTag.a(name, "Error")) {
                    l(VastXmlTag.c(xmlPullParser));
                } else if (VastXmlTag.a(name, "AdSystem")) {
                    a(new AdSystemTag(xmlPullParser));
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "InLine");
    }
}
