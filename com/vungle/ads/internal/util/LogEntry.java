package com.vungle.ads.internal.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Logger.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/vungle/ads/internal/util/LogEntry;", "", "()V", "adSource", "", "getAdSource$vungle_ads_release", "()Ljava/lang/String;", "setAdSource$vungle_ads_release", "(Ljava/lang/String;)V", "creativeId", "getCreativeId$vungle_ads_release", "setCreativeId$vungle_ads_release", "eventId", "getEventId$vungle_ads_release", "setEventId$vungle_ads_release", "mediationName", "getMediationName$vungle_ads_release", "setMediationName$vungle_ads_release", "placementRefId", "getPlacementRefId$vungle_ads_release", "setPlacementRefId$vungle_ads_release", "vmVersion", "getVmVersion$vungle_ads_release", "setVmVersion$vungle_ads_release", "equals", "", "other", "hashCode", "", "toString", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class LogEntry {
    private String adSource;
    private String creativeId;
    private String eventId;
    private String mediationName;
    private String placementRefId;
    private String vmVersion;

    /* renamed from: getPlacementRefId$vungle_ads_release, reason: from getter */
    public final String getPlacementRefId() {
        return this.placementRefId;
    }

    public final void setPlacementRefId$vungle_ads_release(String str) {
        this.placementRefId = str;
    }

    /* renamed from: getCreativeId$vungle_ads_release, reason: from getter */
    public final String getCreativeId() {
        return this.creativeId;
    }

    public final void setCreativeId$vungle_ads_release(String str) {
        this.creativeId = str;
    }

    /* renamed from: getEventId$vungle_ads_release, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    public final void setEventId$vungle_ads_release(String str) {
        this.eventId = str;
    }

    /* renamed from: getAdSource$vungle_ads_release, reason: from getter */
    public final String getAdSource() {
        return this.adSource;
    }

    public final void setAdSource$vungle_ads_release(String str) {
        this.adSource = str;
    }

    /* renamed from: getMediationName$vungle_ads_release, reason: from getter */
    public final String getMediationName() {
        return this.mediationName;
    }

    public final void setMediationName$vungle_ads_release(String str) {
        this.mediationName = str;
    }

    /* renamed from: getVmVersion$vungle_ads_release, reason: from getter */
    public final String getVmVersion() {
        return this.vmVersion;
    }

    public final void setVmVersion$vungle_ads_release(String str) {
        this.vmVersion = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.vungle.ads.internal.util.LogEntry");
        LogEntry logEntry = (LogEntry) other;
        return Intrinsics.areEqual(this.placementRefId, logEntry.placementRefId) && Intrinsics.areEqual(this.creativeId, logEntry.creativeId) && Intrinsics.areEqual(this.eventId, logEntry.eventId) && Intrinsics.areEqual(this.adSource, logEntry.adSource) && Intrinsics.areEqual(this.mediationName, logEntry.mediationName) && Intrinsics.areEqual(this.vmVersion, logEntry.vmVersion);
    }

    public int hashCode() {
        String str = this.placementRefId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.creativeId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.eventId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.adSource;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mediationName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.vmVersion;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "LogEntry(placementRefId=" + this.placementRefId + ", creativeId=" + this.creativeId + ", eventId=" + this.eventId + ", adSource=" + this.adSource + ", mediationName=" + this.mediationName + ", vmVersion=" + this.vmVersion + ')';
    }
}
