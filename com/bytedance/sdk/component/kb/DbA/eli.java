package com.bytedance.sdk.component.kb.DbA;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.DbA.eli.MGA;
import com.bytedance.sdk.component.DbA.eli.du;
import com.bytedance.sdk.component.DbA.eli.nlS;
import com.bytedance.sdk.component.DbA.eli.nn;
import com.google.common.net.HttpHeaders;
import com.inmobi.unification.sdk.InitializationStatus;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: classes3.dex */
public class eli extends Os {
    public File DbA;
    private volatile boolean aAs;
    public File eli;

    public eli(du duVar) {
        super(duVar);
    }

    public void eli(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.eli = new File(str, str2);
        this.DbA = new File(str, str2 + ".temp");
    }

    public void eli(final com.bytedance.sdk.component.kb.eli.eli eliVar) {
        File file = this.eli;
        if (file == null || this.DbA == null) {
            if (eliVar != null) {
                eliVar.eli(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.eli.length() != 0 && eliVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.kb.DbA dbA = new com.bytedance.sdk.component.kb.DbA(true, 200, InitializationStatus.SUCCESS, null, null, currentTimeMillis, currentTimeMillis);
            dbA.eli(this.eli);
            eliVar.eli(this, dbA);
            return;
        }
        long length = this.DbA.length();
        final long j = length >= 0 ? length : 0L;
        nlS.eli eliVar2 = new nlS.eli();
        eliVar2.eli((Object) Os());
        DbA("Range", "bytes=" + j + "-");
        if (TextUtils.isEmpty(this.wC)) {
            eliVar.eli(this, new IOException("Url is Empty"));
            return;
        }
        try {
            eliVar2.DbA(this.wC);
            if (!TextUtils.isEmpty(this.ui)) {
                eliVar2.eli(this.ui);
            }
            if (this.MGA > 0) {
                eliVar2.eli(this.MGA);
            }
            eli(eliVar2);
            com.bytedance.sdk.component.DbA.eli.DbA eli = this.Os.eli(eliVar2.eli().DbA());
            if (eli == null) {
                eliVar.eli(this, new IOException("new call error"));
            } else {
                eli.eli(new com.bytedance.sdk.component.DbA.eli.Os() { // from class: com.bytedance.sdk.component.kb.DbA.eli.1
                    @Override // com.bytedance.sdk.component.DbA.eli.Os
                    public void eli(com.bytedance.sdk.component.DbA.eli.DbA dbA2, IOException iOException) {
                        com.bytedance.sdk.component.kb.eli.eli eliVar3 = eliVar;
                        if (eliVar3 != null) {
                            eliVar3.eli(eli.this, iOException);
                        }
                        eli.this.ui();
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:101:0x0231, code lost:
                    
                        if (0 != 0) goto L107;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:79:0x0210, code lost:
                    
                        if (r9 != null) goto L107;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:87:0x0212, code lost:
                    
                        r9.close();
                     */
                    /* JADX WARN: Removed duplicated region for block: B:54:0x0162 A[Catch: all -> 0x0219, TryCatch #5 {all -> 0x0219, blocks: (B:46:0x0139, B:48:0x0147, B:50:0x014b, B:51:0x0151, B:52:0x0158, B:54:0x0162, B:56:0x016e, B:58:0x017f, B:62:0x018a, B:63:0x0191, B:64:0x0176, B:67:0x0194, B:69:0x019c, B:72:0x01a8, B:74:0x01b2, B:76:0x01be, B:78:0x01cc, B:90:0x01db, B:91:0x01e8, B:94:0x0202), top: B:45:0x0139 }] */
                    /* JADX WARN: Removed duplicated region for block: B:65:0x0192 A[SYNTHETIC] */
                    @Override // com.bytedance.sdk.component.DbA.eli.Os
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void eli(com.bytedance.sdk.component.DbA.eli.DbA dbA2, nn nnVar) throws IOException {
                        RandomAccessFile randomAccessFile;
                        long j2;
                        byte[] bArr;
                        int i;
                        long j3;
                        int read;
                        if (eliVar == null) {
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        if (nnVar == null) {
                            return;
                        }
                        MGA kb = nnVar.kb();
                        if (kb != null) {
                            for (int i2 = 0; i2 < kb.eli(); i2++) {
                                hashMap.put(kb.eli(i2), kb.DbA(i2));
                            }
                        }
                        com.bytedance.sdk.component.kb.DbA dbA3 = new com.bytedance.sdk.component.kb.DbA(nnVar.aGH(), nnVar.Os(), nnVar.ui(), hashMap, null, nnVar.DbA(), nnVar.eli());
                        if (nnVar.aGH()) {
                            long eli2 = nnVar.MGA().eli();
                            long j4 = 0;
                            if (eli2 <= 0) {
                                eli2 = eli.MGA(hashMap);
                            }
                            boolean ui = eli.ui(hashMap);
                            if (ui) {
                                eli2 += j;
                                String str = (String) hashMap.get(HttpHeaders.CONTENT_RANGE);
                                if (!TextUtils.isEmpty(str)) {
                                    String str2 = "bytes " + j + "-" + (eli2 - 1);
                                    if (TextUtils.indexOf(str, str2) == -1) {
                                        eli.this.ui();
                                        eliVar.eli(eli.this, new IOException("The Content-Range Header is invalid Assume[" + str2 + "] vs Real[" + str + "], please remove the temporary file [" + eli.this.DbA + "]."));
                                        return;
                                    }
                                }
                            }
                            if (eli2 > 0 && eli.this.DbA.exists() && eli.this.DbA.length() == eli2) {
                                if (!eli.this.DbA.renameTo(eli.this.eli)) {
                                    eliVar.eli(eli.this, new IOException("Rename fail"));
                                    return;
                                } else {
                                    dbA3.eli(eli.this.eli);
                                    eliVar.eli(eli.this, dbA3);
                                    return;
                                }
                            }
                            InputStream inputStream = null;
                            try {
                                randomAccessFile = new RandomAccessFile(eli.this.DbA, "rw");
                            } catch (Throwable unused) {
                                randomAccessFile = null;
                            }
                            if (ui) {
                                randomAccessFile.seek(j);
                                j2 = j;
                                try {
                                    inputStream = nnVar.MGA().Os();
                                    if (eli.kb(hashMap) && !(inputStream instanceof GZIPInputStream)) {
                                        inputStream = new GZIPInputStream(inputStream);
                                    }
                                    bArr = new byte[16384];
                                    long j5 = 0;
                                    i = 0;
                                    while (true) {
                                        j3 = j4;
                                        read = inputStream.read(bArr, i, 16384 - i);
                                        if (read == -1) {
                                            i += read;
                                            j5 += read;
                                            if (j5 % 16384 == j3 || j5 == eli2 - j) {
                                                randomAccessFile.seek(j2);
                                                randomAccessFile.write(bArr, 0, i);
                                                j2 += i;
                                                i = 0;
                                            }
                                            if (eli.this.aAs) {
                                                throw new IOException("net is cancel");
                                            }
                                            j4 = j3;
                                        } else {
                                            if (i != 0) {
                                                randomAccessFile.seek(j2);
                                                randomAccessFile.write(bArr, 0, i);
                                            }
                                            if (!ui) {
                                                eli2 = eli.this.DbA.length();
                                            }
                                            if (eli2 > j3 && eli.this.DbA.exists() && eli.this.DbA.length() == eli2) {
                                                if (!eli.this.DbA.renameTo(eli.this.eli)) {
                                                    eliVar.eli(eli.this, new IOException("Rename fail"));
                                                } else {
                                                    dbA3.eli(eli.this.eli);
                                                    eliVar.eli(eli.this, dbA3);
                                                }
                                            } else {
                                                eliVar.eli(eli.this, new IOException(" tempFile.length() == fileSize is" + (eli.this.DbA.length() == eli2)));
                                            }
                                        }
                                    }
                                } catch (Throwable th) {
                                    try {
                                        eliVar.eli(eli.this, new IOException(th.getMessage()));
                                        if (!ui) {
                                            eli.this.ui();
                                        }
                                    } finally {
                                    }
                                }
                            } else {
                                randomAccessFile.setLength(0L);
                                j2 = 0;
                                inputStream = nnVar.MGA().Os();
                                if (eli.kb(hashMap)) {
                                    inputStream = new GZIPInputStream(inputStream);
                                }
                                bArr = new byte[16384];
                                long j52 = 0;
                                i = 0;
                                while (true) {
                                    j3 = j4;
                                    read = inputStream.read(bArr, i, 16384 - i);
                                    if (read == -1) {
                                    }
                                    j4 = j3;
                                }
                            }
                        } else {
                            eliVar.eli(eli.this, dbA3);
                            return;
                        }
                        try {
                            randomAccessFile.close();
                        } catch (Throwable unused2) {
                        }
                    }
                });
            }
        } catch (IllegalArgumentException unused) {
            eliVar.eli(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:30|(3:32|(2:35|33)|36)|37|(1:39)|40|41|(4:43|44|45|(4:47|(2:49|50)|51|(4:62|63|65|(8:67|68|69|70|71|(1:75)|76|(3:77|78|(10:80|81|82|(6:84|(1:86)|87|88|89|(1:91)(3:92|93|94))|122|123|87|88|89|(0)(0))(6:126|(1:128)|129|(1:173)|133|(5:162|(2:164|165)|168|169|170)(2:139|(5:141|(2:143|144)|147|148|149)(4:(2:153|154)|157|158|159)))))(9:178|179|68|69|70|71|(2:73|75)|76|(4:77|78|(0)(0)|91)))(2:57|(2:59|60)(1:61))))|185|51|(1:53)|62|63|65|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x018c, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0186 A[Catch: all -> 0x018e, TRY_LEAVE, TryCatch #10 {all -> 0x018e, blocks: (B:67:0x0181, B:178:0x0186), top: B:65:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0181 A[Catch: all -> 0x018e, TRY_ENTER, TryCatch #10 {all -> 0x018e, blocks: (B:67:0x0181, B:178:0x0186), top: B:65:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e0 A[LOOP:1: B:77:0x01af->B:91:0x01e0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.bytedance.sdk.component.kb.DbA eli() {
        com.bytedance.sdk.component.kb.DbA dbA;
        long j;
        long j2;
        InputStream inputStream;
        InputStream Os;
        byte[] bArr;
        int i;
        int read;
        eli eliVar = this;
        File file = eliVar.eli;
        if (file == null || eliVar.DbA == null) {
            return null;
        }
        if (file.exists() && eliVar.eli.length() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.kb.DbA dbA2 = new com.bytedance.sdk.component.kb.DbA(true, 200, InitializationStatus.SUCCESS, null, null, currentTimeMillis, currentTimeMillis);
            dbA2.eli(eliVar.eli);
            return dbA2;
        }
        long length = eliVar.DbA.length();
        if (length < 0) {
            length = 0;
        }
        nlS.eli eliVar2 = new nlS.eli();
        eliVar2.eli((Object) eliVar.Os());
        eliVar.DbA("Range", "bytes=" + length + "-");
        if (TextUtils.isEmpty(eliVar.wC)) {
            Log.e("DownloadExecutor", "execute: Url is Empty");
            return null;
        }
        try {
            eliVar2.DbA(eliVar.wC);
            eliVar.eli(eliVar2);
            try {
                com.bytedance.sdk.component.DbA.eli.DbA eli = eliVar.Os.eli(eliVar2.eli().DbA());
                if (eli == null) {
                    return null;
                }
                nn DbA = eli.DbA();
                if (DbA == null || !DbA.aGH()) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                MGA kb = DbA.kb();
                if (kb != null) {
                    for (int i2 = 0; i2 < kb.eli(); i2++) {
                        hashMap.put(kb.eli(i2), kb.DbA(i2));
                    }
                }
                com.bytedance.sdk.component.kb.DbA dbA3 = new com.bytedance.sdk.component.kb.DbA(DbA.aGH(), DbA.Os(), DbA.ui(), hashMap, null, DbA.DbA(), DbA.eli());
                long eli2 = DbA.MGA().eli();
                if (eli2 <= 0) {
                    eli2 = MGA(hashMap);
                }
                long length2 = eliVar.DbA.length();
                boolean ui = ui(hashMap);
                dbA = null;
                if (ui) {
                    eli2 += length2;
                    try {
                        String str = (String) hashMap.get(HttpHeaders.CONTENT_RANGE);
                        if (!TextUtils.isEmpty(str)) {
                            j = 0;
                            String str2 = "bytes " + length2 + "-" + (eli2 - 1);
                            if (TextUtils.indexOf(str, str2) == -1) {
                                new StringBuilder("execute: The Content-Range Header is invalid Assume[").append(str2).append("] vs Real[").append(str).append("], please remove the temporary file [").append(eliVar.DbA);
                                eliVar.ui();
                                return null;
                            }
                            if (eli2 <= j && eliVar.DbA.exists() && eliVar.DbA.length() == eli2) {
                                if (!eliVar.DbA.renameTo(eliVar.eli)) {
                                    return null;
                                }
                                dbA3.eli(eliVar.eli);
                                return dbA3;
                            }
                            RandomAccessFile randomAccessFile = new RandomAccessFile(eliVar.DbA, "rw");
                            if (ui) {
                                randomAccessFile.setLength(j);
                                j2 = 0;
                                Os = DbA.MGA().Os();
                                if (kb(hashMap)) {
                                    Os = new GZIPInputStream(Os);
                                }
                                bArr = new byte[16384];
                                i = 0;
                                long j3 = 0;
                                while (true) {
                                    read = Os.read(bArr, i, 16384 - i);
                                    inputStream = Os;
                                    if (read != -1) {
                                    }
                                    Os = inputStream;
                                }
                            } else {
                                randomAccessFile.seek(length);
                                j2 = length;
                                try {
                                    Os = DbA.MGA().Os();
                                    try {
                                        if (kb(hashMap) && !(Os instanceof GZIPInputStream)) {
                                            Os = new GZIPInputStream(Os);
                                        }
                                        bArr = new byte[16384];
                                        i = 0;
                                        long j32 = 0;
                                        while (true) {
                                            read = Os.read(bArr, i, 16384 - i);
                                            inputStream = Os;
                                            if (read != -1) {
                                                if (read != 0) {
                                                    randomAccessFile.seek(j2);
                                                    randomAccessFile.write(bArr, 0, i);
                                                }
                                                if (!ui || length == 0) {
                                                    eli2 = eliVar.DbA.length();
                                                }
                                                if (eli2 <= 0 || !eliVar.DbA.exists() || eliVar.DbA.length() != eli2) {
                                                    eliVar.DbA.length();
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Throwable unused) {
                                                        }
                                                    }
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Throwable unused2) {
                                                    }
                                                    return null;
                                                }
                                                if (!eliVar.DbA.renameTo(eliVar.eli)) {
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Throwable unused3) {
                                                        }
                                                    }
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Throwable unused4) {
                                                    }
                                                    return null;
                                                }
                                                dbA3.eli(eliVar.eli);
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Throwable unused5) {
                                                    }
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                } catch (Throwable unused6) {
                                                }
                                                return dbA3;
                                            }
                                            i += read;
                                            j32 += read;
                                            try {
                                            } catch (Throwable unused7) {
                                                eliVar = this;
                                            }
                                            try {
                                                if (j32 % 16384 != 0) {
                                                    if (j32 == eli2 - length) {
                                                    }
                                                    eliVar = this;
                                                    if (!eliVar.aAs) {
                                                        throw new IOException("net is cancel");
                                                    }
                                                    Os = inputStream;
                                                }
                                                if (!eliVar.aAs) {
                                                }
                                            } catch (Throwable unused8) {
                                                if (!ui) {
                                                    try {
                                                        eliVar.ui();
                                                    } finally {
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Throwable unused9) {
                                                    }
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                } catch (Throwable unused10) {
                                                }
                                                return null;
                                            }
                                            randomAccessFile.seek(j2);
                                            randomAccessFile.write(bArr, 0, i);
                                            j2 += i;
                                            i = 0;
                                            eliVar = this;
                                        }
                                    } catch (Throwable unused11) {
                                        inputStream = Os;
                                    }
                                } catch (Throwable unused12) {
                                    inputStream = null;
                                }
                            }
                        }
                    } catch (IOException unused13) {
                        eliVar.ui();
                        return dbA;
                    }
                }
                j = 0;
                if (eli2 <= j) {
                }
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(eliVar.DbA, "rw");
                if (ui) {
                }
            } catch (IOException unused14) {
                dbA = null;
            }
        } catch (IllegalArgumentException unused15) {
            Log.e("DownloadExecutor", "execute: Url is not a valid HTTP or HTTPS URL");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ui(Map<String, String> map) {
        if (TextUtils.equals(map.get(HttpHeaders.ACCEPT_RANGES), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get(HttpHeaders.CONTENT_RANGE);
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long MGA(Map<String, String> map) {
        String str;
        if (map.containsKey("content-length")) {
            str = map.get("content-length");
        } else {
            str = map.containsKey(HttpHeaders.CONTENT_LENGTH) ? map.get(HttpHeaders.CONTENT_LENGTH) : null;
        }
        if (!TextUtils.isEmpty(str) && str != null) {
            try {
                return Long.valueOf(str).longValue();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean kb(Map<String, String> map) {
        return TextUtils.equals(map.get(HttpHeaders.CONTENT_ENCODING), "gzip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui() {
        try {
            this.eli.delete();
        } catch (Throwable unused) {
        }
        try {
            this.DbA.delete();
        } catch (Throwable unused2) {
        }
    }

    @Override // com.bytedance.sdk.component.kb.DbA.Os
    public void DbA() {
        this.aAs = true;
        super.DbA();
    }
}
