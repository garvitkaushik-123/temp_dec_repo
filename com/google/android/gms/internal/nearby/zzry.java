package com.google.android.gms.internal.nearby;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzry {
    static HashMap zze;
    private static Object zzl;
    private static boolean zzm;
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri zzb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzk = new AtomicBoolean();
    static final HashMap zzf = new HashMap();
    static final HashMap zzg = new HashMap();
    static final HashMap zzh = new HashMap();
    static final HashMap zzi = new HashMap();
    static final String[] zzj = new String[0];

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zzb(ContentResolver contentResolver, String str, boolean z) {
        Object obj;
        String str2;
        Object obj2;
        synchronized (zzry.class) {
            zzc(contentResolver);
            obj = zzl;
        }
        HashMap hashMap = zzf;
        boolean z2 = true;
        Boolean bool = true;
        synchronized (zzry.class) {
            str2 = null;
            if (hashMap.containsKey("gms:nearby:requires_gms_check")) {
                obj2 = hashMap.get("gms:nearby:requires_gms_check");
                if (obj2 == null) {
                    obj2 = bool;
                }
            } else {
                obj2 = null;
            }
        }
        Boolean bool2 = (Boolean) obj2;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        synchronized (zzry.class) {
            zzc(contentResolver);
            Object obj3 = zzl;
            if (zze.containsKey("gms:nearby:requires_gms_check")) {
                String str3 = (String) zze.get("gms:nearby:requires_gms_check");
                if (str3 != null) {
                    str2 = str3;
                }
            } else {
                int length = zzj.length;
                Cursor query = contentResolver.query(zza, null, null, new String[]{"gms:nearby:requires_gms_check"}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            String string = query.getString(1);
                            if (string != null && string.equals(null)) {
                                string = null;
                            }
                            zzd(obj3, "gms:nearby:requires_gms_check", string);
                            if (string != null) {
                                str2 = string;
                            }
                        } else {
                            zzd(obj3, "gms:nearby:requires_gms_check", null);
                        }
                    } finally {
                        query.close();
                    }
                }
            }
        }
        if (str2 != null && !str2.equals("")) {
            if (!zzc.matcher(str2).matches()) {
                if (zzd.matcher(str2).matches()) {
                    bool = false;
                    z2 = false;
                } else {
                    Log.w("Gservices", "attempt to read gservices key gms:nearby:requires_gms_check (value \"" + str2 + "\") as boolean");
                }
            }
            synchronized (zzry.class) {
                if (obj == zzl) {
                    hashMap.put("gms:nearby:requires_gms_check", bool);
                    zze.remove("gms:nearby:requires_gms_check");
                }
            }
            return z2;
        }
        bool = bool2;
        synchronized (zzry.class) {
        }
    }

    private static void zzc(ContentResolver contentResolver) {
        if (zze == null) {
            zzk.set(false);
            zze = new HashMap();
            zzl = new Object();
            zzm = false;
            contentResolver.registerContentObserver(zza, true, new zzrx(null));
            return;
        }
        if (zzk.getAndSet(false)) {
            zze.clear();
            zzf.clear();
            zzg.clear();
            zzh.clear();
            zzi.clear();
            zzl = new Object();
            zzm = false;
        }
    }

    private static void zzd(Object obj, String str, String str2) {
        synchronized (zzry.class) {
            if (obj == zzl) {
                zze.put("gms:nearby:requires_gms_check", str2);
            }
        }
    }
}
