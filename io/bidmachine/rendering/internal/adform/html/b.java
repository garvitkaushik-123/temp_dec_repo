package io.bidmachine.rendering.internal.adform.html;

import android.webkit.WebView;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.mraid.MraidAdView;
import io.bidmachine.iab.mraid.MraidOrientationProperties;
import io.bidmachine.iab.mraid.MraidResizeProperties;
import io.bidmachine.iab.mraid.MraidScreenMetrics;
import io.bidmachine.rendering.internal.adform.c;
import io.bidmachine.rendering.measurer.HtmlMeasurer;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001e\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001f\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J/\u0010*\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J1\u0010.\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b0\u0010\u001cJ\u001f\u00101\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b3\u00104J\u001f\u00105\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b5\u0010!J\u0017\u00106\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b6\u0010\u001cJ\u001f\u00107\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b7\u0010!J\u001f\u00108\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b8\u0010!R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lio/bidmachine/rendering/internal/adform/html/b;", "Lio/bidmachine/iab/mraid/MraidAdView$Listener;", "Lio/bidmachine/rendering/internal/adform/html/a;", "htmlAdForm", "Lio/bidmachine/rendering/internal/adform/c;", "adFormListener", "Lio/bidmachine/rendering/internal/event/b;", "eventCallback", "Lio/bidmachine/rendering/measurer/HtmlMeasurer;", "htmlMeasurer", "<init>", "(Lio/bidmachine/rendering/internal/adform/html/a;Lio/bidmachine/rendering/internal/adform/c;Lio/bidmachine/rendering/internal/event/b;Lio/bidmachine/rendering/measurer/HtmlMeasurer;)V", "Lio/bidmachine/iab/mraid/MraidAdView;", "mraidAdView", "", "url", "Landroid/webkit/WebView;", "webView", "", "isUseCustomClose", "", "onMraidAdViewPageLoaded", "(Lio/bidmachine/iab/mraid/MraidAdView;Ljava/lang/String;Landroid/webkit/WebView;Z)V", "Lio/bidmachine/iab/IabError;", "iabError", "onMraidAdViewLoadFailed", "(Lio/bidmachine/iab/mraid/MraidAdView;Lio/bidmachine/iab/IabError;)V", "onMraidAdViewShown", "(Lio/bidmachine/iab/mraid/MraidAdView;)V", "onMraidAdViewShowFailed", "onMraidAdViewExpired", "onMraidLoadedIntention", "onOpenUrlIntention", "(Lio/bidmachine/iab/mraid/MraidAdView;Ljava/lang/String;)V", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "privacySheetParams", "onOpenPrivacySheet", "(Lio/bidmachine/iab/mraid/MraidAdView;Lio/bidmachine/rendering/model/PrivacySheetParams;)V", "Lio/bidmachine/iab/mraid/MraidResizeProperties;", "mraidResizeProperties", "Lio/bidmachine/iab/mraid/MraidScreenMetrics;", "mraidScreenMetrics", "onResizeIntention", "(Lio/bidmachine/iab/mraid/MraidAdView;Landroid/webkit/WebView;Lio/bidmachine/iab/mraid/MraidResizeProperties;Lio/bidmachine/iab/mraid/MraidScreenMetrics;)Z", "Lio/bidmachine/iab/mraid/MraidOrientationProperties;", "mraidOrientationProperties", "onExpandIntention", "(Lio/bidmachine/iab/mraid/MraidAdView;Landroid/webkit/WebView;Lio/bidmachine/iab/mraid/MraidOrientationProperties;Z)Z", "onExpanded", "onSyncCustomCloseIntention", "(Lio/bidmachine/iab/mraid/MraidAdView;Z)V", "onChangeOrientationIntention", "(Lio/bidmachine/iab/mraid/MraidAdView;Lio/bidmachine/iab/mraid/MraidOrientationProperties;)V", "onPlayVideoIntention", "onCloseIntention", "onCalendarEventIntention", "onStorePictureIntention", "a", "Lio/bidmachine/rendering/internal/adform/html/a;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/internal/adform/c;", "c", "Lio/bidmachine/rendering/internal/event/b;", "d", "Lio/bidmachine/rendering/measurer/HtmlMeasurer;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class b implements MraidAdView.Listener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a htmlAdForm;

    /* renamed from: b, reason: from kotlin metadata */
    private final c adFormListener;

    /* renamed from: c, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.event.b eventCallback;

    /* renamed from: d, reason: from kotlin metadata */
    private final HtmlMeasurer htmlMeasurer;

    public b(a htmlAdForm, c adFormListener, io.bidmachine.rendering.internal.event.b eventCallback, HtmlMeasurer htmlMeasurer) {
        Intrinsics.checkNotNullParameter(htmlAdForm, "htmlAdForm");
        Intrinsics.checkNotNullParameter(adFormListener, "adFormListener");
        Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
        this.htmlAdForm = htmlAdForm;
        this.adFormListener = adFormListener;
        this.eventCallback = eventCallback;
        this.htmlMeasurer = htmlMeasurer;
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onCalendarEventIntention(MraidAdView mraidAdView, String url) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        Intrinsics.checkNotNullParameter(url, "url");
        onOpenUrlIntention(mraidAdView, url);
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onChangeOrientationIntention(MraidAdView mraidAdView, MraidOrientationProperties mraidOrientationProperties) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        Intrinsics.checkNotNullParameter(mraidOrientationProperties, "mraidOrientationProperties");
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onCloseIntention(MraidAdView mraidAdView) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        this.eventCallback.onClose();
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public boolean onExpandIntention(MraidAdView mraidAdView, WebView webView, MraidOrientationProperties mraidOrientationProperties, boolean isUseCustomClose) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        Intrinsics.checkNotNullParameter(webView, "webView");
        return false;
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onExpanded(MraidAdView mraidAdView) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onMraidAdViewExpired(MraidAdView mraidAdView, IabError iabError) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        Intrinsics.checkNotNullParameter(iabError, "iabError");
        c cVar = this.adFormListener;
        a aVar = this.htmlAdForm;
        String message = iabError.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "iabError.message");
        cVar.b(aVar, new Error(message));
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onMraidAdViewLoadFailed(MraidAdView mraidAdView, IabError iabError) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        Intrinsics.checkNotNullParameter(iabError, "iabError");
        a aVar = this.htmlAdForm;
        String message = iabError.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "iabError.message");
        aVar.a(new Error(message));
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onMraidAdViewPageLoaded(MraidAdView mraidAdView, String url, WebView webView, boolean isUseCustomClose) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(webView, "webView");
        HtmlMeasurer htmlMeasurer = this.htmlMeasurer;
        if (htmlMeasurer != null) {
            htmlMeasurer.onViewReady(webView);
        }
        this.adFormListener.b(this.htmlAdForm);
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onMraidAdViewShowFailed(MraidAdView mraidAdView, IabError iabError) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        Intrinsics.checkNotNullParameter(iabError, "iabError");
        a aVar = this.htmlAdForm;
        String message = iabError.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "iabError.message");
        aVar.b(new Error(message));
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onMraidAdViewShown(MraidAdView mraidAdView) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onMraidLoadedIntention(MraidAdView mraidAdView) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onOpenPrivacySheet(MraidAdView mraidAdView, PrivacySheetParams privacySheetParams) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        Intrinsics.checkNotNullParameter(privacySheetParams, "privacySheetParams");
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onOpenUrlIntention(MraidAdView mraidAdView, String url) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        Intrinsics.checkNotNullParameter(url, "url");
        HtmlMeasurer htmlMeasurer = this.htmlMeasurer;
        if (htmlMeasurer != null) {
            htmlMeasurer.onClicked();
        }
        this.eventCallback.a(url);
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onPlayVideoIntention(MraidAdView mraidAdView, String url) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public boolean onResizeIntention(MraidAdView mraidAdView, WebView webView, MraidResizeProperties mraidResizeProperties, MraidScreenMetrics mraidScreenMetrics) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(mraidResizeProperties, "mraidResizeProperties");
        Intrinsics.checkNotNullParameter(mraidScreenMetrics, "mraidScreenMetrics");
        return false;
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onStorePictureIntention(MraidAdView mraidAdView, String url) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        Intrinsics.checkNotNullParameter(url, "url");
        onOpenUrlIntention(mraidAdView, url);
    }

    @Override // io.bidmachine.iab.mraid.MraidAdView.Listener
    public void onSyncCustomCloseIntention(MraidAdView mraidAdView, boolean isUseCustomClose) {
        Intrinsics.checkNotNullParameter(mraidAdView, "mraidAdView");
        this.eventCallback.onUseCustomClose(isUseCustomClose);
    }
}
