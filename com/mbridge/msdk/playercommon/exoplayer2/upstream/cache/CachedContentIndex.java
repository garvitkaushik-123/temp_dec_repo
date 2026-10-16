package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import android.util.SparseArray;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.AtomicFile;
import com.mbridge.msdk.playercommon.exoplayer2.util.ReusableBufferedOutputStream;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
class CachedContentIndex {
    public static final String FILE_NAME = "cached_content_index.exi";
    private static final int FLAG_ENCRYPTED_INDEX = 1;
    private static final int VERSION = 2;
    private final AtomicFile atomicFile;
    private ReusableBufferedOutputStream bufferedOutputStream;
    private boolean changed;
    private final Cipher cipher;
    private final boolean encrypt;
    private final SparseArray<String> idToKey;
    private final HashMap<String, CachedContent> keyToContent;
    private final SecretKeySpec secretKeySpec;

    public CachedContentIndex(File file) {
        this(file, null);
    }

    private void add(CachedContent cachedContent) {
        this.keyToContent.put(cachedContent.key, cachedContent);
        this.idToKey.put(cachedContent.id, cachedContent.key);
    }

    private CachedContent addNew(String str) {
        CachedContent cachedContent = new CachedContent(getNewId(this.idToKey), str);
        add(cachedContent);
        this.changed = true;
        return cachedContent;
    }

    private static Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (Util.SDK_INT == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public static int getNewId(SparseArray<String> sparseArray) {
        int size = sparseArray.size();
        int i = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt >= 0) {
            return keyAt;
        }
        while (i < size && i == sparseArray.keyAt(i)) {
            i++;
        }
        return i;
    }

    private boolean readFile() {
        DataInputStream dataInputStream = null;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.atomicFile.openRead());
            DataInputStream dataInputStream2 = new DataInputStream(bufferedInputStream);
            try {
                int readInt = dataInputStream2.readInt();
                if (readInt >= 0 && readInt <= 2) {
                    if ((dataInputStream2.readInt() & 1) != 0) {
                        if (this.cipher == null) {
                            Util.closeQuietly(dataInputStream2);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream2.readFully(bArr);
                        try {
                            this.cipher.init(2, this.secretKeySpec, new IvParameterSpec(bArr));
                            dataInputStream2 = new DataInputStream(new CipherInputStream(bufferedInputStream, this.cipher));
                        } catch (InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        }
                    } else if (this.encrypt) {
                        this.changed = true;
                    }
                    int readInt2 = dataInputStream2.readInt();
                    int i = 0;
                    for (int i2 = 0; i2 < readInt2; i2++) {
                        CachedContent readFromStream = CachedContent.readFromStream(readInt, dataInputStream2);
                        add(readFromStream);
                        i += readFromStream.headerHashCode(readInt);
                    }
                    int readInt3 = dataInputStream2.readInt();
                    boolean z = dataInputStream2.read() == -1;
                    if (readInt3 == i && z) {
                        Util.closeQuietly(dataInputStream2);
                        return true;
                    }
                    Util.closeQuietly(dataInputStream2);
                    return false;
                }
                Util.closeQuietly(dataInputStream2);
                return false;
            } catch (IOException unused) {
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    Util.closeQuietly(dataInputStream);
                }
                return false;
            } catch (Throwable th) {
                th = th;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    Util.closeQuietly(dataInputStream);
                }
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.DataOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.DataOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.mbridge.msdk.playercommon.exoplayer2.util.AtomicFile] */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedContent] */
    private void writeFile() throws Cache.CacheException {
        ?? r1;
        Throwable th;
        IOException e;
        Object obj = null;
        try {
            OutputStream startWrite = this.atomicFile.startWrite();
            ReusableBufferedOutputStream reusableBufferedOutputStream = this.bufferedOutputStream;
            if (reusableBufferedOutputStream == null) {
                this.bufferedOutputStream = new ReusableBufferedOutputStream(startWrite);
            } else {
                reusableBufferedOutputStream.reset(startWrite);
            }
            r1 = new DataOutputStream(this.bufferedOutputStream);
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            r1 = obj;
            th = th3;
            Util.closeQuietly((Closeable) r1);
            throw th;
        }
        try {
            r1.writeInt(2);
            r1.writeInt(this.encrypt ? 1 : 0);
            r1 = r1;
            if (this.encrypt) {
                byte[] bArr = new byte[16];
                new Random().nextBytes(bArr);
                r1.write(bArr);
                try {
                    this.cipher.init(1, this.secretKeySpec, new IvParameterSpec(bArr));
                    r1.flush();
                    r1 = new DataOutputStream(new CipherOutputStream(this.bufferedOutputStream, this.cipher));
                } catch (InvalidAlgorithmParameterException e3) {
                    e = e3;
                    throw new IllegalStateException(e);
                } catch (InvalidKeyException e4) {
                    e = e4;
                    throw new IllegalStateException(e);
                }
            }
            try {
                try {
                    r1.writeInt(this.keyToContent.size());
                    int i = 0;
                    for (CachedContent cachedContent : this.keyToContent.values()) {
                        cachedContent.writeToStream(r1);
                        i += cachedContent.headerHashCode(2);
                    }
                    r1.writeInt(i);
                    this.atomicFile.endWrite(r1);
                    Util.closeQuietly((Closeable) null);
                } catch (IOException e5) {
                    Object obj2 = r1;
                    e = e5;
                    obj = obj2;
                    IOException iOException = e;
                    r1 = obj;
                    e = iOException;
                    throw new Cache.CacheException(e);
                }
            } catch (Throwable th4) {
                Object obj3 = r1;
                th = th4;
                obj = obj3;
                Throwable th32 = th;
                r1 = obj;
                th = th32;
                Util.closeQuietly((Closeable) r1);
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            throw new Cache.CacheException(e);
        } catch (Throwable th5) {
            th = th5;
            Util.closeQuietly((Closeable) r1);
            throw th;
        }
    }

    public void applyContentMetadataMutations(String str, ContentMetadataMutations contentMetadataMutations) {
        if (getOrAdd(str).applyMetadataMutations(contentMetadataMutations)) {
            this.changed = true;
        }
    }

    public int assignIdForKey(String str) {
        return getOrAdd(str).id;
    }

    public CachedContent get(String str) {
        return this.keyToContent.get(str);
    }

    public Collection<CachedContent> getAll() {
        return this.keyToContent.values();
    }

    public ContentMetadata getContentMetadata(String str) {
        CachedContent cachedContent = get(str);
        return cachedContent != null ? cachedContent.getMetadata() : DefaultContentMetadata.EMPTY;
    }

    public String getKeyForId(int i) {
        return this.idToKey.get(i);
    }

    public Set<String> getKeys() {
        return this.keyToContent.keySet();
    }

    public CachedContent getOrAdd(String str) {
        CachedContent cachedContent = this.keyToContent.get(str);
        return cachedContent == null ? addNew(str) : cachedContent;
    }

    public void load() {
        Assertions.checkState(!this.changed);
        if (readFile()) {
            return;
        }
        this.atomicFile.delete();
        this.keyToContent.clear();
        this.idToKey.clear();
    }

    public void maybeRemove(String str) {
        CachedContent cachedContent = this.keyToContent.get(str);
        if (cachedContent == null || !cachedContent.isEmpty() || cachedContent.isLocked()) {
            return;
        }
        this.keyToContent.remove(str);
        this.idToKey.remove(cachedContent.id);
        this.changed = true;
    }

    public void removeEmpty() {
        int size = this.keyToContent.size();
        String[] strArr = new String[size];
        this.keyToContent.keySet().toArray(strArr);
        for (int i = 0; i < size; i++) {
            maybeRemove(strArr[i]);
        }
    }

    public void store() throws Cache.CacheException {
        if (this.changed) {
            writeFile();
            this.changed = false;
        }
    }

    public CachedContentIndex(File file, byte[] bArr) {
        this(file, bArr, bArr != null);
    }

    public CachedContentIndex(File file, byte[] bArr, boolean z) {
        this.encrypt = z;
        if (bArr != null) {
            Assertions.checkArgument(bArr.length == 16);
            try {
                this.cipher = getCipher();
                this.secretKeySpec = new SecretKeySpec(bArr, "AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new IllegalStateException(e);
            }
        } else {
            Assertions.checkState(!z);
            this.cipher = null;
            this.secretKeySpec = null;
        }
        this.keyToContent = new HashMap<>();
        this.idToKey = new SparseArray<>();
        this.atomicFile = new AtomicFile(new File(file, FILE_NAME));
    }
}
