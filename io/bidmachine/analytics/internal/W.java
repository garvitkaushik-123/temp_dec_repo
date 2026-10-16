package io.bidmachine.analytics.internal;

import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class W implements V {

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteOpenHelper f6674a;
    private final Lazy b = LazyKt.lazy(new a());

    static final class a extends Lambda implements Function0 {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final S invoke() {
            return new S(W.this.f6674a);
        }
    }

    public W(SQLiteOpenHelper sQLiteOpenHelper) {
        this.f6674a = sQLiteOpenHelper;
    }

    @Override // io.bidmachine.analytics.internal.V
    public Object b(List list) {
        S a2 = a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(U.a((Q) it.next()));
        }
        return a2.a(arrayList);
    }

    @Override // io.bidmachine.analytics.internal.V
    public Object c(List list) {
        S a2 = a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(U.a((Q) it.next()));
        }
        return a2.b(arrayList);
    }

    private final S a() {
        return (S) this.b.getValue();
    }

    @Override // io.bidmachine.analytics.internal.V
    public Object a(Q q) {
        return a().a(U.a(q));
    }

    @Override // io.bidmachine.analytics.internal.V
    public Object a(String str, String str2) {
        return a(a().a(str, str2));
    }

    @Override // io.bidmachine.analytics.internal.V
    public Object a(String str, String str2, int i) {
        return a(a().a(str, str2, Integer.valueOf(i)));
    }

    @Override // io.bidmachine.analytics.internal.V
    public Object a(List list) {
        S a2 = a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(U.a((Q) it.next()));
        }
        return a2.c(arrayList);
    }

    public final Object b() {
        return a().a();
    }

    @Override // io.bidmachine.analytics.internal.V
    public Object a(String str, List list) {
        return a().a(str, list);
    }

    private final Object a(Object obj) {
        try {
            Result.Companion companion = Result.INSTANCE;
            ResultKt.throwOnFailure(obj);
            Iterable iterable = (Iterable) obj;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(U.a((T) it.next()));
            }
            return Result.m10241constructorimpl(arrayList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }
}
