package io.ktor.client.call;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: SavedCall.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0003"}, d2 = {"save", "Lio/ktor/client/call/HttpClientCall;", "(Lio/ktor/client/call/HttpClientCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SavedCallKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object save(HttpClientCall httpClientCall, Continuation<? super HttpClientCall> continuation) {
        SavedCallKt$save$1 savedCallKt$save$1;
        int i;
        if (continuation instanceof SavedCallKt$save$1) {
            savedCallKt$save$1 = (SavedCallKt$save$1) continuation;
            if ((savedCallKt$save$1.label & Integer.MIN_VALUE) != 0) {
                savedCallKt$save$1.label -= Integer.MIN_VALUE;
                SavedCallKt$save$1 savedCallKt$save$12 = savedCallKt$save$1;
                Object obj = savedCallKt$save$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = savedCallKt$save$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ByteReadChannel content = httpClientCall.getResponse().getContent();
                    savedCallKt$save$12.L$0 = httpClientCall;
                    savedCallKt$save$12.label = 1;
                    obj = ByteReadChannel.DefaultImpls.readRemaining$default(content, 0L, savedCallKt$save$12, 1, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    httpClientCall = (HttpClientCall) savedCallKt$save$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return new SavedHttpCall(httpClientCall.getClient(), httpClientCall.getRequest(), httpClientCall.getResponse(), StringsKt.readBytes$default((ByteReadPacket) obj, 0, 1, null));
            }
        }
        savedCallKt$save$1 = new SavedCallKt$save$1(continuation);
        SavedCallKt$save$1 savedCallKt$save$122 = savedCallKt$save$1;
        Object obj2 = savedCallKt$save$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = savedCallKt$save$122.label;
        if (i != 0) {
        }
        return new SavedHttpCall(httpClientCall.getClient(), httpClientCall.getRequest(), httpClientCall.getResponse(), StringsKt.readBytes$default((ByteReadPacket) obj2, 0, 1, null));
    }
}
