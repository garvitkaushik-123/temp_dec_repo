package com.unity3d.ads.core.data.manager;

import com.unity3d.ads.core.data.model.exception.TransactionException;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.services.store.StoreMonitor;
import com.unity3d.services.store.gpbl.BillingResultResponseCode;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseBridge;
import com.unity3d.services.store.gpbl.listeners.BillingInitializationListener;
import com.unity3d.services.store.gpbl.listeners.PurchasesResponseListener;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TransactionEventManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.manager.TransactionEventManager$invoke$1", f = "TransactionEventManager.kt", i = {}, l = {Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class TransactionEventManager$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TransactionEventManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransactionEventManager$invoke$1(TransactionEventManager transactionEventManager, Continuation<? super TransactionEventManager$invoke$1> continuation) {
        super(2, continuation);
        this.this$0 = transactionEventManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransactionEventManager$invoke$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransactionEventManager$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SendDiagnosticEvent sendDiagnosticEvent;
        StoreMonitor storeMonitor;
        StoreMonitor storeMonitor2;
        StoreMonitor storeMonitor3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception unused) {
            sendDiagnosticEvent = this.this$0.sendDiagnosticEvent;
            SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "billing_service_unavailable", null, null, null, null, null, 62, null);
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            storeMonitor = this.this$0.storeMonitor;
            if (!storeMonitor.isInitialized()) {
                final TransactionEventManager transactionEventManager = this.this$0;
                this.L$0 = transactionEventManager;
                this.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                storeMonitor2 = transactionEventManager.storeMonitor;
                storeMonitor2.initialize(new BillingInitializationListener() { // from class: com.unity3d.ads.core.data.manager.TransactionEventManager$invoke$1$1$1
                    private final void tryResume() {
                        if (cancellableContinuationImpl2.isActive()) {
                            CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m10241constructorimpl(Unit.INSTANCE));
                        }
                    }

                    private final void tryResumeWithException(Exception exception) {
                        if (cancellableContinuationImpl2.isActive()) {
                            CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(exception)));
                        }
                    }

                    @Override // com.unity3d.services.store.gpbl.listeners.BillingInitializationListener
                    public void onIsAlreadyInitialized() {
                        tryResume();
                    }

                    @Override // com.unity3d.services.store.gpbl.listeners.BillingClientStateListener
                    public void onBillingSetupFinished(BillingResultBridge billingResult) {
                        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                        if (billingResult.getResponseCode() != BillingResultResponseCode.OK) {
                            tryResumeWithException(new TransactionException("Billing setup failed"));
                        } else {
                            tryResume();
                        }
                    }

                    @Override // com.unity3d.services.store.gpbl.listeners.BillingClientStateListener
                    public void onBillingServiceDisconnected() {
                        tryResumeWithException(new TransactionException("Billing service disconnected"));
                    }

                    @Override // com.unity3d.services.store.gpbl.listeners.PurchaseUpdatedResponseListener
                    public void onPurchaseUpdated(BillingResultBridge billingResult, List<? extends PurchaseBridge> purchases) {
                        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                        transactionEventManager.onPurchasesReceived(billingResult, purchases);
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        storeMonitor3 = this.this$0.storeMonitor;
        final TransactionEventManager transactionEventManager2 = this.this$0;
        storeMonitor3.getPurchases(42, "inapp", new PurchasesResponseListener() { // from class: com.unity3d.ads.core.data.manager.TransactionEventManager$invoke$1$$ExternalSyntheticLambda0
            @Override // com.unity3d.services.store.gpbl.listeners.PurchasesResponseListener
            public final void onPurchaseResponse(BillingResultBridge billingResultBridge, List list) {
                TransactionEventManager.access$onPurchasesReceived(TransactionEventManager.this, billingResultBridge, list);
            }
        });
        return Unit.INSTANCE;
    }
}
