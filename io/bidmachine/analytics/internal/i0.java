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
public final class i0 {
    public static final a b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteOpenHelper f6706a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SQLiteDatabase f6707a;
        final /* synthetic */ ContentValues b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
            super(1);
            this.f6707a = sQLiteDatabase;
            this.b = contentValues;
        }

        public final void a(List list) {
            SQLiteDatabase sQLiteDatabase = this.f6707a;
            ContentValues contentValues = this.b;
            String[] strArr = null;
            String a2 = list != null ? AbstractC3577q.a(list, "id IN") : null;
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((j0) it.next()).c());
                }
                strArr = AbstractC3577q.a(arrayList);
            }
            sQLiteDatabase.update("reader_record", contentValues, a2, strArr);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SQLiteDatabase f6708a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SQLiteDatabase sQLiteDatabase) {
            super(1);
            this.f6708a = sQLiteDatabase;
        }

        public final void a(List list) {
            SQLiteDatabase sQLiteDatabase = this.f6708a;
            String[] strArr = null;
            String a2 = list != null ? AbstractC3577q.a(list, "id IN") : null;
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((j0) it.next()).c());
                }
                strArr = AbstractC3577q.a(arrayList);
            }
            sQLiteDatabase.delete("reader_record", a2, strArr);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return Unit.INSTANCE;
        }
    }

    public i0(SQLiteOpenHelper sQLiteOpenHelper) {
        this.f6706a = sQLiteOpenHelper;
    }

    public final Object a(j0 j0Var) {
        Object m10241constructorimpl;
        synchronized (this.f6706a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f6706a.getWritableDatabase();
                try {
                    writableDatabase.insert("reader_record", null, b(j0Var));
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

    public final Object b() {
        return a(false, (List) null);
    }

    public final Object c(j0 j0Var) {
        Object m10241constructorimpl;
        synchronized (this.f6706a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f6706a.getWritableDatabase();
                try {
                    writableDatabase.update("reader_record", b(j0Var), "id = ?", new String[]{j0Var.c()});
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

    public final Object d(List list) {
        return a(false, list);
    }

    public final Object e(List list) {
        return a(true, list);
    }

    public final Object b(List list) {
        Object m10241constructorimpl;
        synchronized (this.f6706a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f6706a.getWritableDatabase();
                try {
                    writableDatabase.delete("reader_record", AbstractC3577q.a(list, "name NOT IN"), AbstractC3577q.a(list));
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

    private final ContentValues b(j0 j0Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", j0Var.c());
        contentValues.put("name", j0Var.d());
        contentValues.put("timestamp", Long.valueOf(j0Var.f()));
        contentValues.put("data_hash", j0Var.a());
        contentValues.put("rule", s0.c(j0Var.e()));
        contentValues.put("error", s0.b(j0Var.b(), j0Var.c()));
        contentValues.put("is_dirty", Boolean.valueOf(j0Var.g()));
        return contentValues;
    }

    public final Object c(List list) {
        Object m10241constructorimpl;
        synchronized (this.f6706a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(s0.c((String) it.next()));
                }
                SQLiteDatabase writableDatabase = this.f6706a.getWritableDatabase();
                try {
                    writableDatabase.delete("reader_record", AbstractC3577q.a(arrayList, "rule NOT IN"), AbstractC3577q.a(arrayList));
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

    public final Object a(String str, String str2) {
        Object a2 = a(this, "name = ? AND rule = ? AND " + a(), new String[]{str, s0.c(str2)}, null, 4, null);
        if (Result.m10247isFailureimpl(a2)) {
            Result.Companion companion = Result.INSTANCE;
            Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a2);
            if (m10244exceptionOrNullimpl == null) {
                m10244exceptionOrNullimpl = new Exception();
            }
            return Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
        }
        Result.Companion companion2 = Result.INSTANCE;
        if (Result.m10247isFailureimpl(a2)) {
            a2 = null;
        }
        List list = (List) a2;
        return Result.m10241constructorimpl(list != null ? (j0) CollectionsKt.firstOrNull(list) : null);
    }

    public final Object a(String str) {
        return a(this, "name = ? AND is_reserved = 0 AND is_dirty = 1", new String[]{str}, null, 4, null);
    }

    static /* synthetic */ Object a(i0 i0Var, String str, String[] strArr, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            strArr = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return i0Var.a(str, strArr, str2);
    }

    private final Object a(String str, String[] strArr, String str2) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f6706a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase readableDatabase = this.f6706a.getReadableDatabase();
                try {
                    Cursor query = readableDatabase.query("reader_record", new String[]{"id", "name", "timestamp", "data_hash", "rule", "error", "is_dirty"}, str, strArr, null, null, "timestamp DESC", str2);
                    while (query.moveToNext()) {
                        try {
                            try {
                                Result.Companion companion2 = Result.INSTANCE;
                                String string = query.getString(0);
                                try {
                                    try {
                                        try {
                                            try {
                                                Result.m10241constructorimpl(Boolean.valueOf(arrayList.add(new j0(string, query.getString(1), query.getLong(2), query.getString(3), s0.a(query.getString(4)), s0.a(query.getBlob(5), string), query.getInt(6) == 1))));
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
                                        Result.Companion companion322 = Result.INSTANCE;
                                        Result.m10241constructorimpl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } catch (Throwable th5) {
                                th = th5;
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
            } catch (Throwable th6) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m10241constructorimpl(ResultKt.createFailure(th6));
            }
        }
        Result.Companion companion5 = Result.INSTANCE;
        return Result.m10241constructorimpl(arrayList);
    }

    private final Object a(boolean z, List list) {
        Object m10241constructorimpl;
        synchronized (this.f6706a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f6706a.getWritableDatabase();
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
        synchronized (this.f6706a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                SQLiteDatabase writableDatabase = this.f6706a.getWritableDatabase();
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
        synchronized (this.f6706a) {
            try {
                Result.Companion companion = Result.INSTANCE;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(s0.c((String) it.next()));
                }
                SQLiteDatabase writableDatabase = this.f6706a.getWritableDatabase();
                try {
                    writableDatabase.delete("reader_record", "name = ? AND " + a() + " AND " + AbstractC3577q.a(arrayList, "rule IN"), AbstractC3577q.a(CollectionsKt.plus((Collection) CollectionsKt.listOf(str), (Iterable) arrayList)));
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

    private final String a() {
        return "(LENGTH(error) = 0 OR error IS NULL)";
    }
}
