package com.moloco.sdk.acm.db;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.moloco.sdk.acm.db.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class e implements com.moloco.sdk.acm.db.d {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f5319a;
    public final EntityInsertionAdapter<com.moloco.sdk.acm.db.b> b;
    public final com.moloco.sdk.acm.db.a c = new com.moloco.sdk.acm.db.a();
    public final EntityInsertionAdapter<com.moloco.sdk.acm.db.b> d;
    public final SharedSQLiteStatement e;
    public final SharedSQLiteStatement f;

    public class a extends EntityInsertionAdapter<com.moloco.sdk.acm.db.b> {
        public a(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `events` (`id`,`name`,`timestamp`,`eventType`,`data`,`tags`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }

        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement stmt, com.moloco.sdk.acm.db.b value) {
            stmt.bindLong(1, value.i());
            if (value.j() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.j());
            }
            stmt.bindLong(3, value.l());
            String a2 = e.this.c.a(value.h());
            if (a2 == null) {
                stmt.bindNull(4);
            } else {
                stmt.bindString(4, a2);
            }
            if (value.g() == null) {
                stmt.bindNull(5);
            } else {
                stmt.bindLong(5, value.g().longValue());
            }
            String a3 = e.this.c.a(value.k());
            if (a3 == null) {
                stmt.bindNull(6);
            } else {
                stmt.bindString(6, a3);
            }
        }
    }

    public class b extends EntityInsertionAdapter<com.moloco.sdk.acm.db.b> {
        public b(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR ABORT INTO `events` (`id`,`name`,`timestamp`,`eventType`,`data`,`tags`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }

        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement stmt, com.moloco.sdk.acm.db.b value) {
            stmt.bindLong(1, value.i());
            if (value.j() == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, value.j());
            }
            stmt.bindLong(3, value.l());
            String a2 = e.this.c.a(value.h());
            if (a2 == null) {
                stmt.bindNull(4);
            } else {
                stmt.bindString(4, a2);
            }
            if (value.g() == null) {
                stmt.bindNull(5);
            } else {
                stmt.bindLong(5, value.g().longValue());
            }
            String a3 = e.this.c.a(value.k());
            if (a3 == null) {
                stmt.bindNull(6);
            } else {
                stmt.bindString(6, a3);
            }
        }
    }

    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM events";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(RoomDatabase database) {
            super(database);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM sqlite_sequence WHERE name='events'";
        }
    }

    /* renamed from: com.moloco.sdk.acm.db.e$e, reason: collision with other inner class name */
    public class CallableC0426e implements Callable<Unit> {
        public CallableC0426e() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = e.this.e.acquire();
            e.this.f5319a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                e.this.f5319a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                e.this.f5319a.endTransaction();
                e.this.e.release(acquire);
            }
        }
    }

    public class f implements Callable<Unit> {
        public f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            SupportSQLiteStatement acquire = e.this.f.acquire();
            e.this.f5319a.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                e.this.f5319a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                e.this.f5319a.endTransaction();
                e.this.f.release(acquire);
            }
        }
    }

    public class g implements Callable<Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f5326a;

        public g(final List val$ids) {
            this.f5326a = val$ids;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() throws Exception {
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("DELETE FROM events WHERE id IN (");
            StringUtil.appendPlaceholders(newStringBuilder, this.f5326a.size());
            newStringBuilder.append(")");
            SupportSQLiteStatement compileStatement = e.this.f5319a.compileStatement(newStringBuilder.toString());
            Iterator it = this.f5326a.iterator();
            int i = 1;
            while (it.hasNext()) {
                compileStatement.bindLong(i, ((Long) it.next()).longValue());
                i++;
            }
            e.this.f5319a.beginTransaction();
            try {
                compileStatement.executeUpdateDelete();
                e.this.f5319a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                e.this.f5319a.endTransaction();
            }
        }
    }

    public e(RoomDatabase __db) {
        this.f5319a = __db;
        this.b = new a(__db);
        this.d = new b(__db);
        this.e = new c(__db);
        this.f = new d(__db);
    }

    public final /* synthetic */ Object e(Continuation continuation) {
        return d.a.a(this, continuation);
    }

    public final /* synthetic */ Object f(Continuation continuation) {
        return d.a.b(this, continuation);
    }

    @Override // com.moloco.sdk.acm.db.d
    public long a(final com.moloco.sdk.acm.db.b event) {
        this.f5319a.assertNotSuspendingTransaction();
        this.f5319a.beginTransaction();
        try {
            long insertAndReturnId = this.b.insertAndReturnId(event);
            this.f5319a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.f5319a.endTransaction();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public List<Long> b(final List<com.moloco.sdk.acm.db.b> events) {
        this.f5319a.assertNotSuspendingTransaction();
        this.f5319a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.d.insertAndReturnIdsList(events);
            this.f5319a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.f5319a.endTransaction();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object c(final Continuation<? super Unit> continuation) {
        return RoomDatabaseKt.withTransaction(this.f5319a, new Function1() { // from class: com.moloco.sdk.acm.db.e$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return e.this.f((Continuation) obj);
            }
        }, continuation);
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object d(final Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f5319a, true, new f(), continuation);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // com.moloco.sdk.acm.db.d
    public List<Long> a(final List<com.moloco.sdk.acm.db.b> events) {
        this.f5319a.assertNotSuspendingTransaction();
        this.f5319a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.b.insertAndReturnIdsList(events);
            this.f5319a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.f5319a.endTransaction();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object b(final Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f5319a, true, new CallableC0426e(), continuation);
    }

    @Override // com.moloco.sdk.acm.db.d
    public List<com.moloco.sdk.acm.db.b> b() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM events LIMIT 900", 0);
        this.f5319a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5319a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "eventType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "data");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "tags");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new com.moloco.sdk.acm.db.b(query.getLong(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.getLong(columnIndexOrThrow3), this.c.a(query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4)), query.isNull(columnIndexOrThrow5) ? null : Long.valueOf(query.getLong(columnIndexOrThrow5)), this.c.b(query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6))));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object a(final Continuation<? super List<com.moloco.sdk.acm.db.b>> continuation) {
        return RoomDatabaseKt.withTransaction(this.f5319a, new Function1() { // from class: com.moloco.sdk.acm.db.e$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return e.this.e((Continuation) obj);
            }
        }, continuation);
    }

    @Override // com.moloco.sdk.acm.db.d
    public com.moloco.sdk.acm.db.b a(long j) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM events WHERE id = ?", 1);
        acquire.bindLong(1, j);
        this.f5319a.assertNotSuspendingTransaction();
        com.moloco.sdk.acm.db.b bVar = null;
        String string = null;
        Cursor query = DBUtil.query(this.f5319a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "eventType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "data");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "tags");
            if (query.moveToFirst()) {
                long j2 = query.getLong(columnIndexOrThrow);
                String string2 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                long j3 = query.getLong(columnIndexOrThrow3);
                com.moloco.sdk.acm.db.c a2 = this.c.a(query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4));
                Long valueOf = query.isNull(columnIndexOrThrow5) ? null : Long.valueOf(query.getLong(columnIndexOrThrow5));
                if (!query.isNull(columnIndexOrThrow6)) {
                    string = query.getString(columnIndexOrThrow6);
                }
                bVar = new com.moloco.sdk.acm.db.b(j2, string2, j3, a2, valueOf, this.c.b(string));
            }
            return bVar;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public List<com.moloco.sdk.acm.db.b> a() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM events", 0);
        this.f5319a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f5319a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "eventType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "data");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "tags");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new com.moloco.sdk.acm.db.b(query.getLong(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.getLong(columnIndexOrThrow3), this.c.a(query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4)), query.isNull(columnIndexOrThrow5) ? null : Long.valueOf(query.getLong(columnIndexOrThrow5)), this.c.b(query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6))));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object a(final List<Long> ids, final Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.f5319a, true, new g(ids), continuation);
    }
}
