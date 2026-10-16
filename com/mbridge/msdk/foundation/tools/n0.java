package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.MBridgeConstans;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SameFileTool.java */
/* loaded from: classes6.dex */
public class n0 extends v {

    /* compiled from: SameFileTool.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.setting.g d = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d == null) {
                    d = com.mbridge.msdk.setting.h.b().a();
                }
                n0.b(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_RES_MANAGER_DIR), d.N());
                n0.a(System.currentTimeMillis() - (d.e() * 1000));
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* compiled from: SameFileTool.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    n0.b(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_VC));
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* compiled from: SameFileTool.java */
    class c implements FileFilter {
        c() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.isHidden() || file.isDirectory();
        }
    }

    /* compiled from: SameFileTool.java */
    class d implements Comparator<File> {
        d() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, int i) {
        try {
            if (d(new File(str)) > i * 1048576) {
                f(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable unused) {
            p0.b("SameFileTool", "clean memory failed");
        }
    }

    public static File[] c(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.listFiles();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(File file) {
        IOException e;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (file == 0) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    file = new StringBuffer();
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            file.append(readLine + "\n");
                        } catch (IOException e2) {
                            e = e2;
                            try {
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                    file = file;
                                }
                                if (file == 0) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                    bufferedReader.close();
                    file = file;
                } catch (IOException e3) {
                    e = e3;
                    file = 0;
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            file = 0;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = bufferedReader2;
            if (bufferedReader != null) {
            }
            throw th;
        }
        if (file == 0) {
            return file.toString();
        }
        return null;
    }

    public static void f(String str) {
        try {
            ArrayList<File> b2 = b(new File(str));
            Collections.sort(b2, new d());
            int size = (b2.size() - 1) / 2;
            for (int i = 0; i < size; i++) {
                File file = b2.get(i);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
            p0.b("SameFileTool", "del memory failed");
        }
    }

    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.mbridge.msdk.setting.g d2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d2 == null) {
                d2 = com.mbridge.msdk.setting.h.b().a();
            }
            long currentTimeMillis = System.currentTimeMillis() - (d2.e() * 1000);
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.lastModified() + currentTimeMillis < currentTimeMillis2) {
                            a(file2);
                            try {
                                File file3 = new File(str + ".zip");
                                if (file3.exists() && file3.isFile()) {
                                    a(file3);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static String d(String str) {
        return !TextUtils.isEmpty(str) ? SameMD5.getMD5(b1.b(str.trim())) : "";
    }

    private static long c(File file) throws Exception {
        FileInputStream fileInputStream;
        long j = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        fileInputStream = new FileInputStream(file);
                        try {
                            j = fileInputStream.available();
                            fileInputStream2 = fileInputStream;
                        } catch (Exception e) {
                            e = e;
                            fileInputStream2 = fileInputStream;
                            e.printStackTrace();
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            return 0L;
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        file.createNewFile();
                        p0.b("获取文件大小", "文件不存在!");
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return j;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private static long d(File file) throws Exception {
        long c2;
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    c2 = d(listFiles[i]);
                } else {
                    c2 = c(listFiles[i]);
                }
                j += c2;
            }
        }
        return j;
    }

    public static void b() {
        new Thread(new b()).start();
    }

    public static void a() {
        a aVar = new a();
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
        } else {
            aVar.run();
        }
    }

    public static void b(String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : c(str)) {
                    if (file2.exists() && file2.isFile()) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean e(String str) {
        if (com.mbridge.msdk.foundation.same.image.e.a(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    private static ArrayList<File> b(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        for (File file2 : file.listFiles(new c())) {
            if (!file2.isDirectory()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(b(file2));
            }
        }
        return arrayList;
    }

    public static void a(long j) {
        try {
            Iterator<File> it = b(new File(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_RES_MANAGER_DIR))).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next.lastModified() < j && next.exists() && next.isFile()) {
                    next.delete();
                }
            }
        } catch (Throwable th) {
            p0.b("SameFileTool", th.getMessage(), th);
        }
    }

    public static String a(File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return "";
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        a(file2);
                    }
                    file.delete();
                    return "";
                }
                file.delete();
            }
            return "";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x00fa, code lost:
    
        if (r12 == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00fc, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0100, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0101, code lost:
    
        com.mbridge.msdk.foundation.tools.p0.b("SameFileTool", "unzip error", r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0126, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0129, code lost:
    
        if (r12 == null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x012b, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x012f, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0130, code lost:
    
        com.mbridge.msdk.foundation.tools.p0.b("SameFileTool", "unzip error", r12);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0156 A[Catch: all -> 0x0172, TryCatch #11 {all -> 0x0172, blocks: (B:59:0x0152, B:61:0x0156, B:62:0x0159), top: B:58:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, String str2) {
        Throwable th;
        InputStream inputStream;
        IOException iOException;
        InputStream inputStream2;
        ?? r8;
        IOException e;
        Throwable th2;
        ?? r6;
        if (str != null && str2 != null) {
            if (!str2.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                str2 = str2 + RemoteSettings.FORWARD_SLASH_STRING;
            }
            File file = new File(str);
            if (!file.exists()) {
                return "unzip file not exists";
            }
            InputStream inputStream3 = null;
            try {
                ZipFile zipFile = new ZipFile(file);
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                r6 = 0;
                while (true) {
                    try {
                        try {
                            String str3 = "";
                            if (!entries.hasMoreElements()) {
                                break;
                            }
                            ZipEntry nextElement = entries.nextElement();
                            if (nextElement == null) {
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (IOException e2) {
                                        p0.b("SameFileTool", "unzip error", e2);
                                    }
                                }
                                if (r6 != 0) {
                                    try {
                                        r6.close();
                                    } catch (IOException e3) {
                                        p0.b("SameFileTool", "unzip error", e3);
                                    }
                                }
                                return "unzip zipEntry is null";
                            }
                            String name = nextElement.getName();
                            if (!TextUtils.isEmpty(name) && !name.startsWith("..") && !name.startsWith("../")) {
                                File file2 = new File(str2 + name);
                                try {
                                    str3 = file2.getCanonicalPath();
                                } catch (IOException unused) {
                                }
                                if (TextUtils.isEmpty(str3) || !str3.startsWith(str2) || str3.startsWith("..") || str3.startsWith("../")) {
                                    break;
                                }
                                if (nextElement.isDirectory()) {
                                    file2.mkdirs();
                                } else {
                                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                                        file2.getParentFile().mkdirs();
                                    }
                                    r8 = new FileOutputStream(file2);
                                    try {
                                        inputStream3 = zipFile.getInputStream(nextElement);
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int read = inputStream3.read(bArr, 0, 1024);
                                            if (read == -1) {
                                                break;
                                            }
                                            r8.write(bArr, 0, read);
                                            r8.flush();
                                        }
                                        r6 = r8;
                                    } catch (IOException e4) {
                                        e = e4;
                                        try {
                                            if (MBridgeConstans.DEBUG) {
                                            }
                                            String message = e.getMessage();
                                            if (inputStream3 != null) {
                                            }
                                            if (r8 != 0) {
                                            }
                                            return message;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            inputStream = inputStream3;
                                            inputStream3 = r8;
                                            r8 = inputStream3;
                                            inputStream3 = inputStream;
                                            th2 = th;
                                            if (inputStream3 != null) {
                                                try {
                                                    inputStream3.close();
                                                } catch (IOException e5) {
                                                    p0.b("SameFileTool", "unzip error", e5);
                                                }
                                            }
                                            if (r8 != 0) {
                                                try {
                                                    r8.close();
                                                    throw th2;
                                                } catch (IOException e6) {
                                                    p0.b("SameFileTool", "unzip error", e6);
                                                    throw th2;
                                                }
                                            }
                                            throw th2;
                                        }
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        if (inputStream3 != null) {
                                        }
                                        if (r8 != 0) {
                                        }
                                    }
                                }
                            } else {
                                break;
                            }
                        } catch (IOException e7) {
                            iOException = e7;
                            inputStream2 = inputStream3;
                            inputStream3 = r6;
                            r8 = inputStream3;
                            inputStream3 = inputStream2;
                            e = iOException;
                            if (MBridgeConstans.DEBUG) {
                                p0.b("SameFileTool", "unzip error", e);
                            }
                            String message2 = e.getMessage();
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e8) {
                                    p0.b("SameFileTool", "unzip error", e8);
                                }
                            }
                            if (r8 != 0) {
                                try {
                                    r8.close();
                                } catch (IOException e9) {
                                    p0.b("SameFileTool", "unzip error", e9);
                                }
                            }
                            return message2;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = inputStream3;
                        inputStream3 = r6;
                        r8 = inputStream3;
                        inputStream3 = inputStream;
                        th2 = th;
                        if (inputStream3 != null) {
                        }
                        if (r8 != 0) {
                        }
                    }
                }
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e10) {
                        p0.b("SameFileTool", "unzip error", e10);
                    }
                }
                if (r6 != 0) {
                    try {
                        r6.close();
                    } catch (IOException e11) {
                        p0.b("SameFileTool", "unzip error", e11);
                    }
                }
                return "unzip zipEntry name is not available";
            } catch (IOException e12) {
                iOException = e12;
                inputStream2 = null;
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
            }
        } else {
            return "unzip srcFile or destDir is null ";
        }
        if (r6 != 0) {
            try {
                r6.close();
            } catch (IOException e13) {
                p0.b("SameFileTool", "unzip error", e13);
            }
        }
        return "unzip zipEntry canonicalPath is not available";
        return "unzip zipEntry canonicalPath is not available";
        if (r6 != 0) {
            try {
                r6.close();
            } catch (IOException e14) {
                p0.b("SameFileTool", "unzip error", e14);
            }
        }
        return "";
        return "";
    }

    public static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str + File.separator + "template_config.json");
                if (file.isFile() && file.exists()) {
                    String e = e(file);
                    if (!TextUtils.isEmpty(e)) {
                        try {
                            JSONArray jSONArray = new JSONArray(e);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                if (jSONObject != null && str2.equals(jSONObject.optString("xml_type"))) {
                                    arrayList.add(str + File.separator + jSONObject.optString("name"));
                                    if (jSONObject.has("ext_template")) {
                                        jSONObject.put("folder_dir", str);
                                        arrayList.add(jSONObject.toString());
                                    }
                                }
                            }
                        } catch (JSONException e2) {
                            p0.b("SameFileTool", e2.getMessage());
                        }
                    }
                }
                arrayList.add(str);
                return arrayList;
            }
        } catch (Exception e3) {
            p0.b("SameFileTool", e3.getMessage());
        }
        return arrayList;
    }

    public static boolean a(byte[] bArr, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file.getParentFile() != null && !file.exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
            fileOutputStream = fileOutputStream2;
        }
        try {
            fileOutputStream.write(bArr);
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 == null) {
                return false;
            }
            try {
                fileOutputStream2.close();
                return false;
            } catch (IOException e4) {
                e4.printStackTrace();
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }
}
