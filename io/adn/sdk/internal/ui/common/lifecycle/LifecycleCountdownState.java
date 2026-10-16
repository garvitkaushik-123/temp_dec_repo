package io.adn.sdk.internal.ui.common.lifecycle;

import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifecycleCountdown.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR+\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/adn/sdk/internal/ui/common/lifecycle/LifecycleCountdownState;", "", "initialTimeLeft", "", "timeInterval", "<init>", "(JJ)V", "getTimeInterval", "()J", "<set-?>", "timeLeft", "getTimeLeft", "setTimeLeft", "(J)V", "timeLeft$delegate", "Landroidx/compose/runtime/MutableLongState;", "decrementTimeLeft", "", "isCountdownFinished", "", "()Z", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LifecycleCountdownState {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<LifecycleCountdownState, Object> saver = ListSaverKt.listSaver(new Function2() { // from class: io.adn.sdk.internal.ui.common.lifecycle.LifecycleCountdownState$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            List saver$lambda$1;
            saver$lambda$1 = LifecycleCountdownState.saver$lambda$1((SaverScope) obj, (LifecycleCountdownState) obj2);
            return saver$lambda$1;
        }
    }, new Function1() { // from class: io.adn.sdk.internal.ui.common.lifecycle.LifecycleCountdownState$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            LifecycleCountdownState saver$lambda$2;
            saver$lambda$2 = LifecycleCountdownState.saver$lambda$2((List) obj);
            return saver$lambda$2;
        }
    });
    private final long timeInterval;

    /* renamed from: timeLeft$delegate, reason: from kotlin metadata */
    private final MutableLongState timeLeft;

    public LifecycleCountdownState(long j, long j2) {
        this.timeInterval = j2;
        if (j < 0 || j2 <= 0) {
            throw new IllegalArgumentException("Time left and interval must be non-negative and interval must be greater than zero.".toString());
        }
        this.timeLeft = SnapshotLongStateKt.mutableLongStateOf(j);
    }

    public final long getTimeInterval() {
        return this.timeInterval;
    }

    private final void setTimeLeft(long j) {
        this.timeLeft.setLongValue(j);
    }

    public final long getTimeLeft() {
        return this.timeLeft.getLongValue();
    }

    public final void decrementTimeLeft() {
        if (getTimeLeft() > 0) {
            setTimeLeft(getTimeLeft() - this.timeInterval);
        }
    }

    public final boolean isCountdownFinished() {
        return getTimeLeft() <= 0;
    }

    /* compiled from: LifecycleCountdown.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/adn/sdk/internal/ui/common/lifecycle/LifecycleCountdownState$Companion;", "", "<init>", "()V", "saver", "Landroidx/compose/runtime/saveable/Saver;", "Lio/adn/sdk/internal/ui/common/lifecycle/LifecycleCountdownState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LifecycleCountdownState, Object> getSaver() {
            return LifecycleCountdownState.saver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List saver$lambda$1(SaverScope listSaver, LifecycleCountdownState it) {
        Intrinsics.checkNotNullParameter(listSaver, "$this$listSaver");
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.listOf((Object[]) new Long[]{Long.valueOf(it.getTimeLeft()), Long.valueOf(it.timeInterval)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleCountdownState saver$lambda$2(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new LifecycleCountdownState(((Number) it.get(0)).longValue(), ((Number) it.get(1)).longValue());
    }
}
