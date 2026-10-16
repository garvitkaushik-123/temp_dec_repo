package com.iab.omid.library.appodeal.adsession;

import io.adn.sdk.internal.domain.constants.AnalyticsConstants;

/* loaded from: classes4.dex */
public enum AdSessionContextType {
    HTML(AnalyticsConstants.CREATIVE_TYPE_HTML),
    NATIVE("native"),
    JAVASCRIPT("javascript");

    private final String typeString;

    AdSessionContextType(String str) {
        this.typeString = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.typeString;
    }
}
