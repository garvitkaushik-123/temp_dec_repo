package io.adn.sdk.internal.data.repository;

import com.unity3d.services.core.di.ServiceProvider;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.common.utils.FileKt;
import io.adn.sdk.internal.common.utils.TaskKt;
import io.adn.sdk.internal.data.api.remote.RemoteDataSource;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.FileContentType;
import io.adn.sdk.internal.domain.model.ad.LoadedFile;
import io.adn.sdk.internal.domain.repository.AdFileLoader;
import io.adn.sdk.internal.domain.repository.StorageRepository;
import io.ktor.util.cio.FileChannelsKt;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* compiled from: AdFileLoaderImpl.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\fH\u0016J&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b\u001c\u0010\u0015J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\fH\u0002J.\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0004\b \u0010!J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\"J\n\u0010#\u001a\u0004\u0018\u00010\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lio/adn/sdk/internal/data/repository/AdFileLoaderImpl;", "Lio/adn/sdk/internal/domain/repository/AdFileLoader;", ServiceProvider.NAMED_REMOTE, "Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "storageRepository", "Lio/adn/sdk/internal/domain/repository/StorageRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;Lio/adn/sdk/internal/domain/repository/StorageRepository;Lkotlinx/coroutines/CoroutineScope;)V", "ongoingDownloads", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlinx/coroutines/Deferred;", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "loadAdFile", "url", "contentType", "Lio/adn/sdk/internal/domain/model/ad/FileContentType;", "loadAdFile-0E7RQCE", "(Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/FileContentType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFile", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdFile", "Ljava/io/File;", "getOrDownloadAdFile", "getOrDownloadAdFile-0E7RQCE", "createFileFromUrl", "downloadAndCacheFile", "destinationFile", "downloadAndCacheFile-BWLJW6A", "(Ljava/lang/String;Ljava/io/File;Lio/adn/sdk/internal/domain/model/ad/FileContentType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTempFile", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdFileLoaderImpl implements AdFileLoader {
    public static final int $stable = 8;
    private final ConcurrentHashMap<String, Deferred<Result<LoadedFile>>> ongoingDownloads;
    private final RemoteDataSource remote;
    private final CoroutineScope scope;
    private final StorageRepository storageRepository;

    public AdFileLoaderImpl(RemoteDataSource remote, StorageRepository storageRepository, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(storageRepository, "storageRepository");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.remote = remote;
        this.storageRepository = storageRepository;
        this.scope = scope;
        this.ongoingDownloads = new ConcurrentHashMap<>();
    }

    public /* synthetic */ AdFileLoaderImpl(RemoteDataSource remoteDataSource, StorageRepository storageRepository, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(remoteDataSource, storageRepository, (i & 4) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()) : coroutineScope);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.adn.sdk.internal.domain.repository.AdFileLoader
    /* renamed from: loadAdFile-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo9478loadAdFile0E7RQCE(String str, FileContentType fileContentType, Continuation<? super Result<LoadedFile>> continuation) {
        AdFileLoaderImpl$loadAdFile$1 adFileLoaderImpl$loadAdFile$1;
        int i;
        if (continuation instanceof AdFileLoaderImpl$loadAdFile$1) {
            adFileLoaderImpl$loadAdFile$1 = (AdFileLoaderImpl$loadAdFile$1) continuation;
            if ((adFileLoaderImpl$loadAdFile$1.label & Integer.MIN_VALUE) != 0) {
                adFileLoaderImpl$loadAdFile$1.label -= Integer.MIN_VALUE;
                Object obj = adFileLoaderImpl$loadAdFile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = adFileLoaderImpl$loadAdFile$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher io2 = Dispatchers.getIO();
                    AdFileLoaderImpl$loadAdFile$2 adFileLoaderImpl$loadAdFile$2 = new AdFileLoaderImpl$loadAdFile$2(this, str, fileContentType, null);
                    adFileLoaderImpl$loadAdFile$1.label = 1;
                    obj = BuildersKt.withContext(io2, adFileLoaderImpl$loadAdFile$2, adFileLoaderImpl$loadAdFile$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        adFileLoaderImpl$loadAdFile$1 = new AdFileLoaderImpl$loadAdFile$1(this, continuation);
        Object obj2 = adFileLoaderImpl$loadAdFile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = adFileLoaderImpl$loadAdFile$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    @Override // io.adn.sdk.internal.domain.repository.AdFileLoader
    public Object downloadFile(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AdFileLoaderImpl$downloadFile$2(this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // io.adn.sdk.internal.domain.repository.AdFileLoader
    public File getAdFile(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        File createFileFromUrl = createFileFromUrl(url);
        if (createFileFromUrl == null || !FileKt.existsAndNotEmpty(createFileFromUrl)) {
            return null;
        }
        return createFileFromUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        r0 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r15.scope, null, kotlinx.coroutines.CoroutineStart.LAZY, new io.adn.sdk.internal.data.repository.AdFileLoaderImpl$getOrDownloadAdFile$download$1$newDownload$1(r15, r16, r3, r17, null), 1, null);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: getOrDownloadAdFile-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9477getOrDownloadAdFile0E7RQCE(String str, FileContentType fileContentType, Continuation<? super Result<LoadedFile>> continuation) {
        AdFileLoaderImpl$getOrDownloadAdFile$1 adFileLoaderImpl$getOrDownloadAdFile$1;
        int i;
        Deferred<Result<LoadedFile>> putIfAbsent;
        if (continuation instanceof AdFileLoaderImpl$getOrDownloadAdFile$1) {
            adFileLoaderImpl$getOrDownloadAdFile$1 = (AdFileLoaderImpl$getOrDownloadAdFile$1) continuation;
            if ((adFileLoaderImpl$getOrDownloadAdFile$1.label & Integer.MIN_VALUE) != 0) {
                adFileLoaderImpl$getOrDownloadAdFile$1.label -= Integer.MIN_VALUE;
                AdFileLoaderImpl$getOrDownloadAdFile$1 adFileLoaderImpl$getOrDownloadAdFile$12 = adFileLoaderImpl$getOrDownloadAdFile$1;
                Object obj = adFileLoaderImpl$getOrDownloadAdFile$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = adFileLoaderImpl$getOrDownloadAdFile$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    File createFileFromUrl = this.storageRepository.createFileFromUrl(str);
                    if (createFileFromUrl == null) {
                        Result.Companion companion = Result.INSTANCE;
                        return Result.m10241constructorimpl(ResultKt.createFailure(new AdException(AdError.AssetCacheError, null, 2, null)));
                    }
                    if (FileKt.existsAndNotEmpty(createFileFromUrl)) {
                        Result.Companion companion2 = Result.INSTANCE;
                        return Result.m10241constructorimpl(new LoadedFile(str, fileContentType, createFileFromUrl, true));
                    }
                    Deferred<Result<LoadedFile>> deferred = this.ongoingDownloads.get(str);
                    if (deferred == null && (putIfAbsent = this.ongoingDownloads.putIfAbsent(str, deferred)) != null) {
                        deferred = putIfAbsent;
                    }
                    adFileLoaderImpl$getOrDownloadAdFile$12.label = 1;
                    obj = deferred.await(adFileLoaderImpl$getOrDownloadAdFile$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        adFileLoaderImpl$getOrDownloadAdFile$1 = new AdFileLoaderImpl$getOrDownloadAdFile$1(this, continuation);
        AdFileLoaderImpl$getOrDownloadAdFile$1 adFileLoaderImpl$getOrDownloadAdFile$122 = adFileLoaderImpl$getOrDownloadAdFile$1;
        Object obj2 = adFileLoaderImpl$getOrDownloadAdFile$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = adFileLoaderImpl$getOrDownloadAdFile$122.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File createFileFromUrl(String url) {
        return this.storageRepository.createFileFromUrl(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008d A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:11:0x0039, B:12:0x0087, B:14:0x008d, B:25:0x009b, B:26:0x00ad), top: B:10:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:11:0x0039, B:12:0x0087, B:14:0x008d, B:25:0x009b, B:26:0x00ad), top: B:10:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* renamed from: downloadAndCacheFile-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9476downloadAndCacheFileBWLJW6A(String str, File file, FileContentType fileContentType, Continuation<? super Result<LoadedFile>> continuation) {
        AdFileLoaderImpl$downloadAndCacheFile$1 adFileLoaderImpl$downloadAndCacheFile$1;
        int i;
        File createTempFile;
        String str2;
        File file2;
        Object m10241constructorimpl;
        Throwable m10244exceptionOrNullimpl;
        Throwable m10244exceptionOrNullimpl2;
        if (continuation instanceof AdFileLoaderImpl$downloadAndCacheFile$1) {
            adFileLoaderImpl$downloadAndCacheFile$1 = (AdFileLoaderImpl$downloadAndCacheFile$1) continuation;
            if ((adFileLoaderImpl$downloadAndCacheFile$1.label & Integer.MIN_VALUE) != 0) {
                adFileLoaderImpl$downloadAndCacheFile$1.label -= Integer.MIN_VALUE;
                Object obj = adFileLoaderImpl$downloadAndCacheFile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = adFileLoaderImpl$downloadAndCacheFile$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    createTempFile = createTempFile();
                    if (createTempFile == null) {
                        Result.Companion companion = Result.INSTANCE;
                        return Result.m10241constructorimpl(ResultKt.createFailure(new AdException(AdError.AssetCacheError, null, 2, null)));
                    }
                    try {
                        Result.Companion companion2 = Result.INSTANCE;
                        AdFileLoaderImpl adFileLoaderImpl = this;
                        AdFileLoaderImpl$downloadAndCacheFile$result$1$1 adFileLoaderImpl$downloadAndCacheFile$result$1$1 = new AdFileLoaderImpl$downloadAndCacheFile$result$1$1(this, str, createTempFile, null);
                        adFileLoaderImpl$downloadAndCacheFile$1.L$0 = str;
                        adFileLoaderImpl$downloadAndCacheFile$1.L$1 = file;
                        adFileLoaderImpl$downloadAndCacheFile$1.L$2 = fileContentType;
                        adFileLoaderImpl$downloadAndCacheFile$1.L$3 = createTempFile;
                        adFileLoaderImpl$downloadAndCacheFile$1.label = 1;
                        if (TaskKt.retryOperation(2, adFileLoaderImpl$downloadAndCacheFile$result$1$1, adFileLoaderImpl$downloadAndCacheFile$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str2 = str;
                        file2 = createTempFile;
                    } catch (Throwable th) {
                        th = th;
                        Result.Companion companion3 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        str2 = str;
                        file2 = createTempFile;
                        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                        if (m10244exceptionOrNullimpl != null) {
                        }
                        file2.delete();
                        m10244exceptionOrNullimpl2 = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                        if (m10244exceptionOrNullimpl2 == null) {
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    file2 = (File) adFileLoaderImpl$downloadAndCacheFile$1.L$3;
                    fileContentType = (FileContentType) adFileLoaderImpl$downloadAndCacheFile$1.L$2;
                    file = (File) adFileLoaderImpl$downloadAndCacheFile$1.L$1;
                    str2 = (String) adFileLoaderImpl$downloadAndCacheFile$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        createTempFile = file2;
                        str = str2;
                        Result.Companion companion32 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        str2 = str;
                        file2 = createTempFile;
                        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                        if (m10244exceptionOrNullimpl != null) {
                        }
                        file2.delete();
                        m10244exceptionOrNullimpl2 = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                        if (m10244exceptionOrNullimpl2 == null) {
                        }
                    }
                }
                if (FileKt.hasValidContent(file2, fileContentType)) {
                    throw new IOException("Downloaded file is not valid for type: " + fileContentType);
                }
                file2.renameTo(file);
                m10241constructorimpl = Result.m10241constructorimpl(new LoadedFile(str2, fileContentType, file, false));
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl != null) {
                    Logger.INSTANCE.e("AdFileLoader", m10244exceptionOrNullimpl.getMessage());
                }
                file2.delete();
                m10244exceptionOrNullimpl2 = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl2 == null) {
                    Result.Companion companion4 = Result.INSTANCE;
                    return Result.m10241constructorimpl((LoadedFile) m10241constructorimpl);
                }
                Result.Companion companion5 = Result.INSTANCE;
                return Result.m10241constructorimpl(ResultKt.createFailure(new AdException(AdError.AssetDownloadError, "url: " + str2 + ", " + m10244exceptionOrNullimpl2.getMessage())));
            }
        }
        adFileLoaderImpl$downloadAndCacheFile$1 = new AdFileLoaderImpl$downloadAndCacheFile$1(this, continuation);
        Object obj2 = adFileLoaderImpl$downloadAndCacheFile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = adFileLoaderImpl$downloadAndCacheFile$1.label;
        if (i != 0) {
        }
        if (FileKt.hasValidContent(file2, fileContentType)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(100, r5) == r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0078, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
    
        if (io.ktor.utils.io.ByteReadChannelKt.copyAndClose$default((io.ktor.utils.io.ByteReadChannel) r12, r11, 0, r5, 2, null) != r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        if (r12 == r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object downloadFile(String str, File file, Continuation<? super Unit> continuation) {
        AdFileLoaderImpl$downloadFile$3 adFileLoaderImpl$downloadFile$3;
        int i;
        if (continuation instanceof AdFileLoaderImpl$downloadFile$3) {
            adFileLoaderImpl$downloadFile$3 = (AdFileLoaderImpl$downloadFile$3) continuation;
            if ((adFileLoaderImpl$downloadFile$3.label & Integer.MIN_VALUE) != 0) {
                adFileLoaderImpl$downloadFile$3.label -= Integer.MIN_VALUE;
                AdFileLoaderImpl$downloadFile$3 adFileLoaderImpl$downloadFile$32 = adFileLoaderImpl$downloadFile$3;
                Object obj = adFileLoaderImpl$downloadFile$32.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = adFileLoaderImpl$downloadFile$32.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    RemoteDataSource remoteDataSource = this.remote;
                    adFileLoaderImpl$downloadFile$32.L$0 = file;
                    adFileLoaderImpl$downloadFile$32.label = 1;
                    obj = remoteDataSource.loadAdFile(str, adFileLoaderImpl$downloadFile$32);
                } else if (i == 1) {
                    file = (File) adFileLoaderImpl$downloadFile$32.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    adFileLoaderImpl$downloadFile$32.label = 3;
                }
                ByteWriteChannel writeChannel$default = FileChannelsKt.writeChannel$default(file, null, 1, null);
                adFileLoaderImpl$downloadFile$32.L$0 = null;
                adFileLoaderImpl$downloadFile$32.label = 2;
            }
        }
        adFileLoaderImpl$downloadFile$3 = new AdFileLoaderImpl$downloadFile$3(this, continuation);
        AdFileLoaderImpl$downloadFile$3 adFileLoaderImpl$downloadFile$322 = adFileLoaderImpl$downloadFile$3;
        Object obj2 = adFileLoaderImpl$downloadFile$322.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = adFileLoaderImpl$downloadFile$322.label;
        if (i != 0) {
        }
        ByteWriteChannel writeChannel$default2 = FileChannelsKt.writeChannel$default(file, null, 1, null);
        adFileLoaderImpl$downloadFile$322.L$0 = null;
        adFileLoaderImpl$downloadFile$322.label = 2;
    }

    private final File createTempFile() {
        return this.storageRepository.createTempFile();
    }
}
