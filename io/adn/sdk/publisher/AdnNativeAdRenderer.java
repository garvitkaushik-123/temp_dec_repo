package io.adn.sdk.publisher;

import android.net.Uri;
import android.view.View;
import androidx.compose.runtime.Composer;
import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: AdnNativeAdInfo.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u001cH&J\u001b\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!H'¢\u0006\u0002\u0010\"R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u0006#"}, d2 = {"Lio/adn/sdk/publisher/AdnNativeAdRenderer;", "", "title", "", "getTitle", "()Ljava/lang/String;", "iconUri", "Landroid/net/Uri;", "getIconUri", "()Landroid/net/Uri;", "body", "getBody", "callToAction", "getCallToAction", C3040d4.h.F0, "getAdvertiser", "aspectRatio", "", "getAspectRatio", "()F", "mainMediaView", "Landroid/view/View;", "getMainMediaView", "()Landroid/view/View;", "privacyView", "getPrivacyView", "customData", "id", "", "customMedia", "MainMediaContent", "", "onClicked", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdnNativeAdRenderer {
    void MainMediaContent(Function0<Unit> function0, Composer composer, int i);

    String customData(int id);

    Uri customMedia(int id);

    String getAdvertiser();

    float getAspectRatio();

    String getBody();

    String getCallToAction();

    Uri getIconUri();

    View getMainMediaView();

    View getPrivacyView();

    String getTitle();
}
