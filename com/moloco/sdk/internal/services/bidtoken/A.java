package com.moloco.sdk.internal.services.bidtoken;

import android.os.Build;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.J;
import com.moloco.sdk.service_locator.a;
import io.ktor.client.HttpClient;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes6.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f5624a = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.services.bidtoken.A$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return A.a();
        }
    });

    public static final z a() {
        String str;
        String str2;
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "ServerBidTokenService", "Creating BidTokenService instance", null, false, 12, null);
        a.e eVar = a.e.f5753a;
        HttpClient a2 = com.moloco.sdk.internal.http.a.a(eVar.h().invoke(), eVar.l().invoke());
        j jVar = new j(2800L, 3, 200L);
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        String str3 = Build.MANUFACTURER;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = Build.MODEL;
        if (str4 == null) {
            str4 = "";
        }
        String str5 = Build.HARDWARE;
        if (str5 == null) {
            String str6 = str4;
            str2 = "";
            str = str6;
        } else {
            str = str4;
            str2 = str5;
        }
        return new z(new c(BuildConfig.SDK_VERSION_NAME, a2, jVar, new g(language, RELEASE, str3, str, str2)), CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(com.moloco.sdk.internal.scheduling.b.a().getIo())), v.f5660a.a(new com.moloco.sdk.internal.bidtoken.c(), new J()));
    }

    public static final z c() {
        return (z) f5624a.getValue();
    }
}
