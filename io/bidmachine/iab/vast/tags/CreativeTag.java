package io.bidmachine.iab.vast.tags;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class CreativeTag extends VastXmlTag {
    private static final String[] d = {"id", VastAttributes.AD_ID};
    private CreativeContentTag c;

    CreativeTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
        xmlPullParser.require(2, null, "Creative");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, "Linear")) {
                    this.c = new LinearCreativeTag(xmlPullParser);
                } else if (VastXmlTag.a(name, "CompanionAds")) {
                    this.c = new CompanionAdsCreativeTag(xmlPullParser);
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "Creative");
    }

    public CreativeContentTag getCreativeContentTag() {
        return this.c;
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return d;
    }
}
