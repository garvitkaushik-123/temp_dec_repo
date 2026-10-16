package com.vungle.ads.internal.network;

import com.vungle.ads.TpatError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.ErrorInfo;
import com.vungle.ads.internal.network.TpatRequest;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.AdActivity;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.text.Regex;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* compiled from: TpatSender.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001-B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0007J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017H\u0002J(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\r\u0010'\u001a\u00020\u001fH\u0000¢\u0006\u0002\b(J\u001c\u0010)\u001a\u00020\u001f2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0002J\u0018\u0010+\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010,\u001a\u00020\u001cR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Lcom/vungle/ads/internal/network/TpatSender;", "", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "ioExecutor", "Ljava/util/concurrent/Executor;", "jobExecutor", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "signalManager", "Lcom/vungle/ads/internal/signals/SignalManager;", "(Lcom/vungle/ads/internal/network/VungleApiClient;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/vungle/ads/internal/util/PathProvider;Lcom/vungle/ads/internal/signals/SignalManager;)V", "getJobExecutor", "()Ljava/util/concurrent/Executor;", "getSignalManager", "()Lcom/vungle/ads/internal/signals/SignalManager;", "tpatFilePreferences", "Lcom/vungle/ads/internal/persistence/FilePreferences;", "tpatLock", "getVungleApiClient", "()Lcom/vungle/ads/internal/network/VungleApiClient;", "getStoredTpats", "", "", "Lcom/vungle/ads/internal/network/FailedTpat;", "injectSessionIdToUrl", "url", "isPriorityTpat", "", "event", "logTpatError", "", AdActivity.REQUEST_KEY_EXTRA, "Lcom/vungle/ads/internal/network/TpatRequest;", "error", "Lcom/vungle/ads/internal/model/ErrorInfo;", "reason", "Lcom/vungle/ads/internal/protos/Sdk$SDKError$Reason;", "performPriorityRetry", "resendStoredTpats", "resendStoredTpats$vungle_ads_release", "saveStoredTpats", "tpats", "sendTpat", "fromFailedTpat", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class TpatSender {
    private static final String FAILED_TPATS = "FAILED_TPATS";
    private static final String TAG = "TpatSender";
    private final Executor jobExecutor;
    private final SignalManager signalManager;
    private final FilePreferences tpatFilePreferences;
    private final Object tpatLock;
    private final VungleApiClient vungleApiClient;

    public TpatSender(VungleApiClient vungleApiClient, Executor ioExecutor, Executor jobExecutor, PathProvider pathProvider, SignalManager signalManager) {
        Intrinsics.checkNotNullParameter(vungleApiClient, "vungleApiClient");
        Intrinsics.checkNotNullParameter(ioExecutor, "ioExecutor");
        Intrinsics.checkNotNullParameter(jobExecutor, "jobExecutor");
        Intrinsics.checkNotNullParameter(pathProvider, "pathProvider");
        this.vungleApiClient = vungleApiClient;
        this.jobExecutor = jobExecutor;
        this.signalManager = signalManager;
        this.tpatFilePreferences = FilePreferences.INSTANCE.get(ioExecutor, pathProvider, FilePreferences.TPAT_FAILED_FILENAME);
        this.tpatLock = new Object();
    }

    public /* synthetic */ TpatSender(VungleApiClient vungleApiClient, Executor executor, Executor executor2, PathProvider pathProvider, SignalManager signalManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(vungleApiClient, executor, executor2, pathProvider, (i & 16) != 0 ? null : signalManager);
    }

    public final VungleApiClient getVungleApiClient() {
        return this.vungleApiClient;
    }

    public final Executor getJobExecutor() {
        return this.jobExecutor;
    }

    public final SignalManager getSignalManager() {
        return this.signalManager;
    }

    public static /* synthetic */ void sendTpat$default(TpatSender tpatSender, TpatRequest tpatRequest, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        tpatSender.sendTpat(tpatRequest, z);
    }

    public final void sendTpat(final TpatRequest request, final boolean fromFailedTpat) {
        Intrinsics.checkNotNullParameter(request, "request");
        final String injectSessionIdToUrl = injectSessionIdToUrl(request.getUrl());
        this.jobExecutor.execute(new Runnable() { // from class: com.vungle.ads.internal.network.TpatSender$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TpatSender.m9362sendTpat$lambda1(TpatSender.this, request, injectSessionIdToUrl, fromFailedTpat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendTpat$lambda-1, reason: not valid java name */
    public static final void m9362sendTpat$lambda1(TpatSender this$0, TpatRequest request, String urlWithSessionId, boolean z) {
        FailedTpat failedTpat;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(urlWithSessionId, "$urlWithSessionId");
        ErrorInfo performPriorityRetry = this$0.performPriorityRetry(request, urlWithSessionId);
        if (request.getRegularRetry()) {
            if (performPriorityRetry == null || !performPriorityRetry.getErrorIsTerminal()) {
                if (performPriorityRetry != null || z) {
                    synchronized (this$0.tpatLock) {
                        Map<String, FailedTpat> storedTpats = this$0.getStoredTpats();
                        FailedTpat failedTpat2 = storedTpats.get(request.getUrl());
                        int retryAttempt = failedTpat2 != null ? failedTpat2.getRetryAttempt() : 0;
                        if (performPriorityRetry == null && retryAttempt > 0) {
                            storedTpats.remove(request.getUrl());
                            this$0.saveStoredTpats(storedTpats);
                        } else if (performPriorityRetry != null && retryAttempt >= request.getRegularRetryCount()) {
                            storedTpats.remove(request.getUrl());
                            this$0.saveStoredTpats(storedTpats);
                            this$0.logTpatError(request, urlWithSessionId, performPriorityRetry, Sdk.SDKError.Reason.TPAT_RETRY_FAILED);
                        } else if (performPriorityRetry != null) {
                            FailedTpat failedTpat3 = storedTpats.get(request.getUrl());
                            if (failedTpat3 == null || (failedTpat = FailedTpat.copy$default(failedTpat3, null, null, null, retryAttempt + 1, 0, null, 55, null)) == null) {
                                failedTpat = new FailedTpat(request.getMethod(), request.getHeaders(), request.getBody(), 1, request.getRegularRetryCount(), request.getTpatKey());
                            }
                            storedTpats.put(request.getUrl(), failedTpat);
                            this$0.saveStoredTpats(storedTpats);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
    }

    private final boolean isPriorityTpat(String event) {
        return Intrinsics.areEqual(event, Constants.CHECKPOINT_0) || Intrinsics.areEqual(event, "clickUrl") || Intrinsics.areEqual(event, "impression") || Intrinsics.areEqual(event, Constants.LOAD_AD);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        if (r2 < r11.getPriorityRetryCount()) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        r0 = com.vungle.ads.internal.protos.Sdk.SDKError.Reason.TPAT_RETRY_FAILED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        logTpatError(r11, r5, r12, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
    
        r0 = com.vungle.ads.internal.protos.Sdk.SDKError.Reason.TPAT_ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ErrorInfo performPriorityRetry(TpatRequest request, String url) {
        ErrorInfo pingTPAT;
        Boolean priorityRetry = request.getPriorityRetry();
        int i = 0;
        boolean z = ConfigManager.INSTANCE.retryPriorityTPATs() && (priorityRetry != null ? priorityRetry.booleanValue() : isPriorityTpat(request.getTpatKey()));
        while (true) {
            String str = url;
            pingTPAT = this.vungleApiClient.pingTPAT(str, request.getHeaders(), request.getBody(), request.getMethod(), request.getLogEntry());
            if (!z || pingTPAT == null || !pingTPAT.isRetryCode() || (i = i + 1) >= request.getPriorityRetryCount()) {
                break;
            }
            url = str;
        }
        return pingTPAT;
    }

    private final void logTpatError(TpatRequest request, String url, ErrorInfo error, Sdk.SDKError.Reason reason) {
        String str = "tpat key: " + request.getTpatKey() + ", error: " + error.getDescription() + ", errorIsTerminal: " + error.getErrorIsTerminal() + " url: " + url;
        Logger.INSTANCE.e(TAG, str);
        new TpatError(reason, str).setLogEntry$vungle_ads_release(request.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
    }

    private final Map<String, FailedTpat> getStoredTpats() {
        LinkedHashMap m10241constructorimpl;
        String string = this.tpatFilePreferences.getString(FAILED_TPATS);
        if (string != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                TpatSender tpatSender = this;
                Json.Companion companion2 = Json.INSTANCE;
                KSerializer<Object> serializer = SerializersKt.serializer(companion2.getSerializersModule(), Reflection.mutableCollectionType(Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(FailedTpat.class)))));
                Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                m10241constructorimpl = Result.m10241constructorimpl((Map) companion2.decodeFromString(serializer, string));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
            if (m10244exceptionOrNullimpl != null) {
                Logger.INSTANCE.e(TAG, "Failed to decode stored tpats: " + m10244exceptionOrNullimpl);
            }
            if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) != null) {
                m10241constructorimpl = new LinkedHashMap();
            }
            Map<String, FailedTpat> map = (Map) m10241constructorimpl;
            if (map != null) {
                return map;
            }
        }
        return new LinkedHashMap();
    }

    private final void saveStoredTpats(Map<String, FailedTpat> tpats) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            TpatSender tpatSender = this;
            FilePreferences filePreferences = this.tpatFilePreferences;
            Json.Companion companion2 = Json.INSTANCE;
            KSerializer<Object> serializer = SerializersKt.serializer(companion2.getSerializersModule(), Reflection.mutableCollectionType(Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(FailedTpat.class)))));
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            filePreferences.put(FAILED_TPATS, companion2.encodeToString(serializer, tpats)).apply();
            m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10244exceptionOrNullimpl(m10241constructorimpl) != null) {
            Logger.INSTANCE.e(TAG, "Failed to encode the about to storing tpats: " + tpats);
        }
    }

    public final void resendStoredTpats$vungle_ads_release() {
        for (Map.Entry<String, FailedTpat> entry : getStoredTpats().entrySet()) {
            String key = entry.getKey();
            FailedTpat value = entry.getValue();
            sendTpat(new TpatRequest.Builder(key).regularRetry(true).priorityRetry(false).headers(value.getHeaders()).body(value.getBody()).regularRetryCount(value.getRetryCount()).method(value.getMethod()).tpatKey(value.getTpatKey()).build(), true);
        }
    }

    public final String injectSessionIdToUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        SignalManager signalManager = this.signalManager;
        String uuid = signalManager != null ? signalManager.getUuid() : null;
        if (uuid == null) {
            uuid = "";
        }
        if (uuid.length() <= 0) {
            return url;
        }
        String quote = Pattern.quote(Constants.SESSION_ID);
        Intrinsics.checkNotNullExpressionValue(quote, "quote(Constants.SESSION_ID)");
        return new Regex(quote).replace(url, uuid);
    }
}
