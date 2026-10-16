package io.ktor.client.plugins.observer;

import adn.analytics.Analytics;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.ironsource.C3337ue;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.ByteChannelsKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ResponseObserver.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", C3337ue.n}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1", f = "ResponseObserver.kt", i = {0, 0, 0}, l = {68, Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER}, m = "invokeSuspend", n = {"$this$intercept", "newResponse", "sideResponse"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes8.dex */
final class ResponseObserver$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResponseObserver $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ResponseObserver$Plugin$install$1(ResponseObserver responseObserver, HttpClient httpClient, Continuation<? super ResponseObserver$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = responseObserver;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        ResponseObserver$Plugin$install$1 responseObserver$Plugin$install$1 = new ResponseObserver$Plugin$install$1(this.$plugin, this.$scope, continuation);
        responseObserver$Plugin$install$1.L$0 = pipelineContext;
        responseObserver$Plugin$install$1.L$1 = httpResponse;
        return responseObserver$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00cd, code lost:
    
        if (r10.proceedWith(r9, r12) == r0) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [kotlinx.coroutines.CoroutineScope] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PipelineContext pipelineContext;
        Function1 function1;
        HttpResponse httpResponse;
        HttpResponse httpResponse2;
        HttpClient httpClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            pipelineContext = (PipelineContext) this.L$0;
            HttpResponse httpResponse3 = (HttpResponse) this.L$1;
            function1 = this.$plugin.filter;
            if (function1 != null && !((Boolean) function1.invoke(httpResponse3.getCall())).booleanValue()) {
                return Unit.INSTANCE;
            }
            Pair<ByteReadChannel, ByteReadChannel> split = ByteChannelsKt.split(httpResponse3.getContent(), httpResponse3);
            ByteReadChannel component1 = split.component1();
            HttpResponse response = DelegatedCallKt.wrapWithContent(httpResponse3.getCall(), split.component2()).getResponse();
            HttpResponse response2 = DelegatedCallKt.wrapWithContent(httpResponse3.getCall(), component1).getResponse();
            HttpClient httpClient2 = this.$scope;
            this.L$0 = pipelineContext;
            this.L$1 = response;
            this.L$2 = response2;
            this.L$3 = httpClient2;
            this.label = 1;
            Object responseObserverContext = ResponseObserverContextJvmKt.getResponseObserverContext(this);
            if (responseObserverContext != coroutine_suspended) {
                httpResponse = response;
                httpResponse2 = response2;
                obj = responseObserverContext;
                httpClient = httpClient2;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ?? r1 = (CoroutineScope) this.L$3;
        HttpResponse httpResponse4 = (HttpResponse) this.L$2;
        HttpResponse httpResponse5 = (HttpResponse) this.L$1;
        pipelineContext = (PipelineContext) this.L$0;
        ResultKt.throwOnFailure(obj);
        httpClient = r1;
        httpResponse2 = httpResponse4;
        httpResponse = httpResponse5;
        PipelineContext pipelineContext2 = pipelineContext;
        BuildersKt__Builders_commonKt.launch$default(httpClient, (CoroutineContext) obj, null, new AnonymousClass1(httpResponse2, this.$plugin, null), 2, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
    }

    /* compiled from: ResponseObserver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1", f = "ResponseObserver.kt", i = {0}, l = {69, TokenParametersOuterClass$TokenParameters.APPSETID_FIELD_NUMBER}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResponseObserver $plugin;
        final /* synthetic */ HttpResponse $sideResponse;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HttpResponse httpResponse, ResponseObserver responseObserver, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sideResponse = httpResponse;
            this.$plugin = responseObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$sideResponse, this.$plugin, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
        
            if (r7 == r0) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Function2 function2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                } catch (Throwable th) {
                    Result.Companion companion = Result.INSTANCE;
                    Result.m10241constructorimpl(ResultKt.createFailure(th));
                }
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m10241constructorimpl(ResultKt.createFailure(th2));
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ResponseObserver responseObserver = this.$plugin;
                HttpResponse httpResponse = this.$sideResponse;
                Result.Companion companion3 = Result.INSTANCE;
                function2 = responseObserver.responseHandler;
                this.L$0 = coroutineScope;
                this.label = 1;
                if (function2.invoke(httpResponse, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    Result.m10241constructorimpl(Boxing.boxLong(((Number) obj).longValue()));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.m10241constructorimpl(Unit.INSTANCE);
            ByteReadChannel content = this.$sideResponse.getContent();
            if (!content.isClosedForRead()) {
                Result.Companion companion4 = Result.INSTANCE;
                this.L$0 = null;
                this.label = 2;
                obj = ByteReadChannelKt.discard(content, this);
            }
            return Unit.INSTANCE;
        }
    }
}
