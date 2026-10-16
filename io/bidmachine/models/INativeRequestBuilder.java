package io.bidmachine.models;

import io.bidmachine.MediaAssetType;
import io.bidmachine.models.INativeRequestBuilder;

/* loaded from: classes7.dex */
public interface INativeRequestBuilder<SelfType extends INativeRequestBuilder> {
    SelfType setMediaAssetTypes(MediaAssetType... types);
}
