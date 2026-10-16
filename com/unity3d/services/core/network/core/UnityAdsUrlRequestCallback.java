package com.unity3d.services.core.network.core;

import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.vungle.ads.internal.ui.AdActivity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* compiled from: UnityAdsUrlRequestCallback.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\b \u0018\u0000 +2\u00020\u0001:\u0001+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J$\u0010#\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0016\u0010&\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010'\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ \u0010'\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H&J\u000e\u0010*\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006,"}, d2 = {"Lcom/unity3d/services/core/network/core/UnityAdsUrlRequestCallback;", "Lorg/chromium/net/UrlRequest$Callback;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "readTimeout", "", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;J)V", "bytesReceived", "Ljava/io/ByteArrayOutputStream;", "getReadTimeout", "()J", "receiveChannel", "Ljava/nio/channels/WritableByteChannel;", "kotlin.jvm.PlatformType", "task", "Lkotlinx/coroutines/Job;", "getTask$annotations", "()V", "getTask", "()Lkotlinx/coroutines/Job;", "setTask", "(Lkotlinx/coroutines/Job;)V", "cancelTimer", "", "onCanceled", AdActivity.REQUEST_KEY_EXTRA, "Lorg/chromium/net/UrlRequest;", "info", "Lorg/chromium/net/UrlResponseInfo;", "onFailed", "error", "Lorg/chromium/net/CronetException;", "onReadCompleted", "byteBuffer", "Ljava/nio/ByteBuffer;", "onRedirectReceived", "newLocationUrl", "", "onResponseStarted", "onSucceeded", "bodyBytes", "", "startTimer", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public abstract class UnityAdsUrlRequestCallback extends UrlRequest.Callback {
    private static final int BYTE_BUFFER_CAPACITY_BYTES = 16384;
    private final ByteArrayOutputStream bytesReceived;
    private final ISDKDispatchers dispatchers;
    private final long readTimeout;
    private final WritableByteChannel receiveChannel;
    private Job task;

    public static /* synthetic */ void getTask$annotations() {
    }

    public abstract void onSucceeded(UrlRequest request, UrlResponseInfo info, byte[] bodyBytes);

    public final long getReadTimeout() {
        return this.readTimeout;
    }

    public UnityAdsUrlRequestCallback(ISDKDispatchers dispatchers, long j) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.dispatchers = dispatchers;
        this.readTimeout = j;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.bytesReceived = byteArrayOutputStream;
        this.receiveChannel = Channels.newChannel(byteArrayOutputStream);
    }

    public final Job getTask() {
        return this.task;
    }

    public final void setTask(Job job) {
        this.task = job;
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onRedirectReceived(UrlRequest request, UrlResponseInfo info, String newLocationUrl) {
        Intrinsics.checkNotNullParameter(request, "request");
        request.followRedirect();
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onResponseStarted(UrlRequest request, UrlResponseInfo info) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(info, "info");
        startTimer(request);
        request.read(ByteBuffer.allocateDirect(16384));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onReadCompleted(UrlRequest request, UrlResponseInfo info, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
        cancelTimer();
        byteBuffer.flip();
        try {
            this.receiveChannel.write(byteBuffer);
        } catch (IOException e) {
            DeviceLog.info("IOException during ByteBuffer read. Details: ", e);
        }
        byteBuffer.clear();
        startTimer(request);
        request.read(byteBuffer);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onSucceeded(UrlRequest request, UrlResponseInfo info) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(info, "info");
        cancelTimer();
        byte[] bodyBytes = this.bytesReceived.toByteArray();
        Intrinsics.checkNotNullExpressionValue(bodyBytes, "bodyBytes");
        onSucceeded(request, info, bodyBytes);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onCanceled(UrlRequest request, UrlResponseInfo info) {
        super.onCanceled(request, info);
        cancelTimer();
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onFailed(UrlRequest request, UrlResponseInfo info, CronetException error) {
        cancelTimer();
    }

    public final void startTimer(UrlRequest request) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(request, "request");
        cancelTimer();
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.dispatchers.getIo()), null, null, new UnityAdsUrlRequestCallback$startTimer$1(this, request, null), 3, null);
        this.task = launch$default;
    }

    private final void cancelTimer() {
        Job job = this.task;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.task = null;
    }
}
