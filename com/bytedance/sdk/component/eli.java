package com.bytedance.sdk.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class eli {
    private static boolean DbA = false;
    private static ArrayMap<File, eli> NU;
    protected static InterfaceC0144eli eli;
    private static ArrayMap<String, File> nlS;
    private long FC;
    private volatile boolean MGA;
    private final Object Os;
    private final File aAs;
    private final Object aGH;
    private final File du;
    private int kb;
    private Properties ui;
    private long wC;

    /* renamed from: com.bytedance.sdk.component.eli$eli, reason: collision with other inner class name */
    public interface InterfaceC0144eli {
        ExecutorService getExecutorService();

        HandlerThread getSafeHandlerThread(String str, int i);
    }

    static /* synthetic */ int FC(eli eliVar) {
        int i = eliVar.kb;
        eliVar.kb = i - 1;
        return i;
    }

    static /* synthetic */ long MGA(eli eliVar) {
        long j = eliVar.wC;
        eliVar.wC = 1 + j;
        return j;
    }

    static /* synthetic */ int ui(eli eliVar) {
        int i = eliVar.kb;
        eliVar.kb = i + 1;
        return i;
    }

    public static void eli(InterfaceC0144eli interfaceC0144eli) {
        eli = interfaceC0144eli;
    }

    public static eli eli(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_prop";
        }
        synchronized (eli.class) {
            if (nlS == null) {
                nlS = new ArrayMap<>();
            }
            File file = nlS.get(str);
            if (file == null) {
                file = new File(context.getFilesDir(), str);
                nlS.put(str, file);
            }
            if (NU == null) {
                NU = new ArrayMap<>();
            }
            eli eliVar = NU.get(file);
            if (eliVar != null) {
                return eliVar;
            }
            eli eliVar2 = new eli(file);
            NU.put(file, eliVar2);
            return eliVar2;
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.sdk.component.eli$1] */
    private eli(File file) {
        Object obj = new Object();
        this.Os = obj;
        this.aGH = new Object();
        this.ui = new Properties();
        this.MGA = false;
        this.kb = 0;
        this.aAs = file;
        this.du = eli(file);
        synchronized (obj) {
            this.MGA = false;
        }
        InterfaceC0144eli interfaceC0144eli = eli;
        if (interfaceC0144eli == null || interfaceC0144eli.getExecutorService() == null) {
            new Thread("TTPropHelper") { // from class: com.bytedance.sdk.component.eli.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    eli.this.eli();
                }
            }.start();
        } else {
            eli.getExecutorService().execute(new Runnable() { // from class: com.bytedance.sdk.component.eli.2
                @Override // java.lang.Runnable
                public void run() {
                    eli.this.eli();
                }
            });
        }
    }

    static File eli(File file) {
        return new File(file.getPath() + ".bak");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00b3 -> B:32:0x00bc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli() {
        FileInputStream fileInputStream;
        Throwable th;
        synchronized (this.Os) {
            if (this.MGA) {
                if (DbA) {
                    Log.d("TTPropHelper", "reload: already loaded, ignore");
                }
                return;
            }
            if (this.du.exists()) {
                this.aAs.delete();
                this.du.renameTo(this.aAs);
            }
            if (DbA) {
                Log.d("TTPropHelper", "reload: " + this.aAs.getAbsolutePath() + ", exist? " + this.aAs.exists());
            }
            Properties properties = null;
            if (this.aAs.exists()) {
                Properties properties2 = new Properties();
                try {
                    try {
                        fileInputStream = new FileInputStream(this.aAs);
                    } catch (Throwable th2) {
                        fileInputStream = null;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    Log.w("TTPropHelper", th3.getMessage());
                }
                try {
                    properties2.load(fileInputStream);
                    if (DbA) {
                        Log.d("TTPropHelper", "reload: find " + properties2.size() + " ,items from " + this.aAs.getAbsolutePath());
                    }
                    fileInputStream.close();
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        Log.e("TTPropHelper", "reload: ", th);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        properties = properties2;
                        synchronized (this.Os) {
                        }
                    } catch (Throwable th5) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th6) {
                                Log.w("TTPropHelper", th6.getMessage());
                            }
                        }
                        throw th5;
                    }
                }
                properties = properties2;
            }
            synchronized (this.Os) {
                if (properties != null) {
                    if (!properties.isEmpty()) {
                        this.ui = properties;
                    }
                }
                this.MGA = true;
                this.Os.notifyAll();
            }
        }
    }

    private void aGH() {
        while (!this.MGA) {
            try {
                this.Os.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public String eli(String str, String str2) {
        String property;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        synchronized (this.Os) {
            aGH();
            property = this.ui.getProperty(str, str2);
        }
        return property;
    }

    public int eli(String str, int i) {
        int parseInt;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.Os) {
                try {
                    try {
                        aGH();
                        parseInt = Integer.parseInt(this.ui.getProperty(str, String.valueOf(i)));
                    } catch (NumberFormatException e) {
                        Log.e("TTPropHelper", e.getMessage());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return parseInt;
        }
        return i;
    }

    public long eli(String str, long j) {
        long parseLong;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.Os) {
                try {
                    try {
                        aGH();
                        parseLong = Long.parseLong(this.ui.getProperty(str, String.valueOf(j)));
                    } catch (NumberFormatException e) {
                        Log.e("TTPropHelper", e.getMessage());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return parseLong;
        }
        return j;
    }

    public float eli(String str, float f) {
        float parseFloat;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.Os) {
                try {
                    try {
                        aGH();
                        parseFloat = Float.parseFloat(this.ui.getProperty(str, String.valueOf(f)));
                    } catch (NumberFormatException e) {
                        Log.e("TTPropHelper", e.getMessage());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return parseFloat;
        }
        return f;
    }

    public boolean eli(String str, boolean z) {
        boolean parseBoolean;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.Os) {
                try {
                    try {
                        aGH();
                        parseBoolean = Boolean.parseBoolean(this.ui.getProperty(str, String.valueOf(z)));
                    } catch (NumberFormatException e) {
                        Log.e("TTPropHelper", e.getMessage());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return parseBoolean;
        }
        return z;
    }

    public boolean eli(String str) {
        boolean containsKey;
        synchronized (this.Os) {
            try {
                try {
                    aGH();
                    containsKey = this.ui.containsKey(str);
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return containsKey;
    }

    public Os DbA() {
        return new Os();
    }

    private static class DbA {
        final Properties DbA;
        final CountDownLatch Os;
        volatile boolean aGH;
        final long eli;
        boolean ui;

        private DbA(long j, Properties properties) {
            this.Os = new CountDownLatch(1);
            this.aGH = false;
            this.ui = false;
            this.eli = j;
            this.DbA = properties;
        }

        void eli(boolean z, boolean z2) {
            this.ui = z;
            this.aGH = z2;
            this.Os.countDown();
        }
    }

    public class Os implements SharedPreferences.Editor {
        private final Object DbA = new Object();
        private final Map<String, Object> Os = new HashMap();
        private boolean aGH = false;

        public Os() {
        }

        @Override // android.content.SharedPreferences.Editor
        public /* synthetic */ SharedPreferences.Editor putStringSet(String str, Set set) {
            return eli(str, (Set<String>) set);
        }

        public Os eli(String str, Set<String> set) {
            synchronized (this.DbA) {
                this.Os.put(str, set == null ? null : new HashSet(set));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Os putInt(String str, int i) {
            synchronized (this.DbA) {
                this.Os.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Os putLong(String str, long j) {
            synchronized (this.DbA) {
                this.Os.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Os putFloat(String str, float f) {
            synchronized (this.DbA) {
                this.Os.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Os putString(String str, String str2) {
            synchronized (this.DbA) {
                this.Os.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Os putBoolean(String str, boolean z) {
            synchronized (this.DbA) {
                this.Os.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Os remove(String str) {
            synchronized (this.DbA) {
                this.Os.put(str, this);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public Os clear() {
            synchronized (this.DbA) {
                this.aGH = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            long currentTimeMillis = eli.DbA ? System.currentTimeMillis() : 0L;
            DbA DbA = DbA();
            eli.this.eli(DbA, true);
            try {
                DbA.Os.await();
                if (eli.DbA) {
                    Log.d("TTPropHelper", eli.this.aAs.getName() + ":" + DbA.eli + " committed after " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
                return DbA.aGH;
            } catch (InterruptedException unused) {
                if (!eli.DbA) {
                    return false;
                }
                Log.d("TTPropHelper", eli.this.aAs.getName() + ":" + DbA.eli + " committed after " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return false;
            } catch (Throwable th) {
                if (eli.DbA) {
                    Log.d("TTPropHelper", eli.this.aAs.getName() + ":" + DbA.eli + " committed after " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
                throw th;
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            eli.this.eli(DbA(), false);
        }

        private DbA DbA() {
            Properties properties;
            long j;
            Object obj;
            boolean z;
            synchronized (eli.this.Os) {
                if (eli.this.kb > 0) {
                    Properties properties2 = new Properties();
                    properties2.putAll(eli.this.ui);
                    eli.this.ui = properties2;
                }
                properties = eli.this.ui;
                eli.ui(eli.this);
                synchronized (this.DbA) {
                    boolean z2 = false;
                    if (this.aGH) {
                        if (properties.isEmpty()) {
                            z = false;
                        } else {
                            properties.clear();
                            z = true;
                        }
                        this.aGH = false;
                        z2 = z;
                    }
                    for (Map.Entry<String, Object> entry : this.Os.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value != this && value != null) {
                            if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(String.valueOf(value))) {
                                properties.put(key, String.valueOf(value));
                                z2 = true;
                            }
                        }
                        if (properties.containsKey(key)) {
                            properties.remove(key);
                            z2 = true;
                        }
                    }
                    this.Os.clear();
                    if (z2) {
                        eli.MGA(eli.this);
                    }
                    j = eli.this.wC;
                }
            }
            return new DbA(j, properties);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final DbA dbA, final boolean z) {
        boolean z2;
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.eli.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (eli.this.aGH) {
                    try {
                        eli.this.DbA(dbA, z);
                    } catch (OutOfMemoryError unused) {
                    }
                }
                synchronized (eli.this.Os) {
                    eli.FC(eli.this);
                }
            }
        };
        if (z) {
            synchronized (this.Os) {
                z2 = this.kb == 1;
            }
            if (z2) {
                runnable.run();
                return;
            }
        }
        com.bytedance.sdk.component.DbA.eli(runnable, true ^ z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0127 A[Catch: all -> 0x01a2, TryCatch #3 {all -> 0x01a2, blocks: (B:38:0x0093, B:39:0x0095, B:57:0x0123, B:59:0x0127, B:60:0x012e, B:62:0x0137, B:63:0x013f, B:65:0x014b, B:104:0x01a0, B:105:0x01a1, B:55:0x00e8, B:56:0x0122, B:72:0x00ed, B:73:0x00f3, B:82:0x011b, B:97:0x019e, B:96:0x0195), top: B:37:0x0093, inners: #9, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0137 A[Catch: all -> 0x01a2, TryCatch #3 {all -> 0x01a2, blocks: (B:38:0x0093, B:39:0x0095, B:57:0x0123, B:59:0x0127, B:60:0x012e, B:62:0x0137, B:63:0x013f, B:65:0x014b, B:104:0x01a0, B:105:0x01a1, B:55:0x00e8, B:56:0x0122, B:72:0x00ed, B:73:0x00f3, B:82:0x011b, B:97:0x019e, B:96:0x0195), top: B:37:0x0093, inners: #9, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014b A[Catch: all -> 0x01a2, TRY_LEAVE, TryCatch #3 {all -> 0x01a2, blocks: (B:38:0x0093, B:39:0x0095, B:57:0x0123, B:59:0x0127, B:60:0x012e, B:62:0x0137, B:63:0x013f, B:65:0x014b, B:104:0x01a0, B:105:0x01a1, B:55:0x00e8, B:56:0x0122, B:72:0x00ed, B:73:0x00f3, B:82:0x011b, B:97:0x019e, B:96:0x0195), top: B:37:0x0093, inners: #9, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void DbA(DbA dbA, boolean z) {
        long j;
        long j2;
        Throwable th;
        long j3;
        String str;
        String message;
        FileOutputStream fileOutputStream;
        boolean z2;
        long currentTimeMillis = DbA ? System.currentTimeMillis() : 0L;
        boolean exists = this.aAs.exists();
        if (DbA) {
            j = System.currentTimeMillis();
            j2 = j;
        } else {
            j = 0;
            j2 = 0;
        }
        if (exists) {
            if (this.FC >= dbA.eli) {
                z2 = false;
            } else if (z) {
                z2 = true;
            } else {
                synchronized (this.Os) {
                    z2 = this.wC == dbA.eli;
                }
            }
            if (!z2) {
                dbA.eli(false, true);
                return;
            }
            boolean exists2 = this.du.exists();
            if (DbA) {
                j2 = System.currentTimeMillis();
            }
            if (!exists2) {
                if (!this.aAs.renameTo(this.du)) {
                    Log.e("TTPropHelper", "Couldn't rename file " + this.aAs + " to backup file " + this.du);
                    dbA.eli(false, false);
                    return;
                }
            } else {
                this.aAs.delete();
            }
        }
        try {
            synchronized (this.aGH) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(this.aAs);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        try {
                            j3 = DbA ? System.currentTimeMillis() : 0L;
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream2 = fileOutputStream;
                            j3 = 0;
                            Log.e("TTPropHelper", "saveToLocal: ", e);
                            dbA.eli(false, false);
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable th3) {
                                    str = "TTPropHelper";
                                    message = th3.getMessage();
                                    Log.w(str, message);
                                    if (DbA) {
                                    }
                                    this.du.delete();
                                    if (DbA) {
                                    }
                                    this.FC = dbA.eli;
                                    dbA.eli(true, true);
                                    if (DbA) {
                                    }
                                }
                            }
                            if (DbA) {
                            }
                            this.du.delete();
                            if (DbA) {
                            }
                            this.FC = dbA.eli;
                            dbA.eli(true, true);
                            if (DbA) {
                            }
                        }
                        try {
                            dbA.DbA.store(fileOutputStream, (String) null);
                            if (DbA) {
                                Log.d("TTPropHelper", "save: " + dbA.DbA);
                                Log.d("TTPropHelper", "saveToLocal: save to" + this.aAs.getAbsolutePath() + "success");
                            }
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream2 = fileOutputStream;
                            Log.e("TTPropHelper", "saveToLocal: ", e);
                            dbA.eli(false, false);
                            if (fileOutputStream2 != null) {
                            }
                            if (DbA) {
                            }
                            this.du.delete();
                            if (DbA) {
                            }
                            this.FC = dbA.eli;
                            dbA.eli(true, true);
                            if (DbA) {
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                                throw th;
                            } catch (Throwable th5) {
                                Log.w("TTPropHelper", th5.getMessage());
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    fileOutputStream.close();
                } catch (Throwable th6) {
                    str = "TTPropHelper";
                    message = th6.getMessage();
                    Log.w(str, message);
                    if (DbA) {
                    }
                    this.du.delete();
                    if (DbA) {
                    }
                    this.FC = dbA.eli;
                    dbA.eli(true, true);
                    if (DbA) {
                    }
                }
            }
            long currentTimeMillis2 = DbA ? System.currentTimeMillis() : 0L;
            this.du.delete();
            long currentTimeMillis3 = DbA ? System.currentTimeMillis() : 0L;
            this.FC = dbA.eli;
            dbA.eli(true, true);
            if (DbA) {
                Log.d("TTPropHelper", "write: " + (j - currentTimeMillis) + RemoteSettings.FORWARD_SLASH_STRING + (j2 - currentTimeMillis) + RemoteSettings.FORWARD_SLASH_STRING + (j3 - currentTimeMillis) + RemoteSettings.FORWARD_SLASH_STRING + (currentTimeMillis2 - currentTimeMillis) + RemoteSettings.FORWARD_SLASH_STRING + (currentTimeMillis3 - currentTimeMillis));
            }
        } catch (Throwable th7) {
            Log.w("TTPropHelper", "writeToFile: Got exception:", th7);
            if (this.aAs.exists() && !this.aAs.delete()) {
                Log.e("TTPropHelper", "Couldn't clean up partially-written file " + this.aAs);
            }
            dbA.eli(false, false);
        }
    }
}
