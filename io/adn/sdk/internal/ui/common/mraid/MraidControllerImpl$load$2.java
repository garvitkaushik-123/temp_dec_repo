package io.adn.sdk.internal.ui.common.mraid;

import android.app.Activity;
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

/* compiled from: MraidController.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.mraid.MraidControllerImpl$load$2", f = "MraidController.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class MraidControllerImpl$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $content;
    int label;
    final /* synthetic */ MraidControllerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MraidControllerImpl$load$2(MraidControllerImpl mraidControllerImpl, Activity activity, String str, Continuation<? super MraidControllerImpl$load$2> continuation) {
        super(2, continuation);
        this.this$0 = mraidControllerImpl;
        this.$activity = activity;
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MraidControllerImpl$load$2(this.this$0, this.$activity, this.$content, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((MraidControllerImpl$load$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MraidBridge mraidBridge;
        Object mo9556loadgIAlus;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.onLoadStarted();
            this.this$0.createAndAttachAdView(this.$activity);
            mraidBridge = this.this$0.mraidBridge;
            this.label = 1;
            mo9556loadgIAlus = mraidBridge.mo9556loadgIAlus(this.$content, this);
            if (mo9556loadgIAlus == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            mo9556loadgIAlus = ((Result) obj).getValue();
        }
        this.this$0.onLoadComplete(mo9556loadgIAlus);
        return Result.m10240boximpl(mo9556loadgIAlus);
    }
}
