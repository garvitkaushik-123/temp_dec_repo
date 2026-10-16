package com.moloco.sdk.internal.publisher.nativead.parser;

import android.content.Context;
import android.net.Uri;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.publisher.nativead.model.b;
import com.moloco.sdk.internal.publisher.nativead.model.c;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5556a = "PrepareNativeAssets";

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt", f = "PrepareNativeAssets.kt", i = {0}, l = {113}, m = "prepareImageAsset", n = {"asset"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5557a;
        public /* synthetic */ Object b;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return c.b(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt", f = "PrepareNativeAssets.kt", i = {0, 0, 0, 1}, l = {37, 58}, m = "prepareNativeAssets-exY8QGI", n = {"loadVast", "optionalAssetsGroup", "timeout", "preparedRequiredAssets"}, s = {"L$0", "L$1", "J$0", "L$0"})
    public static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public long f5558a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return c.a((Context) null, (List<? extends b.a>) null, 0L, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedOptionalAssets$1", f = "PrepareNativeAssets.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.internal.publisher.nativead.parser.c$c, reason: collision with other inner class name */
    public static final class C0451c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Pair<? extends b.a, ? extends v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5559a;
        public /* synthetic */ Object b;
        public final /* synthetic */ List<b.a> c;
        public final /* synthetic */ Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> d;
        public final /* synthetic */ long e;

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedOptionalAssets$1$1$1", f = "PrepareNativeAssets.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.internal.publisher.nativead.parser.c$c$a */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends b.a, ? extends v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public Object f5560a;
            public int b;
            public final /* synthetic */ b.a c;
            public final /* synthetic */ Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> d;
            public final /* synthetic */ long e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(b.a aVar, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super a> continuation) {
                super(2, continuation);
                this.c = aVar;
                this.d = lazy;
                this.e = j;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends b.a, ? extends v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                b.a aVar;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.b;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    b.a aVar2 = this.c;
                    Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy = this.d;
                    long j = this.e;
                    this.f5560a = aVar2;
                    this.b = 1;
                    Object b = c.b(aVar2, lazy, j, this);
                    if (b == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar = aVar2;
                    obj = b;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (b.a) this.f5560a;
                    ResultKt.throwOnFailure(obj);
                }
                return TuplesKt.to(aVar, obj);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0451c(List<? extends b.a> list, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super C0451c> continuation) {
            super(2, continuation);
            this.c = list;
            this.d = lazy;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Pair<? extends b.a, ? extends v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>> continuation) {
            return ((C0451c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C0451c c0451c = new C0451c(this.c, this.d, this.e, continuation);
            c0451c.b = obj;
            return c0451c;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Deferred async$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5559a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.b;
            List<b.a> list = this.c;
            Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy = this.d;
            long j = this.e;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new a((b.a) it.next(), lazy, j, null), 3, null);
                arrayList.add(async$default);
                lazy = lazy;
                j = j;
            }
            this.f5559a = 1;
            Object awaitAll = AwaitKt.awaitAll(arrayList, this);
            return awaitAll == coroutine_suspended ? coroutine_suspended : awaitAll;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedRequiredAssets$1", f = "PrepareNativeAssets.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Pair<? extends b.a, ? extends v.b<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5561a;
        public /* synthetic */ Object b;
        public final /* synthetic */ List<b.a> c;
        public final /* synthetic */ Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> d;
        public final /* synthetic */ long e;

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedRequiredAssets$1$1$1", f = "PrepareNativeAssets.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends b.a, ? extends v.b<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5562a;
            public final /* synthetic */ b.a b;
            public final /* synthetic */ Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> c;
            public final /* synthetic */ long d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(b.a aVar, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = aVar;
                this.c = lazy;
                this.d = j;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends b.a, v.b<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5562a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    b.a aVar = this.b;
                    Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy = this.c;
                    long j = this.d;
                    this.f5562a = 1;
                    obj = c.b(aVar, lazy, j, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                v vVar = (v) obj;
                if (vVar instanceof v.b) {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, c.f5556a, "Successfully prepared native asset: " + this.b.a(), null, false, 12, null);
                    return TuplesKt.to(this.b, vVar);
                }
                if (!(vVar instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, c.f5556a, "Failed to prepare required native asset: " + this.b.a(), null, false, 12, null);
                throw new com.moloco.sdk.internal.publisher.nativead.parser.b(this.b.a(), (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((v.a) vVar).a());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(List<? extends b.a> list, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = list;
            this.d = lazy;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Pair<? extends b.a, v.b<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(this.c, this.d, this.e, continuation);
            dVar.b = obj;
            return dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Deferred async$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5561a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.b;
            List<b.a> list = this.c;
            Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy = this.d;
            long j = this.e;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new a((b.a) it.next(), lazy, j, null), 3, null);
                arrayList.add(async$default);
                lazy = lazy;
                j = j;
            }
            this.f5561a = 1;
            Object awaitAll = AwaitKt.awaitAll(arrayList, this);
            return awaitAll == coroutine_suspended ? coroutine_suspended : awaitAll;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt", f = "PrepareNativeAssets.kt", i = {0, 0, 0, 1}, l = {148, 155}, m = "prepareVideoAsset-exY8QGI", n = {"asset", "loadVast", "timeout", "asset"}, s = {"L$0", "L$1", "J$0", "L$0"})
    public static final class e extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5563a;
        public Object b;
        public long c;
        public /* synthetic */ Object d;
        public int e;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return c.b((b.a.d) null, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d) null, 0L, this);
        }
    }

    public static final Object b(b.a aVar, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> continuation) {
        if (aVar instanceof b.a.C0447a) {
            return new v.b(new c.a((b.a.C0447a) aVar));
        }
        if (aVar instanceof b.a.C0448b) {
            return a((b.a.C0448b) aVar, null, continuation, 2, null);
        }
        if (aVar instanceof b.a.c) {
            return new v.b(new c.C0450c((b.a.c) aVar));
        }
        if (aVar instanceof b.a.d) {
            return b((b.a.d) aVar, lazy.getValue(), j, continuation);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(final Context context, List<? extends b.a> list, long j, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.internal.publisher.nativead.parser.b>> continuation) {
        b bVar;
        Object coroutine_suspended;
        int i;
        List list2;
        Lazy lazy;
        long j2;
        Object coroutineScope;
        List list3;
        try {
            if (continuation instanceof b) {
                bVar = (b) continuation;
                int i2 = bVar.e;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    bVar.e = i2 - Integer.MIN_VALUE;
                    Object obj = bVar.d;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = bVar.e;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Lazy lazy2 = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.publisher.nativead.parser.c$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return c.a(context);
                            }
                        });
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Object obj2 : list) {
                            Boolean boxBoolean = Boxing.boxBoolean(((b.a) obj2).b());
                            Object obj3 = linkedHashMap.get(boxBoolean);
                            if (obj3 == null) {
                                obj3 = new ArrayList();
                                linkedHashMap.put(boxBoolean, obj3);
                            }
                            ((List) obj3).add(obj2);
                        }
                        List list4 = (List) linkedHashMap.get(Boxing.boxBoolean(true));
                        if (list4 == null) {
                            list4 = CollectionsKt.emptyList();
                        }
                        List list5 = list4;
                        List list6 = (List) linkedHashMap.get(Boxing.boxBoolean(false));
                        if (list6 == null) {
                            list6 = CollectionsKt.emptyList();
                        }
                        list2 = list6;
                        d dVar = new d(list5, lazy2, j, null);
                        bVar.b = lazy2;
                        bVar.c = list2;
                        bVar.f5558a = j;
                        bVar.e = 1;
                        obj = CoroutineScopeKt.coroutineScope(dVar, bVar);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        lazy = lazy2;
                        j2 = j;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            list3 = (List) bVar.b;
                            ResultKt.throwOnFailure(obj);
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                            ArrayList arrayList = new ArrayList();
                            for (Pair pair : CollectionsKt.plus((Collection) list3, (Iterable) obj)) {
                                b.a aVar = (b.a) pair.component1();
                                v vVar = (v) pair.component2();
                                if (vVar instanceof v.a) {
                                    arrayList.add(TuplesKt.to(aVar, ((v.a) vVar).a()));
                                } else if (vVar instanceof v.b) {
                                    com.moloco.sdk.internal.publisher.nativead.model.c cVar = (com.moloco.sdk.internal.publisher.nativead.model.c) ((v.b) vVar).a();
                                    if (cVar instanceof c.a) {
                                        Pair pair2 = TuplesKt.to(Boxing.boxInt(cVar.b().a()), cVar);
                                        linkedHashMap2.put(pair2.getFirst(), pair2.getSecond());
                                    } else if (cVar instanceof c.b) {
                                        Pair pair3 = TuplesKt.to(Boxing.boxInt(cVar.b().a()), cVar);
                                        linkedHashMap3.put(pair3.getFirst(), pair3.getSecond());
                                    } else if (cVar instanceof c.C0450c) {
                                        Pair pair4 = TuplesKt.to(Boxing.boxInt(cVar.b().a()), cVar);
                                        linkedHashMap4.put(pair4.getFirst(), pair4.getSecond());
                                    } else {
                                        if (!(cVar instanceof c.d)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        Pair pair5 = TuplesKt.to(Boxing.boxInt(cVar.b().a()), cVar);
                                        linkedHashMap5.put(pair5.getFirst(), pair5.getSecond());
                                    }
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                            return new v.b(new com.moloco.sdk.internal.publisher.nativead.model.d(linkedHashMap2, linkedHashMap3, linkedHashMap4, linkedHashMap5, arrayList));
                        }
                        long j3 = bVar.f5558a;
                        list2 = (List) bVar.c;
                        Lazy lazy3 = (Lazy) bVar.b;
                        ResultKt.throwOnFailure(obj);
                        j2 = j3;
                        lazy = lazy3;
                    }
                    List list7 = (List) obj;
                    C0451c c0451c = new C0451c(list2, lazy, j2, null);
                    bVar.b = list7;
                    bVar.c = null;
                    bVar.e = 2;
                    coroutineScope = CoroutineScopeKt.coroutineScope(c0451c, bVar);
                    if (coroutineScope != coroutine_suspended) {
                        list3 = list7;
                        obj = coroutineScope;
                        LinkedHashMap linkedHashMap22 = new LinkedHashMap();
                        LinkedHashMap linkedHashMap32 = new LinkedHashMap();
                        LinkedHashMap linkedHashMap42 = new LinkedHashMap();
                        LinkedHashMap linkedHashMap52 = new LinkedHashMap();
                        ArrayList arrayList2 = new ArrayList();
                        while (r0.hasNext()) {
                        }
                        return new v.b(new com.moloco.sdk.internal.publisher.nativead.model.d(linkedHashMap22, linkedHashMap32, linkedHashMap42, linkedHashMap52, arrayList2));
                    }
                    return coroutine_suspended;
                }
            }
            if (i != 0) {
            }
            List list72 = (List) obj;
            C0451c c0451c2 = new C0451c(list2, lazy, j2, null);
            bVar.b = list72;
            bVar.c = null;
            bVar.e = 2;
            coroutineScope = CoroutineScopeKt.coroutineScope(c0451c2, bVar);
            if (coroutineScope != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (com.moloco.sdk.internal.publisher.nativead.parser.b e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, f5556a, "Failed to prepare required assets", e2, false, 8, null);
            return new v.a(e2);
        }
        bVar = new b(continuation);
        Object obj4 = bVar.d;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bVar.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object b(b.a.C0448b c0448b, i iVar, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> continuation) {
        a aVar;
        int i;
        i.a aVar2;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.c = i2 - Integer.MIN_VALUE;
                Object obj = aVar.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = aVar.c;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String e2 = c0448b.e();
                    aVar.f5557a = c0448b;
                    aVar.c = 1;
                    obj = iVar.a(e2, aVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    c0448b = (b.a.C0448b) aVar.f5557a;
                    ResultKt.throwOnFailure(obj);
                }
                aVar2 = (i.a) obj;
                if (!(aVar2 instanceof i.a.b)) {
                    try {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, f5556a, "Successfully loaded image asset media", null, false, 12, null);
                        String absolutePath = ((i.a.b) aVar2).a().getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                        Uri parse = Uri.parse(absolutePath);
                        Intrinsics.checkNotNullExpressionValue(parse, "parse(this)");
                        return new v.b(new c.b(c0448b, parse));
                    } catch (Exception e3) {
                        MolocoLogger.warn$default(MolocoLogger.INSTANCE, f5556a, "Failed to prepare image asset", e3, false, 8, null);
                        return new v.a(f.c);
                    }
                }
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, f5556a, "Failed to fetch image asset media", null, false, 12, null);
                return new v.a(f.b);
            }
        }
        aVar = new a(continuation);
        Object obj2 = aVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar.c;
        if (i != 0) {
        }
        aVar2 = (i.a) obj2;
        if (!(aVar2 instanceof i.a.b)) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0091, code lost:
    
        if (r14 == r0) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object b(b.a.d dVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar2, long j, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> continuation) {
        e eVar;
        int i;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar3;
        v vVar;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i2 = eVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                eVar.e = i2 - Integer.MIN_VALUE;
                e eVar2 = eVar;
                Object obj = eVar2.d;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = eVar2.e;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String c = dVar.c();
                    eVar2.f5563a = dVar;
                    eVar2.b = dVar2;
                    eVar2.c = j;
                    eVar2.e = 1;
                    obj = d.a.a(dVar2, c, null, true, eVar2, 2, null);
                    if (obj != coroutine_suspended) {
                        dVar3 = dVar2;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    dVar = (b.a.d) eVar2.f5563a;
                    ResultKt.throwOnFailure(obj);
                    v vVar2 = (v) obj;
                    if (vVar2 instanceof v.b) {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, f5556a, "Successfully loaded video asset media", null, false, 12, null);
                        return new v.b(new c.d(dVar, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((v.b) vVar2).a()));
                    }
                    if (vVar2 instanceof v.a) {
                        MolocoLogger.warn$default(MolocoLogger.INSTANCE, f5556a, "Failed to fetch video asset media: " + ((v.a) vVar2).a(), null, false, 12, null);
                        return new v.a(f.d);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                j = eVar2.c;
                dVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d) eVar2.b;
                dVar = (b.a.d) eVar2.f5563a;
                ResultKt.throwOnFailure(obj);
                vVar = (v) obj;
                if (!(vVar instanceof v.b)) {
                    long duration = DurationKt.toDuration(Duration.m11585getInWholeMillisecondsimpl(j) * 0.9d, DurationUnit.MILLISECONDS);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((v.b) vVar).a();
                    eVar2.f5563a = dVar;
                    eVar2.b = null;
                    eVar2.e = 2;
                    obj = dVar3.a(aVar, duration, eVar2);
                } else {
                    if (vVar instanceof v.a) {
                        MolocoLogger.warn$default(MolocoLogger.INSTANCE, f5556a, "Failed to fetch video asset media: " + ((v.a) vVar).a(), null, false, 12, null);
                        return new v.a(f.e);
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        eVar = new e(continuation);
        e eVar22 = eVar;
        Object obj2 = eVar22.d;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = eVar22.e;
        if (i != 0) {
        }
        vVar = (v) obj2;
        if (!(vVar instanceof v.b)) {
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d a(Context context) {
        return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.f.a(context);
    }

    public static /* synthetic */ Object a(b.a.C0448b c0448b, i iVar, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            iVar = a.g.f5755a.a();
        }
        return b(c0448b, iVar, continuation);
    }
}
