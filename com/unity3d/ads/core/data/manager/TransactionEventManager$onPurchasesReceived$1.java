package com.unity3d.ads.core.data.manager;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.protobuf.Timestamp;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.repository.TransactionEventRepository;
import com.unity3d.ads.core.domain.events.GetTransactionData;
import com.unity3d.ads.core.domain.events.GetTransactionRequest;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.services.store.StoreMonitor;
import com.unity3d.services.store.gpbl.BillingResultResponseCode;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseBridge;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsBridge;
import com.unity3d.services.store.gpbl.listeners.SkuDetailsResponseListener;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TransactionEventManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.manager.TransactionEventManager$onPurchasesReceived$1", f = "TransactionEventManager.kt", i = {0, 0, 0, 0, 0, 0, 1}, l = {92, 109, 112}, m = "invokeSuspend", n = {"transactionDataList", "deferredPurchaseList", FirebaseAnalytics.Event.PURCHASE, "index$iv", FirebaseAnalytics.Param.INDEX, "purchaseTime", "transactionDataList"}, s = {"L$0", "L$1", "L$4", "I$0", "I$1", "J$0", "L$0"})
/* loaded from: classes7.dex */
final class TransactionEventManager$onPurchasesReceived$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PurchaseBridge> $purchases;
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ TransactionEventManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TransactionEventManager$onPurchasesReceived$1(List<? extends PurchaseBridge> list, TransactionEventManager transactionEventManager, Continuation<? super TransactionEventManager$onPurchasesReceived$1> continuation) {
        super(2, continuation);
        this.$purchases = list;
        this.this$0 = transactionEventManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransactionEventManager$onPurchasesReceived$1(this.$purchases, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransactionEventManager$onPurchasesReceived$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0185, code lost:
    
        if (r2 == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0167, code lost:
    
        if (kotlinx.coroutines.AwaitKt.awaitAll((kotlinx.coroutines.Deferred[]) java.util.Arrays.copyOf(r3, r3.length), r22) == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00e4 -> B:20:0x0051). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        Iterator it;
        List list;
        TransactionEventManager transactionEventManager;
        int i;
        ByteStringDataSource byteStringDataSource;
        StoreMonitor storeMonitor;
        GetTransactionRequest getTransactionRequest;
        Object invoke;
        TransactionEventRepository transactionEventRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            arrayList = new ArrayList();
            List<PurchaseBridge> list2 = this.$purchases;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (PurchaseBridge purchaseBridge : list2) {
                arrayList2.add(CompletableDeferredKt.CompletableDeferred$default(null, 1, null));
            }
            List<PurchaseBridge> list3 = this.$purchases;
            TransactionEventManager transactionEventManager2 = this.this$0;
            it = list3.iterator();
            list = arrayList2;
            transactionEventManager = transactionEventManager2;
            i = 0;
            if (it.hasNext()) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                invoke = obj;
                transactionEventRepository = this.this$0.transactionEventRepository;
                transactionEventRepository.addTransactionEvent((TransactionEventRequestOuterClass.TransactionEventRequest) invoke);
                return Unit.INSTANCE;
            }
            arrayList = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (!arrayList.isEmpty()) {
                getTransactionRequest = this.this$0.getTransactionRequest;
                this.L$0 = null;
                this.label = 3;
                invoke = getTransactionRequest.invoke(arrayList, this);
            }
            return Unit.INSTANCE;
        }
        long j = this.J$0;
        int i3 = this.I$1;
        int i4 = this.I$0;
        PurchaseBridge purchaseBridge2 = (PurchaseBridge) this.L$4;
        it = (Iterator) this.L$3;
        transactionEventManager = (TransactionEventManager) this.L$2;
        list = (List) this.L$1;
        List<TransactionEventRequestOuterClass.TransactionData> list4 = (List) this.L$0;
        ResultKt.throwOnFailure(obj);
        final int i5 = i3;
        long longValue = j;
        final List<TransactionEventRequestOuterClass.TransactionData> list5 = list4;
        Object obj2 = obj;
        i = i4;
        final PurchaseBridge purchaseBridge3 = purchaseBridge2;
        final TransactionEventManager transactionEventManager3 = transactionEventManager;
        final List list6 = list;
        if (Timestamp.parseFrom(((ByteStringStoreOuterClass.ByteStringStore) obj2).getData()).getSeconds() >= longValue / 1000.0f) {
            storeMonitor = transactionEventManager3.storeMonitor;
            Object obj3 = purchaseBridge3.getOriginalJson().get(InAppPurchaseMetaData.KEY_PRODUCT_ID);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            list = list6;
            storeMonitor.getSkuDetails(42, "inapp", CollectionsKt.listOf((String) obj3), new SkuDetailsResponseListener() { // from class: com.unity3d.ads.core.data.manager.TransactionEventManager$onPurchasesReceived$1$$ExternalSyntheticLambda0
                @Override // com.unity3d.services.store.gpbl.listeners.SkuDetailsResponseListener
                public final void onSkuDetailsUpdated(BillingResultBridge billingResultBridge, List list7) {
                    TransactionEventManager$onPurchasesReceived$1.invokeSuspend$lambda$3$lambda$2(list6, i5, list5, transactionEventManager3, purchaseBridge3, billingResultBridge, list7);
                }
            });
        } else {
            list = list6;
            ((CompletableDeferred) list.get(i5)).complete(Unit.INSTANCE);
        }
        arrayList = list5;
        transactionEventManager = transactionEventManager3;
        if (it.hasNext()) {
            Object next = it.next();
            i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            purchaseBridge2 = (PurchaseBridge) next;
            Object obj4 = purchaseBridge2.getOriginalJson().get("purchaseTime");
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Long");
            longValue = ((Long) obj4).longValue();
            byteStringDataSource = transactionEventManager.iapTransactionStore;
            this.L$0 = arrayList;
            this.L$1 = list;
            this.L$2 = transactionEventManager;
            this.L$3 = it;
            this.L$4 = purchaseBridge2;
            this.I$0 = i4;
            this.I$1 = i;
            this.J$0 = longValue;
            this.label = 1;
            obj2 = byteStringDataSource.get(this);
            if (obj2 != coroutine_suspended) {
                list5 = arrayList;
                i5 = i;
                i = i4;
                final PurchaseBridge purchaseBridge32 = purchaseBridge2;
                final TransactionEventManager transactionEventManager32 = transactionEventManager;
                final List list62 = list;
                if (Timestamp.parseFrom(((ByteStringStoreOuterClass.ByteStringStore) obj2).getData()).getSeconds() >= longValue / 1000.0f) {
                }
                arrayList = list5;
                transactionEventManager = transactionEventManager32;
                if (it.hasNext()) {
                    CompletableDeferred[] completableDeferredArr = (CompletableDeferred[]) list.toArray(new CompletableDeferred[0]);
                    this.L$0 = arrayList;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 2;
                }
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$3$lambda$2(List list, int i, List list2, TransactionEventManager transactionEventManager, PurchaseBridge purchaseBridge, BillingResultBridge billingResultBridge, List list3) {
        GetTransactionData getTransactionData;
        if (list3 == null || billingResultBridge.getResponseCode() != BillingResultResponseCode.OK) {
            ((CompletableDeferred) list.get(i)).complete(Unit.INSTANCE);
            return;
        }
        List<SkuDetailsBridge> list4 = list3;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        for (SkuDetailsBridge skuDetailsBridge : list4) {
            getTransactionData = transactionEventManager.getTransactionData;
            arrayList.add(getTransactionData.invoke(purchaseBridge, skuDetailsBridge));
        }
        list2.addAll(arrayList);
        ((CompletableDeferred) list.get(i)).complete(Unit.INSTANCE);
    }
}
