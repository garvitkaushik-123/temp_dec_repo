package io.bidmachine.iab.vast.tags;

import android.text.TextUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class MediaFileTag extends VastXmlTag {
    private static final String[] c = {"delivery", "type", "width", "height", VastAttributes.CODEC, "id", VastAttributes.BITRATE, VastAttributes.MIN_BITRATE, VastAttributes.MAX_BITRATE, VastAttributes.SCALABLE, VastAttributes.MAINTAIN_ASPECT_RATION, VastAttributes.API_FRAMEWORK};

    MediaFileTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
    }

    public String getApiFramework() {
        return a(VastAttributes.API_FRAMEWORK);
    }

    public int getHeight() {
        return b("height");
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return c;
    }

    public String getType() {
        return a("type");
    }

    public int getWidth() {
        return b("width");
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public boolean isTextSupported() {
        return true;
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public boolean isValidTag() {
        return (TextUtils.isEmpty(a("type")) || TextUtils.isEmpty(a("width")) || TextUtils.isEmpty(a("height")) || TextUtils.isEmpty(getText())) ? false : true;
    }
}
