package io.adn.sdk.internal.data.api.local;

import android.content.Context;
import com.ironsource.C3040d4;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.j;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.common.utils.ConversionsKt;
import io.adn.sdk.internal.domain.repository.StorageRepository;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: StorageRepositoryImpl.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002J'\u0010\u001c\u001a\u0004\u0018\u00010\u0011*\u00020\u000b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u001eH\u0002¢\u0006\u0002\u0010\u001fJ\f\u0010 \u001a\u00020\u0013*\u00020\u000bH\u0002J\f\u0010!\u001a\u00020\u0013*\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lio/adn/sdk/internal/data/api/local/StorageRepositoryImpl;", "Lio/adn/sdk/internal/domain/repository/StorageRepository;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "cleanupScope", "Lkotlinx/coroutines/CoroutineScope;", "cleanupJob", "Lkotlinx/coroutines/Job;", "getCacheDir", "Ljava/io/File;", "createFileFromUrl", "url", "", "createTempFile", "cleanup", "", "isCachedFileAvailable", "", "ttlMillis", "", "getCachedFile", "fallbackAssetName", "copyAssetToFile", "assetName", C3040d4.h.b, "cleanUpCachedAssetsIfNeeded", "deleteFiles", "predicate", "Lkotlin/Function1;", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "isTempAsset", "isExpiredAsset", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class StorageRepositoryImpl implements StorageRepository {
    public static final int $stable = 8;
    private Job cleanupJob;
    private final CoroutineScope cleanupScope;
    private final Context context;

    public StorageRepositoryImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.cleanupScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    private final File getCacheDir() {
        return this.context.getDir("adn_assets", 0);
    }

    @Override // io.adn.sdk.internal.domain.repository.StorageRepository
    public File createFileFromUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Result.Companion companion = Result.INSTANCE;
            StorageRepositoryImpl storageRepositoryImpl = this;
            return new File(getCacheDir(), ConversionsKt.toMD5(url));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
            if (m10244exceptionOrNullimpl != null) {
                Logger.INSTANCE.e("FileCache", m10244exceptionOrNullimpl);
            }
            if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                m10241constructorimpl = null;
            }
            return (File) m10241constructorimpl;
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.StorageRepository
    public File createTempFile() {
        try {
            Result.Companion companion = Result.INSTANCE;
            StorageRepositoryImpl storageRepositoryImpl = this;
            return new File(getCacheDir(), j.n + ConversionsKt.randomUUID());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
            if (m10244exceptionOrNullimpl != null) {
                Logger.INSTANCE.e("FileCache", m10244exceptionOrNullimpl);
            }
            if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                m10241constructorimpl = null;
            }
            return (File) m10241constructorimpl;
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.StorageRepository
    public void cleanup() {
        Job launch$default;
        try {
            Result.Companion companion = Result.INSTANCE;
            StorageRepositoryImpl storageRepositoryImpl = this;
            Job job = this.cleanupJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.cleanupScope, null, null, new StorageRepositoryImpl$cleanup$1$1(this, null), 3, null);
            this.cleanupJob = launch$default;
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.StorageRepository
    public boolean isCachedFileAvailable(String url, long ttlMillis) {
        Intrinsics.checkNotNullParameter(url, "url");
        File file = new File(getCacheDir(), ConversionsKt.toMD5(url));
        return file.exists() && !(((System.currentTimeMillis() - file.lastModified()) > ttlMillis ? 1 : ((System.currentTimeMillis() - file.lastModified()) == ttlMillis ? 0 : -1)) > 0);
    }

    @Override // io.adn.sdk.internal.domain.repository.StorageRepository
    public File getCachedFile(String url, String fallbackAssetName) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(fallbackAssetName, "fallbackAssetName");
        File createFileFromUrl = createFileFromUrl(url);
        if (createFileFromUrl == null) {
            throw new FileNotFoundException("Cached file not found for url: " + url);
        }
        if (createFileFromUrl.length() == 0) {
            copyAssetToFile(fallbackAssetName, createFileFromUrl);
        }
        return createFileFromUrl;
    }

    private final void copyAssetToFile(String assetName, File file) {
        FileOutputStream open = this.context.getAssets().open(assetName);
        try {
            InputStream inputStream = open;
            open = new FileOutputStream(file);
            try {
                Intrinsics.checkNotNull(inputStream);
                ByteStreamsKt.copyTo$default(inputStream, open, 0, 2, null);
                CloseableKt.closeFinally(open, null);
                CloseableKt.closeFinally(open, null);
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanUpCachedAssetsIfNeeded() {
        Object m10241constructorimpl;
        File cacheDir;
        try {
            Result.Companion companion = Result.INSTANCE;
            StorageRepositoryImpl storageRepositoryImpl = this;
            cacheDir = getCacheDir();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (cacheDir == null) {
            return;
        }
        deleteFiles(cacheDir, new Function1() { // from class: io.adn.sdk.internal.data.api.local.StorageRepositoryImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean cleanUpCachedAssetsIfNeeded$lambda$9$lambda$7;
                cleanUpCachedAssetsIfNeeded$lambda$9$lambda$7 = StorageRepositoryImpl.cleanUpCachedAssetsIfNeeded$lambda$9$lambda$7(StorageRepositoryImpl.this, (File) obj);
                return Boolean.valueOf(cleanUpCachedAssetsIfNeeded$lambda$9$lambda$7);
            }
        });
        long freeSpace = cacheDir.getFreeSpace();
        if (1 <= freeSpace && freeSpace < 83886080) {
            deleteFiles(cacheDir, new Function1() { // from class: io.adn.sdk.internal.data.api.local.StorageRepositoryImpl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean cleanUpCachedAssetsIfNeeded$lambda$9$lambda$8;
                    cleanUpCachedAssetsIfNeeded$lambda$9$lambda$8 = StorageRepositoryImpl.cleanUpCachedAssetsIfNeeded$lambda$9$lambda$8((File) obj);
                    return Boolean.valueOf(cleanUpCachedAssetsIfNeeded$lambda$9$lambda$8);
                }
            });
        }
        m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            Logger.INSTANCE.e("FileCache", m10244exceptionOrNullimpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cleanUpCachedAssetsIfNeeded$lambda$9$lambda$7(StorageRepositoryImpl storageRepositoryImpl, File it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return storageRepositoryImpl.isTempAsset(it) || storageRepositoryImpl.isExpiredAsset(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cleanUpCachedAssetsIfNeeded$lambda$9$lambda$8(File it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isFile();
    }

    private final Unit deleteFiles(File file, final Function1<? super File, Boolean> function1) {
        File[] listFiles = file.listFiles(new FileFilter() { // from class: io.adn.sdk.internal.data.api.local.StorageRepositoryImpl$$ExternalSyntheticLambda2
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                boolean deleteFiles$lambda$11;
                deleteFiles$lambda$11 = StorageRepositoryImpl.deleteFiles$lambda$11(Function1.this, file2);
                return deleteFiles$lambda$11;
            }
        });
        if (listFiles == null) {
            return null;
        }
        for (File file2 : listFiles) {
            file2.delete();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteFiles$lambda$11(Function1 function1, File file) {
        return ((Boolean) function1.invoke(file)).booleanValue();
    }

    private final boolean isTempAsset(File file) {
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.startsWith$default(name, j.n, false, 2, (Object) null);
    }

    private final boolean isExpiredAsset(File file) {
        long lastModified = file.lastModified();
        return lastModified > 0 && System.currentTimeMillis() - lastModified > 604800000;
    }
}
