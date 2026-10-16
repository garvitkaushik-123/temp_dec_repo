package com.moloco.sdk.internal.services.config;

import com.moloco.sdk.ConfigsOuterClass;
import com.moloco.sdk.Init;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b implements a {
    public static final int e = 8;

    /* renamed from: a, reason: collision with root package name */
    public final String f5671a = "RemoteConfigService";
    public final Map<String, Object> b = new LinkedHashMap();
    public final Map<String, String> c = new LinkedHashMap();
    public final List<com.moloco.sdk.internal.services.config.handlers.a> d = CollectionsKt.listOf(new com.moloco.sdk.internal.services.config.handlers.b());

    @Override // com.moloco.sdk.internal.services.config.a
    public void a(Init.SDKInitResponse sdkInitResponse) {
        Intrinsics.checkNotNullParameter(sdkInitResponse, "sdkInitResponse");
        b(sdkInitResponse);
        c(sdkInitResponse);
    }

    @Override // com.moloco.sdk.internal.services.config.a
    public String b(String featureFlagName) {
        Intrinsics.checkNotNullParameter(featureFlagName, "featureFlagName");
        return this.c.get(featureFlagName);
    }

    public final void c(Init.SDKInitResponse sDKInitResponse) {
        List<Init.SDKInitResponse.ExperimentalFeatureFlag> experimentalFeatureFlagsList = sDKInitResponse.getExperimentalFeatureFlagsList();
        Intrinsics.checkNotNullExpressionValue(experimentalFeatureFlagsList, "getExperimentalFeatureFlagsList(...)");
        for (Init.SDKInitResponse.ExperimentalFeatureFlag experimentalFeatureFlag : experimentalFeatureFlagsList) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f5671a, "Adding ExperimentalFeatureFlag: " + experimentalFeatureFlag.getName(), null, false, 12, null);
            Map<String, String> map = this.c;
            String name = experimentalFeatureFlag.getName();
            String value = experimentalFeatureFlag.getValue();
            map.put(name, (value == null || value.length() == 0) ? null : experimentalFeatureFlag.getValue());
        }
    }

    public final l d(Init.SDKInitResponse sDKInitResponse) {
        l lVar;
        List<Init.SDKInitResponse.ExperimentalFeatureFlag> experimentalFeatureFlagsList = sDKInitResponse.getExperimentalFeatureFlagsList();
        Intrinsics.checkNotNullExpressionValue(experimentalFeatureFlagsList, "getExperimentalFeatureFlagsList(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(experimentalFeatureFlagsList, 10));
        Iterator<T> it = experimentalFeatureFlagsList.iterator();
        while (it.hasNext()) {
            arrayList.add(((Init.SDKInitResponse.ExperimentalFeatureFlag) it.next()).getName());
        }
        boolean contains = arrayList.contains("ANDROID_STREAMING_ENABLED");
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, this.f5671a, "Adding StreamingEnabled: " + contains, null, false, 12, null);
        if (sDKInitResponse.hasConfigs() && sDKInitResponse.getConfigs().hasCommonConfigs() && sDKInitResponse.getConfigs().getCommonConfigs().hasMediaConfig()) {
            ConfigsOuterClass.Configs.CommonConfigs.MediaConfig mediaConfig = sDKInitResponse.getConfigs().getCommonConfigs().getMediaConfig();
            lVar = new l(((int) sDKInitResponse.getConfigs().getCommonConfigs().getMediaConfig().getStreamingChunkSizeKilobytes()) > 0 ? ((int) mediaConfig.getStreamingChunkSizeKilobytes()) * 1024 : m.a().e(), contains, sDKInitResponse.getConfigs().getCommonConfigs().getMediaConfig().getMinStreamingPlayableDurationOnTimeoutSecs() > 0.0d ? mediaConfig.getMinStreamingPlayableDurationOnTimeoutSecs() : m.a().g(), m.a().f());
        } else {
            lVar = new l(m.a().e(), contains, m.a().g(), m.a().f());
        }
        MolocoLogger.debug$default(molocoLogger, this.f5671a, "Parsed and adding MediaConfig: " + lVar.e() + ", " + lVar.h() + ", " + lVar.g() + ", " + lVar.f() + ' ', false, 4, null);
        return lVar;
    }

    public final void b(Init.SDKInitResponse sDKInitResponse) {
        for (com.moloco.sdk.internal.services.config.handlers.a aVar : this.d) {
            this.b.put(aVar.a().getName(), aVar.a(sDKInitResponse));
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f5671a, "Adding config: " + aVar.a().getName(), null, false, 12, null);
        }
        this.b.put(l.class.getName(), d(sDKInitResponse));
    }

    @Override // com.moloco.sdk.internal.services.config.a
    public <T> T a(Class<T> configType, T t) {
        Intrinsics.checkNotNullParameter(configType, "configType");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f5671a, "Retrieving config: " + configType, false, 4, null);
        T t2 = (T) this.b.get(configType.getName());
        return t2 == null ? t : t2;
    }

    @Override // com.moloco.sdk.internal.services.config.a
    public boolean a(String featureFlagName) {
        Intrinsics.checkNotNullParameter(featureFlagName, "featureFlagName");
        return this.c.containsKey(featureFlagName);
    }
}
