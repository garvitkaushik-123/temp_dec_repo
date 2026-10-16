package io.bidmachine.iab.vast.tags;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class AdTag extends VastXmlTag {
    private static final String[] d = {"id"};
    private AdContentTag c;

    AdTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
        xmlPullParser.require(2, null, "Ad");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, "InLine")) {
                    this.c = new InLineAdTag(xmlPullParser);
                } else if (VastXmlTag.a(name, "Wrapper")) {
                    this.c = new WrapperAdTag(xmlPullParser);
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "Ad");
    }

    public AdContentTag getAdContentTag() {
        return this.c;
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return d;
    }
}
