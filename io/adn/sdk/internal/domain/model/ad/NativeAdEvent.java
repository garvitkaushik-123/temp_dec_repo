package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;

/* compiled from: NativeAdEvent.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdEvent;", "", "Impression", "ClickThrough", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEvent$ClickThrough;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEvent$Impression;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface NativeAdEvent {

    /* compiled from: NativeAdEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdEvent$Impression;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Impression implements NativeAdEvent {
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
            return -448812059;
        }

        public String toString() {
            return "Impression";
        }

        private Impression() {
        }
    }

    /* compiled from: NativeAdEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdEvent$ClickThrough;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ClickThrough implements NativeAdEvent {
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
            return 1745921785;
        }

        public String toString() {
            return "ClickThrough";
        }

        private ClickThrough() {
        }
    }
}
