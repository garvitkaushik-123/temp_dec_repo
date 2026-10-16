package io.bidmachine.protobuf.analytics;

import com.explorestack.protobuf.MessageOrBuilder;
import io.bidmachine.protobuf.analytics.SDKAnalyticPayload;
import java.util.List;

/* loaded from: classes8.dex */
public interface SDKAnalyticPayloadOrBuilder extends MessageOrBuilder {
    SDKAnalyticPayload.Metric getMetrics(int i);

    int getMetricsCount();

    List<SDKAnalyticPayload.Metric> getMetricsList();

    SDKAnalyticPayload.MetricOrBuilder getMetricsOrBuilder(int i);

    List<? extends SDKAnalyticPayload.MetricOrBuilder> getMetricsOrBuilderList();
}
