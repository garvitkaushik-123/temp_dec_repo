package adn.analytics;

import adn.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CountInfoKt.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ladn/analytics/CountInfoKt;", "", "<init>", "()V", "Dsl", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CountInfoKt {
    public static final CountInfoKt INSTANCE = new CountInfoKt();

    private CountInfoKt() {
    }

    /* compiled from: CountInfoKt.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\u0010J\u0006\u0010\u001a\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020\u0010J\u0006\u0010$\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR$\u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000e¨\u0006&"}, d2 = {"Ladn/analytics/CountInfoKt$Dsl;", "", "_builder", "Ladn/analytics/Analytics$CountInfo$Builder;", "<init>", "(Ladn/analytics/Analytics$CountInfo$Builder;)V", "_build", "Ladn/analytics/Analytics$CountInfo;", "value", "", "placement", "getPlacement", "()Ljava/lang/String;", "setPlacement", "(Ljava/lang/String;)V", "clearPlacement", "", "hasPlacement", "", "", "cnt", "getCnt", "()I", "setCnt", "(I)V", "clearCnt", "hasCnt", "creaId", "getCreaId", "setCreaId", "clearCreaId", "hasCreaId", "adNetwork", "getAdNetwork", "setAdNetwork", "clearAdNetwork", "hasAdNetwork", "Companion", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Analytics.CountInfo.Builder _builder;

        public /* synthetic */ Dsl(Analytics.CountInfo.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(Analytics.CountInfo.Builder builder) {
            this._builder = builder;
        }

        /* compiled from: CountInfoKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¨\u0006\b"}, d2 = {"Ladn/analytics/CountInfoKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Ladn/analytics/CountInfoKt$Dsl;", "builder", "Ladn/analytics/Analytics$CountInfo$Builder;", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(Analytics.CountInfo.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ Analytics.CountInfo _build() {
            Analytics.CountInfo build = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }

        public final String getPlacement() {
            String placement = this._builder.getPlacement();
            Intrinsics.checkNotNullExpressionValue(placement, "getPlacement(...)");
            return placement;
        }

        public final void setPlacement(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPlacement(value);
        }

        public final void clearPlacement() {
            this._builder.clearPlacement();
        }

        public final boolean hasPlacement() {
            return this._builder.hasPlacement();
        }

        public final int getCnt() {
            return this._builder.getCnt();
        }

        public final void setCnt(int i) {
            this._builder.setCnt(i);
        }

        public final void clearCnt() {
            this._builder.clearCnt();
        }

        public final boolean hasCnt() {
            return this._builder.hasCnt();
        }

        public final String getCreaId() {
            String creaId = this._builder.getCreaId();
            Intrinsics.checkNotNullExpressionValue(creaId, "getCreaId(...)");
            return creaId;
        }

        public final void setCreaId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCreaId(value);
        }

        public final void clearCreaId() {
            this._builder.clearCreaId();
        }

        public final boolean hasCreaId() {
            return this._builder.hasCreaId();
        }

        public final String getAdNetwork() {
            String adNetwork = this._builder.getAdNetwork();
            Intrinsics.checkNotNullExpressionValue(adNetwork, "getAdNetwork(...)");
            return adNetwork;
        }

        public final void setAdNetwork(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAdNetwork(value);
        }

        public final void clearAdNetwork() {
            this._builder.clearAdNetwork();
        }

        public final boolean hasAdNetwork() {
            return this._builder.hasAdNetwork();
        }
    }
}
