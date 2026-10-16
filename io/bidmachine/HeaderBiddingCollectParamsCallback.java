package io.bidmachine;

import io.bidmachine.utils.BMError;
import java.util.Map;

/* loaded from: classes7.dex */
public interface HeaderBiddingCollectParamsCallback {
    void onCollectFail(BMError error);

    void onCollectFinished(Map<String, String> params);
}
