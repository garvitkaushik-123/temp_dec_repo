package io.bidmachine.iab.vast.tags;

import io.bidmachine.iab.vast.VastLog;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class CompanionAdsCreativeTag extends CreativeContentTag {
    private final List<CompanionTag> c;

    CompanionAdsCreativeTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
        this.c = new ArrayList();
        xmlPullParser.require(2, null, "CompanionAds");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (VastXmlTag.a(xmlPullParser.getName(), "Companion")) {
                    CompanionTag companionTag = new CompanionTag(xmlPullParser);
                    if (companionTag.isValidTag()) {
                        this.c.add(companionTag);
                    } else {
                        VastLog.d("VastXmlTag", "Creative Companion: is not valid. Skipping it.", new Object[0]);
                    }
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "CompanionAds");
    }

    public List<CompanionTag> getCompanionTagList() {
        return this.c;
    }
}
