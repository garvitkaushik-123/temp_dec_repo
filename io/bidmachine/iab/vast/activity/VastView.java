package io.bidmachine.iab.vast.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.ironsource.D5;
import io.bidmachine.iab.CacheControl;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.measurer.MraidAdMeasurer;
import io.bidmachine.iab.measurer.VastAdMeasurer;
import io.bidmachine.iab.mraid.MraidInterstitial;
import io.bidmachine.iab.mraid.MraidInterstitialListener;
import io.bidmachine.iab.utils.Assets;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.iab.utils.IabCloseWrapper;
import io.bidmachine.iab.utils.IabCountDownWrapper;
import io.bidmachine.iab.utils.IabCtaWrapper;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.utils.IabElementWrapper;
import io.bidmachine.iab.utils.IabLoadingWrapper;
import io.bidmachine.iab.utils.IabMuteWrapper;
import io.bidmachine.iab.utils.IabProgressWrapper;
import io.bidmachine.iab.utils.IabRepeatWrapper;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.vast.TrackingEvent;
import io.bidmachine.iab.vast.VastExtension;
import io.bidmachine.iab.vast.VastHelper;
import io.bidmachine.iab.vast.VastLog;
import io.bidmachine.iab.vast.VastPlaybackListener;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VastRequestManager;
import io.bidmachine.iab.vast.VastSpecError;
import io.bidmachine.iab.vast.VastVideoLoadedListener;
import io.bidmachine.iab.vast.VastViewListener;
import io.bidmachine.iab.vast.VideoType;
import io.bidmachine.iab.vast.processor.VastAd;
import io.bidmachine.iab.vast.tags.AppodealExtensionTag;
import io.bidmachine.iab.vast.tags.CompanionTag;
import io.bidmachine.iab.vast.tags.PostBannerTag;
import io.bidmachine.iab.vast.view.IabVideoTexture;
import io.bidmachine.iab.view.CloseableLayout;
import io.bidmachine.rendering.model.PrivacySheetParams;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class VastView extends RelativeLayout implements IabClickCallback {
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private final List<View> O;
    private final List<IabElementWrapper<? extends View>> P;
    private final Runnable Q;
    private final Runnable R;
    private final A S;
    private final A T;
    private final LinkedList<Integer> U;
    private int V;
    private float W;

    /* renamed from: a, reason: collision with root package name */
    private final String f6887a;
    private final A a0;
    IabVideoTexture b;
    private final TextureView.SurfaceTextureListener b0;
    FrameLayout c;
    private final MediaPlayer.OnCompletionListener c0;
    Surface d;
    private final MediaPlayer.OnErrorListener d0;
    FrameLayout e;
    private final MediaPlayer.OnPreparedListener e0;
    CloseableLayout f;
    private final MediaPlayer.OnVideoSizeChangedListener f0;
    IabCloseWrapper g;
    private VastHelper.OnScreenStateChangeListener g0;
    IabCountDownWrapper h;
    private final View.OnTouchListener h0;
    IabRepeatWrapper i;
    private final WebChromeClient i0;
    IabMuteWrapper j;
    private final WebViewClient j0;
    IabLoadingWrapper k;
    IabProgressWrapper l;
    IabCtaWrapper m;
    MediaPlayer n;
    View o;
    CompanionTag p;
    CompanionTag q;
    ImageView r;
    MraidInterstitial s;
    VastRequest t;
    B u;
    private VastViewListener v;
    private VastPlaybackListener w;
    private VastAdMeasurer x;
    private MraidAdMeasurer y;
    private y z;

    private interface A {
        void a(int durationMs, int currentPositionMs, float percent);
    }

    private static class PostBannerAdMeasurer implements MraidAdMeasurer {

        /* renamed from: a, reason: collision with root package name */
        private final VastView f6889a;
        private final MraidAdMeasurer b;

        public PostBannerAdMeasurer(VastView vastView, MraidAdMeasurer mraidAdMeasurer) {
            this.f6889a = vastView;
            this.b = mraidAdMeasurer;
        }

        @Override // io.bidmachine.iab.measurer.AdMeasurer
        public void onAdClicked() {
            this.b.onAdClicked();
        }

        @Override // io.bidmachine.iab.measurer.AdMeasurer
        public void onAdShown() {
            this.b.onAdShown();
        }

        @Override // io.bidmachine.iab.measurer.AdMeasurer
        public void onError(IabError iabError) {
            this.b.onError(iabError);
        }

        @Override // io.bidmachine.iab.measurer.MraidAdMeasurer
        public String prepareCreativeForMeasure(String html) {
            return this.b.prepareCreativeForMeasure(html);
        }

        @Override // io.bidmachine.iab.measurer.AdMeasurer
        public void registerAdContainer(ViewGroup container) {
            this.b.registerAdContainer(this.f6889a);
        }

        @Override // io.bidmachine.iab.measurer.AdMeasurer
        public void onAdViewReady(WebView webView) {
            this.b.onAdViewReady(webView);
        }

        @Override // io.bidmachine.iab.measurer.AdMeasurer
        public void registerAdView(WebView webView) {
            this.b.registerAdView(webView);
        }
    }

    /* renamed from: io.bidmachine.iab.vast.activity.VastView$a, reason: case insensitive filesystem */
    class RunnableC3586a implements Runnable {
        RunnableC3586a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VastView.this.isPlaybackStarted()) {
                VastView.this.d();
            }
        }
    }

    /* renamed from: io.bidmachine.iab.vast.activity.VastView$b, reason: case insensitive filesystem */
    class RunnableC3587b implements Runnable {
        RunnableC3587b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (VastView.this.isPlaybackStarted() && VastView.this.n.isPlaying()) {
                    int duration = VastView.this.n.getDuration();
                    int currentPosition = VastView.this.n.getCurrentPosition();
                    if (currentPosition > 0) {
                        float f = (currentPosition * 100.0f) / duration;
                        VastView.this.S.a(duration, currentPosition, f);
                        VastView.this.T.a(duration, currentPosition, f);
                        VastView.this.a0.a(duration, currentPosition, f);
                        if (f > 105.0f) {
                            VastLog.e(VastView.this.f6887a, "Playback tracking: video hang detected", new Object[0]);
                            VastView.this.g();
                        }
                    }
                }
            } catch (Exception e) {
                VastLog.e(VastView.this.f6887a, "Playback tracking exception: %s", e.getMessage());
            }
            VastView.this.postDelayed(this, 16L);
        }
    }

    class c implements A {
        c() {
        }

        @Override // io.bidmachine.iab.vast.activity.VastView.A
        public void a(int durationMs, int currentPositionMs, float percent) {
            IabCountDownWrapper iabCountDownWrapper;
            VastView vastView = VastView.this;
            B b = vastView.u;
            if (b.i || b.b == 0.0f || !vastView.a(vastView.t)) {
                return;
            }
            VastView vastView2 = VastView.this;
            float f = vastView2.u.b * 1000.0f;
            float f2 = currentPositionMs;
            float f3 = f - f2;
            int i = (int) ((f2 * 100.0f) / f);
            VastLog.d(vastView2.f6887a, "Skip percent: %s", Integer.valueOf(i));
            if (i < 100 && (iabCountDownWrapper = VastView.this.h) != null) {
                iabCountDownWrapper.changePercentage(i, (int) Math.ceil(f3 / 1000.0d));
            }
            if (f3 <= 0.0f) {
                VastView vastView3 = VastView.this;
                B b2 = vastView3.u;
                b2.b = 0.0f;
                b2.i = true;
                vastView3.setCloseControlsVisible(true);
            }
        }
    }

    class d implements A {
        d() {
        }

        @Override // io.bidmachine.iab.vast.activity.VastView.A
        public void a(int durationMs, int currentPositionMs, float percent) {
            VastView vastView = VastView.this;
            B b = vastView.u;
            if (b.h && b.c == 3) {
                return;
            }
            if (vastView.t.getMaxDurationMillis() > 0 && currentPositionMs > VastView.this.t.getMaxDurationMillis() && VastView.this.t.getVideoType() == VideoType.Rewarded) {
                VastView vastView2 = VastView.this;
                vastView2.u.i = true;
                vastView2.setCloseControlsVisible(true);
            }
            VastView vastView3 = VastView.this;
            int i = vastView3.u.c;
            if (percent > i * 25.0f) {
                if (i == 3) {
                    VastLog.d(vastView3.f6887a, "Video at third quartile: (%s)", Float.valueOf(percent));
                    VastView.this.c(TrackingEvent.thirdQuartile);
                    if (VastView.this.w != null) {
                        VastView.this.w.onVideoThirdQuartile();
                    }
                } else if (i == 0) {
                    VastLog.d(vastView3.f6887a, "Video at start: (%s)", Float.valueOf(percent));
                    VastView.this.c(TrackingEvent.start);
                    if (VastView.this.w != null) {
                        VastView.this.w.onVideoStarted(durationMs, VastView.this.u.f ? 0.0f : 1.0f);
                    }
                } else if (i == 1) {
                    VastLog.d(vastView3.f6887a, "Video at first quartile: (%s)", Float.valueOf(percent));
                    VastView.this.c(TrackingEvent.firstQuartile);
                    if (VastView.this.w != null) {
                        VastView.this.w.onVideoFirstQuartile();
                    }
                } else if (i == 2) {
                    VastLog.d(vastView3.f6887a, "Video at midpoint: (%s)", Float.valueOf(percent));
                    VastView.this.c(TrackingEvent.midpoint);
                    if (VastView.this.w != null) {
                        VastView.this.w.onVideoMidpoint();
                    }
                }
                VastView.this.u.c++;
            }
        }
    }

    class e implements A {
        e() {
        }

        @Override // io.bidmachine.iab.vast.activity.VastView.A
        public void a(int durationMs, int currentPositionMs, float percent) {
            if (VastView.this.U.size() == 2 && ((Integer) VastView.this.U.getFirst()).intValue() > ((Integer) VastView.this.U.getLast()).intValue()) {
                VastLog.e(VastView.this.f6887a, "Playing progressing error: seek", new Object[0]);
                VastView.this.U.removeFirst();
            }
            if (VastView.this.U.size() == 19) {
                Integer num = (Integer) VastView.this.U.getFirst();
                int intValue = num.intValue();
                Integer num2 = (Integer) VastView.this.U.getLast();
                int intValue2 = num2.intValue();
                VastLog.d(VastView.this.f6887a, "Playing progressing position: last=%d, first=%d)", num2, num);
                if (intValue2 > intValue) {
                    VastView.this.U.removeFirst();
                } else {
                    VastView.l(VastView.this);
                    if (VastView.this.V >= 3) {
                        VastView.this.c(IabError.internal("Playing progressing error: video hang detected"));
                        return;
                    }
                }
            }
            try {
                VastView.this.U.addLast(Integer.valueOf(currentPositionMs));
                if (durationMs == 0 || currentPositionMs <= 0) {
                    return;
                }
                VastView vastView = VastView.this;
                if (vastView.l != null) {
                    VastLog.d(vastView.f6887a, "Playing progressing percent: %s", Float.valueOf(percent));
                    if (VastView.this.W < percent) {
                        VastView.this.W = percent;
                        int i = durationMs / 1000;
                        VastView.this.l.changePercentage(percent, Math.min(i, (int) Math.ceil(currentPositionMs / 1000.0f)), i);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    class f implements TextureView.SurfaceTextureListener {
        f() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            VastLog.d(VastView.this.f6887a, "onSurfaceTextureAvailable", new Object[0]);
            VastView.this.d = new Surface(surface);
            VastView.this.G = true;
            if (VastView.this.H) {
                VastView.this.H = false;
                VastView.this.startPlayback("onSurfaceTextureAvailable");
            } else if (VastView.this.isPlaybackStarted()) {
                VastView vastView = VastView.this;
                vastView.n.setSurface(vastView.d);
                VastView.this.r();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            VastLog.d(VastView.this.f6887a, "onSurfaceTextureDestroyed", new Object[0]);
            VastView vastView = VastView.this;
            vastView.d = null;
            vastView.G = false;
            if (VastView.this.isPlaybackStarted()) {
                VastView.this.n.setSurface(null);
                VastView.this.l();
            }
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            VastLog.d(VastView.this.f6887a, "onSurfaceTextureSizeChanged: %d/%d", Integer.valueOf(width), Integer.valueOf(height));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        }
    }

    class g implements MediaPlayer.OnCompletionListener {
        g() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mp) {
            VastLog.d(VastView.this.f6887a, "MediaPlayer - onCompletion", new Object[0]);
            VastView.this.g();
        }
    }

    class h implements MediaPlayer.OnErrorListener {
        h() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mp, int what, int extra) {
            VastView.this.c(IabError.internal(String.format("MediaPlayer - onError: what - %s, extra - %s", Integer.valueOf(what), Integer.valueOf(extra))));
            return true;
        }
    }

    class i implements MediaPlayer.OnPreparedListener {
        i() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(final MediaPlayer mp) {
            VastLog.d(VastView.this.f6887a, "MediaPlayer - onPrepared", new Object[0]);
            VastView vastView = VastView.this;
            if (vastView.u.j) {
                return;
            }
            vastView.c(TrackingEvent.creativeView);
            VastView.this.c(TrackingEvent.fullscreen);
            VastView.this.y();
            VastView.this.setLoadingViewVisibility(false);
            VastView.this.J = true;
            if (!VastView.this.u.g) {
                mp.start();
                VastView.this.u();
            }
            VastView.this.x();
            int i = VastView.this.u.d;
            if (i > 0) {
                mp.seekTo(i);
                VastView.this.c(TrackingEvent.resume);
                if (VastView.this.w != null) {
                    VastView.this.w.onVideoResumed();
                }
            }
            VastView vastView2 = VastView.this;
            if (!vastView2.u.m) {
                vastView2.l();
            }
            VastView vastView3 = VastView.this;
            if (vastView3.u.k) {
                return;
            }
            vastView3.h();
            if (VastView.this.t.shouldPreloadCompanion()) {
                VastView.this.a(false);
            }
        }
    }

    class j implements MediaPlayer.OnVideoSizeChangedListener {
        j() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
            VastLog.d(VastView.this.f6887a, "onVideoSizeChanged", new Object[0]);
            VastView.this.C = width;
            VastView.this.D = height;
            VastView.this.d();
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (VastView.this.isPlaybackStarted() || VastView.this.u.j) {
                VastView.this.t();
            }
        }
    }

    class l implements VastHelper.OnScreenStateChangeListener {
        l() {
        }

        @Override // io.bidmachine.iab.vast.VastHelper.OnScreenStateChangeListener
        public void onScreenStateChange(boolean isScreenOn) {
            VastView.this.z();
        }
    }

    class m implements View.OnTouchListener {
        m() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            if (action != 0 && action != 1) {
                return false;
            }
            VastView.this.O.add(v);
            if (v.hasFocus()) {
                return false;
            }
            v.requestFocus();
            return false;
        }
    }

    class n extends WebChromeClient {
        n() {
        }

        private boolean a(JsResult result) {
            result.cancel();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            VastLog.d("JS alert", message, new Object[0]);
            return a(result);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            VastLog.d("JS confirm", message, new Object[0]);
            return a(result);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            VastLog.d("JS prompt", message, new Object[0]);
            return a(result);
        }
    }

    class p implements VastVideoLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f6905a;
        final /* synthetic */ CacheControl b;

        p(final boolean val$restoring, final CacheControl val$cacheControl) {
            this.f6905a = val$restoring;
            this.b = val$cacheControl;
        }

        @Override // io.bidmachine.iab.vast.VastVideoLoadedListener
        public void onError(VastRequest vastRequest, IabError iabError) {
            VastView vastView = VastView.this;
            vastView.b(vastView.v, vastRequest, IabError.placeholder(String.format("Error loading video after showing with %s - %s", this.b, iabError)));
        }

        @Override // io.bidmachine.iab.vast.VastVideoLoadedListener
        public void onSuccess(VastRequest vastRequest, VastAd vastAd) {
            VastView.this.a(vastRequest, vastAd, this.f6905a);
        }
    }

    class q implements CloseableLayout.OnCloseClickListener {
        q() {
        }

        @Override // io.bidmachine.iab.view.CloseableLayout.OnCloseClickListener
        public void onCloseClick() {
            VastView vastView = VastView.this;
            vastView.b(vastView.v, VastView.this.t, IabError.placeholder("Close button clicked"));
        }

        @Override // io.bidmachine.iab.view.CloseableLayout.OnCloseClickListener
        public void onCountDownFinish() {
        }
    }

    class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            VastView.this.i();
        }
    }

    class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            VastRequest vastRequest = VastView.this.t;
            if (vastRequest != null && vastRequest.isR1()) {
                VastView vastView = VastView.this;
                if (!vastView.u.l && vastView.i()) {
                    return;
                }
            }
            if (VastView.this.I) {
                VastView.this.e();
            } else {
                VastView.this.handleBackPress();
            }
        }
    }

    class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            VastView.this.A();
        }
    }

    class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            VastView.this.q();
        }
    }

    class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            VastView.this.i();
        }
    }

    class w extends y {
        final /* synthetic */ WeakReference f;

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VastView.this.i();
                VastView.this.e();
            }
        }

        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                VastView.this.c.setVisibility(8);
            }
        }

        class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VastView.this.i();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(Context context, Uri fileUri, String networkUrl, final WeakReference val$targetViewReference) {
            super(context, fileUri, networkUrl);
            this.f = val$targetViewReference;
        }

        @Override // io.bidmachine.iab.vast.activity.VastView.y
        void a(final Bitmap result) {
            ImageView imageView = (ImageView) this.f.get();
            if (imageView != null) {
                if (result == null) {
                    imageView.setOnClickListener(new a());
                    return;
                }
                imageView.setImageBitmap(result);
                imageView.setAlpha(0.0f);
                imageView.animate().alpha(1.0f).setDuration(100L).setListener(new b()).start();
                imageView.setOnClickListener(new c());
            }
        }
    }

    private final class x implements MraidInterstitialListener {
        private x() {
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onCalendarEvent(MraidInterstitial mraidInterstitial, String url, IabClickCallback iabClickCallback) {
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onClose(MraidInterstitial mraidInterstitial) {
            VastView.this.f();
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onExpired(MraidInterstitial mraidInterstitial, IabError iabError) {
            VastView.this.a(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onLoadFailed(MraidInterstitial mraidInterstitial, IabError iabError) {
            VastView.this.b(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onLoaded(MraidInterstitial mraidInterstitial) {
            VastView vastView = VastView.this;
            if (vastView.u.j) {
                vastView.setLoadingViewVisibility(false);
                mraidInterstitial.showInView(VastView.this, false);
            }
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onOpenPrivacySheet(MraidInterstitial mraidInterstitial, PrivacySheetParams privacySheetParams) {
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onOpenUrl(MraidInterstitial mraidInterstitial, String url, IabClickCallback iabClickCallback) {
            iabClickCallback.clickHandled();
            VastView vastView = VastView.this;
            vastView.a(vastView.q, url);
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onPlayVideo(MraidInterstitial mraidInterstitial, String url) {
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onShowFailed(MraidInterstitial mraidInterstitial, IabError iabError) {
            VastView.this.b(iabError);
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onShown(MraidInterstitial mraidInterstitial) {
        }

        @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
        public void onStorePicture(MraidInterstitial mraidInterstitial, String url, IabClickCallback iabClickCallback) {
        }

        /* synthetic */ x(VastView vastView, k kVar) {
            this();
        }
    }

    private static abstract class y extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Context> f6916a;
        private final Uri b;
        private final String c;
        private Bitmap d;
        private boolean e;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                y yVar = y.this;
                yVar.a(yVar.d);
            }
        }

        y(Context context, Uri fileUri, String networkUrl) {
            this.f6916a = new WeakReference<>(context);
            this.b = fileUri;
            this.c = networkUrl;
            if (networkUrl == null && (fileUri == null || TextUtils.isEmpty(fileUri.getPath()) || !new File(fileUri.getPath()).exists())) {
                a((Bitmap) null);
            } else {
                start();
            }
        }

        abstract void a(Bitmap result);

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Context context = this.f6916a.get();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (context != null) {
                try {
                    Uri uri = this.b;
                    if (uri != null) {
                        mediaMetadataRetriever.setDataSource(context, uri);
                    } else {
                        String str = this.c;
                        if (str != null) {
                            mediaMetadataRetriever.setDataSource(str, new HashMap());
                        }
                    }
                    this.d = mediaMetadataRetriever.getFrameAtTime((Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) / 2) * 1000, 2);
                } catch (Exception e) {
                    VastLog.e("MediaFrameRetriever", e.getMessage(), new Object[0]);
                }
            }
            try {
                mediaMetadataRetriever.release();
            } catch (IOException e2) {
                VastLog.e("MediaFrameRetriever", e2.getMessage(), new Object[0]);
            }
            if (this.e) {
                return;
            }
            Utils.onUiThread(new a());
        }

        void a() {
            this.e = true;
        }
    }

    public VastView(Context context) {
        this(context, null);
    }

    private int getAvailableHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getAvailableWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    static /* synthetic */ int l(VastView vastView) {
        int i2 = vastView.V;
        vastView.V = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCloseControlsVisible(boolean visible) {
        this.L = visible;
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingViewVisibility(boolean visible) {
        IabLoadingWrapper iabLoadingWrapper = this.k;
        if (iabLoadingWrapper == null) {
            return;
        }
        if (!visible) {
            iabLoadingWrapper.setVisibility(8);
        } else {
            iabLoadingWrapper.setVisibility(0);
            this.k.bringToFront();
        }
    }

    private void setMute(boolean isMuted) {
        this.u.f = isMuted;
        x();
        c(this.u.f ? TrackingEvent.mute : TrackingEvent.unmute);
    }

    private void setPlaceholderViewVisible(boolean visible) {
        CloseableLayout closeableLayout = this.f;
        VastRequest vastRequest = this.t;
        closeableLayout.setCloseVisibility(visible, vastRequest != null ? vastRequest.getPlaceholderTimeoutSec() : 3.0f);
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        super.addView(child);
        this.e.bringToFront();
    }

    @Override // io.bidmachine.iab.utils.IabClickCallback
    public void clickHandleCanceled() {
        if (isCompanionShown()) {
            setLoadingViewVisibility(false);
        } else {
            r();
        }
    }

    @Override // io.bidmachine.iab.utils.IabClickCallback
    public void clickHandleError() {
        if (isPlaybackStarted()) {
            r();
        } else if (isCompanionShown()) {
            f();
        } else {
            s();
        }
    }

    @Override // io.bidmachine.iab.utils.IabClickCallback
    public void clickHandled() {
        if (isCompanionShown()) {
            setLoadingViewVisibility(false);
        } else if (this.E) {
            r();
        } else {
            l();
        }
    }

    public void destroy() {
        MraidInterstitial mraidInterstitial = this.s;
        if (mraidInterstitial != null) {
            mraidInterstitial.destroy();
            this.s = null;
            this.q = null;
        }
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        y yVar = this.z;
        if (yVar != null) {
            yVar.a();
            this.z = null;
        }
    }

    public boolean display(VastRequest vastRequest, Boolean isFullscreen) {
        return a(vastRequest, isFullscreen, false);
    }

    public VastViewListener getListener() {
        return this.v;
    }

    public void handleBackPress() {
        if (this.f.isVisible() && this.f.canBeClosed()) {
            b(this.v, this.t, IabError.placeholder("OnBackPress event fired"));
            return;
        }
        if (isSkipEnabled()) {
            if (!isCompanionShown()) {
                m();
                return;
            }
            VastRequest vastRequest = this.t;
            if (vastRequest == null || vastRequest.getVideoType() != VideoType.NonRewarded) {
                return;
            }
            if (this.q == null) {
                e();
                return;
            }
            MraidInterstitial mraidInterstitial = this.s;
            if (mraidInterstitial != null) {
                mraidInterstitial.dispatchClose();
            } else {
                f();
            }
        }
    }

    public boolean isCompanionShown() {
        return this.u.j;
    }

    public boolean isFinished() {
        VastRequest vastRequest = this.t;
        if (vastRequest == null) {
            return false;
        }
        if (vastRequest.getCompanionCloseTime() == 0.0f && this.u.h) {
            return true;
        }
        return this.t.getCompanionCloseTime() > 0.0f && this.u.j;
    }

    public boolean isFullscreen() {
        return this.u.e;
    }

    public boolean isLoaded() {
        VastRequest vastRequest = this.t;
        return (vastRequest == null || vastRequest.getVastAd() == null) ? false : true;
    }

    public boolean isPlaybackStarted() {
        return this.n != null && this.J;
    }

    public boolean isSkipEnabled() {
        B b = this.u;
        return b.i || b.b == 0.0f;
    }

    public boolean isVideoFileLoaded() {
        VastRequest vastRequest = this.t;
        return vastRequest != null && vastRequest.checkFile();
    }

    public void mute() {
        setMute(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.E) {
            startPlayback("onAttachedToWindow");
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (isLoaded()) {
            i(this.t.getVastAd().getAppodealExtension());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopPlayback();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof z)) {
            super.onRestoreInstanceState(state);
            return;
        }
        z zVar = (z) state;
        super.onRestoreInstanceState(zVar.getSuperState());
        B b = zVar.f6918a;
        if (b != null) {
            this.u = b;
        }
        VastRequest vastRequest = VastRequestManager.get(this.u.f6888a);
        if (vastRequest != null) {
            a(vastRequest, (Boolean) null, true);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        if (isPlaybackStarted()) {
            this.u.d = this.n.getCurrentPosition();
        }
        z zVar = new z(super.onSaveInstanceState());
        zVar.f6918a = this.u;
        return zVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w2, int h2, int oldw, int oldh) {
        super.onSizeChanged(w2, h2, oldw, oldh);
        removeCallbacks(this.Q);
        post(this.Q);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        VastLog.d(this.f6887a, "onWindowFocusChanged: %s", Boolean.valueOf(hasWindowFocus));
        this.E = hasWindowFocus;
        z();
    }

    public void pause() {
        setCanAutoResume(false);
        l();
    }

    public void resume() {
        setCanAutoResume(true);
        r();
    }

    public void setAdMeasurer(VastAdMeasurer vastAdMeasurer) {
        this.x = vastAdMeasurer;
    }

    public void setCanAutoResume(boolean canAutoResume) {
        this.M = canAutoResume;
        this.u.m = canAutoResume;
    }

    public void setCanIgnorePostBanner(boolean canIgnorePostBanner) {
        this.N = canIgnorePostBanner;
        this.u.n = canIgnorePostBanner;
    }

    public void setListener(VastViewListener listener) {
        this.v = listener;
    }

    public void setPlaybackListener(VastPlaybackListener playbackListener) {
        this.w = playbackListener;
    }

    public void setPostBannerAdMeasurer(MraidAdMeasurer mraidAdMeasurer) {
        this.y = mraidAdMeasurer != null ? new PostBannerAdMeasurer(this, mraidAdMeasurer) : null;
    }

    public void startPlayback(String who) {
        VastLog.d(this.f6887a, "startPlayback: %s", who);
        if (isLoaded()) {
            setPlaceholderViewVisible(false);
            if (this.u.j) {
                s();
                return;
            }
            if (!this.E) {
                this.F = true;
                return;
            }
            if (this.G) {
                stopPlayback();
                k();
                d();
                n();
                VastHelper.addScreenStateChangeListener(this, this.g0);
            } else {
                this.H = true;
            }
            if (this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
        }
    }

    public void stopPlayback() {
        this.u.g = false;
        if (this.n != null) {
            VastLog.d(this.f6887a, "stopPlayback", new Object[0]);
            try {
                if (this.n.isPlaying()) {
                    this.n.stop();
                }
                this.n.setSurface(null);
                this.n.release();
            } catch (Exception e2) {
                VastLog.e(this.f6887a, e2);
            }
            this.n = null;
            this.J = false;
            this.K = false;
            c();
            VastHelper.removeScreenStateChangeListener(this);
        }
    }

    public void unmute() {
        setMute(false);
    }

    public VastView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        setMute(!this.u.f);
    }

    private void g(VastExtension extension) {
        if (extension != null && !extension.getProgressStyle().isVisible().booleanValue()) {
            IabProgressWrapper iabProgressWrapper = this.l;
            if (iabProgressWrapper != null) {
                iabProgressWrapper.detach();
                return;
            }
            return;
        }
        if (this.l == null) {
            IabProgressWrapper iabProgressWrapper2 = new IabProgressWrapper(null);
            this.l = iabProgressWrapper2;
            this.P.add(iabProgressWrapper2);
        }
        this.l.attach(getContext(), this.e, a(extension, extension != null ? extension.getProgressStyle() : null));
        this.l.changePercentage(0.0f, 0, 0);
    }

    private void h(VastExtension extension) {
        if (extension == null || !extension.getRepeatStyle().isVisible().booleanValue()) {
            IabRepeatWrapper iabRepeatWrapper = this.i;
            if (iabRepeatWrapper != null) {
                iabRepeatWrapper.detach();
                return;
            }
            return;
        }
        if (this.i == null) {
            IabRepeatWrapper iabRepeatWrapper2 = new IabRepeatWrapper(new u());
            this.i = iabRepeatWrapper2;
            this.P.add(iabRepeatWrapper2);
        }
        this.i.attach(getContext(), this.e, a(extension, extension.getRepeatStyle()));
    }

    private void i(VastExtension extension) {
        IabElementStyle iabElementStyle;
        IabElementStyle copyWith = extension != null ? Assets.DEF_VIDEO_STYLE.copyWith(extension.getVideoStyle()) : Assets.DEF_VIDEO_STYLE;
        if (extension == null || !extension.isVideoClickable()) {
            this.c.setOnClickListener(null);
            this.c.setClickable(false);
        } else {
            this.c.setOnClickListener(new v());
        }
        this.c.setBackgroundColor(copyWith.getFillColor().intValue());
        o();
        if (this.p == null || this.u.j) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.c.setLayoutParams(layoutParams);
            return;
        }
        this.o = a(getContext(), this.p);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.o.getLayoutParams());
        if ("inline".equals(copyWith.getStyle())) {
            iabElementStyle = Assets.DEF_INLINE_BANNER_STYLE;
            if (getResources().getConfiguration().orientation == 2) {
                layoutParams2.addRule(15);
                layoutParams3.height = -1;
                layoutParams3.addRule(10);
                layoutParams3.addRule(12);
                if (copyWith.getHorizontalPosition().intValue() == 3) {
                    layoutParams2.addRule(9);
                    layoutParams2.addRule(0, this.o.getId());
                    layoutParams3.addRule(11);
                } else {
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(1, this.o.getId());
                    layoutParams3.addRule(9);
                }
            } else {
                layoutParams2.addRule(14);
                layoutParams3.width = -1;
                layoutParams3.addRule(9);
                layoutParams3.addRule(11);
                if (copyWith.getVerticalPosition().intValue() == 48) {
                    layoutParams2.addRule(10);
                    layoutParams2.addRule(2, this.o.getId());
                    layoutParams3.addRule(12);
                } else {
                    layoutParams2.addRule(12);
                    layoutParams2.addRule(3, this.o.getId());
                    layoutParams3.addRule(10);
                }
            }
        } else {
            IabElementStyle iabElementStyle2 = Assets.DEF_BANNER_STYLE;
            layoutParams2.addRule(13);
            iabElementStyle = iabElementStyle2;
        }
        if (extension != null) {
            iabElementStyle = iabElementStyle.copyWith(extension.getCtaStyle());
        }
        iabElementStyle.applyPadding(getContext(), this.o);
        iabElementStyle.applyMargin(getContext(), layoutParams3);
        iabElementStyle.applyRelativeAlignment(layoutParams3);
        this.o.setBackgroundColor(iabElementStyle.getFillColor().intValue());
        copyWith.applyPadding(getContext(), this.c);
        copyWith.applyMargin(getContext(), layoutParams2);
        this.c.setLayoutParams(layoutParams2);
        addView(this.o, layoutParams3);
        a(TrackingEvent.creativeView);
    }

    private void j() {
        VastLog.d(this.f6887a, "finishVideoPlaying", new Object[0]);
        stopPlayback();
        VastRequest vastRequest = this.t;
        if (vastRequest == null || vastRequest.isAutoClose() || !(this.t.getVastAd().getAppodealExtension() == null || this.t.getVastAd().getAppodealExtension().getPostBannerTag().isVisible())) {
            e();
            return;
        }
        if (isSkipEnabled()) {
            c(TrackingEvent.close);
        }
        setLoadingViewVisibility(false);
        o();
        s();
    }

    private void k() {
        if (this.r != null) {
            p();
        } else {
            MraidInterstitial mraidInterstitial = this.s;
            if (mraidInterstitial != null) {
                mraidInterstitial.destroy();
                this.s = null;
                this.q = null;
            }
        }
        this.I = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!isPlaybackStarted() || this.u.g) {
            return;
        }
        VastLog.d(this.f6887a, "pausePlayback", new Object[0]);
        B b = this.u;
        b.g = true;
        b.d = this.n.getCurrentPosition();
        this.n.pause();
        c();
        a();
        c(TrackingEvent.pause);
        VastPlaybackListener vastPlaybackListener = this.w;
        if (vastPlaybackListener != null) {
            vastPlaybackListener.onVideoPaused();
        }
    }

    private void m() {
        VastLog.e(this.f6887a, "performVideoCloseClick", new Object[0]);
        stopPlayback();
        if (this.K) {
            e();
            return;
        }
        if (!this.u.h) {
            c(TrackingEvent.skip);
            VastPlaybackListener vastPlaybackListener = this.w;
            if (vastPlaybackListener != null) {
                vastPlaybackListener.onVideoSkipped();
            }
        }
        VastRequest vastRequest = this.t;
        if (vastRequest != null && vastRequest.getVideoType() == VideoType.Rewarded) {
            VastPlaybackListener vastPlaybackListener2 = this.w;
            if (vastPlaybackListener2 != null) {
                vastPlaybackListener2.onVideoCompleted();
            }
            VastViewListener vastViewListener = this.v;
            if (vastViewListener != null) {
                vastViewListener.onComplete(this, this.t);
            }
        }
        j();
    }

    private void n() {
        try {
            if (!isLoaded() || this.u.j) {
                return;
            }
            if (this.n == null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.n = mediaPlayer;
                mediaPlayer.setLooping(false);
                this.n.setAudioStreamType(3);
                this.n.setOnCompletionListener(this.c0);
                this.n.setOnErrorListener(this.d0);
                this.n.setOnPreparedListener(this.e0);
                this.n.setOnVideoSizeChangedListener(this.f0);
            }
            this.n.setSurface(this.d);
            Uri fileUri = isVideoFileLoaded() ? this.t.getFileUri() : null;
            if (fileUri == null) {
                setLoadingViewVisibility(true);
                this.n.setDataSource(this.t.getVastAd().getPickedMediaFileTag().getText());
            } else {
                setLoadingViewVisibility(false);
                this.n.setDataSource(getContext(), fileUri);
            }
            this.n.prepareAsync();
        } catch (Exception e2) {
            VastLog.e(this.f6887a, e2);
            c(IabError.throwable("Exception during preparing MediaPlayer", e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        View view = this.o;
        if (view != null) {
            Utils.removeFromParent(view);
            this.o = null;
        }
    }

    private void p() {
        if (this.r != null) {
            b();
            removeView(this.r);
            this.r = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (isLoaded()) {
            B b = this.u;
            b.j = false;
            b.d = 0;
            k();
            i(this.t.getVastAd().getAppodealExtension());
            startPlayback("restartPlayback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        B b = this.u;
        if (!b.m) {
            if (isPlaybackStarted()) {
                this.n.start();
                this.n.pause();
                setLoadingViewVisibility(false);
                return;
            } else {
                if (this.u.j) {
                    return;
                }
                startPlayback("resumePlayback (canAutoResume: false)");
                return;
            }
        }
        if (b.g && this.E) {
            VastLog.d(this.f6887a, "resumePlayback", new Object[0]);
            this.u.g = false;
            if (!isPlaybackStarted()) {
                if (this.u.j) {
                    return;
                }
                startPlayback("resumePlayback");
                return;
            }
            this.n.start();
            y();
            u();
            setLoadingViewVisibility(false);
            c(TrackingEvent.resume);
            VastPlaybackListener vastPlaybackListener = this.w;
            if (vastPlaybackListener != null) {
                vastPlaybackListener.onVideoResumed();
            }
        }
    }

    private void s() {
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Iterator<IabElementWrapper<? extends View>> it = this.P.iterator();
        while (it.hasNext()) {
            it.next().toggleShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        v();
        c();
        this.R.run();
    }

    private void v() {
        this.U.clear();
        this.V = 0;
        this.W = 0.0f;
    }

    private void w() {
        boolean z2;
        boolean z3;
        if (this.L) {
            z2 = true;
            if (isSkipEnabled() || this.I) {
                z3 = false;
            } else {
                z3 = true;
                z2 = false;
            }
        } else {
            z3 = false;
            z2 = false;
        }
        IabCloseWrapper iabCloseWrapper = this.g;
        if (iabCloseWrapper != null) {
            iabCloseWrapper.setVisibility(z2 ? 0 : 8);
        }
        IabCountDownWrapper iabCountDownWrapper = this.h;
        if (iabCountDownWrapper != null) {
            iabCountDownWrapper.setVisibility(z3 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        IabMuteWrapper iabMuteWrapper;
        if (!isPlaybackStarted() || (iabMuteWrapper = this.j) == null) {
            return;
        }
        iabMuteWrapper.setMuted(this.u.f);
        if (this.u.f) {
            this.n.setVolume(0.0f, 0.0f);
            VastPlaybackListener vastPlaybackListener = this.w;
            if (vastPlaybackListener != null) {
                vastPlaybackListener.onVideoVolumeChanged(0.0f);
                return;
            }
            return;
        }
        this.n.setVolume(1.0f, 1.0f);
        VastPlaybackListener vastPlaybackListener2 = this.w;
        if (vastPlaybackListener2 != null) {
            vastPlaybackListener2.onVideoVolumeChanged(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (isLoaded()) {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (!this.E || !VastHelper.isScreenOn(getContext())) {
            l();
            return;
        }
        if (this.F) {
            this.F = false;
            startPlayback("onWindowFocusChanged");
        } else if (this.u.j) {
            setLoadingViewVisibility(false);
        } else {
            r();
        }
    }

    static class z extends View.BaseSavedState {
        public static final Parcelable.Creator<z> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        B f6918a;

        class a implements Parcelable.Creator<z> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public z createFromParcel(Parcel in) {
                return new z(in);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public z[] newArray(int size) {
                return new z[size];
            }
        }

        z(Parcel source) {
            super(source);
            this.f6918a = (B) source.readParcelable(B.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeParcelable(this.f6918a, 0);
        }

        z(Parcelable superState) {
            super(superState);
        }
    }

    public VastView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f6887a = "VastView-" + Integer.toHexString(hashCode());
        this.u = new B();
        this.A = 0;
        this.B = 0;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = true;
        this.N = false;
        this.O = new ArrayList();
        this.P = new ArrayList();
        this.Q = new RunnableC3586a();
        this.R = new RunnableC3587b();
        this.S = new c();
        this.T = new d();
        this.U = new LinkedList<>();
        this.V = 0;
        this.W = 0.0f;
        this.a0 = new e();
        f fVar = new f();
        this.b0 = fVar;
        this.c0 = new g();
        this.d0 = new h();
        this.e0 = new i();
        this.f0 = new j();
        this.g0 = new l();
        this.h0 = new m();
        this.i0 = new n();
        this.j0 = new o();
        setBackgroundColor(-16777216);
        setOnClickListener(new k());
        IabVideoTexture iabVideoTexture = new IabVideoTexture(context);
        this.b = iabVideoTexture;
        iabVideoTexture.setSurfaceTextureListener(fVar);
        FrameLayout frameLayout = new FrameLayout(context);
        this.c = frameLayout;
        frameLayout.addView(this.b, new FrameLayout.LayoutParams(-1, -1, 17));
        addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.e = frameLayout2;
        frameLayout2.setBackgroundColor(0);
        addView(this.e, new ViewGroup.LayoutParams(-1, -1));
        CloseableLayout closeableLayout = new CloseableLayout(getContext());
        this.f = closeableLayout;
        closeableLayout.setBackgroundColor(0);
        addView(this.f, new ViewGroup.LayoutParams(-1, -1));
    }

    private void d(VastExtension extension) {
        if (extension != null && !extension.getLoadingStyle().isVisible().booleanValue()) {
            IabLoadingWrapper iabLoadingWrapper = this.k;
            if (iabLoadingWrapper != null) {
                iabLoadingWrapper.detach();
                return;
            }
            return;
        }
        if (this.k == null) {
            this.k = new IabLoadingWrapper(null);
        }
        this.k.attach(getContext(), this, a(extension, extension != null ? extension.getLoadingStyle() : null));
    }

    private void e(VastExtension extension) {
        if (extension != null && !extension.getMuteStyle().isVisible().booleanValue()) {
            IabMuteWrapper iabMuteWrapper = this.j;
            if (iabMuteWrapper != null) {
                iabMuteWrapper.detach();
                return;
            }
            return;
        }
        if (this.j == null) {
            IabMuteWrapper iabMuteWrapper2 = new IabMuteWrapper(new t());
            this.j = iabMuteWrapper2;
            this.P.add(iabMuteWrapper2);
        }
        this.j.attach(getContext(), this.e, a(extension, extension != null ? extension.getMuteStyle() : null));
    }

    private void f(VastExtension extension) {
        this.f.setCountDownStyle(a(extension, extension != null ? extension.getCountDownStyle() : null));
        if (isFullscreen()) {
            this.f.setCloseStyle(a(extension, extension != null ? extension.getCloseStyle() : null));
            this.f.setCloseClickListener(new q());
        }
        d(extension);
    }

    class o extends WebViewClient {
        o() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            view.setBackgroundColor(0);
            view.setLayerType(1, null);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
            VastView.this.o();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (request.hasGesture()) {
                VastView.this.O.add(view);
            }
            return shouldOverrideUrlLoading(view, request.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!VastView.this.O.contains(view)) {
                return true;
            }
            VastLog.d(VastView.this.f6887a, "banner clicked", new Object[0]);
            VastView vastView = VastView.this;
            vastView.a(vastView.p, url);
            return true;
        }
    }

    private void c(VastExtension extension) {
        if (extension == null || !extension.isVideoClickable()) {
            return;
        }
        this.P.clear();
    }

    private void b(VastExtension extension) {
        if (extension != null && !extension.getCountDownStyle().isVisible().booleanValue()) {
            IabCountDownWrapper iabCountDownWrapper = this.h;
            if (iabCountDownWrapper != null) {
                iabCountDownWrapper.detach();
                return;
            }
            return;
        }
        if (this.h == null) {
            IabCountDownWrapper iabCountDownWrapper2 = new IabCountDownWrapper(null);
            this.h = iabCountDownWrapper2;
            this.P.add(iabCountDownWrapper2);
        }
        this.h.attach(getContext(), this.e, a(extension, extension != null ? extension.getCountDownStyle() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IabError iabError) {
        VastLog.e(this.f6887a, "handlePlaybackError - %s", iabError);
        this.K = true;
        a(VastSpecError.SHOWING);
        a(this.v, this.t, iabError);
        j();
    }

    private boolean a(final VastRequest vastRequest, final Boolean isFullscreen, final boolean restoring) {
        stopPlayback();
        if (!restoring) {
            this.u = new B();
        }
        if (isFullscreen != null) {
            this.u.e = isFullscreen.booleanValue();
        }
        this.t = vastRequest;
        if (vastRequest == null) {
            e();
            VastLog.e(this.f6887a, "VastRequest is null. Stop playing...", new Object[0]);
            return false;
        }
        VastAd vastAd = vastRequest.getVastAd();
        if (vastAd == null) {
            e();
            VastLog.e(this.f6887a, "VastAd is null. Stop playing...", new Object[0]);
            return false;
        }
        CacheControl cacheControl = vastRequest.getCacheControl();
        if (cacheControl == CacheControl.PartialLoad && !isVideoFileLoaded()) {
            a(vastRequest, vastAd, cacheControl, restoring);
            return true;
        }
        if (cacheControl == CacheControl.Stream && !isVideoFileLoaded()) {
            a(vastRequest, vastAd, cacheControl, restoring);
            vastRequest.performCache(getContext().getApplicationContext(), null);
            return true;
        }
        a(vastRequest, vastAd, restoring);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(TrackingEvent trackingEvent) {
        VastLog.d(this.f6887a, "Track Event: %s", trackingEvent);
        VastRequest vastRequest = this.t;
        VastAd vastAd = vastRequest != null ? vastRequest.getVastAd() : null;
        if (vastAd != null) {
            a(vastAd.getTrackingEventListMap(), trackingEvent);
        }
    }

    static class B implements Parcelable {
        public static final Parcelable.Creator<B> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f6888a;
        float b;
        int c;
        int d;
        boolean e;
        boolean f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        boolean n;

        class a implements Parcelable.Creator<B> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public B createFromParcel(Parcel in) {
                return new B(in);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public B[] newArray(int size) {
                return new B[size];
            }
        }

        B() {
            this.f6888a = null;
            this.b = 5.0f;
            this.c = 0;
            this.d = 0;
            this.e = true;
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = false;
            this.l = false;
            this.m = true;
            this.n = false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f6888a);
            parcel.writeFloat(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        }

        B(Parcel in) {
            this.f6888a = null;
            this.b = 5.0f;
            this.c = 0;
            this.d = 0;
            this.e = true;
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = false;
            this.l = false;
            this.m = true;
            this.n = false;
            this.f6888a = in.readString();
            this.b = in.readFloat();
            this.c = in.readInt();
            this.d = in.readInt();
            this.e = in.readByte() != 0;
            this.f = in.readByte() != 0;
            this.g = in.readByte() != 0;
            this.h = in.readByte() != 0;
            this.i = in.readByte() != 0;
            this.j = in.readByte() != 0;
            this.k = in.readByte() != 0;
            this.l = in.readByte() != 0;
            this.m = in.readByte() != 0;
            this.n = in.readByte() != 0;
        }
    }

    private void c() {
        removeCallbacks(this.R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        VastLog.d(this.f6887a, "handleImpressions", new Object[0]);
        VastRequest vastRequest = this.t;
        if (vastRequest != null) {
            this.u.k = true;
            a(vastRequest.getVastAd().getImpressionUrlList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i2;
        int i3 = this.C;
        if (i3 != 0 && (i2 = this.D) != 0) {
            this.b.setVideoSize(i3, i2);
        } else {
            VastLog.d(this.f6887a, "configureVideoSurface - skip: videoWidth or videoHeight is 0", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        VastLog.d(this.f6887a, "handleComplete", new Object[0]);
        B b = this.u;
        b.i = true;
        if (!this.K && !b.h) {
            b.h = true;
            VastPlaybackListener vastPlaybackListener = this.w;
            if (vastPlaybackListener != null) {
                vastPlaybackListener.onVideoCompleted();
            }
            VastViewListener vastViewListener = this.v;
            if (vastViewListener != null) {
                vastViewListener.onComplete(this, this.t);
            }
            VastRequest vastRequest = this.t;
            if (vastRequest != null && vastRequest.isR2() && !this.u.l) {
                i();
            }
            c(TrackingEvent.complete);
        }
        if (this.u.h) {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(VastViewListener vastViewListener, VastRequest vastRequest, IabError iabError) {
        a(vastViewListener, vastRequest, iabError);
        if (vastViewListener == null || vastRequest == null) {
            return;
        }
        vastViewListener.onFinish(this, vastRequest, false);
    }

    private void b(boolean forceNativeCompanion) {
        VastView vastView;
        VastViewListener vastViewListener;
        if (!isLoaded() || this.I) {
            return;
        }
        this.I = true;
        this.u.j = true;
        int i2 = getResources().getConfiguration().orientation;
        int i3 = this.B;
        if (i2 != i3 && (vastViewListener = this.v) != null) {
            vastViewListener.onOrientationRequested(this, this.t, i3);
        }
        IabProgressWrapper iabProgressWrapper = this.l;
        if (iabProgressWrapper != null) {
            iabProgressWrapper.detach();
        }
        IabMuteWrapper iabMuteWrapper = this.j;
        if (iabMuteWrapper != null) {
            iabMuteWrapper.detach();
        }
        IabRepeatWrapper iabRepeatWrapper = this.i;
        if (iabRepeatWrapper != null) {
            iabRepeatWrapper.detach();
        }
        a();
        if (this.u.n) {
            if (this.r == null) {
                this.r = a(getContext());
            }
            this.r.setImageBitmap(this.b.getBitmap());
            addView(this.r, new FrameLayout.LayoutParams(-1, -1));
            this.e.bringToFront();
            return;
        }
        a(forceNativeCompanion);
        if (this.q == null) {
            setCloseControlsVisible(true);
            if (this.r != null) {
                vastView = this;
                vastView.z = vastView.new w(getContext(), this.t.getFileUri(), this.t.getVastAd().getPickedMediaFileTag().getText(), new WeakReference(this.r));
            } else {
                vastView = this;
            }
            addView(vastView.r, new FrameLayout.LayoutParams(-1, -1));
        } else {
            vastView = this;
            setCloseControlsVisible(false);
            vastView.c.setVisibility(8);
            o();
            IabCtaWrapper iabCtaWrapper = vastView.m;
            if (iabCtaWrapper != null) {
                iabCtaWrapper.setVisibility(8);
            }
            MraidInterstitial mraidInterstitial = vastView.s;
            if (mraidInterstitial != null) {
                if (mraidInterstitial.isReady()) {
                    setLoadingViewVisibility(false);
                    vastView.s.showInView(this, false);
                } else {
                    setLoadingViewVisibility(true);
                }
            } else {
                setLoadingViewVisibility(false);
                b(IabError.internal("CompanionInterstitial is null"));
            }
        }
        stopPlayback();
        vastView.e.bringToFront();
        b(TrackingEvent.creativeView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        VastRequest vastRequest;
        VastLog.e(this.f6887a, "handleCompanionClose", new Object[0]);
        b(TrackingEvent.close);
        VastViewListener vastViewListener = this.v;
        if (vastViewListener == null || (vastRequest = this.t) == null) {
            return;
        }
        vastViewListener.onFinish(this, vastRequest, isFinished());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        VastRequest vastRequest;
        VastLog.e(this.f6887a, "handleClose", new Object[0]);
        c(TrackingEvent.close);
        VastViewListener vastViewListener = this.v;
        if (vastViewListener == null || (vastRequest = this.t) == null) {
            return;
        }
        vastViewListener.onFinish(this, vastRequest, isFinished());
    }

    private void a(VastRequest vastRequest, VastAd vastAd, CacheControl cacheControl, boolean restoring) {
        vastRequest.setVastVideoLoadedListener(new p(restoring, cacheControl));
        f(vastAd.getAppodealExtension());
        setPlaceholderViewVisible(true);
        setLoadingViewVisibility(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VastRequest vastRequest, VastAd vastAd, boolean restoring) {
        int i2;
        AppodealExtensionTag appodealExtension = vastAd.getAppodealExtension();
        this.A = vastRequest.getPreferredVideoOrientation();
        if (appodealExtension != null && appodealExtension.getCtaStyle().isVisible().booleanValue()) {
            this.p = appodealExtension.getCompanionTag();
        } else {
            this.p = null;
        }
        if (this.p == null) {
            this.p = vastAd.getBanner(getContext());
        }
        i(appodealExtension);
        a(appodealExtension, this.o != null);
        a(appodealExtension);
        b(appodealExtension);
        e(appodealExtension);
        h(appodealExtension);
        g(appodealExtension);
        d(appodealExtension);
        c(appodealExtension);
        setLoadingViewVisibility(false);
        VastAdMeasurer vastAdMeasurer = this.x;
        if (vastAdMeasurer != null) {
            vastAdMeasurer.registerAdContainer(this);
            this.x.registerAdView(this.b);
        }
        VastViewListener vastViewListener = this.v;
        if (vastViewListener != null) {
            if (this.u.j) {
                i2 = this.B;
            } else {
                i2 = this.A;
            }
            vastViewListener.onOrientationRequested(this, vastRequest, i2);
        }
        if (!restoring) {
            this.u.f6888a = vastRequest.getId();
            B b = this.u;
            b.m = this.M;
            b.n = this.N;
            if (appodealExtension != null) {
                b.f = appodealExtension.isMuted();
            }
            this.u.b = vastRequest.getFusedVideoCloseTimeSec();
            VastAdMeasurer vastAdMeasurer2 = this.x;
            if (vastAdMeasurer2 != null) {
                vastAdMeasurer2.onAdViewReady(this.b);
                this.x.onAdShown();
            }
            VastViewListener vastViewListener2 = this.v;
            if (vastViewListener2 != null) {
                vastViewListener2.onShown(this, vastRequest);
            }
        }
        setCloseControlsVisible(a(vastRequest));
        startPlayback("load (restoring: " + restoring + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        VastLog.e(this.f6887a, "handleInfoClicked", new Object[0]);
        VastRequest vastRequest = this.t;
        if (vastRequest != null) {
            return a(vastRequest.getVastAd().getClickTrackingUrlList(), this.t.getVastAd().getClickThroughUrl());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(VastRequest vastRequest) {
        return vastRequest.getVideoType() != VideoType.Rewarded || vastRequest.getMaxDurationMillis() <= 0;
    }

    private void a(VastExtension extension, boolean hasBanner) {
        if (!hasBanner && (extension == null || extension.getCtaStyle().isVisible().booleanValue())) {
            if (this.m == null) {
                IabCtaWrapper iabCtaWrapper = new IabCtaWrapper(new r());
                this.m = iabCtaWrapper;
                this.P.add(iabCtaWrapper);
            }
            this.m.attach(getContext(), this.e, a(extension, extension != null ? extension.getCtaStyle() : null));
            return;
        }
        IabCtaWrapper iabCtaWrapper2 = this.m;
        if (iabCtaWrapper2 != null) {
            iabCtaWrapper2.detach();
        }
    }

    private void b() {
        y yVar = this.z;
        if (yVar != null) {
            yVar.a();
            this.z = null;
        }
    }

    private void a(VastExtension extension) {
        if (extension != null && !extension.getCloseStyle().isVisible().booleanValue()) {
            IabCloseWrapper iabCloseWrapper = this.g;
            if (iabCloseWrapper != null) {
                iabCloseWrapper.detach();
                return;
            }
            return;
        }
        if (this.g == null) {
            IabCloseWrapper iabCloseWrapper2 = new IabCloseWrapper(new s());
            this.g = iabCloseWrapper2;
            this.P.add(iabCloseWrapper2);
        }
        this.g.attach(getContext(), this.e, a(extension, extension != null ? extension.getCloseStyle() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(IabError iabError) {
        VastRequest vastRequest;
        VastLog.e(this.f6887a, "handleCompanionShowError - %s", iabError);
        a(VastSpecError.GENERAL_COMPANION);
        a(this.v, this.t, iabError);
        if (this.q != null) {
            k();
            b(true);
            return;
        }
        VastViewListener vastViewListener = this.v;
        if (vastViewListener == null || (vastRequest = this.t) == null) {
            return;
        }
        vastViewListener.onFinish(this, vastRequest, isFinished());
    }

    private void b(TrackingEvent trackingEvent) {
        VastLog.d(this.f6887a, "Track Companion Event: %s", trackingEvent);
        CompanionTag companionTag = this.q;
        if (companionTag != null) {
            a(companionTag.getTrackingEventListMap(), trackingEvent);
        }
    }

    private IabElementStyle a(VastExtension extension, IabElementStyle style) {
        if (extension == null) {
            return null;
        }
        if (style == null) {
            IabElementStyle iabElementStyle = new IabElementStyle();
            iabElementStyle.setStrokeColor(extension.getAssetsColor());
            iabElementStyle.setFillColor(extension.getAssetsBackgroundColor());
            return iabElementStyle;
        }
        if (!style.hasStrokeColor()) {
            style.setStrokeColor(extension.getAssetsColor());
        }
        if (!style.hasFillColor()) {
            style.setFillColor(extension.getAssetsBackgroundColor());
        }
        return style;
    }

    private View a(Context context, CompanionTag bannerTag) {
        float f2;
        float f3;
        boolean isTablet = Utils.isTablet(context);
        if (bannerTag.getWidth() > 0) {
            f2 = bannerTag.getWidth();
        } else {
            f2 = isTablet ? 728.0f : 320.0f;
        }
        int dpToPx = Utils.dpToPx(context, f2);
        if (bannerTag.getHeight() > 0) {
            f3 = bannerTag.getHeight();
        } else {
            f3 = isTablet ? 90.0f : 50.0f;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dpToPx, Utils.dpToPx(context, f3));
        WebView webView = new WebView(context);
        webView.setId(Utils.generateViewId());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollContainer(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setScrollBarStyle(33554432);
        webView.setFocusableInTouchMode(false);
        webView.setBackgroundColor(0);
        webView.setOnTouchListener(this.h0);
        webView.setWebViewClient(this.j0);
        webView.setWebChromeClient(this.i0);
        String html = bannerTag.getHtml();
        if (html != null) {
            webView.loadDataWithBaseURL("", html, "text/html", D5.N, null);
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(Utils.generateViewId());
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.addView(webView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean forceNativeCompanion) {
        if (isLoaded()) {
            k kVar = null;
            if (!forceNativeCompanion) {
                CompanionTag companion = this.t.getVastAd().getCompanion(getAvailableWidth(), getAvailableHeight());
                if (this.q != companion) {
                    if (companion != null && this.t.shouldUseScreenSizeForCompanionOrientation()) {
                        this.B = Utils.orientationBySize(companion.getWidth(), companion.getHeight());
                    } else {
                        this.B = this.A;
                    }
                    this.q = companion;
                    MraidInterstitial mraidInterstitial = this.s;
                    if (mraidInterstitial != null) {
                        mraidInterstitial.destroy();
                        this.s = null;
                    }
                }
            }
            if (this.q == null) {
                if (this.r == null) {
                    this.r = a(getContext());
                    return;
                }
                return;
            }
            if (this.s == null) {
                p();
                String htmlForMraid = this.q.getHtmlForMraid();
                if (htmlForMraid != null) {
                    AppodealExtensionTag appodealExtension = this.t.getVastAd().getAppodealExtension();
                    PostBannerTag postBannerTag = appodealExtension != null ? appodealExtension.getPostBannerTag() : null;
                    MraidInterstitial.Builder listener = MraidInterstitial.newBuilder().setBaseUrl(null).setCacheControl(CacheControl.FullLoad).setCloseTime(this.t.getCompanionCloseTime()).forceUseNativeCloseButton(this.t.isForceUseNativeCloseTime()).setIsTag(false).setAdMeasurer(this.y).setListener(new x(this, kVar));
                    if (postBannerTag != null) {
                        listener.setCloseStyle(postBannerTag.getCloseStyle());
                        listener.setCountDownStyle(postBannerTag.getCountDownStyle());
                        listener.setLoadingStyle(postBannerTag.getLoadingStyle());
                        listener.setProgressStyle(postBannerTag.getProgressStyle());
                        listener.setDurationSec(postBannerTag.getDurationSec());
                        listener.setProductLink(postBannerTag.getProductLink());
                        if (postBannerTag.isForceUseNativeClose()) {
                            listener.forceUseNativeCloseButton(true);
                        }
                        listener.setR1(postBannerTag.isR1());
                        listener.setR2(postBannerTag.isR2());
                    }
                    try {
                        MraidInterstitial build = listener.build(getContext());
                        this.s = build;
                        build.load(htmlForMraid);
                        return;
                    } catch (Throwable th) {
                        b(IabError.throwable("Exception during companion creation", th));
                        return;
                    }
                }
                b(IabError.badContent("Companion creative is null"));
            }
        }
    }

    private ImageView a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }

    private void a() {
        Iterator<IabElementWrapper<? extends View>> it = this.P.iterator();
        while (it.hasNext()) {
            it.next().cancelHide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IabError iabError) {
        VastLog.e(this.f6887a, "handleCompanionExpired - %s", iabError);
        a(VastSpecError.GENERAL_COMPANION);
        if (this.q != null) {
            k();
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(CompanionTag companionTag, String clickThroughUrl) {
        VastRequest vastRequest = this.t;
        ArrayList arrayList = null;
        VastAd vastAd = vastRequest != null ? vastRequest.getVastAd() : null;
        ArrayList<String> wrapperCompanionClickTrackingUrlList = vastAd != null ? vastAd.getWrapperCompanionClickTrackingUrlList() : null;
        List<String> companionClickTrackingList = companionTag != null ? companionTag.getCompanionClickTrackingList() : null;
        if (wrapperCompanionClickTrackingUrlList != null || companionClickTrackingList != null) {
            arrayList = new ArrayList();
            if (companionClickTrackingList != null) {
                arrayList.addAll(companionClickTrackingList);
            }
            if (wrapperCompanionClickTrackingUrlList != null) {
                arrayList.addAll(wrapperCompanionClickTrackingUrlList);
            }
        }
        return a(arrayList, clickThroughUrl);
    }

    private boolean a(List<String> trackingUrls, String clickThroughUrl) {
        VastLog.d(this.f6887a, "processClickThroughEvent: %s", clickThroughUrl);
        this.u.l = true;
        if (clickThroughUrl == null) {
            return false;
        }
        a(trackingUrls);
        VastAdMeasurer vastAdMeasurer = this.x;
        if (vastAdMeasurer != null) {
            vastAdMeasurer.onAdClicked();
        }
        if (this.v != null && this.t != null) {
            l();
            setLoadingViewVisibility(true);
            this.v.onClick(this, this.t, this, clickThroughUrl);
        }
        return true;
    }

    private void a(TrackingEvent trackingEvent) {
        VastLog.d(this.f6887a, "Track Banner Event: %s", trackingEvent);
        CompanionTag companionTag = this.p;
        if (companionTag != null) {
            a(companionTag.getTrackingEventListMap(), trackingEvent);
        }
    }

    private void a(Map<TrackingEvent, List<String>> eventListMap, TrackingEvent trackingEvent) {
        if (eventListMap != null && !eventListMap.isEmpty()) {
            a(eventListMap.get(trackingEvent));
        } else {
            VastLog.d(this.f6887a, "Processing Event - fail: %s (tracking event map is null or empty)", trackingEvent);
        }
    }

    private void a(List<String> urls) {
        if (isLoaded()) {
            if (urls != null && !urls.isEmpty()) {
                this.t.fireUrls(urls, null);
            } else {
                VastLog.d(this.f6887a, "\turl list is null", new Object[0]);
            }
        }
    }

    private void a(VastViewListener vastViewListener, VastRequest vastRequest, IabError iabError) {
        if (vastViewListener == null || vastRequest == null) {
            return;
        }
        vastViewListener.onShowFailed(this, vastRequest, iabError);
    }

    private void a(VastSpecError vastSpecError) {
        VastRequest vastRequest = this.t;
        if (vastRequest != null) {
            vastRequest.sendVastSpecError(vastSpecError);
        }
    }
}
