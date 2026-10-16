package io.adn.sdk.internal.thirdparty.omsdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdMeasurementVerificationResource.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementVerificationResource;", "", "vendorKey", "", "verificationUrl", "verificationParameters", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVendorKey", "()Ljava/lang/String;", "getVerificationUrl", "getVerificationParameters", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdMeasurementVerificationResource {
    public static final int $stable = 0;
    private final String vendorKey;
    private final String verificationParameters;
    private final String verificationUrl;

    public static /* synthetic */ AdMeasurementVerificationResource copy$default(AdMeasurementVerificationResource adMeasurementVerificationResource, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adMeasurementVerificationResource.vendorKey;
        }
        if ((i & 2) != 0) {
            str2 = adMeasurementVerificationResource.verificationUrl;
        }
        if ((i & 4) != 0) {
            str3 = adMeasurementVerificationResource.verificationParameters;
        }
        return adMeasurementVerificationResource.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVendorKey() {
        return this.vendorKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVerificationUrl() {
        return this.verificationUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVerificationParameters() {
        return this.verificationParameters;
    }

    public final AdMeasurementVerificationResource copy(String vendorKey, String verificationUrl, String verificationParameters) {
        Intrinsics.checkNotNullParameter(vendorKey, "vendorKey");
        Intrinsics.checkNotNullParameter(verificationUrl, "verificationUrl");
        Intrinsics.checkNotNullParameter(verificationParameters, "verificationParameters");
        return new AdMeasurementVerificationResource(vendorKey, verificationUrl, verificationParameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdMeasurementVerificationResource)) {
            return false;
        }
        AdMeasurementVerificationResource adMeasurementVerificationResource = (AdMeasurementVerificationResource) other;
        return Intrinsics.areEqual(this.vendorKey, adMeasurementVerificationResource.vendorKey) && Intrinsics.areEqual(this.verificationUrl, adMeasurementVerificationResource.verificationUrl) && Intrinsics.areEqual(this.verificationParameters, adMeasurementVerificationResource.verificationParameters);
    }

    public int hashCode() {
        return (((this.vendorKey.hashCode() * 31) + this.verificationUrl.hashCode()) * 31) + this.verificationParameters.hashCode();
    }

    public String toString() {
        return "AdMeasurementVerificationResource(vendorKey=" + this.vendorKey + ", verificationUrl=" + this.verificationUrl + ", verificationParameters=" + this.verificationParameters + ')';
    }

    public AdMeasurementVerificationResource(String vendorKey, String verificationUrl, String verificationParameters) {
        Intrinsics.checkNotNullParameter(vendorKey, "vendorKey");
        Intrinsics.checkNotNullParameter(verificationUrl, "verificationUrl");
        Intrinsics.checkNotNullParameter(verificationParameters, "verificationParameters");
        this.vendorKey = vendorKey;
        this.verificationUrl = verificationUrl;
        this.verificationParameters = verificationParameters;
    }

    public final String getVendorKey() {
        return this.vendorKey;
    }

    public final String getVerificationUrl() {
        return this.verificationUrl;
    }

    public final String getVerificationParameters() {
        return this.verificationParameters;
    }
}
