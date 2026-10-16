package io.bidmachine.iab.vast.tags;

import android.text.TextUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class StaticResourceTag extends VastXmlTag {
    private static final String[] c = {"creativeType"};

    StaticResourceTag(XmlPullParser xmlPullParser) {
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

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public boolean isValidTag() {
        String a2 = a("creativeType");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return a2.matches("image/.*(?i)(gif|jpeg|jpg|bmp|png)");
    }
}
