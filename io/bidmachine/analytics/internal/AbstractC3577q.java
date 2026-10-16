package io.bidmachine.analytics.internal;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: io.bidmachine.analytics.internal.q, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC3577q {

    /* renamed from: io.bidmachine.analytics.internal.q$a */
    static final class a extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6781a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Object obj) {
            return "?";
        }
    }

    public static final String a(List list, String str) {
        if (list != null) {
            return str + " (" + CollectionsKt.joinToString$default(list, ",", null, null, 0, null, a.f6781a, 30, null) + ')';
        }
        return null;
    }

    public static /* synthetic */ void a(List list, SQLiteDatabase sQLiteDatabase, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 100;
        }
        a(list, sQLiteDatabase, i, function1);
    }

    public static final void a(List list, SQLiteDatabase sQLiteDatabase, int i, Function1 function1) {
        if (list == null) {
            function1.invoke(null);
            return;
        }
        sQLiteDatabase.beginTransaction();
        try {
            Iterator it = CollectionsKt.chunked(list, i).iterator();
            while (it.hasNext()) {
                function1.invoke((List) it.next());
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static final String[] a(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
