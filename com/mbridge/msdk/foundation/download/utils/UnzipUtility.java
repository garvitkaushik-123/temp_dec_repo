package com.mbridge.msdk.foundation.download.utils;

import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.tools.p0;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* loaded from: classes6.dex */
public class UnzipUtility {
    private static final int BUFFER_SIZE = 4096;
    private static final String TAG = "UnzipUtility";

    private void extractFile(ZipInputStream zipInputStream, String str) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = zipInputStream.read(bArr);
                if (read == -1) {
                    bufferedOutputStream.close();
                    return;
                }
                bufferedOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e2) {
            e = e2;
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x00fa, code lost:
    
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00fe, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00ff, code lost:
    
        com.mbridge.msdk.foundation.tools.p0.b(com.mbridge.msdk.foundation.download.utils.UnzipUtility.TAG, r14.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0117, code lost:
    
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x011b, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x011c, code lost:
    
        com.mbridge.msdk.foundation.tools.p0.b(com.mbridge.msdk.foundation.download.utils.UnzipUtility.TAG, r14.getMessage());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0194 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int unzip(String str, String str2) throws IOException {
        Throwable th;
        InputStream inputStream;
        IOException iOException;
        InputStream inputStream2;
        ?? r9;
        IOException e;
        Throwable th2;
        String str3;
        if (str == null || str2 == null) {
            return -1;
        }
        if (!str2.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str2 = str2 + RemoteSettings.FORWARD_SLASH_STRING;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 1;
        }
        InputStream inputStream3 = null;
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            ?? r6 = 0;
            while (entries.hasMoreElements()) {
                try {
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        if (nextElement == null) {
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e2) {
                                    p0.b(TAG, e2.getMessage());
                                }
                            }
                            if (r6 != 0) {
                                try {
                                    r6.close();
                                } catch (IOException e3) {
                                    p0.b(TAG, e3.getMessage());
                                }
                            }
                            return 2;
                        }
                        String name = nextElement.getName();
                        if (!TextUtils.isEmpty(name) && !name.startsWith("..") && !name.startsWith("../")) {
                            File file2 = new File(str2 + name);
                            try {
                                str3 = file2.getCanonicalPath();
                            } catch (IOException unused) {
                                str3 = "";
                            }
                            if (!TextUtils.isEmpty(str3) && str3.startsWith(str2) && !str3.startsWith("..") && !str3.startsWith("../")) {
                                if (nextElement.isDirectory()) {
                                    file2.mkdirs();
                                } else {
                                    if (!file2.getParentFile().exists()) {
                                        file2.getParentFile().mkdirs();
                                    }
                                    r9 = new FileOutputStream(file2);
                                    try {
                                        inputStream3 = zipFile.getInputStream(nextElement);
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int read = inputStream3.read(bArr, 0, 1024);
                                            if (read == -1) {
                                                break;
                                            }
                                            r9.write(bArr, 0, read);
                                            r9.flush();
                                        }
                                        r6 = r9;
                                    } catch (IOException e4) {
                                        e = e4;
                                        try {
                                            p0.b(TAG, e.getMessage());
                                            if (inputStream3 != null) {
                                            }
                                            if (r9 != 0) {
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            inputStream = inputStream3;
                                            inputStream3 = r9;
                                            r9 = inputStream3;
                                            inputStream3 = inputStream;
                                            th2 = th;
                                            if (inputStream3 != null) {
                                                try {
                                                    inputStream3.close();
                                                } catch (IOException e5) {
                                                    p0.b(TAG, e5.getMessage());
                                                }
                                            }
                                            if (r9 == 0) {
                                                throw th2;
                                            }
                                            try {
                                                r9.close();
                                                throw th2;
                                            } catch (IOException e6) {
                                                p0.b(TAG, e6.getMessage());
                                                throw th2;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        if (inputStream3 != null) {
                                        }
                                        if (r9 == 0) {
                                        }
                                    }
                                }
                            }
                            if (r6 != 0) {
                                try {
                                    r6.close();
                                } catch (IOException e7) {
                                    p0.b(TAG, e7.getMessage());
                                }
                            }
                            return 2;
                        }
                        if (r6 != 0) {
                            try {
                                r6.close();
                            } catch (IOException e8) {
                                p0.b(TAG, e8.getMessage());
                            }
                        }
                        return 2;
                    } catch (IOException e9) {
                        iOException = e9;
                        inputStream2 = inputStream3;
                        inputStream3 = r6;
                        r9 = inputStream3;
                        inputStream3 = inputStream2;
                        e = iOException;
                        p0.b(TAG, e.getMessage());
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (IOException e10) {
                                p0.b(TAG, e10.getMessage());
                            }
                        }
                        if (r9 != 0) {
                            return 3;
                        }
                        try {
                            r9.close();
                            return 3;
                        } catch (IOException e11) {
                            p0.b(TAG, e11.getMessage());
                            return 3;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = inputStream3;
                    inputStream3 = r6;
                    r9 = inputStream3;
                    inputStream3 = inputStream;
                    th2 = th;
                    if (inputStream3 != null) {
                    }
                    if (r9 == 0) {
                    }
                }
            }
            zipFile.close();
            if (inputStream3 != null) {
                try {
                    inputStream3.close();
                } catch (IOException e12) {
                    p0.b(TAG, e12.getMessage());
                }
            }
            if (r6 != 0) {
                try {
                    r6.close();
                } catch (IOException e13) {
                    p0.b(TAG, e13.getMessage());
                }
            }
            return 0;
        } catch (IOException e14) {
            iOException = e14;
            inputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
        }
    }
}
