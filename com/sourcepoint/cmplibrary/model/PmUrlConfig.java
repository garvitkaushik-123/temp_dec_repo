package com.sourcepoint.cmplibrary.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PmUrlConfig.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/PmUrlConfig;", "", "pmTab", "Lcom/sourcepoint/cmplibrary/model/PMTab;", "consentLanguage", "", "uuid", "siteId", "messageId", "(Lcom/sourcepoint/cmplibrary/model/PMTab;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConsentLanguage", "()Ljava/lang/String;", "getMessageId", "getPmTab", "()Lcom/sourcepoint/cmplibrary/model/PMTab;", "getSiteId", "getUuid", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PmUrlConfig {
    private final String consentLanguage;
    private final String messageId;
    private final PMTab pmTab;
    private final String siteId;
    private final String uuid;

    public PmUrlConfig(PMTab pMTab, String str, String str2, String str3, String str4) {
        this.pmTab = pMTab;
        this.consentLanguage = str;
        this.uuid = str2;
        this.siteId = str3;
        this.messageId = str4;
    }

    public /* synthetic */ PmUrlConfig(PMTab pMTab, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PMTab.PURPOSES : pMTab, str, str2, str3, str4);
    }

    public final PMTab getPmTab() {
        return this.pmTab;
    }

    public final String getConsentLanguage() {
        return this.consentLanguage;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getSiteId() {
        return this.siteId;
    }

    public final String getMessageId() {
        return this.messageId;
    }
}
