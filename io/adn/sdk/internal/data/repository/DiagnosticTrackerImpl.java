package io.adn.sdk.internal.data.repository;

import com.unity3d.services.core.di.ServiceProvider;
import io.adn.sdk.internal.data.api.local.LocalDataSource;
import io.adn.sdk.internal.data.api.remote.RemoteDataSource;
import io.adn.sdk.internal.data.mapper.DiagnosticEventMapperKt;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEvent;
import io.adn.sdk.internal.domain.repository.DiagnosticTracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: DiagnosticTrackerImpl.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u000e\u0010\u0016\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0002J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0082@¢\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\n\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000e0\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lio/adn/sdk/internal/data/repository/DiagnosticTrackerImpl;", "Lio/adn/sdk/internal/domain/repository/DiagnosticTracker;", ServiceProvider.NAMED_REMOTE, "Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "local", "Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;Lio/adn/sdk/internal/data/api/local/LocalDataSource;Lkotlinx/coroutines/CoroutineScope;)V", "eventsQueue", "", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEvent;", "kotlin.jvm.PlatformType", "", "Ljava/util/List;", "requestChannel", "Lkotlinx/coroutines/channels/Channel;", "Lio/adn/sdk/internal/data/repository/DiagnosticRequest;", "trackEvent", "", "diagnosticEvent", "flushEvents", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventsToSend", "sendEvents", "Lkotlin/Result;", "events", "sendEvents-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DiagnosticTrackerImpl implements DiagnosticTracker {
    public static final int $stable = 8;
    private final List<DiagnosticEvent> eventsQueue;
    private final LocalDataSource local;
    private final RemoteDataSource remote;
    private final Channel<DiagnosticRequest> requestChannel;

    public DiagnosticTrackerImpl(RemoteDataSource remote, LocalDataSource local, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(local, "local");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.remote = remote;
        this.local = local;
        this.eventsQueue = Collections.synchronizedList(new ArrayList());
        this.requestChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(null), 3, null);
    }

    public /* synthetic */ DiagnosticTrackerImpl(RemoteDataSource remoteDataSource, LocalDataSource localDataSource, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(remoteDataSource, localDataSource, (i & 4) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))) : coroutineScope);
    }

    /* compiled from: DiagnosticTrackerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.adn.sdk.internal.data.repository.DiagnosticTrackerImpl$1", f = "DiagnosticTrackerImpl.kt", i = {}, l = {26, 27}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.adn.sdk.internal.data.repository.DiagnosticTrackerImpl$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DiagnosticTrackerImpl.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0060, code lost:
        
            if (r6.this$0.flushEvents(r6) == r0) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0042  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0060 -> B:6:0x0015). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator it;
            ChannelIterator channelIterator;
            Object hasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = DiagnosticTrackerImpl.this.requestChannel.iterator();
                this.L$0 = it;
                this.label = 1;
                hasNext = it.hasNext(this);
                if (hasNext != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                channelIterator = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                it = channelIterator;
                this.L$0 = it;
                this.label = 1;
                hasNext = it.hasNext(this);
                if (hasNext != coroutine_suspended) {
                    channelIterator = it;
                    obj = hasNext;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = channelIterator;
                    this.label = 2;
                }
                return coroutine_suspended;
            }
            channelIterator = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.DiagnosticTracker
    public void trackEvent(DiagnosticEvent diagnosticEvent) {
        Intrinsics.checkNotNullParameter(diagnosticEvent, "diagnosticEvent");
        try {
            Result.Companion companion = Result.INSTANCE;
            DiagnosticTrackerImpl diagnosticTrackerImpl = this;
            List<DiagnosticEvent> eventsQueue = this.eventsQueue;
            Intrinsics.checkNotNullExpressionValue(eventsQueue, "eventsQueue");
            synchronized (eventsQueue) {
                this.eventsQueue.add(diagnosticEvent);
            }
            Result.m10241constructorimpl(ChannelResult.m11761boximpl(this.requestChannel.mo11746trySendJP2dKIU(new DiagnosticRequest())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(2:3|(9:5|6|7|(1:(2:10|11)(2:28|29))(3:30|31|(2:33|34)(2:35|(1:37)(1:38)))|12|(3:14|72|19)|25|26|27))|41|6|7|(0)(0)|12|(0)|25|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        kotlin.Result.m10241constructorimpl(kotlin.ResultKt.createFailure(r5));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b A[Catch: all -> 0x008a, TryCatch #0 {all -> 0x008a, blocks: (B:11:0x002e, B:12:0x0065, B:14:0x006b, B:15:0x0072, B:18:0x007d, B:22:0x0080, B:23:0x0081, B:25:0x0082, B:31:0x0043, B:33:0x0052, B:35:0x0055, B:17:0x0073), top: B:7:0x0022, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object flushEvents(Continuation<? super Unit> continuation) {
        DiagnosticTrackerImpl$flushEvents$1 diagnosticTrackerImpl$flushEvents$1;
        int i;
        List<DiagnosticEvent> list;
        Object obj;
        DiagnosticTrackerImpl diagnosticTrackerImpl;
        if (continuation instanceof DiagnosticTrackerImpl$flushEvents$1) {
            diagnosticTrackerImpl$flushEvents$1 = (DiagnosticTrackerImpl$flushEvents$1) continuation;
            if ((diagnosticTrackerImpl$flushEvents$1.label & Integer.MIN_VALUE) != 0) {
                diagnosticTrackerImpl$flushEvents$1.label -= Integer.MIN_VALUE;
                Object obj2 = diagnosticTrackerImpl$flushEvents$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = diagnosticTrackerImpl$flushEvents$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Result.Companion companion = Result.INSTANCE;
                    DiagnosticTrackerImpl diagnosticTrackerImpl2 = this;
                    List<DiagnosticEvent> eventsToSend = getEventsToSend();
                    if (eventsToSend.isEmpty()) {
                        return Unit.INSTANCE;
                    }
                    diagnosticTrackerImpl$flushEvents$1.L$0 = this;
                    diagnosticTrackerImpl$flushEvents$1.L$1 = eventsToSend;
                    diagnosticTrackerImpl$flushEvents$1.label = 1;
                    Object m9480sendEventsgIAlus = m9480sendEventsgIAlus(eventsToSend, diagnosticTrackerImpl$flushEvents$1);
                    if (m9480sendEventsgIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list = eventsToSend;
                    obj = m9480sendEventsgIAlus;
                    diagnosticTrackerImpl = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) diagnosticTrackerImpl$flushEvents$1.L$1;
                    diagnosticTrackerImpl = (DiagnosticTrackerImpl) diagnosticTrackerImpl$flushEvents$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    obj = ((Result) obj2).getValue();
                }
                if (Result.m10244exceptionOrNullimpl(obj) != null) {
                    List<DiagnosticEvent> eventsQueue = diagnosticTrackerImpl.eventsQueue;
                    Intrinsics.checkNotNullExpressionValue(eventsQueue, "eventsQueue");
                    synchronized (eventsQueue) {
                        diagnosticTrackerImpl.eventsQueue.addAll(0, list);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                Result.m10241constructorimpl(Result.m10240boximpl(obj));
                return Unit.INSTANCE;
            }
        }
        diagnosticTrackerImpl$flushEvents$1 = new DiagnosticTrackerImpl$flushEvents$1(this, continuation);
        Object obj22 = diagnosticTrackerImpl$flushEvents$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = diagnosticTrackerImpl$flushEvents$1.label;
        if (i != 0) {
        }
        if (Result.m10244exceptionOrNullimpl(obj) != null) {
        }
        Result.m10241constructorimpl(Result.m10240boximpl(obj));
        return Unit.INSTANCE;
    }

    private final List<DiagnosticEvent> getEventsToSend() {
        ArrayList arrayList;
        List<DiagnosticEvent> eventsQueue = this.eventsQueue;
        Intrinsics.checkNotNullExpressionValue(eventsQueue, "eventsQueue");
        synchronized (eventsQueue) {
            int min = Math.min(this.eventsQueue.size(), 6);
            ArrayList arrayList2 = new ArrayList(min);
            for (int i = 0; i < min; i++) {
                arrayList2.add(this.eventsQueue.remove(0));
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* renamed from: sendEvents-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9480sendEventsgIAlus(List<DiagnosticEvent> list, Continuation<? super Result<Unit>> continuation) {
        DiagnosticTrackerImpl$sendEvents$1 diagnosticTrackerImpl$sendEvents$1;
        int i;
        try {
            if (continuation instanceof DiagnosticTrackerImpl$sendEvents$1) {
                diagnosticTrackerImpl$sendEvents$1 = (DiagnosticTrackerImpl$sendEvents$1) continuation;
                if ((diagnosticTrackerImpl$sendEvents$1.label & Integer.MIN_VALUE) != 0) {
                    diagnosticTrackerImpl$sendEvents$1.label -= Integer.MIN_VALUE;
                    Object obj = diagnosticTrackerImpl$sendEvents$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = diagnosticTrackerImpl$sendEvents$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Result.Companion companion = Result.INSTANCE;
                        DiagnosticTrackerImpl diagnosticTrackerImpl = this;
                        RemoteDataSource remoteDataSource = this.remote;
                        List<DiagnosticEvent> list2 = list;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(DiagnosticEventMapperKt.mapToDiagnosticEventBody((DiagnosticEvent) it.next(), this.local));
                        }
                        diagnosticTrackerImpl$sendEvents$1.label = 1;
                        if (remoteDataSource.sendDiagnosticEvents(arrayList, diagnosticTrackerImpl$sendEvents$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Result.m10241constructorimpl(Unit.INSTANCE);
                }
            }
            if (i != 0) {
            }
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        diagnosticTrackerImpl$sendEvents$1 = new DiagnosticTrackerImpl$sendEvents$1(this, continuation);
        Object obj2 = diagnosticTrackerImpl$sendEvents$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = diagnosticTrackerImpl$sendEvents$1.label;
    }
}
