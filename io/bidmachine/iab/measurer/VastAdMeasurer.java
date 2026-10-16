package io.bidmachine.iab.measurer;

import android.view.View;
import io.bidmachine.iab.vast.VastRequest;

/* loaded from: classes7.dex */
public interface VastAdMeasurer extends AdMeasurer<View> {
    void onVastModelLoaded(VastRequest vastRequest);
}
