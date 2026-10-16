package com.moloco.sdk.acm.eventprocessing;

import adn.analytics.Analytics;
import android.database.sqlite.SQLiteException;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.EventTag;
import com.moloco.sdk.acm.TimerEvent;
import java.util.ArrayList;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* loaded from: classes6.dex */
public final class i implements h {
    public static final a e = new a(null);
    public static final String f = "EventProcessor";

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.acm.db.d f5334a;
    public final com.moloco.sdk.acm.services.g b;
    public final l c;
    public final com.moloco.sdk.acm.services.b d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.EventProcessorImpl$processCountEvent$2", f = "EventProcessor.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5335a;
        public final /* synthetic */ CountEvent c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CountEvent countEvent, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = countEvent;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new b(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5335a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                String name = this.c.getName();
                com.moloco.sdk.acm.db.c cVar = com.moloco.sdk.acm.db.c.b;
                long countValue = this.c.getCountValue();
                List<EventTag> eventTags = this.c.getEventTags();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(eventTags, 10));
                Iterator<T> it = eventTags.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.moloco.sdk.acm.d.a((EventTag) it.next()));
                }
                this.f5335a = 1;
                if (iVar.a(name, cVar, countValue, arrayList, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.EventProcessorImpl$processEvent$2", f = "EventProcessor.kt", i = {}, l = {Analytics.AnalyticsData.EXTRA_SIGNALS_FIELD_NUMBER, Analytics.AnalyticsData.BOOT_TIME_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5336a;
        public final /* synthetic */ String b;
        public final /* synthetic */ i c;
        public final /* synthetic */ com.moloco.sdk.acm.db.c d;
        public final /* synthetic */ long e;
        public final /* synthetic */ List<String> f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, i iVar, com.moloco.sdk.acm.db.c cVar, long j, List<String> list, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = str;
            this.c = iVar;
            this.d = cVar;
            this.e = j;
            this.f = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, this.d, this.e, this.f, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0067, code lost:
        
            if (r2.a(r16) == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5336a;
            try {
            } catch (SQLiteException e) {
                com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f5359a, i.f, "Database error: " + e.getMessage(), false, 4, null);
            } catch (Exception e2) {
                com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f5359a, i.f, "Unexpected error while processing event: " + e2.getMessage(), false, 4, null);
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.c.f5334a.a(new com.moloco.sdk.acm.db.b(0L, this.b, this.c.b.invoke(), this.d, Boxing.boxLong(this.e), this.f, 1, null));
                l lVar = this.c.c;
                this.f5336a = 1;
                if (lVar.b(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.acm.services.b bVar = this.c.d;
            this.f5336a = 2;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.EventProcessorImpl$processTimerEvent$2", f = "EventProcessor.kt", i = {}, l = {58, 60}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5337a;
        public final /* synthetic */ TimerEvent b;
        public final /* synthetic */ i c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TimerEvent timerEvent, i iVar, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = timerEvent;
            this.c = iVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
        
            if (r4.a(r5, r6, r7, r9, r11) == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x00c3, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00c1, code lost:
        
            if (r1.a(r3, r3, r5, r6, r11) == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5337a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.b.getTimeInMillis() > 0) {
                    i iVar = this.c;
                    String name = this.b.getName();
                    com.moloco.sdk.acm.db.c cVar = com.moloco.sdk.acm.db.c.f5316a;
                    long timeInMillis = this.b.getTimeInMillis();
                    List<EventTag> eventTags = this.b.getEventTags();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(eventTags, 10));
                    Iterator<T> it = eventTags.iterator();
                    while (it.hasNext()) {
                        arrayList.add(com.moloco.sdk.acm.d.a((EventTag) it.next()));
                    }
                    this.f5337a = 1;
                } else {
                    i iVar2 = this.c;
                    String str = "negative_time_" + this.b.getName();
                    com.moloco.sdk.acm.db.c cVar2 = com.moloco.sdk.acm.db.c.f5316a;
                    long timeInMillis2 = this.b.getTimeInMillis();
                    List<EventTag> eventTags2 = this.b.getEventTags();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(eventTags2, 10));
                    Iterator<T> it2 = eventTags2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(com.moloco.sdk.acm.d.a((EventTag) it2.next()));
                    }
                    this.f5337a = 2;
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public i(com.moloco.sdk.acm.db.d metricsDAO, com.moloco.sdk.acm.services.g timeProviderService, l requestScheduler, com.moloco.sdk.acm.services.b applicationLifecycle) {
        Intrinsics.checkNotNullParameter(metricsDAO, "metricsDAO");
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        Intrinsics.checkNotNullParameter(requestScheduler, "requestScheduler");
        Intrinsics.checkNotNullParameter(applicationLifecycle, "applicationLifecycle");
        this.f5334a = metricsDAO;
        this.b = timeProviderService;
        this.c = requestScheduler;
        this.d = applicationLifecycle;
    }

    @Override // com.moloco.sdk.acm.eventprocessing.h
    public Object a(CountEvent countEvent, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new b(countEvent, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.acm.eventprocessing.h
    public Object a(TimerEvent timerEvent, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new d(timerEvent, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object a(String str, com.moloco.sdk.acm.db.c cVar, long j, List<String> list, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new c(str, this, cVar, j, list, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
