package com.inmobi.unification.sdk.model.Initialization;

import com.inmobi.media.C2752le;
import com.inmobi.media.C2784ne;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"com/inmobi/unification/sdk/model/Initialization/TimeoutConfigurations$NonABConfig", "", "<init>", "()V", "Lcom/inmobi/unification/sdk/model/Initialization/TimeoutConfigurations$AdNonABConfig;", "getBanner", "()Lcom/inmobi/unification/sdk/model/Initialization/TimeoutConfigurations$AdNonABConfig;", "getInterstitial", "getNative", "getAudio", "", "isValid", "()Z", "banner", "Lcom/inmobi/unification/sdk/model/Initialization/TimeoutConfigurations$AdNonABConfig;", "int", "native", "audio", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TimeoutConfigurations$NonABConfig {
    private TimeoutConfigurations$AdNonABConfig audio;
    private TimeoutConfigurations$AdNonABConfig banner;
    private TimeoutConfigurations$AdNonABConfig int;
    private TimeoutConfigurations$AdNonABConfig native;

    public TimeoutConfigurations$NonABConfig() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        JSONObject jSONObject8;
        JSONObject jSONObject9;
        JSONObject jSONObject10;
        JSONObject jSONObject11;
        JSONObject jSONObject12;
        JSONObject jSONObject13;
        JSONObject jSONObject14;
        JSONObject jSONObject15;
        JSONObject jSONObject16;
        C2752le c2752le = C2784ne.Companion;
        c2752le.getClass();
        jSONObject = C2784ne.defaultNonABBannerloadTimeout;
        c2752le.getClass();
        jSONObject2 = C2784ne.defaultNonABBannerMuttTimeout;
        c2752le.getClass();
        jSONObject3 = C2784ne.defaultNonABBannerRetryInterval;
        c2752le.getClass();
        jSONObject4 = C2784ne.defaultNonABBannerMaxRetries;
        this.banner = new TimeoutConfigurations$AdNonABConfig(jSONObject, jSONObject2, jSONObject3, jSONObject4);
        c2752le.getClass();
        jSONObject5 = C2784ne.defaultNonABIntloadTimeout;
        c2752le.getClass();
        jSONObject6 = C2784ne.defaultNonABIntMuttTimeout;
        c2752le.getClass();
        jSONObject7 = C2784ne.defaultNonABIntRetryInterval;
        c2752le.getClass();
        jSONObject8 = C2784ne.defaultNonABIntMaxRetries;
        this.int = new TimeoutConfigurations$AdNonABConfig(jSONObject5, jSONObject6, jSONObject7, jSONObject8);
        c2752le.getClass();
        jSONObject9 = C2784ne.defaultNonABNativeloadTimeout;
        c2752le.getClass();
        jSONObject10 = C2784ne.defaultNonABNativeMuttTimeout;
        c2752le.getClass();
        jSONObject11 = C2784ne.defaultNonABNativeRetryInterval;
        c2752le.getClass();
        jSONObject12 = C2784ne.defaultNonABNativeMaxRetries;
        this.native = new TimeoutConfigurations$AdNonABConfig(jSONObject9, jSONObject10, jSONObject11, jSONObject12);
        c2752le.getClass();
        jSONObject13 = C2784ne.defaultNonABAudioloadTimeout;
        c2752le.getClass();
        jSONObject14 = C2784ne.defaultNonABAudioMuttTimeout;
        c2752le.getClass();
        jSONObject15 = C2784ne.defaultNonABAudioRetryInterval;
        c2752le.getClass();
        jSONObject16 = C2784ne.defaultNonABAudioMaxRetries;
        this.audio = new TimeoutConfigurations$AdNonABConfig(jSONObject13, jSONObject14, jSONObject15, jSONObject16);
    }

    public final TimeoutConfigurations$AdNonABConfig getAudio() {
        return this.audio;
    }

    public final TimeoutConfigurations$AdNonABConfig getBanner() {
        return this.banner;
    }

    /* renamed from: getInterstitial, reason: from getter */
    public final TimeoutConfigurations$AdNonABConfig getInt() {
        return this.int;
    }

    public final TimeoutConfigurations$AdNonABConfig getNative() {
        return this.native;
    }

    public final boolean isValid() {
        return this.banner.isValid() && this.int.isValid() && this.native.isValid() && this.audio.isValid();
    }
}
