package io.bidmachine.iab.vast.tags;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class AdContentTag extends VastXmlTag {
    private AdSystemTag c;
    private List<CreativeTag> d;
    private List<ExtensionTag> e;
    private List<String> f;
    private List<String> g;

    AdContentTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
    }

    private ExtensionTag f(XmlPullParser xmlPullParser) {
        ExtensionTag extensionTag;
        xmlPullParser.require(2, null, VastTagName.EXTENSION);
        String a2 = new ExtensionTag(xmlPullParser).a("type");
        if (VastXmlTag.a(a2, "appodeal")) {
            extensionTag = new AppodealExtensionTag(xmlPullParser);
        } else if (VastXmlTag.a(a2, "AdVerifications")) {
            ExtensionTag extensionTag2 = null;
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (VastXmlTag.a(xmlPullParser.getName(), "AdVerifications")) {
                        extensionTag2 = new AdVerificationsExtensionTag(xmlPullParser);
                    } else {
                        VastXmlTag.d(xmlPullParser);
                    }
                }
            }
            extensionTag = extensionTag2;
        } else {
            VastXmlTag.d(xmlPullParser);
            extensionTag = null;
        }
        xmlPullParser.require(3, null, VastTagName.EXTENSION);
        return extensionTag;
    }

    void a(AdSystemTag adSystemTag) {
        this.c = adSystemTag;
    }

    void b(List<ExtensionTag> extensionTagList) {
        this.e = extensionTagList;
    }

    List<CreativeTag> e(XmlPullParser xmlPullParser) {
        xmlPullParser.require(2, null, "Creatives");
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (VastXmlTag.a(xmlPullParser.getName(), "Creative")) {
                    arrayList.add(new CreativeTag(xmlPullParser));
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "Creatives");
        return arrayList;
    }

    List<ExtensionTag> g(XmlPullParser xmlPullParser) {
        xmlPullParser.require(2, null, VastTagName.EXTENSIONS);
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (VastXmlTag.a(xmlPullParser.getName(), VastTagName.EXTENSION)) {
                    ExtensionTag f = f(xmlPullParser);
                    if (f != null) {
                        arrayList.add(f);
                    }
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, VastTagName.EXTENSIONS);
        return arrayList;
    }

    public List<CreativeTag> getCreativeTagList() {
        return this.d;
    }

    public List<String> getErrorUrlList() {
        return this.g;
    }

    public List<ExtensionTag> getExtensionTagList() {
        return this.e;
    }

    public List<String> getImpressionUrlList() {
        return this.f;
    }

    void l(String errorUrl) {
        if (TextUtils.isEmpty(errorUrl)) {
            return;
        }
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(errorUrl);
    }

    void m(String impressionUrl) {
        if (TextUtils.isEmpty(impressionUrl)) {
            return;
        }
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(impressionUrl);
    }

    void a(List<CreativeTag> creativeTagList) {
        this.d = creativeTagList;
    }
}
