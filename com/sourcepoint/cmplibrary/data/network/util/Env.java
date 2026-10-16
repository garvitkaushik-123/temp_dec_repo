package com.sourcepoint.cmplibrary.data.network.util;

import com.example.cmplibrary.BuildConfig;
import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HttpUrlManager.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "", "host", "", "pmHostGdpr", "pmHostCcpa", "pmHostUSNat", "queryParam", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHost", "()Ljava/lang/String;", "getPmHostCcpa", "getPmHostGdpr", "getPmHostUSNat", "getQueryParam", "STAGE", "PRE_PROD", "LOCAL_PROD", BuildConfig.SDK_ENV, "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Env {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Env[] $VALUES;
    private final String host;
    private final String pmHostCcpa;
    private final String pmHostGdpr;
    private final String pmHostUSNat;
    private final String queryParam;
    public static final Env STAGE = new Env("STAGE", 0, "cdn.sp-stage.net", "notice.sp-stage.net", "ccpa-notice.sp-stage.net", "ccpa-notice.sp-stage.net", C3040d4.h.q);
    public static final Env PRE_PROD = new Env("PRE_PROD", 1, "preprod-cdn.privacy-mgmt.com", "preprod-cdn.privacy-mgmt.com", "preprod-cdn.privacy-mgmt.com", "preprod-cdn.privacy-mgmt.com", "prod");
    public static final Env LOCAL_PROD = new Env("LOCAL_PROD", 2, "cdn.privacy-mgmt.com", "cdn.privacy-mgmt.com", "cdn.privacy-mgmt.com", "cdn.privacy-mgmt.com", "localProd");
    public static final Env PROD = new Env(BuildConfig.SDK_ENV, 3, "cdn.privacy-mgmt.com", "cdn.privacy-mgmt.com", "cdn.privacy-mgmt.com", "cdn.privacy-mgmt.com", "prod");

    private static final /* synthetic */ Env[] $values() {
        return new Env[]{STAGE, PRE_PROD, LOCAL_PROD, PROD};
    }

    public static EnumEntries<Env> getEntries() {
        return $ENTRIES;
    }

    public static Env valueOf(String str) {
        return (Env) Enum.valueOf(Env.class, str);
    }

    public static Env[] values() {
        return (Env[]) $VALUES.clone();
    }

    private Env(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        this.host = str2;
        this.pmHostGdpr = str3;
        this.pmHostCcpa = str4;
        this.pmHostUSNat = str5;
        this.queryParam = str6;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getPmHostGdpr() {
        return this.pmHostGdpr;
    }

    public final String getPmHostCcpa() {
        return this.pmHostCcpa;
    }

    public final String getPmHostUSNat() {
        return this.pmHostUSNat;
    }

    public final String getQueryParam() {
        return this.queryParam;
    }

    static {
        Env[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
