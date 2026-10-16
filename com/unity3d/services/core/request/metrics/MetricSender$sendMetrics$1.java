package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: MetricSender.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.request.metrics.MetricSender$sendMetrics$1", f = "MetricSender.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class MetricSender$sendMetrics$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Metric> $metrics;
    int label;
    final /* synthetic */ MetricSender this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MetricSender$sendMetrics$1(MetricSender metricSender, List<Metric> list, Continuation<? super MetricSender$sendMetrics$1> continuation) {
        super(2, continuation);
        this.this$0 = metricSender;
        this.$metrics = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MetricSender$sendMetrics$1(this.this$0, this.$metrics, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MetricSender$sendMetrics$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        MetricCommonTags metricCommonTags;
        String str2;
        HttpClient httpClient;
        Object execute;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            str = this.this$0.metricSampleRate;
            metricCommonTags = this.this$0.commonTags;
            List<Metric> list = this.$metrics;
            str2 = this.this$0.sessionToken;
            String jSONObject = new JSONObject(new MetricsContainer(str, metricCommonTags, list, str2).toMap()).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(container.toMap()).toString()");
            String metricEndPoint = this.this$0.getMetricEndPoint();
            if (metricEndPoint == null) {
                metricEndPoint = "";
            }
            HttpRequest httpRequest = new HttpRequest(metricEndPoint, null, RequestType.POST, jSONObject, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131058, null);
            httpClient = this.this$0.httpClient;
            this.label = 1;
            execute = httpClient.execute(httpRequest, this);
            if (execute == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            execute = obj;
        }
        HttpResponse httpResponse = (HttpResponse) execute;
        if (httpResponse.getStatusCode() / 100 == 2) {
            DeviceLog.debug("Metric " + this.$metrics + " sent to " + this.this$0.getMetricEndPoint());
        } else {
            DeviceLog.debug("Metric " + this.$metrics + " failed to send with response code: " + httpResponse.getStatusCode());
        }
        return Unit.INSTANCE;
    }
}
