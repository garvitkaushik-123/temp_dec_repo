package com.pgl.ssdk;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

/* loaded from: classes6.dex */
public class f0 {
    private static void a(byte[] bArr, int i, byte[] bArr2) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2 % bArr2.length]);
        }
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                }
            } catch (Exception unused) {
            }
        } while (read >= 4096);
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r1 == null) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(String str) {
        Process process;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        r0 = null;
        String str2 = null;
        try {
            process = Runtime.getRuntime().exec(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SH);
            try {
                bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
                try {
                    bufferedInputStream = new BufferedInputStream(process.getInputStream());
                } catch (Exception unused) {
                    bufferedInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = null;
                }
            } catch (Exception unused2) {
                bufferedOutputStream = null;
                bufferedInputStream = null;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                if (process != null) {
                    throw th;
                }
                process.destroy();
                throw th;
            }
        } catch (Exception unused7) {
            process = null;
        } catch (Throwable th3) {
            th = th3;
            process = null;
        }
        try {
            bufferedOutputStream.write(str.getBytes());
            bufferedOutputStream.write(10);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            process.waitFor();
            String a2 = a(bufferedInputStream);
            try {
                bufferedOutputStream.close();
            } catch (IOException unused8) {
            }
            try {
                bufferedInputStream.close();
            } catch (IOException unused9) {
            }
            str2 = a2;
        } catch (Exception unused10) {
            if (bufferedOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (process != null) {
            }
        }
        process.destroy();
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00dd, code lost:
    
        if (r9.length() == 0) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a(Context context) {
        String str;
        synchronized (f0.class) {
            try {
                String str2 = context.getFilesDir().getAbsolutePath() + "/dic";
                if (new File(str2).exists()) {
                    a("chmod 777 ".concat(String.valueOf(str2)));
                    String a2 = a(str2);
                    a("chmod 600 ".concat(String.valueOf(str2)));
                    if (a2 != null && a2.length() > 0) {
                        return a2;
                    }
                }
                InputStream open = context.getResources().getAssets().open("dic");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = open.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    a(bArr, read, "dic".getBytes(Charset.forName("UTF-8")));
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.close();
                a("chmod 777 ".concat(String.valueOf(str2)));
                str = a(str2);
                if (str == null || str.length() == 0) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(str2, "rw");
                    randomAccessFile.seek(16L);
                    randomAccessFile.write(new byte[]{2});
                    randomAccessFile.close();
                    str = a(str2);
                }
                a("chmod 600 ".concat(String.valueOf(str2)));
            } catch (Throwable unused) {
                str = "0[<!>]EXCEPTION[<!>]";
            }
            if (str != null) {
            }
            str = "0[<!>]ERROR[<!>]";
            return str;
        }
    }
}
