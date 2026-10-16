package io.bidmachine.iab.vast.processor;

import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.iab.vast.tags.VastXmlTag;

/* loaded from: classes7.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6924a;
    private final boolean b;
    private final boolean c;

    a() {
        this(true, true, true);
    }

    boolean a() {
        return this.b;
    }

    boolean b() {
        return this.c;
    }

    boolean c() {
        return this.f6924a;
    }

    a(VastXmlTag vastXmlTag) {
        this(vastXmlTag.getBooleanAttributeValueByName(VastAttributes.FOLLOW_ADDITIONAL_WRAPPERS, true), vastXmlTag.getBooleanAttributeValueByName(VastAttributes.ALLOW_MULTIPLE_ADS, true), vastXmlTag.getBooleanAttributeValueByName(VastAttributes.FALLBACK_ON_NO_AD, true));
    }

    private a(boolean followAdditionalWrappers, boolean allowMultipleAds, boolean fallbackOnNoAd) {
        this.f6924a = followAdditionalWrappers;
        this.b = allowMultipleAds;
        this.c = fallbackOnNoAd;
    }
}
