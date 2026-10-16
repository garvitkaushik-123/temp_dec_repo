package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;

/* loaded from: classes4.dex */
public interface e0 {
    void onAdRefreshFailed(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode);

    void onAdRefreshed(InneractiveAdSpot inneractiveAdSpot);
}
