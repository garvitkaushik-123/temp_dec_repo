package com.apm.insight.e.a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.apm.insight.c;
import com.apm.insight.runtime.j;
import java.util.HashMap;

/* compiled from: AbsDAO.java */
/* loaded from: classes2.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final String f237a;
    private String b = "_id";

    protected abstract ContentValues a(T t);

    protected abstract HashMap<String, String> a();

    protected a(String str) {
        this.f237a = str;
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append(this.f237a).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> a2 = a();
            for (String str : a2.keySet()) {
                sb.append(str).append(" ").append(a2.get(str)).append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append(")");
            sQLiteDatabase.execSQL(sb.toString());
        } catch (Throwable th) {
            c.a();
            j.a(th, "NPTH_CATCH");
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.f237a, null, a((a<T>) t));
        } catch (Throwable th) {
            com.apm.insight.a.b(th);
        }
    }
}
