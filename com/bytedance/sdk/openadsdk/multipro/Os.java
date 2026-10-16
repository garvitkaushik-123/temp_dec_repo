package com.bytedance.sdk.openadsdk.multipro;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.bf;
import com.ironsource.C3040d4;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class Os {
    private static final AtomicBoolean DbA = new AtomicBoolean(false);
    private static boolean eli = true;

    public static void eli(Context context) {
        if (context != null && eli && DbA.compareAndSet(false, true)) {
            try {
                if (bf.eli(context)) {
                    DbA(context);
                    return;
                }
                String DbA2 = bf.DbA(context);
                try {
                    if (TextUtils.isEmpty(DbA2)) {
                        DbA2 = context.getPackageName() + Process.myPid();
                    }
                    WebView.setDataDirectorySuffix(DbA2);
                } catch (IllegalStateException unused) {
                    eli(DbA2);
                } catch (Exception unused2) {
                }
            } catch (Throwable th) {
                Xb.Os(th.getMessage(), new Object[0]);
            }
        }
    }

    public static void eli() {
        eli = false;
    }

    private static void eli(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void DbA(Context context) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel;
        Throwable th;
        RandomAccessFile randomAccessFile2;
        String DbA2 = DbA();
        ?? r1 = "webview_data.lock";
        File file = new File(context.getDir(TextUtils.isEmpty(DbA2) ? C3040d4.h.K : "webview_".concat(String.valueOf(DbA2)), 0).getPath(), "webview_data.lock");
        file.getAbsolutePath();
        if (file.exists()) {
            ?? th2 = 0;
            th2 = 0;
            r3 = null;
            FileChannel fileChannel2 = null;
            try {
                try {
                    r1 = new RandomAccessFile(file, "rw");
                    try {
                        fileChannel = r1.getChannel();
                        if (fileChannel != null) {
                            try {
                                th2 = fileChannel.tryLock();
                            } catch (Exception unused) {
                                fileChannel2 = fileChannel;
                                eli(file);
                                th2 = fileChannel2;
                                if (fileChannel2 != null) {
                                    try {
                                        fileChannel2.close();
                                        th2 = fileChannel2;
                                    } catch (Throwable th3) {
                                        th3.getMessage();
                                        th2 = th3;
                                    }
                                }
                                if (r1 != 0) {
                                    try {
                                        r1.close();
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        th2.getMessage();
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                randomAccessFile2 = r1;
                                if (fileChannel != null) {
                                }
                                if (randomAccessFile2 != null) {
                                }
                            }
                        }
                        if (th2 != 0) {
                            th2.close();
                        } else {
                            eli(file);
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (Throwable th6) {
                                th2 = th6;
                                th2.getMessage();
                            }
                        }
                        try {
                            r1.close();
                        } catch (Throwable th7) {
                            th7.getMessage();
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th8) {
                    th = th8;
                    fileChannel = th2;
                    randomAccessFile = r1;
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (Throwable th9) {
                            th9.getMessage();
                        }
                    }
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                            throw th;
                        } catch (Throwable th10) {
                            th10.getMessage();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                r1 = 0;
            } catch (Throwable th11) {
                th = th11;
                randomAccessFile = null;
                fileChannel = null;
                th = th;
                randomAccessFile2 = randomAccessFile;
                if (fileChannel != null) {
                }
                if (randomAccessFile2 != null) {
                }
            }
        }
    }

    private static void eli(File file) {
        eli(file, file.exists() ? file.delete() : false);
    }

    private static void eli(File file, boolean z) {
        if (!z || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            Xb.Os("TTAD.TTMultiInitHelper", e.getMessage());
        }
    }

    private static String DbA() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}
