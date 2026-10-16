package io.bidmachine.analytics.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class S {
    public static final a b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteOpenHelper f6670a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SQLiteDatabase f6671a;
        final /* synthetic */ ContentValues b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
            super(1);
            this.f6671a = sQLiteDatabase;
            this.b = contentValues;
        }

        public final void a(List list) {
            SQLiteDatabase sQLiteDatabase = this.f6671a;
            ContentValues contentValues = this.b;
            String[] strArr = null;
            String a2 = list != null ? AbstractC3577q.a(list, "id IN") : null;
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((T) it.next()).c());
                }
                strArr = AbstractC3577q.a(arrayList);
            }
            sQLiteDatabase.update("monitor_record", contentValues, a2, strArr);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SQLiteDatabase f6672a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SQLiteDatabase sQLiteDatabase) {
            super(1);
            this.f6672a = sQLiteDatabase;
        }

        public final void a(List list) {
            SQLiteDatabase sQLiteDatabase = this.f6672a;
            String[] strArr = null;
            String a2 = list != null ? AbstractC3577q.a(list, "id IN") : null;
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((T) it.next()).c());
                }
                strArr = AbstractC3577q.a(arrayList);
            }
            sQLiteDatabase.delete("monitor_record", a2, strArr);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return Unit.INSTANCE;
        }
    }

    public S(SQLiteOpenHelper sQLiteOpenHelper) {
        this.f6670a = sQLiteOpenHelper;
    }

    public final Object a(T t) {
        Object m10241constructorimpl;
        synchronized (this.f6670a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f6670a.getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", t.c());
                    contentValues.put("name", t.d());
                    contentValues.put("timestamp", Long.valueOf(t.f()));
                    contentValues.put("session_id", t.e());
                    contentValues.put("data", s0.b(t.a(), t.c()));
                    contentValues.put("error", s0.b(t.b(), t.c()));
                    writableDatabase.insert("monitor_record", null, contentValues);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writableDatabase, null);
                    m10241constructorimpl = Result.m10241constructorimpl(unit);
                } finally {
                }
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
        }
        return m10241constructorimpl;
    }

    public final Object b(List list) {
        return a(false, list);
    }

    public final Object c(List list) {
        return a(true, list);
    }

    public final Object a(String str, String str2) {
        return a(str, str2, (Integer) null);
    }

    public final Object a(String str, String str2, Integer num) {
        return a("name = ? AND session_id = ? AND is_reserved = 0", new String[]{str, str2}, num != null ? num.toString() : null);
    }

    private final Object a(String str, String[] strArr, String str2) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f6670a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase readableDatabase = this.f6670a.getReadableDatabase();
                try {
                    Cursor query = readableDatabase.query("monitor_record", new String[]{"id", "name", "timestamp", "session_id", "data", "error"}, str, strArr, null, null, "timestamp DESC", str2);
                    while (query.moveToNext()) {
                        try {
                            try {
                                Result.Companion companion2 = Result.INSTANCE;
                                String string = query.getString(0);
                                String string2 = query.getString(1);
                                long j = query.getLong(2);
                                try {
                                    try {
                                        try {
                                            Result.m10241constructorimpl(Boolean.valueOf(arrayList.add(new T(string, string2, query.getString(3), j, s0.a(query.getBlob(4), string), s0.a(query.getBlob(5), string)))));
                                        } catch (Throwable th) {
                                            th = th;
                                            Result.Companion companion3 = Result.INSTANCE;
                                            Result.m10241constructorimpl(ResultKt.createFailure(th));
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        Result.Companion companion32 = Result.INSTANCE;
                                        Result.m10241constructorimpl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } finally {
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(query, null);
                    CloseableKt.closeFinally(readableDatabase, null);
                    Result.m10241constructorimpl(unit);
                } finally {
                }
            } catch (Throwable th5) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m10241constructorimpl(ResultKt.createFailure(th5));
            }
        }
        Result.Companion companion5 = Result.INSTANCE;
        return Result.m10241constructorimpl(arrayList);
    }

    public final Object a() {
        return a(false, (List) null);
    }

    private final Object a(boolean z, List list) {
        Object m10241constructorimpl;
        synchronized (this.f6670a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f6670a.getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_reserved", Boolean.valueOf(z));
                    AbstractC3577q.a(list, writableDatabase, 0, new b(writableDatabase, contentValues), 2, null);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writableDatabase, null);
                    m10241constructorimpl = Result.m10241constructorimpl(unit);
                } finally {
                }
            } finally {
            }
        }
        return m10241constructorimpl;
    }

    public final Object a(List list) {
        Object m10241constructorimpl;
        synchronized (this.f6670a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f6670a.getWritableDatabase();
                try {
                    AbstractC3577q.a(list, writableDatabase, 0, new c(writableDatabase), 2, null);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writableDatabase, null);
                    m10241constructorimpl = Result.m10241constructorimpl(unit);
                } finally {
                }
            } finally {
            }
        }
        return m10241constructorimpl;
    }

    public final Object a(String str, List list) {
        Object m10241constructorimpl;
        synchronized (this.f6670a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f6670a.getWritableDatabase();
                try {
                    writableDatabase.delete("monitor_record", "session_id != ? OR " + AbstractC3577q.a(list, "name NOT IN"), AbstractC3577q.a(CollectionsKt.plus((Collection) CollectionsKt.listOf(str), (Iterable) list)));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writableDatabase, null);
                    m10241constructorimpl = Result.m10241constructorimpl(unit);
                } finally {
                }
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
        }
        return m10241constructorimpl;
    }
}
