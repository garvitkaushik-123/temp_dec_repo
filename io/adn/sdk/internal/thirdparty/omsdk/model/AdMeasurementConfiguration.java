package io.adn.sdk.internal.thirdparty.omsdk.model;

import io.bidmachine.unified.UnifiedMediationParams;
import kotlin.Metadata;

/* compiled from: AdMeasurementConfiguration.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0010\u001a\u00020\u0011H×\u0001J\t\u0010\u0012\u001a\u00020\u0013H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementConfiguration;", "", "isSkippable", "", UnifiedMediationParams.KEY_SKIP_OFFSET, "", "<init>", "(ZF)V", "()Z", "getSkipOffset", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdMeasurementConfiguration {
    public static final int $stable = 0;
    private final boolean isSkippable;
    private final float skipOffset;

    public static /* synthetic */ AdMeasurementConfiguration copy$default(AdMeasurementConfiguration adMeasurementConfiguration, boolean z, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            z = adMeasurementConfiguration.isSkippable;
        }
        if ((i & 2) != 0) {
            f = adMeasurementConfiguration.skipOffset;
        }
        return adMeasurementConfiguration.copy(z, f);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsSkippable() {
        return this.isSkippable;
    }

    /* renamed from: component2, reason: from getter */
    public final float getSkipOffset() {
        return this.skipOffset;
    }

    public final AdMeasurementConfiguration copy(boolean isSkippable, float skipOffset) {
        return new AdMeasurementConfiguration(isSkippable, skipOffset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdMeasurementConfiguration)) {
            return false;
        }
        AdMeasurementConfiguration adMeasurementConfiguration = (AdMeasurementConfiguration) other;
        return this.isSkippable == adMeasurementConfiguration.isSkippable && Float.compare(this.skipOffset, adMeasurementConfiguration.skipOffset) == 0;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isSkippable) * 31) + Float.hashCode(this.skipOffset);
    }

    public String toString() {
        return "AdMeasurementConfiguration(isSkippable=" + this.isSkippable + ", skipOffset=" + this.skipOffset + ')';
    }

    public AdMeasurementConfiguration(boolean z, float f) {
        this.isSkippable = z;
        this.skipOffset = f;
    }

    public final boolean isSkippable() {
        return this.isSkippable;
    }

    public final float getSkipOffset() {
        return this.skipOffset;
    }
}
