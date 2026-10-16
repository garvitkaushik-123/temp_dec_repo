package io.adn.sdk.internal.data.api.local;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.common.utils.TaskKt;
import io.adn.sdk.internal.domain.model.privacy.AdvertisingInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: AdvertisingIdsApi.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0002\u0010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0082@¢\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApiImpl;", "Lio/adn/sdk/internal/data/api/local/AdvertisingIdsApi;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "advertisingInfo", "Lio/adn/sdk/internal/domain/model/privacy/AdvertisingInfo;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getAdvertisingInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "advertisingIdInfo", "Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;", "appSetIdInfo", "Lcom/google/android/gms/appset/AppSetIdInfo;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdvertisingIdsApiImpl implements AdvertisingIdsApi {
    public static final int $stable = 8;
    private AdvertisingInfo advertisingInfo;
    private final Context context;
    private final CoroutineScope scope;

    public AdvertisingIdsApiImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.scope = CoroutineScope;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    public final Context getContext() {
        return this.context;
    }

    /* compiled from: AdvertisingIdsApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.adn.sdk.internal.data.api.local.AdvertisingIdsApiImpl$1", f = "AdvertisingIdsApi.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.adn.sdk.internal.data.api.local.AdvertisingIdsApiImpl$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AdvertisingIdsApiImpl.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AdvertisingIdsApiImpl.this.getAdvertisingInfo(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.adn.sdk.internal.data.api.local.AdvertisingIdsApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getAdvertisingInfo(Continuation<? super AdvertisingInfo> continuation) {
        AdvertisingIdsApiImpl$getAdvertisingInfo$1 advertisingIdsApiImpl$getAdvertisingInfo$1;
        int i;
        AdvertisingIdsApiImpl advertisingIdsApiImpl;
        AdvertisingIdClient.Info info;
        AppSetIdInfo appSetIdInfo;
        if (continuation instanceof AdvertisingIdsApiImpl$getAdvertisingInfo$1) {
            advertisingIdsApiImpl$getAdvertisingInfo$1 = (AdvertisingIdsApiImpl$getAdvertisingInfo$1) continuation;
            if ((advertisingIdsApiImpl$getAdvertisingInfo$1.label & Integer.MIN_VALUE) != 0) {
                advertisingIdsApiImpl$getAdvertisingInfo$1.label -= Integer.MIN_VALUE;
                Object obj = advertisingIdsApiImpl$getAdvertisingInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = advertisingIdsApiImpl$getAdvertisingInfo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.advertisingInfo == null) {
                        AdvertisingIdClient.Info advertisingIdInfo = advertisingIdInfo();
                        advertisingIdsApiImpl$getAdvertisingInfo$1.L$0 = this;
                        advertisingIdsApiImpl$getAdvertisingInfo$1.L$1 = advertisingIdInfo;
                        advertisingIdsApiImpl$getAdvertisingInfo$1.label = 1;
                        Object appSetIdInfo2 = appSetIdInfo(advertisingIdsApiImpl$getAdvertisingInfo$1);
                        if (appSetIdInfo2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        info = advertisingIdInfo;
                        obj = appSetIdInfo2;
                        advertisingIdsApiImpl = this;
                    } else {
                        advertisingIdsApiImpl = this;
                        return advertisingIdsApiImpl.advertisingInfo;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    info = (AdvertisingIdClient.Info) advertisingIdsApiImpl$getAdvertisingInfo$1.L$1;
                    advertisingIdsApiImpl = (AdvertisingIdsApiImpl) advertisingIdsApiImpl$getAdvertisingInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                appSetIdInfo = (AppSetIdInfo) obj;
                if (info == null || appSetIdInfo != null) {
                    advertisingIdsApiImpl.advertisingInfo = new AdvertisingInfo(info == null ? info.getId() : null, appSetIdInfo == null ? appSetIdInfo.getId() : null, appSetIdInfo == null ? Boxing.boxInt(appSetIdInfo.getScope()) : null, info != null ? Boxing.boxBoolean(info.isLimitAdTrackingEnabled()) : null);
                }
                return advertisingIdsApiImpl.advertisingInfo;
            }
        }
        advertisingIdsApiImpl$getAdvertisingInfo$1 = new AdvertisingIdsApiImpl$getAdvertisingInfo$1(this, continuation);
        Object obj2 = advertisingIdsApiImpl$getAdvertisingInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = advertisingIdsApiImpl$getAdvertisingInfo$1.label;
        if (i != 0) {
        }
        appSetIdInfo = (AppSetIdInfo) obj2;
        if (info == null) {
        }
        advertisingIdsApiImpl.advertisingInfo = new AdvertisingInfo(info == null ? info.getId() : null, appSetIdInfo == null ? appSetIdInfo.getId() : null, appSetIdInfo == null ? Boxing.boxInt(appSetIdInfo.getScope()) : null, info != null ? Boxing.boxBoolean(info.isLimitAdTrackingEnabled()) : null);
        return advertisingIdsApiImpl.advertisingInfo;
    }

    private final AdvertisingIdClient.Info advertisingIdInfo() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AdvertisingIdsApiImpl advertisingIdsApiImpl = this;
            m10241constructorimpl = Result.m10241constructorimpl(AdvertisingIdClient.getAdvertisingIdInfo(this.context));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            Logger.INSTANCE.e("AdvertisingDataService", m10244exceptionOrNullimpl);
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = null;
        }
        return (AdvertisingIdClient.Info) m10241constructorimpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(2:3|(9:5|6|7|(1:(1:10)(2:21|22))(3:23|24|(1:26))|11|12|(1:14)|15|(1:17)(1:19)))|29|6|7|(0)(0)|11|12|(0)|15|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r5 = kotlin.Result.m10241constructorimpl(kotlin.ResultKt.createFailure(r5));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0077 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object appSetIdInfo(Continuation<? super AppSetIdInfo> continuation) {
        AdvertisingIdsApiImpl$appSetIdInfo$1 advertisingIdsApiImpl$appSetIdInfo$1;
        int i;
        Object m10241constructorimpl;
        Throwable m10244exceptionOrNullimpl;
        if (continuation instanceof AdvertisingIdsApiImpl$appSetIdInfo$1) {
            advertisingIdsApiImpl$appSetIdInfo$1 = (AdvertisingIdsApiImpl$appSetIdInfo$1) continuation;
            if ((advertisingIdsApiImpl$appSetIdInfo$1.label & Integer.MIN_VALUE) != 0) {
                advertisingIdsApiImpl$appSetIdInfo$1.label -= Integer.MIN_VALUE;
                Object obj = advertisingIdsApiImpl$appSetIdInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = advertisingIdsApiImpl$appSetIdInfo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion = Result.INSTANCE;
                    AdvertisingIdsApiImpl advertisingIdsApiImpl = this;
                    Task<AppSetIdInfo> appSetIdInfo = AppSet.getClient(this.context).getAppSetIdInfo();
                    Intrinsics.checkNotNullExpressionValue(appSetIdInfo, "getAppSetIdInfo(...)");
                    advertisingIdsApiImpl$appSetIdInfo$1.label = 1;
                    obj = TaskKt.await(appSetIdInfo, advertisingIdsApiImpl$appSetIdInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                m10241constructorimpl = Result.m10241constructorimpl((AppSetIdInfo) obj);
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl != null) {
                    Logger.INSTANCE.e("AdvertisingDataService", m10244exceptionOrNullimpl);
                }
                if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                    return m10241constructorimpl;
                }
                return null;
            }
        }
        advertisingIdsApiImpl$appSetIdInfo$1 = new AdvertisingIdsApiImpl$appSetIdInfo$1(this, continuation);
        Object obj2 = advertisingIdsApiImpl$appSetIdInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = advertisingIdsApiImpl$appSetIdInfo$1.label;
        if (i != 0) {
        }
        m10241constructorimpl = Result.m10241constructorimpl((AppSetIdInfo) obj2);
        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
        }
    }
}
