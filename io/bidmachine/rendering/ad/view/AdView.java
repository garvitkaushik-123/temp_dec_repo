package io.bidmachine.rendering.ad.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.C3355vf;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.rendering.internal.A;
import io.bidmachine.rendering.internal.B;
import io.bidmachine.rendering.internal.C;
import io.bidmachine.rendering.internal.animation.i;
import io.bidmachine.rendering.internal.controller.c;
import io.bidmachine.rendering.internal.controller.e;
import io.bidmachine.rendering.internal.h;
import io.bidmachine.rendering.internal.n;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.internal.view.d;
import io.bidmachine.rendering.internal.view.f;
import io.bidmachine.rendering.internal.z;
import io.bidmachine.rendering.model.AdParams;
import io.bidmachine.rendering.model.Background;
import io.bidmachine.rendering.model.Border;
import io.bidmachine.rendering.model.BrokenCreativeEvent;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.Orientation;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.Tag;
import io.bidmachine.rendering.view.WatermarkView;
import io.bidmachine.util.UiUtils;
import io.bidmachine.util.ViewUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0012\u001bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\nJ\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\nJ\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001b\u0010\u001fJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u0012\u0010\u001fJ\u000f\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b \u0010\nJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\nJ\u000f\u0010!\u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\nJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010\nJ\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010#\u001a\u00020\bH\u0002¢\u0006\u0004\b#\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010\nJ\u000f\u0010%\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010\nJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u0012\u0010\u001cJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b\u0012\u0010(J\u000f\u0010)\u001a\u00020\bH\u0014¢\u0006\u0004\b)\u0010\nJ\u000f\u0010*\u001a\u00020\bH\u0014¢\u0006\u0004\b*\u0010\nJ\u001f\u0010/\u001a\u00020\b2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H\u0014¢\u0006\u0004\b/\u00100J\r\u00102\u001a\u000201¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\b¢\u0006\u0004\b4\u0010\nJ\u0017\u00107\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b:\u0010;J\r\u0010<\u001a\u00020\b¢\u0006\u0004\b<\u0010\nJ\u000f\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010AR\u0014\u0010D\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010IR\u0014\u0010M\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010LR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010OR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010RR\u0016\u0010V\u001a\u0004\u0018\u00010T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010UR$\u0010]\u001a\u0004\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0016\u0010_\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010^¨\u0006`"}, d2 = {"Lio/bidmachine/rendering/ad/view/AdView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/model/AdParams;", "adParams", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/model/AdParams;)V", "", j.b, "()V", "Lio/bidmachine/rendering/model/Error;", "error", "c", "(Lio/bidmachine/rendering/model/Error;)V", CampaignEx.JSON_KEY_AD_K, "Lio/bidmachine/rendering/internal/controller/e;", "adPhaseController", "a", "(Lio/bidmachine/rendering/internal/controller/e;)V", "d", "o", D5.q, "l", "m", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "privacySheetParams", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/bidmachine/rendering/model/PrivacySheetParams;)V", "Lio/bidmachine/rendering/internal/view/f;", "placeholderView", "(Lio/bidmachine/rendering/internal/view/f;)V", "p", "h", "i", "g", "e", InneractiveMediationDefs.GENDER_FEMALE, "Lio/bidmachine/rendering/model/BrokenCreativeEvent;", "brokenCreativeEvent", "(Lio/bidmachine/rendering/model/BrokenCreativeEvent;)V", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/view/View;", "changedView", "", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "", "isLoaded", "()Z", "load", "Landroid/graphics/drawable/Drawable;", "drawable", "setWatermark", "(Landroid/graphics/drawable/Drawable;)V", "Lio/bidmachine/rendering/model/Orientation;", "getRequiredOrientation", "()Lio/bidmachine/rendering/model/Orientation;", "destroy", "", "toString", "()Ljava/lang/String;", "Lio/bidmachine/rendering/utils/Tag;", "Lio/bidmachine/rendering/utils/Tag;", "tag", "Landroid/widget/FrameLayout;", "adLayer", "Lio/bidmachine/rendering/view/WatermarkView;", "Lio/bidmachine/rendering/view/WatermarkView;", "watermarkLayer", "Lio/bidmachine/rendering/internal/state/a;", "Lio/bidmachine/rendering/internal/state/a;", "adState", "Lio/bidmachine/rendering/internal/controller/a;", "Lio/bidmachine/rendering/internal/controller/a;", "adController", "Lio/bidmachine/rendering/internal/view/d;", "Lio/bidmachine/rendering/internal/view/d;", "loadingView", "Lio/bidmachine/rendering/internal/B;", "Lio/bidmachine/rendering/internal/B;", "visibilityTracker", "Lio/bidmachine/rendering/internal/z;", "Lio/bidmachine/rendering/internal/z;", "viewBackgroundSetter", "Lio/bidmachine/rendering/ad/view/AdViewListener;", "Lio/bidmachine/rendering/ad/view/AdViewListener;", "getAdViewListener", "()Lio/bidmachine/rendering/ad/view/AdViewListener;", "setAdViewListener", "(Lio/bidmachine/rendering/ad/view/AdViewListener;)V", "adViewListener", "Z", "isAttachedToWindow", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class AdView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Tag tag;

    /* renamed from: b, reason: from kotlin metadata */
    private final FrameLayout adLayer;

    /* renamed from: c, reason: from kotlin metadata */
    private final WatermarkView watermarkLayer;

    /* renamed from: d, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.state.a adState;

    /* renamed from: e, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.controller.a adController;

    /* renamed from: f, reason: from kotlin metadata */
    private final d loadingView;

    /* renamed from: g, reason: from kotlin metadata */
    private final B visibilityTracker;

    /* renamed from: h, reason: from kotlin metadata */
    private final z viewBackgroundSetter;

    /* renamed from: i, reason: from kotlin metadata */
    private AdViewListener adViewListener;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean isAttachedToWindow;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\r\u0010\u0014J!\u0010\r\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u0015J\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\r\u0010\u0018J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\t\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0011J\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u0011J\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0011J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u0011J\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\r\u0010\u001dJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\r\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\"¨\u0006$"}, d2 = {"Lio/bidmachine/rendering/ad/view/AdView$a;", "Lio/bidmachine/rendering/internal/controller/c;", "Lio/bidmachine/rendering/ad/view/AdView;", "adView", "<init>", "(Lio/bidmachine/rendering/ad/view/AdView;)V", "Lio/bidmachine/rendering/internal/controller/a;", "adController", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/bidmachine/rendering/internal/controller/a;)V", "Lio/bidmachine/rendering/model/Error;", "error", "a", "(Lio/bidmachine/rendering/internal/controller/a;Lio/bidmachine/rendering/model/Error;)V", "c", "d", "()V", "Lio/bidmachine/rendering/internal/controller/e;", "adPhaseController", "(Lio/bidmachine/rendering/internal/controller/e;)V", "(Lio/bidmachine/rendering/internal/controller/e;Lio/bidmachine/rendering/model/Error;)V", "Lio/bidmachine/rendering/internal/view/f;", "placeholderView", "(Lio/bidmachine/rendering/internal/view/f;)V", "e", C3355vf.f, "Lio/bidmachine/rendering/model/PrivacySheetParams;", "privacySheetParams", "(Lio/bidmachine/rendering/model/PrivacySheetParams;)V", "Lio/bidmachine/rendering/model/BrokenCreativeEvent;", "brokenCreativeEvent", "(Lio/bidmachine/rendering/model/BrokenCreativeEvent;)V", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "weakAdView", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a implements c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<AdView> weakAdView;

        public a(AdView adView) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            this.weakAdView = new WeakReference<>(adView);
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(io.bidmachine.rendering.internal.controller.a adController, Error error) {
            Intrinsics.checkNotNullParameter(adController, "adController");
            Intrinsics.checkNotNullParameter(error, "error");
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.c(error);
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void b(io.bidmachine.rendering.internal.controller.a adController) {
            Intrinsics.checkNotNullParameter(adController, "adController");
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.j();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void c(io.bidmachine.rendering.internal.controller.a adController) {
            Intrinsics.checkNotNullParameter(adController, "adController");
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.i();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void d() {
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.k();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void e() {
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.b(new Error("Ad loading timeout after display"));
                adView.a();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void onAdClicked() {
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.d();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(io.bidmachine.rendering.internal.controller.a adController) {
            Intrinsics.checkNotNullParameter(adController, "adController");
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.f();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void b(f placeholderView) {
            Intrinsics.checkNotNullParameter(placeholderView, "placeholderView");
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.a(placeholderView);
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void c() {
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.b();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(e adPhaseController) {
            Intrinsics.checkNotNullParameter(adPhaseController, "adPhaseController");
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.a(adPhaseController);
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void b() {
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.a();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(e adPhaseController, Error error) {
            Intrinsics.checkNotNullParameter(error, "error");
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.d(error);
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(f placeholderView) {
            Intrinsics.checkNotNullParameter(placeholderView, "placeholderView");
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.b(placeholderView);
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a() {
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.p();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(PrivacySheetParams privacySheetParams) {
            Intrinsics.checkNotNullParameter(privacySheetParams, "privacySheetParams");
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.b(privacySheetParams);
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.c
        public void a(BrokenCreativeEvent brokenCreativeEvent) {
            Intrinsics.checkNotNullParameter(brokenCreativeEvent, "brokenCreativeEvent");
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.a(brokenCreativeEvent);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b¨\u0006\r"}, d2 = {"Lio/bidmachine/rendering/ad/view/AdView$b;", "Lio/bidmachine/rendering/internal/B$a;", "Lio/bidmachine/rendering/ad/view/AdView;", "adView", "<init>", "(Lio/bidmachine/rendering/ad/view/AdView;)V", "", "a", "()V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "weakAdView", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class b implements B.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<AdView> weakAdView;

        public b(AdView adView) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            this.weakAdView = new WeakReference<>(adView);
        }

        @Override // io.bidmachine.rendering.internal.B.a
        public void a() {
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.l();
            }
        }

        @Override // io.bidmachine.rendering.internal.B.a
        public void b() {
            AdView adView = this.weakAdView.get();
            if (adView != null) {
                adView.m();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdView(Context context, AdParams adParams) {
        super(context);
        z zVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adParams, "adParams");
        Tag tag = new Tag("AdView");
        this.tag = tag;
        FrameLayout frameLayout = new FrameLayout(context);
        this.adLayer = frameLayout;
        WatermarkView watermarkView = new WatermarkView(context);
        this.watermarkLayer = watermarkView;
        addView(frameLayout, ViewUtils.createMatchParentParams());
        addView(watermarkView, ViewUtils.createMatchParentParams());
        h a2 = h.INSTANCE.a();
        String tag2 = tag.toString();
        Intrinsics.checkNotNullExpressionValue(tag2, "tag.toString()");
        io.bidmachine.rendering.internal.state.c cVar = new io.bidmachine.rendering.internal.state.c(tag2, a2);
        this.adState = cVar;
        io.bidmachine.rendering.internal.state.b o = cVar.o();
        this.adController = new io.bidmachine.rendering.internal.controller.b(context, adParams, new a(this), new i(o, a2));
        d dVar = new d(context);
        this.loadingView = dVar;
        addView(dVar, ViewUtils.createMatchParentParams());
        dVar.a();
        this.visibilityTracker = new C(this, adParams.getVisibilityParams(), new b(this));
        Background background = adParams.getBackground();
        if (background != null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
            zVar = A.a(background, applicationContext, new io.bidmachine.rendering.internal.repository.b(applicationContext2, o, a2));
        } else {
            zVar = null;
        }
        this.viewBackgroundSetter = zVar;
        this.isAttachedToWindow = false;
        setBackgroundColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AdView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adLayer.removeAllViews();
        this$0.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(PrivacySheetParams privacySheetParams) {
        o.b(this.tag, "onOpenPrivacySheet", new Object[0]);
        a(privacySheetParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(Error error) {
        a(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Error error) {
        o.a(this.tag, "onPreparingForShowFail - %s", error);
        b(new Error("No phase loaded"));
    }

    private final void e() {
        if (this.adState.b(false)) {
            o.b(this.tag, "notifyAdDisappeared", new Object[0]);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    AdView.d(AdView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AdView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdViewListener adViewListener = this$0.adViewListener;
        if (adViewListener != null) {
            adViewListener.onAdFinished(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AdView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdViewListener adViewListener = this$0.adViewListener;
        if (adViewListener != null) {
            adViewListener.onAdLoaded(this$0);
        }
    }

    private final void h() {
        if (this.adState.a(true)) {
            o.b(this.tag, "notifyAdLoaded", new Object[0]);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    AdView.g(AdView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        if (this.adState.i()) {
            o.b(this.tag, "notifyAdShown", new Object[0]);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    AdView.h(AdView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        o.b(this.tag, "onPreparingForShowStarted", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        o.b(this.tag, "onViewOnScreen", new Object[0]);
        this.adController.d();
        this.adController.onShown();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        o.b(this.tag, "onViewOutOfScreen", new Object[0]);
        n();
    }

    private final void n() {
        this.visibilityTracker.stop();
        this.adController.f();
        e();
    }

    private final void o() {
        if (this.isAttachedToWindow && ViewUtils.isViewVisible(this)) {
            this.adState.l();
            this.visibilityTracker.start();
            if (this.visibilityTracker.b()) {
                l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        this.loadingView.c();
    }

    public final void destroy() {
        o.b(this.tag, "destroy", new Object[0]);
        this.adViewListener = null;
        this.adController.a();
        this.visibilityTracker.a();
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda2
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                AdView.a(AdView.this);
            }
        });
        this.adState.a();
    }

    public final AdViewListener getAdViewListener() {
        return this.adViewListener;
    }

    public final Orientation getRequiredOrientation() {
        return this.adController.b();
    }

    public final boolean isLoaded() {
        return this.adState.b();
    }

    public final void load() {
        AdView adView;
        if (this.adState.c()) {
            z zVar = this.viewBackgroundSetter;
            if (zVar != null) {
                adView = this;
                z.a(zVar, adView, (Integer) null, (Border) null, 6, (Object) null);
            } else {
                adView = this;
            }
            adView.adController.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        o.b(this.tag, "onAttachedToWindow", new Object[0]);
        this.isAttachedToWindow = true;
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o.b(this.tag, "onDetachedFromWindow", new Object[0]);
        this.isAttachedToWindow = false;
        n();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        o.b(this.tag, "onVisibilityChanged - %s", io.bidmachine.rendering.utils.UiUtils.toString(visibility));
        if (io.bidmachine.rendering.utils.UiUtils.isViewVisible(visibility)) {
            o();
        } else {
            n();
        }
    }

    public final void setAdViewListener(AdViewListener adViewListener) {
        this.adViewListener = adViewListener;
    }

    public final void setWatermark(Drawable drawable) {
        this.watermarkLayer.setWatermark(drawable);
    }

    @Override // android.view.View
    public String toString() {
        String tag = this.tag.toString();
        Intrinsics.checkNotNullExpressionValue(tag, "tag.toString()");
        return tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AdView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdViewListener adViewListener = this$0.adViewListener;
        if (adViewListener != null) {
            adViewListener.onAdClicked(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        if (this.adState.k()) {
            o.b(this.tag, "notifyAdExpired", new Object[0]);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AdView.e(AdView.this);
                }
            });
        }
    }

    private final void g() {
        if (this.adState.j()) {
            o.b(this.tag, "notifyAdFinished", new Object[0]);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AdView.f(AdView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final e adPhaseController) {
        o.b(this.tag, "onPreparingForShowComplete", new Object[0]);
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda9
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                AdView.a(e.this, this);
            }
        });
    }

    private final void c() {
        if (this.adState.b(true)) {
            o.b(this.tag, "notifyAdAppeared", new Object[0]);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    AdView.b(AdView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final f placeholderView) {
        o.b(this.tag, "showPlaceholder (%s)", placeholderView);
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda12
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                AdView.a(f.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        this.adState.e();
        o.b(this.tag, "notifyAdClicked", new Object[0]);
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AdView.c(AdView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(e adPhaseController, AdView this$0) {
        Intrinsics.checkNotNullParameter(adPhaseController, "$adPhaseController");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (adPhaseController.a(this$0.adLayer)) {
            this$0.b();
            this$0.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        this.loadingView.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final Error error) {
        if (this.adState.f()) {
            o.a(this.tag, "notifyAdFailToShow - %s", error);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    AdView.b(AdView.this, error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AdView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdViewListener adViewListener = this$0.adViewListener;
        if (adViewListener != null) {
            adViewListener.onAdExpired(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AdView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdViewListener adViewListener = this$0.adViewListener;
        if (adViewListener != null) {
            adViewListener.onAdShown(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AdView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdViewListener adViewListener = this$0.adViewListener;
        if (adViewListener != null) {
            adViewListener.onAdDisappeared(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(f placeholderView, AdView this$0) {
        Intrinsics.checkNotNullParameter(placeholderView, "$placeholderView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (placeholderView.getParent() == this$0) {
            return;
        }
        Utils.removeFromParent(placeholderView);
        this$0.addView(placeholderView, ViewUtils.createMatchParentParams());
        placeholderView.bringToFront();
        placeholderView.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdView this$0, Error error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        AdViewListener adViewListener = this$0.adViewListener;
        if (adViewListener != null) {
            adViewListener.onAdFailToShow(this$0, error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdViewListener adViewListener = this$0.adViewListener;
        if (adViewListener != null) {
            adViewListener.onAdAppeared(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final f placeholderView) {
        o.b(this.tag, "hidePlaceholder (%s)", placeholderView);
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda11
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                AdView.a(AdView.this, placeholderView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AdView this$0, f placeholderView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(placeholderView, "$placeholderView");
        this$0.removeView(placeholderView);
    }

    private final void a(final Error error) {
        if (this.adState.a(false)) {
            o.a(this.tag, "notifyAdFailToLoad - %s", error);
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    AdView.a(AdView.this, error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AdView this$0, Error error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        AdViewListener adViewListener = this$0.adViewListener;
        if (adViewListener != null) {
            adViewListener.onAdFailToLoad(this$0, error);
        }
    }

    private final void a(final PrivacySheetParams privacySheetParams) {
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                AdView.a(AdView.this, privacySheetParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AdView this$0, PrivacySheetParams privacySheetParams) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(privacySheetParams, "$privacySheetParams");
        AdViewListener adViewListener = this$0.adViewListener;
        if (adViewListener != null) {
            adViewListener.onOpenPrivacySheet(this$0, privacySheetParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final BrokenCreativeEvent brokenCreativeEvent) {
        if (this.adState.h()) {
            return;
        }
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.ad.view.AdView$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                AdView.a(AdView.this, brokenCreativeEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AdView this$0, BrokenCreativeEvent brokenCreativeEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(brokenCreativeEvent, "$brokenCreativeEvent");
        AdViewListener adViewListener = this$0.adViewListener;
        if (adViewListener != null) {
            adViewListener.onBrokenCreativeEvent(this$0, brokenCreativeEvent);
        }
    }
}
