package io.bidmachine.iab.vast.tags;

import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class AdVerificationsExtensionTag extends ExtensionTag {
    private final List<VerificationTag> d;

    AdVerificationsExtensionTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
        this.d = new ArrayList();
        xmlPullParser.require(2, null, "AdVerifications");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (VastXmlTag.a(xmlPullParser.getName(), VastTagName.VERIFICATION)) {
                    this.d.add(new VerificationTag(xmlPullParser));
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "AdVerifications");
    }

    public List<VerificationTag> getVerificationTagList() {
        return this.d;
    }
}
