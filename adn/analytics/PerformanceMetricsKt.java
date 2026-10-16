package adn.analytics;

import adn.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PerformanceMetricsKt.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ladn/analytics/PerformanceMetricsKt;", "", "<init>", "()V", "Dsl", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PerformanceMetricsKt {
    public static final PerformanceMetricsKt INSTANCE = new PerformanceMetricsKt();

    private PerformanceMetricsKt() {
    }

    /* compiled from: PerformanceMetricsKt.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000e¨\u0006\u0019"}, d2 = {"Ladn/analytics/PerformanceMetricsKt$Dsl;", "", "_builder", "Ladn/analytics/Analytics$PerformanceMetrics$Builder;", "<init>", "(Ladn/analytics/Analytics$PerformanceMetrics$Builder;)V", "_build", "Ladn/analytics/Analytics$PerformanceMetrics;", "value", "", "badFrames", "getBadFrames", "()I", "setBadFrames", "(I)V", "clearBadFrames", "", "hasBadFrames", "", "terribleFrames", "getTerribleFrames", "setTerribleFrames", "clearTerribleFrames", "hasTerribleFrames", "Companion", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Analytics.PerformanceMetrics.Builder _builder;

        public /* synthetic */ Dsl(Analytics.PerformanceMetrics.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(Analytics.PerformanceMetrics.Builder builder) {
            this._builder = builder;
        }

        /* compiled from: PerformanceMetricsKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¨\u0006\b"}, d2 = {"Ladn/analytics/PerformanceMetricsKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Ladn/analytics/PerformanceMetricsKt$Dsl;", "builder", "Ladn/analytics/Analytics$PerformanceMetrics$Builder;", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(Analytics.PerformanceMetrics.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ Analytics.PerformanceMetrics _build() {
            Analytics.PerformanceMetrics build = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }

        public final int getBadFrames() {
            return this._builder.getBadFrames();
        }

        public final void setBadFrames(int i) {
            this._builder.setBadFrames(i);
        }

        public final void clearBadFrames() {
            this._builder.clearBadFrames();
        }

        public final boolean hasBadFrames() {
            return this._builder.hasBadFrames();
        }

        public final int getTerribleFrames() {
            return this._builder.getTerribleFrames();
        }

        public final void setTerribleFrames(int i) {
            this._builder.setTerribleFrames(i);
        }

        public final void clearTerribleFrames() {
            this._builder.clearTerribleFrames();
        }

        public final boolean hasTerribleFrames() {
            return this._builder.hasTerribleFrames();
        }
    }
}
