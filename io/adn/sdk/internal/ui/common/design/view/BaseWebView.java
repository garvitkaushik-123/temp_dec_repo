package io.adn.sdk.internal.ui.common.design.view;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.webkit.WebViewClientCompat;
import com.ironsource.D5;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.adn.sdk.internal.ui.common.model.ClickPosition;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseWebView.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000fJ\u001e\u0010\u0016\u001a\u00020\u00072\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00070\u0018H\u0007J\b\u0010\u001a\u001a\u00020\u0007H\u0016¨\u0006\u001b"}, d2 = {"Lio/adn/sdk/internal/ui/common/design/view/BaseWebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "setZoomEnabled", "", "enabled", "", "setJavaScriptEnabled", "setFileAndContentAccessEnabled", "setAutoPlayMediaEnabled", "loadHtmlContent", AnalyticsConstants.CREATIVE_TYPE_HTML, "", "loadUrlContent", "url", "loadDataWithDefaultBaseUrl", "data", "sendJs", "js", "observeOnClick", "onClick", "Lkotlin/Function1;", "Lio/adn/sdk/internal/ui/common/model/ClickPosition;", "destroy", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public class BaseWebView extends WebView {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(Context context) {
        super(context.getApplicationContext());
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setZoomEnabled(boolean enabled) {
        setScrollBarStyle(0);
        setHorizontalScrollBarEnabled(enabled);
        setVerticalScrollBarEnabled(enabled);
        setScrollContainer(enabled);
        getSettings().setSupportZoom(enabled);
    }

    public final void setJavaScriptEnabled(boolean enabled) {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(enabled);
        settings.setDomStorageEnabled(enabled);
    }

    public final void setFileAndContentAccessEnabled(boolean enabled) {
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(enabled);
        settings.setAllowContentAccess(enabled);
    }

    public final void setAutoPlayMediaEnabled(boolean enabled) {
        getSettings().setMediaPlaybackRequiresUserGesture(!enabled);
    }

    public final void loadHtmlContent(String html) {
        Intrinsics.checkNotNullParameter(html, "html");
        loadDataWithDefaultBaseUrl(html);
    }

    public final void loadUrlContent(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        loadUrl(url);
    }

    private final void loadDataWithDefaultBaseUrl(String data) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            BaseWebView baseWebView = this;
            loadDataWithBaseURL("https://appassets.androidplatform.net", data, "text/html", D5.N, null);
            m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
            Log.e("WebView", m10244exceptionOrNullimpl.toString());
        }
    }

    public final void sendJs(String js) {
        Intrinsics.checkNotNullParameter(js, "js");
        if (getVisibility() == 0) {
            Log.d("WebView", "js " + js);
            loadUrl("javascript:" + js);
        }
    }

    public final void observeOnClick(final Function1<? super ClickPosition, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: io.adn.sdk.internal.ui.common.design.view.BaseWebView$observeOnClick$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                onClick.invoke(new ClickPosition((int) e.getX(), (int) e.getY()));
                return false;
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: io.adn.sdk.internal.ui.common.design.view.BaseWebView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean observeOnClick$lambda$4;
                observeOnClick$lambda$4 = BaseWebView.observeOnClick$lambda$4(gestureDetector, view, motionEvent);
                return observeOnClick$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean observeOnClick$lambda$4(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            Result.Companion companion = Result.INSTANCE;
            BaseWebView baseWebView = this;
            ViewParent parent = getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this);
            }
            removeAllViews();
            setWebViewClient(new WebViewClientCompat());
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        super.destroy();
    }
}
