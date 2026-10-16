package com.unity3d.ironsourceads;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes7.dex */
public interface InitListener {
    void onInitFailed(IronSourceError ironSourceError);

    void onInitSuccess();
}
