package com.unity3d.ads.core.domain.exposure;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.om.AndroidOmStartSession;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CommonAdViewerExposedFunctions.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "", "invoke", "([Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
final class CommonAdViewerExposedFunctionsKt$omStartSession$1 implements ExposedFunction {
    final /* synthetic */ AdObject $adObject;
    final /* synthetic */ AndroidOmStartSession $omStartSession;

    CommonAdViewerExposedFunctionsKt$omStartSession$1(AndroidOmStartSession androidOmStartSession, AdObject adObject) {
        this.$omStartSession = androidOmStartSession;
        this.$adObject = adObject;
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
        CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1 commonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1;
        int i;
        if (continuation instanceof CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1) {
            commonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1 = (CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1) continuation;
            if ((commonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = commonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Object obj2 = objArr[0];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                    AndroidOmStartSession androidOmStartSession = this.$omStartSession;
                    AdObject adObject = this.$adObject;
                    commonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1.label = 1;
                    if (androidOmStartSession.invoke(adObject, (JSONObject) obj2, commonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1) == coroutine_suspended) {
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
        commonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1 = new CommonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1(this, continuation);
        Object obj3 = commonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonAdViewerExposedFunctionsKt$omStartSession$1$invoke$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }
}
