package io.adn.sdk.internal.ui.common.inappbrowser;

import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.model.ad.PostClickData;
import io.adn.sdk.internal.domain.repository.AdTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppBrowserTracker.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0014\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0016\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0017\u001a\u00020\u0012J'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserTracker;", "", "sessionIndex", "", "trackingUrls", "", "", "adTracker", "Lio/adn/sdk/internal/domain/repository/AdTracker;", "<init>", "(ILjava/util/List;Lio/adn/sdk/internal/domain/repository/AdTracker;)V", "currentPageIndex", "sessionStartTime", "", "isInitialPageLoaded", "", "lastVisitedUrl", "onBrowserStart", "", "url", "onPageFinished", "onPageHistoryUpdated", "onPageLoadError", "onBrowserClosed", "sendTrackingEvent", "Lkotlin/Result;", C3040d4.h.j0, "sendTrackingEvent-gIAlu-s", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InAppBrowserTracker {
    public static final int $stable = 8;
    private final AdTracker adTracker;
    private int currentPageIndex;
    private boolean isInitialPageLoaded;
    private String lastVisitedUrl;
    private final int sessionIndex;
    private final long sessionStartTime;
    private final List<String> trackingUrls;

    public InAppBrowserTracker(int i, List<String> trackingUrls, AdTracker adTracker) {
        Intrinsics.checkNotNullParameter(trackingUrls, "trackingUrls");
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        this.sessionIndex = i;
        this.trackingUrls = trackingUrls;
        this.adTracker = adTracker;
        this.sessionStartTime = System.currentTimeMillis();
    }

    public final void onBrowserStart(String url) {
        m9549sendTrackingEventgIAlus(url, "browser_started");
        this.lastVisitedUrl = url;
    }

    public final void onPageFinished(String url) {
        if (this.isInitialPageLoaded) {
            return;
        }
        this.isInitialPageLoaded = true;
        m9549sendTrackingEventgIAlus(url, "browser_loaded");
    }

    public final void onPageHistoryUpdated(String url) {
        if (this.isInitialPageLoaded) {
            this.currentPageIndex++;
            m9549sendTrackingEventgIAlus(url, "page_changed");
            this.lastVisitedUrl = url;
        }
    }

    public final void onPageLoadError(String url) {
        m9549sendTrackingEventgIAlus(url, "page_view_load_error");
    }

    public final void onBrowserClosed() {
        m9549sendTrackingEventgIAlus(this.lastVisitedUrl, "browser_closed");
    }

    /* renamed from: sendTrackingEvent-gIAlu-s, reason: not valid java name */
    private final Object m9549sendTrackingEventgIAlus(String url, String eventName) {
        try {
            Result.Companion companion = Result.INSTANCE;
            InAppBrowserTracker inAppBrowserTracker = this;
            this.adTracker.trackPostClick(this.trackingUrls, new PostClickData(eventName, this.sessionIndex, this.currentPageIndex, url, System.currentTimeMillis() - this.sessionStartTime));
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }
}
