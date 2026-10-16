package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.E;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes6.dex */
public final class m implements l {
    public static final int c = 8;

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i f6134a;
    public final CoroutineScope b;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastTrackerImpl$track$1", f = "VastTracker.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f6135a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public int i;
        public final /* synthetic */ List<String> j;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a k;
        public final /* synthetic */ a.AbstractC0571a.f l;
        public final /* synthetic */ m m;
        public final /* synthetic */ List<a.AbstractC0571a.c> n;
        public final /* synthetic */ x o;
        public final /* synthetic */ Integer p;
        public final /* synthetic */ String q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List<String> list, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, a.AbstractC0571a.f fVar, m mVar, List<a.AbstractC0571a.c> list2, x xVar, Integer num, String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.j = list;
            this.k = aVar;
            this.l = fVar;
            this.m = mVar;
            this.n = list2;
            this.o = xVar;
            this.p = num;
            this.q = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0099  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0063 -> B:6:0x0097). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0065 -> B:6:0x0097). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0085 -> B:5:0x008d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            List<a.AbstractC0571a.c> list;
            x xVar;
            Integer num;
            com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar;
            a.AbstractC0571a.f fVar;
            m mVar;
            Iterator it;
            String str;
            String d;
            String b;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.i;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<String> list2 = this.j;
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar2 = this.k;
                a.AbstractC0571a.f fVar2 = this.l;
                m mVar2 = this.m;
                List<a.AbstractC0571a.c> list3 = this.n;
                x xVar2 = this.o;
                Integer num2 = this.p;
                String str2 = this.q;
                list = list3;
                xVar = xVar2;
                num = num2;
                aVar = aVar2;
                fVar = fVar2;
                mVar = mVar2;
                it = list2.iterator();
                str = str2;
                if (it.hasNext()) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.h;
                String str3 = (String) this.g;
                Integer num3 = (Integer) this.f;
                x xVar3 = (x) this.e;
                List<a.AbstractC0571a.c> list4 = (List) this.d;
                m mVar3 = (m) this.c;
                a.AbstractC0571a.f fVar3 = (a.AbstractC0571a.f) this.b;
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a) this.f6135a;
                ResultKt.throwOnFailure(obj);
                num = num3;
                xVar = xVar3;
                aVar = aVar3;
                String str4 = (String) obj;
                str = str3;
                list = list4;
                mVar = mVar3;
                fVar = fVar3;
                Integer boxInt = xVar == null ? Boxing.boxInt(xVar.c()) : null;
                d = n.d();
                b = n.b(str4, boxInt, num, str, d);
                mVar.f6134a.a(b);
                if (it.hasNext()) {
                    str4 = (String) it.next();
                    if (aVar != null && fVar != null) {
                        long a2 = E.a();
                        this.f6135a = aVar;
                        this.b = fVar;
                        this.c = mVar;
                        this.d = list;
                        this.e = xVar;
                        this.f = num;
                        this.g = str;
                        this.h = it;
                        this.i = 1;
                        Object a3 = mVar.a(str4, aVar, fVar, a2, list, this);
                        if (a3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mVar3 = mVar;
                        fVar3 = fVar;
                        list4 = list;
                        str3 = str;
                        obj = a3;
                        aVar3 = aVar;
                        num3 = num;
                        xVar3 = xVar;
                        num = num3;
                        xVar = xVar3;
                        aVar = aVar3;
                        String str42 = (String) obj;
                        str = str3;
                        list = list4;
                        mVar = mVar3;
                        fVar = fVar3;
                    }
                    if (xVar == null) {
                    }
                    d = n.d();
                    b = n.b(str42, boxInt, num, str, d);
                    mVar.f6134a.a(b);
                    if (it.hasNext()) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }

    public m(com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest) {
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        this.f6134a = persistentHttpRequest;
        this.b = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getDefault());
    }

    public final void b(List<String> list, x xVar, Integer num, String str, List<a.AbstractC0571a.c> list2, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, a.AbstractC0571a.f fVar) {
        if (list.isEmpty()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.b, null, null, new a(list, aVar, fVar, this, list2, xVar, num, str, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l
    public void a(List<String> urls, x xVar, Integer num, String str, List<a.AbstractC0571a.c> renderedButtons, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, a.AbstractC0571a.f lastClickPosition) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(renderedButtons, "renderedButtons");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(lastClickPosition, "lastClickPosition");
        b(urls, xVar, num, str, renderedButtons, customUserEventBuilderService, lastClickPosition);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l
    public void a(List<String> urls, x xVar, Integer num, String str) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        b(urls, xVar, num, str, CollectionsKt.emptyList(), null, null);
    }

    public final Object a(String str, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, a.AbstractC0571a.f fVar, long j, List<a.AbstractC0571a.c> list, Continuation<? super String> continuation) {
        return aVar.a(j, new a.AbstractC0571a.d(fVar, null, null, list, 6, null), str, continuation);
    }
}
