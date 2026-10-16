package com.bytedance.sdk.openadsdk.core.settings;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.bf;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.settings.ui;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class nlS implements ui {
    private eli aAs;
    private final String kb;
    private final ConcurrentHashMap<String, Object> Os = new ConcurrentHashMap<>();
    private final Object aGH = new Object();
    private final Object ui = new Object();
    private final CountDownLatch MGA = new CountDownLatch(1);
    private Properties wC = new Properties();
    private volatile boolean FC = false;

    public interface eli {
        void DbA();

        void eli();
    }

    public nlS(String str, eli eliVar) {
        this.kb = str;
        this.aAs = eliVar;
        cyF.eli(new com.bytedance.sdk.component.wC.wC("SetL_".concat(String.valueOf(str))) { // from class: com.bytedance.sdk.openadsdk.core.settings.nlS.1
            @Override // java.lang.Runnable
            public void run() {
                nlS.this.eli(false);
            }
        });
    }

    public String eli(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return str2;
        }
        ui();
        return this.wC.getProperty(str, str2);
    }

    private void ui() {
        if (this.FC) {
            return;
        }
        try {
            SystemClock.elapsedRealtime();
            this.MGA.await(cyF.MGA() ? 4 : 8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Xb.eli("SdkSettings.Prop", "awaitLoadedLocked: ", e);
        }
    }

    public int eli(String str, int i) {
        if (str != null && !str.isEmpty()) {
            ui();
            try {
                return Integer.parseInt(this.wC.getProperty(str, String.valueOf(i)));
            } catch (NumberFormatException e) {
                Xb.eli("SdkSettings.Prop", "", e);
            }
        }
        return i;
    }

    public long eli(String str, long j) {
        if (str != null && !str.isEmpty()) {
            ui();
            try {
                return Long.parseLong(this.wC.getProperty(str, String.valueOf(j)));
            } catch (NumberFormatException e) {
                Xb.eli("SdkSettings.Prop", "", e);
            }
        }
        return j;
    }

    public float eli(String str, float f) {
        if (str != null && !str.isEmpty()) {
            ui();
            try {
                return Float.parseFloat(this.wC.getProperty(str, String.valueOf(f)));
            } catch (NumberFormatException e) {
                Xb.eli("SdkSettings.Prop", "", e);
            }
        }
        return f;
    }

    public boolean eli(String str, boolean z) {
        if (str != null && !str.isEmpty()) {
            ui();
            try {
                return Boolean.parseBoolean(this.wC.getProperty(str, String.valueOf(z)));
            } catch (Exception e) {
                Xb.eli("SdkSettings.Prop", "", e);
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0107 A[Catch: all -> 0x0117, TryCatch #3 {, blocks: (B:4:0x0003, B:7:0x0009, B:10:0x000b, B:12:0x0016, B:22:0x0051, B:23:0x0056, B:24:0x0103, B:26:0x0107, B:28:0x010b, B:29:0x010e, B:30:0x0115, B:45:0x006a, B:46:0x006d, B:49:0x0088, B:50:0x008b, B:51:0x0090, B:36:0x0080, B:37:0x0083, B:54:0x0091, B:56:0x009b, B:59:0x00a5, B:61:0x00ba, B:62:0x00ca, B:64:0x00d0, B:67:0x00e2, B:72:0x00ea, B:80:0x00f5, B:81:0x00f8, B:43:0x0061, B:40:0x0077, B:34:0x0072), top: B:3:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli(boolean z) {
        eli eliVar;
        Object obj;
        FileInputStream fileInputStream;
        synchronized (this.aGH) {
            if (!this.FC || z) {
                File MGA = MGA();
                if (MGA.exists()) {
                    Properties properties = new Properties();
                    FileInputStream fileInputStream2 = null;
                    try {
                        try {
                            fileInputStream = new FileInputStream(MGA);
                        } catch (Throwable th) {
                            if (fileInputStream2 != null) {
                                com.bytedance.sdk.openadsdk.utils.NU.eli(fileInputStream2);
                            }
                            this.aGH.notifyAll();
                            throw th;
                        }
                    } catch (OutOfMemoryError unused) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        properties.load(fileInputStream);
                        new Object[]{"reload: find", Integer.valueOf(properties.size()), "items from " + MGA.getAbsolutePath()};
                        if (!properties.isEmpty()) {
                            this.wC = properties;
                            this.Os.clear();
                        }
                        com.bytedance.sdk.openadsdk.utils.NU.eli(fileInputStream);
                        obj = this.aGH;
                    } catch (OutOfMemoryError unused2) {
                        fileInputStream2 = fileInputStream;
                        try {
                            com.bytedance.sdk.component.utils.kb.Os(MGA);
                        } catch (Throwable th3) {
                            Xb.eli("SdkSettings.Prop", "delete: ", th3);
                        }
                        if (fileInputStream2 != null) {
                            com.bytedance.sdk.openadsdk.utils.NU.eli(fileInputStream2);
                        }
                        obj = this.aGH;
                        obj.notifyAll();
                        if (!this.FC) {
                            eliVar.eli();
                        }
                        this.FC = true;
                        this.MGA.countDown();
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream2 = fileInputStream;
                        Xb.eli("SdkSettings.Prop", "reload: ", th);
                        if (fileInputStream2 != null) {
                            com.bytedance.sdk.openadsdk.utils.NU.eli(fileInputStream2);
                        }
                        obj = this.aGH;
                        obj.notifyAll();
                        if (!this.FC) {
                        }
                        this.FC = true;
                        this.MGA.countDown();
                    }
                    obj.notifyAll();
                } else if (bf.eli(dV.eli()) && "tt_sdk_settings.prop".equals(this.kb)) {
                    try {
                        boolean z2 = false;
                        SharedPreferences sharedPreferences = dV.eli().getSharedPreferences("tt_sdk_settings", 0);
                        if (!sharedPreferences.getAll().isEmpty()) {
                            ui.eli eli2 = eli();
                            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                                String key = entry.getKey();
                                Object value = entry.getValue();
                                if (key != null && !key.isEmpty() && value != null) {
                                    eli2.eli(key, value.toString());
                                    z2 = true;
                                }
                            }
                            if (z2) {
                                eli2.eli();
                            }
                            sharedPreferences.edit().clear().commit();
                        }
                    } catch (Exception unused3) {
                    }
                }
                if (!this.FC && (eliVar = this.aAs) != null) {
                    eliVar.eli();
                }
                this.FC = true;
                this.MGA.countDown();
            }
        }
    }

    private File MGA() {
        return new File(dV.eli().getFilesDir(), this.kb);
    }

    public ui.eli eli() {
        return new DbA();
    }

    public <T> T eli(String str, T t, ui.DbA<T> dbA) {
        T DbA2;
        if (str != null && !str.isEmpty()) {
            T t2 = (T) this.Os.get(str);
            if (t2 != null) {
                return t2;
            }
            ui();
            String property = this.wC.getProperty(str, null);
            if (property != null && dbA != null && (DbA2 = dbA.DbA(property)) != null) {
                this.Os.put(str, DbA2);
                return DbA2;
            }
        }
        return t;
    }

    public boolean DbA() {
        return this.FC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.String] */
    public void eli(Properties properties) {
        FileOutputStream fileOutputStream;
        synchronized (this.ui) {
            File MGA = MGA();
            FileOutputStream fileOutputStream2 = null;
            FileOutputStream fileOutputStream3 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(MGA);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                properties.store(fileOutputStream, (String) null);
                ?? r2 = "success";
                new Object[]{"saveToLocal: save to", MGA.getAbsolutePath(), "success"};
                com.bytedance.sdk.openadsdk.utils.NU.eli(fileOutputStream);
                fileOutputStream2 = r2;
            } catch (Exception e2) {
                e = e2;
                fileOutputStream3 = fileOutputStream;
                Xb.eli("SdkSettings.Prop", "saveToLocal: ", e);
                fileOutputStream2 = fileOutputStream3;
                if (fileOutputStream3 != null) {
                    com.bytedance.sdk.openadsdk.utils.NU.eli(fileOutputStream3);
                    fileOutputStream2 = fileOutputStream3;
                }
                NU.QW();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    com.bytedance.sdk.openadsdk.utils.NU.eli(fileOutputStream2);
                }
                throw th;
            }
        }
        NU.QW();
    }

    public void Os() {
        File MGA = MGA();
        if (MGA.exists()) {
            MGA.delete();
        }
    }

    public class DbA implements ui.eli {
        private final Map<String, Object> DbA = new HashMap();
        private final Object Os = new Object();

        public DbA() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ui.eli
        public void eli() {
            Object obj;
            new Object[]{"commit: ", this.DbA};
            Properties properties = new Properties();
            synchronized (this.Os) {
                properties.putAll(nlS.this.wC);
                boolean z = false;
                for (Map.Entry<String, Object> entry : this.DbA.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value != this && value != null) {
                        if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(value)) {
                            properties.put(key, String.valueOf(value));
                            z = true;
                        }
                    }
                    if (properties.containsKey(key)) {
                        properties.remove(key);
                        z = true;
                    }
                }
                this.DbA.clear();
                if (z) {
                    nlS.this.eli(properties);
                    nlS.this.wC = properties;
                    nlS.this.Os.clear();
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ui.eli
        public ui.eli eli(String str, String str2) {
            synchronized (this.Os) {
                this.DbA.put(str, str2);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ui.eli
        public ui.eli eli(String str, int i) {
            synchronized (this.Os) {
                this.DbA.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ui.eli
        public ui.eli eli(String str, long j) {
            synchronized (this.Os) {
                this.DbA.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ui.eli
        public ui.eli eli(String str) {
            synchronized (this.Os) {
                this.DbA.put(str, this);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ui.eli
        public ui.eli eli(String str, float f) {
            synchronized (this.Os) {
                this.DbA.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ui.eli
        public ui.eli eli(String str, boolean z) {
            synchronized (this.Os) {
                this.DbA.put(str, Boolean.valueOf(z));
            }
            return this;
        }
    }

    protected void aGH() {
        eli eliVar = this.aAs;
        if (eliVar != null) {
            eliVar.DbA();
        }
    }
}
