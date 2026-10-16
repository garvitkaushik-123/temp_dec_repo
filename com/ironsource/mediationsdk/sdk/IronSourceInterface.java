package com.ironsource.mediationsdk.sdk;

import android.content.Context;
import com.ironsource.InterfaceC3267qb;
import com.ironsource.T8;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import java.util.Map;

/* loaded from: classes6.dex */
public interface IronSourceInterface extends InterfaceC3267qb, T8 {
    void clearRewardedVideoServerParameters();

    String getAdvertiserId(Context context);

    InterstitialPlacement getInterstitialPlacementInfo(String str);

    Placement getRewardedVideoPlacementInfo(String str);

    void removeInterstitialListener();

    void removeRewardedVideoListener();

    void setAdaptersDebug(boolean z);

    boolean setDynamicUserId(String str);

    void setMediationType(String str);

    void setRewardedVideoServerParameters(Map<String, String> map);

    void shouldTrackNetworkState(Context context, boolean z);
}
