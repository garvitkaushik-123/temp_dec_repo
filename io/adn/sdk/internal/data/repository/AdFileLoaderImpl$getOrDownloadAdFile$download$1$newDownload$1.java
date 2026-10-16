package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.domain.model.ad.FileContentType;
import io.adn.sdk.internal.domain.model.ad.LoadedFile;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AdFileLoaderImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.AdFileLoaderImpl$getOrDownloadAdFile$download$1$newDownload$1", f = "AdFileLoaderImpl.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AdFileLoaderImpl$getOrDownloadAdFile$download$1$newDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends LoadedFile>>, Object> {
    final /* synthetic */ File $cachedFile;
    final /* synthetic */ FileContentType $contentType;
    final /* synthetic */ AdFileLoaderImpl $this_run;
    final /* synthetic */ String $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdFileLoaderImpl$getOrDownloadAdFile$download$1$newDownload$1(AdFileLoaderImpl adFileLoaderImpl, String str, File file, FileContentType fileContentType, Continuation<? super AdFileLoaderImpl$getOrDownloadAdFile$download$1$newDownload$1> continuation) {
        super(2, continuation);
        this.$this_run = adFileLoaderImpl;
        this.$url = str;
        this.$cachedFile = file;
        this.$contentType = fileContentType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdFileLoaderImpl$getOrDownloadAdFile$download$1$newDownload$1(this.$this_run, this.$url, this.$cachedFile, this.$contentType, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends LoadedFile>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<LoadedFile>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<LoadedFile>> continuation) {
        return ((AdFileLoaderImpl$getOrDownloadAdFile$download$1$newDownload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9476downloadAndCacheFileBWLJW6A;
        ConcurrentHashMap concurrentHashMap;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            m9476downloadAndCacheFileBWLJW6A = this.$this_run.m9476downloadAndCacheFileBWLJW6A(this.$url, this.$cachedFile, this.$contentType, this);
            if (m9476downloadAndCacheFileBWLJW6A == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            m9476downloadAndCacheFileBWLJW6A = ((Result) obj).getValue();
        }
        Result m10240boximpl = Result.m10240boximpl(m9476downloadAndCacheFileBWLJW6A);
        AdFileLoaderImpl adFileLoaderImpl = this.$this_run;
        String str = this.$url;
        m10240boximpl.getValue();
        concurrentHashMap = adFileLoaderImpl.ongoingDownloads;
        concurrentHashMap.remove(str);
        return m10240boximpl;
    }
}
