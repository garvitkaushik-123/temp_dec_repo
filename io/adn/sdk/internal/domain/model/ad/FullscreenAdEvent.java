package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdEvent.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent;", "", "Impression", "ClickThrough", "Dismiss", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent$ClickThrough;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent$Dismiss;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent$Impression;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface FullscreenAdEvent {

    /* compiled from: FullscreenAdEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent$Impression;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Impression implements FullscreenAdEvent {
        public static final int $stable = 0;
        public static final Impression INSTANCE = new Impression();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Impression)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2010943607;
        }

        public String toString() {
            return "Impression";
        }

        private Impression() {
        }
    }

    /* compiled from: FullscreenAdEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent$ClickThrough;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ClickThrough implements FullscreenAdEvent {
        public static final int $stable = 0;
        public static final ClickThrough INSTANCE = new ClickThrough();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClickThrough)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -518909539;
        }

        public String toString() {
            return "ClickThrough";
        }

        private ClickThrough() {
        }
    }

    /* compiled from: FullscreenAdEvent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent$Dismiss;", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent;", "origin", "Lio/adn/sdk/internal/domain/model/ad/DismissOrigin;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/DismissOrigin;)V", "getOrigin", "()Lio/adn/sdk/internal/domain/model/ad/DismissOrigin;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Dismiss implements FullscreenAdEvent {
        public static final int $stable = 0;
        private final DismissOrigin origin;

        public static /* synthetic */ Dismiss copy$default(Dismiss dismiss, DismissOrigin dismissOrigin, int i, Object obj) {
            if ((i & 1) != 0) {
                dismissOrigin = dismiss.origin;
            }
            return dismiss.copy(dismissOrigin);
        }

        /* renamed from: component1, reason: from getter */
        public final DismissOrigin getOrigin() {
            return this.origin;
        }

        public final Dismiss copy(DismissOrigin origin) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            return new Dismiss(origin);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Dismiss) && this.origin == ((Dismiss) other).origin;
        }

        public int hashCode() {
            return this.origin.hashCode();
        }

        public String toString() {
            return "Dismiss(origin=" + this.origin + ')';
        }

        public Dismiss(DismissOrigin origin) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            this.origin = origin;
        }

        public final DismissOrigin getOrigin() {
            return this.origin;
        }
    }
}
