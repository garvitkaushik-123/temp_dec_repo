package com.ironsource.sdk.utils;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.nearby.messages.Message;
import com.ironsource.C3040d4;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.C3382x8;
import com.ironsource.InterfaceC3381x7;
import com.ironsource.Ze;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class IronSourceStorageUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3827a = "supersonicads";
    private static Ze b = null;
    private static boolean c = false;

    private static void a(Context context) {
        Ze ze = b;
        if (ze != null && ze.b()) {
            deleteCacheDirectories(context);
        }
        Ze ze2 = b;
        if (ze2 == null || !ze2.c()) {
            return;
        }
        deleteFilesDirectories(context);
    }

    private static File b(Context context) {
        InterfaceC3381x7 i = C3334ub.U().i();
        Ze ze = b;
        return (ze == null || !ze.d()) ? i.f(context) : i.l(context);
    }

    public static String buildAbsolutePathToDirInCache(String str, String str2) {
        return str2 == null ? str : str + File.separator + str2;
    }

    public static JSONObject buildFilesMap(String str, String str2) {
        File file = new File(str, str2);
        JSONObject jSONObject = new JSONObject();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                try {
                    Object c2 = c(file2);
                    if (c2 instanceof JSONArray) {
                        jSONObject.put("files", c(file2));
                    } else if (c2 instanceof JSONObject) {
                        jSONObject.put(file2.getName(), c(file2));
                    }
                } catch (JSONException e) {
                    C3260q4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject buildFilesMapOfDirectory(C3382x8 c3382x8, JSONObject jSONObject) throws Exception {
        if (c3382x8 == null || !c3382x8.isDirectory()) {
            return new JSONObject();
        }
        File[] listFiles = c3382x8.listFiles();
        if (listFiles == null) {
            return new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject();
        for (File file : listFiles) {
            C3382x8 c3382x82 = new C3382x8(file.getPath());
            if (c3382x82.isFile()) {
                String name = c3382x82.getName();
                JSONObject a2 = c3382x82.a();
                if (jSONObject.has(name)) {
                    jSONObject2.put(name, SDKUtils.mergeJSONObjects(a2, jSONObject.getJSONObject(name)));
                } else {
                    jSONObject2.put(name, a2);
                }
            } else if (c3382x82.isDirectory()) {
                jSONObject2.put(c3382x82.getName(), buildFilesMapOfDirectory(c3382x82, jSONObject));
            }
        }
        return jSONObject2;
    }

    private static File c(Context context) {
        InterfaceC3381x7 i = C3334ub.U().i();
        Ze ze = b;
        return (ze == null || !ze.d()) ? i.j(context) : i.B(context);
    }

    public static void deleteCacheDirectories(Context context) {
        InterfaceC3381x7 i = C3334ub.U().i();
        a(i.l(context));
        a(i.B(context));
    }

    public static synchronized boolean deleteFile(C3382x8 c3382x8) {
        synchronized (IronSourceStorageUtils.class) {
            if (!c3382x8.exists()) {
                return false;
            }
            return c3382x8.delete();
        }
    }

    public static void deleteFilesDirectories(Context context) {
        InterfaceC3381x7 i = C3334ub.U().i();
        a(i.f(context));
        a(i.j(context));
    }

    public static synchronized boolean deleteFolder(String str) {
        boolean z;
        synchronized (IronSourceStorageUtils.class) {
            File file = new File(str);
            if (deleteFolderContentRecursive(file)) {
                z = file.delete();
            }
        }
        return z;
    }

    public static boolean deleteFolderContentRecursive(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= deleteFolderContentRecursive(file2);
                }
                if (!file2.delete()) {
                    z = false;
                }
            }
        }
        return z;
    }

    public static void ensurePathSafety(File file, String str) throws Exception {
        Ze ze = b;
        if (ze == null || !ze.e()) {
            String canonicalPath = new File(str).getCanonicalPath();
            String canonicalPath2 = file.getCanonicalPath();
            if (!canonicalPath2.startsWith(canonicalPath)) {
                throw new Exception(C3040d4.c.u + canonicalPath2);
            }
        }
    }

    public static String getCachedFilesMap(String str, String str2) {
        JSONObject buildFilesMap = buildFilesMap(str, str2);
        try {
            buildFilesMap.put("path", str2);
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return buildFilesMap.toString();
    }

    public static String getDiskCacheDirPath(Context context) {
        File b2;
        if (!a() || !SDKUtils.isExternalStorageAvailable() || (b2 = b(context)) == null || !b2.canWrite()) {
            return c(context).getPath();
        }
        c = true;
        return b2.getPath();
    }

    public static ArrayList<C3382x8> getFilesInFolderRecursive(C3382x8 c3382x8) {
        if (c3382x8 == null || !c3382x8.isDirectory()) {
            return new ArrayList<>();
        }
        ArrayList<C3382x8> arrayList = new ArrayList<>();
        File[] listFiles = c3382x8.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                C3382x8 c3382x82 = new C3382x8(file.getPath());
                if (c3382x82.isDirectory()) {
                    arrayList.addAll(getFilesInFolderRecursive(c3382x82));
                }
                if (c3382x82.isFile()) {
                    arrayList.add(c3382x82);
                }
            }
        }
        return arrayList;
    }

    public static String getNetworkStorageDir(Context context) {
        File b2 = b(new File(getDiskCacheDirPath(context)));
        if (!b2.exists()) {
            b2.mkdir();
        }
        return b2.getPath();
    }

    public static long getTotalSizeOfDir(C3382x8 c3382x8) {
        long totalSizeOfDir;
        long j = 0;
        if (c3382x8 != null && c3382x8.isDirectory()) {
            File[] listFiles = c3382x8.listFiles();
            if (listFiles == null) {
                return 0L;
            }
            for (File file : listFiles) {
                C3382x8 c3382x82 = new C3382x8(file.getPath());
                if (c3382x82.isFile()) {
                    totalSizeOfDir = c3382x82.length();
                } else if (c3382x82.isDirectory()) {
                    totalSizeOfDir = getTotalSizeOfDir(c3382x82);
                }
                j += totalSizeOfDir;
            }
        }
        return j;
    }

    public static void initializeCacheDirectory(Context context, Ze ze) {
        b = ze;
        a(context);
    }

    public static boolean isPathExist(String str, String str2) {
        return new File(str, str2).exists();
    }

    public static boolean isUxt() {
        return c;
    }

    public static String makeDir(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return file.getPath();
        }
        return null;
    }

    public static String readFile(C3382x8 c3382x8) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(c3382x8));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    public static boolean renameFile(String str, String str2) throws Exception {
        return new File(str).renameTo(new File(str2));
    }

    public static int saveFile(byte[] bArr, String str) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            byte[] bArr2 = new byte[Message.MAX_CONTENT_SIZE_BYTES];
            int i = 0;
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read == -1) {
                    return i;
                }
                fileOutputStream.write(bArr2, 0, read);
                i += read;
            }
        } finally {
            fileOutputStream.close();
            byteArrayInputStream.close();
        }
    }

    private static void a(File file) {
        if (file != null) {
            deleteFolder(b(file).getPath());
        }
    }

    private static File b(File file) {
        StringBuilder append = new StringBuilder().append(file.getAbsolutePath());
        String str = File.separator;
        return new File(append.append(str).append(f3827a).append(str).toString());
    }

    private static Object c(File file) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        if (file.isFile()) {
            jSONArray.put(file.getName());
            return jSONArray;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                jSONObject.put(file2.getName(), c(file2));
            } else {
                jSONArray.put(file2.getName());
                jSONObject.put("files", jSONArray);
            }
        }
        return jSONObject;
    }

    private static boolean a() {
        Ze ze;
        return Build.VERSION.SDK_INT > 29 && (ze = b) != null && ze.a();
    }
}
