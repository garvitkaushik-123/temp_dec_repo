package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.common_adapter_internal.ScreenData;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.u;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.A;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.AbstractC3491b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.B;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.C3490a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.protobuf.EventTypeExtended;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpRequestTimeoutException;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes6.dex */
public final class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d {
    public static final c i = new c(null);
    public static final long j = 5000;
    public static final int k = 4;

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i f6059a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l d;
    public final u e;
    public final HttpClient f;
    public final q g;
    public final String h;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> f6060a;
        public final List<String> b;
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> impressions, List<String> errorUrls, List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> creativesPerWrapper) {
            Intrinsics.checkNotNullParameter(impressions, "impressions");
            Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
            Intrinsics.checkNotNullParameter(creativesPerWrapper, "creativesPerWrapper");
            this.f6060a = impressions;
            this.b = errorUrls;
            this.c = creativesPerWrapper;
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> a() {
            return this.f6060a;
        }

        public final List<String> b() {
            return this.b;
        }

        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> c() {
            return this.c;
        }

        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> d() {
            return this.c;
        }

        public final List<String> e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f6060a, aVar.f6060a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> f() {
            return this.f6060a;
        }

        public int hashCode() {
            return (((this.f6060a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "AggregatedWrapperChainAdData(impressions=" + this.f6060a + ", errorUrls=" + this.b + ", creativesPerWrapper=" + this.c + ')';
        }

        public final a a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> impressions, List<String> errorUrls, List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> creativesPerWrapper) {
            Intrinsics.checkNotNullParameter(impressions, "impressions");
            Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
            Intrinsics.checkNotNullParameter(creativesPerWrapper, "creativesPerWrapper");
            return new a(impressions, errorUrls, creativesPerWrapper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ a a(a aVar, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = aVar.f6060a;
            }
            if ((i & 2) != 0) {
                list2 = aVar.b;
            }
            if ((i & 4) != 0) {
                list3 = aVar.c;
            }
            return aVar.a(list, list2, list3);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> f6061a;
        public final A b;
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>> c;
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>> d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> linearTrackingList, A a2, List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>> iconsPerWrapper, List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>> companionsPerWrapper) {
            Intrinsics.checkNotNullParameter(linearTrackingList, "linearTrackingList");
            Intrinsics.checkNotNullParameter(iconsPerWrapper, "iconsPerWrapper");
            Intrinsics.checkNotNullParameter(companionsPerWrapper, "companionsPerWrapper");
            this.f6061a = linearTrackingList;
            this.b = a2;
            this.c = iconsPerWrapper;
            this.d = companionsPerWrapper;
        }

        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>> a() {
            return this.d;
        }

        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>> b() {
            return this.c;
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> c() {
            return this.f6061a;
        }

        public final A d() {
            return this.b;
        }
    }

    public static final class c {
        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public c() {
        }

        public final boolean a(String str) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return Intrinsics.areEqual(lowerCase, "video/mp4") || Intrinsics.areEqual(lowerCase, "video/3gpp") || Intrinsics.areEqual(lowerCase, "video/webm");
        }

        public final List<String> a(Map<v, ? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>> map, v vVar) {
            List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list = map.get(vVar);
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u) it.next()).f());
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g> a(Map<v, ? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>> map) {
            List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list = map.get(v.n);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u uVar : list) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g gVar = uVar.e() == null ? null : new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g(uVar.f(), uVar.e());
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }

        public final List<String> a(A a2) {
            List<z> b;
            if (a2 != null && (b = a2.b()) != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(b, 10));
                Iterator<T> it = b.iterator();
                while (it.hasNext()) {
                    arrayList.add(((z) it.next()).b());
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar) {
            String g = gVar.g();
            return !(g == null || StringsKt.isBlank(g));
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar) {
            String c = eVar.c();
            return !(c == null || StringsKt.isBlank(c));
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q qVar) {
            String a2 = qVar.a();
            return !(a2 == null || StringsKt.isBlank(a2));
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l lVar) {
            String a2 = lVar.a();
            return !(a2 == null || StringsKt.isBlank(a2));
        }

        public final <T> Set<T> a(Set<? extends T> set, T t) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (set != null) {
                CollectionsKt.addAll(linkedHashSet, set);
            }
            if (t != null) {
                linkedHashSet.add(t);
            }
            return linkedHashSet;
        }

        public final <T> List<T> a(List<? extends T> list, List<? extends T> list2) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                CollectionsKt.addAll(arrayList, list);
            }
            if (list2 != null) {
                CollectionsKt.addAll(arrayList, list2);
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> List<T> a(List<? extends T> list, T t) {
            List<T> a2;
            return (t == null || (a2 = e.i.a((List) list, (List) CollectionsKt.listOf(t))) == null) ? list == 0 ? CollectionsKt.emptyList() : list : a2;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.h a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list, A a2) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                v d = ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u) obj).d();
                Object obj2 = linkedHashMap.get(d);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(d, obj2);
                }
                ((List) obj2).add(obj);
            }
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.h(a(a2), a(linkedHashMap, v.f6159a), a(linkedHashMap, v.b), a(linkedHashMap, v.c), a(linkedHashMap, v.d), a(linkedHashMap, v.e), a(linkedHashMap, v.f), a(linkedHashMap, v.g), a(linkedHashMap, v.h), a(linkedHashMap, v.i), a(linkedHashMap, v.k), a(linkedHashMap, v.j), a(linkedHashMap, v.m), a(linkedHashMap, v.l), a(linkedHashMap));
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f6062a;
        public final Set<String> b;
        public final boolean c;
        public final a d;

        public d(int i, Set<String> usedVastAdTagUrls, boolean z, a aggregatedWrapperChainData) {
            Intrinsics.checkNotNullParameter(usedVastAdTagUrls, "usedVastAdTagUrls");
            Intrinsics.checkNotNullParameter(aggregatedWrapperChainData, "aggregatedWrapperChainData");
            this.f6062a = i;
            this.b = usedVastAdTagUrls;
            this.c = z;
            this.d = aggregatedWrapperChainData;
        }

        public final int a() {
            return this.f6062a;
        }

        public final Set<String> b() {
            return this.b;
        }

        public final boolean c() {
            return this.c;
        }

        public final a d() {
            return this.d;
        }

        public final a e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f6062a == dVar.f6062a && Intrinsics.areEqual(this.b, dVar.b) && this.c == dVar.c && Intrinsics.areEqual(this.d, dVar.d);
        }

        public final boolean f() {
            return this.c;
        }

        public final Set<String> g() {
            return this.b;
        }

        public final int h() {
            return this.f6062a;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f6062a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "WrapperChainParams(wrapperDepth=" + this.f6062a + ", usedVastAdTagUrls=" + this.b + ", followAdditionalWrappers=" + this.c + ", aggregatedWrapperChainData=" + this.d + ')';
        }

        public final d a(int i, Set<String> usedVastAdTagUrls, boolean z, a aggregatedWrapperChainData) {
            Intrinsics.checkNotNullParameter(usedVastAdTagUrls, "usedVastAdTagUrls");
            Intrinsics.checkNotNullParameter(aggregatedWrapperChainData, "aggregatedWrapperChainData");
            return new d(i, usedVastAdTagUrls, z, aggregatedWrapperChainData);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ d a(d dVar, int i, Set set, boolean z, a aVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = dVar.f6062a;
            }
            if ((i2 & 2) != 0) {
                set = dVar.b;
            }
            if ((i2 & 4) != 0) {
                z = dVar.c;
            }
            if ((i2 & 8) != 0) {
                aVar = dVar.d;
            }
            return dVar.a(i, set, z, aVar);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 0}, l = {152, 163}, m = "invoke", n = {"this", "mtid", "isStreamingEnabled"}, s = {"L$0", "L$1", "Z$0"})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$e, reason: collision with other inner class name */
    public static final class C0528e extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f6063a;
        public Object b;
        public boolean c;
        public /* synthetic */ Object d;
        public int f;

        public C0528e(Continuation<? super C0528e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return e.this.a((String) null, (String) null, false, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$invoke$renderAdResult$1", f = "VastAdLoader.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6064a;
        public final /* synthetic */ w c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(w wVar, boolean z, String str, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = wVar;
            this.d = z;
            this.e = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new f(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6064a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            e eVar = e.this;
            w wVar = this.c;
            double b = eVar.b();
            ScreenData invoke = e.this.g.invoke();
            boolean z = this.d;
            String str = this.e;
            this.f6064a = 1;
            Object a2 = eVar.a(wVar, (d) null, b, invoke, z, str, this);
            return a2 == coroutine_suspended ? coroutine_suspended : a2;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 1, 1, 2, 2}, l = {EventTypeExtended.EVENT_TYPE_EXTENDED_NURL_VALUE, 356, 367}, m = "loadAndParseWrapperVastDocument", n = {"this", "vastErrorUrls", "this", "vastErrorUrls", "this", "vastErrorUrls"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    public static final class g extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f6065a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.a((B) null, (List<String>) null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {418}, m = "tryLoadInLineRenderAd", n = {"this", "inline", "aggregatedWrapperChainData", "screenData", "mtid", "aggregatedErrorUrls", "preparedWrapperDataForInline$delegate", "renderLinearNullable", "renderCompanion", "renderLinearError", "creative", "targetLinearFileSizeInMegabytes", "isStreamingEnabled"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "D$0", "Z$0"})
    public static final class h extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f6066a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;
        public Object k;
        public Object l;
        public double m;
        public boolean n;
        public /* synthetic */ Object o;
        public int q;

        public h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.o = obj;
            this.q |= Integer.MIN_VALUE;
            return e.this.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o) null, (a) null, 0.0d, (ScreenData) null, false, (String) null, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    public static final class i implements Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f6067a;
        public final /* synthetic */ e b;
        public final /* synthetic */ d c;
        public final /* synthetic */ double d;
        public final /* synthetic */ ScreenData e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Ref.ObjectRef h;

        public static final class a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f6068a;
            public final /* synthetic */ e b;
            public final /* synthetic */ d c;
            public final /* synthetic */ double d;
            public final /* synthetic */ ScreenData e;
            public final /* synthetic */ boolean f;
            public final /* synthetic */ String g;
            public final /* synthetic */ Ref.ObjectRef h;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$tryLoadVastRenderAd$$inlined$mapNotNull$1$2", f = "VastAdLoader.kt", i = {0, 0, 1, 1}, l = {54, 65, 86}, m = "emit", n = {"this", "$this$mapNotNull_u24lambda_u246", "this", "$this$mapNotNull_u24lambda_u246"}, s = {"L$0", "L$1", "L$0", "L$1"})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$i$a$a, reason: collision with other inner class name */
            public static final class C0529a extends ContinuationImpl {

                /* renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f6069a;
                public int b;
                public Object c;
                public Object e;

                public C0529a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f6069a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(FlowCollector flowCollector, e eVar, d dVar, double d, ScreenData screenData, boolean z, String str, Ref.ObjectRef objectRef) {
                this.f6068a = flowCollector;
                this.b = eVar;
                this.c = dVar;
                this.d = d;
                this.e = screenData;
                this.f = z;
                this.g = str;
                this.h = objectRef;
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x0148, code lost:
            
                if (r3.emit(r1, r11) == r2) goto L45;
             */
            /* JADX WARN: Removed duplicated region for block: B:21:0x00fe  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x013e  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0130  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x0057  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Object obj, Continuation continuation) {
                C0529a c0529a;
                int i;
                FlowCollector flowCollector;
                a<T> aVar;
                com.moloco.sdk.internal.v vVar;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar2;
                if (continuation instanceof C0529a) {
                    c0529a = (C0529a) continuation;
                    int i2 = c0529a.b;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        c0529a.b = i2 - Integer.MIN_VALUE;
                        C0529a c0529a2 = c0529a;
                        Object obj2 = c0529a2.f6069a;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = c0529a2.b;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector2 = this.f6068a;
                            AbstractC3491b a2 = ((C3490a) obj).a();
                            if (a2 instanceof AbstractC3491b.C0532b) {
                                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.b.h, "Found Wrapper child element, trying load wrapper render Ad", null, false, 12, null);
                                e eVar = this.b;
                                B a3 = ((AbstractC3491b.C0532b) a2).a();
                                d dVar = this.c;
                                double d = this.d;
                                ScreenData screenData = this.e;
                                boolean z = this.f;
                                String str = this.g;
                                c0529a2.c = this;
                                c0529a2.e = flowCollector2;
                                c0529a2.b = 1;
                                Object a4 = eVar.a(a3, dVar, d, screenData, z, str, c0529a2);
                                if (a4 != coroutine_suspended) {
                                    flowCollector = flowCollector2;
                                    obj2 = a4;
                                    aVar = this;
                                    vVar = (com.moloco.sdk.internal.v) obj2;
                                }
                            } else {
                                if (!(a2 instanceof AbstractC3491b.a)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.b.h, "Found InLine child element, trying load render Ad", null, false, 12, null);
                                e eVar2 = this.b;
                                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o a5 = ((AbstractC3491b.a) a2).a();
                                d dVar2 = this.c;
                                a e = dVar2 != null ? dVar2.e() : null;
                                double d2 = this.d;
                                ScreenData screenData2 = this.e;
                                boolean z2 = this.f;
                                String str2 = this.g;
                                c0529a2.c = this;
                                c0529a2.e = flowCollector2;
                                c0529a2.b = 2;
                                Object a6 = eVar2.a(a5, e, d2, screenData2, z2, str2, c0529a2);
                                if (a6 != coroutine_suspended) {
                                    flowCollector = flowCollector2;
                                    obj2 = a6;
                                    aVar = this;
                                    vVar = (com.moloco.sdk.internal.v) obj2;
                                }
                            }
                            return coroutine_suspended;
                        }
                        if (i == 1) {
                            flowCollector = (FlowCollector) c0529a2.e;
                            aVar = (a) c0529a2.c;
                            ResultKt.throwOnFailure(obj2);
                            vVar = (com.moloco.sdk.internal.v) obj2;
                        } else {
                            if (i != 2) {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                                return Unit.INSTANCE;
                            }
                            flowCollector = (FlowCollector) c0529a2.e;
                            aVar = (a) c0529a2.c;
                            ResultKt.throwOnFailure(obj2);
                            vVar = (com.moloco.sdk.internal.v) obj2;
                        }
                        if (!(vVar instanceof v.a)) {
                            v.a aVar3 = (v.a) vVar;
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, aVar.b.h, "Failed to load the ad with error: " + aVar3.a(), null, false, 12, null);
                            aVar.h.element = (T) aVar3.a();
                            aVar2 = null;
                        } else {
                            if (!(vVar instanceof v.b)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            aVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((v.b) vVar).a();
                        }
                        if (aVar2 != null) {
                            c0529a2.c = null;
                            c0529a2.e = null;
                            c0529a2.b = 3;
                        }
                        return Unit.INSTANCE;
                    }
                }
                c0529a = new C0529a(continuation);
                C0529a c0529a22 = c0529a;
                Object obj22 = c0529a22.f6069a;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0529a22.b;
                if (i != 0) {
                }
                if (!(vVar instanceof v.a)) {
                }
                if (aVar2 != null) {
                }
                return Unit.INSTANCE;
            }
        }

        public i(Flow flow, e eVar, d dVar, double d, ScreenData screenData, boolean z, String str, Ref.ObjectRef objectRef) {
            this.f6067a = flow;
            this.b = eVar;
            this.c = dVar;
            this.d = d;
            this.e = screenData;
            this.f = z;
            this.g = str;
            this.h = objectRef;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a> flowCollector, Continuation continuation) {
            Object collect = this.f6067a.collect(new a(flowCollector, this.b, this.c, this.d, this.e, this.f, this.g, this.h), continuation);
            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
        }
    }

    public static final class j<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(((C3490a) t).c(), ((C3490a) t2).c());
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0}, l = {280}, m = "tryLoadVastRenderAd", n = {"this", "adLoadError"}, s = {"L$0", "L$1"})
    public static final class k extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f6070a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public k(Continuation<? super k> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.a((w) null, (d) null, 0.0d, (ScreenData) null, false, (String) null, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY_VALUE, 328}, m = "tryLoadWrapperRenderAd", n = {"this", "wrapper", "wrapperChainParams", "screenData", "mtid", "aggregatedErrorUrls", "targetLinearFileSizeInMegabytes", "isStreamingEnabled", "currentWrapperDepth"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "D$0", "Z$0", "I$0"})
    public static final class l extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f6071a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public double g;
        public boolean h;
        public int i;
        public /* synthetic */ Object j;
        public int l;

        public l(Continuation<? super l> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.l |= Integer.MIN_VALUE;
            return e.this.a((B) null, (d) null, 0.0d, (ScreenData) null, false, (String) null, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    public static final class m implements Flow<Pair<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q, ? extends File>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f6072a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Ref.ObjectRef e;

        public static final class a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f6073a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ e c;
            public final /* synthetic */ String d;
            public final /* synthetic */ Ref.ObjectRef e;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$tryPrepareInLineRenderLinear$$inlined$mapNotNull$1$2", f = "VastAdLoader.kt", i = {0, 0, 0, 1, 1, 1}, l = {53, 71, 82}, m = "emit", n = {"this", "$this$mapNotNull_u24lambda_u246", "vastMediaFile", "this", "$this$mapNotNull_u24lambda_u246", "vastMediaFile"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$m$a$a, reason: collision with other inner class name */
            public static final class C0530a extends ContinuationImpl {

                /* renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f6074a;
                public int b;
                public Object c;
                public Object e;
                public Object f;

                public C0530a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f6074a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(FlowCollector flowCollector, boolean z, e eVar, String str, Ref.ObjectRef objectRef) {
                this.f6073a = flowCollector;
                this.b = z;
                this.c = eVar;
                this.d = str;
                this.e = objectRef;
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x0103, code lost:
            
                if (r2.emit(r9, r0) == r1) goto L49;
             */
            /* JADX WARN: Removed duplicated region for block: B:20:0x00db  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x00f7  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00e6  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0093  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x005a  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Object obj, Continuation continuation) {
                C0530a c0530a;
                int i;
                FlowCollector flowCollector;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q qVar;
                a<T> aVar;
                a<T> aVar2;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar;
                Pair pair;
                i.a aVar3;
                if (continuation instanceof C0530a) {
                    c0530a = (C0530a) continuation;
                    int i2 = c0530a.b;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        c0530a.b = i2 - Integer.MIN_VALUE;
                        Object obj2 = c0530a.f6074a;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = c0530a.b;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj2);
                            flowCollector = this.f6073a;
                            qVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q) obj;
                            if (this.b) {
                                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i iVar = this.c.c;
                                String g = qVar.g();
                                String str = this.d;
                                c0530a.c = this;
                                c0530a.e = flowCollector;
                                c0530a.f = qVar;
                                c0530a.b = 1;
                                obj2 = iVar.a(g, str, c0530a);
                                if (obj2 != coroutine_suspended) {
                                    aVar2 = this;
                                    cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) obj2;
                                    if (!(cVar instanceof c.a)) {
                                    }
                                    if (pair != null) {
                                    }
                                }
                            } else {
                                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i iVar2 = this.c.c;
                                String g2 = qVar.g();
                                c0530a.c = this;
                                c0530a.e = flowCollector;
                                c0530a.f = qVar;
                                c0530a.b = 2;
                                obj2 = iVar2.a(g2, c0530a);
                                if (obj2 != coroutine_suspended) {
                                    aVar = this;
                                    aVar3 = (i.a) obj2;
                                    if (!(aVar3 instanceof i.a.b)) {
                                    }
                                }
                            }
                            return coroutine_suspended;
                        }
                        if (i == 1) {
                            qVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q) c0530a.f;
                            flowCollector = (FlowCollector) c0530a.e;
                            aVar2 = (a) c0530a.c;
                            ResultKt.throwOnFailure(obj2);
                            cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) obj2;
                            if (!(cVar instanceof c.a)) {
                                pair = TuplesKt.to(qVar, ((c.a) cVar).b());
                            } else if (cVar instanceof c.C0482c) {
                                pair = TuplesKt.to(qVar, ((c.C0482c) cVar).c());
                            } else {
                                if (!(cVar instanceof c.b)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                aVar2.e.element = (T) com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.h.a(((c.b) cVar).b());
                                pair = null;
                            }
                            if (pair != null) {
                            }
                        } else if (i == 2) {
                            qVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q) c0530a.f;
                            flowCollector = (FlowCollector) c0530a.e;
                            aVar = (a) c0530a.c;
                            ResultKt.throwOnFailure(obj2);
                            aVar3 = (i.a) obj2;
                            if (!(aVar3 instanceof i.a.b)) {
                                pair = TuplesKt.to(qVar, ((i.a.b) aVar3).a());
                                if (pair != null) {
                                    c0530a.c = null;
                                    c0530a.e = null;
                                    c0530a.f = null;
                                    c0530a.b = 3;
                                }
                            } else {
                                if (!(aVar3 instanceof i.a.AbstractC0479a)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                aVar.e.element = (T) com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.h.a((i.a.AbstractC0479a) aVar3);
                                pair = null;
                                if (pair != null) {
                                }
                            }
                        } else {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
                c0530a = new C0530a(continuation);
                Object obj22 = c0530a.f6074a;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0530a.b;
                if (i != 0) {
                }
                return Unit.INSTANCE;
            }
        }

        public m(Flow flow, boolean z, e eVar, String str, Ref.ObjectRef objectRef) {
            this.f6072a = flow;
            this.b = z;
            this.c = eVar;
            this.d = str;
            this.e = objectRef;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super Pair<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q, ? extends File>> flowCollector, Continuation continuation) {
            Object collect = this.f6072a.collect(new a(flowCollector, this.b, this.c, this.d, this.e), continuation);
            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 0, 0, 0}, l = {565}, m = "tryPrepareInLineRenderLinear", n = {"this", "linear", "wrapperLinearTrackingList", "wrapperVideoClicks", "vastError"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class n extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f6075a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public int h;

        public n(Continuation<? super n> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return e.this.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p) null, (List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>) null, (A) null, (List<String>) null, 0.0d, (Long) null, (ScreenData) null, false, (String) null, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0}, l = {95}, m = "waitForAdLoadToStart-8Mi8wO0", n = {"this", "ad"}, s = {"L$0", "L$1"})
    public static final class o extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f6076a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public o(Continuation<? super o> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) null, 0L, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$waitForAdLoadToStart$streamStatus$1", f = "VastAdLoader.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    public static final class p extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6077a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a c;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$waitForAdLoadToStart$streamStatus$1$1", f = "VastAdLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c, Continuation<? super Boolean>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f6078a;
            public /* synthetic */ Object b;
            public final /* synthetic */ e c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.c = eVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar, Continuation<? super Boolean> continuation) {
                return ((a) create(cVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.c, continuation);
                aVar.b = obj;
                return aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6078a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) this.b;
                if (cVar instanceof c.C0482c) {
                    c.C0482c c0482c = (c.C0482c) cVar;
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, this.c.h, "Stream status: " + c0482c.d().c() + '/' + c0482c.d().d() + " bytes downloaded", null, false, 12, null);
                }
                return Boxing.boxBoolean((cVar instanceof c.a) || (cVar instanceof c.b));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, Continuation<? super p> continuation) {
            super(2, continuation);
            this.c = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> continuation) {
            return ((p) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new p(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6077a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> b = e.this.c.b(this.c.j().l());
            a aVar = new a(e.this, null);
            this.f6077a = 1;
            Object firstOrNull = FlowKt.firstOrNull(b, aVar, this);
            return firstOrNull == coroutine_suspended ? coroutine_suspended : firstOrNull;
        }
    }

    public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i parseVast, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l mediaConfig, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i mediaCacheRepository, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l vastTracker, u connectivityService, HttpClient httpClient, q screenService) {
        Intrinsics.checkNotNullParameter(parseVast, "parseVast");
        Intrinsics.checkNotNullParameter(mediaConfig, "mediaConfig");
        Intrinsics.checkNotNullParameter(mediaCacheRepository, "mediaCacheRepository");
        Intrinsics.checkNotNullParameter(vastTracker, "vastTracker");
        Intrinsics.checkNotNullParameter(connectivityService, "connectivityService");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(screenService, "screenService");
        this.f6059a = parseVast;
        this.b = mediaConfig;
        this.c = mediaCacheRepository;
        this.d = vastTracker;
        this.e = connectivityService;
        this.f = httpClient;
        this.g = screenService;
        this.h = "VastAdLoaderImpl";
    }

    public final double a(long j2, int i2) {
        return (j2 * 8) / (i2 * 1000);
    }

    public final double b() {
        return !this.e.b() ? 10.0d : 2.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, long j2, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
        o oVar;
        int i2;
        e eVar;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar;
        if (continuation instanceof o) {
            oVar = (o) continuation;
            int i3 = oVar.e;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                oVar.e = i3 - Integer.MIN_VALUE;
                Object obj = oVar.c;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = oVar.e;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, this.h, "Waiting for " + ((Object) Duration.m11616toStringimpl(j2)) + " to load the vast media file: " + this.c, null, false, 12, null);
                    p pVar = new p(aVar, null);
                    oVar.f6076a = this;
                    oVar.b = aVar;
                    oVar.e = 1;
                    obj = TimeoutKt.m11744withTimeoutOrNullKLykuaI(j2, pVar, oVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eVar = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) oVar.b;
                    eVar = (e) oVar.f6076a;
                    ResultKt.throwOnFailure(obj);
                }
                cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) obj;
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, eVar.h, "Either timeout occurred or media file streaming had terminal status", null, false, 12, null);
                MolocoLogger.info$default(molocoLogger, eVar.h, "Stream status: " + cVar + " on timeout", null, false, 12, null);
                if (cVar != null) {
                    File j3 = aVar.j().j();
                    if (j3.exists() && j3.length() != 0) {
                        MolocoLogger.info$default(molocoLogger, eVar.h, "Local vast media resource exists and has some content. Checking for bitrate information", null, false, 12, null);
                        if (aVar.j().k() != null) {
                            MolocoLogger.info$default(molocoLogger, eVar.h, "Checking for playability of VAST ad with bitrate: " + aVar.j().k(), null, false, 12, null);
                            double a2 = eVar.a(j3.length(), aVar.j().k().intValue());
                            MolocoLogger.info$default(molocoLogger, eVar.h, "VAST ad has playable duration: " + a2 + " seconds", null, false, 12, null);
                            if (a2 < eVar.b.g()) {
                                MolocoLogger.error$default(molocoLogger, eVar.h, "VAST does not have enough playable duration, so failing ", null, false, 12, null);
                                return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.y);
                            }
                        } else {
                            MolocoLogger.info$default(molocoLogger, eVar.h, "VAST ad playable duration cannot be determined due to no bitrate information", null, false, 12, null);
                            return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.z);
                        }
                    } else {
                        MolocoLogger.error$default(molocoLogger, eVar.h, j3.getAbsolutePath() + " does not exist or is empty", null, false, 12, null);
                        MolocoLogger.error$default(molocoLogger, eVar.h, "Failed to start streaming media file, reporting timeout error", null, false, 12, null);
                        return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.x);
                    }
                } else {
                    if (cVar instanceof c.a) {
                        MolocoLogger.info$default(molocoLogger, eVar.h, "Streamed entire file successfully", null, false, 12, null);
                        return new v.b(aVar);
                    }
                    if (cVar instanceof c.b) {
                        MolocoLogger.info$default(molocoLogger, eVar.h, "Failed to stream file", null, false, 12, null);
                        return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.h.a(((c.b) cVar).b()));
                    }
                }
                MolocoLogger.info$default(molocoLogger, eVar.h, "Media file partially exists and ready for streaming", null, false, 12, null);
                return new v.b(aVar);
            }
        }
        oVar = new o(continuation);
        Object obj2 = oVar.c;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = oVar.e;
        if (i2 != 0) {
        }
        cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) obj2;
        MolocoLogger molocoLogger2 = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger2, eVar.h, "Either timeout occurred or media file streaming had terminal status", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger2, eVar.h, "Stream status: " + cVar + " on timeout", null, false, 12, null);
        if (cVar != null) {
        }
        MolocoLogger.info$default(molocoLogger2, eVar.h, "Media file partially exists and ready for streaming", null, false, 12, null);
        return new v.b(aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00be, code lost:
    
        if (r1 == r3) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(String str, String str2, boolean z, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
        C0528e c0528e;
        int i2;
        String str3;
        boolean z2;
        e eVar;
        com.moloco.sdk.internal.v vVar;
        if (continuation instanceof C0528e) {
            c0528e = (C0528e) continuation;
            int i3 = c0528e.f;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c0528e.f = i3 - Integer.MIN_VALUE;
                Object obj = c0528e.d;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = c0528e.f;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i iVar = this.f6059a;
                    c0528e.f6063a = this;
                    c0528e.b = str2;
                    c0528e.c = z;
                    c0528e.f = 1;
                    obj = iVar.a(str, c0528e);
                    if (obj != coroutine_suspended) {
                        str3 = str2;
                        z2 = z;
                        eVar = this;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.internal.v vVar2 = (com.moloco.sdk.internal.v) obj;
                    if (vVar2 instanceof v.a) {
                        return new v.a(((v.a) vVar2).a());
                    }
                    if (vVar2 instanceof v.b) {
                        return new v.b(((v.b) vVar2).a());
                    }
                    throw new NoWhenBranchMatchedException();
                }
                boolean z3 = c0528e.c;
                String str4 = (String) c0528e.b;
                eVar = (e) c0528e.f6063a;
                ResultKt.throwOnFailure(obj);
                z2 = z3;
                str3 = str4;
                vVar = (com.moloco.sdk.internal.v) obj;
                if (!(vVar instanceof v.a)) {
                    v.a aVar = (v.a) vVar;
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar.h, "Failed to parse vast XML: " + aVar.a(), null, false, 12, null);
                    return new v.a(aVar.a());
                }
                if (vVar instanceof v.b) {
                    w wVar = (w) ((v.b) vVar).a();
                    CoroutineContext coroutineContext = com.moloco.sdk.internal.scheduling.b.a().getDefault();
                    f fVar = eVar.new f(wVar, z2, str3, null);
                    c0528e.f6063a = null;
                    c0528e.b = null;
                    c0528e.f = 2;
                    obj = BuildersKt.withContext(coroutineContext, fVar, c0528e);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        c0528e = new C0528e(continuation);
        Object obj2 = c0528e.d;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = c0528e.f;
        if (i2 != 0) {
        }
        vVar = (com.moloco.sdk.internal.v) obj2;
        if (!(vVar instanceof v.a)) {
        }
    }

    public static /* synthetic */ void a(e eVar, List list, x xVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            xVar = null;
        }
        eVar.a((List<String>) list, xVar);
    }

    public final void a(List<String> list, x xVar) {
        l.a.a(this.d, list, xVar, null, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(w wVar, d dVar, double d2, ScreenData screenData, boolean z, String str, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
        k kVar;
        int i2;
        e eVar;
        Ref.ObjectRef objectRef;
        a e;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar;
        if (continuation instanceof k) {
            kVar = (k) continuation;
            int i3 = kVar.e;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                kVar.e = i3 - Integer.MIN_VALUE;
                k kVar2 = kVar;
                Object obj = kVar2.c;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = kVar2.e;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, this.h, "Loading vast ad with wrapperChainParams: " + dVar, null, false, 12, null);
                    List<String> a2 = i.a((List<? extends List<String>>) ((dVar == null || (e = dVar.e()) == null) ? null : e.e()), (List<String>) wVar.b());
                    if (wVar.a().isEmpty()) {
                        a(a2, dVar != null ? x.f : null);
                        return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.d);
                    }
                    d a3 = dVar != null ? d.a(dVar, 0, null, false, a.a(dVar.e(), null, a2, null, 5, null), 7, null) : null;
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.F;
                    List<C3490a> a4 = wVar.a();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : a4) {
                        C3490a c3490a = (C3490a) obj2;
                        if (c3490a.c() == null || new IntRange(0, 1).contains(c3490a.c().intValue())) {
                            arrayList.add(obj2);
                        }
                    }
                    i iVar = new i(FlowKt.cancellable(FlowKt.asFlow(CollectionsKt.sortedWith(arrayList, new j()))), this, a3, d2, screenData, z, str, objectRef2);
                    kVar2.f6070a = this;
                    kVar2.b = objectRef2;
                    kVar2.e = 1;
                    obj = FlowKt.firstOrNull(iVar, kVar2);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eVar = this;
                    objectRef = objectRef2;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) kVar2.b;
                    eVar = (e) kVar2.f6070a;
                    ResultKt.throwOnFailure(obj);
                }
                aVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) obj;
                if (aVar != null) {
                    v.a aVar2 = new v.a(objectRef.element);
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar.h, "Failed to load linear: " + objectRef.element, null, false, 12, null);
                    return aVar2;
                }
                return new v.b(aVar);
            }
        }
        kVar = new k(continuation);
        k kVar22 = kVar;
        Object obj3 = kVar22.c;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = kVar22.e;
        if (i2 != 0) {
        }
        aVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) obj3;
        if (aVar != null) {
        }
    }

    public static /* synthetic */ Object a(e eVar, w wVar, d dVar, double d2, ScreenData screenData, boolean z, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            dVar = null;
        }
        return eVar.a(wVar, dVar, d2, screenData, z, str, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(B b2, d dVar, double d2, ScreenData screenData, boolean z, String str, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
        l lVar;
        int i2;
        List<String> a2;
        d dVar2;
        e eVar;
        B b3;
        int i3;
        ScreenData screenData2;
        boolean z2;
        String str2;
        double d3;
        Set<String> g2;
        a e;
        com.moloco.sdk.internal.v vVar;
        a e2;
        a e3;
        if (continuation instanceof l) {
            lVar = (l) continuation;
            int i4 = lVar.l;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                lVar.l = i4 - Integer.MIN_VALUE;
                l lVar2 = lVar;
                Object obj = lVar2.j;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = lVar2.l;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                    MolocoLogger.info$default(molocoLogger, this.h, "Loading wrapper vast ad: " + b2.f(), null, false, 12, null);
                    int h2 = dVar != null ? dVar.h() + 1 : 0;
                    a2 = i.a((List) ((dVar == null || (e = dVar.e()) == null) ? null : e.e()), (List) b2.c());
                    if (h2 <= 4 && ((dVar == null || (g2 = dVar.g()) == null || !g2.contains(b2.f())) && (dVar == null || dVar.f()))) {
                        lVar2.f6071a = this;
                        lVar2.b = b2;
                        lVar2.c = dVar;
                        lVar2.d = screenData;
                        lVar2.e = str;
                        lVar2.f = a2;
                        lVar2.g = d2;
                        lVar2.h = z;
                        lVar2.i = h2;
                        lVar2.l = 1;
                        Object a3 = a(b2, a2, lVar2);
                        if (a3 != coroutine_suspended) {
                            dVar2 = dVar;
                            eVar = this;
                            b3 = b2;
                            i3 = h2;
                            obj = a3;
                            screenData2 = screenData;
                            z2 = z;
                            str2 = str;
                            d3 = d2;
                        }
                    }
                    a(a2, x.e);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k kVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.e;
                    MolocoLogger.error$default(molocoLogger, this.h, "Failed to load wrapper vast ad: " + kVar, null, false, 12, null);
                    return new v.a(kVar);
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                i3 = lVar2.i;
                boolean z3 = lVar2.h;
                double d4 = lVar2.g;
                a2 = (List) lVar2.f;
                str2 = (String) lVar2.e;
                ScreenData screenData3 = (ScreenData) lVar2.d;
                dVar2 = (d) lVar2.c;
                b3 = (B) lVar2.b;
                e eVar2 = (e) lVar2.f6071a;
                ResultKt.throwOnFailure(obj);
                z2 = z3;
                eVar = eVar2;
                screenData2 = screenData3;
                d3 = d4;
                vVar = (com.moloco.sdk.internal.v) obj;
                if (!(vVar instanceof v.a)) {
                    v.a aVar = (v.a) vVar;
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar.h, "Failed to load wrapper vast ad: " + aVar.a(), null, false, 12, null);
                    return new v.a(aVar.a());
                }
                if (vVar instanceof v.b) {
                    w wVar = (w) ((v.b) vVar).a();
                    c cVar = i;
                    e eVar3 = eVar;
                    List a4 = cVar.a((List) ((dVar2 == null || (e3 = dVar2.e()) == null) ? null : e3.f()), (List) b3.e());
                    List a5 = cVar.a((List) ((dVar2 == null || (e2 = dVar2.e()) == null) ? null : e2.d()), CollectionsKt.listOf(b3.b()));
                    Set a6 = cVar.a(dVar2 != null ? dVar2.g() : null, (Set<String>) b3.f());
                    Boolean d5 = b3.d();
                    d dVar3 = new d(i3, a6, d5 != null ? d5.booleanValue() : true, new a(a4, a2, a5));
                    lVar2.f6071a = null;
                    lVar2.b = null;
                    lVar2.c = null;
                    lVar2.d = null;
                    lVar2.e = null;
                    lVar2.f = null;
                    lVar2.l = 2;
                    Object a7 = eVar3.a(wVar, dVar3, d3, screenData2, z2, str2, lVar2);
                    return a7 == coroutine_suspended ? coroutine_suspended : a7;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        lVar = new l(continuation);
        l lVar22 = lVar;
        Object obj2 = lVar22.j;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = lVar22.l;
        if (i2 != 0) {
        }
        vVar = (com.moloco.sdk.internal.v) obj2;
        if (!(vVar instanceof v.a)) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00cf, code lost:
    
        if (r0 != r4) goto L77;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(B b2, List<String> list, Continuation<? super com.moloco.sdk.internal.v<w, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
        g gVar;
        ?? r5;
        ?? r52;
        e eVar;
        ?? r53;
        e eVar2;
        e eVar3;
        List<String> list2;
        List<String> list3;
        HttpStatement httpStatement;
        e eVar4;
        w wVar;
        try {
            if (continuation instanceof g) {
                gVar = (g) continuation;
                int i2 = gVar.e;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    gVar.e = i2 - Integer.MIN_VALUE;
                    Object obj = gVar.c;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r5 = gVar.e;
                    if (r5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        try {
                            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.h, "Fetching wrapper vast tag url: " + b2.f(), null, false, 12, null);
                            HttpClient httpClient = this.f;
                            String f2 = b2.f();
                            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                            HttpRequestKt.url(httpRequestBuilder, f2);
                            com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, 5000L);
                            httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
                            httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                            gVar.f6065a = this;
                            list3 = list;
                        } catch (HttpRequestTimeoutException e) {
                            e = e;
                            list3 = list;
                        } catch (Exception e2) {
                            e = e2;
                            list3 = list;
                        }
                        try {
                            gVar.b = list3;
                            gVar.e = 1;
                            obj = httpStatement.execute(gVar);
                            if (obj != coroutine_suspended) {
                                list2 = list3;
                                eVar3 = this;
                            }
                            return coroutine_suspended;
                        } catch (HttpRequestTimeoutException e3) {
                            e = e3;
                            eVar2 = this;
                            r53 = list3;
                            List<String> list4 = r53;
                            eVar3 = eVar2;
                            list2 = list4;
                            eVar3.a(list2, x.d);
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar3.h, "Fetching wrapper vast tag url timed out", e, false, 8, null);
                            return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.f);
                        } catch (Exception e4) {
                            e = e4;
                            eVar = this;
                            r52 = list3;
                            List<String> list5 = r52;
                            eVar3 = eVar;
                            list2 = list5;
                            eVar3.a(list2, x.c);
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar3.h, "Fetching wrapper vast tag url fetch error", e, false, 8, null);
                            return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.g);
                        }
                    }
                    if (r5 != 1) {
                        if (r5 != 2) {
                            if (r5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            list2 = (List) gVar.b;
                            eVar4 = (e) gVar.f6065a;
                            ResultKt.throwOnFailure(obj);
                            v.b bVar = !(obj instanceof v.b) ? (v.b) obj : null;
                            wVar = bVar != null ? (w) bVar.a() : null;
                            if (wVar != null) {
                                eVar4.a(list2, x.b);
                                MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar4.h, "Failed to create VAST object from XML", null, false, 12, null);
                                return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.b);
                            }
                            return new v.b(wVar);
                        }
                        list2 = (List) gVar.b;
                        eVar3 = (e) gVar.f6065a;
                        ResultKt.throwOnFailure(obj);
                        try {
                            String str = (String) obj;
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i iVar = eVar3.f6059a;
                            gVar.f6065a = eVar3;
                            gVar.b = list2;
                            gVar.e = 3;
                            obj = iVar.a(str, gVar);
                            if (obj != coroutine_suspended) {
                                eVar4 = eVar3;
                                if (!(obj instanceof v.b)) {
                                }
                                if (bVar != null) {
                                }
                                if (wVar != null) {
                                }
                            }
                            return coroutine_suspended;
                        } catch (HttpRequestTimeoutException e5) {
                            e = e5;
                            eVar3.a(list2, x.d);
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar3.h, "Fetching wrapper vast tag url timed out", e, false, 8, null);
                            return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.f);
                        } catch (Exception e6) {
                            e = e6;
                            eVar3.a(list2, x.c);
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar3.h, "Fetching wrapper vast tag url fetch error", e, false, 8, null);
                            return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.g);
                        }
                    }
                    list2 = (List) gVar.b;
                    eVar3 = (e) gVar.f6065a;
                    ResultKt.throwOnFailure(obj);
                    gVar.f6065a = eVar3;
                    gVar.b = list2;
                    gVar.e = 2;
                    obj = HttpResponseKt.bodyAsText$default((HttpResponse) obj, null, gVar, 1, null);
                }
            }
            if (r5 != 0) {
            }
            gVar.f6065a = eVar3;
            gVar.b = list2;
            gVar.e = 2;
            obj = HttpResponseKt.bodyAsText$default((HttpResponse) obj, null, gVar, 1, null);
        } catch (HttpRequestTimeoutException e7) {
            e = e7;
            r53 = "Fetching wrapper vast tag url: ";
            eVar2 = r5;
        } catch (Exception e8) {
            e = e8;
            r52 = "Fetching wrapper vast tag url: ";
            eVar = r5;
        }
        gVar = new g(continuation);
        Object obj2 = gVar.c;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r5 = gVar.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0189 -> B:10:0x0196). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o oVar, final a aVar, double d2, ScreenData screenData, boolean z, String str, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
        h hVar;
        int i2;
        String str2;
        List<String> list;
        h hVar2;
        Lazy lazy;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k kVar;
        Iterator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g> it;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c cVar;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f fVar;
        double d3;
        ScreenData screenData2;
        boolean z2;
        a aVar2;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o oVar2;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g next;
        final e eVar = this;
        if (continuation instanceof h) {
            hVar = (h) continuation;
            int i3 = hVar.q;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                hVar.q = i3 - Integer.MIN_VALUE;
                Object obj = hVar.o;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = hVar.q;
                if (i2 == 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z3 = hVar.n;
                    double d4 = hVar.m;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g) hVar.l;
                    Iterator<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g> it2 = (Iterator) hVar.k;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k kVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k) hVar.j;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c cVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c) hVar.i;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f fVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f) hVar.h;
                    Lazy lazy2 = (Lazy) hVar.g;
                    List<String> list2 = (List) hVar.f;
                    String str3 = (String) hVar.e;
                    ScreenData screenData3 = (ScreenData) hVar.d;
                    a aVar3 = (a) hVar.c;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o oVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o) hVar.b;
                    e eVar2 = (e) hVar.f6066a;
                    ResultKt.throwOnFailure(obj);
                    boolean z4 = z3;
                    h hVar3 = hVar;
                    String str4 = str3;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o oVar4 = oVar3;
                    Object obj2 = coroutine_suspended;
                    Object obj3 = obj;
                    aVar2 = aVar3;
                    com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj3;
                    if (!(vVar instanceof v.a)) {
                        e eVar3 = eVar2;
                        v.a aVar4 = (v.a) vVar;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar2.h, "Failed to prepare RenderLinear: " + aVar4.a(), null, false, 12, null);
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k kVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k) aVar4.a();
                        oVar2 = oVar4;
                        next = gVar;
                        screenData2 = screenData3;
                        d3 = d4;
                        it = it2;
                        list = list2;
                        str2 = str4;
                        hVar2 = hVar3;
                        lazy = lazy2;
                        fVar = fVar2;
                        cVar = cVar2;
                        kVar = kVar3;
                        eVar = eVar3;
                    } else {
                        e eVar4 = eVar2;
                        if (vVar instanceof v.b) {
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f fVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f) ((v.b) vVar).a();
                            oVar2 = oVar4;
                            next = gVar;
                            screenData2 = screenData3;
                            d3 = d4;
                            cVar = cVar2;
                            list = list2;
                            str2 = str4;
                            kVar = kVar2;
                            lazy = lazy2;
                            fVar = fVar3;
                            it = it2;
                            eVar = eVar4;
                            hVar2 = hVar3;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o oVar5 = oVar2;
                    if (cVar == null && (next.h() instanceof h.a)) {
                        cVar = eVar.a(((h.a) next.h()).a(), screenData2);
                    }
                    oVar2 = oVar5;
                    coroutine_suspended = obj2;
                    z2 = z4;
                    while (it.hasNext()) {
                        Object obj4 = coroutine_suspended;
                        next = it.next();
                        if (fVar != null && cVar != null) {
                            break;
                        }
                        z4 = z2;
                        if (i.a(next)) {
                            z2 = z4;
                            coroutine_suspended = obj4;
                        } else if (fVar == null && (next.h() instanceof h.b)) {
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p a2 = ((h.b) next.h()).a();
                            List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> c2 = a((Lazy<b>) lazy).c();
                            A d5 = a((Lazy<b>) lazy).d();
                            Long b2 = ((h.b) next.h()).a().b();
                            hVar2.f6066a = eVar;
                            hVar2.b = oVar2;
                            hVar2.c = aVar2;
                            hVar2.d = screenData2;
                            hVar2.e = str2;
                            hVar2.f = list;
                            hVar2.g = lazy;
                            hVar2.h = fVar;
                            hVar2.i = cVar;
                            hVar2.j = kVar;
                            hVar2.k = it;
                            hVar2.l = next;
                            hVar2.m = d3;
                            hVar2.n = z4;
                            e eVar5 = eVar;
                            hVar2.q = 1;
                            ScreenData screenData4 = screenData2;
                            double d6 = d3;
                            str4 = str2;
                            hVar3 = hVar2;
                            Object a3 = eVar5.a(a2, c2, d5, list, d6, b2, screenData4, z4, str4, hVar3);
                            screenData3 = screenData4;
                            obj2 = obj4;
                            if (a3 == obj2) {
                                return obj2;
                            }
                            oVar4 = oVar2;
                            eVar2 = eVar5;
                            gVar = next;
                            obj3 = a3;
                            it2 = it;
                            kVar2 = kVar;
                            cVar2 = cVar;
                            fVar2 = fVar;
                            lazy2 = lazy;
                            list2 = list;
                            d4 = d6;
                            com.moloco.sdk.internal.v vVar2 = (com.moloco.sdk.internal.v) obj3;
                            if (!(vVar2 instanceof v.a)) {
                            }
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o oVar52 = oVar2;
                            if (cVar == null) {
                            }
                            oVar2 = oVar52;
                            coroutine_suspended = obj2;
                            z2 = z4;
                            while (it.hasNext()) {
                            }
                        } else {
                            obj2 = obj4;
                            eVar = eVar;
                            screenData2 = screenData2;
                            d3 = d3;
                            str2 = str2;
                            hVar2 = hVar2;
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o oVar522 = oVar2;
                            if (cVar == null) {
                                cVar = eVar.a(((h.a) next.h()).a(), screenData2);
                            }
                            oVar2 = oVar522;
                            coroutine_suspended = obj2;
                            z2 = z4;
                            while (it.hasNext()) {
                            }
                        }
                    }
                    final e eVar6 = eVar;
                    final ScreenData screenData5 = screenData2;
                    if (fVar != null) {
                        eVar6.a(list, x.h);
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar6.h, "Failed to load linear: " + kVar, null, false, 12, null);
                        return new v.a(kVar);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, eVar6.h, "RenderAd loaded successfully.", null, false, 12, null);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f a4 = fVar.i() == null ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f.a(fVar, null, null, null, null, null, null, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(CollectionsKt.asReversed(a((Lazy<b>) lazy).b())), new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj5) {
                            return e.a(e.this, (List) obj5);
                        }
                    })), 63, null) : fVar;
                    if (cVar == null) {
                        cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(CollectionsKt.asReversed(a((Lazy<b>) lazy).a())), new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj5) {
                                return e.a(e.this, screenData5, (List) obj5);
                            }
                        }));
                    }
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c cVar3 = cVar;
                    List a5 = i.a((List) (aVar2 != null ? aVar2.f() : null), (List) oVar2.g());
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a5, 10));
                    Iterator it3 = a5.iterator();
                    while (it3.hasNext()) {
                        arrayList.add(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n) it3.next()).b());
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, eVar6.h, "Returning RenderAd", null, false, 12, null);
                    return new v.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a(a4, cVar3, arrayList, list, null, 16, null));
                }
                ResultKt.throwOnFailure(obj);
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, eVar.h, "Trying to load RenderAd", null, false, 12, null);
                List<String> a6 = i.a((List) (aVar != null ? aVar.e() : null), (List) oVar.f());
                if (oVar.d().isEmpty()) {
                    eVar.a(a6, x.g);
                    MolocoLogger.error$default(molocoLogger, eVar.h, "No creatives in InLine", null, false, 12, null);
                    return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.h);
                }
                str2 = str;
                list = a6;
                hVar2 = hVar;
                lazy = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return e.a(e.this, aVar);
                    }
                });
                kVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.i;
                it = oVar.d().iterator();
                cVar = null;
                fVar = null;
                d3 = d2;
                screenData2 = screenData;
                z2 = z;
                aVar2 = aVar;
                oVar2 = oVar;
                while (it.hasNext()) {
                }
                final e eVar62 = eVar;
                final ScreenData screenData52 = screenData2;
                if (fVar != null) {
                }
            }
        }
        hVar = eVar.new h(continuation);
        Object obj5 = hVar.o;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = hVar.q;
        if (i2 == 0) {
        }
    }

    public static final b a(Lazy<b> lazy) {
        return lazy.getValue();
    }

    public static final b a(e eVar, a aVar) {
        return eVar.a(aVar);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e a(e eVar, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return eVar.a((List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>) it);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c a(e eVar, ScreenData screenData, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return eVar.a((List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>) it, screenData);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p pVar, List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list, A a2, List<String> list2, double d2, Long l2, ScreenData screenData, boolean z, String str, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
        n nVar;
        int i2;
        Ref.ObjectRef objectRef;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p pVar2;
        A a3;
        List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list3;
        e eVar;
        Pair pair;
        z a4;
        if (continuation instanceof n) {
            nVar = (n) continuation;
            int i3 = nVar.h;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                nVar.h = i3 - Integer.MIN_VALUE;
                n nVar2 = nVar;
                Object obj = nVar2.f;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = nVar2.h;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, this.h, "Preparing InLine RenderLinear with target linear size: " + d2, null, false, 12, null);
                    List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q> d3 = pVar.d();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : d3) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q qVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q) obj2;
                        c cVar = i;
                        if (!cVar.a(qVar) && qVar.k() && cVar.a(qVar.i())) {
                            arrayList.add(obj2);
                        }
                    }
                    List sortedWith = CollectionsKt.sortedWith(arrayList, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g.a(d2, l2, Boxing.boxInt(screenData.getWidthPx()), Boxing.boxInt(screenData.getHeightPx())));
                    if (sortedWith.isEmpty()) {
                        a(list2, x.i);
                        return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.j);
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.E;
                    m mVar = new m(FlowKt.cancellable(FlowKt.asFlow(sortedWith)), z, this, str, objectRef2);
                    nVar2.f6075a = this;
                    nVar2.b = pVar;
                    nVar2.c = list;
                    nVar2.d = a2;
                    nVar2.e = objectRef2;
                    nVar2.h = 1;
                    Object firstOrNull = FlowKt.firstOrNull(mVar, nVar2);
                    if (firstOrNull == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = firstOrNull;
                    objectRef = objectRef2;
                    pVar2 = pVar;
                    a3 = a2;
                    list3 = list;
                    eVar = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) nVar2.e;
                    a3 = (A) nVar2.d;
                    list3 = (List) nVar2.c;
                    pVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p) nVar2.b;
                    eVar = (e) nVar2.f6075a;
                    ResultKt.throwOnFailure(obj);
                }
                pair = (Pair) obj;
                if (pair != null) {
                    v.a aVar = new v.a(objectRef.element);
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar.h, "Failed to load media file: " + objectRef.element, null, false, 12, null);
                    return aVar;
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q qVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q) pair.component1();
                File file = (File) pair.component2();
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, eVar.h, "Found a RenderLinear MediaFile: " + file.getAbsolutePath() + " for url: " + qVar2.g(), null, false, 12, null);
                A g2 = pVar2.g();
                String b2 = (g2 == null || (a4 = g2.a()) == null) ? null : a4.b();
                c cVar2 = i;
                List a5 = cVar2.a((List) pVar2.f(), (List) list3);
                A g3 = pVar2.g();
                z a6 = g3 != null ? g3.a() : null;
                A g4 = pVar2.g();
                List a7 = cVar2.a((List) (g4 != null ? g4.b() : null), (List) (a3 != null ? a3.b() : null));
                A g5 = pVar2.g();
                A a8 = new A(a6, a7, cVar2.a((List) (g5 != null ? g5.c() : null), (List) (a3 != null ? a3.c() : null)));
                MolocoLogger.info$default(molocoLogger, eVar.h, "Returning RenderLinear for url: " + qVar2.g() + ", with bitrate: " + qVar2.b() + ' ', null, false, 12, null);
                return new v.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f(pVar2.e(), file, qVar2.b(), qVar2.g(), b2, cVar2.a((List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>) a5, a8), eVar.a(pVar2.c())));
            }
        }
        nVar = new n(continuation);
        n nVar22 = nVar;
        Object obj3 = nVar22.f;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = nVar22.h;
        if (i2 != 0) {
        }
        pair = (Pair) obj3;
        if (pair != null) {
        }
    }

    public final b a(a aVar) {
        List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> d2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        if (aVar != null && (d2 = aVar.d()) != null) {
            Iterator<T> it = d2.iterator();
            while (it.hasNext()) {
                List list = (List) it.next();
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                ArrayList<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g> arrayList8 = new ArrayList();
                for (Object obj : list) {
                    if (!i.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g) obj)) {
                        arrayList8.add(obj);
                    }
                }
                for (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar : arrayList8) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h h2 = gVar.h();
                    if (h2 instanceof h.b) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p a2 = ((h.b) gVar.h()).a();
                        CollectionsKt.addAll(arrayList, a2.f());
                        A g2 = a2.g();
                        if (g2 != null) {
                            CollectionsKt.addAll(arrayList2, g2.b());
                            CollectionsKt.addAll(arrayList3, g2.c());
                        }
                        CollectionsKt.addAll(arrayList6, a2.c());
                    } else if (h2 instanceof h.a) {
                        CollectionsKt.addAll(arrayList7, ((h.a) gVar.h()).a());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                arrayList4.add(arrayList6);
                arrayList5.add(arrayList7);
            }
        }
        return new b(arrayList, new A(null, arrayList2, arrayList3), arrayList4, arrayList5);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e> list, ScreenData screenData) {
        List<String> emptyList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e) obj;
            if (!i.a(eVar) && !eVar.h().isEmpty()) {
                arrayList.add(obj);
            }
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(arrayList, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g.a(Integer.valueOf(screenData.getWidthPx()), Integer.valueOf(screenData.getHeightPx()))));
        if (eVar2 == null) {
            return null;
        }
        y yVar = (y) CollectionsKt.first(CollectionsKt.sortedWith(eVar2.h(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g.b()));
        Integer i2 = eVar2.i();
        int intValue = i2 != null ? i2.intValue() : 0;
        Integer f2 = eVar2.f();
        int intValue2 = f2 != null ? f2.intValue() : 0;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f d2 = eVar2.d();
        String a2 = d2 != null ? d2.a() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f d3 = eVar2.d();
        if (d3 == null || (emptyList = d3.b()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        List<String> list2 = emptyList;
        List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> e = eVar2.e();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(e, 10));
        Iterator<T> it = e.iterator();
        while (it.hasNext()) {
            arrayList2.add(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u) it.next()).f());
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c(yVar, intValue, intValue2, a2, list2, arrayList2);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l> list) {
        List<String> emptyList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!i.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l) obj)) {
                arrayList.add(obj);
            }
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l lVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(arrayList, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g.a()));
        if (lVar == null) {
            return null;
        }
        y g2 = lVar.g();
        Integer i2 = lVar.i();
        int intValue = i2 != null ? i2.intValue() : 0;
        Integer d2 = lVar.d();
        int intValue2 = d2 != null ? d2.intValue() : 0;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m b2 = lVar.b();
        String a2 = b2 != null ? b2.a() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m b3 = lVar.b();
        if (b3 == null || (emptyList = b3.b()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e(g2, intValue, intValue2, a2, emptyList, lVar.h(), lVar.c(), lVar.e());
    }
}
