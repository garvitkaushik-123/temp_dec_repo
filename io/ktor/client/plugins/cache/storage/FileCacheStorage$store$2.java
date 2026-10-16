package io.ktor.client.plugins.cache.storage;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import io.ktor.http.Url;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FileCacheStorage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$store$2", f = "FileCacheStorage.kt", i = {0}, l = {TokenParametersOuterClass$TokenParameters.MEDIAMUTED_FIELD_NUMBER, TokenParametersOuterClass$TokenParameters.APPSETID_FIELD_NUMBER}, m = "invokeSuspend", n = {"urlHex"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class FileCacheStorage$store$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CachedResponseData $data;
    final /* synthetic */ Url $url;
    Object L$0;
    int label;
    final /* synthetic */ FileCacheStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileCacheStorage$store$2(FileCacheStorage fileCacheStorage, Url url, CachedResponseData cachedResponseData, Continuation<? super FileCacheStorage$store$2> continuation) {
        super(2, continuation);
        this.this$0 = fileCacheStorage;
        this.$url = url;
        this.$data = cachedResponseData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileCacheStorage$store$2(this.this$0, this.$url, this.$data, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FileCacheStorage$store$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
    
        if (r9 == r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0086, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
    
        if (r9 == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String key;
        Object writeCache;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            key = this.this$0.key(this.$url);
            this.L$0 = key;
            this.label = 1;
            obj = this.this$0.readCache(key, (Continuation<? super Set<CachedResponseData>>) this);
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            key = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        CachedResponseData cachedResponseData = this.$data;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) obj) {
            if (!Intrinsics.areEqual(((CachedResponseData) obj2).getVaryKeys(), cachedResponseData.getVaryKeys())) {
                arrayList.add(obj2);
            }
        }
        List plus = CollectionsKt.plus((Collection<? extends CachedResponseData>) arrayList, this.$data);
        this.L$0 = null;
        this.label = 2;
        writeCache = this.this$0.writeCache(key, (List<CachedResponseData>) plus, (Continuation<Object>) this);
    }
}
