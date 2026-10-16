package io.adn.sdk.internal.domain.usecase;

import io.adn.sdk.internal.domain.model.ad.AttributionSource;
import io.adn.sdk.internal.domain.repository.InstallReferrerRepository;
import io.adn.sdk.internal.domain.repository.InstallReferrerStorage;
import io.adn.sdk.internal.domain.repository.RemoteDataRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TrackAttributionUseCase.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.TrackAttributionUseCase$invoke$1", f = "TrackAttributionUseCase.kt", i = {}, l = {23, 25}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class TrackAttributionUseCase$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TrackAttributionUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrackAttributionUseCase$invoke$1(TrackAttributionUseCase trackAttributionUseCase, Continuation<? super TrackAttributionUseCase$invoke$1> continuation) {
        super(2, continuation);
        this.this$0 = trackAttributionUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TrackAttributionUseCase$invoke$1 trackAttributionUseCase$invoke$1 = new TrackAttributionUseCase$invoke$1(this.this$0, continuation);
        trackAttributionUseCase$invoke$1.L$0 = obj;
        return trackAttributionUseCase$invoke$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrackAttributionUseCase$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0095  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m10241constructorimpl;
        Throwable m10244exceptionOrNullimpl;
        InstallReferrerStorage installReferrerStorage;
        InstallReferrerRepository installReferrerRepository;
        TrackAttributionUseCase trackAttributionUseCase;
        InstallReferrerStorage installReferrerStorage2;
        RemoteDataRepository remoteDataRepository;
        TrackAttributionUseCase trackAttributionUseCase2;
        InstallReferrerStorage installReferrerStorage3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TrackAttributionUseCase trackAttributionUseCase3 = this.this$0;
            Result.Companion companion2 = Result.INSTANCE;
            installReferrerStorage = trackAttributionUseCase3.installReferrerStorage;
            if (installReferrerStorage.isAlreadySent()) {
                return Unit.INSTANCE;
            }
            installReferrerRepository = trackAttributionUseCase3.installReferrerRepository;
            this.L$0 = trackAttributionUseCase3;
            this.label = 1;
            Object installReferrer = installReferrerRepository.getInstallReferrer(this);
            if (installReferrer == coroutine_suspended) {
                return coroutine_suspended;
            }
            trackAttributionUseCase = trackAttributionUseCase3;
            obj = installReferrer;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                trackAttributionUseCase2 = (TrackAttributionUseCase) this.L$0;
                ResultKt.throwOnFailure(obj);
                installReferrerStorage3 = trackAttributionUseCase2.installReferrerStorage;
                installReferrerStorage3.markAsSent();
                m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                TrackAttributionUseCase trackAttributionUseCase4 = this.this$0;
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl != null) {
                    trackAttributionUseCase4.logError(m10244exceptionOrNullimpl);
                }
                return Unit.INSTANCE;
            }
            trackAttributionUseCase = (TrackAttributionUseCase) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        AttributionSource attributionSource = (AttributionSource) obj;
        if (attributionSource instanceof AttributionSource.Adn) {
            remoteDataRepository = trackAttributionUseCase.remoteDataRepository;
            String callbackUrl = ((AttributionSource.Adn) attributionSource).getCallbackUrl();
            this.L$0 = trackAttributionUseCase;
            this.label = 2;
            if (remoteDataRepository.triggerAdnAttributionCallback(callbackUrl, this) != coroutine_suspended) {
                trackAttributionUseCase2 = trackAttributionUseCase;
                installReferrerStorage3 = trackAttributionUseCase2.installReferrerStorage;
                installReferrerStorage3.markAsSent();
                m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                TrackAttributionUseCase trackAttributionUseCase42 = this.this$0;
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl != null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        installReferrerStorage2 = trackAttributionUseCase.installReferrerStorage;
        installReferrerStorage2.markAsSent();
        m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        TrackAttributionUseCase trackAttributionUseCase422 = this.this$0;
        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
        }
        return Unit.INSTANCE;
    }
}
