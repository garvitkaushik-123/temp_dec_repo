package io.adn.sdk.internal.ui.nativead;

import android.net.Uri;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.model.ad.NativeAdAssetMetadata;
import io.adn.sdk.internal.domain.model.ad.NativeAdMetadata;
import io.adn.sdk.publisher.AdnNativeAdRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetadataAdRenderer.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\u00122\u0006\u0010#\u001a\u00020$H\u0016J\u001b\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)H\u0017¢\u0006\u0002\u0010*R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f¨\u0006+"}, d2 = {"Lio/adn/sdk/internal/ui/nativead/MetadataAdRenderer;", "Lio/adn/sdk/publisher/AdnNativeAdRenderer;", "metadata", "Lio/adn/sdk/internal/domain/model/ad/NativeAdMetadata;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/NativeAdMetadata;)V", "titleText", "", "bodyText", "ctaText", "mainMediaAspectRatio", "", "title", "getTitle", "()Ljava/lang/String;", "body", "getBody", "iconUri", "Landroid/net/Uri;", "getIconUri", "()Landroid/net/Uri;", "callToAction", "getCallToAction", C3040d4.h.F0, "getAdvertiser", "aspectRatio", "getAspectRatio", "()F", "mainMediaView", "Landroid/view/View;", "getMainMediaView", "()Landroid/view/View;", "privacyView", "getPrivacyView", "customData", "id", "", "customMedia", "MainMediaContent", "", "onClicked", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MetadataAdRenderer implements AdnNativeAdRenderer {
    public static final int $stable = 8;
    private final String advertiser;
    private final float aspectRatio;
    private final String body;
    private final String bodyText;
    private final String callToAction;
    private final String ctaText;
    private final Uri iconUri;
    private final float mainMediaAspectRatio;
    private final View mainMediaView;
    private final View privacyView;
    private final String title;
    private final String titleText;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainMediaContent$lambda$0(MetadataAdRenderer metadataAdRenderer, Function0 function0, int i, Composer composer, int i2) {
        metadataAdRenderer.MainMediaContent(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public String customData(int id) {
        return null;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public Uri customMedia(int id) {
        return null;
    }

    public MetadataAdRenderer(NativeAdMetadata metadata) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        float aspectRatio;
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        List<NativeAdAssetMetadata> assets = metadata.getAssets();
        ArrayList arrayList = new ArrayList();
        for (Object obj6 : assets) {
            if (obj6 instanceof NativeAdAssetMetadata.TitleMetadata) {
                arrayList.add(obj6);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (((NativeAdAssetMetadata) obj2).getId() == 1) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        NativeAdAssetMetadata.TitleMetadata titleMetadata = (NativeAdAssetMetadata.TitleMetadata) ((NativeAdAssetMetadata) obj2);
        this.titleText = titleMetadata != null ? titleMetadata.getText() : null;
        List<NativeAdAssetMetadata> assets2 = metadata.getAssets();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj7 : assets2) {
            if (obj7 instanceof NativeAdAssetMetadata.DataMetadata) {
                arrayList2.add(obj7);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj3 = it2.next();
                if (((NativeAdAssetMetadata) obj3).getId() == 3) {
                    break;
                }
            } else {
                obj3 = null;
                break;
            }
        }
        NativeAdAssetMetadata.DataMetadata dataMetadata = (NativeAdAssetMetadata.DataMetadata) ((NativeAdAssetMetadata) obj3);
        this.bodyText = dataMetadata != null ? dataMetadata.getValue() : null;
        List<NativeAdAssetMetadata> assets3 = metadata.getAssets();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj8 : assets3) {
            if (obj8 instanceof NativeAdAssetMetadata.DataMetadata) {
                arrayList3.add(obj8);
            }
        }
        Iterator it3 = arrayList3.iterator();
        while (true) {
            if (it3.hasNext()) {
                obj4 = it3.next();
                if (((NativeAdAssetMetadata) obj4).getId() == 6) {
                    break;
                }
            } else {
                obj4 = null;
                break;
            }
        }
        NativeAdAssetMetadata.DataMetadata dataMetadata2 = (NativeAdAssetMetadata.DataMetadata) ((NativeAdAssetMetadata) obj4);
        this.ctaText = dataMetadata2 != null ? dataMetadata2.getValue() : null;
        List<NativeAdAssetMetadata> assets4 = metadata.getAssets();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj9 : assets4) {
            if (obj9 instanceof NativeAdAssetMetadata.VideoMetadata) {
                arrayList4.add(obj9);
            }
        }
        Iterator it4 = arrayList4.iterator();
        while (true) {
            if (it4.hasNext()) {
                obj5 = it4.next();
                if (((NativeAdAssetMetadata) obj5).getId() == 5) {
                    break;
                }
            } else {
                obj5 = null;
                break;
            }
        }
        NativeAdAssetMetadata.VideoMetadata videoMetadata = (NativeAdAssetMetadata.VideoMetadata) ((NativeAdAssetMetadata) obj5);
        if (videoMetadata != null) {
            aspectRatio = videoMetadata.getAspectRatio();
        } else {
            List<NativeAdAssetMetadata> assets5 = metadata.getAssets();
            ArrayList arrayList5 = new ArrayList();
            for (Object obj10 : assets5) {
                if (obj10 instanceof NativeAdAssetMetadata.ImageMetadata) {
                    arrayList5.add(obj10);
                }
            }
            Iterator it5 = arrayList5.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (((NativeAdAssetMetadata) next).getId() == 4) {
                    obj = next;
                    break;
                }
            }
            NativeAdAssetMetadata.ImageMetadata imageMetadata = (NativeAdAssetMetadata.ImageMetadata) ((NativeAdAssetMetadata) obj);
            aspectRatio = imageMetadata != null ? imageMetadata.getAspectRatio() : 0.0f;
        }
        this.mainMediaAspectRatio = aspectRatio;
        this.title = this.titleText;
        this.body = this.bodyText;
        this.callToAction = this.ctaText;
        this.aspectRatio = aspectRatio;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public String getTitle() {
        return this.title;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public String getBody() {
        return this.body;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public Uri getIconUri() {
        return this.iconUri;
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
    public View getPrivacyView() {
        return this.privacyView;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAdRenderer
    public void MainMediaContent(final Function0<Unit> onClicked, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(onClicked, "onClicked");
        Composer startRestartGroup = composer.startRestartGroup(1421399798);
        if ((i & 1) != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1421399798, i, -1, "io.adn.sdk.internal.ui.nativead.MetadataAdRenderer.MainMediaContent (MetadataAdRenderer.kt:48)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.nativead.MetadataAdRenderer$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MainMediaContent$lambda$0;
                    MainMediaContent$lambda$0 = MetadataAdRenderer.MainMediaContent$lambda$0(MetadataAdRenderer.this, onClicked, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MainMediaContent$lambda$0;
                }
            });
        }
    }
}
