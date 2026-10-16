package com.inmobi.media;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class A3 {
    public static final SQLiteDatabase b;

    /* renamed from: a, reason: collision with root package name */
    public static final A3 f2229a = new A3();
    public static final Object c = new Object();

    static {
        try {
            b = new C2969z3(Uc.d()).getWritableDatabase();
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final int a(String tableName, ContentValues contentValues, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        synchronized (c) {
            long a2 = a(tableName, contentValues);
            if (a2 == -1) {
                return b(tableName, contentValues, str, strArr);
            }
            return (int) a2;
        }
    }

    @JvmStatic
    public static final int b(String tableName, ContentValues contentValues, String str, String[] strArr) {
        int i;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            if (sQLiteDatabase != null) {
                i = sQLiteDatabase.updateWithOnConflict(tableName, contentValues, str, strArr, 4);
            } else {
                Intrinsics.checkNotNullExpressionValue("A3", "TAG");
                i = -1;
            }
        }
        return i;
    }

    @JvmStatic
    public static final long a(String tableName, ContentValues contentValues) {
        long j;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            if (sQLiteDatabase != null) {
                j = sQLiteDatabase.insertWithOnConflict(tableName, null, contentValues, 4);
            } else {
                Intrinsics.checkNotNullExpressionValue("A3", "TAG");
                j = -1;
            }
        }
        return j;
    }

    @JvmStatic
    public static final List<ContentValues> b(String tableName, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        Cursor query;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            query = sQLiteDatabase != null ? sQLiteDatabase.query(tableName, strArr, str, strArr2, str2, str3, str4, str5) : null;
            Unit unit = Unit.INSTANCE;
        }
        if (query != null) {
            try {
                ArrayList arrayList = new ArrayList();
                if (query.moveToFirst()) {
                    do {
                        ContentValues contentValues = new ContentValues();
                        DatabaseUtils.cursorRowToContentValues(query, contentValues);
                        arrayList.add(contentValues);
                    } while (query.moveToNext());
                }
                CloseableKt.closeFinally(query, null);
                return arrayList;
            } finally {
            }
        } else {
            return CollectionsKt.emptyList();
        }
    }

    @JvmStatic
    public static final int a(String tableName, String str, String[] strArr) {
        int i;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            if (sQLiteDatabase != null) {
                i = sQLiteDatabase.delete(tableName, str, strArr);
            } else {
                Intrinsics.checkNotNullExpressionValue("A3", "TAG");
                i = 0;
            }
        }
        return i;
    }

    @JvmStatic
    public static final void a(String tableName) {
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        String str = "DROP TABLE IF EXISTS \"" + tableName + '\"';
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.execSQL(str);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void a(String tableName, String tableSchema) {
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(tableSchema, "tableSchema");
        String str = "CREATE TABLE IF NOT EXISTS " + tableName + tableSchema + ';';
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.execSQL(str);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @JvmStatic
    public static final int a(String tableName, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        int i;
        Cursor query;
        int columnIndex;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        synchronized (c) {
            SQLiteDatabase sQLiteDatabase = b;
            i = 0;
            query = sQLiteDatabase != null ? sQLiteDatabase.query(tableName, new String[]{"COUNT(*) AS count"}, str, strArr2, str2, str3, str4, str5) : null;
            Unit unit = Unit.INSTANCE;
        }
        if (query != null) {
            try {
                try {
                    if (query.moveToFirst() && (columnIndex = query.getColumnIndex("count")) >= 0) {
                        i = query.getInt(columnIndex);
                    }
                    CloseableKt.closeFinally(query, null);
                    return i;
                } finally {
                }
            } catch (Exception unused) {
            }
        }
        return i;
    }
}
