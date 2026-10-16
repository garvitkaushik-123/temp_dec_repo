package io.adn.sdk.internal.ui.utils;

import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import io.adn.sdk.internal.common.model.Destroyable;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: ViewVisibilityTracker.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u0013J\u0006\u0010\u0014\u001a\u00020\u000fJ\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/adn/sdk/internal/ui/utils/ViewVisibilityTracker;", "Lio/adn/sdk/internal/common/model/Destroyable;", "intervalMs", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(JLkotlinx/coroutines/CoroutineScope;)V", "visibilityJob", "Lkotlinx/coroutines/Job;", "lastVisiblePercent", "", "state", "Lio/adn/sdk/internal/ui/utils/TrackerState;", "start", "", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "onVisiblePercentChanged", "Lkotlin/Function1;", "stop", "destroy", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ViewVisibilityTracker implements Destroyable {
    public static final int $stable = 8;
    private final long intervalMs;
    private float lastVisiblePercent;
    private final CoroutineScope scope;
    private TrackerState state;
    private Job visibilityJob;

    public ViewVisibilityTracker() {
        this(0L, null, 3, null);
    }

    public ViewVisibilityTracker(long j, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.intervalMs = j;
        this.scope = scope;
        this.state = TrackerState.None;
    }

    public /* synthetic */ ViewVisibilityTracker(long j, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 600L : j, (i & 2) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }

    public final void start(View view, Function1<? super Float, Unit> onVisiblePercentChanged) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onVisiblePercentChanged, "onVisiblePercentChanged");
        if (this.state != TrackerState.None) {
            return;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ViewVisibilityTracker$start$1(this, view, onVisiblePercentChanged, null), 3, null);
        this.visibilityJob = launch$default;
    }

    public final void stop() {
        if (this.state != TrackerState.Active) {
            return;
        }
        Job job = this.visibilityJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.visibilityJob = null;
        this.lastVisiblePercent = 0.0f;
        this.state = TrackerState.None;
    }

    @Override // io.adn.sdk.internal.common.model.Destroyable
    public void destroy() {
        Job job = this.visibilityJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        this.state = TrackerState.Destroyed;
    }
}
