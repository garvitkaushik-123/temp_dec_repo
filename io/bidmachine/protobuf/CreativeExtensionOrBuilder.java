package io.bidmachine.protobuf;

import com.explorestack.protobuf.MessageOrBuilder;
import io.bidmachine.protobuf.CreativeExtension;
import java.util.List;

/* loaded from: classes8.dex */
public interface CreativeExtensionOrBuilder extends MessageOrBuilder {
    CreativeExtension.AssetAppearance getAsset();

    CreativeExtension.AssetAppearanceOrBuilder getAssetOrBuilder();

    CreativeExtension.Feature getFeatures(int i);

    int getFeaturesCount();

    List<CreativeExtension.Feature> getFeaturesList();

    CreativeExtension.FeatureOrBuilder getFeaturesOrBuilder(int i);

    List<? extends CreativeExtension.FeatureOrBuilder> getFeaturesOrBuilderList();

    CreativeExtension.Postbanner getPostbanners(int i);

    int getPostbannersCount();

    List<CreativeExtension.Postbanner> getPostbannersList();

    CreativeExtension.PostbannerOrBuilder getPostbannersOrBuilder(int i);

    List<? extends CreativeExtension.PostbannerOrBuilder> getPostbannersOrBuilderList();

    boolean hasAsset();
}
