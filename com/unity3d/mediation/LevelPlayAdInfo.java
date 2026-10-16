package com.unity3d.mediation;

import com.ironsource.C3132ib;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class LevelPlayAdInfo {

    /* renamed from: a, reason: collision with root package name */
    private final String f6442a;
    private final String b;
    private final String c;
    private final ImpressionData d;
    private final C3132ib e;
    private final LevelPlayAdSize f;
    private final String g;

    @Deprecated(message = "This constructor is deprecated and will be removed in version 9.0.0.")
    public LevelPlayAdInfo(String adId, String adUnitId, String adFormat, ImpressionData impressionData, C3132ib c3132ib, LevelPlayAdSize levelPlayAdSize, String str) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        this.f6442a = adId;
        this.b = adUnitId;
        this.c = adFormat;
        this.d = impressionData;
        this.e = c3132ib;
        this.f = levelPlayAdSize;
        this.g = str;
    }

    private final String a() {
        return this.f6442a;
    }

    private final String b() {
        return this.b;
    }

    private final String c() {
        return this.c;
    }

    public static /* synthetic */ LevelPlayAdInfo copy$default(LevelPlayAdInfo levelPlayAdInfo, String str, String str2, String str3, ImpressionData impressionData, C3132ib c3132ib, LevelPlayAdSize levelPlayAdSize, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = levelPlayAdInfo.f6442a;
        }
        if ((i & 2) != 0) {
            str2 = levelPlayAdInfo.b;
        }
        if ((i & 4) != 0) {
            str3 = levelPlayAdInfo.c;
        }
        if ((i & 8) != 0) {
            impressionData = levelPlayAdInfo.d;
        }
        if ((i & 16) != 0) {
            c3132ib = levelPlayAdInfo.e;
        }
        if ((i & 32) != 0) {
            levelPlayAdSize = levelPlayAdInfo.f;
        }
        if ((i & 64) != 0) {
            str4 = levelPlayAdInfo.g;
        }
        LevelPlayAdSize levelPlayAdSize2 = levelPlayAdSize;
        String str5 = str4;
        C3132ib c3132ib2 = c3132ib;
        String str6 = str3;
        return levelPlayAdInfo.copy(str, str2, str6, impressionData, c3132ib2, levelPlayAdSize2, str5);
    }

    private final ImpressionData d() {
        return this.d;
    }

    private final C3132ib e() {
        return this.e;
    }

    private final LevelPlayAdSize f() {
        return this.f;
    }

    private final String g() {
        return this.g;
    }

    public final LevelPlayAdInfo copy(String adId, String adUnitId, String adFormat, ImpressionData impressionData, C3132ib c3132ib, LevelPlayAdSize levelPlayAdSize, String str) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        return new LevelPlayAdInfo(adId, adUnitId, adFormat, impressionData, c3132ib, levelPlayAdSize, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LevelPlayAdInfo)) {
            return false;
        }
        LevelPlayAdInfo levelPlayAdInfo = (LevelPlayAdInfo) obj;
        return Intrinsics.areEqual(this.f6442a, levelPlayAdInfo.f6442a) && Intrinsics.areEqual(this.b, levelPlayAdInfo.b) && Intrinsics.areEqual(this.c, levelPlayAdInfo.c) && Intrinsics.areEqual(this.d, levelPlayAdInfo.d) && Intrinsics.areEqual(this.e, levelPlayAdInfo.e) && Intrinsics.areEqual(this.f, levelPlayAdInfo.f) && Intrinsics.areEqual(this.g, levelPlayAdInfo.g);
    }

    public final String getAb() {
        ImpressionData impressionData = this.d;
        String ab = impressionData != null ? impressionData.getAb() : null;
        return ab == null ? "" : ab;
    }

    public final String getAdFormat() {
        ImpressionData impressionData = this.d;
        String adFormat = impressionData != null ? impressionData.getAdFormat() : null;
        return adFormat == null ? this.c : adFormat;
    }

    public final String getAdId() {
        return this.f6442a;
    }

    public final String getAdNetwork() {
        ImpressionData impressionData = this.d;
        String adNetwork = impressionData != null ? impressionData.getAdNetwork() : null;
        return adNetwork == null ? "" : adNetwork;
    }

    public final LevelPlayAdSize getAdSize() {
        return this.f;
    }

    public final String getAdUnitId() {
        ImpressionData impressionData = this.d;
        String mediationAdUnitId = impressionData != null ? impressionData.getMediationAdUnitId() : null;
        return mediationAdUnitId == null ? this.b : mediationAdUnitId;
    }

    public final String getAdUnitName() {
        ImpressionData impressionData = this.d;
        String mediationAdUnitName = impressionData != null ? impressionData.getMediationAdUnitName() : null;
        return mediationAdUnitName == null ? "" : mediationAdUnitName;
    }

    public final String getAuctionId() {
        ImpressionData impressionData = this.d;
        String auctionId = impressionData != null ? impressionData.getAuctionId() : null;
        return auctionId == null ? "" : auctionId;
    }

    public final String getCountry() {
        ImpressionData impressionData = this.d;
        String country = impressionData != null ? impressionData.getCountry() : null;
        return country == null ? "" : country;
    }

    public final String getCreativeId() {
        ImpressionData impressionData = this.d;
        String creativeId = impressionData != null ? impressionData.getCreativeId() : null;
        return creativeId == null ? "" : creativeId;
    }

    public final String getEncryptedCPM() {
        ImpressionData impressionData = this.d;
        String encryptedCPM = impressionData != null ? impressionData.getEncryptedCPM() : null;
        return encryptedCPM == null ? "" : encryptedCPM;
    }

    public final String getInstanceId() {
        ImpressionData impressionData = this.d;
        String instanceId = impressionData != null ? impressionData.getInstanceId() : null;
        return instanceId == null ? "" : instanceId;
    }

    public final String getInstanceName() {
        ImpressionData impressionData = this.d;
        String instanceName = impressionData != null ? impressionData.getInstanceName() : null;
        return instanceName == null ? "" : instanceName;
    }

    public final String getPlacementName() {
        String str = this.g;
        return str == null ? "" : str;
    }

    public final String getPrecision() {
        String c;
        C3132ib c3132ib = this.e;
        if (c3132ib != null && (c = c3132ib.c()) != null) {
            return c;
        }
        ImpressionData impressionData = this.d;
        String precision = impressionData != null ? impressionData.getPrecision() : null;
        return precision == null ? "" : precision;
    }

    public final double getRevenue() {
        C3132ib c3132ib = this.e;
        if (c3132ib != null) {
            return c3132ib.d();
        }
        ImpressionData impressionData = this.d;
        Double revenue = impressionData != null ? impressionData.getRevenue() : null;
        if (revenue != null) {
            return revenue.doubleValue();
        }
        return 0.0d;
    }

    public final String getSegmentName() {
        ImpressionData impressionData = this.d;
        String segmentName = impressionData != null ? impressionData.getSegmentName() : null;
        return segmentName == null ? "" : segmentName;
    }

    public int hashCode() {
        int hashCode = ((((this.f6442a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        ImpressionData impressionData = this.d;
        int hashCode2 = (hashCode + (impressionData == null ? 0 : impressionData.hashCode())) * 31;
        C3132ib c3132ib = this.e;
        int hashCode3 = (hashCode2 + (c3132ib == null ? 0 : c3132ib.hashCode())) * 31;
        LevelPlayAdSize levelPlayAdSize = this.f;
        int hashCode4 = (hashCode3 + (levelPlayAdSize == null ? 0 : levelPlayAdSize.hashCode())) * 31;
        String str = this.g;
        return hashCode4 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "adId: " + getAdId() + ", adUnitId: " + getAdUnitId() + ", adUnitName: " + getAdUnitName() + ", adSize: " + this.f + ", adFormat: " + getAdFormat() + ", placementName: " + getPlacementName() + ", auctionId: " + getAuctionId() + ", country: " + getCountry() + ", ab: " + getAb() + ", segmentName: " + getSegmentName() + ", adNetwork: " + getAdNetwork() + ", instanceName: " + getInstanceName() + ", instanceId: " + getInstanceId() + ", revenue: " + getRevenue() + ", precision: " + getPrecision() + ", encryptedCPM: " + getEncryptedCPM() + ", creativeId: " + getCreativeId();
    }

    public /* synthetic */ LevelPlayAdInfo(String str, String str2, String str3, ImpressionData impressionData, C3132ib c3132ib, LevelPlayAdSize levelPlayAdSize, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : impressionData, (i & 16) != 0 ? null : c3132ib, (i & 32) != 0 ? null : levelPlayAdSize, (i & 64) != 0 ? null : str4);
    }

    public /* synthetic */ LevelPlayAdInfo(String str, String str2, String str3, ImpressionData impressionData, C3132ib c3132ib, LevelPlayAdSize levelPlayAdSize, String str4, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : impressionData, (i & 16) != 0 ? null : c3132ib, (i & 32) != 0 ? null : levelPlayAdSize, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? MapsKt.emptyMap() : map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LevelPlayAdInfo(String adId, String adUnitId, String adFormat, ImpressionData impressionData, C3132ib c3132ib, LevelPlayAdSize levelPlayAdSize, String str, Map<String, ? extends Object> adapterData) {
        this(adId, adUnitId, adFormat, impressionData, c3132ib, levelPlayAdSize, str);
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adapterData, "adapterData");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated and will be removed in version 9.0.0.")
    public LevelPlayAdInfo(LevelPlayAdInfo adInfo, String str) {
        this(adInfo.f6442a, adInfo.b, adInfo.c, adInfo.d, adInfo.e, adInfo.f, str);
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
    }
}
