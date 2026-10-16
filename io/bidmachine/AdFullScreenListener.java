package io.bidmachine;

import io.bidmachine.IAd;

/* loaded from: classes7.dex */
public interface AdFullScreenListener<AdType extends IAd> {
    void onAdClosed(AdType ad, boolean finished);
}
