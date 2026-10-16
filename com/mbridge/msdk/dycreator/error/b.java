package com.mbridge.msdk.dycreator.error;

import io.bidmachine.media3.common.PlaybackException;

/* compiled from: FixedError.java */
/* loaded from: classes6.dex */
public enum b {
    NOT_FOUND_VIEWOPTION(-101, "ViewOption is null"),
    NOT_FOUND_CONTEXT(PlaybackException.ERROR_CODE_AUTHENTICATION_EXPIRED, "context is null"),
    FILE_CREATE_VIEW_FILE(PlaybackException.ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED, "file create view is null"),
    CAMPAIGNEX_IS_NULL(PlaybackException.ERROR_CODE_CONCURRENT_STREAM_LIMIT, "Campaign size only one"),
    NOT_FOUND_CAMPAIGN(PlaybackException.ERROR_CODE_PARENTAL_CONTROL_RESTRICTED, "campaign is null"),
    NOT_FOUND_DYNAMIC_FILE(PlaybackException.ERROR_CODE_NOT_AVAILABLE_IN_REGION, "dynamic file is not exits"),
    BIND_DATA_FILE_OR_DIR(PlaybackException.ERROR_CODE_SKIP_LIMIT_REACHED, "data file or file dir is not exits "),
    NOT_FOUND_DYNAMIC_OPTION(PlaybackException.ERROR_CODE_SETUP_REQUIRED, "dynamic_option is not exits");


    /* renamed from: a, reason: collision with root package name */
    private int f4171a;
    private String b;

    b(int i, String str) {
        this.f4171a = i;
        this.b = str;
    }

    public int a() {
        return this.f4171a;
    }

    public String b() {
        return this.b;
    }
}
