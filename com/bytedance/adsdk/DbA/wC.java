package com.bytedance.adsdk.DbA;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import com.bytedance.adsdk.DbA.ui.ev;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes3.dex */
public class wC {
    private static final Map<String, NU<kb>> eli = new HashMap();
    private static final Set<Object> DbA = new HashSet();
    private static final byte[] Os = {80, 75, 3, 4};

    public static NU<kb> eli(Context context, String str) {
        return eli(context, str, "url_".concat(String.valueOf(str)));
    }

    public static NU<kb> eli(final Context context, final String str, final String str2) {
        return eli(str2, new Callable<nlS<kb>>() { // from class: com.bytedance.adsdk.DbA.wC.1
            @Override // java.util.concurrent.Callable
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public nlS<kb> call() throws Exception {
                nlS<kb> eli2 = ui.eli(context).eli(context, str, str2);
                if (str2 != null && eli2.eli() != null) {
                    com.bytedance.adsdk.DbA.Os.ui.eli().eli(str2, eli2.eli());
                }
                return eli2;
            }
        });
    }

    public static NU<kb> DbA(Context context, String str) {
        return DbA(context, str, "asset_".concat(String.valueOf(str)));
    }

    public static NU<kb> DbA(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return eli(str2, new Callable<nlS<kb>>() { // from class: com.bytedance.adsdk.DbA.wC.4
            @Override // java.util.concurrent.Callable
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public nlS<kb> call() throws Exception {
                return wC.Os(applicationContext, str, str2);
            }
        });
    }

    public static nlS<kb> Os(Context context, String str) {
        return Os(context, str, "asset_".concat(String.valueOf(str)));
    }

    public static nlS<kb> Os(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return DbA(context.getAssets().open(str), str2);
            }
            return eli(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new nlS<>((Throwable) e);
        }
    }

    public static NU<kb> eli(Context context, int i) {
        return eli(context, i, Os(context, i));
    }

    public static NU<kb> eli(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return eli(str, new Callable<nlS<kb>>() { // from class: com.bytedance.adsdk.DbA.wC.5
            @Override // java.util.concurrent.Callable
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public nlS<kb> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return wC.DbA(context2, i, str);
            }
        });
    }

    public static nlS<kb> DbA(Context context, int i) {
        return DbA(context, i, Os(context, i));
    }

    public static nlS<kb> DbA(Context context, int i, String str) {
        try {
            return DbA(context.getResources().openRawResource(i), Os(context, i));
        } catch (Resources.NotFoundException e) {
            return new nlS<>((Throwable) e);
        }
    }

    private static String Os(Context context, int i) {
        return "rawRes" + (eli(context) ? "_night_" : "_day_") + i;
    }

    private static boolean eli(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static NU<kb> eli(final InputStream inputStream, final String str) {
        return eli(str, new Callable<nlS<kb>>() { // from class: com.bytedance.adsdk.DbA.wC.6
            @Override // java.util.concurrent.Callable
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public nlS<kb> call() throws Exception {
                return wC.DbA(inputStream, str);
            }
        });
    }

    public static nlS<kb> DbA(InputStream inputStream, String str) {
        return eli(inputStream, str, true);
    }

    private static nlS<kb> eli(InputStream inputStream, String str, boolean z) {
        try {
            return eli(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.bytedance.adsdk.DbA.MGA.MGA.eli(inputStream);
            }
        }
    }

    public static nlS<kb> eli(JsonReader jsonReader, String str) {
        return eli(jsonReader, str, true);
    }

    private static nlS<kb> eli(JsonReader jsonReader, String str, boolean z) {
        try {
            try {
                kb eli2 = ev.eli(jsonReader);
                com.bytedance.adsdk.DbA.Os.ui.eli().eli(str, eli2);
                nlS<kb> nls = new nlS<>(eli2);
                if (z) {
                    eli(jsonReader);
                }
                return nls;
            } catch (Exception e) {
                nlS<kb> nls2 = new nlS<>(e);
                if (z) {
                    eli(jsonReader);
                }
                return nls2;
            }
        } catch (Throwable th) {
            if (z) {
                eli(jsonReader);
            }
            throw th;
        }
    }

    public static void eli(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static nlS<kb> eli(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return DbA(context, zipInputStream, str);
        } finally {
            com.bytedance.adsdk.DbA.MGA.MGA.eli(zipInputStream);
        }
    }

    private static nlS<kb> DbA(Context context, ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            kb kbVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    kbVar = eli(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).eli();
                } else {
                    if (!name.endsWith(".png") && !name.endsWith(".webp") && !name.endsWith(".jpg") && !name.endsWith(".jpeg")) {
                        if (!name.endsWith(".ttf") && !name.endsWith(".otf")) {
                            zipInputStream.closeEntry();
                        }
                        if (name.contains("../")) {
                            zipInputStream.closeEntry();
                            nextEntry = zipInputStream.getNextEntry();
                        } else {
                            String[] split = name.split(RemoteSettings.FORWARD_SLASH_STRING);
                            String str2 = split[split.length - 1];
                            String str3 = str2.split("\\.")[0];
                            File file = new File(context.getCacheDir(), str2);
                            new FileOutputStream(file);
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                try {
                                    byte[] bArr = new byte[4096];
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } finally {
                                }
                            } catch (Throwable unused) {
                                new StringBuilder("Unable to save font ").append(str3).append(" to the temporary file: ").append(str2);
                            }
                            Typeface createFromFile = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                new StringBuilder("Failed to delete temp font file ").append(file.getAbsolutePath());
                            }
                            hashMap2.put(str3, createFromFile);
                        }
                    }
                    if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] split2 = name.split(RemoteSettings.FORWARD_SLASH_STRING);
                        hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (kbVar == null) {
                return new nlS<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                aAs eli2 = eli(kbVar, (String) entry.getKey());
                if (eli2 != null) {
                    eli2.eli(com.bytedance.adsdk.DbA.MGA.MGA.eli((Bitmap) entry.getValue(), eli2.eli(), eli2.DbA()));
                }
            }
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                boolean z = false;
                for (com.bytedance.adsdk.DbA.Os.Os os : kbVar.Dfc().values()) {
                    if (os.eli().equals(entry2.getKey())) {
                        os.eli((Typeface) entry2.getValue());
                        z = true;
                    }
                }
                if (!z) {
                }
            }
            if (hashMap.isEmpty()) {
                Iterator<Map.Entry<String, aAs>> it = kbVar.aqO().entrySet().iterator();
                while (it.hasNext()) {
                    aAs value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String FC = value.FC();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (FC.startsWith("data:") && FC.indexOf("base64,") > 0) {
                        try {
                            byte[] decode = Base64.decode(FC.substring(FC.indexOf(44) + 1), 0);
                            value.eli(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                        } catch (IllegalArgumentException unused2) {
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, aAs> entry3 : kbVar.aqO().entrySet()) {
                if (entry3.getValue().du() == null) {
                    return new nlS<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().FC()));
                }
            }
            if (str != null) {
                com.bytedance.adsdk.DbA.Os.ui.eli().eli(str, kbVar);
            }
            return new nlS<>(kbVar);
        } catch (IOException e) {
            return new nlS<>((Throwable) e);
        }
    }

    private static aAs eli(kb kbVar, String str) {
        for (aAs aas : kbVar.aqO().values()) {
            if (aas.FC().equals(str)) {
                return aas;
            }
        }
        return null;
    }

    private static NU<kb> eli(final String str, Callable<nlS<kb>> callable) {
        final kb eli2 = str == null ? null : com.bytedance.adsdk.DbA.Os.ui.eli().eli(str);
        if (eli2 != null) {
            return new NU<>(new Callable<nlS<kb>>() { // from class: com.bytedance.adsdk.DbA.wC.7
                @Override // java.util.concurrent.Callable
                /* renamed from: eli, reason: merged with bridge method [inline-methods] */
                public nlS<kb> call() throws Exception {
                    return new nlS<>(kb.this);
                }
            });
        }
        if (str != null) {
            Map<String, NU<kb>> map = eli;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        NU<kb> nu = new NU<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            nu.eli(new du<kb>() { // from class: com.bytedance.adsdk.DbA.wC.2
                @Override // com.bytedance.adsdk.DbA.du
                public void eli(kb kbVar) {
                    wC.eli.remove(str);
                    atomicBoolean.set(true);
                    if (wC.eli.size() == 0) {
                        wC.DbA(true);
                    }
                }
            });
            nu.Os(new du<Throwable>() { // from class: com.bytedance.adsdk.DbA.wC.3
                @Override // com.bytedance.adsdk.DbA.du
                public void eli(Throwable th) {
                    wC.eli.remove(str);
                    atomicBoolean.set(true);
                    if (wC.eli.size() == 0) {
                        wC.DbA(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, NU<kb>> map2 = eli;
                map2.put(str, nu);
                if (map2.size() == 1) {
                    DbA(false);
                }
            }
        }
        return nu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(boolean z) {
        ArrayList arrayList = new ArrayList(DbA);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
    }
}
