package io.bidmachine.rendering.internal.event;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import io.bidmachine.rendering.internal.h;
import io.bidmachine.rendering.model.EventTaskParams;
import io.bidmachine.rendering.model.EventType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0019\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001e\u0010\u0016J\u000f\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001f\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001f\u0010\u0016J\u000f\u0010 \u001a\u00020\u0014H\u0016¢\u0006\u0004\b \u0010\u0016J\u000f\u0010!\u001a\u00020\u0014H\u0016¢\u0006\u0004\b!\u0010\u0016J\u000f\u0010\"\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\"\u0010\u0016J\u000f\u0010#\u001a\u00020\u0014H\u0016¢\u0006\u0004\b#\u0010\u0016J\u000f\u0010$\u001a\u00020\u0014H\u0016¢\u0006\u0004\b$\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0016¢\u0006\u0004\b\u0019\u0010(J\u000f\u0010)\u001a\u00020\u0014H\u0016¢\u0006\u0004\b)\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010+J\u0017\u0010.\u001a\u00020\u00142\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J/\u0010\u0019\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u000e2\u0016\u00103\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010201\"\u0004\u0018\u000102H\u0007¢\u0006\u0004\b\u0019\u00104R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u00105\u001a\u0004\b6\u00107R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u00108R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u00108R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u00109R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010:R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010;R&\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010<¨\u0006="}, d2 = {"Lio/bidmachine/rendering/internal/event/c;", "Lio/bidmachine/rendering/internal/event/b;", "", "sourceName", "Lio/bidmachine/rendering/internal/event/e;", "stateGroupEventInterceptor", "animationEventInterceptor", "Lio/bidmachine/rendering/internal/event/d;", "callbackProcessor", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lio/bidmachine/rendering/internal/h;", "coroutineDispatchers", "", "Lio/bidmachine/rendering/model/EventType;", "", "Lio/bidmachine/rendering/model/EventTaskParams;", "eventTypes", "<init>", "(Ljava/lang/String;Lio/bidmachine/rendering/internal/event/e;Lio/bidmachine/rendering/internal/event/e;Lio/bidmachine/rendering/internal/event/d;Lkotlinx/coroutines/CoroutineScope;Lio/bidmachine/rendering/internal/h;Ljava/util/Map;)V", "", CampaignEx.JSON_KEY_AD_K, "()V", "", "viewId", "a", "(I)V", "senderId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/Integer;)V", InneractiveMediationDefs.GENDER_FEMALE, "d", "onClose", j.b, "i", "g", "c", "", "maxProgressMs", "currentProgressMs", "(JJ)V", "h", "url", "(Ljava/lang/String;)V", "", "useCustomClose", "onUseCustomClose", "(Z)V", "eventType", "", "", "params", "(Lio/bidmachine/rendering/model/EventType;[Ljava/lang/Object;)V", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "Lio/bidmachine/rendering/internal/event/e;", "Lio/bidmachine/rendering/internal/event/d;", "Lkotlinx/coroutines/CoroutineScope;", "Lio/bidmachine/rendering/internal/h;", "Ljava/util/Map;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String sourceName;

    /* renamed from: b, reason: from kotlin metadata */
    private final e stateGroupEventInterceptor;

    /* renamed from: c, reason: from kotlin metadata */
    private final e animationEventInterceptor;

    /* renamed from: d, reason: from kotlin metadata */
    private final d callbackProcessor;

    /* renamed from: e, reason: from kotlin metadata */
    private final CoroutineScope coroutineScope;

    /* renamed from: f, reason: from kotlin metadata */
    private final h coroutineDispatchers;

    /* renamed from: g, reason: from kotlin metadata */
    private final Map<EventType, List<EventTaskParams>> eventTypes;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.event.EventCallbackImpl$processEventTasks$1", f = "EventCallbackImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f7059a;
        final /* synthetic */ Object[] c;
        final /* synthetic */ EventType d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object[] objArr, EventType eventType, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = objArr;
            this.d = eventType;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new a(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7059a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            e eVar = c.this.animationEventInterceptor;
            List<? extends Object> mutableList = CollectionsKt.toMutableList((Collection) ArraysKt.filterNotNull(this.c));
            mutableList.add(0, this.d);
            if (eVar.a(mutableList)) {
                return Unit.INSTANCE;
            }
            List list = (List) c.this.eventTypes.get(this.d);
            if (list != null) {
                if (list.isEmpty()) {
                    list = null;
                }
                if (list != null) {
                    c cVar = c.this;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        if (!cVar.stateGroupEventInterceptor.a(((EventTaskParams) obj2).getStateGroups())) {
                            arrayList.add(obj2);
                        }
                    }
                    c cVar2 = c.this;
                    EventType eventType = this.d;
                    Object[] objArr = this.c;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        cVar2.callbackProcessor.a(eventType, (EventTaskParams) it.next(), Arrays.copyOf(objArr, objArr.length));
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String sourceName, e stateGroupEventInterceptor, e animationEventInterceptor, d callbackProcessor, CoroutineScope coroutineScope, h coroutineDispatchers, Map<EventType, ? extends List<EventTaskParams>> map) {
        Intrinsics.checkNotNullParameter(sourceName, "sourceName");
        Intrinsics.checkNotNullParameter(stateGroupEventInterceptor, "stateGroupEventInterceptor");
        Intrinsics.checkNotNullParameter(animationEventInterceptor, "animationEventInterceptor");
        Intrinsics.checkNotNullParameter(callbackProcessor, "callbackProcessor");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(coroutineDispatchers, "coroutineDispatchers");
        this.sourceName = sourceName;
        this.stateGroupEventInterceptor = stateGroupEventInterceptor;
        this.animationEventInterceptor = animationEventInterceptor;
        this.callbackProcessor = callbackProcessor;
        this.coroutineScope = coroutineScope;
        this.coroutineDispatchers = coroutineDispatchers;
        this.eventTypes = map == null ? new EnumMap(EventType.class) : map;
    }

    @Override // io.bidmachine.rendering.internal.event.b
    /* renamed from: e, reason: from getter */
    public String getSourceName() {
        return this.sourceName;
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void f() {
        a(EventType.OnPause, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void g() {
        a(EventType.OnMidpoint, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void h() {
        a(EventType.OnScheduled, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void i() {
        a(EventType.OnFirstQuartile, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void j() {
        a(EventType.OnStart, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void k() {
        a(EventType.OnImpression, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void onClose() {
        a(EventType.OnClose, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void onUseCustomClose(boolean useCustomClose) {
        a(EventType.OnUseCustomClose, Boolean.valueOf(useCustomClose));
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void a(int viewId) {
        a(EventType.OnClick, Integer.valueOf(viewId));
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void b(Integer senderId) {
        a(EventType.OnMute, senderId);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void c() {
        a(EventType.OnThirdQuartile, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void d() {
        a(EventType.OnSkip, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void a(Integer senderId) {
        a(EventType.OnUnMute, senderId);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void b() {
        a(EventType.OnResume, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void a() {
        a(EventType.OnComplete, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void a(long maxProgressMs, long currentProgressMs) {
        a(EventType.OnProgress, Long.valueOf(maxProgressMs), Long.valueOf(currentProgressMs));
    }

    @Override // io.bidmachine.rendering.internal.event.b
    public void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        a(EventType.OnNavigate, url);
    }

    public final void a(EventType eventType, Object... params) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(params, "params");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.coroutineDispatchers.b(), null, new a(params, eventType, null), 2, null);
    }
}
