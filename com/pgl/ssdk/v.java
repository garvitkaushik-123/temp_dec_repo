package com.pgl.ssdk;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ironsource.C3114ha;
import com.ironsource.N6;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.pgl.ssdk.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f6410a = null;
    private static volatile String b = null;
    private static volatile boolean c = false;
    private static String d = null;
    private static String e = null;
    private static String f = null;
    private static int g = -1;
    private static long h = 0;
    private static long i = 0;
    private static volatile long j = -1;

    public static void a(File file, boolean z) {
        e a2;
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
                try {
                    if (TextUtils.isEmpty(f6410a) && (a2 = a(file)) != null) {
                        f6410a = a(a2.a());
                        d = a2.b();
                        if (z) {
                            a();
                            randomAccessFile2.close();
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(e)) {
                        e = a(randomAccessFile2);
                    }
                    if (h == 0) {
                        h = randomAccessFile2.length() / 1024;
                    }
                    if (i == 0) {
                        i = b(file);
                    }
                    randomAccessFile2.close();
                } catch (FileNotFoundException unused) {
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (IOException unused2) {
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused4) {
            }
        } catch (FileNotFoundException unused5) {
        } catch (IOException unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b() {
        long j2;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        long j3;
        long j4;
        int i2;
        String str5;
        if (TextUtils.isEmpty(f6410a) || TextUtils.isEmpty(e) || g == -1) {
            SharedPreferences a2 = x0.a(z.b());
            long j5 = -1;
            if (a2 != null) {
                j5 = a2.getLong(N6.Z0, -1L);
                str2 = a2.getString("sa", null);
                str3 = a2.getString("sj", null);
                str4 = a2.getString("md5", null);
                j3 = a2.getLong("as", 0L);
                j4 = a2.getLong("ds", 0L);
                z = true;
                i2 = a2.getInt("cpc", -1);
                j2 = 0;
                str = a2.getString(C3114ha.c, null);
            } else {
                j2 = 0;
                z = true;
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                j3 = 0;
                j4 = 0;
                i2 = 0;
            }
            String c2 = c();
            if (c2 == null) {
                return null;
            }
            File file = new File(c2);
            str5 = null;
            Object[] objArr = (Object[]) com.pgl.ssdk.ces.a.meta(158, z.b(), c2);
            Integer num = (Integer) objArr[0];
            String str6 = (String) objArr[z ? 1 : 0];
            long lastModified = file.lastModified();
            if (lastModified != j5 || str2 == null || i2 == -1) {
                j = lastModified;
                if (str6 != null) {
                    f = str6;
                }
                if (num != null) {
                    g = num.intValue();
                }
                a(file, false);
                a();
            } else {
                f6410a = str2;
                d = str3;
                h = j3;
                i = j4;
                e = str4;
                g = i2;
                f = str;
            }
        } else {
            j2 = 0;
            str5 = null;
            z = true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(f6410a)) {
                jSONObject.put("sign", f6410a);
            }
            if (!TextUtils.isEmpty(d)) {
                jSONObject.put("subject", d);
            }
            if (!TextUtils.isEmpty(e)) {
                jSONObject.put("md5", e);
            }
            if (!TextUtils.isEmpty(f)) {
                jSONObject.put("path", f);
            }
            long j6 = h;
            if (j6 != j2) {
                jSONObject.put("apkSize", j6);
            }
            long j7 = i;
            if (j7 != j2) {
                jSONObject.put("dexSize", j7);
            }
            int i3 = g;
            if (i3 != -1) {
                jSONObject.put("code", i3);
            }
            f();
            jSONObject.put("signpm", b);
            if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(f6410a)) {
                if (!b.equals(f6410a)) {
                    c = z;
                }
                jSONObject.put("rebud", c);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return str5;
        }
    }

    public static String c() {
        if (z.b() == null) {
            return null;
        }
        String packageCodePath = z.b().getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (file.exists() && file.canRead()) {
            return packageCodePath;
        }
        return null;
    }

    public static void d() {
        if (TextUtils.isEmpty(f6410a)) {
            SharedPreferences a2 = x0.a(z.b());
            String str = null;
            long j2 = -1;
            if (a2 != null) {
                j2 = a2.getLong(N6.Z0, -1L);
                str = a2.getString("sa", null);
            }
            String c2 = c();
            if (TextUtils.isEmpty(c2)) {
                return;
            }
            File file = new File(c2);
            long lastModified = file.lastModified();
            if (lastModified != j2 || str == null) {
                j = lastModified;
                a(file, true);
                a();
            } else {
                f6410a = str;
            }
        }
        f();
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(f6410a) || b.equals(f6410a)) {
            return;
        }
        c = true;
    }

    public static String e() {
        d();
        return f6410a;
    }

    public static String f() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            String a2 = a(z.b().getPackageManager().getPackageInfo(z.b().getPackageName(), 64).signatures[0].toByteArray());
            b = a2;
            return a2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        d();
        return c;
    }

    public static void a() {
        SharedPreferences a2 = x0.a(z.b());
        if (a2 != null) {
            if (!TextUtils.isEmpty(f6410a)) {
                a2.edit().putString("sa", f6410a).apply();
            }
            if (!TextUtils.isEmpty(e)) {
                a2.edit().putString("md5", e).apply();
            }
            if (!TextUtils.isEmpty(d)) {
                a2.edit().putString("sj", d).apply();
            }
            if (h != 0) {
                a2.edit().putLong("as", h).apply();
            }
            if (i != 0) {
                a2.edit().putLong("ds", i).apply();
            }
            if (j != -1) {
                a2.edit().putLong(N6.Z0, j).apply();
            }
            if (g != -1) {
                a2.edit().putInt("cpc", g).apply();
            }
            if (TextUtils.isEmpty(f)) {
                return;
            }
            a2.edit().putString(C3114ha.c, f).apply();
        }
    }

    public static long b(File file) {
        String format;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 == 0) {
                        format = "classes.dex";
                    } else {
                        format = String.format(Locale.getDefault(), "classes%d.dex", Integer.valueOf(i2));
                    }
                    ZipEntry entry = zipFile2.getEntry(format);
                    if (entry == null) {
                        break;
                    }
                    try {
                        i3 = (int) (i3 + entry.getSize());
                        i2++;
                    } catch (ZipException unused) {
                        zipFile = zipFile2;
                        if (zipFile == null) {
                            return 0L;
                        }
                        zipFile.close();
                        return 0L;
                    } catch (IOException unused2) {
                        zipFile = zipFile2;
                        if (zipFile == null) {
                            return 0L;
                        }
                        zipFile.close();
                        return 0L;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                long j2 = i3 / 1000;
                try {
                    zipFile2.close();
                } catch (IOException unused4) {
                }
                return j2;
            } catch (IOException unused5) {
                return 0L;
            }
        } catch (ZipException unused6) {
        } catch (IOException unused7) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    @DungeonFlag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static e a(File file) {
        RandomAccessFile randomAccessFile;
        List<e> list;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
            } catch (IOException unused) {
                list = null;
                if (list != null) {
                }
                list = k.a(file);
                if (list != null) {
                }
                return null;
            }
            try {
                q a2 = r.a(randomAccessFile, 0L, randomAccessFile.length());
                list = l.a(a2, c.a(a2));
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (g.a unused3) {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                list = null;
                if (list != null) {
                }
                list = k.a(file);
                if (list != null) {
                }
                return null;
            } catch (Throwable unused4) {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                list = null;
                if (list != null) {
                }
                list = k.a(file);
                if (list != null) {
                }
                return null;
            }
        } catch (g.a unused5) {
            randomAccessFile = null;
        } catch (Throwable unused6) {
            randomAccessFile = null;
        }
        if (list != null || list.isEmpty()) {
            list = k.a(file);
        }
        if (list != null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static String a(RandomAccessFile randomAccessFile) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = "0".concat(String.valueOf(bigInteger));
            }
            return bigInteger;
        } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
