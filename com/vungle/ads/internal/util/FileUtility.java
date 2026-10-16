package com.vungle.ads.internal.util;

import android.webkit.URLUtil;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.C3040d4;
import com.vungle.ads.AssetFailedToDeleteError;
import com.vungle.ads.internal.util.Logger;
import io.ktor.http.ContentDisposition;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.HttpUrl;

/* compiled from: FileUtility.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u00017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0019H\u0007J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0019H\u0007J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004J\u0010\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u0012\u0010'\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0007J&\u0010'\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001f\u001a\u00020 2\n\u0010(\u001a\u00060)j\u0002`*H\u0002J$\u0010+\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\n\u0010(\u001a\u00060)j\u0002`*H\u0002J\u001d\u0010,\u001a\u0004\u0018\u0001H-\"\u0004\b\u0000\u0010-2\u0006\u0010\u001b\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u0019J\u0010\u00100\u001a\u0002012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019J\u001a\u00102\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00192\b\u00103\u001a\u0004\u0018\u000104H\u0007J\u0018\u00105\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00192\b\u00106\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR&\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u00068"}, d2 = {"Lcom/vungle/ads/internal/util/FileUtility;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "allowedClasses", "", "Ljava/lang/Class;", "getAllowedClasses$vungle_ads_release$annotations", "getAllowedClasses$vungle_ads_release", "()Ljava/util/List;", "<set-?>", "Lcom/vungle/ads/internal/util/FileUtility$ObjectInputStreamProvider;", "objectInputStreamProvider", "getObjectInputStreamProvider", "()Lcom/vungle/ads/internal/util/FileUtility$ObjectInputStreamProvider;", "setObjectInputStreamProvider", "(Lcom/vungle/ads/internal/util/FileUtility$ObjectInputStreamProvider;)V", "closeQuietly", "", "closeable", "Ljava/io/Closeable;", "delete", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/io/File;", "deleteAndLogIfFailed", C3040d4.h.b, "deleteContents", "folder", "getIndentString", "indent", "", "guessFileName", "url", "ext", "isValidUrl", "", "httpUrl", "printDirectoryTree", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "printFile", "readSerializable", "T", "(Ljava/io/File;)Ljava/lang/Object;", "readString", ContentDisposition.Parameters.Size, "", "writeSerializable", "serializable", "Ljava/io/Serializable;", "writeString", "content", "ObjectInputStreamProvider", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class FileUtility {
    public static final FileUtility INSTANCE = new FileUtility();
    private static ObjectInputStreamProvider objectInputStreamProvider = new ObjectInputStreamProvider() { // from class: com.vungle.ads.internal.util.FileUtility$$ExternalSyntheticLambda0
        @Override // com.vungle.ads.internal.util.FileUtility.ObjectInputStreamProvider
        public final ObjectInputStream provideObjectInputStream(InputStream inputStream) {
            ObjectInputStream m9404objectInputStreamProvider$lambda0;
            m9404objectInputStreamProvider$lambda0 = FileUtility.m9404objectInputStreamProvider$lambda0(inputStream);
            return m9404objectInputStreamProvider$lambda0;
        }
    };
    private static final String TAG = "FileUtility";
    private static final List<Class<?>> allowedClasses = CollectionsKt.listOf((Object[]) new Class[]{LinkedHashSet.class, HashSet.class, HashMap.class, ArrayList.class, File.class});

    /* compiled from: FileUtility.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/util/FileUtility$ObjectInputStreamProvider;", "", "provideObjectInputStream", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface ObjectInputStreamProvider {
        ObjectInputStream provideObjectInputStream(InputStream inputStream) throws IOException, ClassNotFoundException;
    }

    public static /* synthetic */ void getAllowedClasses$vungle_ads_release$annotations() {
    }

    @JvmStatic
    public static final void printDirectoryTree(File folder) {
    }

    private FileUtility() {
    }

    public final ObjectInputStreamProvider getObjectInputStreamProvider() {
        return objectInputStreamProvider;
    }

    public final void setObjectInputStreamProvider(ObjectInputStreamProvider objectInputStreamProvider2) {
        Intrinsics.checkNotNullParameter(objectInputStreamProvider2, "<set-?>");
        objectInputStreamProvider = objectInputStreamProvider2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: objectInputStreamProvider$lambda-0, reason: not valid java name */
    public static final ObjectInputStream m9404objectInputStreamProvider$lambda0(InputStream inputStream) {
        return new SafeObjectInputStream(inputStream, allowedClasses);
    }

    public final List<Class<?>> getAllowedClasses$vungle_ads_release() {
        return allowedClasses;
    }

    private final void printDirectoryTree(File folder, int indent, StringBuilder sb) {
        if (folder == null) {
            return;
        }
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("folder is not a Directory".toString());
        }
        sb.append(getIndentString(indent)).append("+--").append(folder.getName()).append("/\n");
        File[] listFiles = folder.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.isDirectory()) {
                printDirectoryTree(file, indent + 1, sb);
            } else {
                Intrinsics.checkNotNullExpressionValue(file, "file");
                printFile(file, indent + 1, sb);
            }
        }
    }

    private final void printFile(File file, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent)).append("+--").append(file.getName()).append('\n');
    }

    private final String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("|  ");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    @JvmStatic
    public static final void delete(File f) {
        if (f != null) {
            try {
                if (f.exists()) {
                    if (f.isDirectory()) {
                        deleteContents(f);
                    }
                    if (f.delete()) {
                        return;
                    }
                    Logger.Companion companion = Logger.INSTANCE;
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    companion.d(TAG2, "Failed to delete file: " + f);
                }
            } catch (Exception e) {
                Logger.Companion companion2 = Logger.INSTANCE;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                companion2.e(TAG3, "Failed to delete file: " + e.getLocalizedMessage());
            }
        }
    }

    @JvmStatic
    public static final void deleteContents(File folder) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        File[] listFiles = folder.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            delete(file);
        }
    }

    @JvmStatic
    public static final void deleteAndLogIfFailed(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            Files.delete(file.toPath());
        } catch (Exception e) {
            new AssetFailedToDeleteError("Failed to delete " + file.getName() + " with error :" + e.getMessage()).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    public final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.ObjectOutputStream] */
    @JvmStatic
    public static final void writeSerializable(File file, Serializable serializable) {
        FileOutputStream fileOutputStream;
        ?? r4;
        Intrinsics.checkNotNullParameter(file, "file");
        if (file.exists()) {
            deleteAndLogIfFailed(file);
        }
        if (serializable == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                r4 = new ObjectOutputStream(fileOutputStream);
                try {
                    r4.writeObject(serializable);
                    r4.reset();
                    FileUtility fileUtility = INSTANCE;
                    fileUtility.closeQuietly((Closeable) r4);
                    fileUtility.closeQuietly(fileOutputStream);
                } catch (IOException e) {
                    e = e;
                    fileOutputStream2 = fileOutputStream;
                    r4 = r4;
                    try {
                        Logger.Companion companion = Logger.INSTANCE;
                        String TAG2 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        companion.e(TAG2, String.valueOf(e.getMessage()));
                        FileUtility fileUtility2 = INSTANCE;
                        fileUtility2.closeQuietly((Closeable) r4);
                        fileUtility2.closeQuietly(fileOutputStream2);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        fileOutputStream2 = r4;
                        FileUtility fileUtility3 = INSTANCE;
                        fileUtility3.closeQuietly(fileOutputStream2);
                        fileUtility3.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = r4;
                    FileUtility fileUtility32 = INSTANCE;
                    fileUtility32.closeQuietly(fileOutputStream2);
                    fileUtility32.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                r4 = 0;
            } catch (Throwable th3) {
                th = th3;
                FileUtility fileUtility322 = INSTANCE;
                fileUtility322.closeQuietly(fileOutputStream2);
                fileUtility322.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            r4 = 0;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public final void writeString(File file, String content) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (content == null) {
            return;
        }
        try {
            FilesKt.writeText(file, content, Charsets.UTF_8);
        } catch (IOException e) {
            Logger.Companion companion = Logger.INSTANCE;
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            companion.e(TAG2, String.valueOf(e.getMessage()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00b7: MOVE (r5 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:47:0x00b7 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @JvmStatic
    public static final <T> T readSerializable(File file) {
        Closeable closeable;
        ObjectInputStream objectInputStream;
        Closeable closeable2;
        Intrinsics.checkNotNullParameter(file, "file");
        ?? exists = file.exists();
        Closeable closeable3 = null;
        try {
            if (exists == 0) {
                return null;
            }
            try {
                exists = new FileInputStream(file);
            } catch (IOException e) {
                e = e;
                exists = 0;
                objectInputStream = null;
            } catch (ClassNotFoundException e2) {
                e = e2;
                exists = 0;
                objectInputStream = null;
            } catch (Exception e3) {
                e = e3;
                exists = 0;
                objectInputStream = null;
            } catch (Throwable th) {
                th = th;
                exists = 0;
            }
            try {
                FileUtility fileUtility = INSTANCE;
                objectInputStream = objectInputStreamProvider.provideObjectInputStream((InputStream) exists);
                try {
                    T t = (T) objectInputStream.readObject();
                    fileUtility.closeQuietly(objectInputStream);
                    fileUtility.closeQuietly((Closeable) exists);
                    return t;
                } catch (IOException e4) {
                    e = e4;
                    Logger.Companion companion = Logger.INSTANCE;
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    companion.e(TAG2, "IOException: " + e.getMessage());
                    closeable2 = exists;
                    FileUtility fileUtility2 = INSTANCE;
                    fileUtility2.closeQuietly(objectInputStream);
                    fileUtility2.closeQuietly(closeable2);
                    try {
                        delete(file);
                    } catch (IOException unused) {
                    }
                    return null;
                } catch (ClassNotFoundException e5) {
                    e = e5;
                    Logger.Companion companion2 = Logger.INSTANCE;
                    String TAG3 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    companion2.e(TAG3, "ClassNotFoundException: " + e.getMessage());
                    closeable2 = exists;
                    FileUtility fileUtility22 = INSTANCE;
                    fileUtility22.closeQuietly(objectInputStream);
                    fileUtility22.closeQuietly(closeable2);
                    delete(file);
                    return null;
                } catch (Exception e6) {
                    e = e6;
                    Logger.Companion companion3 = Logger.INSTANCE;
                    String TAG4 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                    companion3.e(TAG4, "cannot read serializable " + e.getMessage());
                    closeable2 = exists;
                    FileUtility fileUtility222 = INSTANCE;
                    fileUtility222.closeQuietly(objectInputStream);
                    fileUtility222.closeQuietly(closeable2);
                    delete(file);
                    return null;
                }
            } catch (IOException e7) {
                e = e7;
                objectInputStream = null;
            } catch (ClassNotFoundException e8) {
                e = e8;
                objectInputStream = null;
            } catch (Exception e9) {
                e = e9;
                objectInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                FileUtility fileUtility3 = INSTANCE;
                fileUtility3.closeQuietly(closeable3);
                fileUtility3.closeQuietly((Closeable) exists);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable3 = closeable;
        }
    }

    public final String readString(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!file.exists()) {
            return null;
        }
        try {
            return FilesKt.readText$default(file, null, 1, null);
        } catch (IOException e) {
            Logger.Companion companion = Logger.INSTANCE;
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            companion.e(TAG2, "IOException: " + e.getMessage());
            return null;
        } catch (Exception e2) {
            Logger.Companion companion2 = Logger.INSTANCE;
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            companion2.e(TAG3, "cannot read string " + e2.getMessage());
            return null;
        }
    }

    public final boolean isValidUrl(String httpUrl) {
        String str = httpUrl;
        return (str == null || str.length() == 0 || HttpUrl.INSTANCE.parse(httpUrl) == null) ? false : true;
    }

    public final long size(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0L;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                if (!(listFiles.length == 0)) {
                    for (File file2 : listFiles) {
                        j += size(file2);
                    }
                }
            }
            return j;
        }
        return file.length();
    }

    public static /* synthetic */ String guessFileName$default(FileUtility fileUtility, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return fileUtility.guessFileName(str, str2);
    }

    public final String guessFileName(String url, String ext) {
        Intrinsics.checkNotNullParameter(url, "url");
        String guessFileName = URLUtil.guessFileName(url, null, ext);
        Intrinsics.checkNotNullExpressionValue(guessFileName, "guessFileName(url, null, ext)");
        return guessFileName;
    }
}
