package com.unity3d.ads.core.data.repository;

import com.unity3d.services.core.network.domain.CleanupDirectory;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidCacheRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$clearCache$2", f = "AndroidCacheRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidCacheRepository$clearCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AndroidCacheRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidCacheRepository$clearCache$2(AndroidCacheRepository androidCacheRepository, Continuation<? super AndroidCacheRepository$clearCache$2> continuation) {
        super(2, continuation);
        this.this$0 = androidCacheRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidCacheRepository$clearCache$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidCacheRepository$clearCache$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SessionRepository sessionRepository;
        SessionRepository sessionRepository2;
        CleanupDirectory cleanupDirectory;
        File file;
        SessionRepository sessionRepository3;
        SessionRepository sessionRepository4;
        CleanupDirectory cleanupDirectory2;
        File file2;
        File file3;
        File file4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            sessionRepository = this.this$0.sessionRepository;
            int i = 0;
            if (!sessionRepository.getNativeConfiguration().hasCachedAssetsConfiguration()) {
                file4 = this.this$0.cacheDir;
                File[] listFiles = file4.listFiles();
                if (listFiles == null) {
                    return null;
                }
                int length = listFiles.length;
                while (i < length) {
                    listFiles[i].delete();
                    i++;
                }
                return Unit.INSTANCE;
            }
            sessionRepository2 = this.this$0.sessionRepository;
            NativeConfigurationOuterClass.CachedAssetsConfiguration cachedAssetsConfiguration = sessionRepository2.getNativeConfiguration().getCachedAssetsConfiguration();
            cleanupDirectory = this.this$0.cleanupDirectory;
            file = this.this$0.cacheDir;
            cleanupDirectory.invoke(file, cachedAssetsConfiguration.getMaxCachedAssetSizeMb(), cachedAssetsConfiguration.getMaxCachedAssetAgeMs());
            sessionRepository3 = this.this$0.sessionRepository;
            if (!sessionRepository3.getNativeConfiguration().hasCachedWebviewFilesConfiguration()) {
                file3 = this.this$0.webviewCacheDir;
                File[] listFiles2 = file3.listFiles();
                if (listFiles2 == null) {
                    return null;
                }
                int length2 = listFiles2.length;
                while (i < length2) {
                    listFiles2[i].delete();
                    i++;
                }
                return Unit.INSTANCE;
            }
            sessionRepository4 = this.this$0.sessionRepository;
            NativeConfigurationOuterClass.CachedAssetsConfiguration cachedWebviewFilesConfiguration = sessionRepository4.getNativeConfiguration().getCachedWebviewFilesConfiguration();
            cleanupDirectory2 = this.this$0.cleanupDirectory;
            file2 = this.this$0.webviewCacheDir;
            cleanupDirectory2.invoke(file2, cachedWebviewFilesConfiguration.getMaxCachedAssetSizeMb(), cachedWebviewFilesConfiguration.getMaxCachedAssetAgeMs());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
