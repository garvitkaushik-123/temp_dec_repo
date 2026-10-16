package com.unity3d.ads.core.domain.scar;

import com.google.protobuf.ByteString;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.core.data.manager.ScarManager;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.ads.gmascar.models.BiddingSignals;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import java.util.List;
import java.util.Map;
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
import kotlin.time.TimeSource;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidFetchSignalsAndSendUseCase.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.scar.AndroidFetchSignalsAndSendUseCase$invoke$2", f = "AndroidFetchSignalsAndSendUseCase.kt", i = {0, 1}, l = {36, 56}, m = "invokeSuspend", n = {"startTime", "uploadStartTime"}, s = {"J$0", "J$0"})
/* loaded from: classes7.dex */
final class AndroidFetchSignalsAndSendUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TokenConfiguration $tokenConfiguration;
    final /* synthetic */ ByteString $tokenId;
    final /* synthetic */ int $tokenNumber;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidFetchSignalsAndSendUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidFetchSignalsAndSendUseCase$invoke$2(AndroidFetchSignalsAndSendUseCase androidFetchSignalsAndSendUseCase, TokenConfiguration tokenConfiguration, int i, ByteString byteString, Continuation<? super AndroidFetchSignalsAndSendUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = androidFetchSignalsAndSendUseCase;
        this.$tokenConfiguration = tokenConfiguration;
        this.$tokenNumber = i;
        this.$tokenId = byteString;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidFetchSignalsAndSendUseCase$invoke$2 androidFetchSignalsAndSendUseCase$invoke$2 = new AndroidFetchSignalsAndSendUseCase$invoke$2(this.this$0, this.$tokenConfiguration, this.$tokenNumber, this.$tokenId, continuation);
        androidFetchSignalsAndSendUseCase$invoke$2.L$0 = obj;
        return androidFetchSignalsAndSendUseCase$invoke$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidFetchSignalsAndSendUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0103  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List<? extends InitializationResponseOuterClass.AdFormat> requestedSignalFormats;
        SendDiagnosticEvent sendDiagnosticEvent;
        long j;
        ScarManager scarManager;
        Object signals;
        Object m10241constructorimpl;
        BiddingSignals biddingSignals;
        String str;
        SendDiagnosticEvent sendDiagnosticEvent2;
        Map tags;
        SendDiagnosticEvent sendDiagnosticEvent3;
        HandleGetTokenRequest handleGetTokenRequest;
        Object invoke;
        long j2;
        String str2;
        SendDiagnosticEvent sendDiagnosticEvent4;
        Map tags2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
            requestedSignalFormats = this.this$0.getRequestedSignalFormats(this.$tokenConfiguration);
            if (requestedSignalFormats.isEmpty()) {
                return Unit.INSTANCE;
            }
            sendDiagnosticEvent = this.this$0.sendDiagnosticEvent;
            SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_scar_signals_collection_started", null, null, null, null, Boxing.boxInt(this.$tokenNumber), 30, null);
            AndroidFetchSignalsAndSendUseCase androidFetchSignalsAndSendUseCase = this.this$0;
            try {
                Result.Companion companion = Result.INSTANCE;
                scarManager = androidFetchSignalsAndSendUseCase.scarManager;
                this.J$0 = m11706markNowz9LOYto;
                this.label = 1;
                signals = scarManager.getSignals(requestedSignalFormats, this);
                if (signals != coroutine_suspended) {
                    j = m11706markNowz9LOYto;
                }
            } catch (Throwable th) {
                th = th;
                j = m11706markNowz9LOYto;
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                }
                biddingSignals = (BiddingSignals) m10241constructorimpl;
                if (biddingSignals != null) {
                }
                sendDiagnosticEvent2 = this.this$0.sendDiagnosticEvent;
                Double boxDouble = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j)));
                tags = this.this$0.getTags();
                SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent2, str, boxDouble, tags, null, null, Boxing.boxInt(this.$tokenNumber), 24, null);
                if (biddingSignals == null) {
                }
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j2 = this.J$0;
            ResultKt.throwOnFailure(obj);
            invoke = obj;
            if (!((UniversalResponseOuterClass.UniversalResponse) invoke).hasError()) {
                str2 = "native_scar_signals_upload_failure_time";
            } else {
                str2 = "native_scar_signals_upload_success_time";
            }
            sendDiagnosticEvent4 = this.this$0.sendDiagnosticEvent;
            Double boxDouble2 = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j2)));
            tags2 = this.this$0.getTags();
            SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent4, str2, boxDouble2, tags2, null, null, Boxing.boxInt(this.$tokenNumber), 24, null);
            return Unit.INSTANCE;
        }
        j = this.J$0;
        try {
            ResultKt.throwOnFailure(obj);
            signals = obj;
        } catch (Throwable th2) {
            th = th2;
            Result.Companion companion22 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            }
            biddingSignals = (BiddingSignals) m10241constructorimpl;
            if (biddingSignals != null) {
            }
            sendDiagnosticEvent2 = this.this$0.sendDiagnosticEvent;
            Double boxDouble3 = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j)));
            tags = this.this$0.getTags();
            SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent2, str, boxDouble3, tags, null, null, Boxing.boxInt(this.$tokenNumber), 24, null);
            if (biddingSignals == null) {
            }
        }
        m10241constructorimpl = Result.m10241constructorimpl((BiddingSignals) signals);
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = null;
        }
        biddingSignals = (BiddingSignals) m10241constructorimpl;
        if (biddingSignals != null) {
            str = "native_scar_signals_collection_success_time";
        } else {
            str = "native_scar_signals_collection_failure_time";
        }
        sendDiagnosticEvent2 = this.this$0.sendDiagnosticEvent;
        Double boxDouble32 = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j)));
        tags = this.this$0.getTags();
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent2, str, boxDouble32, tags, null, null, Boxing.boxInt(this.$tokenNumber), 24, null);
        if (biddingSignals == null) {
            return Unit.INSTANCE;
        }
        long m11706markNowz9LOYto2 = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
        sendDiagnosticEvent3 = this.this$0.sendDiagnosticEvent;
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent3, "native_scar_signals_upload_started", null, null, null, null, Boxing.boxInt(this.$tokenNumber), 30, null);
        handleGetTokenRequest = this.this$0.handleGetTokenRequest;
        this.J$0 = m11706markNowz9LOYto2;
        this.label = 2;
        invoke = handleGetTokenRequest.invoke(this.$tokenId, biddingSignals, this);
        if (invoke != coroutine_suspended) {
            j2 = m11706markNowz9LOYto2;
            if (!((UniversalResponseOuterClass.UniversalResponse) invoke).hasError()) {
            }
            sendDiagnosticEvent4 = this.this$0.sendDiagnosticEvent;
            Double boxDouble22 = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j2)));
            tags2 = this.this$0.getTags();
            SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent4, str2, boxDouble22, tags2, null, null, Boxing.boxInt(this.$tokenNumber), 24, null);
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
