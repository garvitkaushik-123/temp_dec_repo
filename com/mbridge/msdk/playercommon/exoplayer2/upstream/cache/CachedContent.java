package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.TreeSet;

/* loaded from: classes6.dex */
final class CachedContent {
    private static final int VERSION_MAX = Integer.MAX_VALUE;
    private static final int VERSION_METADATA_INTRODUCED = 2;
    public final int id;
    public final String key;
    private boolean locked;
    private DefaultContentMetadata metadata = DefaultContentMetadata.EMPTY;
    private final TreeSet<SimpleCacheSpan> cachedSpans = new TreeSet<>();

    public CachedContent(int i, String str) {
        this.id = i;
        this.key = str;
    }

    public static CachedContent readFromStream(int i, DataInputStream dataInputStream) throws IOException {
        CachedContent cachedContent = new CachedContent(dataInputStream.readInt(), dataInputStream.readUTF());
        if (i >= 2) {
            cachedContent.metadata = DefaultContentMetadata.readFromStream(dataInputStream);
            return cachedContent;
        }
        long readLong = dataInputStream.readLong();
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        ContentMetadataInternal.setContentLength(contentMetadataMutations, readLong);
        cachedContent.applyMetadataMutations(contentMetadataMutations);
        return cachedContent;
    }

    public void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.cachedSpans.add(simpleCacheSpan);
    }

    public boolean applyMetadataMutations(ContentMetadataMutations contentMetadataMutations) {
        this.metadata = this.metadata.copyWithMutationsApplied(contentMetadataMutations);
        return !r2.equals(r0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && CachedContent.class == obj.getClass()) {
            CachedContent cachedContent = (CachedContent) obj;
            if (this.id == cachedContent.id && this.key.equals(cachedContent.key) && this.cachedSpans.equals(cachedContent.cachedSpans) && this.metadata.equals(cachedContent.metadata)) {
                return true;
            }
        }
        return false;
    }

    public long getCachedBytesLength(long j, long j2) {
        SimpleCacheSpan span = getSpan(j);
        if (span.isHoleSpan()) {
            return -Math.min(span.isOpenEnded() ? Long.MAX_VALUE : span.length, j2);
        }
        long j3 = j + j2;
        long j4 = span.position + span.length;
        if (j4 < j3) {
            for (SimpleCacheSpan simpleCacheSpan : this.cachedSpans.tailSet(span, false)) {
                long j5 = simpleCacheSpan.position;
                if (j5 > j4) {
                    break;
                }
                j4 = Math.max(j4, j5 + simpleCacheSpan.length);
                if (j4 >= j3) {
                    break;
                }
            }
        }
        return Math.min(j4 - j, j2);
    }

    public ContentMetadata getMetadata() {
        return this.metadata;
    }

    public SimpleCacheSpan getSpan(long j) {
        SimpleCacheSpan createLookup = SimpleCacheSpan.createLookup(this.key, j);
        SimpleCacheSpan floor = this.cachedSpans.floor(createLookup);
        if (floor != null && floor.position + floor.length > j) {
            return floor;
        }
        SimpleCacheSpan ceiling = this.cachedSpans.ceiling(createLookup);
        return ceiling == null ? SimpleCacheSpan.createOpenHole(this.key, j) : SimpleCacheSpan.createClosedHole(this.key, j, ceiling.position - j);
    }

    public TreeSet<SimpleCacheSpan> getSpans() {
        return this.cachedSpans;
    }

    public int hashCode() {
        return (headerHashCode(Integer.MAX_VALUE) * 31) + this.cachedSpans.hashCode();
    }

    public int headerHashCode(int i) {
        int i2;
        int hashCode;
        int hashCode2 = (this.id * 31) + this.key.hashCode();
        if (i < 2) {
            long contentLength = ContentMetadataInternal.getContentLength(this.metadata);
            i2 = hashCode2 * 31;
            hashCode = (int) (contentLength ^ (contentLength >>> 32));
        } else {
            i2 = hashCode2 * 31;
            hashCode = this.metadata.hashCode();
        }
        return i2 + hashCode;
    }

    public boolean isEmpty() {
        return this.cachedSpans.isEmpty();
    }

    public boolean isLocked() {
        return this.locked;
    }

    public boolean removeSpan(CacheSpan cacheSpan) {
        if (!this.cachedSpans.remove(cacheSpan)) {
            return false;
        }
        cacheSpan.file.delete();
        return true;
    }

    public void setLocked(boolean z) {
        this.locked = z;
    }

    public SimpleCacheSpan touch(SimpleCacheSpan simpleCacheSpan) throws Cache.CacheException {
        Assertions.checkState(this.cachedSpans.remove(simpleCacheSpan));
        SimpleCacheSpan copyWithUpdatedLastAccessTime = simpleCacheSpan.copyWithUpdatedLastAccessTime(this.id);
        if (!simpleCacheSpan.file.renameTo(copyWithUpdatedLastAccessTime.file)) {
            throw new Cache.CacheException("Renaming of " + simpleCacheSpan.file + " to " + copyWithUpdatedLastAccessTime.file + " failed.");
        }
        this.cachedSpans.add(copyWithUpdatedLastAccessTime);
        return copyWithUpdatedLastAccessTime;
    }

    public void writeToStream(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.id);
        dataOutputStream.writeUTF(this.key);
        this.metadata.writeToStream(dataOutputStream);
    }
}
