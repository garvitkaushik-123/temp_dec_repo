package io.bidmachine.protobuf.rendering;

import com.explorestack.protobuf.MessageOrBuilder;
import io.bidmachine.protobuf.rendering.RenderingFeature;

/* loaded from: classes8.dex */
public interface RenderingFeatureOrBuilder extends MessageOrBuilder {
    RenderingFeature.BrokenCreativeDetector getBrokenCreativeDetector();

    RenderingFeature.BrokenCreativeDetectorOrBuilder getBrokenCreativeDetectorOrBuilder();

    RenderingFeature.FeatureCase getFeatureCase();

    boolean hasBrokenCreativeDetector();
}
