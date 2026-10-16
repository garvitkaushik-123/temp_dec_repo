package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedContentIndex;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final File f1563a;
    public final j b;
    public final i d;
    public a f;
    public final HashMap c = new HashMap();
    public final HashMap e = new HashMap();

    public l(File file, j jVar) {
        this.f1563a = file;
        this.b = jVar;
        this.d = new i(file);
        ConditionVariable conditionVariable = new ConditionVariable();
        new k(this, conditionVariable).start();
        conditionVariable.block();
    }

    public final synchronized m a(String str, long j) {
        String str2;
        m a2;
        a aVar = this.f;
        if (aVar != null) {
            throw aVar;
        }
        h hVar = (h) this.d.f1560a.get(str);
        if (hVar != null) {
            str2 = str;
            while (true) {
                a2 = hVar.a(j);
                if (!a2.d || a2.e.length() == a2.c) {
                    break;
                }
                a();
            }
        } else {
            str2 = str;
            a2 = new m(str2, j, -1L, -9223372036854775807L, null);
        }
        if (!a2.d) {
            if (this.c.containsKey(str2)) {
                return null;
            }
            this.c.put(str2, a2);
            return a2;
        }
        h hVar2 = (h) this.d.f1560a.get(str2);
        if (!hVar2.c.remove(a2)) {
            throw new IllegalStateException();
        }
        int i = hVar2.f1559a;
        if (!a2.d) {
            throw new IllegalStateException();
        }
        long currentTimeMillis = System.currentTimeMillis();
        File parentFile = a2.e.getParentFile();
        long j2 = a2.b;
        Pattern pattern = m.g;
        File file = new File(parentFile, i + "." + j2 + "." + currentTimeMillis + ".v3.exo");
        m mVar = new m(a2.f1558a, a2.b, a2.c, currentTimeMillis, file);
        if (!a2.e.renameTo(file)) {
            throw new a("Renaming of " + a2.e + " to " + file + " failed.");
        }
        hVar2.c.add(mVar);
        ArrayList arrayList = (ArrayList) this.e.get(a2.f1558a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                j jVar = (j) arrayList.get(size);
                jVar.f1561a.remove(a2);
                jVar.b -= a2.c;
                jVar.f1561a.add(mVar);
                jVar.b += mVar.c;
                jVar.a(this, 0L);
            }
        }
        j jVar2 = this.b;
        jVar2.f1561a.remove(a2);
        jVar2.b -= a2.c;
        jVar2.f1561a.add(mVar);
        jVar2.b += mVar.c;
        jVar2.a(this, 0L);
        return mVar;
    }

    public final synchronized void b(m mVar) {
        if (mVar != this.c.remove(mVar.f1558a)) {
            throw new IllegalStateException();
        }
        notifyAll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d3, code lost:
    
        if (r4 == null) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(l lVar) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        File[] listFiles;
        BufferedInputStream bufferedInputStream;
        if (!lVar.f1563a.exists()) {
            lVar.f1563a.mkdirs();
            return;
        }
        i iVar = lVar.d;
        if (!iVar.f) {
            DataInputStream dataInputStream3 = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(iVar.c.a());
                    dataInputStream = new DataInputStream(bufferedInputStream);
                    try {
                    } catch (FileNotFoundException unused) {
                    } catch (IOException e) {
                        e = e;
                        Log.e("CachedContentIndex", "Error reading cache content index file.", e);
                        if (dataInputStream != null) {
                            z.a(dataInputStream);
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.util.c cVar = iVar.c;
                        cVar.f1582a.delete();
                        cVar.b.delete();
                        iVar.f1560a.clear();
                        iVar.b.clear();
                        listFiles = lVar.f1563a.listFiles();
                        if (listFiles != null) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (dataInputStream2 != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
                dataInputStream = null;
            } catch (IOException e2) {
                e = e2;
                dataInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            if (dataInputStream.readInt() == 1) {
                if ((dataInputStream.readInt() & 1) != 0) {
                    if (iVar.d != null) {
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            iVar.d.init(2, iVar.e, new IvParameterSpec(bArr));
                            dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, iVar.d));
                        } catch (InvalidAlgorithmParameterException e3) {
                            e = e3;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e4) {
                            e = e4;
                            throw new IllegalStateException(e);
                        }
                    }
                } else if (iVar.d != null) {
                    iVar.f = true;
                }
                try {
                    int readInt = dataInputStream.readInt();
                    int i = 0;
                    for (int i2 = 0; i2 < readInt; i2++) {
                        int readInt2 = dataInputStream.readInt();
                        String readUTF = dataInputStream.readUTF();
                        h hVar = new h(readInt2, readUTF, dataInputStream.readLong());
                        iVar.f1560a.put(readUTF, hVar);
                        iVar.b.put(readInt2, readUTF);
                        int hashCode = readUTF.hashCode();
                        long j = hVar.d;
                        i += ((hashCode + (readInt2 * 31)) * 31) + ((int) (j ^ (j >>> 32)));
                    }
                    if (dataInputStream.readInt() == i) {
                        z.a(dataInputStream);
                        listFiles = lVar.f1563a.listFiles();
                        if (listFiles != null) {
                            return;
                        }
                        for (File file : listFiles) {
                            if (!file.getName().equals(CachedContentIndex.FILE_NAME)) {
                                m a2 = file.length() > 0 ? m.a(file, lVar.d) : null;
                                if (a2 != null) {
                                    lVar.a(a2);
                                } else {
                                    file.delete();
                                }
                            }
                        }
                        lVar.d.a();
                        lVar.d.b();
                        return;
                    }
                    z.a(dataInputStream);
                    com.fyber.inneractive.sdk.player.exoplayer2.util.c cVar2 = iVar.c;
                    cVar2.f1582a.delete();
                    cVar2.b.delete();
                    iVar.f1560a.clear();
                    iVar.b.clear();
                    listFiles = lVar.f1563a.listFiles();
                    if (listFiles != null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream3 = dataInputStream;
                    dataInputStream2 = dataInputStream3;
                    if (dataInputStream2 != null) {
                        z.a(dataInputStream2);
                    }
                    throw th;
                }
            }
            z.a(dataInputStream);
            com.fyber.inneractive.sdk.player.exoplayer2.util.c cVar22 = iVar.c;
            cVar22.f1582a.delete();
            cVar22.b.delete();
            iVar.f1560a.clear();
            iVar.b.clear();
            listFiles = lVar.f1563a.listFiles();
            if (listFiles != null) {
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final void a(m mVar) {
        i iVar = this.d;
        String str = mVar.f1558a;
        h hVar = (h) iVar.f1560a.get(str);
        if (hVar == null) {
            hVar = iVar.a(str, -1L);
        }
        hVar.c.add(mVar);
        ArrayList arrayList = (ArrayList) this.e.get(mVar.f1558a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                j jVar = (j) arrayList.get(size);
                jVar.f1561a.add(mVar);
                jVar.b += mVar.c;
                jVar.a(this, 0L);
            }
        }
        j jVar2 = this.b;
        jVar2.f1561a.add(mVar);
        jVar2.b += mVar.c;
        jVar2.a(this, 0L);
    }

    public final void a(g gVar, boolean z) {
        h hVar = (h) this.d.f1560a.get(gVar.f1558a);
        if (hVar == null || !hVar.c.remove(gVar)) {
            return;
        }
        gVar.e.delete();
        if (z && hVar.c.isEmpty()) {
            i iVar = this.d;
            h hVar2 = (h) iVar.f1560a.remove(hVar.b);
            if (hVar2 != null) {
                if (hVar2.c.isEmpty()) {
                    iVar.b.remove(hVar2.f1559a);
                    iVar.f = true;
                } else {
                    throw new IllegalStateException();
                }
            }
            this.d.b();
        }
        ArrayList arrayList = (ArrayList) this.e.get(gVar.f1558a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                j jVar = (j) arrayList.get(size);
                jVar.f1561a.remove(gVar);
                jVar.b -= gVar.c;
            }
        }
        j jVar2 = this.b;
        jVar2.f1561a.remove(gVar);
        jVar2.b -= gVar.c;
    }

    public final void a() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.d.f1560a.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((h) it.next()).c.iterator();
            while (it2.hasNext()) {
                g gVar = (g) it2.next();
                if (gVar.e.length() != gVar.c) {
                    linkedList.add(gVar);
                }
            }
        }
        Iterator it3 = linkedList.iterator();
        while (it3.hasNext()) {
            a((g) it3.next(), false);
        }
        this.d.a();
        this.d.b();
    }

    public final synchronized long a(String str) {
        h hVar;
        hVar = (h) this.d.f1560a.get(str);
        return hVar == null ? -1L : hVar.d;
    }
}
