package io.adn.sdk.internal.domain.model.ui;

import com.inmobi.unification.sdk.InitializationStatus;
import io.adn.sdk.internal.domain.error.AdException;
import io.bidmachine.iab.vast.tags.VastTagName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RenderingState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/domain/model/ui/RenderingState;", "", VastTagName.PROGRESS, InitializationStatus.SUCCESS, "Failure", "Lio/adn/sdk/internal/domain/model/ui/RenderingState$Failure;", "Lio/adn/sdk/internal/domain/model/ui/RenderingState$Progress;", "Lio/adn/sdk/internal/domain/model/ui/RenderingState$Success;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface RenderingState {

    /* compiled from: RenderingState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ui/RenderingState$Progress;", "Lio/adn/sdk/internal/domain/model/ui/RenderingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Progress implements RenderingState {
        public static final int $stable = 0;
        public static final Progress INSTANCE = new Progress();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Progress)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1034010425;
        }

        public String toString() {
            return VastTagName.PROGRESS;
        }

        private Progress() {
        }
    }

    /* compiled from: RenderingState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ui/RenderingState$Success;", "Lio/adn/sdk/internal/domain/model/ui/RenderingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Success implements RenderingState {
        public static final int $stable = 0;
        public static final Success INSTANCE = new Success();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1385066871;
        }

        public String toString() {
            return InitializationStatus.SUCCESS;
        }

        private Success() {
        }
    }

    /* compiled from: RenderingState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/domain/model/ui/RenderingState$Failure;", "Lio/adn/sdk/internal/domain/model/ui/RenderingState;", "exception", "Lio/adn/sdk/internal/domain/error/AdException;", "<init>", "(Lio/adn/sdk/internal/domain/error/AdException;)V", "getException", "()Lio/adn/sdk/internal/domain/error/AdException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Failure implements RenderingState {
        public static final int $stable = 0;
        private final AdException exception;

        public static /* synthetic */ Failure copy$default(Failure failure, AdException adException, int i, Object obj) {
            if ((i & 1) != 0) {
                adException = failure.exception;
            }
            return failure.copy(adException);
        }

        /* renamed from: component1, reason: from getter */
        public final AdException getException() {
            return this.exception;
        }

        public final Failure copy(AdException exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return new Failure(exception);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failure) && Intrinsics.areEqual(this.exception, ((Failure) other).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(exception=" + this.exception + ')';
        }

        public Failure(AdException exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public final AdException getException() {
            return this.exception;
        }
    }
}
