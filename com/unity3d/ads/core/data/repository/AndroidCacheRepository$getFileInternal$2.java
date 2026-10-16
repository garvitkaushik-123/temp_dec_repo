package com.unity3d.ads.core.data.repository;

import adn.analytics.Analytics;
import com.unity3d.ads.core.data.datasource.CacheDataSource;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.domain.work.DownloadPriorityQueue;
import io.ktor.http.ContentDisposition;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AndroidCacheRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/core/data/model/CacheResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2", f = "AndroidCacheRepository.kt", i = {0, 1}, l = {70, Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER, 89}, m = "invokeSuspend", n = {ContentDisposition.Parameters.FileName, "fileResult"}, s = {"L$0", "L$0"})
/* loaded from: classes7.dex */
final class AndroidCacheRepository$getFileInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CacheResult>, Object> {
    final /* synthetic */ File $cacheDirectory;
    final /* synthetic */ int $priority;
    final /* synthetic */ String $url;
    Object L$0;
    int label;
    final /* synthetic */ AndroidCacheRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidCacheRepository$getFileInternal$2(AndroidCacheRepository androidCacheRepository, String str, File file, int i, Continuation<? super AndroidCacheRepository$getFileInternal$2> continuation) {
        super(2, continuation);
        this.this$0 = androidCacheRepository;
        this.$url = str;
        this.$cacheDirectory = file;
        this.$priority = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidCacheRepository$getFileInternal$2(this.this$0, this.$url, this.$cacheDirectory, this.$priority, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CacheResult> continuation) {
        return ((AndroidCacheRepository$getFileInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
    
        if (r14 == r0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009e A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String filename;
        CacheDataSource cacheDataSource;
        DownloadPriorityQueue downloadPriorityQueue;
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            filename = this.this$0.getFilename(this.$url);
            cacheDataSource = this.this$0.localCacheDataSource;
            this.L$0 = filename;
            this.label = 1;
            obj = cacheDataSource.getFile(this.$cacheDirectory, filename, this.$url, Boxing.boxInt(this.$priority), this);
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                mutableStateFlow = (MutableStateFlow) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = null;
                this.label = 3;
                Object first = FlowKt.first(FlowKt.filterNotNull(mutableStateFlow), this);
                return first != coroutine_suspended ? coroutine_suspended : first;
            }
            String str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            filename = str;
        }
        CacheResult cacheResult = (CacheResult) obj;
        if (cacheResult instanceof CacheResult.Success) {
            return cacheResult;
        }
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        downloadPriorityQueue = this.this$0.downloadPriorityQueue;
        this.L$0 = MutableStateFlow;
        this.label = 2;
        if (downloadPriorityQueue.invoke(this.$priority, new AnonymousClass1(this.this$0, this.$cacheDirectory, filename, this.$url, this.$priority, MutableStateFlow, null), this) != coroutine_suspended) {
            mutableStateFlow = MutableStateFlow;
            this.L$0 = null;
            this.label = 3;
            Object first2 = FlowKt.first(FlowKt.filterNotNull(mutableStateFlow), this);
            if (first2 != coroutine_suspended) {
            }
        }
    }

    /* compiled from: AndroidCacheRepository.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2$1", f = "AndroidCacheRepository.kt", i = {}, l = {Analytics.AnalyticsData.EXTRA_SIGNALS_FIELD_NUMBER, 85}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ File $cacheDirectory;
        final /* synthetic */ MutableStateFlow<CacheResult> $fileResult;
        final /* synthetic */ String $filename;
        final /* synthetic */ int $priority;
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ AndroidCacheRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AndroidCacheRepository androidCacheRepository, File file, String str, String str2, int i, MutableStateFlow<CacheResult> mutableStateFlow, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = androidCacheRepository;
            this.$cacheDirectory = file;
            this.$filename = str;
            this.$url = str2;
            this.$priority = i;
            this.$fileResult = mutableStateFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$cacheDirectory, this.$filename, this.$url, this.$priority, this.$fileResult, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0072, code lost:
        
            if (r11 == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x003c, code lost:
        
            if (r11 == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CacheDataSource cacheDataSource;
            CacheDataSource cacheDataSource2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                cacheDataSource = this.this$0.localCacheDataSource;
                this.label = 1;
                obj = cacheDataSource.getFile(this.$cacheDirectory, this.$filename, this.$url, Boxing.boxInt(this.$priority), this);
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    CacheResult cacheResult = (CacheResult) obj;
                    MutableStateFlow<CacheResult> mutableStateFlow = this.$fileResult;
                    while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), cacheResult)) {
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            CacheResult cacheResult2 = (CacheResult) obj;
            if (!(cacheResult2 instanceof CacheResult.Success)) {
                cacheDataSource2 = this.this$0.remoteCacheDataSource;
                this.label = 2;
                obj = cacheDataSource2.getFile(this.$cacheDirectory, this.$filename, this.$url, Boxing.boxInt(this.$priority), this);
            } else {
                MutableStateFlow<CacheResult> mutableStateFlow2 = this.$fileResult;
                while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), cacheResult2)) {
                }
                return Unit.INSTANCE;
            }
        }
    }
}
