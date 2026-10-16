package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.FileContentType;
import io.adn.sdk.internal.domain.model.ad.LoadedFile;
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
import kotlinx.coroutines.TimeoutKt;

/* compiled from: AdFileLoaderImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.AdFileLoaderImpl$loadAdFile$2", f = "AdFileLoaderImpl.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AdFileLoaderImpl$loadAdFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends LoadedFile>>, Object> {
    final /* synthetic */ FileContentType $contentType;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ AdFileLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdFileLoaderImpl$loadAdFile$2(AdFileLoaderImpl adFileLoaderImpl, String str, FileContentType fileContentType, Continuation<? super AdFileLoaderImpl$loadAdFile$2> continuation) {
        super(2, continuation);
        this.this$0 = adFileLoaderImpl;
        this.$url = str;
        this.$contentType = fileContentType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdFileLoaderImpl$loadAdFile$2(this.this$0, this.$url, this.$contentType, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends LoadedFile>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<LoadedFile>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<LoadedFile>> continuation) {
        return ((AdFileLoaderImpl$loadAdFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: AdFileLoaderImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.adn.sdk.internal.data.repository.AdFileLoaderImpl$loadAdFile$2$1", f = "AdFileLoaderImpl.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.adn.sdk.internal.data.repository.AdFileLoaderImpl$loadAdFile$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends LoadedFile>>, Object> {
        final /* synthetic */ FileContentType $contentType;
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ AdFileLoaderImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AdFileLoaderImpl adFileLoaderImpl, String str, FileContentType fileContentType, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = adFileLoaderImpl;
            this.$url = str;
            this.$contentType = fileContentType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$url, this.$contentType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends LoadedFile>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<LoadedFile>>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<LoadedFile>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object m9477getOrDownloadAdFile0E7RQCE;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                m9477getOrDownloadAdFile0E7RQCE = this.this$0.m9477getOrDownloadAdFile0E7RQCE(this.$url, this.$contentType, this);
                if (m9477getOrDownloadAdFile0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                m9477getOrDownloadAdFile0E7RQCE = ((Result) obj).getValue();
            }
            return Result.m10240boximpl(m9477getOrDownloadAdFile0E7RQCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        Object m10241constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j = AdFileLoaderImplKt.DOWNLOAD_TIMEOUT;
            this.label = 1;
            obj = TimeoutKt.m11744withTimeoutOrNullKLykuaI(j, new AnonymousClass1(this.this$0, this.$url, this.$contentType, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Result result = (Result) obj;
        if (result != null) {
            m10241constructorimpl = result.getValue();
        } else {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(new AdException(AdError.AssetDownloadError, null, 2, null)));
        }
        return Result.m10240boximpl(m10241constructorimpl);
    }
}
