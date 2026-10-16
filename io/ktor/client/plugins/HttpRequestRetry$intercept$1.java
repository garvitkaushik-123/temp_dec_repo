package io.ktor.client.plugins;

import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.slf4j.Logger;

/* compiled from: HttpRequestRetry.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/Sender;", AdActivity.REQUEST_KEY_EXTRA, "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetry$intercept$1", f = "HttpRequestRetry.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {298, Sdk.SDKError.Reason.LINK_COMMAND_OPEN_FAILED_VALUE}, m = "invokeSuspend", n = {"$this$intercept", AdActivity.REQUEST_KEY_EXTRA, "shouldRetry", "shouldRetryOnException", "delayMillis", "modifyRequest", "subRequest", "retryCount", "maxRetries", "$this$intercept", AdActivity.REQUEST_KEY_EXTRA, "shouldRetry", "shouldRetryOnException", "delayMillis", "modifyRequest", "lastRetryData", "retryCount", "maxRetries"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"})
/* loaded from: classes8.dex */
final class HttpRequestRetry$intercept$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ HttpClient $client;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ HttpRequestRetry this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpRequestRetry$intercept$1(HttpRequestRetry httpRequestRetry, HttpClient httpClient, Continuation<? super HttpRequestRetry$intercept$1> continuation) {
        super(3, continuation);
        this.this$0 = httpRequestRetry;
        this.$client = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpRequestRetry$intercept$1 httpRequestRetry$intercept$1 = new HttpRequestRetry$intercept$1(this.this$0, this.$client, continuation);
        httpRequestRetry$intercept$1.L$0 = sender;
        httpRequestRetry$intercept$1.L$1 = httpRequestBuilder;
        return httpRequestRetry$intercept$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0113 A[Catch: all -> 0x0076, TRY_ENTER, TryCatch #0 {all -> 0x0076, blocks: (B:10:0x0113, B:11:0x0127, B:16:0x0146, B:19:0x0151, B:35:0x006f), top: B:34:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0150 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0151 A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #0 {all -> 0x0076, blocks: (B:10:0x0113, B:11:0x0127, B:16:0x0146, B:19:0x0151, B:35:0x006f), top: B:34:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01cf  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x01cf -> B:6:0x0038). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AttributeKey attributeKey;
        AttributeKey attributeKey2;
        AttributeKey attributeKey3;
        AttributeKey attributeKey4;
        Function2 function2;
        AttributeKey attributeKey5;
        Function3 function3;
        int i;
        Sender sender;
        HttpRequestBuilder httpRequestBuilder;
        int i2;
        Function2 function22;
        HttpRequestRetry.RetryEventData retryEventData;
        Function3 function32;
        HttpRequestBuilder httpRequestBuilder2;
        boolean shouldRetryOnException;
        Function2 function23;
        Function2 function24;
        Function3 function33;
        Function3 function34;
        HttpRequestBuilder httpRequestBuilder3;
        Sender sender2;
        Function2 function25;
        Object invoke;
        char c;
        Object obj2;
        boolean shouldRetry;
        Logger logger;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        int i4 = 1;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Sender sender3 = (Sender) this.L$0;
            HttpRequestBuilder httpRequestBuilder4 = (HttpRequestBuilder) this.L$1;
            Attributes attributes = httpRequestBuilder4.getAttributes();
            attributeKey = HttpRequestRetryKt.ShouldRetryPerRequestAttributeKey;
            Function3 function35 = (Function3) attributes.getOrNull(attributeKey);
            if (function35 == null) {
                function35 = this.this$0.shouldRetry;
            }
            Attributes attributes2 = httpRequestBuilder4.getAttributes();
            attributeKey2 = HttpRequestRetryKt.ShouldRetryOnExceptionPerRequestAttributeKey;
            Function3 function36 = (Function3) attributes2.getOrNull(attributeKey2);
            if (function36 == null) {
                function36 = this.this$0.shouldRetryOnException;
            }
            Attributes attributes3 = httpRequestBuilder4.getAttributes();
            attributeKey3 = HttpRequestRetryKt.MaxRetriesPerRequestAttributeKey;
            Integer num = (Integer) attributes3.getOrNull(attributeKey3);
            int intValue = num != null ? num.intValue() : this.this$0.maxRetries;
            Attributes attributes4 = httpRequestBuilder4.getAttributes();
            attributeKey4 = HttpRequestRetryKt.RetryDelayPerRequestAttributeKey;
            function2 = (Function2) attributes4.getOrNull(attributeKey4);
            if (function2 == null) {
                function2 = this.this$0.delayMillis;
            }
            Attributes attributes5 = httpRequestBuilder4.getAttributes();
            attributeKey5 = HttpRequestRetryKt.ModifyRequestPerRequestAttributeKey;
            Function2 function26 = (Function2) attributes5.getOrNull(attributeKey5);
            if (function26 == null) {
                function26 = this.this$0.modifyRequest;
            }
            function3 = function35;
            i = 0;
            sender = sender3;
            httpRequestBuilder = httpRequestBuilder4;
            i2 = intValue;
            function22 = function26;
            retryEventData = null;
            function32 = function36;
            httpRequestBuilder2 = this.this$0.prepareRequest(httpRequestBuilder);
            if (retryEventData != null) {
            }
            this.L$0 = sender;
            this.L$1 = httpRequestBuilder;
            this.L$2 = function3;
            this.L$3 = function32;
            this.L$4 = function2;
            this.L$5 = function22;
            this.L$6 = httpRequestBuilder2;
            this.I$0 = i;
            this.I$1 = i2;
            this.label = i4;
            obj2 = sender.execute(httpRequestBuilder2, this);
            if (obj2 == coroutine_suspended) {
            }
            HttpClientCall httpClientCall = (HttpClientCall) obj2;
            shouldRetry = this.this$0.shouldRetry(i, i2, function3, httpClientCall);
            if (shouldRetry) {
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i5 = this.I$1;
                int i6 = this.I$0;
                HttpRequestRetry.RetryEventData retryEventData2 = (HttpRequestRetry.RetryEventData) this.L$6;
                function23 = (Function2) this.L$5;
                function24 = (Function2) this.L$4;
                function33 = (Function3) this.L$3;
                function34 = (Function3) this.L$2;
                httpRequestBuilder3 = (HttpRequestBuilder) this.L$1;
                sender2 = (Sender) this.L$0;
                ResultKt.throwOnFailure(obj);
                c = 2;
                int i7 = i5;
                retryEventData = retryEventData2;
                i = i6;
                Sender sender4 = sender2;
                httpRequestBuilder = httpRequestBuilder3;
                function3 = function34;
                function32 = function33;
                function2 = function24;
                function22 = function23;
                logger = HttpRequestRetryKt.LOGGER;
                logger.trace("Retrying request " + httpRequestBuilder.getUrl() + " attempt: " + i);
                i2 = i7;
                i4 = 1;
                sender = sender4;
                httpRequestBuilder2 = this.this$0.prepareRequest(httpRequestBuilder);
                if (retryEventData != null) {
                    function22.invoke(new HttpRequestRetry.ModifyRequestContext(httpRequestBuilder, retryEventData.getResponse(), retryEventData.getCause(), retryEventData.getRetryCount()), httpRequestBuilder2);
                }
                this.L$0 = sender;
                this.L$1 = httpRequestBuilder;
                this.L$2 = function3;
                this.L$3 = function32;
                this.L$4 = function2;
                this.L$5 = function22;
                this.L$6 = httpRequestBuilder2;
                this.I$0 = i;
                this.I$1 = i2;
                this.label = i4;
                obj2 = sender.execute(httpRequestBuilder2, this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                HttpClientCall httpClientCall2 = (HttpClientCall) obj2;
                shouldRetry = this.this$0.shouldRetry(i, i2, function3, httpClientCall2);
                if (shouldRetry) {
                    return httpClientCall2;
                }
                int i8 = i + 1;
                HttpRequestRetry.RetryEventData retryEventData3 = new HttpRequestRetry.RetryEventData(httpRequestBuilder2, i8, httpClientCall2.getResponse(), null);
                int i9 = i2;
                int i10 = i8;
                function23 = function22;
                function24 = function2;
                function33 = function32;
                HttpRequestRetry.RetryEventData retryEventData4 = retryEventData3;
                function34 = function3;
                httpRequestBuilder3 = httpRequestBuilder;
                sender2 = sender;
                this.$client.getMonitor().raise(HttpRequestRetry.INSTANCE.getHttpRequestRetryEvent(), retryEventData4);
                HttpRequestRetry.DelayContext delayContext = new HttpRequestRetry.DelayContext(retryEventData4.getRequest(), retryEventData4.getResponse(), retryEventData4.getCause());
                function25 = this.this$0.delay;
                invoke = function24.invoke(delayContext, Boxing.boxInt(i10));
                this.L$0 = sender2;
                this.L$1 = httpRequestBuilder3;
                this.L$2 = function34;
                this.L$3 = function33;
                this.L$4 = function24;
                this.L$5 = function23;
                this.L$6 = retryEventData4;
                this.I$0 = i10;
                this.I$1 = i9;
                c = 2;
                this.label = 2;
                if (function25.invoke(invoke, this) != coroutine_suspended) {
                    i7 = i9;
                    retryEventData = retryEventData4;
                    i = i10;
                    Sender sender42 = sender2;
                    httpRequestBuilder = httpRequestBuilder3;
                    function3 = function34;
                    function32 = function33;
                    function2 = function24;
                    function22 = function23;
                    logger = HttpRequestRetryKt.LOGGER;
                    logger.trace("Retrying request " + httpRequestBuilder.getUrl() + " attempt: " + i);
                    i2 = i7;
                    i4 = 1;
                    sender = sender42;
                    httpRequestBuilder2 = this.this$0.prepareRequest(httpRequestBuilder);
                    if (retryEventData != null) {
                    }
                    this.L$0 = sender;
                    this.L$1 = httpRequestBuilder;
                    this.L$2 = function3;
                    this.L$3 = function32;
                    this.L$4 = function2;
                    this.L$5 = function22;
                    this.L$6 = httpRequestBuilder2;
                    this.I$0 = i;
                    this.I$1 = i2;
                    this.label = i4;
                    obj2 = sender.execute(httpRequestBuilder2, this);
                    if (obj2 == coroutine_suspended) {
                    }
                    HttpClientCall httpClientCall22 = (HttpClientCall) obj2;
                    shouldRetry = this.this$0.shouldRetry(i, i2, function3, httpClientCall22);
                    if (shouldRetry) {
                    }
                }
                return coroutine_suspended;
            }
            i2 = this.I$1;
            i = this.I$0;
            httpRequestBuilder2 = (HttpRequestBuilder) this.L$6;
            function22 = (Function2) this.L$5;
            function2 = (Function2) this.L$4;
            function32 = (Function3) this.L$3;
            function3 = (Function3) this.L$2;
            httpRequestBuilder = (HttpRequestBuilder) this.L$1;
            sender = (Sender) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
            } finally {
                if (shouldRetryOnException) {
                    function34 = function3;
                    httpRequestBuilder3 = httpRequestBuilder;
                    sender2 = sender;
                    this.$client.getMonitor().raise(HttpRequestRetry.INSTANCE.getHttpRequestRetryEvent(), retryEventData4);
                    HttpRequestRetry.DelayContext delayContext2 = new HttpRequestRetry.DelayContext(retryEventData4.getRequest(), retryEventData4.getResponse(), retryEventData4.getCause());
                    function25 = this.this$0.delay;
                    invoke = function24.invoke(delayContext2, Boxing.boxInt(i10));
                    this.L$0 = sender2;
                    this.L$1 = httpRequestBuilder3;
                    this.L$2 = function34;
                    this.L$3 = function33;
                    this.L$4 = function24;
                    this.L$5 = function23;
                    this.L$6 = retryEventData4;
                    this.I$0 = i10;
                    this.I$1 = i9;
                    c = 2;
                    this.label = 2;
                    if (function25.invoke(invoke, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
            }
            HttpClientCall httpClientCall222 = (HttpClientCall) obj2;
            shouldRetry = this.this$0.shouldRetry(i, i2, function3, httpClientCall222);
            if (shouldRetry) {
            }
        }
    }
}
