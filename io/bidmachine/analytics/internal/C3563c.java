package io.bidmachine.analytics.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ironsource.D5;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: io.bidmachine.analytics.internal.c, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3563c extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6690a = new a(null);

    /* renamed from: io.bidmachine.analytics.internal.c$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public C3563c(Context context) {
        super(context, "BMAnalytics.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    private final Object a(SQLiteDatabase sQLiteDatabase) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Cursor query = sQLiteDatabase.query("sqlite_master", new String[]{"name"}, "type = ?", new String[]{D5.Q}, null, null, null);
            while (query.moveToNext()) {
                try {
                    try {
                        Result.Companion companion2 = Result.INSTANCE;
                        String string = query.getString(0);
                        if (!Intrinsics.areEqual(string, "android_metadata") && !Intrinsics.areEqual(string, "sqlite_master")) {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + string);
                        }
                        Result.m10241constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.INSTANCE;
                        Result.m10241constructorimpl(ResultKt.createFailure(th));
                    }
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
            return Result.m10241constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th2));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE monitor_record (id TEXT,name TEXT,timestamp INTEGER,session_id TEXT,data BLOB,error BLOB,is_reserved INTEGER DEFAULT 0)");
        sQLiteDatabase.execSQL("CREATE TABLE reader_record (id TEXT,name TEXT,timestamp INTEGER,data_hash TEXT,rule TEXT,error BLOB,is_dirty INTEGER,is_reserved INTEGER DEFAULT 0)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        a(sQLiteDatabase);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS monitor_record");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS reader_record");
        onCreate(sQLiteDatabase);
    }
}
