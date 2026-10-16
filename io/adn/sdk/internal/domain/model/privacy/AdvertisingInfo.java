package io.adn.sdk.internal.domain.model.privacy;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdvertisingInfo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÇ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001c\u001a\u00020\u0006H×\u0001J\t\u0010\u001d\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lio/adn/sdk/internal/domain/model/privacy/AdvertisingInfo;", "", "advertisingId", "", "appSetId", "appSetIdScope", "", "limitAdTrackingEnabled", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAdvertisingId", "()Ljava/lang/String;", "getAppSetId", "getAppSetIdScope", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLimitAdTrackingEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lio/adn/sdk/internal/domain/model/privacy/AdvertisingInfo;", "equals", "other", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdvertisingInfo {
    public static final int $stable = 0;
    private final String advertisingId;
    private final String appSetId;
    private final Integer appSetIdScope;
    private final Boolean limitAdTrackingEnabled;

    public static /* synthetic */ AdvertisingInfo copy$default(AdvertisingInfo advertisingInfo, String str, String str2, Integer num, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = advertisingInfo.advertisingId;
        }
        if ((i & 2) != 0) {
            str2 = advertisingInfo.appSetId;
        }
        if ((i & 4) != 0) {
            num = advertisingInfo.appSetIdScope;
        }
        if ((i & 8) != 0) {
            bool = advertisingInfo.limitAdTrackingEnabled;
        }
        return advertisingInfo.copy(str, str2, num, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAdvertisingId() {
        return this.advertisingId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppSetId() {
        return this.appSetId;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getAppSetIdScope() {
        return this.appSetIdScope;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getLimitAdTrackingEnabled() {
        return this.limitAdTrackingEnabled;
    }

    public final AdvertisingInfo copy(String advertisingId, String appSetId, Integer appSetIdScope, Boolean limitAdTrackingEnabled) {
        return new AdvertisingInfo(advertisingId, appSetId, appSetIdScope, limitAdTrackingEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvertisingInfo)) {
            return false;
        }
        AdvertisingInfo advertisingInfo = (AdvertisingInfo) other;
        return Intrinsics.areEqual(this.advertisingId, advertisingInfo.advertisingId) && Intrinsics.areEqual(this.appSetId, advertisingInfo.appSetId) && Intrinsics.areEqual(this.appSetIdScope, advertisingInfo.appSetIdScope) && Intrinsics.areEqual(this.limitAdTrackingEnabled, advertisingInfo.limitAdTrackingEnabled);
    }

    public int hashCode() {
        String str = this.advertisingId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.appSetId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.appSetIdScope;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.limitAdTrackingEnabled;
        return hashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "AdvertisingInfo(advertisingId=" + this.advertisingId + ", appSetId=" + this.appSetId + ", appSetIdScope=" + this.appSetIdScope + ", limitAdTrackingEnabled=" + this.limitAdTrackingEnabled + ')';
    }

    public AdvertisingInfo(String str, String str2, Integer num, Boolean bool) {
        this.advertisingId = str;
        this.appSetId = str2;
        this.appSetIdScope = num;
        this.limitAdTrackingEnabled = bool;
    }

    public final String getAdvertisingId() {
        return this.advertisingId;
    }

    public final String getAppSetId() {
        return this.appSetId;
    }

    public final Integer getAppSetIdScope() {
        return this.appSetIdScope;
    }

    public /* synthetic */ AdvertisingInfo(String str, String str2, Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, num, (i & 8) != 0 ? false : bool);
    }

    public final Boolean getLimitAdTrackingEnabled() {
        return this.limitAdTrackingEnabled;
    }
}
