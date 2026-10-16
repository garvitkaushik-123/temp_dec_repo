package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSink;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSourceException;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.FileDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.TeeDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public final class CacheDataSource implements DataSource {
    public static final int CACHE_IGNORED_REASON_ERROR = 0;
    public static final int CACHE_IGNORED_REASON_UNSET_LENGTH = 1;
    private static final int CACHE_NOT_IGNORED = -1;
    public static final long DEFAULT_MAX_CACHE_FILE_SIZE = 2097152;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    private static final long MIN_READ_BEFORE_CHECKING_CACHE = 102400;
    private Uri actualUri;
    private final boolean blockOnCache;
    private long bytesRemaining;
    private final Cache cache;
    private final DataSource cacheReadDataSource;
    private final DataSource cacheWriteDataSource;
    private long checkCachePosition;
    private DataSource currentDataSource;
    private boolean currentDataSpecLengthUnset;
    private CacheSpan currentHoleSpan;
    private boolean currentRequestIgnoresCache;
    private final EventListener eventListener;
    private int flags;
    private final boolean ignoreCacheForUnsetLengthRequests;
    private final boolean ignoreCacheOnError;
    private String key;
    private long readPosition;
    private boolean seenCacheError;
    private long totalCachedBytesRead;
    private final DataSource upstreamDataSource;
    private Uri uri;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    public interface EventListener {
        void onCacheIgnored(int i);

        void onCachedBytesRead(long j, long j2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public CacheDataSource(Cache cache, DataSource dataSource) {
        this(cache, dataSource, 0, 2097152L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void closeCurrentSource() throws IOException {
        DataSource dataSource = this.currentDataSource;
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
        } finally {
            this.currentDataSource = null;
            this.currentDataSpecLengthUnset = false;
            CacheSpan cacheSpan = this.currentHoleSpan;
            if (cacheSpan != null) {
                this.cache.releaseHoleSpan(cacheSpan);
                this.currentHoleSpan = null;
            }
        }
    }

    private static Uri getRedirectedUriOrDefault(Cache cache, String str, Uri uri) {
        Uri redirectedUri = ContentMetadataInternal.getRedirectedUri(cache.getContentMetadata(str));
        return redirectedUri == null ? uri : redirectedUri;
    }

    private void handleBeforeThrow(IOException iOException) {
        if (isReadingFromCache() || (iOException instanceof Cache.CacheException)) {
            this.seenCacheError = true;
        }
    }

    private boolean isBypassingCache() {
        return this.currentDataSource == this.upstreamDataSource;
    }

    private static boolean isCausedByPositionOutOfRange(IOException iOException) {
        for (IOException iOException2 = iOException; iOException2 != null; iOException2 = iOException2.getCause()) {
            if ((iOException2 instanceof DataSourceException) && ((DataSourceException) iOException2).reason == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isReadingFromCache() {
        return this.currentDataSource == this.cacheReadDataSource;
    }

    private boolean isReadingFromUpstream() {
        return !isReadingFromCache();
    }

    private boolean isWritingToCache() {
        return this.currentDataSource == this.cacheWriteDataSource;
    }

    private void notifyBytesRead() {
        EventListener eventListener = this.eventListener;
        if (eventListener == null || this.totalCachedBytesRead <= 0) {
            return;
        }
        eventListener.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
        this.totalCachedBytesRead = 0L;
    }

    private void notifyCacheIgnored(int i) {
        EventListener eventListener = this.eventListener;
        if (eventListener != null) {
            eventListener.onCacheIgnored(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void openNextSource(boolean z) throws IOException {
        CacheSpan startReadWrite;
        long j;
        DataSpec dataSpec;
        CacheSpan cacheSpan;
        DataSource dataSource;
        DataSpec dataSpec2;
        long open;
        ContentMetadataMutations contentMetadataMutations;
        if (this.currentRequestIgnoresCache) {
            startReadWrite = null;
        } else if (this.blockOnCache) {
            try {
                startReadWrite = this.cache.startReadWrite(this.key, this.readPosition);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            startReadWrite = this.cache.startReadWriteNonBlocking(this.key, this.readPosition);
        }
        if (startReadWrite == null) {
            dataSource = this.upstreamDataSource;
            dataSpec2 = new DataSpec(this.uri, this.readPosition, this.bytesRemaining, this.key, this.flags);
        } else if (startReadWrite.isCached) {
            Uri fromFile = Uri.fromFile(startReadWrite.file);
            long j2 = this.readPosition - startReadWrite.position;
            long j3 = startReadWrite.length - j2;
            long j4 = this.bytesRemaining;
            if (j4 != -1) {
                j3 = Math.min(j3, j4);
            }
            dataSpec2 = new DataSpec(fromFile, this.readPosition, j2, j3, this.key, this.flags);
            dataSource = this.cacheReadDataSource;
        } else {
            if (startReadWrite.isOpenEnded()) {
                j = this.bytesRemaining;
            } else {
                j = startReadWrite.length;
                long j5 = this.bytesRemaining;
                if (j5 != -1) {
                    j = Math.min(j, j5);
                }
            }
            dataSpec = new DataSpec(this.uri, this.readPosition, j, this.key, this.flags);
            DataSource dataSource2 = this.cacheWriteDataSource;
            if (dataSource2 != null) {
                dataSource = dataSource2;
                cacheSpan = startReadWrite;
                this.checkCachePosition = (this.currentRequestIgnoresCache && dataSource == this.upstreamDataSource) ? this.readPosition + MIN_READ_BEFORE_CHECKING_CACHE : Long.MAX_VALUE;
                if (z) {
                    Assertions.checkState(isBypassingCache());
                    if (dataSource == this.upstreamDataSource) {
                        return;
                    }
                    try {
                        closeCurrentSource();
                    } catch (Throwable th) {
                        if (cacheSpan.isHoleSpan()) {
                            this.cache.releaseHoleSpan(cacheSpan);
                        }
                        throw th;
                    }
                }
                if (cacheSpan != null && cacheSpan.isHoleSpan()) {
                    this.currentHoleSpan = cacheSpan;
                }
                this.currentDataSource = dataSource;
                this.currentDataSpecLengthUnset = dataSpec.length == -1;
                open = dataSource.open(dataSpec);
                contentMetadataMutations = new ContentMetadataMutations();
                if (this.currentDataSpecLengthUnset && open != -1) {
                    this.bytesRemaining = open;
                    ContentMetadataInternal.setContentLength(contentMetadataMutations, this.readPosition + open);
                }
                if (isReadingFromUpstream()) {
                    Uri uri = this.currentDataSource.getUri();
                    this.actualUri = uri;
                    if (this.uri.equals(uri)) {
                        ContentMetadataInternal.removeRedirectedUri(contentMetadataMutations);
                    } else {
                        ContentMetadataInternal.setRedirectedUri(contentMetadataMutations, this.actualUri);
                    }
                }
                if (isWritingToCache()) {
                    this.cache.applyContentMetadataMutations(this.key, contentMetadataMutations);
                    return;
                }
                return;
            }
            DataSource dataSource3 = this.upstreamDataSource;
            this.cache.releaseHoleSpan(startReadWrite);
            cacheSpan = null;
            dataSource = dataSource3;
            this.checkCachePosition = (this.currentRequestIgnoresCache && dataSource == this.upstreamDataSource) ? this.readPosition + MIN_READ_BEFORE_CHECKING_CACHE : Long.MAX_VALUE;
            if (z) {
            }
            if (cacheSpan != null) {
                this.currentHoleSpan = cacheSpan;
            }
            this.currentDataSource = dataSource;
            this.currentDataSpecLengthUnset = dataSpec.length == -1;
            open = dataSource.open(dataSpec);
            contentMetadataMutations = new ContentMetadataMutations();
            if (this.currentDataSpecLengthUnset) {
                this.bytesRemaining = open;
                ContentMetadataInternal.setContentLength(contentMetadataMutations, this.readPosition + open);
            }
            if (isReadingFromUpstream()) {
            }
            if (isWritingToCache()) {
            }
        }
        dataSpec = dataSpec2;
        cacheSpan = startReadWrite;
        this.checkCachePosition = (this.currentRequestIgnoresCache && dataSource == this.upstreamDataSource) ? this.readPosition + MIN_READ_BEFORE_CHECKING_CACHE : Long.MAX_VALUE;
        if (z) {
        }
        if (cacheSpan != null) {
        }
        this.currentDataSource = dataSource;
        this.currentDataSpecLengthUnset = dataSpec.length == -1;
        open = dataSource.open(dataSpec);
        contentMetadataMutations = new ContentMetadataMutations();
        if (this.currentDataSpecLengthUnset) {
        }
        if (isReadingFromUpstream()) {
        }
        if (isWritingToCache()) {
        }
    }

    private void setNoBytesRemainingAndMaybeStoreLength() throws IOException {
        this.bytesRemaining = 0L;
        if (isWritingToCache()) {
            this.cache.setContentLength(this.key, this.readPosition);
        }
    }

    private int shouldIgnoreCacheForRequest(DataSpec dataSpec) {
        if (this.ignoreCacheOnError && this.seenCacheError) {
            return 0;
        }
        return (this.ignoreCacheForUnsetLengthRequests && dataSpec.length == -1) ? 1 : -1;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        this.uri = null;
        this.actualUri = null;
        notifyBytesRead();
        try {
            closeCurrentSource();
        } catch (IOException e) {
            handleBeforeThrow(e);
            throw e;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.actualUri;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        try {
            String key = CacheUtil.getKey(dataSpec);
            this.key = key;
            Uri uri = dataSpec.uri;
            this.uri = uri;
            this.actualUri = getRedirectedUriOrDefault(this.cache, key, uri);
            this.flags = dataSpec.flags;
            this.readPosition = dataSpec.position;
            int shouldIgnoreCacheForRequest = shouldIgnoreCacheForRequest(dataSpec);
            boolean z = shouldIgnoreCacheForRequest != -1;
            this.currentRequestIgnoresCache = z;
            if (z) {
                notifyCacheIgnored(shouldIgnoreCacheForRequest);
            }
            long j = dataSpec.length;
            if (j == -1 && !this.currentRequestIgnoresCache) {
                long contentLength = this.cache.getContentLength(this.key);
                this.bytesRemaining = contentLength;
                if (contentLength != -1) {
                    long j2 = contentLength - dataSpec.position;
                    this.bytesRemaining = j2;
                    if (j2 <= 0) {
                        throw new DataSourceException(0);
                    }
                }
                openNextSource(false);
                return this.bytesRemaining;
            }
            this.bytesRemaining = j;
            openNextSource(false);
            return this.bytesRemaining;
        } catch (IOException e) {
            handleBeforeThrow(e);
            throw e;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            if (this.readPosition >= this.checkCachePosition) {
                openNextSource(true);
            }
            int read = this.currentDataSource.read(bArr, i, i2);
            if (read == -1) {
                if (this.currentDataSpecLengthUnset) {
                    setNoBytesRemainingAndMaybeStoreLength();
                    return read;
                }
                long j = this.bytesRemaining;
                if (j <= 0) {
                    if (j == -1) {
                    }
                }
                closeCurrentSource();
                openNextSource(false);
                return read(bArr, i, i2);
            }
            if (isReadingFromCache()) {
                this.totalCachedBytesRead += read;
            }
            long j2 = read;
            this.readPosition += j2;
            long j3 = this.bytesRemaining;
            if (j3 != -1) {
                this.bytesRemaining = j3 - j2;
                return read;
            }
            return read;
        } catch (IOException e) {
            if (this.currentDataSpecLengthUnset && isCausedByPositionOutOfRange(e)) {
                setNoBytesRemainingAndMaybeStoreLength();
                return -1;
            }
            handleBeforeThrow(e);
            throw e;
        }
    }

    public CacheDataSource(Cache cache, DataSource dataSource, int i) {
        this(cache, dataSource, i, 2097152L);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, int i, long j) {
        this(cache, dataSource, new FileDataSource(), new CacheDataSink(cache, j), i, null);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, DataSource dataSource2, DataSink dataSink, int i, EventListener eventListener) {
        this.cache = cache;
        this.cacheReadDataSource = dataSource2;
        this.blockOnCache = (i & 1) != 0;
        this.ignoreCacheOnError = (i & 2) != 0;
        this.ignoreCacheForUnsetLengthRequests = (i & 4) != 0;
        this.upstreamDataSource = dataSource;
        if (dataSink != null) {
            this.cacheWriteDataSource = new TeeDataSource(dataSource, dataSink);
        } else {
            this.cacheWriteDataSource = null;
        }
        this.eventListener = eventListener;
    }
}
