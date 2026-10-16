package io.bidmachine.iab.vast;

import io.bidmachine.iab.IabError;
import io.bidmachine.iab.vast.processor.VastAd;

/* loaded from: classes7.dex */
public interface VastVideoLoadedListener {
    void onError(VastRequest vastRequest, IabError iabError);

    void onSuccess(VastRequest vastRequest, VastAd vastAd);
}
