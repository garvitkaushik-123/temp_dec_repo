package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import java.io.File;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.AdFileLoaderImpl$downloadFile$2", f = "AdFileLoaderImpl.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AdFileLoaderImpl$downloadFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AdFileLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdFileLoaderImpl$downloadFile$2(AdFileLoaderImpl adFileLoaderImpl, String str, Continuation<? super AdFileLoaderImpl$downloadFile$2> continuation) {
        super(2, continuation);
        this.this$0 = adFileLoaderImpl;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AdFileLoaderImpl$downloadFile$2 adFileLoaderImpl$downloadFile$2 = new AdFileLoaderImpl$downloadFile$2(this.this$0, this.$url, continuation);
        adFileLoaderImpl$downloadFile$2.L$0 = obj;
        return adFileLoaderImpl$downloadFile$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((AdFileLoaderImpl$downloadFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m10241constructorimpl;
        File createFileFromUrl;
        Object downloadFile;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AdFileLoaderImpl adFileLoaderImpl = this.this$0;
                String str = this.$url;
                Result.Companion companion = Result.INSTANCE;
                createFileFromUrl = adFileLoaderImpl.createFileFromUrl(str);
                if (createFileFromUrl == null) {
                    throw new AdException(AdError.AssetCacheError, null, 2, null);
                }
                this.label = 1;
                downloadFile = adFileLoaderImpl.downloadFile(str, createFileFromUrl, this);
                if (downloadFile == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m10240boximpl(m10241constructorimpl);
    }
}
