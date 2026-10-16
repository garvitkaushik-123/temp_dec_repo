package io.adn.sdk.internal.ui.nativead;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import com.ironsource.C3040d4;
import com.ironsource.C3061e8;
import io.adn.sdk.internal.common.model.Destroyable;
import io.adn.sdk.internal.common.model.UrlInfo;
import io.adn.sdk.internal.common.utils.UriKt;
import io.adn.sdk.internal.data.service.ExternalLinkNavigator;
import io.adn.sdk.internal.domain.constants.Constants;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.model.ad.AdLink;
import io.adn.sdk.internal.domain.model.ad.LoadedFile;
import io.adn.sdk.internal.domain.model.ad.NativeAdAsset;
import io.adn.sdk.internal.domain.model.ad.NativeAdEntity;
import io.adn.sdk.internal.domain.model.ad.NativeAdEvent;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.model.ui.RenderingState;
import io.adn.sdk.internal.domain.repository.AdTracker;
import io.adn.sdk.internal.ui.common.inappbrowser.InAppBrowserFactory;
import io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt;
import io.adn.sdk.internal.ui.nativead.mapper.NativeAdUiMapperKt;
import io.adn.sdk.publisher.AdnClickElement;
import io.adn.sdk.publisher.AdnNativeAdRenderer;
import io.adn.sdk.publisher.AdnNativeInteractionHandler;
import io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser;
import io.adn.sdk.publisher.inappbrowser.AdnInAppBrowserLauncher;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: NativeAdViewModel.kt */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BM\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020$H\u0002J\u001b\u0010B\u001a\u00020C2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0EH\u0017¢\u0006\u0002\u0010FJ\u0012\u0010G\u001a\u0004\u0018\u00010-2\u0006\u0010H\u001a\u00020!H\u0016J\u0012\u0010I\u001a\u0004\u0018\u0001012\u0006\u0010H\u001a\u00020!H\u0016J\u000e\u0010L\u001a\u00020C2\u0006\u0010M\u001a\u00020NJ\b\u0010O\u001a\u00020CH\u0016J\u0018\u0010P\u001a\u00020C2\u0006\u0010Q\u001a\u00020\u001f2\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020C2\u0006\u0010U\u001a\u00020VH\u0002J\u0010\u0010W\u001a\u00020C2\u0006\u0010U\u001a\u00020VH\u0002J\u0010\u0010X\u001a\u00020C2\u0006\u0010Y\u001a\u00020ZH\u0002J\u001e\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020-2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020-0_H\u0002J\b\u0010`\u001a\u00020\u001fH\u0002J\b\u0010a\u001a\u00020CH\u0002J\u0018\u0010b\u001a\u00020C2\u0006\u0010Q\u001a\u00020\u001f2\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010c\u001a\u00020CH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010,\u001a\u0004\u0018\u00010-X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u0004\u0018\u000101X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u00104\u001a\u0004\u0018\u00010-X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u0016\u00106\u001a\u0004\u0018\u00010-X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010/R\u0016\u00108\u001a\u0004\u0018\u00010-X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010/R\u0014\u0010:\u001a\u00020;X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010>\u001a\u0004\u0018\u00010?X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0016\u0010J\u001a\u0004\u0018\u00010?X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010A¨\u0006d"}, d2 = {"Lio/adn/sdk/internal/ui/nativead/NativeAdViewModel;", "Lio/adn/sdk/internal/common/model/Destroyable;", "Lio/adn/sdk/publisher/AdnNativeAdRenderer;", "Lio/adn/sdk/internal/ui/nativead/NativeAdMediaListener;", "activity", "Landroid/app/Activity;", "ad", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "mediaViewModel", "Lio/adn/sdk/internal/ui/nativead/NativeMediaViewModel;", "adTracker", "Lio/adn/sdk/internal/domain/repository/AdTracker;", "externalLinkNavigator", "Lio/adn/sdk/internal/data/service/ExternalLinkNavigator;", "inAppBrowserLauncher", "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowserLauncher;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/app/Activity;Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;Lio/adn/sdk/internal/ui/nativead/NativeMediaViewModel;Lio/adn/sdk/internal/domain/repository/AdTracker;Lio/adn/sdk/internal/data/service/ExternalLinkNavigator;Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowserLauncher;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;Lkotlinx/coroutines/CoroutineScope;)V", "diagnosticAdReady", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$NativeAdReadyForInteraction;", "diagnosticAdShow", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$NativeAdShow;", "diagnosticAdClick", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$NativeAdClick;", "diagnosticAdDestroyed", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventBuilder$NativeAdDestroyed;", "hasTrackedInteractionReady", "", "clickNavigationIndex", "", "_adEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEvent;", "adEvent", "Lkotlinx/coroutines/flow/Flow;", "getAdEvent", "()Lkotlinx/coroutines/flow/Flow;", "emitEvent", "Lkotlinx/coroutines/Job;", "event", "title", "", "getTitle", "()Ljava/lang/String;", "iconUri", "Landroid/net/Uri;", "getIconUri", "()Landroid/net/Uri;", "body", "getBody", "callToAction", "getCallToAction", C3040d4.h.F0, "getAdvertiser", "aspectRatio", "", "getAspectRatio", "()F", "mainMediaView", "Landroid/view/View;", "getMainMediaView", "()Landroid/view/View;", "MainMediaContent", "", "onClicked", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "customData", "id", "customMedia", "privacyView", "getPrivacyView", "prepareForInteraction", "interactionHandler", "Lio/adn/sdk/publisher/AdnNativeInteractionHandler;", "onMediaDisplayed", "onMediaVisibilityChange", C3061e8.k, "renderingState", "Lio/adn/sdk/internal/domain/model/ui/RenderingState;", "handleAdClick", "clickElement", "Lio/adn/sdk/publisher/AdnClickElement;", "onClickThrough", "handleClickNavigation", "link", "Lio/adn/sdk/internal/domain/model/ad/AdLink$Native;", "createInAppBrowser", "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowser;", "url", "postClickTrackers", "", "onPrivacyClick", "reportAdReadyForInteraction", "reportAdShow", "destroy", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NativeAdViewModel implements Destroyable, AdnNativeAdRenderer, NativeAdMediaListener {
    public static final int $stable = 8;
    private final MutableSharedFlow<NativeAdEvent> _adEvent;
    private final Activity activity;
    private final NativeAdEntity ad;
    private final Flow<NativeAdEvent> adEvent;
    private final AdTracker adTracker;
    private final String advertiser;
    private final float aspectRatio;
    private final String body;
    private final String callToAction;
    private int clickNavigationIndex;
    private final DiagnosticEventBuilder.NativeAdClick diagnosticAdClick;
    private final DiagnosticEventBuilder.NativeAdDestroyed diagnosticAdDestroyed;
    private final DiagnosticEventBuilder.NativeAdReadyForInteraction diagnosticAdReady;
    private final DiagnosticEventBuilder.NativeAdShow diagnosticAdShow;
    private final DiagnosticReporter diagnosticReporter;
    private final ExternalLinkNavigator externalLinkNavigator;
    private boolean hasTrackedInteractionReady;
    private final Uri iconUri;
    private final AdnInAppBrowserLauncher inAppBrowserLauncher;
    private final View mainMediaView;
    private final NativeMediaViewModel mediaViewModel;
    private final View privacyView;
    private final CoroutineScope scope;
    private final String title;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainMediaContent$lambda$4(NativeAdViewModel nativeAdViewModel, Function0 function0, int i, Composer composer, int i2) {
        nativeAdViewModel.MainMediaContent(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public NativeAdViewModel(Activity activity, NativeAdEntity ad, NativeMediaViewModel nativeMediaViewModel, AdTracker adTracker, ExternalLinkNavigator externalLinkNavigator, AdnInAppBrowserLauncher adnInAppBrowserLauncher, DiagnosticReporter diagnosticReporter, CoroutineScope scope) {
        ComposeView composeView;
        LoadedFile resource;
        File file;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        Intrinsics.checkNotNullParameter(externalLinkNavigator, "externalLinkNavigator");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.activity = activity;
        this.ad = ad;
        this.mediaViewModel = nativeMediaViewModel;
        this.adTracker = adTracker;
        this.externalLinkNavigator = externalLinkNavigator;
        this.inAppBrowserLauncher = adnInAppBrowserLauncher;
        this.diagnosticReporter = diagnosticReporter;
        this.scope = scope;
        this.diagnosticAdReady = new DiagnosticEventBuilder.NativeAdReadyForInteraction(ad);
        this.diagnosticAdShow = new DiagnosticEventBuilder.NativeAdShow(ad);
        this.diagnosticAdClick = new DiagnosticEventBuilder.NativeAdClick(ad);
        this.diagnosticAdDestroyed = new DiagnosticEventBuilder.NativeAdDestroyed(ad);
        ImageView imageView = null;
        MutableSharedFlow<NativeAdEvent> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._adEvent = MutableSharedFlow$default;
        this.adEvent = MutableSharedFlow$default;
        NativeAdAsset.Title title = ad.getTitle();
        this.title = title != null ? title.getText() : null;
        NativeAdAsset.Media.Image icon = ad.getIcon();
        this.iconUri = (icon == null || (resource = icon.getResource()) == null || (file = resource.getFile()) == null) ? null : Uri.fromFile(file);
        NativeAdAsset.Data body = ad.getBody();
        this.body = body != null ? body.getValue() : null;
        NativeAdAsset.Data cta = ad.getCta();
        this.callToAction = cta != null ? cta.getValue() : null;
        NativeAdAsset.Data advertiser = ad.getAdvertiser();
        this.advertiser = advertiser != null ? advertiser.getValue() : null;
        NativeAdAsset.Media mainMedia = ad.getMainMedia();
        this.aspectRatio = mainMedia != null ? mainMedia.getAspectRatio() : 0.0f;
        if (nativeMediaViewModel != null) {
            nativeMediaViewModel.setListener(this);
            composeView = new ComposeView(activity, null, 0, 6, null);
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-428113180, true, new NativeAdViewModel$mainMediaView$1$1$1(nativeMediaViewModel, this)));
        } else {
            composeView = null;
        }
        this.mainMediaView = composeView;
        if (ad.getPrivacy() != null) {
            imageView = new ImageView(activity);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: io.adn.sdk.internal.ui.nativead.NativeAdViewModel$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NativeAdViewModel.this.onPrivacyClick();
                }
            });
        }
        this.privacyView = imageView;
    }

    public /* synthetic */ NativeAdViewModel(Activity activity, NativeAdEntity nativeAdEntity, NativeMediaViewModel nativeMediaViewModel, AdTracker adTracker, ExternalLinkNavigator externalLinkNavigator, AdnInAppBrowserLauncher adnInAppBrowserLauncher, DiagnosticReporter diagnosticReporter, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, nativeAdEntity, nativeMediaViewModel, adTracker, externalLinkNavigator, adnInAppBrowserLauncher, diagnosticReporter, (i & 128) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }

    public final Flow<NativeAdEvent> getAdEvent() {
        return this.adEvent;
    }

    private final Job emitEvent(NativeAdEvent event) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new NativeAdViewModel$emitEvent$1(this, event, null), 3, null);
        return launch$default;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public String getTitle() {
        return this.title;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public Uri getIconUri() {
        return this.iconUri;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public String getBody() {
        return this.body;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public String getCallToAction() {
        return this.callToAction;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public String getAdvertiser() {
        return this.advertiser;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public float getAspectRatio() {
        return this.aspectRatio;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public View getMainMediaView() {
        return this.mainMediaView;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public void MainMediaContent(final Function0<Unit> onClicked, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onClicked, "onClicked");
        Composer startRestartGroup = composer.startRestartGroup(-695344056);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(onClicked) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-695344056, i2, -1, "io.adn.sdk.internal.ui.nativead.NativeAdViewModel.MainMediaContent (NativeAdViewModel.kt:83)");
            }
            NativeMediaViewModel nativeMediaViewModel = this.mediaViewModel;
            if (nativeMediaViewModel != null) {
                nativeMediaViewModel.setListener(this);
                NativeAdMediaContentKt.NativeAdMediaContent(nativeMediaViewModel, onClicked, startRestartGroup, (i2 << 3) & 112);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.nativead.NativeAdViewModel$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MainMediaContent$lambda$4;
                    MainMediaContent$lambda$4 = NativeAdViewModel.MainMediaContent$lambda$4(NativeAdViewModel.this, onClicked, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MainMediaContent$lambda$4;
                }
            });
        }
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public String customData(int id) {
        Object obj;
        List<NativeAdAsset> assets = this.ad.getAssets();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : assets) {
            if (obj2 instanceof NativeAdAsset) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((NativeAdAsset) obj).getId() == id) {
                break;
            }
        }
        NativeAdAsset nativeAdAsset = (NativeAdAsset) obj;
        if (nativeAdAsset instanceof NativeAdAsset.Title) {
            return ((NativeAdAsset.Title) nativeAdAsset).getText();
        }
        if (nativeAdAsset instanceof NativeAdAsset.Data) {
            return ((NativeAdAsset.Data) nativeAdAsset).getValue();
        }
        return null;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public Uri customMedia(int id) {
        Object obj;
        LoadedFile resource;
        File file;
        List<NativeAdAsset> assets = this.ad.getAssets();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : assets) {
            if (obj2 instanceof NativeAdAsset.Media) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((NativeAdAsset) obj).getId() == id) {
                break;
            }
        }
        NativeAdAsset.Media media = (NativeAdAsset.Media) ((NativeAdAsset) obj);
        if (media == null || (resource = media.getResource()) == null || (file = resource.getFile()) == null) {
            return null;
        }
        return Uri.fromFile(file);
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public View getPrivacyView() {
        return this.privacyView;
    }

    public final void prepareForInteraction(AdnNativeInteractionHandler interactionHandler) {
        Intrinsics.checkNotNullParameter(interactionHandler, "interactionHandler");
        interactionHandler.setOnAdElementClick$adn_sdk_release(new Function1() { // from class: io.adn.sdk.internal.ui.nativead.NativeAdViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit prepareForInteraction$lambda$9;
                prepareForInteraction$lambda$9 = NativeAdViewModel.prepareForInteraction$lambda$9(NativeAdViewModel.this, (AdnClickElement) obj);
                return prepareForInteraction$lambda$9;
            }
        });
        reportAdReadyForInteraction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareForInteraction$lambda$9(NativeAdViewModel nativeAdViewModel, AdnClickElement clickElement) {
        Intrinsics.checkNotNullParameter(clickElement, "clickElement");
        nativeAdViewModel.handleAdClick(clickElement);
        return Unit.INSTANCE;
    }

    @Override // io.adn.sdk.internal.ui.nativead.NativeAdMediaListener
    public void onMediaDisplayed() {
        if (this.adTracker.trackImpression(this.ad.getImpressionTrackers())) {
            emitEvent(NativeAdEvent.Impression.INSTANCE);
        }
    }

    @Override // io.adn.sdk.internal.ui.nativead.NativeAdMediaListener
    public void onMediaVisibilityChange(boolean isVisible, RenderingState renderingState) {
        Intrinsics.checkNotNullParameter(renderingState, "renderingState");
        reportAdShow(isVisible, renderingState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAdClick(AdnClickElement clickElement) {
        NativeMediaViewModel nativeMediaViewModel;
        if (clickElement instanceof AdnClickElement.Privacy) {
            onPrivacyClick();
            return;
        }
        onClickThrough(clickElement);
        if (!(clickElement instanceof AdnClickElement.MainMedia) || (nativeMediaViewModel = this.mediaViewModel) == null) {
            return;
        }
        nativeMediaViewModel.onClicked();
    }

    private final void onClickThrough(AdnClickElement clickElement) {
        this.adTracker.trackClick(this.ad.getLink(), NativeAdUiMapperKt.mapToClickTrackingData$default(clickElement, null, false, !this.ad.getLink().getShouldOpenInAppBrowser(), 2, null));
        emitEvent(NativeAdEvent.ClickThrough.INSTANCE);
        this.diagnosticAdClick.updateElementIdProperty(clickElement);
        this.diagnosticReporter.reportEvent(this.diagnosticAdClick);
        handleClickNavigation(this.ad.getLink());
    }

    private final void handleClickNavigation(AdLink.Native link) {
        String url = link.getUrl();
        if (url == null) {
            return;
        }
        UrlInfo analyzeUrl = UriKt.analyzeUrl(url);
        AdnInAppBrowserLauncher adnInAppBrowserLauncher = this.inAppBrowserLauncher;
        if (adnInAppBrowserLauncher == null) {
            this.externalLinkNavigator.open(url);
        } else if (adnInAppBrowserLauncher.isInternalDeeplink(url)) {
            adnInAppBrowserLauncher.openInternalDeeplink(url);
        } else if (analyzeUrl.isDeeplink()) {
            this.externalLinkNavigator.openDeeplink(url);
        } else if (link.getShouldOpenInAppBrowser()) {
            adnInAppBrowserLauncher.open(createInAppBrowser(url, link.getPostClickTrackers()));
        } else {
            this.externalLinkNavigator.open(url);
        }
        this.clickNavigationIndex++;
    }

    private final AdnInAppBrowser createInAppBrowser(String url, List<String> postClickTrackers) {
        return new InAppBrowserFactory().create(this.activity, this.clickNavigationIndex, url, postClickTrackers, this.adTracker, this.externalLinkNavigator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onPrivacyClick() {
        return this.externalLinkNavigator.open(Constants.DEFAULT_PRIVACY_URL);
    }

    private final void reportAdReadyForInteraction() {
        if (this.hasTrackedInteractionReady) {
            return;
        }
        this.hasTrackedInteractionReady = true;
        this.diagnosticReporter.reportEvent(this.diagnosticAdReady);
    }

    private final void reportAdShow(boolean isVisible, RenderingState renderingState) {
        if (isVisible) {
            this.diagnosticReporter.updateShowStartedDate();
            this.diagnosticReporter.reportStart(this.diagnosticAdShow);
        } else {
            if (renderingState instanceof RenderingState.Failure) {
                this.diagnosticReporter.reportFailure(this.diagnosticAdShow, ((RenderingState.Failure) renderingState).getException());
            } else {
                this.diagnosticReporter.reportSuccess(this.diagnosticAdShow);
            }
            this.diagnosticAdShow.resetState();
        }
    }

    @Override // io.adn.sdk.internal.common.model.Destroyable
    public void destroy() {
        try {
            Result.Companion companion = Result.INSTANCE;
            NativeAdViewModel nativeAdViewModel = this;
            NativeMediaViewModel nativeMediaViewModel = this.mediaViewModel;
            if (nativeMediaViewModel != null) {
                nativeMediaViewModel.destroy();
            }
            this.diagnosticReporter.reportEvent(this.diagnosticAdDestroyed);
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }
}
