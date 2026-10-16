package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers;

import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class d {
    public static final a d = new a(null);
    public static final int e = 8;
    public static final String f = "CompositeEventHandler";

    /* renamed from: a, reason: collision with root package name */
    public final Set<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> f5980a;
    public final MetricsRecorder b;
    public final Lazy c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Set<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> eventHandlers, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(eventHandlers, "eventHandlers");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5980a = eventHandlers;
        this.b = metricsRecorder;
        this.c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.d$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d.a(d.this);
            }
        });
    }

    public final Map<String, List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a>> a() {
        return (Map) this.c.getValue();
    }

    public static final Map a(d dVar) {
        Set<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> set = dVar.f5980a;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a) it.next()).a());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            String str = (String) obj;
            Set<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> set2 = dVar.f5980a;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : set2) {
                if (((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a) obj2).a().contains(str)) {
                    arrayList2.add(obj2);
                }
            }
            linkedHashMap.put(obj, arrayList2);
        }
        return linkedHashMap;
    }

    public final void a(String event) {
        TimerEvent timerEvent;
        String str;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a aVar;
        TimerEvent timerEvent2;
        Intrinsics.checkNotNullParameter(event, "event");
        TimerEvent startTimerEvent = this.b.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.s.c());
        JSONObject jSONObject = new JSONObject(event);
        String string = jSONObject.getString("event");
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.debug$default(molocoLogger, f, "Event received: " + string, false, 4, null);
        List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> list = a().get(string);
        if (list != null && !list.isEmpty()) {
            if (list.size() > 1) {
                timerEvent = startTimerEvent;
                str = AnalyticsConstants.EVENT_FAILURE;
                MolocoLogger.warn$default(molocoLogger, f, "Found multiple event handlers for event: " + string + ", using first one", null, false, 12, null);
                MetricsRecorder metricsRecorder = this.b;
                CountEvent withTag = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.H.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), str);
                Intrinsics.checkNotNull(string);
                metricsRecorder.recordCountEvent(withTag.withTag("event", string));
            } else {
                timerEvent = startTimerEvent;
                str = AnalyticsConstants.EVENT_FAILURE;
            }
            TimerEvent startTimerEvent2 = this.b.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.t.c());
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a aVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a) CollectionsKt.first((List) list);
            try {
                aVar2.a(jSONObject);
                aVar = aVar2;
            } catch (Exception e2) {
                e = e2;
                aVar = aVar2;
            }
            try {
                MolocoLogger.debug$default(molocoLogger, f, "Event handled: " + string, false, 4, null);
                MetricsRecorder metricsRecorder2 = this.b;
                Intrinsics.checkNotNull(string);
                TimerEvent withTag2 = startTimerEvent2.withTag("event", string).withTag("handler", aVar.b());
                com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
                metricsRecorder2.recordTimerEvent(withTag2.withTag(cVar.c(), "success"));
                this.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.G.c()).withTag(cVar.c(), "success").withTag("handler", aVar.b()).withTag("event", string));
                MetricsRecorder metricsRecorder3 = this.b;
                String c = cVar.c();
                timerEvent2 = timerEvent;
                try {
                    metricsRecorder3.recordTimerEvent(timerEvent2.withTag(c, "success").withTag("handler", aVar.b()).withTag("event", string));
                    return;
                } catch (Exception e3) {
                    e = e3;
                    Exception exc = e;
                    MolocoLogger.warn$default(MolocoLogger.INSTANCE, f, "Event handling failed: " + string, exc, false, 8, null);
                    MetricsRecorder metricsRecorder4 = this.b;
                    Intrinsics.checkNotNull(string);
                    TimerEvent withTag3 = startTimerEvent2.withTag("event", string).withTag("handler", aVar.b());
                    com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.b;
                    String c2 = cVar2.c();
                    String simpleName = exc.getClass().getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                    TimerEvent withTag4 = withTag3.withTag(c2, simpleName);
                    com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.d;
                    metricsRecorder4.recordTimerEvent(withTag4.withTag(cVar3.c(), str));
                    MetricsRecorder metricsRecorder5 = this.b;
                    CountEvent withTag5 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.G.c()).withTag(cVar3.c(), str);
                    String c3 = cVar2.c();
                    String simpleName2 = exc.getClass().getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
                    metricsRecorder5.recordCountEvent(withTag5.withTag(c3, simpleName2).withTag("handler", aVar.b()).withTag("event", string));
                    MetricsRecorder metricsRecorder6 = this.b;
                    TimerEvent withTag6 = timerEvent2.withTag(cVar3.c(), str);
                    String c4 = cVar2.c();
                    String simpleName3 = exc.getClass().getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName3, "getSimpleName(...)");
                    metricsRecorder6.recordTimerEvent(withTag6.withTag(c4, simpleName3).withTag("handler", aVar.b()).withTag("event", string));
                    return;
                }
            } catch (Exception e4) {
                e = e4;
                timerEvent2 = timerEvent;
                Exception exc2 = e;
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, f, "Event handling failed: " + string, exc2, false, 8, null);
                MetricsRecorder metricsRecorder42 = this.b;
                Intrinsics.checkNotNull(string);
                TimerEvent withTag32 = startTimerEvent2.withTag("event", string).withTag("handler", aVar.b());
                com.moloco.sdk.internal.client_metrics_data.c cVar22 = com.moloco.sdk.internal.client_metrics_data.c.b;
                String c22 = cVar22.c();
                String simpleName4 = exc2.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName4, "getSimpleName(...)");
                TimerEvent withTag42 = withTag32.withTag(c22, simpleName4);
                com.moloco.sdk.internal.client_metrics_data.c cVar32 = com.moloco.sdk.internal.client_metrics_data.c.d;
                metricsRecorder42.recordTimerEvent(withTag42.withTag(cVar32.c(), str));
                MetricsRecorder metricsRecorder52 = this.b;
                CountEvent withTag52 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.G.c()).withTag(cVar32.c(), str);
                String c32 = cVar22.c();
                String simpleName22 = exc2.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName22, "getSimpleName(...)");
                metricsRecorder52.recordCountEvent(withTag52.withTag(c32, simpleName22).withTag("handler", aVar.b()).withTag("event", string));
                MetricsRecorder metricsRecorder62 = this.b;
                TimerEvent withTag62 = timerEvent2.withTag(cVar32.c(), str);
                String c42 = cVar22.c();
                String simpleName32 = exc2.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName32, "getSimpleName(...)");
                metricsRecorder62.recordTimerEvent(withTag62.withTag(c42, simpleName32).withTag("handler", aVar.b()).withTag("event", string));
                return;
            }
        }
        MolocoLogger.error$default(molocoLogger, f, "Event not handled: " + string, null, false, 12, null);
        MetricsRecorder metricsRecorder7 = this.b;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.G.c());
        com.moloco.sdk.internal.client_metrics_data.c cVar4 = com.moloco.sdk.internal.client_metrics_data.c.d;
        CountEvent withTag7 = countEvent.withTag(cVar4.c(), AnalyticsConstants.EVENT_FAILURE);
        com.moloco.sdk.internal.client_metrics_data.c cVar5 = com.moloco.sdk.internal.client_metrics_data.c.b;
        CountEvent withTag8 = withTag7.withTag(cVar5.c(), "no_handler");
        Intrinsics.checkNotNull(string);
        metricsRecorder7.recordCountEvent(withTag8.withTag("event", string));
        this.b.recordTimerEvent(startTimerEvent.withTag(cVar4.c(), AnalyticsConstants.EVENT_FAILURE).withTag(cVar5.c(), "no_handler").withTag("event", string));
    }
}
