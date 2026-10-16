package com.inmobi.media;

import android.content.ContentValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class T1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2433a;

    public T1(String tableName, String tableSchema) {
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(tableSchema, "tableSchema");
        this.f2433a = tableName;
        try {
            A3.f2229a.a(tableName, tableSchema);
        } catch (Exception unused) {
        }
    }

    public abstract Object a(ContentValues contentValues);

    public final void a(Object obj) {
        try {
            A3.a(this.f2433a, b(obj));
            Intrinsics.checkNotNullExpressionValue("T1", "TAG");
            Objects.toString(obj);
        } catch (Exception unused) {
        }
    }

    public abstract ContentValues b(Object obj);

    public final void b(Object obj, String str, String[] strArr) {
        try {
            A3.b(this.f2433a, b(obj), str, strArr);
            Intrinsics.checkNotNullExpressionValue("T1", "TAG");
            Objects.toString(obj);
        } catch (Exception unused) {
        }
    }

    public final void a(Object obj, String str, String[] strArr) {
        try {
            A3.a(this.f2433a, b(obj), str, strArr);
            Intrinsics.checkNotNullExpressionValue("T1", "TAG");
            Objects.toString(obj);
        } catch (Exception unused) {
        }
    }

    public final Object b(String str, String[] strArr) {
        try {
            List<ContentValues> b = A3.b(this.f2433a, null, str, strArr, null, null, null, null);
            if (!b.isEmpty()) {
                return a(b.get(0));
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static ArrayList a(T1 t1, String str, String[] strArr, String str2, String str3, String str4, Integer num, int i) {
        String str5 = (i & 1) != 0 ? null : str;
        String[] strArr2 = (i & 2) != 0 ? null : strArr;
        String str6 = (i & 4) != 0 ? null : str2;
        String str7 = (i & 8) != 0 ? null : str3;
        String str8 = (i & 16) != 0 ? null : str4;
        Integer num2 = (i & 32) != 0 ? null : num;
        t1.getClass();
        try {
            ArrayList arrayList = new ArrayList();
            List<ContentValues> b = A3.b(t1.f2433a, null, str5, strArr2, str6, str7, str8, num2 != null ? num2.toString() : null);
            if (!b.isEmpty()) {
                Iterator<ContentValues> it = b.iterator();
                while (it.hasNext()) {
                    arrayList.add(t1.a(it.next()));
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static int a(T1 t1, String str, String[] strArr, int i) {
        String str2 = (i & 1) != 0 ? null : str;
        String[] strArr2 = (i & 2) != 0 ? null : strArr;
        t1.getClass();
        try {
            return A3.a(t1.f2433a, null, str2, strArr2, null, null, null, null);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final int a(String str, String[] strArr) {
        try {
            return A3.a(this.f2433a, str, strArr);
        } catch (Exception unused) {
            return 0;
        }
    }
}
