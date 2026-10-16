package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;

/* compiled from: VastOffset.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "", "Time", "Percents", "Lio/adn/sdk/internal/domain/model/ad/VastOffset$Percents;", "Lio/adn/sdk/internal/domain/model/ad/VastOffset$Time;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface VastOffset {

    /* compiled from: VastOffset.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastOffset$Time;", "Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "millis", "", "<init>", "(J)V", "getMillis", "()J", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Time implements VastOffset {
        public static final int $stable = 0;
        private final long millis;

        public Time(long j) {
            this.millis = j;
        }

        public final long getMillis() {
            return this.millis;
        }
    }

    /* compiled from: VastOffset.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastOffset$Percents;", "Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "percents", "", "<init>", "(I)V", "getPercents", "()I", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Percents implements VastOffset {
        public static final int $stable = 0;
        private final int percents;

        public Percents(int i) {
            this.percents = i;
        }

        public final int getPercents() {
            return this.percents;
        }
    }
}
