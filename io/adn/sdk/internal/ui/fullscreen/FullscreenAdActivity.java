package io.adn.sdk.internal.ui.fullscreen;

import android.app.Activity;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.LifecycleOwnerKt;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEvent;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEventKt;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenAdViewModel;
import io.adn.sdk.internal.ui.utils.ActivityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: FullscreenAdActivity.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \r2\u00020\u0001:\u0001\rB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014R\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\f¨\u0006\u000e"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/FullscreenAdActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "isAdClosed", "", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent;", "(Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEvent;)Z", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdActivity extends ComponentActivity {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static FullscreenAdViewModel adController;

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullscreenAdActivity fullscreenAdActivity = this;
        ActivityKt.hideSystemUI(fullscreenAdActivity);
        FullscreenAdViewModel fullscreenAdViewModel = adController;
        if (fullscreenAdViewModel != null) {
            fullscreenAdViewModel.onActivityCreated(fullscreenAdActivity);
            FlowKt.launchIn(FlowKt.onEach(fullscreenAdViewModel.getAdEvent(), new FullscreenAdActivity$onCreate$1$1(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
            ActivityKt.hideSystemUI(fullscreenAdActivity);
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-906560947, true, new FullscreenAdActivity$onCreate$1$2(fullscreenAdViewModel)), 1, null);
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        FullscreenAdViewModel fullscreenAdViewModel = adController;
        if (fullscreenAdViewModel != null) {
            fullscreenAdViewModel.onActivityDestroyed();
        }
        adController = null;
    }

    /* compiled from: FullscreenAdActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/FullscreenAdActivity$Companion;", "", "<init>", "()V", "adController", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenAdViewModel;", "displayAd", "", "activity", "Landroid/app/Activity;", "controller", "(Landroid/app/Activity;Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenAdViewModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object displayAd(Activity activity, FullscreenAdViewModel fullscreenAdViewModel, Continuation<? super Unit> continuation) {
            FullscreenAdActivity.adController = fullscreenAdViewModel;
            Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new FullscreenAdActivity$Companion$displayAd$2(activity, null), continuation);
            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAdClosed(FullscreenAdEvent fullscreenAdEvent) {
        return (fullscreenAdEvent instanceof FullscreenAdEvent.Dismiss) && FullscreenAdEventKt.isClosedByUser((FullscreenAdEvent.Dismiss) fullscreenAdEvent);
    }
}
