package io.adn.sdk.internal.domain.handler;

import io.adn.sdk.internal.common.logger.AdLogEvent;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.domain.management.SdkInitializer;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.AdnBidTokenCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BidTokenHandler.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u000e\u001a\u00020\u000fH\u0086\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lio/adn/sdk/internal/domain/handler/BidTokenHandler;", "", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "callback", "Lio/adn/sdk/publisher/AdnBidTokenCallback;", "sdkInitializer", "Lio/adn/sdk/internal/domain/management/SdkInitializer;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lio/adn/sdk/publisher/AdnAdPlacement;Lio/adn/sdk/publisher/AdnBidTokenCallback;Lio/adn/sdk/internal/domain/management/SdkInitializer;Lkotlinx/coroutines/CoroutineScope;)V", "startTime", "", "invoke", "", "logBidToken", "bidToken", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class BidTokenHandler {
    public static final int $stable = 8;
    private final AdnBidTokenCallback callback;
    private final AdnAdPlacement placement;
    private final CoroutineScope scope;
    private final SdkInitializer sdkInitializer;
    private final long startTime;

    public BidTokenHandler(AdnAdPlacement placement, AdnBidTokenCallback callback, SdkInitializer sdkInitializer, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(sdkInitializer, "sdkInitializer");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.placement = placement;
        this.callback = callback;
        this.sdkInitializer = sdkInitializer;
        this.scope = scope;
        this.startTime = System.currentTimeMillis();
    }

    public /* synthetic */ BidTokenHandler(AdnAdPlacement adnAdPlacement, AdnBidTokenCallback adnBidTokenCallback, SdkInitializer sdkInitializer, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adnAdPlacement, adnBidTokenCallback, sdkInitializer, (i & 8) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()) : coroutineScope);
    }

    public final void invoke() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new BidTokenHandler$invoke$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logBidToken(String bidToken) {
        try {
            Result.Companion companion = Result.INSTANCE;
            BidTokenHandler bidTokenHandler = this;
            Logger.INSTANCE.log(new AdLogEvent.Token(this.startTime, System.currentTimeMillis() - this.startTime, bidToken, null, 8, null));
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }
}
