package io.adn.sdk.internal.ui.common.mraid;

import android.app.Activity;
import android.view.View;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import io.adn.sdk.internal.common.model.Destroyable;
import io.adn.sdk.internal.domain.model.ad.RedirectionStrategy;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: MraidController.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H¦@¢\u0006\u0004\b\u000e\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0014H&J\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001a\u001a\u00020\tH&J\b\u0010\u001b\u001a\u00020\tH&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0014H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006#"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidController;", "Lio/adn/sdk/internal/common/model/Destroyable;", "event", "Lkotlinx/coroutines/flow/Flow;", "Lio/adn/sdk/internal/ui/common/mraid/MraidControllerEvent;", "getEvent", "()Lkotlinx/coroutines/flow/Flow;", "load", "Lkotlin/Result;", "", "activity", "Landroid/app/Activity;", "content", "", "load-0E7RQCE", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", C3040d4.h.b, "Ljava/io/File;", "(Landroid/app/Activity;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isLoaded", "", "awaitHtmlLoadEvent", "enabled", "setRedirectionStrategy", "strategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "prepareForDisplay", C3207n2.v, "getView", "Landroid/view/View;", "updateLayoutMetrics", "metrics", "Lio/adn/sdk/internal/ui/common/mraid/MraidLayoutMetrics;", "updateForegroundState", "isForeground", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface MraidController extends Destroyable {
    void awaitHtmlLoadEvent(boolean enabled);

    Flow<MraidControllerEvent> getEvent();

    View getView();

    boolean isLoaded();

    /* renamed from: load-0E7RQCE, reason: not valid java name */
    Object mo9557load0E7RQCE(Activity activity, File file, Continuation<? super Result<Unit>> continuation);

    /* renamed from: load-0E7RQCE, reason: not valid java name */
    Object mo9558load0E7RQCE(Activity activity, String str, Continuation<? super Result<Unit>> continuation);

    void prepareForDisplay();

    void setRedirectionStrategy(RedirectionStrategy strategy);

    void show();

    void updateForegroundState(boolean isForeground);

    void updateLayoutMetrics(MraidLayoutMetrics metrics);
}
