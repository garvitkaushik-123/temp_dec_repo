package io.bidmachine.analytics.internal;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.bidmachine.analytics.internal.n, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3574n {

    /* renamed from: a, reason: collision with root package name */
    private final String f6723a;
    private final a b;
    private final a c;
    private final Lazy d = LazyKt.lazy(new c());
    private final Lazy e = LazyKt.lazy(new b());

    /* renamed from: io.bidmachine.analytics.internal.n$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List f6724a;
        private final List b;
        private final List c;

        public a(List list, List list2, List list3) {
            this.f6724a = list;
            this.b = list2;
            this.c = list3;
        }

        public final a a(List list, List list2, List list3) {
            return new a(list, list2, list3);
        }

        public final List b() {
            return this.c;
        }

        public final List c() {
            return this.b;
        }

        public final boolean d() {
            return this.f6724a.isEmpty() && this.b.isEmpty() && this.c.isEmpty();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f6724a, aVar.f6724a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.f6724a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return super.toString();
        }

        public static /* synthetic */ a a(a aVar, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = aVar.f6724a;
            }
            if ((i & 2) != 0) {
                list2 = aVar.b;
            }
            if ((i & 4) != 0) {
                list3 = aVar.c;
            }
            return aVar.a(list, list2, list3);
        }

        public final List a() {
            return this.f6724a;
        }

        public /* synthetic */ a(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3);
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.n$b */
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return C3574n.this.d().hashCode() + '_' + CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(C3574n.this.c().a().size()), Integer.valueOf(C3574n.this.c().c().size()), Integer.valueOf(C3574n.this.c().b().size()), Integer.valueOf(C3574n.this.e().a().size()), Integer.valueOf(C3574n.this.e().c().size()), Integer.valueOf(C3574n.this.e().b().size())}), "_", null, null, 0, null, null, 62, null);
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.n$c */
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            JSONObject jSONObject = new JSONObject();
            C3574n c3574n = C3574n.this;
            jSONObject.put("ver", c3574n.a());
            jSONObject.put("iaa", new JSONArray((Collection) c3574n.c().a()));
            jSONObject.put("iah", new JSONArray((Collection) c3574n.c().c()));
            jSONObject.put("iad", new JSONArray((Collection) c3574n.c().b()));
            jSONObject.put("sua", new JSONArray((Collection) c3574n.e().a()));
            jSONObject.put("suh", new JSONArray((Collection) c3574n.e().c()));
            jSONObject.put("sud", new JSONArray((Collection) c3574n.e().b()));
            return jSONObject.toString();
        }
    }

    public C3574n(String str, a aVar, a aVar2) {
        this.f6723a = str;
        this.b = aVar;
        this.c = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d() {
        return (String) this.d.getValue();
    }

    public final String b() {
        return (String) this.e.getValue();
    }

    public final a c() {
        return this.b;
    }

    public final a e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3574n)) {
            return false;
        }
        C3574n c3574n = (C3574n) obj;
        return Intrinsics.areEqual(this.f6723a, c3574n.f6723a) && Intrinsics.areEqual(this.b, c3574n.b) && Intrinsics.areEqual(this.c, c3574n.c);
    }

    public final boolean f() {
        return this.b.d() && this.c.d();
    }

    public int hashCode() {
        return (((this.f6723a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return d();
    }

    public final String a() {
        return this.f6723a;
    }
}
