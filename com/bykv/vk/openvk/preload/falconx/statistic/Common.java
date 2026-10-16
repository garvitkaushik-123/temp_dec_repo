package com.bykv.vk.openvk.preload.falconx.statistic;

import android.os.Build;
import com.bykv.vk.openvk.preload.a.a.b;
import com.ironsource.N6;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;

/* loaded from: classes3.dex */
public class Common {

    @b(a = BidTokenRepositoryKt.APP_VERSION)
    public String appVersion;

    @b(a = "device_id")
    public String deviceId;

    @b(a = "region")
    public String region;

    @b(a = BidTokenRepositoryKt.SDK_VERSION)
    public String sdkVersion = "2.0.3-rc.9-pangle";

    @b(a = BidTokenRepositoryKt.DEVICE_MODEL)
    public String deviceModel = Build.MODEL;

    @b(a = N6.F)
    public int os = 0;
}
