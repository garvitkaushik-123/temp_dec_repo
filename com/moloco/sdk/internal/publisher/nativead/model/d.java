package com.moloco.sdk.internal.publisher.nativead.model;

import android.net.Uri;
import com.moloco.sdk.internal.publisher.nativead.model.b;
import com.moloco.sdk.internal.publisher.nativead.model.c;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d {
    public static final int g = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Map<Integer, c.a> f5553a;
    public final Map<Integer, c.b> b;
    public final Map<Integer, c.C0450c> c;
    public final Map<Integer, c.d> d;
    public final List<Pair<b.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> e;
    public final Lazy f;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Map<Integer, c.a> data, Map<Integer, c.b> images, Map<Integer, c.C0450c> titles, Map<Integer, c.d> videos, List<? extends Pair<? extends b.a, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> failedAssets) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(titles, "titles");
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(failedAssets, "failedAssets");
        this.f5553a = data;
        this.b = images;
        this.c = titles;
        this.d = videos;
        this.e = failedAssets;
        this.f = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.publisher.nativead.model.d$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d.a(d.this);
            }
        });
    }

    public final Map<Integer, c.a> a() {
        return this.f5553a;
    }

    public final Map<Integer, c.b> b() {
        return this.b;
    }

    public final Map<Integer, c.C0450c> c() {
        return this.c;
    }

    public final Map<Integer, c.d> d() {
        return this.d;
    }

    public final List<Pair<b.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual(this.f5553a, dVar.f5553a) && Intrinsics.areEqual(this.b, dVar.b) && Intrinsics.areEqual(this.c, dVar.c) && Intrinsics.areEqual(this.d, dVar.d) && Intrinsics.areEqual(this.e, dVar.e);
    }

    public final Map<Integer, c> f() {
        return (Map) this.f.getValue();
    }

    public int hashCode() {
        return (((((((this.f5553a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "PreparedNativeAssets(data=" + this.f5553a + ", images=" + this.b + ", titles=" + this.c + ", videos=" + this.d + ", failedAssets=" + this.e + ')';
    }

    public final d a(Map<Integer, c.a> data, Map<Integer, c.b> images, Map<Integer, c.C0450c> titles, Map<Integer, c.d> videos, List<? extends Pair<? extends b.a, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> failedAssets) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(titles, "titles");
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(failedAssets, "failedAssets");
        return new d(data, images, titles, videos, failedAssets);
    }

    public final Uri b(int i) {
        c.b bVar = this.b.get(Integer.valueOf(i));
        if (bVar != null) {
            return bVar.d();
        }
        return null;
    }

    public final String c(int i) {
        c.C0450c c0450c = this.c.get(Integer.valueOf(i));
        if (c0450c != null) {
            return c0450c.d();
        }
        return null;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a d(int i) {
        c.d dVar = this.d.get(Integer.valueOf(i));
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public static /* synthetic */ d a(d dVar, Map map, Map map2, Map map3, Map map4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            map = dVar.f5553a;
        }
        if ((i & 2) != 0) {
            map2 = dVar.b;
        }
        if ((i & 4) != 0) {
            map3 = dVar.c;
        }
        if ((i & 8) != 0) {
            map4 = dVar.d;
        }
        if ((i & 16) != 0) {
            list = dVar.e;
        }
        List list2 = list;
        Map map5 = map3;
        return dVar.a(map, map2, map5, map4, list2);
    }

    public static final Map a(d dVar) {
        return MapsKt.plus(MapsKt.plus(MapsKt.plus(dVar.f5553a, dVar.b), dVar.c), dVar.d);
    }

    public final String a(int i) {
        c.a aVar = this.f5553a.get(Integer.valueOf(i));
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }
}
