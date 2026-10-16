package io.bidmachine.iab.measurer;

import android.view.View;
import android.view.ViewGroup;
import io.bidmachine.iab.IabError;
import java.io.Serializable;

/* loaded from: classes7.dex */
public interface AdMeasurer<AdView extends View> extends Serializable {
    void onAdClicked();

    void onAdShown();

    void onAdViewReady(AdView adView);

    void onError(IabError iabError);

    void registerAdContainer(ViewGroup container);

    void registerAdView(AdView adView);
}
