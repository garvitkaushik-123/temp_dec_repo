package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes5.dex */
public final class zzax {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        if (r0 == false) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void zza(zzhe zzheVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        Throwable th;
        Cursor cursor;
        if (zzheVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        ?? r4 = 0;
        try {
            try {
                cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = cursor.moveToFirst();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzheVar.zzk().zzc("Error querying for table", str, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    sQLiteDatabase.execSQL(str2);
                    try {
                        HashSet hashSet = new HashSet();
                        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
                        try {
                            Collections.addAll(hashSet, rawQuery.getColumnNames());
                            rawQuery.close();
                            for (String str4 : str3.split(",")) {
                                if (!hashSet.remove(str4)) {
                                    throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                                }
                            }
                            if (strArr != null) {
                                for (int i = 0; i < strArr.length; i += 2) {
                                    if (!hashSet.remove(strArr[i])) {
                                        sQLiteDatabase.execSQL(strArr[i + 1]);
                                    }
                                }
                            }
                            if (hashSet.isEmpty()) {
                                return;
                            }
                            zzheVar.zzk().zzc("Table has extra columns. table, columns", str, TextUtils.join(", ", hashSet));
                        } catch (Throwable th2) {
                            rawQuery.close();
                            throw th2;
                        }
                    } catch (SQLiteException e2) {
                        zzheVar.zze().zzb("Failed to verify columns on table that was just created", str);
                        throw e2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = str2;
                if (r4 != 0) {
                    throw th;
                }
                r4.close();
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
            if (r4 != 0) {
            }
        }
    }

    static void zzb(zzhe zzheVar, SQLiteDatabase sQLiteDatabase) {
        if (zzheVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        com.google.android.gms.internal.measurement.zzbx.zza();
        String path = sQLiteDatabase.getPath();
        int i = com.google.android.gms.internal.measurement.zzcc.zzb;
        File file = new File(path);
        if (!file.setReadable(false, false)) {
            zzheVar.zzk().zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzheVar.zzk().zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzheVar.zzk().zza("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzheVar.zzk().zza("Failed to turn on database write permission for owner");
    }
}
