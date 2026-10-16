package io.bidmachine.iab.vast.tags;

import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.vast.VastExtension;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class AppodealExtensionTag extends ExtensionTag implements VastExtension {
    private final IabElementStyle d;
    private final IabElementStyle e;
    private final IabElementStyle f;
    private final IabElementStyle g;
    private final IabElementStyle h;
    private final IabElementStyle i;
    private final IabElementStyle j;
    private final IabElementStyle k;
    private final PostBannerTag l;
    private Integer m;
    private Integer n;
    private CompanionTag o;
    private Boolean p;
    private Float q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private Integer v;

    AppodealExtensionTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
        this.d = new IabElementStyle();
        this.e = new IabElementStyle();
        this.f = new IabElementStyle();
        this.g = new IabElementStyle();
        this.h = new IabElementStyle();
        this.i = new IabElementStyle();
        this.j = new IabElementStyle();
        this.k = new IabElementStyle();
        this.l = new PostBannerTag();
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        xmlPullParser.require(2, null, VastTagName.EXTENSION);
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, VastTagName.VIDEO)) {
                    VastXmlTag.a(xmlPullParser, this.d);
                } else if (VastXmlTag.a(name, VastTagName.LOADING_VIEW)) {
                    VastXmlTag.a(xmlPullParser, this.j);
                } else if (VastXmlTag.a(name, VastTagName.COUNTDOWN)) {
                    VastXmlTag.a(xmlPullParser, this.k);
                } else if (VastXmlTag.a(name, VastTagName.PROGRESS)) {
                    VastXmlTag.a(xmlPullParser, this.h);
                } else if (VastXmlTag.a(name, VastTagName.CLOSEABLE_VIEW)) {
                    VastXmlTag.a(xmlPullParser, this.g);
                } else if (VastXmlTag.a(name, VastTagName.MUTE)) {
                    VastXmlTag.a(xmlPullParser, this.f);
                } else if (VastXmlTag.a(name, VastTagName.CTA)) {
                    VastXmlTag.a(xmlPullParser, this.e);
                } else if (VastXmlTag.a(name, VastTagName.REPEAT_VIEW)) {
                    VastXmlTag.a(xmlPullParser, this.i);
                } else if (VastXmlTag.a(name, VastTagName.POSTBANNER)) {
                    this.l.parse(xmlPullParser);
                } else if (VastXmlTag.a(name, VastTagName.AUTO_ROTATE)) {
                    this.p = Boolean.valueOf(VastXmlTag.b(xmlPullParser));
                } else if (VastXmlTag.a(name, VastTagName.R1)) {
                    this.t = VastXmlTag.b(xmlPullParser);
                } else if (VastXmlTag.a(name, VastTagName.R2)) {
                    this.u = VastXmlTag.b(xmlPullParser);
                } else if (VastXmlTag.a(name, VastTagName.FORCE_ORIENTATION)) {
                    this.v = VastXmlTag.g(VastXmlTag.c(xmlPullParser));
                } else if (VastXmlTag.a(name, VastTagName.CTA_TEXT)) {
                    this.e.setContent(VastXmlTag.c(xmlPullParser));
                } else if (VastXmlTag.a(name, VastTagName.SHOW_CTA)) {
                    this.e.setVisible(Boolean.valueOf(VastXmlTag.b(xmlPullParser)));
                } else if (VastXmlTag.a(name, VastTagName.SHOW_MUTE)) {
                    this.f.setVisible(Boolean.valueOf(VastXmlTag.b(xmlPullParser)));
                } else if (VastXmlTag.a(name, VastTagName.SHOW_COMPANION)) {
                    this.l.setVisible(VastXmlTag.b(xmlPullParser));
                } else if (VastXmlTag.a(name, VastTagName.COMPANION_CLOSE_TIME)) {
                    int f = VastXmlTag.f(VastXmlTag.c(xmlPullParser));
                    if (f > -1) {
                        this.l.setCloseTimeSec(f);
                    }
                } else if (VastXmlTag.a(name, VastTagName.MUTED)) {
                    this.r = VastXmlTag.b(xmlPullParser);
                } else if (VastXmlTag.a(name, VastTagName.VIDEO_CLICKABLE)) {
                    this.s = VastXmlTag.b(xmlPullParser);
                } else if (VastXmlTag.a(name, VastTagName.CTA_X_POSITION)) {
                    this.e.setHorizontalPosition(VastXmlTag.h(VastXmlTag.c(xmlPullParser)));
                } else if (VastXmlTag.a(name, VastTagName.CTA_Y_POSITION)) {
                    this.e.setVerticalPosition(VastXmlTag.i(VastXmlTag.c(xmlPullParser)));
                } else if (VastXmlTag.a(name, VastTagName.CLOSE_X_POSITION)) {
                    this.g.setHorizontalPosition(VastXmlTag.h(VastXmlTag.c(xmlPullParser)));
                } else if (VastXmlTag.a(name, VastTagName.CLOSE_Y_POSITION)) {
                    this.g.setVerticalPosition(VastXmlTag.i(VastXmlTag.c(xmlPullParser)));
                } else if (VastXmlTag.a(name, VastTagName.MUTE_X_POSITION)) {
                    this.f.setHorizontalPosition(VastXmlTag.h(VastXmlTag.c(xmlPullParser)));
                } else if (VastXmlTag.a(name, VastTagName.MUTE_Y_POSITION)) {
                    this.f.setVerticalPosition(VastXmlTag.i(VastXmlTag.c(xmlPullParser)));
                } else if (VastXmlTag.a(name, VastTagName.ASSETS_COLOR)) {
                    Integer c = VastXmlTag.c(VastXmlTag.c(xmlPullParser));
                    if (c != null) {
                        this.m = c;
                    }
                } else if (VastXmlTag.a(name, VastTagName.ASSETS_BACKGROUND_COLOR)) {
                    Integer c2 = VastXmlTag.c(VastXmlTag.c(xmlPullParser));
                    if (c2 != null) {
                        this.n = c2;
                    }
                } else if (VastXmlTag.a(name, "Companion")) {
                    CompanionTag companionTag = new CompanionTag(xmlPullParser);
                    if (companionTag.isValidTag() && companionTag.hasCreative()) {
                        this.o = companionTag;
                    }
                } else if (VastXmlTag.a(name, VastTagName.CLOSE_TIME)) {
                    String c3 = VastXmlTag.c(xmlPullParser);
                    if (c3 != null) {
                        this.q = Float.valueOf(Float.parseFloat(c3));
                    }
                } else if (VastXmlTag.a(name, VastTagName.SHOW_PROGRESS)) {
                    this.h.setVisible(Boolean.valueOf(VastXmlTag.b(xmlPullParser)));
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, VastTagName.EXTENSION);
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public Integer getAssetsBackgroundColor() {
        return this.n;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public Integer getAssetsColor() {
        return this.m;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getCloseStyle() {
        return this.g;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public Float getCloseTimeSec() {
        return this.q;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public CompanionTag getCompanionTag() {
        return this.o;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getCountDownStyle() {
        return this.k;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getCtaStyle() {
        return this.e;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public Integer getForceOrientation() {
        return this.v;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getLoadingStyle() {
        return this.j;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getMuteStyle() {
        return this.f;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public PostBannerTag getPostBannerTag() {
        return this.l;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getProgressStyle() {
        return this.h;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getRepeatStyle() {
        return this.i;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public IabElementStyle getVideoStyle() {
        return this.d;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public Boolean isAutoRotate() {
        return this.p;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public boolean isMuted() {
        return this.r;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public boolean isR1() {
        return this.t;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public boolean isR2() {
        return this.u;
    }

    @Override // io.bidmachine.iab.vast.VastExtension
    public boolean isVideoClickable() {
        return this.s;
    }
}
