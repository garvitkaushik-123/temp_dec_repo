package io.bidmachine.iab.vast.tags;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class JavaScriptResourceTag extends VastXmlTag {
    private static final String[] c = {VastAttributes.API_FRAMEWORK};

    JavaScriptResourceTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return c;
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public boolean isTextSupported() {
        return true;
    }
}
