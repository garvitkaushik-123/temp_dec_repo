package com.vungle.ads.internal.downloader;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.unity3d.services.core.di.ServiceProvider;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.AssetDownloadError;
import com.vungle.ads.AssetFailedStatusCodeError;
import com.vungle.ads.AssetRequestError;
import com.vungle.ads.AssetWriteError;
import com.vungle.ads.NoSpaceError;
import com.vungle.ads.OutOfMemory;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.AssetDownloader;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.presenter.NativeAdPresenter;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.task.PriorityRunnable;
import com.vungle.ads.internal.ui.AdActivity;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Okio__JvmOkioKt;
import okio.Sink;

/* compiled from: AssetDownloader.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J$\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\"\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0002J\u001c\u0010$\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010%\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u001a\u0010(\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/vungle/ads/internal/downloader/AssetDownloader;", "Lcom/vungle/ads/internal/downloader/Downloader;", "downloadExecutor", "Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "(Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;Lcom/vungle/ads/internal/util/PathProvider;)V", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "transitioning", "", "Lcom/vungle/ads/internal/downloader/DownloadRequest;", "cancel", "", AdActivity.REQUEST_KEY_EXTRA, "cancelAll", "checkSpaceAvailable", "", "downloadRequest", "decodeGzipIfNeeded", "Lokhttp3/ResponseBody;", "networkResponse", "Lokhttp3/Response;", "deliverError", "downloadListener", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener;", "downloadError", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener$DownloadError;", "deliverSuccess", C3040d4.h.b, "Ljava/io/File;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, NativeAdPresenter.DOWNLOAD, "isValidUrl", "httpUrl", "", "launchRequest", "Companion", "OkHttpSingleton", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class AssetDownloader implements Downloader {
    private static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final int DOWNLOAD_CHUNK_SIZE = 2048;
    private static final String GZIP = "gzip";
    private static final int MINIMUM_SPACE_REQUIRED_MB = 20971520;
    private static final String TAG = "AssetDownloader";
    private final VungleThreadPoolExecutor downloadExecutor;

    /* renamed from: okHttpClient$delegate, reason: from kotlin metadata */
    private final Lazy okHttpClient;
    private final PathProvider pathProvider;
    private final List<DownloadRequest> transitioning;

    public AssetDownloader(VungleThreadPoolExecutor downloadExecutor, PathProvider pathProvider) {
        Intrinsics.checkNotNullParameter(downloadExecutor, "downloadExecutor");
        Intrinsics.checkNotNullParameter(pathProvider, "pathProvider");
        this.downloadExecutor = downloadExecutor;
        this.pathProvider = pathProvider;
        this.okHttpClient = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.vungle.ads.internal.downloader.AssetDownloader$okHttpClient$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final OkHttpClient invoke() {
                PathProvider pathProvider2;
                AssetDownloader.OkHttpSingleton okHttpSingleton = AssetDownloader.OkHttpSingleton.INSTANCE;
                pathProvider2 = AssetDownloader.this.pathProvider;
                return okHttpSingleton.createOkHttpClient(pathProvider2);
            }
        });
        this.transitioning = new ArrayList();
    }

    private final OkHttpClient getOkHttpClient() {
        return (OkHttpClient) this.okHttpClient.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AssetDownloader.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/vungle/ads/internal/downloader/AssetDownloader$OkHttpSingleton;", "", "()V", "client", "Lokhttp3/OkHttpClient;", "createOkHttpClient", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    static final class OkHttpSingleton {
        public static final OkHttpSingleton INSTANCE = new OkHttpSingleton();
        private static OkHttpClient client;

        private OkHttpSingleton() {
        }

        public final OkHttpClient createOkHttpClient(PathProvider pathProvider) {
            Intrinsics.checkNotNullParameter(pathProvider, "pathProvider");
            OkHttpClient okHttpClient = client;
            if (okHttpClient != null) {
                return okHttpClient;
            }
            OkHttpClient.Builder followSslRedirects = new OkHttpClient.Builder().readTimeout(60L, TimeUnit.SECONDS).connectTimeout(60L, TimeUnit.SECONDS).cache(null).followRedirects(true).followSslRedirects(true);
            if (ConfigManager.INSTANCE.isCleverCacheEnabled()) {
                long cleverCacheDiskSize = ConfigManager.INSTANCE.getCleverCacheDiskSize();
                int cleverCacheDiskPercentage = ConfigManager.INSTANCE.getCleverCacheDiskPercentage();
                String absolutePath = pathProvider.getCleverCacheDir().getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "pathProvider.getCleverCacheDir().absolutePath");
                long min = Long.min(cleverCacheDiskSize, (pathProvider.getAvailableBytes(absolutePath) * cleverCacheDiskPercentage) / 100);
                if (min > 0) {
                    followSslRedirects.cache(new Cache(pathProvider.getCleverCacheDir(), min));
                } else {
                    Logger.INSTANCE.w("OkHttpClientWrapper", "cache disk capacity size <=0, no clever cache active.");
                }
            }
            OkHttpClient build = followSslRedirects.build();
            client = build;
            return build;
        }
    }

    @Override // com.vungle.ads.internal.downloader.Downloader
    public void download(final DownloadRequest downloadRequest, final AssetDownloadListener downloadListener) {
        if (downloadRequest == null) {
            return;
        }
        this.transitioning.add(downloadRequest);
        this.downloadExecutor.execute(new PriorityRunnable() { // from class: com.vungle.ads.internal.downloader.AssetDownloader$download$1
            @Override // java.lang.Runnable
            public void run() {
                AssetDownloader.this.launchRequest(downloadRequest, downloadListener);
            }

            @Override // com.vungle.ads.internal.task.PriorityRunnable
            public int getPriority() {
                return downloadRequest.getPriority();
            }
        }, new Runnable() { // from class: com.vungle.ads.internal.downloader.AssetDownloader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AssetDownloader.m9339download$lambda0(DownloadRequest.this, this, downloadListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: download$lambda-0, reason: not valid java name */
    public static final void m9339download$lambda0(DownloadRequest downloadRequest, AssetDownloader this$0, AssetDownloadListener assetDownloadListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.deliverError(downloadRequest, assetDownloadListener, new AssetDownloadListener.DownloadError(-1, new OutOfMemory("Failed to execute download request: " + downloadRequest.getAsset().getServerPath()), AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getINTERNAL_ERROR()));
    }

    private final void deliverError(DownloadRequest downloadRequest, AssetDownloadListener downloadListener, AssetDownloadListener.DownloadError downloadError) {
        if (downloadListener != null) {
            downloadListener.onError(downloadError, downloadRequest);
        }
    }

    @Override // com.vungle.ads.internal.downloader.Downloader
    public void cancel(DownloadRequest request) {
        if (request == null || request.isCancelled()) {
            return;
        }
        request.cancel();
    }

    @Override // com.vungle.ads.internal.downloader.Downloader
    public void cancelAll() {
        Iterator<T> it = this.transitioning.iterator();
        while (it.hasNext()) {
            cancel((DownloadRequest) it.next());
        }
        this.transitioning.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0465 A[Catch: all -> 0x054c, TryCatch #22 {all -> 0x054c, blocks: (B:52:0x0458, B:54:0x0465, B:55:0x04b1, B:77:0x0491, B:79:0x0495, B:81:0x0499), top: B:51:0x0458 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0491 A[Catch: all -> 0x054c, TryCatch #22 {all -> 0x054c, blocks: (B:52:0x0458, B:54:0x0465, B:55:0x04b1, B:77:0x0491, B:79:0x0495, B:81:0x0499), top: B:51:0x0458 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x05a1  */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void launchRequest(DownloadRequest downloadRequest, AssetDownloadListener downloadListener) {
        String str;
        boolean z;
        BufferedSource bufferedSource;
        Call call;
        int i;
        Response response;
        Call call2;
        Call call3;
        Response response2;
        Call call4;
        int status;
        ResponseBody body;
        Call call5;
        Call call6;
        int status2;
        ResponseBody body2;
        long length;
        int i2;
        String str2;
        Sink appendingSink;
        BufferedSink bufferedSink;
        Call call7;
        String str3;
        long j;
        ResponseBody body3;
        int i3;
        String str4 = "On cancel ";
        String str5 = "download status: ";
        Logger.INSTANCE.d(TAG, "launch request in thread: " + Thread.currentThread().getId() + " request: " + downloadRequest.getAsset().getServerPath());
        if (downloadRequest.isCancelled()) {
            Logger.INSTANCE.d(TAG, "Request " + downloadRequest.getAsset().getServerPath() + " is cancelled before starting");
            new AssetDownloadListener.Progress().setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getCANCELLED());
            return;
        }
        AssetDownloadListener.Progress progress = new AssetDownloadListener.Progress();
        progress.setTimestampDownloadStart(System.currentTimeMillis());
        String serverPath = downloadRequest.getAsset().getServerPath();
        String localPath = downloadRequest.getAsset().getLocalPath();
        int i4 = -1;
        if (serverPath.length() == 0 || !isValidUrl(serverPath)) {
            deliverError(downloadRequest, downloadListener, new AssetDownloadListener.DownloadError(-1, new AssetDownloadError(Sdk.SDKError.Reason.INVALID_ASSET_URL, "invalid url: " + serverPath).setLogEntry$vungle_ads_release(downloadRequest.getLogEntry()).logError$vungle_ads_release(), AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getINTERNAL_ERROR()));
            return;
        }
        if (localPath.length() == 0) {
            deliverError(downloadRequest, downloadListener, new AssetDownloadListener.DownloadError(-1, new AssetDownloadError(Sdk.SDKError.Reason.ASSET_WRITE_ERROR, "invalid path: " + localPath).setLogEntry$vungle_ads_release(downloadRequest.getLogEntry()).logError$vungle_ads_release(), AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getFILE_NOT_FOUND_ERROR()));
            return;
        }
        boolean z2 = true;
        Response response3 = null;
        if (!checkSpaceAvailable(downloadRequest)) {
            deliverError(downloadRequest, downloadListener, new AssetDownloadListener.DownloadError(-1, new NoSpaceError(null, 1, null).setLogEntry$vungle_ads_release(downloadRequest.getLogEntry()).logError$vungle_ads_release(), AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getDISK_ERROR()));
            return;
        }
        File file = new File(localPath);
        AssetDownloadListener.DownloadError downloadError = null;
        boolean z3 = false;
        while (!z3) {
            try {
                try {
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        try {
                            if (!parentFile.exists()) {
                                parentFile.mkdirs();
                            }
                        } catch (Exception e) {
                            e = e;
                            i = i4;
                            z = z2;
                            response = response3;
                            Call call8 = response;
                            call3 = call8;
                            response2 = call3;
                            str = str4;
                            call6 = call8;
                            try {
                                Logger.INSTANCE.e(TAG, String.valueOf(e));
                                if (e instanceof ProtocolException) {
                                }
                                progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                                AssetDownloadListener.DownloadError downloadError2 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                                if ((response2 != null ? response2.body() : null) != null) {
                                }
                                if (call3 != null) {
                                }
                                FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                                FileUtility.INSTANCE.closeQuietly(response);
                                Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                                status2 = progress.getStatus();
                                if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                                }
                                deliverError(downloadRequest, downloadListener, downloadError2);
                                downloadError = downloadError2;
                                Unit unit = Unit.INSTANCE;
                                str4 = str;
                                z3 = z;
                                z2 = z3;
                                i4 = -1;
                                response3 = null;
                            } catch (Throwable th) {
                                th = th;
                                bufferedSource = response;
                                call5 = call6;
                                call = call3;
                                response3 = response2;
                                call4 = call5;
                                if ((response3 == null ? response3.body() : null) != null) {
                                }
                                if (call != null) {
                                }
                                FileUtility.INSTANCE.closeQuietly((Closeable) call4);
                                FileUtility.INSTANCE.closeQuietly(bufferedSource);
                                Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                                status = progress.getStatus();
                                if (status != AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                                }
                                deliverError(downloadRequest, downloadListener, downloadError);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str = str4;
                            bufferedSource = response3;
                            call = bufferedSource;
                            call4 = call;
                            if ((response3 == null ? response3.body() : null) != null) {
                            }
                            if (call != null) {
                            }
                            FileUtility.INSTANCE.closeQuietly((Closeable) call4);
                            FileUtility.INSTANCE.closeQuietly(bufferedSource);
                            Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                            status = progress.getStatus();
                            if (status != AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                            }
                            deliverError(downloadRequest, downloadListener, downloadError);
                            throw th;
                        }
                    }
                    length = file.exists() ? file.length() : 0L;
                } catch (Throwable th3) {
                    th = th3;
                    str = str4;
                    response3 = null;
                    bufferedSource = null;
                    call = null;
                }
            } catch (Exception e2) {
                e = e2;
                str = str4;
                z = z2;
            }
            try {
                call = getOkHttpClient().newCall(new Request.Builder().url(serverPath).build());
            } catch (Exception e3) {
                e = e3;
                str = str4;
                z = true;
                i = -1;
                response = null;
                call2 = null;
                call3 = null;
                response2 = null;
                call6 = call2;
                Logger.INSTANCE.e(TAG, String.valueOf(e));
                if (e instanceof ProtocolException) {
                }
                progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                AssetDownloadListener.DownloadError downloadError22 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                if ((response2 != null ? response2.body() : null) != null) {
                }
                if (call3 != null) {
                }
                FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                FileUtility.INSTANCE.closeQuietly(response);
                Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                status2 = progress.getStatus();
                if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                }
                deliverError(downloadRequest, downloadListener, downloadError22);
                downloadError = downloadError22;
                Unit unit2 = Unit.INSTANCE;
                str4 = str;
                z3 = z;
                z2 = z3;
                i4 = -1;
                response3 = null;
            }
            try {
                response3 = call.execute();
                try {
                    try {
                        i = response3.code();
                        try {
                        } catch (Exception e4) {
                            e = e4;
                            str = str4;
                            response2 = response3;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        str = str4;
                        response2 = response3;
                        call3 = call;
                        z = true;
                        i = -1;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = str4;
                }
            } catch (Exception e6) {
                e = e6;
                str = str4;
                call3 = call;
                z = true;
                i = -1;
                response = null;
                call2 = null;
                response2 = null;
                call6 = call2;
                Logger.INSTANCE.e(TAG, String.valueOf(e));
                if (e instanceof ProtocolException) {
                }
                progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                AssetDownloadListener.DownloadError downloadError222 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                if ((response2 != null ? response2.body() : null) != null) {
                }
                if (call3 != null) {
                }
                FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                FileUtility.INSTANCE.closeQuietly(response);
                Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                status2 = progress.getStatus();
                if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                }
                deliverError(downloadRequest, downloadListener, downloadError222);
                downloadError = downloadError222;
                Unit unit22 = Unit.INSTANCE;
                str4 = str;
                z3 = z;
                z2 = z3;
                i4 = -1;
                response3 = null;
            } catch (Throwable th5) {
                th = th5;
                str = str4;
                response3 = null;
            }
            if (response3.isSuccessful()) {
                try {
                    if (response3.cacheResponse() != null) {
                        try {
                            call3 = call;
                            try {
                                try {
                                    i2 = i;
                                    try {
                                        AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.CACHED_ASSETS_USED), downloadRequest.getLogEntry(), serverPath);
                                        Unit unit3 = Unit.INSTANCE;
                                        Unit unit4 = Unit.INSTANCE;
                                    } catch (Exception e7) {
                                        e = e7;
                                        str = str4;
                                        response2 = response3;
                                        i = i2;
                                        z = true;
                                        response = null;
                                        call6 = null;
                                        Logger.INSTANCE.e(TAG, String.valueOf(e));
                                        if (e instanceof ProtocolException) {
                                        }
                                        progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                                        AssetDownloadListener.DownloadError downloadError2222 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                                        if ((response2 != null ? response2.body() : null) != null) {
                                        }
                                        if (call3 != null) {
                                        }
                                        FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                                        FileUtility.INSTANCE.closeQuietly(response);
                                        Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                                        status2 = progress.getStatus();
                                        if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                                        }
                                        deliverError(downloadRequest, downloadListener, downloadError2222);
                                        downloadError = downloadError2222;
                                        Unit unit222 = Unit.INSTANCE;
                                        str4 = str;
                                        z3 = z;
                                        z2 = z3;
                                        i4 = -1;
                                        response3 = null;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    str = str4;
                                    call = call3;
                                    bufferedSource = null;
                                    call4 = null;
                                    if ((response3 == null ? response3.body() : null) != null) {
                                        body.close();
                                        Unit unit5 = Unit.INSTANCE;
                                    }
                                    if (call != null) {
                                    }
                                    FileUtility.INSTANCE.closeQuietly((Closeable) call4);
                                    FileUtility.INSTANCE.closeQuietly(bufferedSource);
                                    Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                                    status = progress.getStatus();
                                    if (status != AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                                    }
                                    deliverError(downloadRequest, downloadListener, downloadError);
                                    throw th;
                                }
                            } catch (Exception e8) {
                                e = e8;
                                str = str4;
                                response2 = response3;
                                z = true;
                                response = null;
                                call6 = null;
                                Logger.INSTANCE.e(TAG, String.valueOf(e));
                                if (e instanceof ProtocolException) {
                                }
                                progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                                AssetDownloadListener.DownloadError downloadError22222 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                                if ((response2 != null ? response2.body() : null) != null) {
                                }
                                if (call3 != null) {
                                }
                                FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                                FileUtility.INSTANCE.closeQuietly(response);
                                Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                                status2 = progress.getStatus();
                                if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                                }
                                deliverError(downloadRequest, downloadListener, downloadError22222);
                                downloadError = downloadError22222;
                                Unit unit2222 = Unit.INSTANCE;
                                str4 = str;
                                z3 = z;
                                z2 = z3;
                                i4 = -1;
                                response3 = null;
                            }
                        } catch (Exception e9) {
                            e = e9;
                            call3 = call;
                        } catch (Throwable th7) {
                            th = th7;
                            str = str4;
                            bufferedSource = null;
                            call4 = null;
                            if ((response3 == null ? response3.body() : null) != null) {
                            }
                            if (call != null) {
                            }
                            FileUtility.INSTANCE.closeQuietly((Closeable) call4);
                            FileUtility.INSTANCE.closeQuietly(bufferedSource);
                            Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                            status = progress.getStatus();
                            if (status != AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                            }
                            deliverError(downloadRequest, downloadListener, downloadError);
                            throw th;
                        }
                    } else {
                        i2 = i;
                        call3 = call;
                    }
                } catch (Exception e10) {
                    e = e10;
                    str = str4;
                    response2 = response3;
                    call3 = call;
                    z = true;
                    response = null;
                    call6 = null;
                    Logger.INSTANCE.e(TAG, String.valueOf(e));
                    if (e instanceof ProtocolException) {
                        new AssetRequestError("Failed to load asset: " + downloadRequest.getAsset().getServerPath()).setLogEntry$vungle_ads_release(downloadRequest.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                    } else if ((e instanceof UnknownHostException) || (e instanceof IOException)) {
                        new AssetFailedStatusCodeError(serverPath, Integer.valueOf(i), e.getMessage()).setLogEntry$vungle_ads_release(downloadRequest.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                    }
                    progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                    AssetDownloadListener.DownloadError downloadError222222 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                    if ((response2 != null ? response2.body() : null) != null && (body2 = response2.body()) != null) {
                        body2.close();
                        Unit unit6 = Unit.INSTANCE;
                    }
                    if (call3 != null) {
                        call3.cancel();
                        Unit unit7 = Unit.INSTANCE;
                    }
                    FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                    FileUtility.INSTANCE.closeQuietly(response);
                    Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                    status2 = progress.getStatus();
                    if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR() || status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getSTARTED()) {
                        deliverError(downloadRequest, downloadListener, downloadError222222);
                    } else if (status2 != AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getCANCELLED()) {
                        Logger.INSTANCE.d(TAG, str + downloadRequest);
                    } else {
                        deliverSuccess(file, downloadRequest, downloadListener);
                    }
                    downloadError = downloadError222222;
                    Unit unit22222 = Unit.INSTANCE;
                    str4 = str;
                    z3 = z;
                    z2 = z3;
                    i4 = -1;
                    response3 = null;
                }
                try {
                    ResponseBody decodeGzipIfNeeded = decodeGzipIfNeeded(response3);
                    bufferedSource = decodeGzipIfNeeded != null ? decodeGzipIfNeeded.getDelegateSource() : null;
                    try {
                        response2 = response3;
                        try {
                            Logger.INSTANCE.d(TAG, "Start download from bytes:" + length + ", url: " + serverPath);
                            if (length == 0) {
                                str2 = str4;
                                z = true;
                                try {
                                    appendingSink = Okio__JvmOkioKt.sink$default(file, false, 1, null);
                                } catch (Exception e11) {
                                    e = e11;
                                    bufferedSink = 0;
                                    str = str2;
                                    call7 = bufferedSink;
                                    response = bufferedSource;
                                    i = i2;
                                    call6 = call7;
                                    Logger.INSTANCE.e(TAG, String.valueOf(e));
                                    if (e instanceof ProtocolException) {
                                    }
                                    progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                                    AssetDownloadListener.DownloadError downloadError2222222 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                                    if ((response2 != null ? response2.body() : null) != null) {
                                    }
                                    if (call3 != null) {
                                    }
                                    FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                                    FileUtility.INSTANCE.closeQuietly(response);
                                    Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                                    status2 = progress.getStatus();
                                    if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                                    }
                                    deliverError(downloadRequest, downloadListener, downloadError2222222);
                                    downloadError = downloadError2222222;
                                    Unit unit222222 = Unit.INSTANCE;
                                    str4 = str;
                                    z3 = z;
                                    z2 = z3;
                                    i4 = -1;
                                    response3 = null;
                                } catch (Throwable th8) {
                                    th = th8;
                                    bufferedSink = 0;
                                    str = str2;
                                    call5 = bufferedSink;
                                    call = call3;
                                    response3 = response2;
                                    call4 = call5;
                                    if ((response3 == null ? response3.body() : null) != null) {
                                    }
                                    if (call != null) {
                                    }
                                    FileUtility.INSTANCE.closeQuietly((Closeable) call4);
                                    FileUtility.INSTANCE.closeQuietly(bufferedSource);
                                    Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                                    status = progress.getStatus();
                                    if (status != AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                                    }
                                    deliverError(downloadRequest, downloadListener, downloadError);
                                    throw th;
                                }
                            } else {
                                str2 = str4;
                                z = true;
                                try {
                                    appendingSink = Okio.appendingSink(file);
                                } catch (Exception e12) {
                                    e = e12;
                                    str = str2;
                                    response = bufferedSource;
                                    i = i2;
                                    call6 = null;
                                    Logger.INSTANCE.e(TAG, String.valueOf(e));
                                    if (e instanceof ProtocolException) {
                                    }
                                    progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                                    AssetDownloadListener.DownloadError downloadError22222222 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                                    if ((response2 != null ? response2.body() : null) != null) {
                                    }
                                    if (call3 != null) {
                                    }
                                    FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                                    FileUtility.INSTANCE.closeQuietly(response);
                                    Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                                    status2 = progress.getStatus();
                                    if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                                    }
                                    deliverError(downloadRequest, downloadListener, downloadError22222222);
                                    downloadError = downloadError22222222;
                                    Unit unit2222222 = Unit.INSTANCE;
                                    str4 = str;
                                    z3 = z;
                                    z2 = z3;
                                    i4 = -1;
                                    response3 = null;
                                } catch (Throwable th9) {
                                    th = th9;
                                    str = str2;
                                    call = call3;
                                    response3 = response2;
                                    call4 = null;
                                    if ((response3 == null ? response3.body() : null) != null) {
                                    }
                                    if (call != null) {
                                    }
                                    FileUtility.INSTANCE.closeQuietly((Closeable) call4);
                                    FileUtility.INSTANCE.closeQuietly(bufferedSource);
                                    Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                                    status = progress.getStatus();
                                    if (status != AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                                    }
                                    deliverError(downloadRequest, downloadListener, downloadError);
                                    throw th;
                                }
                            }
                            bufferedSink = Okio.buffer(appendingSink);
                            try {
                                progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getSTARTED());
                                if (decodeGzipIfNeeded != null) {
                                    str3 = str5;
                                    j = decodeGzipIfNeeded.getContentLength();
                                } else {
                                    str3 = str5;
                                    j = 0;
                                }
                            } catch (Exception e13) {
                                e = e13;
                                str = str2;
                                call7 = bufferedSink;
                                response = bufferedSource;
                                i = i2;
                                call6 = call7;
                                Logger.INSTANCE.e(TAG, String.valueOf(e));
                                if (e instanceof ProtocolException) {
                                }
                                progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                                AssetDownloadListener.DownloadError downloadError222222222 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                                if ((response2 != null ? response2.body() : null) != null) {
                                }
                                if (call3 != null) {
                                }
                                FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                                FileUtility.INSTANCE.closeQuietly(response);
                                Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                                status2 = progress.getStatus();
                                if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                                }
                                deliverError(downloadRequest, downloadListener, downloadError222222222);
                                downloadError = downloadError222222222;
                                Unit unit22222222 = Unit.INSTANCE;
                                str4 = str;
                                z3 = z;
                                z2 = z3;
                                i4 = -1;
                                response3 = null;
                            } catch (Throwable th10) {
                                th = th10;
                                str = str2;
                                call5 = bufferedSink;
                                call = call3;
                                response3 = response2;
                                call4 = call5;
                                if ((response3 == null ? response3.body() : null) != null) {
                                }
                                if (call != null) {
                                }
                                FileUtility.INSTANCE.closeQuietly((Closeable) call4);
                                FileUtility.INSTANCE.closeQuietly(bufferedSource);
                                Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                                status = progress.getStatus();
                                if (status != AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                                }
                                deliverError(downloadRequest, downloadListener, downloadError);
                                throw th;
                            }
                        } catch (Exception e14) {
                            e = e14;
                            str = str4;
                            z = true;
                            response = bufferedSource;
                            i = i2;
                            call6 = null;
                            Logger.INSTANCE.e(TAG, String.valueOf(e));
                            if (e instanceof ProtocolException) {
                            }
                            progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                            AssetDownloadListener.DownloadError downloadError2222222222 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                            if ((response2 != null ? response2.body() : null) != null) {
                            }
                            if (call3 != null) {
                            }
                            FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                            FileUtility.INSTANCE.closeQuietly(response);
                            Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                            status2 = progress.getStatus();
                            if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                            }
                            deliverError(downloadRequest, downloadListener, downloadError2222222222);
                            downloadError = downloadError2222222222;
                            Unit unit222222222 = Unit.INSTANCE;
                            str4 = str;
                            z3 = z;
                            z2 = z3;
                            i4 = -1;
                            response3 = null;
                        } catch (Throwable th11) {
                            th = th11;
                            str = str4;
                        }
                        try {
                            progress.setSizeBytes(j);
                            progress.setStartBytes(length);
                            while (true) {
                                long read = bufferedSource != null ? bufferedSource.read(bufferedSink.getBuffer(), PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) : -1L;
                                Unit unit8 = Unit.INSTANCE;
                                if (read <= 0) {
                                    break;
                                }
                                if (!file.exists()) {
                                    new AssetWriteError("Asset save error " + serverPath).setLogEntry$vungle_ads_release(downloadRequest.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                                    throw new Downloader.RequestException("File is not existing");
                                }
                                if (downloadRequest.isCancelled()) {
                                    progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getCANCELLED());
                                    break;
                                } else {
                                    progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getIN_PROGRESS());
                                    bufferedSink.emit();
                                }
                            }
                            bufferedSink.flush();
                            if (progress.getStatus() == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getIN_PROGRESS()) {
                                progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getDONE());
                            }
                            if ((response2 != null ? response2.body() : null) != null && (body3 = response2.body()) != null) {
                                body3.close();
                                Unit unit9 = Unit.INSTANCE;
                            }
                            if (call3 != null) {
                                call3.cancel();
                                Unit unit10 = Unit.INSTANCE;
                            }
                            FileUtility.INSTANCE.closeQuietly(bufferedSink);
                            FileUtility.INSTANCE.closeQuietly(bufferedSource);
                            str5 = str3;
                            Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                            int status3 = progress.getStatus();
                            if (status3 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR() || status3 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getSTARTED()) {
                                deliverError(downloadRequest, downloadListener, downloadError);
                                str = str2;
                            } else if (status3 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getCANCELLED()) {
                                str = str2;
                                Logger.INSTANCE.d(TAG, str + downloadRequest);
                            } else {
                                str = str2;
                                deliverSuccess(file, downloadRequest, downloadListener);
                            }
                        } catch (Exception e15) {
                            e = e15;
                            str = str2;
                            str5 = str3;
                            call7 = bufferedSink;
                            response = bufferedSource;
                            i = i2;
                            call6 = call7;
                            Logger.INSTANCE.e(TAG, String.valueOf(e));
                            if (e instanceof ProtocolException) {
                            }
                            progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                            AssetDownloadListener.DownloadError downloadError22222222222 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                            if ((response2 != null ? response2.body() : null) != null) {
                            }
                            if (call3 != null) {
                            }
                            FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                            FileUtility.INSTANCE.closeQuietly(response);
                            Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                            status2 = progress.getStatus();
                            if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                            }
                            deliverError(downloadRequest, downloadListener, downloadError22222222222);
                            downloadError = downloadError22222222222;
                            Unit unit2222222222 = Unit.INSTANCE;
                            str4 = str;
                            z3 = z;
                            z2 = z3;
                            i4 = -1;
                            response3 = null;
                        } catch (Throwable th12) {
                            th = th12;
                            str = str2;
                            str5 = str3;
                            call5 = bufferedSink;
                            call = call3;
                            response3 = response2;
                            call4 = call5;
                            if ((response3 == null ? response3.body() : null) != null) {
                            }
                            if (call != null) {
                            }
                            FileUtility.INSTANCE.closeQuietly((Closeable) call4);
                            FileUtility.INSTANCE.closeQuietly(bufferedSource);
                            Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                            status = progress.getStatus();
                            if (status != AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                            }
                            deliverError(downloadRequest, downloadListener, downloadError);
                            throw th;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        str = str4;
                        response2 = response3;
                    } catch (Throwable th13) {
                        th = th13;
                        str = str4;
                        call = call3;
                    }
                } catch (Exception e17) {
                    e = e17;
                    str = str4;
                    response2 = response3;
                    z = true;
                    i = i2;
                    response = null;
                    call6 = null;
                    Logger.INSTANCE.e(TAG, String.valueOf(e));
                    if (e instanceof ProtocolException) {
                    }
                    progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                    AssetDownloadListener.DownloadError downloadError222222222222 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                    if ((response2 != null ? response2.body() : null) != null) {
                    }
                    if (call3 != null) {
                    }
                    FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                    FileUtility.INSTANCE.closeQuietly(response);
                    Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                    status2 = progress.getStatus();
                    if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                    }
                    deliverError(downloadRequest, downloadListener, downloadError222222222222);
                    downloadError = downloadError222222222222;
                    Unit unit22222222222 = Unit.INSTANCE;
                    str4 = str;
                    z3 = z;
                    z2 = z3;
                    i4 = -1;
                    response3 = null;
                } catch (Throwable th14) {
                    th = th14;
                    str = str4;
                    call = call3;
                    bufferedSource = null;
                    call4 = null;
                    if ((response3 == null ? response3.body() : null) != null) {
                    }
                    if (call != null) {
                    }
                    FileUtility.INSTANCE.closeQuietly((Closeable) call4);
                    FileUtility.INSTANCE.closeQuietly(bufferedSource);
                    Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                    status = progress.getStatus();
                    if (status != AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                    }
                    deliverError(downloadRequest, downloadListener, downloadError);
                    throw th;
                }
                Unit unit222222222222 = Unit.INSTANCE;
                str4 = str;
                z3 = z;
                z2 = z3;
                i4 = -1;
                response3 = null;
            } else {
                str = str4;
                response2 = response3;
                call3 = call;
                z = true;
                try {
                    try {
                        new AssetFailedStatusCodeError(serverPath, Integer.valueOf(i), "Asset download does not success: " + response2.message()).setLogEntry$vungle_ads_release(downloadRequest.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
                        i3 = i;
                        try {
                            throw new Downloader.RequestException("Code: " + i3);
                        } catch (Exception e18) {
                            e = e18;
                            i = i3;
                            response = null;
                            call6 = null;
                            Logger.INSTANCE.e(TAG, String.valueOf(e));
                            if (e instanceof ProtocolException) {
                            }
                            progress.setStatus(AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR());
                            AssetDownloadListener.DownloadError downloadError2222222222222 = new AssetDownloadListener.DownloadError(i, e, AssetDownloadListener.DownloadError.ErrorReason.INSTANCE.getREQUEST_ERROR());
                            if ((response2 != null ? response2.body() : null) != null) {
                                body2.close();
                                Unit unit62 = Unit.INSTANCE;
                            }
                            if (call3 != null) {
                            }
                            FileUtility.INSTANCE.closeQuietly((Closeable) call6);
                            FileUtility.INSTANCE.closeQuietly(response);
                            Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                            status2 = progress.getStatus();
                            if (status2 == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR()) {
                                if (status2 != AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getCANCELLED()) {
                                }
                                downloadError = downloadError2222222222222;
                                Unit unit2222222222222 = Unit.INSTANCE;
                                str4 = str;
                                z3 = z;
                                z2 = z3;
                                i4 = -1;
                                response3 = null;
                            }
                            deliverError(downloadRequest, downloadListener, downloadError2222222222222);
                            downloadError = downloadError2222222222222;
                            Unit unit22222222222222 = Unit.INSTANCE;
                            str4 = str;
                            z3 = z;
                            z2 = z3;
                            i4 = -1;
                            response3 = null;
                        }
                    } catch (Throwable th15) {
                        th = th15;
                        call = call3;
                        response3 = response2;
                        bufferedSource = null;
                        call4 = null;
                        if ((response3 == null ? response3.body() : null) != null && (body = response3.body()) != null) {
                            body.close();
                            Unit unit52 = Unit.INSTANCE;
                        }
                        if (call != null) {
                            call.cancel();
                            Unit unit11 = Unit.INSTANCE;
                        }
                        FileUtility.INSTANCE.closeQuietly((Closeable) call4);
                        FileUtility.INSTANCE.closeQuietly(bufferedSource);
                        Logger.INSTANCE.d(TAG, str5 + progress.getStatus());
                        status = progress.getStatus();
                        if (status != AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getERROR() || status == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getSTARTED()) {
                            deliverError(downloadRequest, downloadListener, downloadError);
                        } else if (status == AssetDownloadListener.Progress.ProgressStatus.INSTANCE.getCANCELLED()) {
                            Logger.INSTANCE.d(TAG, str + downloadRequest);
                        } else {
                            deliverSuccess(file, downloadRequest, downloadListener);
                        }
                        throw th;
                    }
                } catch (Exception e19) {
                    e = e19;
                    i3 = i;
                }
            }
        }
    }

    private final ResponseBody decodeGzipIfNeeded(Response networkResponse) {
        ResponseBody body = networkResponse.body();
        if (!StringsKt.equals(GZIP, Response.header$default(networkResponse, "Content-Encoding", null, 2, null), true) || body == null) {
            return body;
        }
        return new RealResponseBody(Response.header$default(networkResponse, "Content-Type", null, 2, null), -1L, Okio.buffer(new GzipSource(body.getDelegateSource())));
    }

    private final void deliverSuccess(File file, DownloadRequest downloadRequest, AssetDownloadListener listener) {
        Logger.INSTANCE.d(TAG, "On success " + downloadRequest);
        if (listener != null) {
            listener.onSuccess(file, downloadRequest);
        }
    }

    private final boolean checkSpaceAvailable(DownloadRequest downloadRequest) {
        PathProvider pathProvider = this.pathProvider;
        String absolutePath = pathProvider.getVungleDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "pathProvider.getVungleDir().absolutePath");
        long availableBytes = pathProvider.getAvailableBytes(absolutePath);
        if (availableBytes >= ServiceProvider.HTTP_CACHE_DISK_SIZE) {
            return true;
        }
        new NoSpaceError("Insufficient space " + availableBytes).setLogEntry$vungle_ads_release(downloadRequest.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
        return false;
    }

    private final boolean isValidUrl(String httpUrl) {
        String str = httpUrl;
        return (str == null || str.length() == 0 || HttpUrl.INSTANCE.parse(httpUrl) == null) ? false : true;
    }
}
