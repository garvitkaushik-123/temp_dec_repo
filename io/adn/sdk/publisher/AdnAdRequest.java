package io.adn.sdk.publisher;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdnAdRequest.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\n\u000bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lio/adn/sdk/publisher/AdnAdRequest;", "", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "getPlacement", "()Lio/adn/sdk/publisher/AdnAdPlacement;", "timeout", "Lio/adn/sdk/publisher/AdnLoadTimeout;", "getTimeout", "()Lio/adn/sdk/publisher/AdnLoadTimeout;", "AdBidRequest", "AdBidFetchRequest", "Lio/adn/sdk/publisher/AdnAdRequest$AdBidFetchRequest;", "Lio/adn/sdk/publisher/AdnAdRequest$AdBidRequest;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdnAdRequest {
    AdnAdPlacement getPlacement();

    AdnLoadTimeout getTimeout();

    /* compiled from: AdnAdRequest.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H×\u0003J\t\u0010\u0018\u001a\u00020\u0019H×\u0001J\t\u0010\u001a\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lio/adn/sdk/publisher/AdnAdRequest$AdBidRequest;", "Lio/adn/sdk/publisher/AdnAdRequest;", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "bidPayload", "", "timeout", "Lio/adn/sdk/publisher/AdnLoadTimeout;", "<init>", "(Lio/adn/sdk/publisher/AdnAdPlacement;Ljava/lang/String;Lio/adn/sdk/publisher/AdnLoadTimeout;)V", "getPlacement", "()Lio/adn/sdk/publisher/AdnAdPlacement;", "getBidPayload", "()Ljava/lang/String;", "getTimeout", "()Lio/adn/sdk/publisher/AdnLoadTimeout;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class AdBidRequest implements AdnAdRequest {
        public static final int $stable = 0;
        private final String bidPayload;
        private final AdnAdPlacement placement;
        private final AdnLoadTimeout timeout;

        public static /* synthetic */ AdBidRequest copy$default(AdBidRequest adBidRequest, AdnAdPlacement adnAdPlacement, String str, AdnLoadTimeout adnLoadTimeout, int i, Object obj) {
            if ((i & 1) != 0) {
                adnAdPlacement = adBidRequest.placement;
            }
            if ((i & 2) != 0) {
                str = adBidRequest.bidPayload;
            }
            if ((i & 4) != 0) {
                adnLoadTimeout = adBidRequest.timeout;
            }
            return adBidRequest.copy(adnAdPlacement, str, adnLoadTimeout);
        }

        /* renamed from: component1, reason: from getter */
        public final AdnAdPlacement getPlacement() {
            return this.placement;
        }

        /* renamed from: component2, reason: from getter */
        public final String getBidPayload() {
            return this.bidPayload;
        }

        /* renamed from: component3, reason: from getter */
        public final AdnLoadTimeout getTimeout() {
            return this.timeout;
        }

        public final AdBidRequest copy(AdnAdPlacement placement, String bidPayload, AdnLoadTimeout timeout) {
            Intrinsics.checkNotNullParameter(placement, "placement");
            Intrinsics.checkNotNullParameter(timeout, "timeout");
            return new AdBidRequest(placement, bidPayload, timeout);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdBidRequest)) {
                return false;
            }
            AdBidRequest adBidRequest = (AdBidRequest) other;
            return this.placement == adBidRequest.placement && Intrinsics.areEqual(this.bidPayload, adBidRequest.bidPayload) && this.timeout == adBidRequest.timeout;
        }

        public int hashCode() {
            int hashCode = this.placement.hashCode() * 31;
            String str = this.bidPayload;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.timeout.hashCode();
        }

        public String toString() {
            return "AdBidRequest(placement=" + this.placement + ", bidPayload=" + this.bidPayload + ", timeout=" + this.timeout + ')';
        }

        public AdBidRequest(AdnAdPlacement placement, String str, AdnLoadTimeout timeout) {
            Intrinsics.checkNotNullParameter(placement, "placement");
            Intrinsics.checkNotNullParameter(timeout, "timeout");
            this.placement = placement;
            this.bidPayload = str;
            this.timeout = timeout;
        }

        @Override // io.adn.sdk.publisher.AdnAdRequest
        public AdnAdPlacement getPlacement() {
            return this.placement;
        }

        public final String getBidPayload() {
            return this.bidPayload;
        }

        public /* synthetic */ AdBidRequest(AdnAdPlacement adnAdPlacement, String str, AdnLoadTimeout adnLoadTimeout, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(adnAdPlacement, str, (i & 4) != 0 ? AdnLoadTimeout.DEFAULT : adnLoadTimeout);
        }

        @Override // io.adn.sdk.publisher.AdnAdRequest
        public AdnLoadTimeout getTimeout() {
            return this.timeout;
        }
    }

    /* compiled from: AdnAdRequest.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0016H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lio/adn/sdk/publisher/AdnAdRequest$AdBidFetchRequest;", "Lio/adn/sdk/publisher/AdnAdRequest;", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "timeout", "Lio/adn/sdk/publisher/AdnLoadTimeout;", "<init>", "(Lio/adn/sdk/publisher/AdnAdPlacement;Lio/adn/sdk/publisher/AdnLoadTimeout;)V", "getPlacement", "()Lio/adn/sdk/publisher/AdnAdPlacement;", "getTimeout", "()Lio/adn/sdk/publisher/AdnLoadTimeout;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class AdBidFetchRequest implements AdnAdRequest {
        public static final int $stable = 0;
        private final AdnAdPlacement placement;
        private final AdnLoadTimeout timeout;

        public static /* synthetic */ AdBidFetchRequest copy$default(AdBidFetchRequest adBidFetchRequest, AdnAdPlacement adnAdPlacement, AdnLoadTimeout adnLoadTimeout, int i, Object obj) {
            if ((i & 1) != 0) {
                adnAdPlacement = adBidFetchRequest.placement;
            }
            if ((i & 2) != 0) {
                adnLoadTimeout = adBidFetchRequest.timeout;
            }
            return adBidFetchRequest.copy(adnAdPlacement, adnLoadTimeout);
        }

        /* renamed from: component1, reason: from getter */
        public final AdnAdPlacement getPlacement() {
            return this.placement;
        }

        /* renamed from: component2, reason: from getter */
        public final AdnLoadTimeout getTimeout() {
            return this.timeout;
        }

        public final AdBidFetchRequest copy(AdnAdPlacement placement, AdnLoadTimeout timeout) {
            Intrinsics.checkNotNullParameter(placement, "placement");
            Intrinsics.checkNotNullParameter(timeout, "timeout");
            return new AdBidFetchRequest(placement, timeout);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdBidFetchRequest)) {
                return false;
            }
            AdBidFetchRequest adBidFetchRequest = (AdBidFetchRequest) other;
            return this.placement == adBidFetchRequest.placement && this.timeout == adBidFetchRequest.timeout;
        }

        public int hashCode() {
            return (this.placement.hashCode() * 31) + this.timeout.hashCode();
        }

        public String toString() {
            return "AdBidFetchRequest(placement=" + this.placement + ", timeout=" + this.timeout + ')';
        }

        public AdBidFetchRequest(AdnAdPlacement placement, AdnLoadTimeout timeout) {
            Intrinsics.checkNotNullParameter(placement, "placement");
            Intrinsics.checkNotNullParameter(timeout, "timeout");
            this.placement = placement;
            this.timeout = timeout;
        }

        @Override // io.adn.sdk.publisher.AdnAdRequest
        public AdnAdPlacement getPlacement() {
            return this.placement;
        }

        public /* synthetic */ AdBidFetchRequest(AdnAdPlacement adnAdPlacement, AdnLoadTimeout adnLoadTimeout, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(adnAdPlacement, (i & 2) != 0 ? AdnLoadTimeout.DEFAULT : adnLoadTimeout);
        }

        @Override // io.adn.sdk.publisher.AdnAdRequest
        public AdnLoadTimeout getTimeout() {
            return this.timeout;
        }
    }
}
