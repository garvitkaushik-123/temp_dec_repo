package adn.analytics;

import adn.analytics.Analytics;
import adn.analytics.AnalyticsDataKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsDataKt.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\"\u0017\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015\"\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"analyticsData", "Ladn/analytics/Analytics$AnalyticsData;", "block", "Lkotlin/Function1;", "Ladn/analytics/AnalyticsDataKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeanalyticsData", "copy", "perfMetricsOrNull", "Ladn/analytics/Analytics$PerformanceMetrics;", "Ladn/analytics/Analytics$AnalyticsDataOrBuilder;", "getPerfMetricsOrNull", "(Ladn/analytics/Analytics$AnalyticsDataOrBuilder;)Ladn/analytics/Analytics$PerformanceMetrics;", "attributionOrNull", "Ladn/analytics/Analytics$Attribution;", "getAttributionOrNull", "(Ladn/analytics/Analytics$AnalyticsDataOrBuilder;)Ladn/analytics/Analytics$Attribution;", "revGenOrNull", "Ladn/analytics/Analytics$RevenueGeneration;", "getRevGenOrNull", "(Ladn/analytics/Analytics$AnalyticsDataOrBuilder;)Ladn/analytics/Analytics$RevenueGeneration;", "revGenSinceInstallOrNull", "getRevGenSinceInstallOrNull", "hasLastClickOrNull", "Ladn/analytics/Analytics$LastClick;", "getHasLastClickOrNull", "(Ladn/analytics/Analytics$AnalyticsDataOrBuilder;)Ladn/analytics/Analytics$LastClick;", "adn-protos"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnalyticsDataKtKt {
    /* renamed from: -initializeanalyticsData, reason: not valid java name */
    public static final Analytics.AnalyticsData m305initializeanalyticsData(Function1<? super AnalyticsDataKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AnalyticsDataKt.Dsl.Companion companion = AnalyticsDataKt.Dsl.INSTANCE;
        Analytics.AnalyticsData.Builder newBuilder = Analytics.AnalyticsData.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder(...)");
        AnalyticsDataKt.Dsl _create = companion._create(newBuilder);
        block.invoke(_create);
        return _create._build();
    }

    public static final Analytics.AnalyticsData copy(Analytics.AnalyticsData analyticsData, Function1<? super AnalyticsDataKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(analyticsData, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        AnalyticsDataKt.Dsl.Companion companion = AnalyticsDataKt.Dsl.INSTANCE;
        Analytics.AnalyticsData.Builder builder = analyticsData.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "toBuilder(...)");
        AnalyticsDataKt.Dsl _create = companion._create(builder);
        block.invoke(_create);
        return _create._build();
    }

    public static final Analytics.PerformanceMetrics getPerfMetricsOrNull(Analytics.AnalyticsDataOrBuilder analyticsDataOrBuilder) {
        Intrinsics.checkNotNullParameter(analyticsDataOrBuilder, "<this>");
        if (analyticsDataOrBuilder.hasPerfMetrics()) {
            return analyticsDataOrBuilder.getPerfMetrics();
        }
        return null;
    }

    public static final Analytics.Attribution getAttributionOrNull(Analytics.AnalyticsDataOrBuilder analyticsDataOrBuilder) {
        Intrinsics.checkNotNullParameter(analyticsDataOrBuilder, "<this>");
        if (analyticsDataOrBuilder.hasAttribution()) {
            return analyticsDataOrBuilder.getAttribution();
        }
        return null;
    }

    public static final Analytics.RevenueGeneration getRevGenOrNull(Analytics.AnalyticsDataOrBuilder analyticsDataOrBuilder) {
        Intrinsics.checkNotNullParameter(analyticsDataOrBuilder, "<this>");
        if (analyticsDataOrBuilder.hasRevGen()) {
            return analyticsDataOrBuilder.getRevGen();
        }
        return null;
    }

    public static final Analytics.RevenueGeneration getRevGenSinceInstallOrNull(Analytics.AnalyticsDataOrBuilder analyticsDataOrBuilder) {
        Intrinsics.checkNotNullParameter(analyticsDataOrBuilder, "<this>");
        if (analyticsDataOrBuilder.hasRevGenSinceInstall()) {
            return analyticsDataOrBuilder.getRevGenSinceInstall();
        }
        return null;
    }

    public static final Analytics.LastClick getHasLastClickOrNull(Analytics.AnalyticsDataOrBuilder analyticsDataOrBuilder) {
        Intrinsics.checkNotNullParameter(analyticsDataOrBuilder, "<this>");
        if (analyticsDataOrBuilder.hasHasLastClick()) {
            return analyticsDataOrBuilder.getHasLastClick();
        }
        return null;
    }
}
