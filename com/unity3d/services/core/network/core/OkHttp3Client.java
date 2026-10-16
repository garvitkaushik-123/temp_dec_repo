package com.unity3d.services.core.network.core;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.net.HttpHeaders;
import com.ironsource.C3337ue;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.extensions.StringExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.OkHttp3Client;
import com.unity3d.services.core.network.domain.CleanupDirectory;
import com.unity3d.services.core.network.mapper.HttpRequestToOkHttpRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.AdActivity;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import io.ktor.client.utils.CacheControl;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* compiled from: OkHttp3Client.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J1\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/unity3d/services/core/network/core/OkHttp3Client;", "Lcom/unity3d/services/core/network/core/HttpClient;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "client", "Lokhttp3/OkHttpClient;", "context", "Landroid/content/Context;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "cleanupDirectory", "Lcom/unity3d/services/core/network/domain/CleanupDirectory;", "isAlternativeFlowReader", "Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;Lokhttp3/OkHttpClient;Landroid/content/Context;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/services/core/network/domain/CleanupDirectory;Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;)V", "okHttpCache", "Ljava/io/File;", "execute", "Lcom/unity3d/services/core/network/model/HttpResponse;", AdActivity.REQUEST_KEY_EXTRA, "Lcom/unity3d/services/core/network/model/HttpRequest;", "(Lcom/unity3d/services/core/network/model/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeBlocking", "getOkHttpCache", "makeRequest", "Lcom/unity3d/services/core/network/core/OkHttp3Client$RequestComplete;", "connectTimeout", "", "readTimeout", "writeTimeout", "(Lcom/unity3d/services/core/network/model/HttpRequest;JJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "RequestComplete", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class OkHttp3Client implements HttpClient {
    public static final String MSG_CONNECTION_FAILED = "Network request failed";
    public static final String MSG_CONNECTION_TIMEOUT = "Network request timeout";
    public static final String NETWORK_CLIENT_OKHTTP = "okhttp";
    private final CleanupDirectory cleanupDirectory;
    private final OkHttpClient client;
    private final Context context;
    private final ISDKDispatchers dispatchers;
    private final AlternativeFlowReader isAlternativeFlowReader;
    private final File okHttpCache;
    private final SessionRepository sessionRepository;

    public OkHttp3Client(ISDKDispatchers dispatchers, OkHttpClient client, Context context, SessionRepository sessionRepository, CleanupDirectory cleanupDirectory, AlternativeFlowReader isAlternativeFlowReader) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(cleanupDirectory, "cleanupDirectory");
        Intrinsics.checkNotNullParameter(isAlternativeFlowReader, "isAlternativeFlowReader");
        this.dispatchers = dispatchers;
        this.client = client;
        this.context = context;
        this.sessionRepository = sessionRepository;
        this.cleanupDirectory = cleanupDirectory;
        this.isAlternativeFlowReader = isAlternativeFlowReader;
        this.okHttpCache = getOkHttpCache();
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public HttpResponse executeBlocking(HttpRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return (HttpResponse) BuildersKt.runBlocking(this.dispatchers.getIo(), new OkHttp3Client$executeBlocking$1(this, request, null));
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public Object execute(HttpRequest httpRequest, Continuation<? super HttpResponse> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new OkHttp3Client$execute$2(this, httpRequest, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object makeRequest(final HttpRequest httpRequest, long j, long j2, long j3, Continuation<? super RequestComplete> continuation) {
        Request okHttpProtoRequest = httpRequest.isProtobuf() ? HttpRequestToOkHttpRequestKt.toOkHttpProtoRequest(httpRequest) : HttpRequestToOkHttpRequestKt.toOkHttpRequest(httpRequest);
        OkHttpClient build = this.client.newBuilder().connectTimeout(j, TimeUnit.MILLISECONDS).readTimeout(j2, TimeUnit.MILLISECONDS).writeTimeout(j3, TimeUnit.MILLISECONDS).build();
        final File file = new File(this.okHttpCache, StringExtensionsKt.getSHA256Hash(httpRequest.getBaseURL()));
        Long boxLong = Boxing.boxLong((file.exists() && file.isFile()) ? file.length() : 0L);
        Request request = null;
        if (boxLong.longValue() <= 0) {
            boxLong = null;
        }
        if (boxLong != null) {
            long longValue = boxLong.longValue();
            DeviceLog.debug("Resuming download for " + httpRequest.getBaseURL());
            request = okHttpProtoRequest.newBuilder().addHeader("Range", "bytes=" + longValue + '-').build();
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (request != null) {
            okHttpProtoRequest = request;
        }
        build.newCall(okHttpProtoRequest).enqueue(new Callback() { // from class: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:41:0x0114 A[Catch: IOException -> 0x0164, TryCatch #0 {IOException -> 0x0164, blocks: (B:7:0x003c, B:9:0x0044, B:11:0x0057, B:13:0x006a, B:16:0x0077, B:19:0x007f, B:21:0x0084, B:23:0x008c, B:24:0x008f, B:27:0x009d, B:29:0x00a9, B:31:0x00b4, B:33:0x00d1, B:34:0x00e7, B:36:0x00ed, B:38:0x00f7, B:39:0x010e, B:41:0x0114, B:43:0x0121, B:46:0x0126, B:51:0x012e, B:53:0x0133, B:55:0x0138, B:56:0x013b, B:58:0x0146, B:59:0x0151, B:61:0x014b, B:62:0x00f3), top: B:6:0x003c }] */
            /* JADX WARN: Removed duplicated region for block: B:53:0x0133 A[Catch: IOException -> 0x0164, TryCatch #0 {IOException -> 0x0164, blocks: (B:7:0x003c, B:9:0x0044, B:11:0x0057, B:13:0x006a, B:16:0x0077, B:19:0x007f, B:21:0x0084, B:23:0x008c, B:24:0x008f, B:27:0x009d, B:29:0x00a9, B:31:0x00b4, B:33:0x00d1, B:34:0x00e7, B:36:0x00ed, B:38:0x00f7, B:39:0x010e, B:41:0x0114, B:43:0x0121, B:46:0x0126, B:51:0x012e, B:53:0x0133, B:55:0x0138, B:56:0x013b, B:58:0x0146, B:59:0x0151, B:61:0x014b, B:62:0x00f3), top: B:6:0x003c }] */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0138 A[Catch: IOException -> 0x0164, TryCatch #0 {IOException -> 0x0164, blocks: (B:7:0x003c, B:9:0x0044, B:11:0x0057, B:13:0x006a, B:16:0x0077, B:19:0x007f, B:21:0x0084, B:23:0x008c, B:24:0x008f, B:27:0x009d, B:29:0x00a9, B:31:0x00b4, B:33:0x00d1, B:34:0x00e7, B:36:0x00ed, B:38:0x00f7, B:39:0x010e, B:41:0x0114, B:43:0x0121, B:46:0x0126, B:51:0x012e, B:53:0x0133, B:55:0x0138, B:56:0x013b, B:58:0x0146, B:59:0x0151, B:61:0x014b, B:62:0x00f3), top: B:6:0x003c }] */
            /* JADX WARN: Removed duplicated region for block: B:58:0x0146 A[Catch: IOException -> 0x0164, TryCatch #0 {IOException -> 0x0164, blocks: (B:7:0x003c, B:9:0x0044, B:11:0x0057, B:13:0x006a, B:16:0x0077, B:19:0x007f, B:21:0x0084, B:23:0x008c, B:24:0x008f, B:27:0x009d, B:29:0x00a9, B:31:0x00b4, B:33:0x00d1, B:34:0x00e7, B:36:0x00ed, B:38:0x00f7, B:39:0x010e, B:41:0x0114, B:43:0x0121, B:46:0x0126, B:51:0x012e, B:53:0x0133, B:55:0x0138, B:56:0x013b, B:58:0x0146, B:59:0x0151, B:61:0x014b, B:62:0x00f3), top: B:6:0x003c }] */
            /* JADX WARN: Removed duplicated region for block: B:61:0x014b A[Catch: IOException -> 0x0164, TryCatch #0 {IOException -> 0x0164, blocks: (B:7:0x003c, B:9:0x0044, B:11:0x0057, B:13:0x006a, B:16:0x0077, B:19:0x007f, B:21:0x0084, B:23:0x008c, B:24:0x008f, B:27:0x009d, B:29:0x00a9, B:31:0x00b4, B:33:0x00d1, B:34:0x00e7, B:36:0x00ed, B:38:0x00f7, B:39:0x010e, B:41:0x0114, B:43:0x0121, B:46:0x0126, B:51:0x012e, B:53:0x0133, B:55:0x0138, B:56:0x013b, B:58:0x0146, B:59:0x0151, B:61:0x014b, B:62:0x00f3), top: B:6:0x003c }] */
            @Override // okhttp3.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResponse(Call call, Response response) {
                BufferedSink bufferedSink;
                Job job;
                Iterator it;
                File file2;
                final Flow debounce;
                ISDKDispatchers iSDKDispatchers;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful()) {
                    CancellableContinuation<OkHttp3Client.RequestComplete> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(new IOException("Network request failed with code " + response.code()))));
                    return;
                }
                try {
                    ResponseBody body = response.body();
                    int i = 2;
                    DefaultConstructorMarker defaultConstructorMarker = null;
                    if (body == null) {
                        CancellableContinuation<OkHttp3Client.RequestComplete> cancellableContinuation2 = cancellableContinuationImpl2;
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation2.resumeWith(Result.m10241constructorimpl(new OkHttp3Client.RequestComplete(response, defaultConstructorMarker, i, defaultConstructorMarker)));
                        return;
                    }
                    final long contentLength = body.getContentLength();
                    Buffer buffer = new Buffer();
                    String header = response.header(HttpHeaders.CACHE_CONTROL);
                    boolean z = false;
                    if (header != null && !StringsKt.contains$default((CharSequence) header, (CharSequence) CacheControl.NO_CACHE, false, 2, (Object) null)) {
                        z = true;
                    }
                    OkHttp3Client$makeRequest$2$1 okHttp3Client$makeRequest$2$1 = this;
                    OkHttp3Client$makeRequest$2$1 okHttp3Client$makeRequest$2$12 = z ? this : null;
                    OkHttp3Client$makeRequest$2$1 okHttp3Client$makeRequest$2$13 = okHttp3Client$makeRequest$2$12;
                    if (okHttp3Client$makeRequest$2$12 != null) {
                        File file3 = file;
                        if (!file3.exists()) {
                            file3.createNewFile();
                        }
                        bufferedSink = Okio.buffer(Okio.appendingSink(file3));
                    } else {
                        bufferedSink = null;
                    }
                    long j4 = 0;
                    MutableStateFlow MutableStateFlow = bufferedSink != null ? StateFlowKt.MutableStateFlow(0L) : null;
                    if (MutableStateFlow != null && (debounce = FlowKt.debounce(MutableStateFlow, 1000L)) != null) {
                        final Flow<Long> flow = new Flow<Long>() { // from class: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1

                            /* compiled from: Emitters.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            /* renamed from: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1$2, reason: invalid class name */
                            public static final class AnonymousClass2<T> implements FlowCollector {
                                final /* synthetic */ FlowCollector $this_unsafeFlow;

                                /* compiled from: Emitters.kt */
                                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1$2", f = "OkHttp3Client.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                                /* renamed from: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1$2$1, reason: invalid class name */
                                public static final class AnonymousClass1 extends ContinuationImpl {
                                    Object L$0;
                                    Object L$1;
                                    int label;
                                    /* synthetic */ Object result;

                                    public AnonymousClass1(Continuation continuation) {
                                        super(continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        this.result = obj;
                                        this.label |= Integer.MIN_VALUE;
                                        return AnonymousClass2.this.emit(null, this);
                                    }
                                }

                                public AnonymousClass2(FlowCollector flowCollector) {
                                    this.$this_unsafeFlow = flowCollector;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                                @Override // kotlinx.coroutines.flow.FlowCollector
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Object emit(Object obj, Continuation continuation) {
                                    AnonymousClass1 anonymousClass1;
                                    int i;
                                    if (continuation instanceof AnonymousClass1) {
                                        anonymousClass1 = (AnonymousClass1) continuation;
                                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                            anonymousClass1.label -= Integer.MIN_VALUE;
                                            Object obj2 = anonymousClass1.result;
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            i = anonymousClass1.label;
                                            if (i != 0) {
                                                ResultKt.throwOnFailure(obj2);
                                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                                if (((Number) obj).longValue() != 0) {
                                                    anonymousClass1.label = 1;
                                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                }
                                            } else {
                                                if (i != 1) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj2);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                    Object obj22 = anonymousClass1.result;
                                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    i = anonymousClass1.label;
                                    if (i != 0) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // kotlinx.coroutines.flow.Flow
                            public Object collect(FlowCollector<? super Long> flowCollector, Continuation continuation2) {
                                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation2);
                                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                            }
                        };
                        Flow onEach = FlowKt.onEach(new Flow<Integer>() { // from class: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1

                            /* compiled from: Emitters.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            /* renamed from: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1$2, reason: invalid class name */
                            public static final class AnonymousClass2<T> implements FlowCollector {
                                final /* synthetic */ long $contentLength$inlined;
                                final /* synthetic */ FlowCollector $this_unsafeFlow;

                                /* compiled from: Emitters.kt */
                                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1$2", f = "OkHttp3Client.kt", i = {}, l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit", n = {}, s = {})
                                /* renamed from: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1$2$1, reason: invalid class name */
                                public static final class AnonymousClass1 extends ContinuationImpl {
                                    Object L$0;
                                    int label;
                                    /* synthetic */ Object result;

                                    public AnonymousClass1(Continuation continuation) {
                                        super(continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        this.result = obj;
                                        this.label |= Integer.MIN_VALUE;
                                        return AnonymousClass2.this.emit(null, this);
                                    }
                                }

                                public AnonymousClass2(FlowCollector flowCollector, long j) {
                                    this.$this_unsafeFlow = flowCollector;
                                    this.$contentLength$inlined = j;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                                @Override // kotlinx.coroutines.flow.FlowCollector
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Object emit(Object obj, Continuation continuation) {
                                    AnonymousClass1 anonymousClass1;
                                    int i;
                                    if (continuation instanceof AnonymousClass1) {
                                        anonymousClass1 = (AnonymousClass1) continuation;
                                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                            anonymousClass1.label -= Integer.MIN_VALUE;
                                            Object obj2 = anonymousClass1.result;
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            i = anonymousClass1.label;
                                            if (i != 0) {
                                                ResultKt.throwOnFailure(obj2);
                                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                                Integer boxInt = Boxing.boxInt(MathKt.roundToInt((((Number) obj).longValue() / this.$contentLength$inlined) * 100));
                                                anonymousClass1.label = 1;
                                                if (flowCollector.emit(boxInt, anonymousClass1) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                if (i != 1) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj2);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                    Object obj22 = anonymousClass1.result;
                                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    i = anonymousClass1.label;
                                    if (i != 0) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // kotlinx.coroutines.flow.Flow
                            public Object collect(FlowCollector<? super Integer> flowCollector, Continuation continuation2) {
                                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, contentLength), continuation2);
                                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                            }
                        }, new OkHttp3Client$makeRequest$2$1$onResponse$downloadProgressLoggingJob$3(httpRequest, null));
                        if (onEach != null) {
                            iSDKDispatchers = this.dispatchers;
                            job = FlowKt.launchIn(onEach, CoroutineScopeKt.CoroutineScope(iSDKDispatchers.getIo()));
                            final BufferedSource bodySource = body.getBodySource();
                            if (bufferedSink != null || (r9 = bufferedSink.getBufferField()) == null) {
                                final Buffer bufferField = buffer.getBufferField();
                            }
                            it = SequencesKt.takeWhile(SequencesKt.generateSequence(new Function0<Long>() { // from class: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Long invoke() {
                                    return Long.valueOf(BufferedSource.this.read(bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI));
                                }
                            }), new Function1<Long, Boolean>() { // from class: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$2
                                public final Boolean invoke(long j5) {
                                    return Boolean.valueOf(j5 != -1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
                                    return invoke(l.longValue());
                                }
                            }).iterator();
                            while (it.hasNext()) {
                                j4 += ((Number) it.next()).longValue();
                                if (bufferedSink != null) {
                                    bufferedSink.emitCompleteSegments();
                                }
                                if (MutableStateFlow != null) {
                                    MutableStateFlow.tryEmit(Long.valueOf(j4));
                                }
                            }
                            buffer.close();
                            if (bufferedSink != null) {
                                bufferedSink.close();
                            }
                            if (job != null) {
                                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                            }
                            bodySource.close();
                            body.close();
                            bufferField.close();
                            if (bufferedSink == null) {
                                file2 = file;
                            } else {
                                file2 = (Serializable) buffer.readByteArray();
                            }
                            CancellableContinuation<OkHttp3Client.RequestComplete> cancellableContinuation3 = cancellableContinuationImpl2;
                            Result.Companion companion3 = Result.INSTANCE;
                            cancellableContinuation3.resumeWith(Result.m10241constructorimpl(new OkHttp3Client.RequestComplete(response, file2)));
                        }
                    }
                    job = null;
                    final BufferedSource bodySource2 = body.getBodySource();
                    if (bufferedSink != null) {
                    }
                    final Buffer bufferField2 = buffer.getBufferField();
                    it = SequencesKt.takeWhile(SequencesKt.generateSequence(new Function0<Long>() { // from class: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Long invoke() {
                            return Long.valueOf(BufferedSource.this.read(bufferField2, PlaybackStateCompat.ACTION_PLAY_FROM_URI));
                        }
                    }), new Function1<Long, Boolean>() { // from class: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$2
                        public final Boolean invoke(long j5) {
                            return Boolean.valueOf(j5 != -1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
                            return invoke(l.longValue());
                        }
                    }).iterator();
                    while (it.hasNext()) {
                    }
                    buffer.close();
                    if (bufferedSink != null) {
                    }
                    if (job != null) {
                    }
                    bodySource2.close();
                    body.close();
                    bufferField2.close();
                    if (bufferedSink == null) {
                    }
                    CancellableContinuation<OkHttp3Client.RequestComplete> cancellableContinuation32 = cancellableContinuationImpl2;
                    Result.Companion companion32 = Result.INSTANCE;
                    cancellableContinuation32.resumeWith(Result.m10241constructorimpl(new OkHttp3Client.RequestComplete(response, file2)));
                } catch (IOException e) {
                    CancellableContinuation<OkHttp3Client.RequestComplete> cancellableContinuation4 = cancellableContinuationImpl2;
                    Result.Companion companion4 = Result.INSTANCE;
                    cancellableContinuation4.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(e)));
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                CancellableContinuation<OkHttp3Client.RequestComplete> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(e)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final File getOkHttpCache() {
        File filesDir = this.context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
        File resolve = FilesKt.resolve(filesDir, UnityAdsConstants.DefaultUrls.HTTP_CACHE_DIR_NAME);
        resolve.mkdirs();
        if (this.sessionRepository.getNativeConfiguration().hasCachedAssetsConfiguration()) {
            NativeConfigurationOuterClass.CachedAssetsConfiguration cachedAssetsConfiguration = this.sessionRepository.getNativeConfiguration().getCachedAssetsConfiguration();
            this.cleanupDirectory.invoke(resolve, cachedAssetsConfiguration.getMaxCachedAssetSizeMb(), cachedAssetsConfiguration.getMaxCachedAssetAgeMs());
        }
        return resolve;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OkHttp3Client.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/unity3d/services/core/network/core/OkHttp3Client$RequestComplete;", "", C3337ue.n, "Lokhttp3/Response;", "body", "(Lokhttp3/Response;Ljava/lang/Object;)V", "getBody", "()Ljava/lang/Object;", "getResponse", "()Lokhttp3/Response;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final /* data */ class RequestComplete {
        private final Object body;
        private final Response response;

        public static /* synthetic */ RequestComplete copy$default(RequestComplete requestComplete, Response response, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                response = requestComplete.response;
            }
            if ((i & 2) != 0) {
                obj = requestComplete.body;
            }
            return requestComplete.copy(response, obj);
        }

        /* renamed from: component1, reason: from getter */
        public final Response getResponse() {
            return this.response;
        }

        /* renamed from: component2, reason: from getter */
        public final Object getBody() {
            return this.body;
        }

        public final RequestComplete copy(Response response, Object body) {
            Intrinsics.checkNotNullParameter(response, "response");
            return new RequestComplete(response, body);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestComplete)) {
                return false;
            }
            RequestComplete requestComplete = (RequestComplete) other;
            return Intrinsics.areEqual(this.response, requestComplete.response) && Intrinsics.areEqual(this.body, requestComplete.body);
        }

        public int hashCode() {
            int hashCode = this.response.hashCode() * 31;
            Object obj = this.body;
            return hashCode + (obj == null ? 0 : obj.hashCode());
        }

        public String toString() {
            return "RequestComplete(response=" + this.response + ", body=" + this.body + ')';
        }

        public RequestComplete(Response response, Object obj) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.response = response;
            this.body = obj;
        }

        public /* synthetic */ RequestComplete(Response response, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(response, (i & 2) != 0 ? null : obj);
        }

        public final Object getBody() {
            return this.body;
        }

        public final Response getResponse() {
            return this.response;
        }
    }
}
