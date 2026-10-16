package io.bidmachine.models;

import android.content.Context;

/* loaded from: classes7.dex */
public interface DeviceInfo {
    String getHttpAgent(Context context);

    String getIfa(Context context);

    boolean isLimitAdTrackingEnabled();
}
