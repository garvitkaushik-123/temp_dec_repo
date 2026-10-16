package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.services.core.properties.SdkProperties;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidGetAdPlayerContext.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0086Bø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetAdPlayerContext;", "", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "(Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/SessionRepository;)V", "invoke", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidGetAdPlayerContext {
    public static final String KEY_GAME_ID = "gameId";
    private final DeviceInfoRepository deviceInfoRepository;
    private final SessionRepository sessionRepository;

    public AndroidGetAdPlayerContext(DeviceInfoRepository deviceInfoRepository, SessionRepository sessionRepository) {
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Continuation<? super Map<String, ? extends Object>> continuation) {
        AndroidGetAdPlayerContext$invoke$1 androidGetAdPlayerContext$invoke$1;
        int i;
        AndroidGetAdPlayerContext androidGetAdPlayerContext;
        String gameId;
        if (continuation instanceof AndroidGetAdPlayerContext$invoke$1) {
            androidGetAdPlayerContext$invoke$1 = (AndroidGetAdPlayerContext$invoke$1) continuation;
            if ((androidGetAdPlayerContext$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidGetAdPlayerContext$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = androidGetAdPlayerContext$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidGetAdPlayerContext$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    DeviceInfoRepository deviceInfoRepository = this.deviceInfoRepository;
                    androidGetAdPlayerContext$invoke$1.L$0 = this;
                    androidGetAdPlayerContext$invoke$1.label = 1;
                    obj = deviceInfoRepository.staticDeviceInfo(androidGetAdPlayerContext$invoke$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    androidGetAdPlayerContext = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    androidGetAdPlayerContext = (AndroidGetAdPlayerContext) androidGetAdPlayerContext$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo = (StaticDeviceInfoOuterClass.StaticDeviceInfo) obj;
                DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo = androidGetAdPlayerContext.deviceInfoRepository.getDynamicDeviceInfo();
                gameId = androidGetAdPlayerContext.sessionRepository.getGameId();
                if (gameId == null) {
                    gameId = "";
                }
                return MapsKt.mapOf(TuplesKt.to("bundleId", staticDeviceInfo.getBundleId()), TuplesKt.to("bundleVersion", staticDeviceInfo.getBundleVersion()), TuplesKt.to("webviewHash", "unknown"), TuplesKt.to("sdkVersion", Boxing.boxInt(SdkProperties.getVersionCode())), TuplesKt.to("sdkVersionName", SdkProperties.getVersionName()), TuplesKt.to("osVersion", staticDeviceInfo.getOsVersion()), TuplesKt.to("systemLanguage", Locale.getDefault().toString()), TuplesKt.to("deviceModel", staticDeviceInfo.getDeviceModel()), TuplesKt.to("limitAdTracking", Boxing.boxBoolean(dynamicDeviceInfo.getLimitedTracking())), TuplesKt.to("maxVolume", Boxing.boxDouble(dynamicDeviceInfo.getAndroid().getMaxVolume())), TuplesKt.to(KEY_GAME_ID, gameId));
            }
        }
        androidGetAdPlayerContext$invoke$1 = new AndroidGetAdPlayerContext$invoke$1(this, continuation);
        Object obj2 = androidGetAdPlayerContext$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidGetAdPlayerContext$invoke$1.label;
        if (i != 0) {
        }
        StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo2 = (StaticDeviceInfoOuterClass.StaticDeviceInfo) obj2;
        DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo2 = androidGetAdPlayerContext.deviceInfoRepository.getDynamicDeviceInfo();
        gameId = androidGetAdPlayerContext.sessionRepository.getGameId();
        if (gameId == null) {
        }
        return MapsKt.mapOf(TuplesKt.to("bundleId", staticDeviceInfo2.getBundleId()), TuplesKt.to("bundleVersion", staticDeviceInfo2.getBundleVersion()), TuplesKt.to("webviewHash", "unknown"), TuplesKt.to("sdkVersion", Boxing.boxInt(SdkProperties.getVersionCode())), TuplesKt.to("sdkVersionName", SdkProperties.getVersionName()), TuplesKt.to("osVersion", staticDeviceInfo2.getOsVersion()), TuplesKt.to("systemLanguage", Locale.getDefault().toString()), TuplesKt.to("deviceModel", staticDeviceInfo2.getDeviceModel()), TuplesKt.to("limitAdTracking", Boxing.boxBoolean(dynamicDeviceInfo2.getLimitedTracking())), TuplesKt.to("maxVolume", Boxing.boxDouble(dynamicDeviceInfo2.getAndroid().getMaxVolume())), TuplesKt.to(KEY_GAME_ID, gameId));
    }
}
