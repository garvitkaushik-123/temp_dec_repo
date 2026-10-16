package io.bidmachine.analytics;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import io.bidmachine.analytics.internal.AbstractC3565e;
import io.bidmachine.analytics.internal.C;
import io.bidmachine.analytics.internal.C3561a;
import io.bidmachine.analytics.internal.C3571k;
import io.bidmachine.analytics.internal.C3573m;
import io.bidmachine.analytics.internal.C3578s;
import java.util.Map;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u000b\u0010\u000fJ/\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00120\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0019\u0010\u000fR!\u0010 \u001a\u00020\u001b8@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001c\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00138\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006."}, d2 = {"Lio/bidmachine/analytics/BidMachineAnalytics;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", MobileAdsBridgeBase.initializeMethodName, "(Landroid/content/Context;)V", "Lio/bidmachine/analytics/AnalyticsConfig;", "analyticsConfig", "configure", "(Landroid/content/Context;Lio/bidmachine/analytics/AnalyticsConfig;)V", "Lio/bidmachine/analytics/ConfigureListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Landroid/content/Context;Lio/bidmachine/analytics/AnalyticsConfig;Lio/bidmachine/analytics/ConfigureListener;)V", "", "typeId", "", "", "getImpData", "(I)Ljava/util/Map;", "", "outPublicKey", "Lio/bidmachine/analytics/internal/s;", "a", "([B)Lio/bidmachine/analytics/internal/s;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Lazy;", "getScope$bidmachine_android_sdk_bg_3_4_0", "()Lkotlinx/coroutines/CoroutineScope;", "getScope$bidmachine_android_sdk_bg_3_4_0$annotations", "scope", "<set-?>", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getSessionId$bidmachine_android_sdk_bg_3_4_0", "()Ljava/lang/String;", JsonStorageKeyNames.SESSION_ID_KEY, "c", "Lio/bidmachine/analytics/internal/s;", "getEncryptionManager$bidmachine_android_sdk_bg_3_4_0", "()Lio/bidmachine/analytics/internal/s;", "setEncryptionManager$bidmachine_android_sdk_bg_3_4_0", "(Lio/bidmachine/analytics/internal/s;)V", "encryptionManager", "bidmachine-android-sdk_bg_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class BidMachineAnalytics {
    public static final BidMachineAnalytics INSTANCE = new BidMachineAnalytics();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy scope = LazyKt.lazy(b.f6648a);

    /* renamed from: b, reason: from kotlin metadata */
    private static String sessionId = "";

    /* renamed from: c, reason: from kotlin metadata */
    private static C3578s encryptionManager;

    static final class a extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        int f6647a;
        private /* synthetic */ Object b;
        final /* synthetic */ AnalyticsConfig c;
        final /* synthetic */ String d;
        final /* synthetic */ Context e;
        final /* synthetic */ ConfigureListener f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AnalyticsConfig analyticsConfig, String str, Context context, ConfigureListener configureListener, Continuation continuation) {
            super(2, continuation);
            this.c = analyticsConfig;
            this.d = str;
            this.e = context;
            this.f = configureListener;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            a aVar = new a(this.c, this.d, this.e, this.f, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object m10241constructorimpl;
            Object m10241constructorimpl2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6647a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AnalyticsConfig analyticsConfig = this.c;
            try {
                Result.Companion companion = Result.INSTANCE;
                BidMachineAnalytics bidMachineAnalytics = BidMachineAnalytics.INSTANCE;
                bidMachineAnalytics.setEncryptionManager$bidmachine_android_sdk_bg_3_4_0(bidMachineAnalytics.a(Base64.decode(analyticsConfig.getBpk(), 2)));
                m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
            }
            Result.m10244exceptionOrNullimpl(m10241constructorimpl);
            Context context = this.e;
            AnalyticsConfig analyticsConfig2 = this.c;
            ConfigureListener configureListener = this.f;
            try {
                Result.Companion companion3 = Result.INSTANCE;
                BidMachineAnalytics.INSTANCE.a(context, analyticsConfig2, configureListener);
                m10241constructorimpl2 = Result.m10241constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                m10241constructorimpl2 = Result.m10241constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m10248isSuccessimpl(m10241constructorimpl2)) {
            }
            Result.m10244exceptionOrNullimpl(m10241constructorimpl2);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f6648a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(ExecutorsKt.from(Executors.newSingleThreadExecutor())));
        }
    }

    private BidMachineAnalytics() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3578s a(byte[] outPublicKey) {
        C3561a c3561a = new C3561a();
        return new C3578s(c3561a, new C(outPublicKey, c3561a.getName(), null, false, 12, null));
    }

    @JvmStatic
    public static final void configure(Context context, AnalyticsConfig analyticsConfig) {
        configure(context, analyticsConfig, null);
    }

    @JvmStatic
    public static final Map<String, Map<String, Object>> getImpData(int typeId) {
        AbstractC3565e.a aVar = (AbstractC3565e.a) ArraysKt.getOrNull(AbstractC3565e.a.values(), typeId);
        return aVar == null ? MapsKt.emptyMap() : C3571k.f6712a.a(aVar);
    }

    public static /* synthetic */ void getScope$bidmachine_android_sdk_bg_3_4_0$annotations() {
    }

    @JvmStatic
    public static final void initialize(Context context) {
        C3571k.f6712a.b(context.getApplicationContext());
    }

    public final C3578s getEncryptionManager$bidmachine_android_sdk_bg_3_4_0() {
        return encryptionManager;
    }

    public final CoroutineScope getScope$bidmachine_android_sdk_bg_3_4_0() {
        return (CoroutineScope) scope.getValue();
    }

    public final String getSessionId$bidmachine_android_sdk_bg_3_4_0() {
        return sessionId;
    }

    public final void setEncryptionManager$bidmachine_android_sdk_bg_3_4_0(C3578s c3578s) {
        encryptionManager = c3578s;
    }

    @JvmStatic
    public static final void configure(Context context, AnalyticsConfig analyticsConfig, ConfigureListener listener) {
        String str = analyticsConfig.getCom.unity3d.services.core.device.reader.JsonStorageKeyNames.SESSION_ID_KEY java.lang.String();
        sessionId = str;
        initialize(context);
        BuildersKt__Builders_commonKt.launch$default(INSTANCE.getScope$bidmachine_android_sdk_bg_3_4_0(), null, null, new a(analyticsConfig, str, context.getApplicationContext(), listener, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Context context, AnalyticsConfig analyticsConfig, ConfigureListener listener) {
        C3573m.f6718a.a(context, analyticsConfig);
        C3571k.f6712a.a(context, analyticsConfig);
        if (listener != null) {
            listener.onConfigured();
        }
    }
}
