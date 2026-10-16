package com.moloco.sdk.acm.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* loaded from: classes6.dex */
public interface d {

    public static final class a {

        @DebugMetadata(c = "com.moloco.sdk.acm.db.MetricsDAO$DefaultImpls", f = "MetricsDAO.kt", i = {0, 0, 0, 1}, l = {58, 62}, m = "deleteAndReturnDeletedEvents", n = {"$this", "deletedEvents", "eventsToDeleteChunk", "deletedEvents"}, s = {"L$0", "L$1", "L$2", "L$0"})
        /* renamed from: com.moloco.sdk.acm.db.d$a$a, reason: collision with other inner class name */
        public static final class C0425a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            public Object f5317a;
            public Object b;
            public Object c;
            public /* synthetic */ Object d;
            public int e;

            public C0425a(Continuation<? super C0425a> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.d = obj;
                this.e |= Integer.MIN_VALUE;
                return a.a(null, this);
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.acm.db.MetricsDAO$DefaultImpls", f = "MetricsDAO.kt", i = {0}, l = {69, 70}, m = "resetDatabase", n = {"$this"}, s = {"L$0"})
        public static final class b extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            public Object f5318a;
            public /* synthetic */ Object b;
            public int c;

            public b(Continuation<? super b> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.c |= Integer.MIN_VALUE;
                return a.b(null, this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a2 -> B:16:0x00a4). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object a(d dVar, Continuation<? super List<com.moloco.sdk.acm.db.b>> continuation) {
            C0425a c0425a;
            int i;
            List arrayList;
            List<com.moloco.sdk.acm.db.b> b2;
            if (continuation instanceof C0425a) {
                c0425a = (C0425a) continuation;
                int i2 = c0425a.e;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    c0425a.e = i2 - Integer.MIN_VALUE;
                    Object obj = c0425a.d;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = c0425a.e;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        arrayList = new ArrayList();
                        b2 = dVar.b();
                        if (b2.isEmpty()) {
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        List list = (List) c0425a.f5317a;
                        ResultKt.throwOnFailure(obj);
                        return list;
                    }
                    List<com.moloco.sdk.acm.db.b> list2 = (List) c0425a.c;
                    arrayList = (List) c0425a.b;
                    d dVar2 = (d) c0425a.f5317a;
                    ResultKt.throwOnFailure(obj);
                    arrayList.addAll(list2);
                    dVar = dVar2;
                    b2 = dVar.b();
                    if (b2.isEmpty()) {
                        c0425a.f5317a = arrayList;
                        c0425a.b = null;
                        c0425a.c = null;
                        c0425a.e = 2;
                        if (dVar.d(c0425a) != coroutine_suspended) {
                            return arrayList;
                        }
                    } else {
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(b2, 10));
                        Iterator<T> it = b2.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(Boxing.boxLong(((com.moloco.sdk.acm.db.b) it.next()).i()));
                        }
                        c0425a.f5317a = dVar;
                        c0425a.b = arrayList;
                        c0425a.c = b2;
                        c0425a.e = 1;
                        if (dVar.a(arrayList2, c0425a) != coroutine_suspended) {
                            dVar2 = dVar;
                            list2 = b2;
                            arrayList.addAll(list2);
                            dVar = dVar2;
                            b2 = dVar.b();
                            if (b2.isEmpty()) {
                            }
                        }
                    }
                    return coroutine_suspended;
                }
            }
            c0425a = new C0425a(continuation);
            Object obj2 = c0425a.d;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = c0425a.e;
            if (i != 0) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        
            if (r5.d(r0) != r1) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
        
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
        
            if (r5.b(r0) == r1) goto L21;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object b(d dVar, Continuation<? super Unit> continuation) {
            b bVar;
            int i;
            if (continuation instanceof b) {
                bVar = (b) continuation;
                int i2 = bVar.c;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    bVar.c = i2 - Integer.MIN_VALUE;
                    Object obj = bVar.b;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = bVar.c;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        bVar.f5318a = dVar;
                        bVar.c = 1;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        dVar = (d) bVar.f5318a;
                        ResultKt.throwOnFailure(obj);
                    }
                    bVar.f5318a = null;
                    bVar.c = 2;
                }
            }
            bVar = new b(continuation);
            Object obj2 = bVar.b;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = bVar.c;
            if (i != 0) {
            }
            bVar.f5318a = null;
            bVar.c = 2;
        }
    }

    long a(b bVar);

    b a(long j);

    Object a(List<Long> list, Continuation<? super Unit> continuation);

    Object a(Continuation<? super List<b>> continuation);

    List<b> a();

    List<Long> a(List<b> list);

    Object b(Continuation<? super Unit> continuation);

    List<b> b();

    List<Long> b(List<b> list);

    Object c(Continuation<? super Unit> continuation);

    Object d(Continuation<? super Unit> continuation);
}
