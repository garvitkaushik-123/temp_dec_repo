package io.bidmachine.protobuf.rendering;

import com.explorestack.protobuf.MessageOrBuilder;
import io.bidmachine.protobuf.rendering.Rendering;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public interface RenderingOrBuilder extends MessageOrBuilder {
    boolean containsCustomParams(String str);

    Rendering.Background getBackground();

    Rendering.BackgroundOrBuilder getBackgroundOrBuilder();

    Rendering.CacheType getCacheType();

    int getCacheTypeValue();

    @Deprecated
    Map<String, String> getCustomParams();

    int getCustomParamsCount();

    Map<String, String> getCustomParamsMap();

    String getCustomParamsOrDefault(String str, String str2);

    String getCustomParamsOrThrow(String str);

    RenderingFeature getFeatures(int i);

    int getFeaturesCount();

    List<RenderingFeature> getFeaturesList();

    RenderingFeatureOrBuilder getFeaturesOrBuilder(int i);

    List<? extends RenderingFeatureOrBuilder> getFeaturesOrBuilderList();

    Rendering.Orientation getOrientation();

    int getOrientationValue();

    Rendering.Phase getPhases(int i);

    int getPhasesCount();

    List<Rendering.Phase> getPhasesList();

    Rendering.PhaseOrBuilder getPhasesOrBuilder(int i);

    List<? extends Rendering.PhaseOrBuilder> getPhasesOrBuilderList();

    Rendering.ProductConfiguration getProductConfiguration();

    Rendering.ProductConfigurationOrBuilder getProductConfigurationOrBuilder();

    Rendering.SKStoreConfiguration getSkAdNetwork();

    Rendering.SKStoreConfigurationOrBuilder getSkAdNetworkOrBuilder();

    boolean hasBackground();

    boolean hasProductConfiguration();

    boolean hasSkAdNetwork();
}
