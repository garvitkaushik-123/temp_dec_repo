package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.data.api.remote.RemoteDataSource;
import java.util.Map;
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

/* compiled from: AdTrackerSenderImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.AdTrackerSenderImpl$track$1$1", f = "AdTrackerSenderImpl.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AdTrackerSenderImpl$track$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $macros;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AdTrackerSenderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdTrackerSenderImpl$track$1$1(AdTrackerSenderImpl adTrackerSenderImpl, String str, Map<String, String> map, Continuation<? super AdTrackerSenderImpl$track$1$1> continuation) {
        super(2, continuation);
        this.this$0 = adTrackerSenderImpl;
        this.$url = str;
        this.$macros = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AdTrackerSenderImpl$track$1$1 adTrackerSenderImpl$track$1$1 = new AdTrackerSenderImpl$track$1$1(this.this$0, this.$url, this.$macros, continuation);
        adTrackerSenderImpl$track$1$1.L$0 = obj;
        return adTrackerSenderImpl$track$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdTrackerSenderImpl$track$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String substituteCustomMacros;
        String substituteBasicMacroses;
        RemoteDataSource remoteDataSource;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AdTrackerSenderImpl adTrackerSenderImpl = this.this$0;
                String str = this.$url;
                Map<String, String> map = this.$macros;
                Result.Companion companion = Result.INSTANCE;
                substituteCustomMacros = adTrackerSenderImpl.substituteCustomMacros(str, map);
                substituteBasicMacroses = adTrackerSenderImpl.substituteBasicMacroses(substituteCustomMacros);
                remoteDataSource = adTrackerSenderImpl.remote;
                this.label = 1;
                if (remoteDataSource.sendAdTracker(substituteBasicMacroses, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        return Unit.INSTANCE;
    }
}
