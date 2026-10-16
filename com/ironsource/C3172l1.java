package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.ironsourceads.AdSize;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.l1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3172l1 {

    /* renamed from: a, reason: collision with root package name */
    public static final C3172l1 f3415a = new C3172l1();

    /* renamed from: com.ironsource.l1$a */
    public static final class a implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final IronSource.AD_UNIT f3416a;

        public a(IronSource.AD_UNIT value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f3416a = value;
        }

        private final IronSource.AD_UNIT a() {
            return this.f3416a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f3416a == ((a) obj).f3416a;
        }

        public int hashCode() {
            return this.f3416a.hashCode();
        }

        public String toString() {
            return "AdFormatEntity(value=" + this.f3416a + ")";
        }

        public final a a(IronSource.AD_UNIT value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new a(value);
        }

        public static /* synthetic */ a a(a aVar, IronSource.AD_UNIT ad_unit, int i, Object obj) {
            if ((i & 1) != 0) {
                ad_unit = aVar.f3416a;
            }
            return aVar.a(ad_unit);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put("adUnit", Integer.valueOf(C3051df.b(this.f3416a)));
        }
    }

    /* renamed from: com.ironsource.l1$b */
    public static final class b implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3417a;

        public b(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f3417a = value;
        }

        private final String a() {
            return this.f3417a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f3417a, ((b) obj).f3417a);
        }

        public int hashCode() {
            return this.f3417a.hashCode();
        }

        public String toString() {
            return "AdIdentifier(value=" + this.f3417a + ")";
        }

        public final b a(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new b(value);
        }

        public static /* synthetic */ b a(b bVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bVar.f3417a;
            }
            return bVar.a(str);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_IRONSOURCE_AD_OBJECT_ID, this.f3417a);
        }
    }

    /* renamed from: com.ironsource.l1$c */
    public static final class c implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final AdSize f3418a;

        public c(AdSize size) {
            Intrinsics.checkNotNullParameter(size, "size");
            this.f3418a = size;
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            int i;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String sizeDescription = this.f3418a.getSizeDescription();
            int hashCode = sizeDescription.hashCode();
            if (hashCode == -96588539) {
                if (sizeDescription.equals("MEDIUM_RECTANGLE")) {
                    i = 3;
                }
                i = 0;
            } else if (hashCode == 72205083) {
                if (sizeDescription.equals("LARGE")) {
                    i = 2;
                }
                i = 0;
            } else if (hashCode != 446888797) {
                if (hashCode == 1951953708 && sizeDescription.equals("BANNER")) {
                    i = 1;
                }
                i = 0;
            } else {
                if (sizeDescription.equals("LEADERBOARD")) {
                    i = 4;
                }
                i = 0;
            }
            bundle.put(com.ironsource.mediationsdk.l.h, Integer.valueOf(i));
        }
    }

    /* renamed from: com.ironsource.l1$d */
    public static final class d implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3419a;

        public d(String auctionId) {
            Intrinsics.checkNotNullParameter(auctionId, "auctionId");
            this.f3419a = auctionId;
        }

        private final String a() {
            return this.f3419a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.areEqual(this.f3419a, ((d) obj).f3419a);
        }

        public int hashCode() {
            return this.f3419a.hashCode();
        }

        public String toString() {
            return "AuctionId(auctionId=" + this.f3419a + ")";
        }

        public final d a(String auctionId) {
            Intrinsics.checkNotNullParameter(auctionId, "auctionId");
            return new d(auctionId);
        }

        public static /* synthetic */ d a(d dVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dVar.f3419a;
            }
            return dVar.a(str);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put("auctionId", this.f3419a);
        }
    }

    /* renamed from: com.ironsource.l1$e */
    public static final class e implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final int f3420a;

        public e(int i) {
            this.f3420a = i;
        }

        private final int a() {
            return this.f3420a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && this.f3420a == ((e) obj).f3420a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f3420a);
        }

        public String toString() {
            return "DemandOnly(value=" + this.f3420a + ")";
        }

        public final e a(int i) {
            return new e(i);
        }

        public static /* synthetic */ e a(e eVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = eVar.f3420a;
            }
            return eVar.a(i);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_DEMAND_ONLY, Integer.valueOf(this.f3420a));
        }
    }

    /* renamed from: com.ironsource.l1$f */
    public static final class f implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final long f3421a;

        public f(long j) {
            this.f3421a = j;
        }

        private final long a() {
            return this.f3421a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && this.f3421a == ((f) obj).f3421a;
        }

        public int hashCode() {
            return Long.hashCode(this.f3421a);
        }

        public String toString() {
            return "Duration(duration=" + this.f3421a + ")";
        }

        public final f a(long j) {
            return new f(j);
        }

        public static /* synthetic */ f a(f fVar, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = fVar.f3421a;
            }
            return fVar.a(j);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put("duration", Long.valueOf(this.f3421a));
        }
    }

    /* renamed from: com.ironsource.l1$g */
    public static final class g implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3422a;

        public g(String dynamicSourceId) {
            Intrinsics.checkNotNullParameter(dynamicSourceId, "dynamicSourceId");
            this.f3422a = dynamicSourceId;
        }

        private final String a() {
            return this.f3422a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && Intrinsics.areEqual(this.f3422a, ((g) obj).f3422a);
        }

        public int hashCode() {
            return this.f3422a.hashCode();
        }

        public String toString() {
            return "DynamicDemandSourceId(dynamicSourceId=" + this.f3422a + ")";
        }

        public final g a(String dynamicSourceId) {
            Intrinsics.checkNotNullParameter(dynamicSourceId, "dynamicSourceId");
            return new g(dynamicSourceId);
        }

        public static /* synthetic */ g a(g gVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gVar.f3422a;
            }
            return gVar.a(str);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put("dynamicDemandSource", this.f3422a);
        }
    }

    /* renamed from: com.ironsource.l1$h */
    public static final class h implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3423a;

        public h(String sourceId) {
            Intrinsics.checkNotNullParameter(sourceId, "sourceId");
            this.f3423a = sourceId;
        }

        private final String a() {
            return this.f3423a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && Intrinsics.areEqual(this.f3423a, ((h) obj).f3423a);
        }

        public int hashCode() {
            return this.f3423a.hashCode();
        }

        public String toString() {
            return "DynamicSourceId(sourceId=" + this.f3423a + ")";
        }

        public final h a(String sourceId) {
            Intrinsics.checkNotNullParameter(sourceId, "sourceId");
            return new h(sourceId);
        }

        public static /* synthetic */ h a(h hVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = hVar.f3423a;
            }
            return hVar.a(str);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put("dynamicDemandSource", this.f3423a);
        }
    }

    /* renamed from: com.ironsource.l1$i */
    public static final class i implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        public static final i f3424a = new i();

        private i() {
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
        }
    }

    /* renamed from: com.ironsource.l1$j */
    public static final class j implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final int f3425a;

        public j(int i) {
            this.f3425a = i;
        }

        private final int a() {
            return this.f3425a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof j) && this.f3425a == ((j) obj).f3425a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f3425a);
        }

        public String toString() {
            return "ErrorCode(code=" + this.f3425a + ")";
        }

        public final j a(int i) {
            return new j(i);
        }

        public static /* synthetic */ j a(j jVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = jVar.f3425a;
            }
            return jVar.a(i);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(this.f3425a));
        }
    }

    /* renamed from: com.ironsource.l1$k */
    public static final class k implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3426a;

        public k(String str) {
            this.f3426a = str;
        }

        private final String a() {
            return this.f3426a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k) && Intrinsics.areEqual(this.f3426a, ((k) obj).f3426a);
        }

        public int hashCode() {
            String str = this.f3426a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "ErrorReason(reason=" + this.f3426a + ")";
        }

        public final k a(String str) {
            return new k(str);
        }

        public static /* synthetic */ k a(k kVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = kVar.f3426a;
            }
            return kVar.a(str);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String str = this.f3426a;
            if (str == null || str.length() == 0) {
                return;
            }
            bundle.put("reason", this.f3426a);
        }
    }

    /* renamed from: com.ironsource.l1$l */
    public static final class l implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3427a;

        public l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f3427a = value;
        }

        private final String a() {
            return this.f3427a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof l) && Intrinsics.areEqual(this.f3427a, ((l) obj).f3427a);
        }

        public int hashCode() {
            return this.f3427a.hashCode();
        }

        public String toString() {
            return "Ext1(value=" + this.f3427a + ")";
        }

        public final l a(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new l(value);
        }

        public static /* synthetic */ l a(l lVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = lVar.f3427a;
            }
            return lVar.a(str);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_EXT1, this.f3427a);
        }
    }

    /* renamed from: com.ironsource.l1$m */
    public static final class m implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final JSONObject f3428a;

        public m(JSONObject jSONObject) {
            this.f3428a = jSONObject;
        }

        private final JSONObject a() {
            return this.f3428a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof m) && Intrinsics.areEqual(this.f3428a, ((m) obj).f3428a);
        }

        public int hashCode() {
            JSONObject jSONObject = this.f3428a;
            if (jSONObject == null) {
                return 0;
            }
            return jSONObject.hashCode();
        }

        public String toString() {
            return "GenericParams(genericParams=" + this.f3428a + ")";
        }

        public final m a(JSONObject jSONObject) {
            return new m(jSONObject);
        }

        public static /* synthetic */ m a(m mVar, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                jSONObject = mVar.f3428a;
            }
            return mVar.a(jSONObject);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            JSONObject jSONObject = this.f3428a;
            if (jSONObject == null) {
                return;
            }
            bundle.put("genericParams", jSONObject);
        }
    }

    /* renamed from: com.ironsource.l1$n */
    public static final class n implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final int f3429a;

        public n(int i) {
            this.f3429a = i;
        }

        private final int a() {
            return this.f3429a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof n) && this.f3429a == ((n) obj).f3429a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f3429a);
        }

        public String toString() {
            return "InstanceType(instanceType=" + this.f3429a + ")";
        }

        public final n a(int i) {
            return new n(i);
        }

        public static /* synthetic */ n a(n nVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = nVar.f3429a;
            }
            return nVar.a(i);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put("instanceType", Integer.valueOf(this.f3429a));
        }
    }

    /* renamed from: com.ironsource.l1$o */
    public static final class o implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final int f3430a;

        public o(int i) {
            this.f3430a = i;
        }

        private final int a() {
            return this.f3430a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof o) && this.f3430a == ((o) obj).f3430a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f3430a);
        }

        public String toString() {
            return "MultipleAdObjects(value=" + this.f3430a + ")";
        }

        public final o a(int i) {
            return new o(i);
        }

        public static /* synthetic */ o a(o oVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = oVar.f3430a;
            }
            return oVar.a(i);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put("isMultipleAdObjects", Integer.valueOf(this.f3430a));
        }
    }

    /* renamed from: com.ironsource.l1$p */
    public static final class p implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final int f3431a;

        public p(int i) {
            this.f3431a = i;
        }

        private final int a() {
            return this.f3431a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof p) && this.f3431a == ((p) obj).f3431a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f3431a);
        }

        public String toString() {
            return "OneFlow(value=" + this.f3431a + ")";
        }

        public final p a(int i) {
            return new p(i);
        }

        public static /* synthetic */ p a(p pVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = pVar.f3431a;
            }
            return pVar.a(i);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put("isOneFlow", Integer.valueOf(this.f3431a));
        }
    }

    /* renamed from: com.ironsource.l1$q */
    public static final class q implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3432a;

        public q(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f3432a = value;
        }

        private final String a() {
            return this.f3432a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof q) && Intrinsics.areEqual(this.f3432a, ((q) obj).f3432a);
        }

        public int hashCode() {
            return this.f3432a.hashCode();
        }

        public String toString() {
            return "Placement(value=" + this.f3432a + ")";
        }

        public final q a(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new q(value);
        }

        public static /* synthetic */ q a(q qVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = qVar.f3432a;
            }
            return qVar.a(str);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put("placement", this.f3432a);
        }
    }

    /* renamed from: com.ironsource.l1$r */
    public static final class r implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final int f3433a;

        public r(int i) {
            this.f3433a = i;
        }

        private final int a() {
            return this.f3433a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof r) && this.f3433a == ((r) obj).f3433a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f3433a);
        }

        public String toString() {
            return "Programmatic(programmatic=" + this.f3433a + ")";
        }

        public final r a(int i) {
            return new r(i);
        }

        public static /* synthetic */ r a(r rVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = rVar.f3433a;
            }
            return rVar.a(i);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(this.f3433a));
        }
    }

    /* renamed from: com.ironsource.l1$s */
    public static final class s implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3434a;

        public s(String sourceName) {
            Intrinsics.checkNotNullParameter(sourceName, "sourceName");
            this.f3434a = sourceName;
        }

        private final String a() {
            return this.f3434a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof s) && Intrinsics.areEqual(this.f3434a, ((s) obj).f3434a);
        }

        public int hashCode() {
            return this.f3434a.hashCode();
        }

        public String toString() {
            return "Provider(sourceName=" + this.f3434a + ")";
        }

        public final s a(String sourceName) {
            Intrinsics.checkNotNullParameter(sourceName, "sourceName");
            return new s(sourceName);
        }

        public static /* synthetic */ s a(s sVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sVar.f3434a;
            }
            return sVar.a(str);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_PROVIDER, this.f3434a);
        }
    }

    /* renamed from: com.ironsource.l1$t */
    public static final class t implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final int f3435a;

        public t(int i) {
            this.f3435a = i;
        }

        private final int a() {
            return this.f3435a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof t) && this.f3435a == ((t) obj).f3435a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f3435a);
        }

        public String toString() {
            return "RewardAmount(value=" + this.f3435a + ")";
        }

        public final t a(int i) {
            return new t(i);
        }

        public static /* synthetic */ t a(t tVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = tVar.f3435a;
            }
            return tVar.a(i);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(this.f3435a));
        }
    }

    /* renamed from: com.ironsource.l1$u */
    public static final class u implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3436a;

        public u(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f3436a = value;
        }

        private final String a() {
            return this.f3436a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof u) && Intrinsics.areEqual(this.f3436a, ((u) obj).f3436a);
        }

        public int hashCode() {
            return this.f3436a.hashCode();
        }

        public String toString() {
            return "RewardName(value=" + this.f3436a + ")";
        }

        public final u a(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new u(value);
        }

        public static /* synthetic */ u a(u uVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = uVar.f3436a;
            }
            return uVar.a(str);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_REWARD_NAME, this.f3436a);
        }
    }

    /* renamed from: com.ironsource.l1$v */
    public static final class v implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3437a;

        public v(String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            this.f3437a = version;
        }

        private final String a() {
            return this.f3437a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof v) && Intrinsics.areEqual(this.f3437a, ((v) obj).f3437a);
        }

        public int hashCode() {
            return this.f3437a.hashCode();
        }

        public String toString() {
            return "SdkVersion(version=" + this.f3437a + ")";
        }

        public final v a(String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            return new v(version);
        }

        public static /* synthetic */ v a(v vVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = vVar.f3437a;
            }
            return vVar.a(str);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, this.f3437a);
        }
    }

    /* renamed from: com.ironsource.l1$w */
    public static final class w implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final int f3438a;

        public w(int i) {
            this.f3438a = i;
        }

        private final int a() {
            return this.f3438a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof w) && this.f3438a == ((w) obj).f3438a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f3438a);
        }

        public String toString() {
            return "SessionDepth(sessionDepth=" + this.f3438a + ")";
        }

        public final w a(int i) {
            return new w(i);
        }

        public static /* synthetic */ w a(w wVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = wVar.f3438a;
            }
            return wVar.a(i);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put("sessionDepth", Integer.valueOf(this.f3438a));
        }
    }

    /* renamed from: com.ironsource.l1$x */
    public static final class x implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3439a;

        public x(String subProviderId) {
            Intrinsics.checkNotNullParameter(subProviderId, "subProviderId");
            this.f3439a = subProviderId;
        }

        private final String a() {
            return this.f3439a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof x) && Intrinsics.areEqual(this.f3439a, ((x) obj).f3439a);
        }

        public int hashCode() {
            return this.f3439a.hashCode();
        }

        public String toString() {
            return "SubProviderId(subProviderId=" + this.f3439a + ")";
        }

        public final x a(String subProviderId) {
            Intrinsics.checkNotNullParameter(subProviderId, "subProviderId");
            return new x(subProviderId);
        }

        public static /* synthetic */ x a(x xVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = xVar.f3439a;
            }
            return xVar.a(str);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put("spId", this.f3439a);
        }
    }

    /* renamed from: com.ironsource.l1$y */
    public static final class y implements InterfaceC3189m1 {

        /* renamed from: a, reason: collision with root package name */
        private final String f3440a;

        public y(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f3440a = value;
        }

        private final String a() {
            return this.f3440a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof y) && Intrinsics.areEqual(this.f3440a, ((y) obj).f3440a);
        }

        public int hashCode() {
            return this.f3440a.hashCode();
        }

        public String toString() {
            return "TransId(value=" + this.f3440a + ")";
        }

        public final y a(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new y(value);
        }

        public static /* synthetic */ y a(y yVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = yVar.f3440a;
            }
            return yVar.a(str);
        }

        @Override // com.ironsource.InterfaceC3189m1
        public void a(Map<String, Object> bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_TRANS_ID, this.f3440a);
        }
    }

    private C3172l1() {
    }
}
