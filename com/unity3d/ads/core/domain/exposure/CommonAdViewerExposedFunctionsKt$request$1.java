package com.unity3d.ads.core.domain.exposure;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.adplayer.model.OnWebRequestComplete;
import com.unity3d.ads.adplayer.model.OnWebRequestFailed;
import com.unity3d.ads.core.domain.ExecuteAdViewerRequest;
import com.unity3d.services.core.network.mapper.HttpResponseHeaderToJSONArrayKt;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: CommonAdViewerExposedFunctions.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "args", "", "invoke", "([Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
final class CommonAdViewerExposedFunctionsKt$request$1 implements ExposedFunction {
    final /* synthetic */ ExecuteAdViewerRequest $executeAdViewerRequest;
    final /* synthetic */ RequestType $type;

    CommonAdViewerExposedFunctionsKt$request$1(ExecuteAdViewerRequest executeAdViewerRequest, RequestType requestType) {
        this.$executeAdViewerRequest = executeAdViewerRequest;
        this.$type = requestType;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(objArr, (Continuation<Object>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006f A[Catch: Exception -> 0x0032, TryCatch #1 {Exception -> 0x0032, blocks: (B:11:0x002e, B:12:0x0065, B:14:0x006f, B:15:0x0082, B:19:0x0072, B:21:0x0076), top: B:10:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072 A[Catch: Exception -> 0x0032, TryCatch #1 {Exception -> 0x0032, blocks: (B:11:0x002e, B:12:0x0065, B:14:0x006f, B:15:0x0082, B:19:0x0072, B:21:0x0076), top: B:10:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
        CommonAdViewerExposedFunctionsKt$request$1$invoke$1 commonAdViewerExposedFunctionsKt$request$1$invoke$1;
        int i;
        String str;
        Exception e;
        String str2;
        String message;
        Object body;
        String str3;
        if (continuation instanceof CommonAdViewerExposedFunctionsKt$request$1$invoke$1) {
            commonAdViewerExposedFunctionsKt$request$1$invoke$1 = (CommonAdViewerExposedFunctionsKt$request$1$invoke$1) continuation;
            if ((commonAdViewerExposedFunctionsKt$request$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonAdViewerExposedFunctionsKt$request$1$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = commonAdViewerExposedFunctionsKt$request$1$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonAdViewerExposedFunctionsKt$request$1$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Object first = ArraysKt.first(objArr);
                    Intrinsics.checkNotNull(first, "null cannot be cast to non-null type kotlin.String");
                    String str4 = (String) first;
                    String str5 = (String) ArraysKt.getOrNull(objArr, 1);
                    try {
                        ExecuteAdViewerRequest executeAdViewerRequest = this.$executeAdViewerRequest;
                        RequestType requestType = this.$type;
                        commonAdViewerExposedFunctionsKt$request$1$invoke$1.L$0 = str4;
                        commonAdViewerExposedFunctionsKt$request$1$invoke$1.L$1 = str5;
                        commonAdViewerExposedFunctionsKt$request$1$invoke$1.label = 1;
                        Object invoke = executeAdViewerRequest.invoke(requestType, objArr, commonAdViewerExposedFunctionsKt$request$1$invoke$1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str = str4;
                        obj = invoke;
                        str2 = str5;
                    } catch (Exception e2) {
                        str = str4;
                        e = e2;
                        str2 = str5;
                        String[] strArr = new String[3];
                        strArr[0] = str;
                        strArr[1] = str2;
                        message = e.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        strArr[2] = message;
                        return new OnWebRequestFailed(CollectionsKt.listOf((Object[]) strArr));
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str2 = (String) commonAdViewerExposedFunctionsKt$request$1$invoke$1.L$1;
                    str = (String) commonAdViewerExposedFunctionsKt$request$1$invoke$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e3) {
                        e = e3;
                        String[] strArr2 = new String[3];
                        strArr2[0] = str;
                        strArr2[1] = str2;
                        message = e.getMessage();
                        if (message == null) {
                        }
                        strArr2[2] = message;
                        return new OnWebRequestFailed(CollectionsKt.listOf((Object[]) strArr2));
                    }
                }
                HttpResponse httpResponse = (HttpResponse) obj;
                body = httpResponse.getBody();
                if (body instanceof String) {
                    str3 = body instanceof byte[] ? new String((byte[]) body, Charsets.UTF_8) : null;
                } else {
                    str3 = (String) body;
                }
                return new OnWebRequestComplete(CollectionsKt.listOf(str, httpResponse.getUrlString(), str3, Boxing.boxInt(httpResponse.getStatusCode()), HttpResponseHeaderToJSONArrayKt.toResponseHeadersMap(httpResponse.getHeaders())));
            }
        }
        commonAdViewerExposedFunctionsKt$request$1$invoke$1 = new CommonAdViewerExposedFunctionsKt$request$1$invoke$1(this, continuation);
        Object obj2 = commonAdViewerExposedFunctionsKt$request$1$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonAdViewerExposedFunctionsKt$request$1$invoke$1.label;
        if (i != 0) {
        }
        HttpResponse httpResponse2 = (HttpResponse) obj2;
        body = httpResponse2.getBody();
        if (body instanceof String) {
        }
        return new OnWebRequestComplete(CollectionsKt.listOf(str, httpResponse2.getUrlString(), str3, Boxing.boxInt(httpResponse2.getStatusCode()), HttpResponseHeaderToJSONArrayKt.toResponseHeadersMap(httpResponse2.getHeaders())));
    }
}
