package io.ktor.client.plugins;

import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.ironsource.N6;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.util.pipeline.PipelinePhase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* compiled from: HttpCallValidator.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019BY\b\u0000\u00127\u0010\u0002\u001a3\u0012/\u0012-\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0002\u001a3\u0012/\u0012-\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/HttpCallValidator;", "", "responseValidators", "", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/ParameterName;", "name", C3337ue.n, "Lkotlin/coroutines/Continuation;", "", "callExceptionHandlers", "Lio/ktor/client/plugins/HandlerWrapper;", "expectSuccess", "", "(Ljava/util/List;Ljava/util/List;Z)V", "processException", "cause", "", AdActivity.REQUEST_KEY_EXTRA, "Lio/ktor/client/request/HttpRequest;", "(Ljava/lang/Throwable;Lio/ktor/client/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateResponse", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HttpCallValidator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<HttpCallValidator> key = new AttributeKey<>("HttpResponseValidator");
    private final List<HandlerWrapper> callExceptionHandlers;
    private final boolean expectSuccess;
    private final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> responseValidators;

    /* JADX WARN: Multi-variable type inference failed */
    public HttpCallValidator(List<? extends Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object>> responseValidators, List<? extends HandlerWrapper> callExceptionHandlers, boolean z) {
        Intrinsics.checkNotNullParameter(responseValidators, "responseValidators");
        Intrinsics.checkNotNullParameter(callExceptionHandlers, "callExceptionHandlers");
        this.responseValidators = responseValidators;
        this.callExceptionHandlers = callExceptionHandlers;
        this.expectSuccess = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object validateResponse(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        HttpCallValidator$validateResponse$1 httpCallValidator$validateResponse$1;
        int i;
        Logger logger;
        HttpResponse httpResponse2;
        Iterator it;
        if (continuation instanceof HttpCallValidator$validateResponse$1) {
            httpCallValidator$validateResponse$1 = (HttpCallValidator$validateResponse$1) continuation;
            if ((httpCallValidator$validateResponse$1.label & Integer.MIN_VALUE) != 0) {
                httpCallValidator$validateResponse$1.label -= Integer.MIN_VALUE;
                Object obj = httpCallValidator$validateResponse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpCallValidator$validateResponse$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    logger = HttpCallValidatorKt.LOGGER;
                    logger.trace("Validating response for request " + httpResponse.getCall().getRequest().getUrl());
                    httpResponse2 = httpResponse;
                    it = this.responseValidators.iterator();
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) httpCallValidator$validateResponse$1.L$1;
                    HttpResponse httpResponse3 = (HttpResponse) httpCallValidator$validateResponse$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    httpResponse2 = httpResponse3;
                }
                while (it.hasNext()) {
                    Function2 function2 = (Function2) it.next();
                    httpCallValidator$validateResponse$1.L$0 = httpResponse2;
                    httpCallValidator$validateResponse$1.L$1 = it;
                    httpCallValidator$validateResponse$1.label = 1;
                    if (function2.invoke(httpResponse2, httpCallValidator$validateResponse$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        httpCallValidator$validateResponse$1 = new HttpCallValidator$validateResponse$1(this, continuation);
        Object obj2 = httpCallValidator$validateResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpCallValidator$validateResponse$1.label;
        if (i != 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b5, code lost:
    
        if (r2.invoke(r9, r10, r0) == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009c, code lost:
    
        r2 = r9;
        r9 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processException(Throwable th, HttpRequest httpRequest, Continuation<? super Unit> continuation) {
        HttpCallValidator$processException$1 httpCallValidator$processException$1;
        int i;
        Logger logger;
        Throwable th2;
        Iterator it;
        HttpRequest httpRequest2;
        if (continuation instanceof HttpCallValidator$processException$1) {
            httpCallValidator$processException$1 = (HttpCallValidator$processException$1) continuation;
            if ((httpCallValidator$processException$1.label & Integer.MIN_VALUE) != 0) {
                httpCallValidator$processException$1.label -= Integer.MIN_VALUE;
                Object obj = httpCallValidator$processException$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpCallValidator$processException$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    logger = HttpCallValidatorKt.LOGGER;
                    logger.trace("Processing exception " + th + " for request " + httpRequest.getUrl());
                    th2 = th;
                    it = this.callExceptionHandlers.iterator();
                    httpRequest2 = httpRequest;
                    while (it.hasNext()) {
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) httpCallValidator$processException$1.L$2;
                HttpRequest httpRequest3 = (HttpRequest) httpCallValidator$processException$1.L$1;
                Throwable th3 = (Throwable) httpCallValidator$processException$1.L$0;
                ResultKt.throwOnFailure(obj);
                httpRequest2 = httpRequest3;
                th2 = th3;
                while (it.hasNext()) {
                    HandlerWrapper handlerWrapper = (HandlerWrapper) it.next();
                    if (handlerWrapper instanceof ExceptionHandlerWrapper) {
                        Function2<Throwable, Continuation<? super Unit>, Object> handler = ((ExceptionHandlerWrapper) handlerWrapper).getHandler();
                        httpCallValidator$processException$1.L$0 = th2;
                        httpCallValidator$processException$1.L$1 = httpRequest2;
                        httpCallValidator$processException$1.L$2 = it;
                        httpCallValidator$processException$1.label = 1;
                        if (handler.invoke(th2, httpCallValidator$processException$1) != coroutine_suspended) {
                            th3 = th2;
                            httpRequest3 = httpRequest2;
                            httpRequest2 = httpRequest3;
                            th2 = th3;
                        }
                        return coroutine_suspended;
                    }
                    if (handlerWrapper instanceof RequestExceptionHandlerWrapper) {
                        Function3<Throwable, HttpRequest, Continuation<? super Unit>, Object> handler2 = ((RequestExceptionHandlerWrapper) handlerWrapper).getHandler();
                        httpCallValidator$processException$1.L$0 = th2;
                        httpCallValidator$processException$1.L$1 = httpRequest2;
                        httpCallValidator$processException$1.L$2 = it;
                        httpCallValidator$processException$1.label = 2;
                    }
                    while (it.hasNext()) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        httpCallValidator$processException$1 = new HttpCallValidator$processException$1(this, continuation);
        Object obj2 = httpCallValidator$processException$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpCallValidator$processException$1.label;
        if (i != 0) {
        }
    }

    /* compiled from: HttpCallValidator.kt */
    @KtorDsl
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JC\u0010\u0018\u001a\u00020\u001621\u0010\u0019\u001a-\b\u0001\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001cJV\u0010\u001d\u001a\u00020\u00162F\u0010\u0019\u001aB\b\u0001\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b( \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eø\u0001\u0000¢\u0006\u0002\u0010!JA\u0010\"\u001a\u00020\u001621\u0010\u0019\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u001cR$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eRH\u0010\u000f\u001a3\u0012/\u0012-\b\u0001\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00100\u000bX\u0080\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lio/ktor/client/plugins/HttpCallValidator$Config;", "", "()V", "expectSuccess", "", "getExpectSuccess$annotations", "getExpectSuccess", "()Z", "setExpectSuccess", "(Z)V", "responseExceptionHandlers", "", "Lio/ktor/client/plugins/HandlerWrapper;", "getResponseExceptionHandlers$ktor_client_core", "()Ljava/util/List;", "responseValidators", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/ParameterName;", "name", C3337ue.n, "Lkotlin/coroutines/Continuation;", "", "getResponseValidators$ktor_client_core", "handleResponseException", "block", "", "cause", "(Lkotlin/jvm/functions/Function2;)V", "handleResponseExceptionWithRequest", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequest;", AdActivity.REQUEST_KEY_EXTRA, "(Lkotlin/jvm/functions/Function3;)V", "validateResponse", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Config {
        private final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> responseValidators = new ArrayList();
        private final List<HandlerWrapper> responseExceptionHandlers = new ArrayList();
        private boolean expectSuccess = true;

        @Deprecated(message = "This property is ignored. Please use `expectSuccess` property in HttpClientConfig. This is going to become internal.")
        public static /* synthetic */ void getExpectSuccess$annotations() {
        }

        public final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> getResponseValidators$ktor_client_core() {
            return this.responseValidators;
        }

        public final List<HandlerWrapper> getResponseExceptionHandlers$ktor_client_core() {
            return this.responseExceptionHandlers;
        }

        public final boolean getExpectSuccess() {
            return this.expectSuccess;
        }

        public final void setExpectSuccess(boolean z) {
            this.expectSuccess = z;
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Consider using `handleResponseExceptionWithRequest` instead", replaceWith = @ReplaceWith(expression = "this.handleResponseExceptionWithRequest(block)", imports = {}))
        public final void handleResponseException(Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.responseExceptionHandlers.add(new ExceptionHandlerWrapper(block));
        }

        public final void handleResponseExceptionWithRequest(Function3<? super Throwable, ? super HttpRequest, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.responseExceptionHandlers.add(new RequestExceptionHandlerWrapper(block));
        }

        public final void validateResponse(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.responseValidators.add(block);
        }
    }

    /* compiled from: HttpCallValidator.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J!\u0010\u000e\u001a\u00020\u00032\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0002\b\u0011H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/HttpCallValidator$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/HttpCallValidator$Config;", "Lio/ktor/client/plugins/HttpCallValidator;", "()V", C3040d4.h.W, "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", N6.L, "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements HttpClientPlugin<Config, HttpCallValidator> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpCallValidator> getKey() {
            return HttpCallValidator.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpCallValidator prepare(Function1<? super Config, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpCallValidator(CollectionsKt.reversed(config.getResponseValidators$ktor_client_core()), CollectionsKt.reversed(config.getResponseExceptionHandlers$ktor_client_core()), config.getExpectSuccess());
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpCallValidator plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getBefore(), new HttpCallValidator$Companion$install$1(plugin, null));
            PipelinePhase pipelinePhase = new PipelinePhase("BeforeReceive");
            scope.getResponsePipeline().insertPhaseBefore(HttpResponsePipeline.INSTANCE.getReceive(), pipelinePhase);
            scope.getResponsePipeline().intercept(pipelinePhase, new HttpCallValidator$Companion$install$2(plugin, null));
            ((HttpSend) HttpClientPluginKt.plugin(scope, HttpSend.INSTANCE)).intercept(new HttpCallValidator$Companion$install$3(plugin, null));
        }
    }
}
