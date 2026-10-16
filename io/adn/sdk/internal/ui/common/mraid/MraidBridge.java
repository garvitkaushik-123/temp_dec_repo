package io.adn.sdk.internal.ui.common.mraid;

import androidx.core.app.NotificationCompat;
import com.ironsource.C3040d4;
import com.ironsource.sdk.controller.f;
import com.mbridge.msdk.MBridgeConstans;
import io.adn.sdk.internal.common.model.Destroyable;
import io.bidmachine.iab.mraid.MraidNativeFeature;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: MraidBridge.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H&J0\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H&J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H&J\b\u0010!\u001a\u00020\u0004H&J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H&J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0011H&¨\u0006'"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidBridge;", "Lio/adn/sdk/internal/common/model/Destroyable;", "load", "Lkotlin/Result;", "", "content", "", "load-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "event", "Lkotlinx/coroutines/flow/SharedFlow;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "sendError", f.b.g, NotificationCompat.CATEGORY_MESSAGE, "sendIsViewable", C3040d4.h.o, "", "sendPlacementType", "placementType", "Lio/adn/sdk/internal/ui/common/mraid/MraidPlacementType;", "sendViewState", "state", "Lio/adn/sdk/internal/ui/common/mraid/MraidViewState;", "sendSupports", "sms", "tel", "calendar", "storePicture", MraidNativeFeature.FEATURE_INLINE_VIDEO, "sendLayoutMetrics", "metrics", "Lio/adn/sdk/internal/ui/common/mraid/MraidLayoutMetrics;", "sendReady", "attachView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lio/adn/sdk/internal/ui/common/mraid/MraidWebView;", "awaitHtmlLoadEvent", "enabled", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface MraidBridge extends Destroyable {
    void attachView(MraidWebView view);

    void awaitHtmlLoadEvent(boolean enabled);

    SharedFlow<MraidWebViewEvent> event();

    /* renamed from: load-gIAlu-s, reason: not valid java name */
    Object mo9556loadgIAlus(String str, Continuation<? super Result<Unit>> continuation);

    void sendError(String command, String msg);

    void sendIsViewable(boolean isViewable);

    void sendLayoutMetrics(MraidLayoutMetrics metrics);

    void sendPlacementType(MraidPlacementType placementType);

    void sendReady();

    void sendSupports(boolean sms, boolean tel, boolean calendar, boolean storePicture, boolean inlineVideo);

    void sendViewState(MraidViewState state);
}
