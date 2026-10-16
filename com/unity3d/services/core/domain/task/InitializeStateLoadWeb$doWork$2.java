package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.extensions.TaskExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateLoadWeb.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb$LoadWebResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2", f = "InitializeStateLoadWeb.kt", i = {0, 0, 1}, l = {46, 64, 71}, m = "invokeSuspend", n = {"$this$withContext", AdActivity.REQUEST_KEY_EXTRA, AdActivity.REQUEST_KEY_EXTRA}, s = {"L$0", "L$3", "L$2"})
/* loaded from: classes7.dex */
final class InitializeStateLoadWeb$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends InitializeStateLoadWeb.LoadWebResult>>, Object> {
    final /* synthetic */ InitializeStateLoadWeb.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2(InitializeStateLoadWeb.Params params, InitializeStateLoadWeb initializeStateLoadWeb, Continuation<? super InitializeStateLoadWeb$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateLoadWeb;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateLoadWeb$doWork$2 initializeStateLoadWeb$doWork$2 = new InitializeStateLoadWeb$doWork$2(this.$params, this.this$0, continuation);
        initializeStateLoadWeb$doWork$2.L$0 = obj;
        return initializeStateLoadWeb$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends InitializeStateLoadWeb.LoadWebResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>> continuation) {
        return ((InitializeStateLoadWeb$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x01d9, code lost:
    
        com.unity3d.services.core.misc.Utilities.writeFile(new java.io.File(com.unity3d.services.core.properties.SdkProperties.getLocalWebViewFile()), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0189, code lost:
    
        if (r0 == r8) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0169 A[Catch: all -> 0x01f3, CancellationException -> 0x0220, TryCatch #5 {CancellationException -> 0x0220, all -> 0x01f3, blocks: (B:8:0x001a, B:10:0x018c, B:11:0x01af, B:13:0x01b9, B:16:0x01c4, B:17:0x01d6, B:20:0x01d9, B:21:0x01e5, B:35:0x0163, B:37:0x0169, B:40:0x018f, B:41:0x01a1, B:67:0x0159, B:48:0x0127, B:53:0x01a2, B:56:0x011d, B:58:0x0071), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018f A[Catch: all -> 0x01f3, CancellationException -> 0x0220, TryCatch #5 {CancellationException -> 0x0220, all -> 0x01f3, blocks: (B:8:0x001a, B:10:0x018c, B:11:0x01af, B:13:0x01b9, B:16:0x01c4, B:17:0x01d6, B:20:0x01d9, B:21:0x01e5, B:35:0x0163, B:37:0x0169, B:40:0x018f, B:41:0x01a1, B:67:0x0159, B:48:0x0127, B:53:0x01a2, B:56:0x011d, B:58:0x0071), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d A[Catch: all -> 0x0046, TRY_ENTER, TryCatch #3 {all -> 0x0046, blocks: (B:33:0x0039, B:34:0x0150, B:50:0x012d), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a2 A[Catch: all -> 0x01f3, CancellationException -> 0x0220, TryCatch #5 {CancellationException -> 0x0220, all -> 0x01f3, blocks: (B:8:0x001a, B:10:0x018c, B:11:0x01af, B:13:0x01b9, B:16:0x01c4, B:17:0x01d6, B:20:0x01d9, B:21:0x01e5, B:35:0x0163, B:37:0x0169, B:40:0x018f, B:41:0x01a1, B:67:0x0159, B:48:0x0127, B:53:0x01a2, B:56:0x011d, B:58:0x0071), top: B:2:0x000e }] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v27, types: [com.unity3d.services.core.network.model.HttpRequest] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.unity3d.services.core.network.model.HttpRequest] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m10241constructorimpl;
        Object m10241constructorimpl2;
        InitializeStateLoadWeb initializeStateLoadWeb;
        ?? r1;
        ISDKDispatchers iSDKDispatchers;
        Object withContext;
        InitializeStateLoadWeb.Params params;
        String str;
        String webViewHash;
        InitializeStateLoadWeb initializeStateLoadWeb2;
        HttpRequest httpRequest;
        Object withRetry;
        Object m10241constructorimpl3;
        InitializeStateLoadWeb initializeStateLoadWeb3;
        ?? r12;
        InitializeStateNetworkError initializeStateNetworkError;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        ?? r2 = 1;
        try {
            try {
            } catch (Throwable th) {
                Result.Companion companion = Result.INSTANCE;
                m10241constructorimpl2 = Result.m10241constructorimpl(ResultKt.createFailure(th));
                r1 = i;
                initializeStateLoadWeb = r2;
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th2));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            InitializeStateLoadWeb.Params params2 = this.$params;
            InitializeStateLoadWeb initializeStateLoadWeb4 = this.this$0;
            Result.Companion companion3 = Result.INSTANCE;
            DeviceLog.info("Unity Ads init: loading webapp from " + params2.getConfig().getWebViewUrl());
            String webViewUrl = params2.getConfig().getWebViewUrl();
            Intrinsics.checkNotNullExpressionValue(webViewUrl, "params.config.webViewUrl");
            HttpRequest httpRequest2 = new HttpRequest(webViewUrl, null, RequestType.GET, null, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131066, null);
            try {
                Result.Companion companion4 = Result.INSTANCE;
                int maxRetries = params2.getConfig().getMaxRetries();
                double retryScalingFactor = params2.getConfig().getRetryScalingFactor();
                long retryDelay = params2.getConfig().getRetryDelay();
                InitializationException initializationException = new InitializationException(ErrorState.NetworkWebviewRequest, new Exception(), params2.getConfig());
                InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 initializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 = new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1(initializeStateLoadWeb4, httpRequest2, null);
                this.L$0 = coroutineScope;
                this.L$1 = params2;
                this.L$2 = initializeStateLoadWeb4;
                this.L$3 = httpRequest2;
                this.label = 1;
                withRetry = TaskExtensionsKt.withRetry(retryDelay, maxRetries, retryScalingFactor, initializationException, initializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1, this);
                if (withRetry != coroutine_suspended) {
                    params = params2;
                    initializeStateLoadWeb2 = initializeStateLoadWeb4;
                    httpRequest = httpRequest2;
                }
            } catch (Throwable th3) {
                th = th3;
                params = params2;
                initializeStateLoadWeb2 = initializeStateLoadWeb4;
                httpRequest = httpRequest2;
                Result.Companion companion5 = Result.INSTANCE;
                m10241constructorimpl3 = Result.m10241constructorimpl(ResultKt.createFailure(th));
                r12 = httpRequest;
                initializeStateLoadWeb3 = initializeStateLoadWeb2;
                if (Result.m10247isFailureimpl(m10241constructorimpl3)) {
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            httpRequest = (HttpRequest) this.L$3;
            initializeStateLoadWeb2 = (InitializeStateLoadWeb) this.L$2;
            params = (InitializeStateLoadWeb.Params) this.L$1;
            try {
                ResultKt.throwOnFailure(obj);
                withRetry = obj;
                httpRequest = httpRequest;
                initializeStateLoadWeb2 = initializeStateLoadWeb2;
            } catch (Throwable th4) {
                th = th4;
                Result.Companion companion52 = Result.INSTANCE;
                m10241constructorimpl3 = Result.m10241constructorimpl(ResultKt.createFailure(th));
                r12 = httpRequest;
                initializeStateLoadWeb3 = initializeStateLoadWeb2;
                if (Result.m10247isFailureimpl(m10241constructorimpl3)) {
                }
            }
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                InitializeStateLoadWeb.Params params3 = (InitializeStateLoadWeb.Params) this.L$0;
                ResultKt.throwOnFailure(obj);
                params = params3;
                withContext = obj;
                str = (String) withContext;
                webViewHash = params.getConfig().getWebViewHash();
                if (webViewHash != null && !Intrinsics.areEqual(Utilities.Sha256(str), webViewHash)) {
                    throw new InitializationException(ErrorState.InvalidHash, new Exception("Invalid webViewHash"), params.getConfig());
                }
                m10241constructorimpl = Result.m10241constructorimpl(new InitializeStateLoadWeb.LoadWebResult(params.getConfig(), str));
                if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
                    Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                    if (m10244exceptionOrNullimpl != null) {
                        Result.Companion companion6 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
                    }
                } else {
                    Result.Companion companion7 = Result.INSTANCE;
                    m10241constructorimpl = Result.m10241constructorimpl(m10241constructorimpl);
                }
                return Result.m10240boximpl(m10241constructorimpl);
            }
            ?? r13 = (HttpRequest) this.L$2;
            InitializeStateLoadWeb initializeStateLoadWeb5 = (InitializeStateLoadWeb) this.L$1;
            params = (InitializeStateLoadWeb.Params) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = ((Result) obj).getValue();
            i = r13;
            r2 = initializeStateLoadWeb5;
            m10241constructorimpl2 = Result.m10241constructorimpl(Result.m10240boximpl(obj2));
            r1 = i;
            initializeStateLoadWeb = r2;
            if (!Result.m10248isSuccessimpl(m10241constructorimpl2)) {
                iSDKDispatchers = initializeStateLoadWeb.dispatchers;
                CoroutineDispatcher io2 = iSDKDispatchers.getIo();
                InitializeStateLoadWeb$doWork$2$1$webViewData$1 initializeStateLoadWeb$doWork$2$1$webViewData$1 = new InitializeStateLoadWeb$doWork$2$1$webViewData$1(initializeStateLoadWeb, r1, null);
                this.L$0 = params;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 3;
                withContext = BuildersKt.withContext(io2, initializeStateLoadWeb$doWork$2$1$webViewData$1, this);
            } else {
                throw new InitializationException(ErrorState.NetworkWebviewRequest, new Exception("No connected events within the timeout!"), params.getConfig());
            }
        }
        m10241constructorimpl3 = Result.m10241constructorimpl((HttpResponse) withRetry);
        r12 = httpRequest;
        initializeStateLoadWeb3 = initializeStateLoadWeb2;
        if (Result.m10247isFailureimpl(m10241constructorimpl3)) {
            Result.Companion companion8 = Result.INSTANCE;
            initializeStateNetworkError = initializeStateLoadWeb3.initializeStateNetworkError;
            InitializeStateNetworkError.Params params4 = new InitializeStateNetworkError.Params(params.getConfig());
            this.L$0 = params;
            this.L$1 = initializeStateLoadWeb3;
            this.L$2 = r12;
            this.L$3 = null;
            this.label = 2;
            obj2 = initializeStateNetworkError.mo9272invokegIAlus(params4, this);
            i = r12;
            r2 = initializeStateLoadWeb3;
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            m10241constructorimpl2 = Result.m10241constructorimpl(Result.m10240boximpl(obj2));
            r1 = i;
            initializeStateLoadWeb = r2;
            if (!Result.m10248isSuccessimpl(m10241constructorimpl2)) {
            }
        } else {
            ResultKt.throwOnFailure(m10241constructorimpl3);
            str = ((HttpResponse) m10241constructorimpl3).getBody().toString();
            webViewHash = params.getConfig().getWebViewHash();
            if (webViewHash != null) {
                throw new InitializationException(ErrorState.InvalidHash, new Exception("Invalid webViewHash"), params.getConfig());
            }
            m10241constructorimpl = Result.m10241constructorimpl(new InitializeStateLoadWeb.LoadWebResult(params.getConfig(), str));
            if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
            }
            return Result.m10240boximpl(m10241constructorimpl);
        }
    }
}
