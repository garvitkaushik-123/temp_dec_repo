package io.adn.sdk.publisher;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3207n2;
import kotlin.Metadata;

/* compiled from: AdnAd.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/publisher/AdnFullscreenAd;", "Lio/adn/sdk/publisher/AdnAd;", "setListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/adn/sdk/publisher/AdnFullscreenAdListener;", C3207n2.v, "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdnFullscreenAd extends AdnAd {
    void setListener(AdnFullscreenAdListener listener);

    void show();
}
