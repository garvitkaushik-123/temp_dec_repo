package com.unity3d.ads.core.domain.exposure;

import android.util.Base64;
import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonAdViewerExposedFunctions.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "", "invoke", "([Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
final class CommonAdViewerExposedFunctionsKt$setPrivacy$1 implements ExposedFunction {
    final /* synthetic */ SessionRepository $sessionRepository;

    CommonAdViewerExposedFunctionsKt$setPrivacy$1(SessionRepository sessionRepository) {
        this.$sessionRepository = sessionRepository;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(objArr, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke2(Object[] objArr, Continuation<? super Unit> continuation) {
        CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1 commonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1;
        int i;
        if (continuation instanceof CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1) {
            commonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1 = (CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1) continuation;
            if ((commonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = commonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    SessionRepository sessionRepository = this.$sessionRepository;
                    Object obj2 = objArr[0];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                    byte[] decode = Base64.decode((String) obj2, 2);
                    Intrinsics.checkNotNullExpressionValue(decode, "decode(it[0] as String, Base64.NO_WRAP)");
                    ByteString byteString = ByteStringsKt.toByteString(decode);
                    commonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1.label = 1;
                    if (sessionRepository.setPrivacy(byteString, commonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1) == coroutine_suspended) {
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
        commonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1 = new CommonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1(this, continuation);
        Object obj3 = commonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonAdViewerExposedFunctionsKt$setPrivacy$1$invoke$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }
}
