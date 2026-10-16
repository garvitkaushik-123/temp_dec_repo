package com.unity3d.ads.core.domain.events;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventObservers.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u000f\u001a\u00020\u0010H\u0086Bø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/unity3d/ads/core/domain/events/EventObservers;", "", "operativeEventObserver", "Lcom/unity3d/ads/core/domain/events/OperativeEventObserver;", "diagnosticEventObserver", "Lcom/unity3d/ads/core/domain/events/DiagnosticEventObserver;", "transactionEventObserver", "Lcom/unity3d/ads/core/domain/events/TransactionEventObserver;", "(Lcom/unity3d/ads/core/domain/events/OperativeEventObserver;Lcom/unity3d/ads/core/domain/events/DiagnosticEventObserver;Lcom/unity3d/ads/core/domain/events/TransactionEventObserver;)V", "getDiagnosticEventObserver", "()Lcom/unity3d/ads/core/domain/events/DiagnosticEventObserver;", "getOperativeEventObserver", "()Lcom/unity3d/ads/core/domain/events/OperativeEventObserver;", "getTransactionEventObserver", "()Lcom/unity3d/ads/core/domain/events/TransactionEventObserver;", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class EventObservers {
    private final DiagnosticEventObserver diagnosticEventObserver;
    private final OperativeEventObserver operativeEventObserver;
    private final TransactionEventObserver transactionEventObserver;

    public EventObservers(OperativeEventObserver operativeEventObserver, DiagnosticEventObserver diagnosticEventObserver, TransactionEventObserver transactionEventObserver) {
        Intrinsics.checkNotNullParameter(operativeEventObserver, "operativeEventObserver");
        Intrinsics.checkNotNullParameter(diagnosticEventObserver, "diagnosticEventObserver");
        Intrinsics.checkNotNullParameter(transactionEventObserver, "transactionEventObserver");
        this.operativeEventObserver = operativeEventObserver;
        this.diagnosticEventObserver = diagnosticEventObserver;
        this.transactionEventObserver = transactionEventObserver;
    }

    public final OperativeEventObserver getOperativeEventObserver() {
        return this.operativeEventObserver;
    }

    public final DiagnosticEventObserver getDiagnosticEventObserver() {
        return this.diagnosticEventObserver;
    }

    public final TransactionEventObserver getTransactionEventObserver() {
        return this.transactionEventObserver;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0071, code lost:
    
        if (r7.invoke(r0) == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if (r7.invoke(r0) != r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Continuation<? super Unit> continuation) {
        EventObservers$invoke$1 eventObservers$invoke$1;
        int i;
        EventObservers eventObservers;
        if (continuation instanceof EventObservers$invoke$1) {
            eventObservers$invoke$1 = (EventObservers$invoke$1) continuation;
            if ((eventObservers$invoke$1.label & Integer.MIN_VALUE) != 0) {
                eventObservers$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = eventObservers$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = eventObservers$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    OperativeEventObserver operativeEventObserver = this.operativeEventObserver;
                    eventObservers$invoke$1.L$0 = this;
                    eventObservers$invoke$1.label = 1;
                    if (operativeEventObserver.invoke(eventObservers$invoke$1) != coroutine_suspended) {
                        eventObservers = this;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    eventObservers = (EventObservers) eventObservers$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    eventObservers = (EventObservers) eventObservers$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    TransactionEventObserver transactionEventObserver = eventObservers.transactionEventObserver;
                    eventObservers$invoke$1.L$0 = null;
                    eventObservers$invoke$1.label = 3;
                }
                DiagnosticEventObserver diagnosticEventObserver = eventObservers.diagnosticEventObserver;
                eventObservers$invoke$1.L$0 = eventObservers;
                eventObservers$invoke$1.label = 2;
            }
        }
        eventObservers$invoke$1 = new EventObservers$invoke$1(this, continuation);
        Object obj2 = eventObservers$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = eventObservers$invoke$1.label;
        if (i != 0) {
        }
        DiagnosticEventObserver diagnosticEventObserver2 = eventObservers.diagnosticEventObserver;
        eventObservers$invoke$1.L$0 = eventObservers;
        eventObservers$invoke$1.label = 2;
    }
}
