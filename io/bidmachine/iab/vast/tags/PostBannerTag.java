package io.bidmachine.iab.vast.tags;

import android.text.TextUtils;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.vast.VastLog;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class PostBannerTag extends VastXmlTag {
    private String g;
    private final IabElementStyle c = new IabElementStyle();
    private final IabElementStyle d = new IabElementStyle();
    private final IabElementStyle e = new IabElementStyle();
    private final IabElementStyle f = new IabElementStyle();
    private float h = 0.0f;
    private float i = 0.0f;
    private boolean j = true;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    protected void a(XmlPullParser xmlPullParser) {
        xmlPullParser.require(2, null, VastTagName.POSTBANNER);
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                try {
                    String name = xmlPullParser.getName();
                    if (VastXmlTag.a(name, VastTagName.CLOSE_TIME)) {
                        String c = VastXmlTag.c(xmlPullParser);
                        if (!TextUtils.isEmpty(c)) {
                            this.h = Float.parseFloat(c);
                        }
                    } else if (VastXmlTag.a(name, "Duration")) {
                        String c2 = VastXmlTag.c(xmlPullParser);
                        if (!TextUtils.isEmpty(c2)) {
                            this.i = Float.parseFloat(c2);
                        }
                    } else if (VastXmlTag.a(name, VastTagName.CLOSEABLE_VIEW)) {
                        VastXmlTag.a(xmlPullParser, this.c);
                    } else if (VastXmlTag.a(name, VastTagName.COUNTDOWN)) {
                        VastXmlTag.a(xmlPullParser, this.d);
                    } else if (VastXmlTag.a(name, VastTagName.LOADING_VIEW)) {
                        VastXmlTag.a(xmlPullParser, this.e);
                    } else if (VastXmlTag.a(name, VastTagName.PROGRESS)) {
                        VastXmlTag.a(xmlPullParser, this.f);
                    } else if (VastXmlTag.a(name, VastTagName.USE_NATIVE_CLOSE)) {
                        this.l = VastXmlTag.b(xmlPullParser);
                    } else if (VastXmlTag.a(name, VastTagName.IGNORE_SAFE_AREA)) {
                        this.k = VastXmlTag.b(xmlPullParser);
                    } else if (VastXmlTag.a(name, VastTagName.PRODUCT_LINK)) {
                        this.g = VastXmlTag.c(xmlPullParser);
                    } else if (VastXmlTag.a(name, VastTagName.R1)) {
                        this.m = VastXmlTag.b(xmlPullParser);
                    } else if (VastXmlTag.a(name, VastTagName.R2)) {
                        this.n = VastXmlTag.b(xmlPullParser);
                    } else {
                        VastXmlTag.d(xmlPullParser);
                    }
                } catch (Throwable th) {
                    VastLog.e("VastXmlTag", th);
                }
            }
        }
        xmlPullParser.require(3, null, VastTagName.POSTBANNER);
    }

    public IabElementStyle getCloseStyle() {
        return this.c;
    }

    public float getCloseTimeSec() {
        return this.h;
    }

    public IabElementStyle getCountDownStyle() {
        return this.d;
    }

    public float getDurationSec() {
        return this.i;
    }

    public IabElementStyle getLoadingStyle() {
        return this.e;
    }

    public String getProductLink() {
        return this.g;
    }

    public IabElementStyle getProgressStyle() {
        return this.f;
    }

    public boolean isForceUseNativeClose() {
        return this.l;
    }

    public boolean isIgnoreSafeArea() {
        return this.k;
    }

    public boolean isR1() {
        return this.m;
    }

    public boolean isR2() {
        return this.n;
    }

    public boolean isVisible() {
        return this.j;
    }

    public void setCloseTimeSec(int closeTimeSec) {
        this.h = closeTimeSec;
    }

    public void setVisible(boolean visible) {
        this.j = visible;
    }
}
