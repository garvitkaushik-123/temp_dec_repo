package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0014\u001a\u00020\u0015H×\u0001J\t\u0010\u0016\u001a\u00020\u0017H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdStoreConfig;", "", "delay", "", "dismissable", "", "enabled", "<init>", "(DZZ)V", "getDelay", "()D", "getDismissable", "()Z", "getEnabled", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdStoreConfig {
    public static final int $stable = 0;
    private final double delay;
    private final boolean dismissable;
    private final boolean enabled;

    public AdStoreConfig() {
        this(0.0d, false, false, 7, null);
    }

    public static /* synthetic */ AdStoreConfig copy$default(AdStoreConfig adStoreConfig, double d, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = adStoreConfig.delay;
        }
        if ((i & 2) != 0) {
            z = adStoreConfig.dismissable;
        }
        if ((i & 4) != 0) {
            z2 = adStoreConfig.enabled;
        }
        return adStoreConfig.copy(d, z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final double getDelay() {
        return this.delay;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getDismissable() {
        return this.dismissable;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final AdStoreConfig copy(double delay, boolean dismissable, boolean enabled) {
        return new AdStoreConfig(delay, dismissable, enabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdStoreConfig)) {
            return false;
        }
        AdStoreConfig adStoreConfig = (AdStoreConfig) other;
        return Double.compare(this.delay, adStoreConfig.delay) == 0 && this.dismissable == adStoreConfig.dismissable && this.enabled == adStoreConfig.enabled;
    }

    public int hashCode() {
        return (((Double.hashCode(this.delay) * 31) + Boolean.hashCode(this.dismissable)) * 31) + Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "AdStoreConfig(delay=" + this.delay + ", dismissable=" + this.dismissable + ", enabled=" + this.enabled + ')';
    }

    public AdStoreConfig(double d, boolean z, boolean z2) {
        this.delay = d;
        this.dismissable = z;
        this.enabled = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AdStoreConfig(double d, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, (i & 2) != 0 ? true : z, (i & 4) != 0 ? d >= 0.0d : z2);
        d = (i & 1) != 0 ? -1.0d : d;
    }

    public final double getDelay() {
        return this.delay;
    }

    public final boolean getDismissable() {
        return this.dismissable;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }
}
