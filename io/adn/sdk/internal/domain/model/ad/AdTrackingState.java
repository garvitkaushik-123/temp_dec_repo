package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AdTrackingState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0010\u001a\u00020\u0011H×\u0001J\t\u0010\u0012\u001a\u00020\u0013H×\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdTrackingState;", "", "isImpressionTracked", "", "isClickTracked", "<init>", "(ZZ)V", "()Z", "setImpressionTracked", "(Z)V", "setClickTracked", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdTrackingState {
    public static final int $stable = 8;
    private boolean isClickTracked;
    private boolean isImpressionTracked;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AdTrackingState() {
        this(r2, r2, 3, null);
        boolean z = false;
    }

    public static /* synthetic */ AdTrackingState copy$default(AdTrackingState adTrackingState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = adTrackingState.isImpressionTracked;
        }
        if ((i & 2) != 0) {
            z2 = adTrackingState.isClickTracked;
        }
        return adTrackingState.copy(z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsImpressionTracked() {
        return this.isImpressionTracked;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsClickTracked() {
        return this.isClickTracked;
    }

    public final AdTrackingState copy(boolean isImpressionTracked, boolean isClickTracked) {
        return new AdTrackingState(isImpressionTracked, isClickTracked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdTrackingState)) {
            return false;
        }
        AdTrackingState adTrackingState = (AdTrackingState) other;
        return this.isImpressionTracked == adTrackingState.isImpressionTracked && this.isClickTracked == adTrackingState.isClickTracked;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isImpressionTracked) * 31) + Boolean.hashCode(this.isClickTracked);
    }

    public String toString() {
        return "AdTrackingState(isImpressionTracked=" + this.isImpressionTracked + ", isClickTracked=" + this.isClickTracked + ')';
    }

    public AdTrackingState(boolean z, boolean z2) {
        this.isImpressionTracked = z;
        this.isClickTracked = z2;
    }

    public /* synthetic */ AdTrackingState(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    public final boolean isImpressionTracked() {
        return this.isImpressionTracked;
    }

    public final void setImpressionTracked(boolean z) {
        this.isImpressionTracked = z;
    }

    public final boolean isClickTracked() {
        return this.isClickTracked;
    }

    public final void setClickTracked(boolean z) {
        this.isClickTracked = z;
    }
}
