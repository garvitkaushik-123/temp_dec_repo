package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.model.LoadEvent;
import gatewayprotocol.v1.AdResponseOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidHandleGatewayAdResponse.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$4", f = "AndroidHandleGatewayAdResponse.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidHandleGatewayAdResponse$invoke$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<AdPlayer> $adPlayer;
    final /* synthetic */ LoadEvent $loadEvent;
    final /* synthetic */ ByteString $opportunityId;
    final /* synthetic */ AdResponseOuterClass.AdResponse $response;
    int label;
    final /* synthetic */ AndroidHandleGatewayAdResponse this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidHandleGatewayAdResponse$invoke$4(AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse, LoadEvent loadEvent, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, Ref.ObjectRef<AdPlayer> objectRef, Continuation<? super AndroidHandleGatewayAdResponse$invoke$4> continuation) {
        super(2, continuation);
        this.this$0 = androidHandleGatewayAdResponse;
        this.$loadEvent = loadEvent;
        this.$opportunityId = byteString;
        this.$response = adResponse;
        this.$adPlayer = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidHandleGatewayAdResponse$invoke$4(this.this$0, this.$loadEvent, this.$opportunityId, this.$response, this.$adPlayer, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidHandleGatewayAdResponse$invoke$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object cleanup;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            cleanup = this.this$0.cleanup(new Error(((LoadEvent.Error) this.$loadEvent).getMessage()), this.$opportunityId, this.$response, this.$adPlayer.element, this);
            if (cleanup == coroutine_suspended) {
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
