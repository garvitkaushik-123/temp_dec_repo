package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributionSource.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AttributionSource;", "", "Adn", "ThirdParty", "Unknown", "Lio/adn/sdk/internal/domain/model/ad/AttributionSource$Adn;", "Lio/adn/sdk/internal/domain/model/ad/AttributionSource$ThirdParty;", "Lio/adn/sdk/internal/domain/model/ad/AttributionSource$Unknown;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AttributionSource {

    /* compiled from: AttributionSource.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AttributionSource$Adn;", "Lio/adn/sdk/internal/domain/model/ad/AttributionSource;", "callbackUrl", "", "<init>", "(Ljava/lang/String;)V", "getCallbackUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Adn implements AttributionSource {
        public static final int $stable = 0;
        private final String callbackUrl;

        public static /* synthetic */ Adn copy$default(Adn adn2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = adn2.callbackUrl;
            }
            return adn2.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCallbackUrl() {
            return this.callbackUrl;
        }

        public final Adn copy(String callbackUrl) {
            Intrinsics.checkNotNullParameter(callbackUrl, "callbackUrl");
            return new Adn(callbackUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Adn) && Intrinsics.areEqual(this.callbackUrl, ((Adn) other).callbackUrl);
        }

        public int hashCode() {
            return this.callbackUrl.hashCode();
        }

        public String toString() {
            return "Adn(callbackUrl=" + this.callbackUrl + ')';
        }

        public Adn(String callbackUrl) {
            Intrinsics.checkNotNullParameter(callbackUrl, "callbackUrl");
            this.callbackUrl = callbackUrl;
        }

        public final String getCallbackUrl() {
            return this.callbackUrl;
        }
    }

    /* compiled from: AttributionSource.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AttributionSource$ThirdParty;", "Lio/adn/sdk/internal/domain/model/ad/AttributionSource;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ThirdParty implements AttributionSource {
        public static final int $stable = 0;
        public static final ThirdParty INSTANCE = new ThirdParty();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThirdParty)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1144365311;
        }

        public String toString() {
            return "ThirdParty";
        }

        private ThirdParty() {
        }
    }

    /* compiled from: AttributionSource.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AttributionSource$Unknown;", "Lio/adn/sdk/internal/domain/model/ad/AttributionSource;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Unknown implements AttributionSource {
        public static final int $stable = 0;
        public static final Unknown INSTANCE = new Unknown();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unknown)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 750293576;
        }

        public String toString() {
            return "Unknown";
        }

        private Unknown() {
        }
    }
}
