package io.adn.sdk.internal.domain.repository;

import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;

/* compiled from: AdMeasurementSessionProvider.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lio/adn/sdk/internal/domain/repository/AdMeasurementSessionProvider;", "", "startSession", "", "registerAdSessionView", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "trackImpression", "trackAdLoad", "stopSession", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdMeasurementSessionProvider {
    void registerAdSessionView(View view);

    void startSession();

    void stopSession();

    void trackAdLoad();

    void trackImpression();
}
