package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.AdPlayer;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: AndroidHandleGatewayAdResponse.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lgatewayprotocol/v1/AllowedPiiOuterClass$AllowedPii;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$2", f = "AndroidHandleGatewayAdResponse.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidHandleGatewayAdResponse$invoke$2 extends SuspendLambda implements Function2<AllowedPiiOuterClass.AllowedPii, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<AdPlayer> $adPlayer;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidHandleGatewayAdResponse$invoke$2(Ref.ObjectRef<AdPlayer> objectRef, Continuation<? super AndroidHandleGatewayAdResponse$invoke$2> continuation) {
        super(2, continuation);
        this.$adPlayer = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidHandleGatewayAdResponse$invoke$2 androidHandleGatewayAdResponse$invoke$2 = new AndroidHandleGatewayAdResponse$invoke$2(this.$adPlayer, continuation);
        androidHandleGatewayAdResponse$invoke$2.L$0 = obj;
        return androidHandleGatewayAdResponse$invoke$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AllowedPiiOuterClass.AllowedPii allowedPii, Continuation<? super Unit> continuation) {
        return ((AndroidHandleGatewayAdResponse$invoke$2) create(allowedPii, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AllowedPiiOuterClass.AllowedPii allowedPii = (AllowedPiiOuterClass.AllowedPii) this.L$0;
            AdPlayer adPlayer = this.$adPlayer.element;
            byte[] byteArray = allowedPii.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "it.toByteArray()");
            this.label = 1;
            if (adPlayer.onAllowedPiiChange(byteArray, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
