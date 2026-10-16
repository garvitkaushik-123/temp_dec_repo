package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.w;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAd;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.internal.publisher.f, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3432f implements x {
    public static final a f = new a(null);
    public static final int g = 8;
    public static final String h = "AdLoadListenerTrackerImpl";

    /* renamed from: a, reason: collision with root package name */
    public final AdLoad.Listener f5511a;
    public final com.moloco.sdk.internal.w b;
    public final TimerEvent c;
    public final AdFormatType d;
    public final MetricsRecorder e;

    /* renamed from: com.moloco.sdk.internal.publisher.f$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public C3432f(AdLoad.Listener listener, com.moloco.sdk.internal.w sdkEventUrlTracker, TimerEvent acmLoadTimerEvent, AdFormatType adFormatType, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(sdkEventUrlTracker, "sdkEventUrlTracker");
        Intrinsics.checkNotNullParameter(acmLoadTimerEvent, "acmLoadTimerEvent");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5511a = listener;
        this.b = sdkEventUrlTracker;
        this.c = acmLoadTimerEvent;
        this.d = adFormatType;
        this.e = metricsRecorder;
    }

    @Override // com.moloco.sdk.internal.publisher.x
    public void a(MolocoAd molocoAd, long j, com.moloco.sdk.internal.ortb.model.r rVar) {
        String g2;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, h, "onAdLoadStarted: " + molocoAd + ", " + j, null, false, 12, null);
        if (rVar == null || (g2 = rVar.g()) == null) {
            return;
        }
        w.a.a(this.b, g2, j, null, 4, null);
    }

    @Override // com.moloco.sdk.internal.publisher.x
    public void a(MolocoAd molocoAd, com.moloco.sdk.internal.ortb.model.r rVar) {
        String i;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, h, "onAdLoadSuccess: " + molocoAd, null, false, 12, null);
        if (rVar != null && (i = rVar.i()) != null) {
            w.a.a(this.b, i, System.currentTimeMillis(), null, 4, null);
        }
        MetricsRecorder metricsRecorder = this.e;
        TimerEvent withTag = this.c.withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), "success");
        com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.c;
        String c = cVar.c();
        String name = this.d.name();
        Locale locale = Locale.ROOT;
        String lowerCase = name.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        metricsRecorder.recordTimerEvent(withTag.withTag(c, lowerCase));
        MetricsRecorder metricsRecorder2 = this.e;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.k.c());
        String c2 = cVar.c();
        String lowerCase2 = this.d.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        metricsRecorder2.recordCountEvent(countEvent.withTag(c2, lowerCase2));
        AdLoad.Listener listener = this.f5511a;
        if (listener != null) {
            listener.onAdLoadSuccess(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.x
    public void a(com.moloco.sdk.internal.s internalError, com.moloco.sdk.internal.ortb.model.r rVar) {
        String e;
        Intrinsics.checkNotNullParameter(internalError, "internalError");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, h, "onAdLoadFailed: " + internalError, null, false, 12, null);
        if (rVar != null && (e = rVar.e()) != null) {
            this.b.a(e, System.currentTimeMillis(), internalError);
        }
        MetricsRecorder metricsRecorder = this.e;
        TimerEvent withTag = this.c.withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), AnalyticsConstants.EVENT_FAILURE);
        com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.b;
        TimerEvent withTag2 = withTag.withTag(cVar.c(), internalError.d().a());
        com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.c;
        String c = cVar2.c();
        String name = this.d.name();
        Locale locale = Locale.ROOT;
        String lowerCase = name.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        metricsRecorder.recordTimerEvent(withTag2.withTag(c, lowerCase));
        MetricsRecorder metricsRecorder2 = this.e;
        CountEvent withTag3 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.l.c()).withTag("network", internalError.c().getNetworkName()).withTag(cVar.c(), internalError.d().a());
        String c2 = cVar2.c();
        String lowerCase2 = this.d.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        metricsRecorder2.recordCountEvent(withTag3.withTag(c2, lowerCase2));
        AdLoad.Listener listener = this.f5511a;
        if (listener != null) {
            listener.onAdLoadFailed(internalError.c());
        }
    }
}
