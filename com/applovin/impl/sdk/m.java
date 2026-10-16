package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.util.AtomicFile;
import com.applovin.impl.a4;
import com.applovin.impl.b6;
import com.applovin.impl.c2;
import com.applovin.impl.f2;
import com.applovin.impl.g2;
import com.applovin.impl.g5;
import com.applovin.impl.k7;
import com.applovin.impl.o0;
import com.applovin.impl.p6;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v4;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class m {
    private final k b;
    private final o c;
    private final boolean f;

    /* renamed from: a, reason: collision with root package name */
    private final String f704a = "FileManager";
    private final Object d = new Object();
    private final Set e = new HashSet();
    private final f2 g = a();

    m(k kVar) {
        this.b = kVar;
        this.c = kVar.O();
        this.f = ((Boolean) kVar.a(v4.U0)).booleanValue();
    }

    private f2 a() {
        if (o0.e() && ((Boolean) this.b.a(v4.q3)).booleanValue()) {
            try {
                return new a4(this.b);
            } catch (Throwable th) {
                if (o.a()) {
                    this.c.a("FileManager", "Error instantiating OkHttpLoader, falling back to HttpUrlConnectionLoader", th);
                }
                this.b.E().a("FileManager", "instantiateOkHttpLoader", th);
            }
        }
        return new g2(this.b);
    }

    private boolean e(File file) {
        if (file == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        synchronized (this.d) {
            if (this.e.contains(absolutePath)) {
                return false;
            }
            d(file);
            return true;
        }
    }

    private boolean g(File file) {
        if (o.a()) {
            this.c.a("FileManager", "Removing file " + file.getName() + " from filesystem...");
        }
        try {
            d(file);
            boolean delete = file.delete();
            if (!delete) {
                HashMap<String, String> hashMap = CollectionUtils.hashMap("path", file.getAbsolutePath());
                hashMap.put("details", b(file));
                this.b.E().a(c2.D0, "removeFile", hashMap);
            }
            return delete;
        } catch (Throwable th) {
            try {
                if (o.a()) {
                    this.c.a("FileManager", "Failed to remove file " + file.getName() + " from filesystem!", th);
                }
                this.b.E().a("FileManager", "removeFile", th);
                h(file);
                return false;
            } finally {
                h(file);
            }
        }
    }

    private void h(File file) {
        String absolutePath = file.getAbsolutePath();
        synchronized (this.d) {
            if (!this.e.remove(absolutePath)) {
                this.b.E().a(c2.D0, "unlockFile", CollectionUtils.hashMap("path", absolutePath));
            }
            this.d.notifyAll();
        }
    }

    public void b(Context context) {
        if (this.b.F0()) {
            if (o.a()) {
                this.c.a("FileManager", "Compacting cache...");
            }
            a(a(context), context);
        }
    }

    public void c(final com.applovin.impl.sdk.ad.b bVar, final Context context) {
        this.b.r0().a((g5) new p6(this.b, false, "removeCachedResourcesForAd", new Runnable() { // from class: com.applovin.impl.sdk.m$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                m.this.a(bVar, context);
            }
        }), b6.b.CACHING);
    }

    public void d(final com.applovin.impl.sdk.ad.b bVar, final Context context) {
        this.b.r0().a((g5) new p6(this.b, false, "removeCachedVideoResourceForAd", new Runnable() { // from class: com.applovin.impl.sdk.m$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                m.this.b(bVar, context);
            }
        }), b6.b.CACHING);
    }

    public String f(File file) {
        if (file == null) {
            return null;
        }
        if (o.a()) {
            this.c.a("FileManager", "Reading resource from filesystem: " + file.getName());
        }
        boolean z = true;
        try {
            try {
                try {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            d(file);
                            String a2 = a(fileInputStream);
                            boolean z2 = a2 == null;
                            fileInputStream.close();
                            if (z2 && ((Boolean) this.b.a(v4.M0)).booleanValue()) {
                                a(file, "removeFileAfterReadFail");
                            }
                            h(file);
                            return a2;
                        } catch (Throwable th) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (IOException e) {
                        if (o.a()) {
                            this.c.a("FileManager", "Failed to read file: " + file.getName() + e);
                        }
                        this.c.a("FileManager", e);
                        this.b.E().a("FileManager", "readFileIO", e);
                        if (((Boolean) this.b.a(v4.M0)).booleanValue()) {
                            a(file, "removeFileAfterReadFail");
                        }
                        h(file);
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (z && ((Boolean) this.b.a(v4.M0)).booleanValue()) {
                        a(file, "removeFileAfterReadFail");
                    }
                    h(file);
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                if (o.a()) {
                    this.c.d("FileManager", "File not found. " + e2);
                }
                this.c.a("FileManager", e2);
                this.b.E().a("FileManager", "readFileNotFound", e2);
                if (0 != 0 && ((Boolean) this.b.a(v4.M0)).booleanValue()) {
                    a(file, "removeFileAfterReadFail");
                }
                h(file);
                return null;
            } catch (Throwable th4) {
                if (o.a()) {
                    this.c.a("FileManager", "Unknown failure to read file.", th4);
                }
                this.c.a("FileManager", th4);
                this.b.E().a("FileManager", "readFile", th4);
                if (((Boolean) this.b.a(v4.M0)).booleanValue()) {
                    a(file, "removeFileAfterReadFail");
                }
                h(file);
                return null;
            }
        } catch (Throwable th5) {
            th = th5;
            z = false;
        }
    }

    private boolean c(File file) {
        boolean contains;
        String absolutePath = file.getAbsolutePath();
        synchronized (this.d) {
            contains = this.e.contains(absolutePath);
        }
        return contains;
    }

    private void d(File file) {
        String absolutePath = file.getAbsolutePath();
        synchronized (this.d) {
            boolean add = this.e.add(absolutePath);
            while (!add) {
                try {
                    this.d.wait();
                    add = this.e.add(absolutePath);
                } catch (InterruptedException e) {
                    if (o.a()) {
                        this.c.a("FileManager", "Lock '" + absolutePath + "' interrupted", e);
                    }
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.applovin.impl.sdk.ad.b bVar, Context context) {
        if (bVar.v0() == null) {
            return;
        }
        g(a(bVar.v0().getLastPathSegment(), context));
    }

    private List c(Context context) {
        File[] listFiles;
        File d = d(context);
        if (d.isDirectory() && (listFiles = d.listFiles()) != null) {
            return Arrays.asList(listFiles);
        }
        return Collections.emptyList();
    }

    private String b(File file) {
        try {
            boolean exists = file.exists();
            boolean isDirectory = file.isDirectory();
            String[] list = file.list();
            boolean z = true;
            boolean z2 = isDirectory && list != null && list.length == 0;
            File parentFile = file.getParentFile();
            boolean z3 = parentFile != null && parentFile.exists();
            if (!z3 || !parentFile.canWrite()) {
                z = false;
            }
            return "fileExists: " + exists + "\nisDirectory: " + isDirectory + "\nisEmptyDirectory: " + z2 + "\nparentDirectoryExists: " + z3 + "\nisParentDirectoryWritable: " + z;
        } catch (Throwable th) {
            return "Error retrieving file deletion failure reason: " + th;
        }
    }

    public void e(Context context) {
        try {
            a(".nomedia", context);
            File file = new File(d(context), ".nomedia");
            if (a(file)) {
                return;
            }
            if (o.a()) {
                this.c.a("FileManager", "Creating .nomedia file at " + file.getAbsolutePath());
            }
            if (file.createNewFile()) {
                return;
            }
            if (o.a()) {
                this.c.b("FileManager", "Failed to create .nomedia file");
            }
            this.b.E().a(c2.D0, "createNoMediaFile");
        } catch (IOException e) {
            if (o.a()) {
                this.c.a("FileManager", "Failed to create .nomedia file", e);
            }
        }
    }

    public File a(String str, Context context) {
        return a(str, true, context);
    }

    private File a(String str, boolean z, Context context) {
        if (!StringUtils.isValidString(str)) {
            if (o.a()) {
                this.c.a("FileManager", "Nothing to look up, skipping...");
            }
            return null;
        }
        if (o.a()) {
            this.c.a("FileManager", "Looking up cached resource: " + str);
        }
        if (str.contains("icon")) {
            str = str.replace(RemoteSettings.FORWARD_SLASH_STRING, "_").replace(".", "_");
        }
        File d = d(context);
        File file = new File(d, str);
        if (!z) {
            return file;
        }
        try {
            d.mkdirs();
            return file;
        } catch (Throwable th) {
            if (o.a()) {
                this.c.a("FileManager", "Unable to make cache directory at " + d, th);
            }
            this.b.E().a("FileManager", "createCacheDir", th);
            return null;
        }
    }

    public boolean c(String str, Context context) {
        if (this.f) {
            return b(str, context);
        }
        boolean z = false;
        File a2 = a(str, false, context);
        if (!e(a2)) {
            return false;
        }
        if (a2.exists() && !a2.isDirectory()) {
            z = true;
        }
        h(a2);
        return z;
    }

    private long b() {
        long longValue = ((Long) this.b.a(v4.B0)).longValue();
        if (longValue >= 0) {
            return longValue;
        }
        return -1L;
    }

    private File d(Context context) {
        return new File(context.getFilesDir(), CampaignEx.JSON_KEY_AD_AL);
    }

    public boolean b(String str, Context context) {
        return a(a(str, false, context));
    }

    public String a(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr, 0, 8192);
                    if (read >= 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                        byteArrayOutputStream.close();
                        return byteArrayOutputStream2;
                    }
                }
            } finally {
            }
        } catch (Throwable th) {
            this.c.a("FileManager", th);
            this.b.E().a("FileManager", "readInputStreamAsString", th);
            return null;
        }
    }

    public boolean a(InputStream inputStream, File file, boolean z) {
        return a(inputStream, file, z, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:201:0x02f2 A[Catch: all -> 0x033b, TRY_LEAVE, TryCatch #19 {all -> 0x033b, blocks: (B:199:0x02ec, B:201:0x02f2), top: B:198:0x02ec }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x031a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014a A[Catch: all -> 0x0198, TryCatch #17 {all -> 0x0198, blocks: (B:59:0x0144, B:61:0x014a, B:62:0x014f), top: B:58:0x0144 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(InputStream inputStream, File file, boolean z, boolean z2) {
        AtomicFile atomicFile;
        FileOutputStream fileOutputStream;
        boolean z3;
        Throwable th;
        boolean z4;
        Throwable th2;
        Throwable th3;
        if (o.a()) {
            this.c.a("FileManager", "Writing resource to filesystem: " + file.getName());
        }
        if (!this.f) {
            if (!z2) {
                d(file);
            }
            if (((Boolean) this.b.a(v4.Q0)).booleanValue() && !z && file.exists()) {
                if (o.a()) {
                    this.c.a("FileManager", "Overwrite not allowed for local resource: " + file.getName() + " - aborting write.");
                }
                this.b.E().a(c2.D0, "cacheResourceOverwriteAttempted", CollectionUtils.hashMap("path", file.getAbsolutePath()));
                return true;
            }
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                int i = 8192;
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr, 0, i);
                        if (read < 0) {
                            break;
                        }
                        try {
                            fileOutputStream2.write(bArr, 0, read);
                            i = 8192;
                        } catch (Throwable th4) {
                            if (o.a()) {
                                this.c.a("FileManager", "Failed to write next buffer to file", th4);
                            }
                            try {
                                this.b.E().a("FileManager", "writeResourceStream", th4);
                                try {
                                    fileOutputStream2.close();
                                    a(file, "removeFileAfterCacheFail");
                                    if (!z2) {
                                        h(file);
                                    }
                                    if (!((Boolean) this.b.a(v4.p3)).booleanValue()) {
                                        return false;
                                    }
                                    try {
                                        inputStream.close();
                                        return false;
                                    } catch (Throwable th5) {
                                        if (o.a()) {
                                            this.c.a("FileManager", "Unable to close resourceStream.", th5);
                                        }
                                        this.b.E().a("FileManager", "closeResourceStream", th5);
                                        return false;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    z4 = true;
                                    try {
                                        if (o.a()) {
                                        }
                                        this.c.a("FileManager", th);
                                        try {
                                            this.b.E().a("FileManager", "writeResource", th);
                                            a(file, "removeFileAfterCacheFail");
                                            if (!z2) {
                                            }
                                            if (((Boolean) this.b.a(v4.p3)).booleanValue()) {
                                            }
                                        } catch (Throwable th7) {
                                            th2 = th7;
                                            z4 = true;
                                            if (z4) {
                                                a(file, "removeFileAfterCacheFail");
                                            }
                                            if (!z2) {
                                                h(file);
                                            }
                                            if (((Boolean) this.b.a(v4.p3)).booleanValue()) {
                                                try {
                                                    inputStream.close();
                                                    throw th2;
                                                } catch (Throwable th8) {
                                                    if (o.a()) {
                                                        this.c.a("FileManager", "Unable to close resourceStream.", th8);
                                                    }
                                                    this.b.E().a("FileManager", "closeResourceStream", th8);
                                                    throw th2;
                                                }
                                            }
                                            throw th2;
                                        }
                                    } catch (Throwable th9) {
                                        th2 = th9;
                                    }
                                }
                            } catch (Throwable th10) {
                                th3 = th10;
                                z4 = true;
                                try {
                                    try {
                                        fileOutputStream2.close();
                                        throw th3;
                                    } catch (Throwable th11) {
                                        th = th11;
                                        if (o.a()) {
                                            this.c.a("FileManager", "Unknown failure to write file.", th);
                                        }
                                        this.c.a("FileManager", th);
                                        this.b.E().a("FileManager", "writeResource", th);
                                        a(file, "removeFileAfterCacheFail");
                                        if (!z2) {
                                            h(file);
                                        }
                                        if (((Boolean) this.b.a(v4.p3)).booleanValue()) {
                                            return false;
                                        }
                                        try {
                                            inputStream.close();
                                            return false;
                                        } catch (Throwable th12) {
                                            if (o.a()) {
                                                this.c.a("FileManager", "Unable to close resourceStream.", th12);
                                            }
                                            this.b.E().a("FileManager", "closeResourceStream", th12);
                                            return false;
                                        }
                                    }
                                } catch (Throwable th13) {
                                    th3.addSuppressed(th13);
                                    throw th3;
                                }
                            }
                        }
                    }
                    fileOutputStream2.close();
                    if (!z2) {
                        h(file);
                    }
                    if (((Boolean) this.b.a(v4.p3)).booleanValue()) {
                        try {
                            inputStream.close();
                        } catch (Throwable th14) {
                            if (o.a()) {
                                this.c.a("FileManager", "Unable to close resourceStream.", th14);
                            }
                            this.b.E().a("FileManager", "closeResourceStream", th14);
                        }
                    }
                    return true;
                } catch (Throwable th15) {
                    th3 = th15;
                    z4 = false;
                    fileOutputStream2.close();
                    throw th3;
                }
            } catch (Throwable th16) {
                th = th16;
                z4 = false;
            }
        } else {
            if (!z2) {
                try {
                    d(file);
                } catch (Throwable th17) {
                    th = th17;
                    atomicFile = null;
                    fileOutputStream = null;
                    z3 = false;
                    try {
                        if (o.a()) {
                        }
                        try {
                            this.b.E().a("FileManager", "writeResource", th);
                            if (atomicFile != null) {
                            }
                            if (!z2) {
                            }
                            if (((Boolean) this.b.a(v4.p3)).booleanValue()) {
                            }
                        } catch (Throwable th18) {
                            th = th18;
                            z3 = true;
                            if (atomicFile != null) {
                                if (z3) {
                                    atomicFile.failWrite(fileOutputStream);
                                } else {
                                    atomicFile.finishWrite(fileOutputStream);
                                }
                            }
                            if (!z2) {
                                h(file);
                            }
                            if (((Boolean) this.b.a(v4.p3)).booleanValue()) {
                                try {
                                    inputStream.close();
                                    throw th;
                                } catch (Throwable th19) {
                                    if (o.a()) {
                                        this.c.a("FileManager", "Unable to close resourceStream.", th19);
                                    }
                                    this.b.E().a("FileManager", "closeResourceStream", th19);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th20) {
                        th = th20;
                    }
                }
            }
            if (((Boolean) this.b.a(v4.Q0)).booleanValue() && !z && file.exists()) {
                if (o.a()) {
                    this.c.a("FileManager", "Overwrite not allowed for local resource: " + file.getName() + " - aborting write.");
                }
                this.b.E().a(c2.D0, "cacheResourceOverwriteAttempted", CollectionUtils.hashMap("path", file.getAbsolutePath()));
                if (!z2) {
                    h(file);
                }
                if (((Boolean) this.b.a(v4.p3)).booleanValue()) {
                    try {
                        inputStream.close();
                        return true;
                    } catch (Throwable th21) {
                        if (o.a()) {
                            this.c.a("FileManager", "Unable to close resourceStream.", th21);
                        }
                        this.b.E().a("FileManager", "closeResourceStream", th21);
                    }
                }
                return true;
            }
            atomicFile = new AtomicFile(file);
            try {
                fileOutputStream = atomicFile.startWrite();
                try {
                    byte[] bArr2 = new byte[8192];
                    while (true) {
                        int read2 = inputStream.read(bArr2, 0, 8192);
                        if (read2 < 0) {
                            break;
                        }
                        try {
                            fileOutputStream.write(bArr2, 0, read2);
                        } catch (Throwable th22) {
                            if (o.a()) {
                                this.c.a("FileManager", "Failed to write next buffer to file", th22);
                            }
                            try {
                                this.b.E().a("FileManager", "writeResourceStream", th22);
                                atomicFile.failWrite(fileOutputStream);
                                if (!z2) {
                                    h(file);
                                }
                                if (!((Boolean) this.b.a(v4.p3)).booleanValue()) {
                                    return false;
                                }
                                try {
                                    inputStream.close();
                                    return false;
                                } catch (Throwable th23) {
                                    if (o.a()) {
                                        this.c.a("FileManager", "Unable to close resourceStream.", th23);
                                    }
                                    this.b.E().a("FileManager", "closeResourceStream", th23);
                                    return false;
                                }
                            } catch (Throwable th24) {
                                th = th24;
                                z3 = true;
                                if (o.a()) {
                                }
                                this.b.E().a("FileManager", "writeResource", th);
                                if (atomicFile != null) {
                                }
                                if (!z2) {
                                }
                                if (((Boolean) this.b.a(v4.p3)).booleanValue()) {
                                }
                            }
                        }
                    }
                    atomicFile.finishWrite(fileOutputStream);
                    if (!z2) {
                        h(file);
                    }
                    if (((Boolean) this.b.a(v4.p3)).booleanValue()) {
                        try {
                            inputStream.close();
                        } catch (Throwable th25) {
                            if (o.a()) {
                                this.c.a("FileManager", "Unable to close resourceStream.", th25);
                            }
                            this.b.E().a("FileManager", "closeResourceStream", th25);
                        }
                    }
                    return true;
                } catch (Throwable th26) {
                    th = th26;
                    z3 = false;
                    if (o.a()) {
                        this.c.a("FileManager", "Unknown failure to write file.", th);
                    }
                    this.b.E().a("FileManager", "writeResource", th);
                    if (atomicFile != null) {
                        atomicFile.failWrite(fileOutputStream);
                    }
                    if (!z2) {
                        h(file);
                    }
                    if (((Boolean) this.b.a(v4.p3)).booleanValue()) {
                        return false;
                    }
                    try {
                        inputStream.close();
                        return false;
                    } catch (Throwable th27) {
                        if (o.a()) {
                            this.c.a("FileManager", "Unable to close resourceStream.", th27);
                        }
                        this.b.E().a("FileManager", "closeResourceStream", th27);
                        return false;
                    }
                }
            } catch (Throwable th28) {
                th = th28;
                fileOutputStream = null;
                z3 = false;
                if (o.a()) {
                }
                this.b.E().a("FileManager", "writeResource", th);
                if (atomicFile != null) {
                }
                if (!z2) {
                }
                if (((Boolean) this.b.a(v4.p3)).booleanValue()) {
                }
            }
        }
    }

    public boolean a(File file, String str, List list, int i, String str2, Map map) {
        return a(file, str, list, true, i, str2, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(File file, String str, List list, boolean z, int i, String str2, Map map) {
        HashMap<String, String> hashMap = CollectionUtils.hashMap("url", str);
        Map map2 = map;
        hashMap.putAll(map2);
        this.b.g().d(c2.x, hashMap);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = 1;
        while (i2 <= i) {
            if (a(file, str, list, z, str2, map2)) {
                a(true, str, i2, elapsedRealtime, map);
                return true;
            }
            i2++;
            map2 = map;
        }
        a(false, str, i, elapsedRealtime, map);
        return false;
    }

    private boolean a(File file, String str, List list, boolean z, String str2, Map map) {
        Boolean bool = (Boolean) this.b.a(v4.V0);
        if (bool.booleanValue()) {
            d(file);
        }
        if (a(file)) {
            if (o.a()) {
                this.c.a("FileManager", "File exists for " + str);
            }
            HashMap<String, String> hashMap = CollectionUtils.hashMap("url", str);
            hashMap.putAll(map);
            this.b.g().d(c2.y, hashMap);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            InputStream a2 = a(str, list, z, map);
            try {
                if (o.a()) {
                    this.c.a("FileManager", "Caching " + file.getAbsolutePath() + "...");
                }
                boolean a3 = a(a2, file, false, bool.booleanValue());
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                if (a3) {
                    if (o.a()) {
                        this.c.a("FileManager", "Caching completed for " + file);
                    }
                    double d = k7.d(elapsedRealtime2);
                    double c = k7.c(file.length());
                    long j = (long) (c / d);
                    Map a4 = a(file, str, elapsedRealtime2, map);
                    CollectionUtils.putObjectToStringIfValid("network_throughput_kbps", Long.valueOf(j), a4);
                    CollectionUtils.putObjectToStringIfValid("details", Double.valueOf(c), a4);
                    this.b.g().d(c2.D, a4);
                    this.b.d0().b(j, str, str2);
                } else {
                    if (o.a()) {
                        this.c.b("FileManager", "Unable to cache " + file.getAbsolutePath());
                    }
                    this.b.g().d(c2.E, a(file, str, elapsedRealtime2, map));
                }
                if (a2 != null) {
                    a2.close();
                }
                if (bool.booleanValue()) {
                    h(file);
                }
                return a3;
            } finally {
            }
        } catch (Throwable th) {
            try {
                this.c.a("FileManager", th);
                this.b.E().a("FileManager", "loadAndCacheResource", th);
                if (bool.booleanValue()) {
                    h(file);
                }
                return false;
            } finally {
                if (bool.booleanValue()) {
                    h(file);
                }
            }
        }
    }

    private Map a(File file, String str, long j, Map map) {
        HashMap<String, String> hashMap = CollectionUtils.hashMap("path", file.getAbsolutePath());
        CollectionUtils.putStringIfValid("url", str, hashMap);
        CollectionUtils.putObjectToStringIfValid("duration_ms", Long.valueOf(j), hashMap);
        hashMap.putAll(map);
        return hashMap;
    }

    private void a(boolean z, String str, int i, long j, Map map) {
        c2 c2Var = z ? c2.z : c2.A;
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        HashMap hashMap = new HashMap(3);
        hashMap.put("attempt_number", Integer.toString(i));
        hashMap.put("url", str);
        hashMap.put("duration_ms", String.valueOf(elapsedRealtime));
        hashMap.putAll(map);
        this.b.g().d(c2Var, hashMap);
    }

    public InputStream a(String str, List list, boolean z, Map map) {
        if (z && !k7.a(str, list)) {
            if (o.a()) {
                this.c.a("FileManager", "Domain is not whitelisted, skipping precache for url: " + str);
            }
            return null;
        }
        String httpsString = StringUtils.toHttpsString(str);
        if (o.a()) {
            this.c.a("FileManager", "Loading " + httpsString + "...");
        }
        HashMap<String, String> hashMap = CollectionUtils.hashMap("url", httpsString);
        hashMap.putAll(map);
        this.b.g().d(c2.B, hashMap);
        try {
            return this.g.a(httpsString, map);
        } catch (Throwable th) {
            if (o.a()) {
                this.c.a("FileManager", "Error loading " + httpsString, th);
            }
            this.b.E().a("FileManager", "loadResource", th, CollectionUtils.hashMap("url", httpsString));
            return null;
        }
    }

    public int a(String str, com.applovin.impl.sdk.ad.b bVar) {
        List d0 = bVar.d0();
        if (bVar.Z0() || d0.contains(str)) {
            return bVar.L();
        }
        return 1;
    }

    public String a(Context context, String str, String str2, List list, boolean z, int i, String str3, Map map) {
        return a(context, str, str2, list, z, false, i, str3, map);
    }

    public String a(Context context, String str, String str2, List list, boolean z, boolean z2, int i, String str3, Map map) {
        if (!StringUtils.isValidString(str)) {
            if (o.a()) {
                this.c.a("FileManager", "Nothing to cache, skipping...");
            }
            this.b.E().a(c2.D0, "cacheResource");
            return null;
        }
        String a2 = k7.a(Uri.parse(str), str2, this.b);
        File a3 = a(a2, context);
        if (!a(a3, str, list, z, i, str3, map)) {
            return null;
        }
        if (o.a()) {
            this.c.a("FileManager", "Caching succeeded for file " + a2);
        }
        return z2 ? Uri.fromFile(a3).toString() : a2;
    }

    private long a(Context context) {
        boolean z;
        long b = b();
        boolean z2 = b != -1;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        List c = this.b.c(v4.G0);
        long j = 0;
        for (File file : c(context)) {
            if (!z2 || c.contains(file.getName()) || c(file) || seconds - TimeUnit.MILLISECONDS.toSeconds(file.lastModified()) <= b) {
                z = false;
            } else {
                if (o.a()) {
                    this.c.a("FileManager", "File " + file.getName() + " has expired, removing...");
                }
                z = g(file);
            }
            if (!z) {
                j += file.length();
            }
        }
        return j;
    }

    private void a(long j, Context context) {
        long intValue = ((Integer) this.b.a(v4.C0)).intValue();
        if (intValue == -1) {
            if (o.a()) {
                this.c.a("FileManager", "Cache has no maximum size set; skipping drop...");
            }
        } else {
            if (a(j) > intValue) {
                if (o.a()) {
                    this.c.a("FileManager", "Cache has exceeded maximum size; dropping...");
                }
                Iterator it = c(context).iterator();
                while (it.hasNext()) {
                    g((File) it.next());
                }
                return;
            }
            if (o.a()) {
                this.c.a("FileManager", "Cache is present but under size limit; not dropping...");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, Context context) {
        ArrayList arrayList = new ArrayList(bVar.l());
        CollectionUtils.addObjectIfExists(bVar.v0(), arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            g(a(((Uri) it.next()).getLastPathSegment(), context));
        }
    }

    public void a(File file, String str) {
        if (o.a()) {
            this.c.a("FileManager", "Removing file " + file.getName() + " for source " + str + ".");
        }
        try {
            if (file.delete()) {
                return;
            }
            HashMap<String, String> hashMap = CollectionUtils.hashMap("path", file.getAbsolutePath());
            hashMap.put("details", b(file));
            this.b.E().a(c2.D0, str, hashMap);
        } catch (Throwable th) {
            if (o.a()) {
                this.c.a("FileManager", "Failed to remove file " + file.getName() + " from filesystem after failed operation.", th);
            }
            this.b.E().a("FileManager", str, th);
        }
    }

    private long a(long j) {
        return j / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    public boolean a(File file) {
        return (file == null || !file.exists() || file.isDirectory()) ? false : true;
    }
}
