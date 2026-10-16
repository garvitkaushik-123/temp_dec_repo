package io.bidmachine.util.network;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import io.bidmachine.util.UtilsKt;
import io.bidmachine.util.taskmanager.CancelableTask;
import io.bidmachine.util.taskmanager.TaskManager;
import io.bidmachine.util.taskmanager.coroutine.CoroutineTaskManager;
import io.bidmachine.util.taskmanager.coroutine.NetworkTaskManager;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: NetworkRequest.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 W*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0005VWXYZB\u009f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u0006\u0010;\u001a\u00020<J\u0006\u0010 \u001a\u00020=J\u001a\u0010>\u001a\u00020<2\b\b\u0002\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020AH\u0002J\u001a\u0010>\u001a\u00020<2\b\b\u0002\u0010?\u001a\u00020=2\u0006\u0010B\u001a\u00020CH\u0002J\u0017\u0010D\u001a\u00020<2\b\u0010E\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010FJ-\u0010G\u001a\u00020<2\b\b\u0002\u0010?\u001a\u00020=2\u0018\u0010H\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0016\u0012\u0004\u0012\u00020<0IH\u0082\bJ\u0010\u0010J\u001a\u00020K2\u0006\u0010\u0003\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020<H\u0002J\u0012\u0010N\u001a\u00020<2\b\b\u0002\u0010O\u001a\u00020$H\u0007J\b\u0010P\u001a\u00020<H\u0002J\b\u0010Q\u001a\u00020<H\u0007J'\u0010R\u001a\u00020<2\u001c\u0010H\u001a\u0018\u0012\u000e\u0012\f0SR\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020<0IH\u0082\bJ\b\u0010T\u001a\u00020<H\u0002J\b\u0010U\u001a\u00020<H\u0002R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b,\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0010\u00108\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006["}, d2 = {"Lio/bidmachine/util/network/NetworkRequest;", "ResponseType", "", "url", "", "method", "Lio/bidmachine/util/network/Method;", "headers", "", "queryParameters", "redirect", "Lio/bidmachine/util/network/Redirect;", "timeoutMs", "", "connectTimeoutMs", "", "readTimeoutMs", "requestProcessor", "Lio/bidmachine/util/network/RequestProcessor;", "responseProcessor", "Lio/bidmachine/util/network/ResponseProcessor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/bidmachine/util/network/NetworkRequest$Listener;", "(Ljava/lang/String;Lio/bidmachine/util/network/Method;Ljava/util/Map;Ljava/util/Map;Lio/bidmachine/util/network/Redirect;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Lio/bidmachine/util/network/RequestProcessor;Lio/bidmachine/util/network/ResponseProcessor;Lio/bidmachine/util/network/NetworkRequest$Listener;)V", "getConnectTimeoutMs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "connectionCount", "getHeaders", "()Ljava/util/Map;", "isDataReceived", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDestroyed", "isNotified", "isSend", "lastTaskManager", "Lio/bidmachine/util/taskmanager/TaskManager;", "getListener", "()Lio/bidmachine/util/network/NetworkRequest$Listener;", "getMethod", "()Lio/bidmachine/util/network/Method;", "processTask", "Lio/bidmachine/util/taskmanager/CancelableTask;", "getQueryParameters", "getReadTimeoutMs", "getRedirect", "()Lio/bidmachine/util/network/Redirect;", "requestData", "", "getRequestProcessor", "()Lio/bidmachine/util/network/RequestProcessor;", "getResponseProcessor", "()Lio/bidmachine/util/network/ResponseProcessor;", "getTimeoutMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "timeoutTask", "getUrl", "()Ljava/lang/String;", "destroy", "", "", "notifyError", "skipCheck", "networkError", "Lio/bidmachine/util/network/NetworkError;", "throwable", "", "notifySuccess", C3337ue.n, "(Ljava/lang/Object;)V", "notifyWithAction", "action", "Lkotlin/Function1;", "openConnection", "Ljava/net/HttpURLConnection;", "Ljava/net/URL;", "processTimeout", "send", "taskManager", "sendInternal", "sendSync", "sendWithAction", "Lio/bidmachine/util/network/NetworkRequest$ProcessTask;", "startTimeout", "stopTimeout", "Builder", "Companion", "Listener", "ProcessTask", "TimeoutTask", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class NetworkRequest<ResponseType> {
    public static final String HEADER_USER_AGENT = "User-Agent";
    private static final int MAX_CONNECTION_COUNT = 20;
    private final Integer connectTimeoutMs;
    private int connectionCount;
    private final Map<String, String> headers;
    private final AtomicBoolean isDataReceived;
    private final AtomicBoolean isDestroyed;
    private final AtomicBoolean isNotified;
    private final AtomicBoolean isSend;
    private TaskManager lastTaskManager;
    private final Listener<ResponseType> listener;
    private final Method method;
    private CancelableTask processTask;
    private final Map<String, String> queryParameters;
    private final Integer readTimeoutMs;
    private final Redirect redirect;
    private byte[] requestData;
    private final RequestProcessor requestProcessor;
    private final ResponseProcessor<ResponseType> responseProcessor;
    private final Long timeoutMs;
    private CancelableTask timeoutTask;
    private final String url;
    private static final TaskManager TASK_MANAGER = new NetworkTaskManager();
    private static final TaskManager TIME_OUT_TASK_MANAGER = new CoroutineTaskManager(new CoroutineName("NetworkTimeOutTaskManager").plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(Dispatchers.getIO()));

    /* compiled from: NetworkRequest.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0017\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/util/network/NetworkRequest$Listener;", "ResponseType", "", "onError", "", "networkError", "Lio/bidmachine/util/network/NetworkError;", "onSuccess", C3337ue.n, "(Ljava/lang/Object;)V", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Listener<ResponseType> {
        void onError(NetworkError networkError);

        void onSuccess(ResponseType response);
    }

    public final void send() {
        send$default(this, null, 1, null);
    }

    public NetworkRequest(String url, Method method, Map<String, String> headers, Map<String, String> queryParameters, Redirect redirect, Long l, Integer num, Integer num2, RequestProcessor requestProcessor, ResponseProcessor<ResponseType> responseProcessor, Listener<ResponseType> listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(queryParameters, "queryParameters");
        Intrinsics.checkNotNullParameter(redirect, "redirect");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.queryParameters = queryParameters;
        this.redirect = redirect;
        this.timeoutMs = l;
        this.connectTimeoutMs = num;
        this.readTimeoutMs = num2;
        this.requestProcessor = requestProcessor;
        this.responseProcessor = responseProcessor;
        this.listener = listener;
        this.isSend = new AtomicBoolean(false);
        this.isNotified = new AtomicBoolean(false);
        this.isDestroyed = new AtomicBoolean(false);
        this.isDataReceived = new AtomicBoolean(false);
    }

    public final String getUrl() {
        return this.url;
    }

    public final Method getMethod() {
        return this.method;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ NetworkRequest(java.lang.String r15, io.bidmachine.util.network.Method r16, java.util.Map r17, java.util.Map r18, io.bidmachine.util.network.Redirect r19, java.lang.Long r20, java.lang.Integer r21, java.lang.Integer r22, io.bidmachine.util.network.RequestProcessor r23, io.bidmachine.util.network.ResponseProcessor r24, io.bidmachine.util.network.NetworkRequest.Listener r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r14 = this;
            r0 = r26
            r1 = r0 & 4
            if (r1 == 0) goto Lf
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            r5 = r1
            goto L11
        Lf:
            r5 = r17
        L11:
            r1 = r0 & 8
            if (r1 == 0) goto L1e
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            r6 = r1
            goto L20
        L1e:
            r6 = r18
        L20:
            r1 = r0 & 16
            if (r1 == 0) goto L28
            io.bidmachine.util.network.Redirect r1 = io.bidmachine.util.network.Redirect.Manual
            r7 = r1
            goto L2a
        L28:
            r7 = r19
        L2a:
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L31
            r8 = r2
            goto L33
        L31:
            r8 = r20
        L33:
            r1 = r0 & 64
            if (r1 == 0) goto L39
            r9 = r2
            goto L3b
        L39:
            r9 = r21
        L3b:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L41
            r10 = r2
            goto L43
        L41:
            r10 = r22
        L43:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L49
            r11 = r2
            goto L4b
        L49:
            r11 = r23
        L4b:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L51
            r12 = r2
            goto L53
        L51:
            r12 = r24
        L53:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L5d
            r13 = r2
            r3 = r15
            r4 = r16
            r2 = r14
            goto L63
        L5d:
            r13 = r25
            r2 = r14
            r3 = r15
            r4 = r16
        L63:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.bidmachine.util.network.NetworkRequest.<init>(java.lang.String, io.bidmachine.util.network.Method, java.util.Map, java.util.Map, io.bidmachine.util.network.Redirect, java.lang.Long, java.lang.Integer, java.lang.Integer, io.bidmachine.util.network.RequestProcessor, io.bidmachine.util.network.ResponseProcessor, io.bidmachine.util.network.NetworkRequest$Listener, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final Map<String, String> getQueryParameters() {
        return this.queryParameters;
    }

    public final Redirect getRedirect() {
        return this.redirect;
    }

    public final Long getTimeoutMs() {
        return this.timeoutMs;
    }

    public final Integer getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    public final Integer getReadTimeoutMs() {
        return this.readTimeoutMs;
    }

    public final RequestProcessor getRequestProcessor() {
        return this.requestProcessor;
    }

    public final ResponseProcessor<ResponseType> getResponseProcessor() {
        return this.responseProcessor;
    }

    public final Listener<ResponseType> getListener() {
        return this.listener;
    }

    public static /* synthetic */ void send$default(NetworkRequest networkRequest, TaskManager taskManager, int i, Object obj) {
        if ((i & 1) != 0) {
            taskManager = TASK_MANAGER;
        }
        networkRequest.send(taskManager);
    }

    public final boolean isDestroyed() {
        return this.isDestroyed.get();
    }

    public final void destroy() {
        TaskManager taskManager;
        this.isDestroyed.set(true);
        stopTimeout();
        CancelableTask cancelableTask = this.processTask;
        if (cancelableTask != null && (taskManager = this.lastTaskManager) != null) {
            taskManager.cancel(cancelableTask);
        }
        this.lastTaskManager = null;
        this.processTask = null;
        this.requestData = null;
    }

    private final void sendWithAction(Function1<? super NetworkRequest<ResponseType>.ProcessTask, Unit> action) {
        if (isDestroyed()) {
            notifyError(true, (Throwable) new IllegalStateException("The Send method was called, but NetworkRequest has already been destroyed"));
            return;
        }
        if (this.isSend.compareAndSet(false, true)) {
            startTimeout();
            try {
                ProcessTask processTask = new ProcessTask();
                action.invoke(processTask);
                this.processTask = processTask;
            } catch (Throwable th) {
                notifyError$default((NetworkRequest) this, false, th, 1, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendInternal() {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = openConnection(new URL(NetworkUtils.appendQueryParameters(this.url, this.queryParameters)));
            try {
                if (isDestroyed()) {
                    return;
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (isDestroyed()) {
                    return;
                }
                if (responseCode == 200) {
                    ResponseProcessor<ResponseType> responseProcessor = this.responseProcessor;
                    notifySuccess(responseProcessor != null ? responseProcessor.process(httpURLConnection) : null);
                } else if (responseCode != 204) {
                    notifyError$default((NetworkRequest) this, false, (Throwable) new IllegalResponseException(responseCode), 1, (Object) null);
                } else {
                    notifySuccess(null);
                }
            } catch (RequestInDestroyedStateException unused) {
                httpURLConnection2 = httpURLConnection;
            } catch (Throwable th) {
                th = th;
                try {
                    notifyError$default((NetworkRequest) this, false, th, 1, (Object) null);
                } finally {
                    NetworkUtilsKt.disconnectSafely(httpURLConnection);
                }
            }
        } catch (RequestInDestroyedStateException unused2) {
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    private final HttpURLConnection openConnection(URL url) throws Throwable {
        int i = this.connectionCount + 1;
        this.connectionCount = i;
        if (i > 20) {
            throw new IllegalStateException("The maximum number of connections for one request has been reached");
        }
        if (isDestroyed()) {
            throw new RequestInDestroyedStateException();
        }
        HttpURLConnection httpURLConnection = null;
        try {
            URLConnection openConnection = url.openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
            httpURLConnection2.setInstanceFollowRedirects(this.redirect == Redirect.Native);
            httpURLConnection2.setDoInput(true);
            httpURLConnection2.setUseCaches(false);
            httpURLConnection2.setAllowUserInteraction(false);
            try {
                RequestProcessor requestProcessor = this.requestProcessor;
                if (requestProcessor != null) {
                    requestProcessor.setupConnection(httpURLConnection2);
                }
                httpURLConnection2.setRequestMethod(this.method.getNetworkName());
                for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                    httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                }
                Integer num = this.connectTimeoutMs;
                if (num != null && num.intValue() >= 0) {
                    httpURLConnection2.setConnectTimeout(this.connectTimeoutMs.intValue());
                }
                Integer num2 = this.readTimeoutMs;
                if (num2 != null && num2.intValue() >= 0) {
                    httpURLConnection2.setReadTimeout(this.readTimeoutMs.intValue());
                }
                if (this.isDataReceived.compareAndSet(false, true)) {
                    RequestProcessor requestProcessor2 = this.requestProcessor;
                    this.requestData = requestProcessor2 != null ? requestProcessor2.getBody() : null;
                }
                byte[] bArr = this.requestData;
                if (bArr != null) {
                    httpURLConnection2.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection2.getOutputStream();
                    Intrinsics.checkNotNullExpressionValue(outputStream, "httpURLConnection.outputStream");
                    BufferedOutputStream bufferedOutputStream = outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, 8192);
                    try {
                        bufferedOutputStream.write(bArr);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedOutputStream, null);
                    } finally {
                    }
                }
                if (isDestroyed()) {
                    throw new RequestInDestroyedStateException();
                }
                if (this.redirect == Redirect.Manual) {
                    int responseCode = httpURLConnection2.getResponseCode();
                    switch (responseCode) {
                        case MRAID_ERROR_VALUE:
                        case INVALID_IFA_STATUS_VALUE:
                        case 303:
                        case MRAID_BRIDGE_ERROR_VALUE:
                        case 307:
                        case 308:
                            String headerField = httpURLConnection2.getHeaderField("Location");
                            NetworkUtilsKt.disconnectSafely(httpURLConnection2);
                            String str = headerField;
                            if (str == null || str.length() == 0) {
                                throw new IllegalArgumentException("Location header url could not be null or empty when server responds with " + responseCode + " code");
                            }
                            URL url2 = new URL(url, headerField);
                            if (!NetworkUtilsKt.isHttp(url2)) {
                                throw new IllegalArgumentException("Location header url is not http or https, but has " + url2.getProtocol() + " protocol");
                            }
                            return openConnection(url2);
                    }
                }
                return httpURLConnection2;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                NetworkUtilsKt.disconnectSafely(httpURLConnection);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void startTimeout() {
        stopTimeout();
        Long l = this.timeoutMs;
        if (l == null || l.longValue() <= 0) {
            return;
        }
        try {
            NetworkRequest<ResponseType> networkRequest = this;
            TimeoutTask timeoutTask = new TimeoutTask();
            TIME_OUT_TASK_MANAGER.scheduleSafely(timeoutTask, this.timeoutMs.longValue());
            this.timeoutTask = timeoutTask;
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
    }

    private final void stopTimeout() {
        CancelableTask cancelableTask = this.timeoutTask;
        if (cancelableTask != null) {
            TIME_OUT_TASK_MANAGER.cancel(cancelableTask);
        }
        this.timeoutTask = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processTimeout() {
        if (isDestroyed()) {
            return;
        }
        destroy();
        TaskManager taskManager = this.lastTaskManager;
        if (taskManager == null) {
            taskManager = TASK_MANAGER;
        }
        taskManager.executeSafely(new Runnable() { // from class: io.bidmachine.util.network.NetworkRequest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NetworkRequest.processTimeout$lambda$9(NetworkRequest.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processTimeout$lambda$9(NetworkRequest this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyError(true, new NetworkError(new TimeoutException("NetworkRequest timeout reached")));
    }

    static /* synthetic */ void notifyError$default(NetworkRequest networkRequest, boolean z, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        networkRequest.notifyError(z, th);
    }

    private final void notifyError(boolean skipCheck, Throwable throwable) {
        notifyError(skipCheck, new NetworkError(throwable));
    }

    static /* synthetic */ void notifyError$default(NetworkRequest networkRequest, boolean z, NetworkError networkError, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        networkRequest.notifyError(z, networkError);
    }

    private final void notifyWithAction(boolean skipCheck, Function1<? super Listener<ResponseType>, Unit> action) {
        Listener<ResponseType> listener;
        if (this.isNotified.compareAndSet(false, true) || skipCheck) {
            if ((!isDestroyed() || skipCheck) && (listener = getListener()) != null) {
                action.invoke(listener);
            }
        }
    }

    static /* synthetic */ void notifyWithAction$default(NetworkRequest networkRequest, boolean z, Function1 function1, int i, Object obj) {
        Listener<ResponseType> listener;
        if ((i & 1) != 0) {
            z = false;
        }
        if (networkRequest.isNotified.compareAndSet(false, true) || z) {
            if ((!networkRequest.isDestroyed() || z) && (listener = networkRequest.getListener()) != null) {
                function1.invoke(listener);
            }
        }
    }

    /* compiled from: NetworkRequest.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\f\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001fJ\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u001f2\b\b\u0002\u0010!\u001a\u00020\"H\u0007J\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\u001fJ\u001b\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010%J\"\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010'J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000eJ\"\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010'J\u001b\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010%J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0016J\u001b\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u00100J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u00102\u001a\u0004\u0018\u00010\u0004R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lio/bidmachine/util/network/NetworkRequest$Builder;", "ResponseType", "", "url", "", "method", "Lio/bidmachine/util/network/Method;", "(Ljava/lang/String;Lio/bidmachine/util/network/Method;)V", "connectTimeoutMs", "", "Ljava/lang/Integer;", "headers", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/bidmachine/util/network/NetworkRequest$Listener;", "queryParameters", "readTimeoutMs", "redirect", "Lio/bidmachine/util/network/Redirect;", "requestProcessor", "Lio/bidmachine/util/network/RequestProcessor;", "responseProcessor", "Lio/bidmachine/util/network/ResponseProcessor;", "timeoutMs", "", "Ljava/lang/Long;", "addHeader", C3040d4.h.W, "value", "addQueryParameter", "build", "Lio/bidmachine/util/network/NetworkRequest;", "send", "taskManager", "Lio/bidmachine/util/taskmanager/TaskManager;", "sendSync", "setConnectTimeoutMs", "(Ljava/lang/Integer;)Lio/bidmachine/util/network/NetworkRequest$Builder;", "setHeaders", "", "setListener", "setQueryParameters", "parameters", "setReadTimeoutMs", "setRedirect", "setRequestProcessor", "setResponseProcessor", "setTimeoutMs", "(Ljava/lang/Long;)Lio/bidmachine/util/network/NetworkRequest$Builder;", "setUserAgentHeader", "userAgent", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder<ResponseType> {
        private Integer connectTimeoutMs;
        private final Map<String, String> headers;
        private Listener<ResponseType> listener;
        private final Method method;
        private final Map<String, String> queryParameters;
        private Integer readTimeoutMs;
        private Redirect redirect;
        private RequestProcessor requestProcessor;
        private ResponseProcessor<ResponseType> responseProcessor;
        private Long timeoutMs;
        private final String url;

        public final NetworkRequest<ResponseType> send() {
            return send$default(this, null, 1, null);
        }

        public Builder(String url, Method method) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(method, "method");
            this.url = url;
            this.method = method;
            this.headers = new HashMap();
            this.queryParameters = new HashMap();
            this.redirect = Redirect.Manual;
        }

        public final Builder<ResponseType> setHeaders(Map<String, String> headers) {
            UtilsKt.setSafely(this.headers, headers);
            return this;
        }

        public final Builder<ResponseType> addHeader(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.headers.put(key, value);
            return this;
        }

        public final Builder<ResponseType> setUserAgentHeader(String userAgent) {
            if (userAgent != null && userAgent.length() > 0) {
                addHeader("User-Agent", userAgent);
            }
            return this;
        }

        public final Builder<ResponseType> setQueryParameters(Map<String, String> parameters) {
            UtilsKt.setSafely(this.queryParameters, parameters);
            return this;
        }

        public final Builder<ResponseType> addQueryParameter(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.queryParameters.put(key, value);
            return this;
        }

        public final Builder<ResponseType> setRedirect(Redirect redirect) {
            Intrinsics.checkNotNullParameter(redirect, "redirect");
            this.redirect = redirect;
            return this;
        }

        public final Builder<ResponseType> setTimeoutMs(Long timeoutMs) {
            this.timeoutMs = timeoutMs;
            return this;
        }

        public final Builder<ResponseType> setConnectTimeoutMs(Integer connectTimeoutMs) {
            this.connectTimeoutMs = connectTimeoutMs;
            return this;
        }

        public final Builder<ResponseType> setReadTimeoutMs(Integer readTimeoutMs) {
            this.readTimeoutMs = readTimeoutMs;
            return this;
        }

        public final Builder<ResponseType> setRequestProcessor(RequestProcessor requestProcessor) {
            this.requestProcessor = requestProcessor;
            return this;
        }

        public final Builder<ResponseType> setResponseProcessor(ResponseProcessor<ResponseType> responseProcessor) {
            this.responseProcessor = responseProcessor;
            return this;
        }

        public final Builder<ResponseType> setListener(Listener<ResponseType> listener) {
            this.listener = listener;
            return this;
        }

        public final NetworkRequest<ResponseType> build() {
            return new NetworkRequest<>(this.url, this.method, this.headers, this.queryParameters, this.redirect, this.timeoutMs, this.connectTimeoutMs, this.readTimeoutMs, this.requestProcessor, this.responseProcessor, this.listener);
        }

        public static /* synthetic */ NetworkRequest send$default(Builder builder, TaskManager taskManager, int i, Object obj) {
            if ((i & 1) != 0) {
                taskManager = NetworkRequest.TASK_MANAGER;
            }
            return builder.send(taskManager);
        }

        public final NetworkRequest<ResponseType> send(TaskManager taskManager) {
            Intrinsics.checkNotNullParameter(taskManager, "taskManager");
            NetworkRequest<ResponseType> build = build();
            build.send(taskManager);
            return build;
        }

        public final NetworkRequest<ResponseType> sendSync() {
            NetworkRequest<ResponseType> build = build();
            build.sendSync();
            return build;
        }
    }

    /* compiled from: NetworkRequest.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lio/bidmachine/util/network/NetworkRequest$ProcessTask;", "Lio/bidmachine/util/taskmanager/CancelableTask;", "(Lio/bidmachine/util/network/NetworkRequest;)V", "runTask", "", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class ProcessTask extends CancelableTask {
        public ProcessTask() {
        }

        @Override // io.bidmachine.util.taskmanager.CancelableTask
        public void runTask() {
            NetworkRequest.this.sendInternal();
        }
    }

    /* compiled from: NetworkRequest.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lio/bidmachine/util/network/NetworkRequest$TimeoutTask;", "Lio/bidmachine/util/taskmanager/CancelableTask;", "(Lio/bidmachine/util/network/NetworkRequest;)V", "runTask", "", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class TimeoutTask extends CancelableTask {
        public TimeoutTask() {
        }

        @Override // io.bidmachine.util.taskmanager.CancelableTask
        public void runTask() {
            NetworkRequest.this.processTimeout();
        }
    }

    public final void send(TaskManager taskManager) {
        Intrinsics.checkNotNullParameter(taskManager, "taskManager");
        if (isDestroyed()) {
            notifyError(true, (Throwable) new IllegalStateException("The Send method was called, but NetworkRequest has already been destroyed"));
            return;
        }
        if (this.isSend.compareAndSet(false, true)) {
            startTimeout();
            try {
                ProcessTask processTask = new ProcessTask();
                taskManager.execute(processTask);
                this.lastTaskManager = taskManager;
                this.processTask = processTask;
            } catch (Throwable th) {
                notifyError$default((NetworkRequest) this, false, th, 1, (Object) null);
            }
        }
    }

    public final void sendSync() {
        if (isDestroyed()) {
            notifyError(true, (Throwable) new IllegalStateException("The Send method was called, but NetworkRequest has already been destroyed"));
            return;
        }
        if (this.isSend.compareAndSet(false, true)) {
            startTimeout();
            try {
                ProcessTask processTask = new ProcessTask();
                processTask.run();
                this.processTask = processTask;
            } catch (Throwable th) {
                notifyError$default((NetworkRequest) this, false, th, 1, (Object) null);
            }
        }
    }

    private final void notifySuccess(ResponseType response) {
        Listener<ResponseType> listener;
        if (!this.isNotified.compareAndSet(false, true) || isDestroyed() || (listener = getListener()) == null) {
            return;
        }
        listener.onSuccess(response);
    }

    private final void notifyError(boolean skipCheck, NetworkError networkError) {
        Listener<ResponseType> listener;
        if (this.isNotified.compareAndSet(false, true) || skipCheck) {
            if ((!isDestroyed() || skipCheck) && (listener = getListener()) != null) {
                listener.onError(networkError);
            }
        }
    }
}
