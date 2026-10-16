package io.bidmachine.iab.vast.tags;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class VerificationTag extends VastXmlTag {
    private static final String[] e = {VastAttributes.VENDOR};
    private JavaScriptResourceTag c;
    private String d;

    VerificationTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
        xmlPullParser.require(2, null, VastTagName.VERIFICATION);
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, VastTagName.JAVA_SCRIPT_RESOURCE)) {
                    this.c = new JavaScriptResourceTag(xmlPullParser);
                } else if (VastXmlTag.a(name, VastTagName.VERIFICATION_PARAMETERS)) {
                    this.d = VastXmlTag.c(xmlPullParser);
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, VastTagName.VERIFICATION);
    }

    public JavaScriptResourceTag getJavaScriptResourceTag() {
        return this.c;
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return e;
    }

    public String getVendor() {
        return a(VastAttributes.VENDOR);
    }

    public String getVerificationParameters() {
        return this.d;
    }
}
