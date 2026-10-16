package com.unity3d.ads.core.domain.om;

import android.content.Context;
import com.unity3d.ads.core.data.model.OMResult;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;

/* compiled from: AndroidInitializeOMSDK.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/unity3d/ads/core/domain/om/AndroidInitializeOMSDK;", "Lcom/unity3d/ads/core/domain/om/InitializeOMSDK;", "context", "Landroid/content/Context;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "omRepository", "Lcom/unity3d/ads/core/data/repository/OpenMeasurementRepository;", "(Landroid/content/Context;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/OpenMeasurementRepository;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidInitializeOMSDK implements InitializeOMSDK {
    private final Context context;
    private final OpenMeasurementRepository omRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    public AndroidInitializeOMSDK(Context context, SendDiagnosticEvent sendDiagnosticEvent, SessionRepository sessionRepository, OpenMeasurementRepository omRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(omRepository, "omRepository");
        this.context = context;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.sessionRepository = sessionRepository;
        this.omRepository = omRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.unity3d.ads.core.domain.om.InitializeOMSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(Continuation<? super Unit> continuation) {
        AndroidInitializeOMSDK$invoke$1 androidInitializeOMSDK$invoke$1;
        int i;
        AndroidInitializeOMSDK androidInitializeOMSDK;
        long j;
        OMResult oMResult;
        if (continuation instanceof AndroidInitializeOMSDK$invoke$1) {
            androidInitializeOMSDK$invoke$1 = (AndroidInitializeOMSDK$invoke$1) continuation;
            if ((androidInitializeOMSDK$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidInitializeOMSDK$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = androidInitializeOMSDK$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidInitializeOMSDK$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.sessionRepository.isOmEnabled()) {
                        long m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "om_activate_started", null, null, null, null, null, 62, null);
                        OpenMeasurementRepository openMeasurementRepository = this.omRepository;
                        Context context = this.context;
                        androidInitializeOMSDK$invoke$1.L$0 = this;
                        androidInitializeOMSDK$invoke$1.J$0 = m11706markNowz9LOYto;
                        androidInitializeOMSDK$invoke$1.label = 1;
                        obj = openMeasurementRepository.activateOM(context, androidInitializeOMSDK$invoke$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        androidInitializeOMSDK = this;
                        j = m11706markNowz9LOYto;
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = androidInitializeOMSDK$invoke$1.J$0;
                androidInitializeOMSDK = (AndroidInitializeOMSDK) androidInitializeOMSDK$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                oMResult = (OMResult) obj;
                if (!(oMResult instanceof OMResult.Success)) {
                    SendDiagnosticEvent.DefaultImpls.invoke$default(androidInitializeOMSDK.sendDiagnosticEvent, "om_activate_success_time", Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j))), null, null, null, null, 60, null);
                } else if (oMResult instanceof OMResult.Failure) {
                    SendDiagnosticEvent sendDiagnosticEvent = androidInitializeOMSDK.sendDiagnosticEvent;
                    Double boxDouble = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j)));
                    Map createMapBuilder = MapsKt.createMapBuilder();
                    OMResult.Failure failure = (OMResult.Failure) oMResult;
                    createMapBuilder.put("reason", failure.getReason());
                    if (failure.getReasonDebug() != null) {
                        createMapBuilder.put("reason_debug", failure.getReasonDebug());
                    }
                    Unit unit = Unit.INSTANCE;
                    SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "om_activate_failure_time", boxDouble, MapsKt.build(createMapBuilder), null, null, null, 56, null);
                }
                return Unit.INSTANCE;
            }
        }
        androidInitializeOMSDK$invoke$1 = new AndroidInitializeOMSDK$invoke$1(this, continuation);
        Object obj2 = androidInitializeOMSDK$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidInitializeOMSDK$invoke$1.label;
        if (i != 0) {
        }
        oMResult = (OMResult) obj2;
        if (!(oMResult instanceof OMResult.Success)) {
        }
        return Unit.INSTANCE;
    }
}
