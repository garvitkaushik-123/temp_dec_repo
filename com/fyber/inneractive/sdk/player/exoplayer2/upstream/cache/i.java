package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.util.p;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedContentIndex;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public final class i {
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.c c;
    public boolean f;
    public p g;
    public final Cipher d = null;
    public final SecretKeySpec e = null;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1560a = new HashMap();
    public final SparseArray b = new SparseArray();

    public i(File file) {
        this.c = new com.fyber.inneractive.sdk.player.exoplayer2.util.c(new File(file, CachedContentIndex.FILE_NAME));
    }

    public final void a() {
        LinkedList linkedList = new LinkedList();
        for (h hVar : this.f1560a.values()) {
            if (hVar.c.isEmpty()) {
                linkedList.add(hVar.b);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            h hVar2 = (h) this.f1560a.remove((String) it.next());
            if (hVar2 != null) {
                if (!hVar2.c.isEmpty()) {
                    throw new IllegalStateException();
                }
                this.b.remove(hVar2.f1559a);
                this.f = true;
            }
        }
    }

    public final void b() {
        DataOutputStream dataOutputStream;
        IOException e;
        Throwable th;
        if (!this.f) {
            return;
        }
        DataOutputStream dataOutputStream2 = null;
        try {
            com.fyber.inneractive.sdk.player.exoplayer2.util.b b = this.c.b();
            p pVar = this.g;
            if (pVar == null) {
                this.g = new p(b);
            } else {
                pVar.a(b);
            }
            dataOutputStream = new DataOutputStream(this.g);
            try {
                dataOutputStream.writeInt(1);
                dataOutputStream.writeInt(this.d != null ? 1 : 0);
                if (this.d != null) {
                    byte[] bArr = new byte[16];
                    new Random().nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        this.d.init(1, this.e, new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream2 = new DataOutputStream(new CipherOutputStream(this.g, this.d));
                    } catch (InvalidAlgorithmParameterException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e3) {
                        e = e3;
                        throw new IllegalStateException(e);
                    }
                } else {
                    dataOutputStream2 = dataOutputStream;
                }
                dataOutputStream2.writeInt(this.f1560a.size());
                int i = 0;
                for (h hVar : this.f1560a.values()) {
                    dataOutputStream2.writeInt(hVar.f1559a);
                    dataOutputStream2.writeUTF(hVar.b);
                    dataOutputStream2.writeLong(hVar.d);
                    int hashCode = (hVar.b.hashCode() + (hVar.f1559a * 31)) * 31;
                    long j = hVar.d;
                    i += hashCode + ((int) (j ^ (j >>> 32)));
                }
                dataOutputStream2.writeInt(i);
                com.fyber.inneractive.sdk.player.exoplayer2.util.c cVar = this.c;
                cVar.getClass();
                dataOutputStream2.close();
                cVar.b.delete();
                int i2 = z.f1599a;
                this.f = false;
            } catch (IOException e4) {
                e = e4;
                try {
                    throw new a(e);
                } catch (Throwable th2) {
                    DataOutputStream dataOutputStream3 = dataOutputStream;
                    th = th2;
                    dataOutputStream2 = dataOutputStream3;
                    Throwable th3 = th;
                    dataOutputStream = dataOutputStream2;
                    th = th3;
                    z.a(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                z.a(dataOutputStream);
                throw th;
            }
        } catch (IOException e5) {
            dataOutputStream = dataOutputStream2;
            e = e5;
        } catch (Throwable th5) {
            th = th5;
            Throwable th32 = th;
            dataOutputStream = dataOutputStream2;
            th = th32;
            z.a(dataOutputStream);
            throw th;
        }
    }

    public final h a(String str, long j) {
        SparseArray sparseArray = this.b;
        int size = sparseArray.size();
        int i = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            keyAt = i;
        }
        h hVar = new h(keyAt, str, j);
        this.f1560a.put(str, hVar);
        this.b.put(keyAt, str);
        this.f = true;
        return hVar;
    }
}
