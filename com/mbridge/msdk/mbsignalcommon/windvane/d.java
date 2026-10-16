package com.mbridge.msdk.mbsignalcommon.windvane;

import io.adn.sdk.internal.domain.constants.AnalyticsConstants;

/* compiled from: MimeTypeEnum.java */
/* loaded from: classes6.dex */
public enum d {
    JS("js", "application/x-javascript"),
    CSS("css", "text/css"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG("png", "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", "text/html"),
    HTML(AnalyticsConstants.CREATIVE_TYPE_HTML, "text/html");


    /* renamed from: a, reason: collision with root package name */
    private String f4568a;
    private String b;

    d(String str, String str2) {
        this.f4568a = str;
        this.b = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f4568a;
    }
}
