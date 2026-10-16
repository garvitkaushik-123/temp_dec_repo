package io.adn.sdk.internal.domain.model.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VideoState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lio/adn/sdk/internal/domain/model/ui/VideoState;", "", "<init>", "()V", "Playing", "Paused", "Finished", "Lio/adn/sdk/internal/domain/model/ui/VideoState$Finished;", "Lio/adn/sdk/internal/domain/model/ui/VideoState$Paused;", "Lio/adn/sdk/internal/domain/model/ui/VideoState$Playing;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public abstract class VideoState {
    public static final int $stable = 0;

    public /* synthetic */ VideoState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: VideoState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ui/VideoState$Playing;", "Lio/adn/sdk/internal/domain/model/ui/VideoState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Playing extends VideoState {
        public static final int $stable = 0;
        public static final Playing INSTANCE = new Playing();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Playing)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -347060589;
        }

        public String toString() {
            return "Playing";
        }

        private Playing() {
            super(null);
        }
    }

    private VideoState() {
    }

    /* compiled from: VideoState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/domain/model/ui/VideoState$Paused;", "Lio/adn/sdk/internal/domain/model/ui/VideoState;", "lastPosition", "", "<init>", "(J)V", "getLastPosition", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Paused extends VideoState {
        public static final int $stable = 0;
        private final long lastPosition;

        public static /* synthetic */ Paused copy$default(Paused paused, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = paused.lastPosition;
            }
            return paused.copy(j);
        }

        /* renamed from: component1, reason: from getter */
        public final long getLastPosition() {
            return this.lastPosition;
        }

        public final Paused copy(long lastPosition) {
            return new Paused(lastPosition);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Paused) && this.lastPosition == ((Paused) other).lastPosition;
        }

        public int hashCode() {
            return Long.hashCode(this.lastPosition);
        }

        public String toString() {
            return "Paused(lastPosition=" + this.lastPosition + ')';
        }

        public Paused(long j) {
            super(null);
            this.lastPosition = j;
        }

        public final long getLastPosition() {
            return this.lastPosition;
        }
    }

    /* compiled from: VideoState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ui/VideoState$Finished;", "Lio/adn/sdk/internal/domain/model/ui/VideoState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Finished extends VideoState {
        public static final int $stable = 0;
        public static final Finished INSTANCE = new Finished();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Finished)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -427026771;
        }

        public String toString() {
            return "Finished";
        }

        private Finished() {
            super(null);
        }
    }
}
