package com.ironsource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class G1 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2878a;
    private final boolean b;
    private final boolean c;
    private final int d;
    private final String e;
    private final String f;
    private final int g;
    private final int h;
    private final int i;
    private final List<Integer> j;
    private final List<Integer> k;
    private final List<Integer> l;
    private final List<Integer> m;

    public G1(JSONObject applicationEvents) {
        Intrinsics.checkNotNullParameter(applicationEvents, "applicationEvents");
        this.f2878a = applicationEvents.optBoolean(I1.f2906a, false);
        this.b = applicationEvents.optBoolean(I1.b, false);
        this.c = applicationEvents.optBoolean(I1.c, false);
        this.d = applicationEvents.optInt(I1.d, -1);
        String optString = applicationEvents.optString(I1.e);
        Intrinsics.checkNotNullExpressionValue(optString, "applicationEvents.optStr…(SERVER_EVENTS_URL_FIELD)");
        this.e = optString;
        String optString2 = applicationEvents.optString(I1.f);
        Intrinsics.checkNotNullExpressionValue(optString2, "applicationEvents.optString(SERVER_EVENTS_TYPE)");
        this.f = optString2;
        this.g = applicationEvents.optInt(I1.g, -1);
        this.h = applicationEvents.optInt(I1.h, -1);
        this.i = applicationEvents.optInt(I1.i, 5000);
        this.j = a(applicationEvents, I1.j);
        this.k = a(applicationEvents, I1.k);
        this.l = a(applicationEvents, I1.l);
        this.m = a(applicationEvents, I1.m);
    }

    public final int a() {
        return this.g;
    }

    public final boolean b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public final String d() {
        return this.f;
    }

    public final int e() {
        return this.i;
    }

    public final int f() {
        return this.h;
    }

    public final List<Integer> g() {
        return this.m;
    }

    public final List<Integer> h() {
        return this.k;
    }

    public final List<Integer> i() {
        return this.j;
    }

    public final boolean j() {
        return this.b;
    }

    public final boolean k() {
        return this.f2878a;
    }

    public final String l() {
        return this.e;
    }

    public final List<Integer> m() {
        return this.l;
    }

    private final List<Integer> a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return CollectionsKt.emptyList();
        }
        IntRange until = RangesKt.until(0, optJSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(optJSONArray.getInt(((IntIterator) it).nextInt())));
        }
        return arrayList;
    }
}
