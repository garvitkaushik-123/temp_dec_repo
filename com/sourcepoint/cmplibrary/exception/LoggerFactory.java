package com.sourcepoint.cmplibrary.exception;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* compiled from: LoggerImpl.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001aÈ\u0001\u0010\b\u001a\u00020\u000126\u0010\t\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n26\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\u0012"}, d2 = {"createLogger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "networkClient", "Lokhttp3/OkHttpClient;", "errorMessageManager", "Lcom/sourcepoint/cmplibrary/exception/ErrorMessageManager;", "url", "", "createLogger4Testing", "info", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "tag", NotificationCompat.CATEGORY_MESSAGE, "", "debug", "verbose", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoggerFactory {
    public static final Logger createLogger(OkHttpClient networkClient, ErrorMessageManager errorMessageManager, String url) {
        Intrinsics.checkNotNullParameter(networkClient, "networkClient");
        Intrinsics.checkNotNullParameter(errorMessageManager, "errorMessageManager");
        Intrinsics.checkNotNullParameter(url, "url");
        return new LoggerImpl(networkClient, errorMessageManager, url);
    }

    public static final Logger createLogger4Testing(Function2<? super String, ? super String, Unit> info, Function2<? super String, ? super String, Unit> debug, Function2<? super String, ? super String, Unit> verbose, OkHttpClient networkClient, ErrorMessageManager errorMessageManager, String url) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(debug, "debug");
        Intrinsics.checkNotNullParameter(verbose, "verbose");
        Intrinsics.checkNotNullParameter(networkClient, "networkClient");
        Intrinsics.checkNotNullParameter(errorMessageManager, "errorMessageManager");
        Intrinsics.checkNotNullParameter(url, "url");
        return new LoggerImpl(networkClient, errorMessageManager, url);
    }
}
