package com.mbridge.msdk.util;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: MBridgeDatabaseUtils.java */
/* loaded from: classes6.dex */
public final class d {
    public static boolean a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    if (!sQLiteDatabase.isReadOnly()) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
