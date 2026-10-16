package io.bidmachine.rendering.internal.adform.html;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.Constants;
import io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingConfig;
import io.bidmachine.iab.IabSettings;
import io.bidmachine.iab.mraid.MraidAdView;
import io.bidmachine.iab.mraid.MraidPlacementType;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.rendering.internal.adform.c;
import io.bidmachine.rendering.internal.n;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.internal.repository.a;
import io.bidmachine.rendering.measurer.HtmlMeasurer;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.HtmlResourceSource;
import io.bidmachine.rendering.model.MediaSource;
import io.bidmachine.rendering.model.Resource;
import io.bidmachine.rendering.model.ResourceSource;
import io.bidmachine.rendering.model.UrlResourceSource;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.Utils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u0002\u001f0BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0018\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u001cJ\u000f\u0010!\u001a\u00020\u0014H\u0016¢\u0006\u0004\b!\u0010\u001cJ\u000f\u0010\"\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\"\u0010\u001cJ\u000f\u0010#\u001a\u00020\u0014H\u0014¢\u0006\u0004\b#\u0010\u001cJ\u000f\u0010$\u001a\u00020\u0014H\u0007¢\u0006\u0004\b$\u0010\u001cJ\u0011\u0010&\u001a\u0004\u0018\u00010%H\u0007¢\u0006\u0004\b&\u0010'J\u0011\u0010(\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120*H\u0007¢\u0006\u0004\b+\u0010,J\u0015\u0010\u001f\u001a\u00020\u00142\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b\u001f\u0010/J\u0015\u00100\u001a\u00020\u00142\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b0\u0010/R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00068"}, d2 = {"Lio/bidmachine/rendering/internal/adform/html/a;", "Lio/bidmachine/rendering/internal/adform/a;", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/internal/repository/a;", "repository", "Lio/bidmachine/rendering/model/AdElementParams;", "adElementParams", "Lio/bidmachine/rendering/internal/adform/c;", "adFormListener", "Lio/bidmachine/rendering/internal/event/b;", "eventCallback", "Lio/bidmachine/rendering/internal/detector/brokencreative/a;", "brokenCreativeDetector", "Lio/bidmachine/rendering/measurer/HtmlMeasurer;", "htmlMeasurer", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/internal/repository/a;Lio/bidmachine/rendering/model/AdElementParams;Lio/bidmachine/rendering/internal/adform/c;Lio/bidmachine/rendering/internal/event/b;Lio/bidmachine/rendering/internal/detector/brokencreative/a;Lio/bidmachine/rendering/measurer/HtmlMeasurer;)V", "", "url", "", "d", "(Ljava/lang/String;)V", "adm", "c", "Landroid/view/View;", "v", "()Landroid/view/View;", "()V", "Landroid/view/ViewGroup;", "viewGroup", "a", "(Landroid/view/ViewGroup;)V", "z", "m", VastAttributes.HORIZONTAL_POSITION, "C", "Lio/bidmachine/iab/mraid/MraidPlacementType;", "F", "()Lio/bidmachine/iab/mraid/MraidPlacementType;", ExifInterface.LONGITUDE_EAST, "()Ljava/lang/String;", "", "D", "()Ljava/util/List;", "Lio/bidmachine/rendering/model/Error;", "error", "(Lio/bidmachine/rendering/model/Error;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "r", "Lio/bidmachine/rendering/measurer/HtmlMeasurer;", "Lio/bidmachine/iab/mraid/MraidAdView;", "s", "Lio/bidmachine/iab/mraid/MraidAdView;", "mraidAdView", "t", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a extends io.bidmachine.rendering.internal.adform.a {

    /* renamed from: r, reason: from kotlin metadata */
    private final HtmlMeasurer htmlMeasurer;

    /* renamed from: s, reason: from kotlin metadata */
    private MraidAdView mraidAdView;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/bidmachine/rendering/internal/adform/html/a$a;", "Lio/bidmachine/rendering/internal/repository/a$a;", "", "<init>", "(Lio/bidmachine/rendering/internal/adform/html/a;)V", "result", "", "a", "(Ljava/lang/String;)V", "Lio/bidmachine/rendering/model/Error;", "error", "onError", "(Lio/bidmachine/rendering/model/Error;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: io.bidmachine.rendering.internal.adform.html.a$a, reason: collision with other inner class name */
    private final class C0606a implements a.InterfaceC0625a<String> {
        public C0606a() {
        }

        @Override // io.bidmachine.rendering.internal.repository.a.InterfaceC0625a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String result) {
            Intrinsics.checkNotNullParameter(result, "result");
            a.this.c(result);
        }

        @Override // io.bidmachine.rendering.internal.repository.a.InterfaceC0625a
        public void onError(Error error) {
            Intrinsics.checkNotNullParameter(error, "error");
            a.this.a(error);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, io.bidmachine.rendering.internal.repository.a repository, AdElementParams adElementParams, c adFormListener, io.bidmachine.rendering.internal.event.b eventCallback, io.bidmachine.rendering.internal.detector.brokencreative.a aVar, HtmlMeasurer htmlMeasurer) {
        super(context, repository, adElementParams, adFormListener, eventCallback, aVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(adElementParams, "adElementParams");
        Intrinsics.checkNotNullParameter(adFormListener, "adFormListener");
        Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
        this.htmlMeasurer = htmlMeasurer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C();
    }

    public final void C() {
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.internal.adform.html.a$$ExternalSyntheticLambda0
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                a.a(a.this);
            }
        });
    }

    public final List<String> D() {
        try {
            String customParam = getAdElementParams().getCustomParam(AdaptiveRenderingConfig.NATIVE_FEATURES_KEY);
            if (customParam != null && customParam.length() > 0) {
                List<String> mutableList = CollectionsKt.toMutableList((Collection) StringsKt.split$default((CharSequence) customParam, new String[]{","}, false, 0, 6, (Object) null));
                int size = mutableList.size();
                for (int i = 0; i < size; i++) {
                    String str = mutableList.get(i);
                    int length = str.length() - 1;
                    int i2 = 0;
                    boolean z = false;
                    while (i2 <= length) {
                        boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (z2) {
                            i2++;
                        } else {
                            z = true;
                        }
                    }
                    mutableList.set(i, str.subSequence(i2, length + 1).toString());
                }
                return mutableList;
            }
        } catch (Exception unused) {
        }
        return CollectionsKt.emptyList();
    }

    public final String E() {
        if (!getAdElementParams().getCustomParams().containsKey("base_url")) {
            return IabSettings.DEF_BASE_URL;
        }
        String customParam = getAdElementParams().getCustomParam("base_url");
        if (Utils.isUrlValid(customParam)) {
            return customParam;
        }
        return null;
    }

    public final MraidPlacementType F() {
        String customParam = getAdElementParams().getCustomParam("placement_type");
        if (Intrinsics.areEqual(customParam, Constants.TEMPLATE_TYPE_FULLSCREEN)) {
            return MraidPlacementType.INTERSTITIAL;
        }
        if (Intrinsics.areEqual(customParam, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW)) {
            return MraidPlacementType.INLINE;
        }
        return null;
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    public void c() {
        Resource resource = getAdElementParams().getResource();
        ResourceSource source = resource != null ? resource.getSource() : null;
        if (source == null) {
            c(getAdElementParams().getSource());
            return;
        }
        if (source instanceof HtmlResourceSource) {
            c(((HtmlResourceSource) source).getIo.adn.sdk.internal.domain.constants.AnalyticsConstants.CREATIVE_TYPE_HTML java.lang.String());
        } else if (source instanceof UrlResourceSource) {
            d(((UrlResourceSource) source).getUrl());
        } else {
            a(new Error("Invalid resource type (" + source.getClass().getSimpleName() + "), it should be HtmlResourceSource or UrlResourceSource"));
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.a, io.bidmachine.rendering.internal.InterfaceC3590c
    public void d() {
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.internal.adform.html.a$$ExternalSyntheticLambda2
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                a.c(a.this);
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.adform.a, io.bidmachine.rendering.internal.InterfaceC3590c
    public void m() {
        Unit unit;
        MraidAdView mraidAdView = this.mraidAdView;
        if (mraidAdView != null) {
            mraidAdView.handleRedirectView();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.m();
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    public View v() {
        return this.mraidAdView;
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    protected void x() {
        Unit unit;
        HtmlMeasurer htmlMeasurer = this.htmlMeasurer;
        if (htmlMeasurer != null) {
            htmlMeasurer.destroy(new n() { // from class: io.bidmachine.rendering.internal.adform.html.a$$ExternalSyntheticLambda3
                @Override // io.bidmachine.util.SafeRunnable
                public final void onRun() {
                    a.b(a.this);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            C();
        }
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    public void z() {
        super.z();
        HtmlMeasurer htmlMeasurer = this.htmlMeasurer;
        if (htmlMeasurer != null) {
            htmlMeasurer.onShown();
        }
    }

    private final void d(String url) {
        MediaSource fromUrl = MediaSource.INSTANCE.fromUrl(url);
        if (fromUrl == null) {
            a(new Error("Invalid adm url (" + url + ')'));
        } else {
            getRepository().a(fromUrl, new C0606a());
        }
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    public void a(final ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.internal.adform.html.a$$ExternalSyntheticLambda4
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                a.a(a.this, viewGroup);
            }
        });
    }

    public final void b(Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        HtmlMeasurer htmlMeasurer = this.htmlMeasurer;
        if (htmlMeasurer != null) {
            htmlMeasurer.onError(error);
        }
        getAdFormListener().a(this, error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewGroup, "$viewGroup");
        MraidAdView mraidAdView = this$0.mraidAdView;
        HtmlMeasurer htmlMeasurer = this$0.htmlMeasurer;
        if (htmlMeasurer == null || mraidAdView == null) {
            return;
        }
        htmlMeasurer.onViewAddedToContainer(mraidAdView.getWebView(), viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, MraidPlacementType mraidPlacementType, String str, String preparedSource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(preparedSource, "$preparedSource");
        try {
            Context applicationContext = this$0.getApplicationContext();
            List<String> D = this$0.D();
            c adFormListener = this$0.getAdFormListener();
            io.bidmachine.rendering.internal.event.b eventCallback = this$0.o();
            Intrinsics.checkNotNullExpressionValue(eventCallback, "eventCallback");
            MraidAdView mraidAdView = new MraidAdView(applicationContext, mraidPlacementType, str, null, D, null, new b(this$0, adFormListener, eventCallback, this$0.htmlMeasurer));
            mraidAdView.load(preparedSource);
            HtmlMeasurer htmlMeasurer = this$0.htmlMeasurer;
            if (htmlMeasurer != null) {
                htmlMeasurer.onViewCreated(mraidAdView.getWebView());
            }
            this$0.mraidAdView = mraidAdView;
        } catch (Throwable th) {
            o.b(th);
            this$0.a(Error.INSTANCE.create(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MraidAdView mraidAdView = this$0.mraidAdView;
        if (mraidAdView != null) {
            mraidAdView.show();
            this$0.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(final String adm) {
        String prepareCreativeForMeasure;
        if (adm != null && adm.length() != 0) {
            HtmlMeasurer htmlMeasurer = this.htmlMeasurer;
            if (htmlMeasurer != null && (prepareCreativeForMeasure = htmlMeasurer.prepareCreativeForMeasure(adm)) != null) {
                adm = prepareCreativeForMeasure;
            }
            Intrinsics.checkNotNullExpressionValue(adm, "htmlMeasurer?.prepareCre…iveForMeasure(adm) ?: adm");
            final MraidPlacementType F = F();
            final String E = E();
            UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.internal.adform.html.a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    a.a(a.this, F, E, adm);
                }
            });
            return;
        }
        a(new Error("Adm is null or empty"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MraidAdView mraidAdView = this$0.mraidAdView;
        if (mraidAdView != null) {
            mraidAdView.destroy();
        }
        this$0.mraidAdView = null;
    }

    public final void a(Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        HtmlMeasurer htmlMeasurer = this.htmlMeasurer;
        if (htmlMeasurer != null) {
            htmlMeasurer.onError(error);
        }
        getAdFormListener().c(this, error);
    }
}
