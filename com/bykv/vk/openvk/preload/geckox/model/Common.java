package com.bykv.vk.openvk.preload.geckox.model;

import android.os.Build;
import com.bykv.vk.openvk.preload.a.a.b;
import com.ironsource.C3114ha;
import com.ironsource.N6;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;

/* loaded from: classes3.dex */
public class Common {

    @b(a = CampaignEx.KEY_ACTIVITY_PATH_AND_NAME)
    public String ac;

    @b(a = C3114ha.b)
    public long aid;

    @b(a = "app_name")
    public String appName;

    @b(a = BidTokenRepositoryKt.APP_VERSION)
    public String appVersion;

    @b(a = "device_id")
    public String deviceId;

    @b(a = "region")
    public String region;

    @b(a = "uid")
    public String uid;

    @b(a = N6.F)
    public int os = 0;

    @b(a = "os_version")
    public String osVersion = new StringBuilder().append(Build.VERSION.SDK_INT).toString();

    @b(a = BidTokenRepositoryKt.DEVICE_MODEL)
    public String deviceModel = Build.MODEL;

    @b(a = "device_platform")
    public String devicePlatform = "android";

    @b(a = BidTokenRepositoryKt.SDK_VERSION)
    public String sdkVersion = "2.0.3-rc.9-pangle";

    public Common(long j, String str, String str2, String str3, String str4) {
        this.aid = j;
        this.appVersion = str;
        this.deviceId = str2;
        this.appName = str3;
        this.ac = str4;
    }

    public Common(long j, String str, String str2, String str3, String str4, String str5, String str6) {
        this.aid = j;
        this.appVersion = str;
        this.deviceId = str2;
        this.appName = str3;
        this.ac = str4;
        this.uid = str5;
        this.region = str6;
    }
}
