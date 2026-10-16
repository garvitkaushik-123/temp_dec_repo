package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.internal.AbstractC3567g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: io.bidmachine.analytics.internal.e, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC3565e extends AbstractC3567g implements InterfaceC3566f {
    private InterfaceC3566f d;
    private final Object e = new Object();
    private final Map f = new LinkedHashMap();
    private b g;

    /* renamed from: io.bidmachine.analytics.internal.e$a */
    public enum a {
        UNSPECIFIED,
        BANNER,
        INTERSTITIAL,
        REWARDED,
        NATIVE
    }

    /* renamed from: io.bidmachine.analytics.internal.e$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f6695a;
        private final float b;
        private final String c;
        private final float d;

        public b(int i, float f, String str) {
            this.f6695a = i;
            this.b = f;
            this.c = str;
            this.d = f * 1000;
        }

        public final b a(int i, float f, String str) {
            return new b(i, f, str);
        }

        public final float b() {
            return this.d;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f6695a == bVar.f6695a && Float.compare(this.b, bVar.b) == 0 && Intrinsics.areEqual(this.c, bVar.c);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f6695a) * 31) + Float.hashCode(this.b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return super.toString();
        }

        public static /* synthetic */ b a(b bVar, int i, float f, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = bVar.f6695a;
            }
            if ((i2 & 2) != 0) {
                f = bVar.b;
            }
            if ((i2 & 4) != 0) {
                str = bVar.c;
            }
            return bVar.a(i, f, str);
        }

        public final int a() {
            return this.f6695a;
        }

        public /* synthetic */ b(int i, float f, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, f, str);
        }
    }

    public void a(AbstractC3567g.a aVar) {
        this.d = aVar.a();
    }

    public final b b() {
        b bVar;
        synchronized (this.e) {
            bVar = this.g;
        }
        return bVar;
    }

    public abstract b b(Map map);

    public abstract a c(Map map);

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public void f(Context context) {
        synchronized (this.e) {
            this.f.clear();
            this.g = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // io.bidmachine.analytics.internal.InterfaceC3566f
    public void a(Map map) {
        b b2;
        InterfaceC3566f interfaceC3566f = this.d;
        if (interfaceC3566f != null) {
            interfaceC3566f.a(map);
        }
        a c = c(map);
        if (c == null || (b2 = b(map)) == null) {
            return;
        }
        synchronized (this.e) {
            b bVar = this.g;
            this.g = b.a(b2, (bVar != null ? bVar.a() : 0) + 1, 0.0f, null, 6, null);
            b bVar2 = (b) this.f.get(c);
            this.f.put(c, bVar2 == null ? b.a(b2, 1, 0.0f, null, 6, null) : b.a(b2, bVar2.a() + 1, 0.0f, null, 6, null));
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // io.bidmachine.analytics.internal.InterfaceC3566f
    public void a(q0 q0Var) {
        InterfaceC3566f interfaceC3566f = this.d;
        if (interfaceC3566f != null) {
            interfaceC3566f.a(q0Var);
        }
    }

    public final b a(a aVar) {
        b bVar;
        synchronized (this.e) {
            bVar = (b) this.f.get(aVar);
        }
        return bVar;
    }
}
