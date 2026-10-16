package adn.analytics;

import adn.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributionKt.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ladn/analytics/AttributionKt;", "", "<init>", "()V", "Dsl", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AttributionKt {
    public static final AttributionKt INSTANCE = new AttributionKt();

    private AttributionKt() {
    }

    /* compiled from: AttributionKt.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\b\u0018\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\u0010J\u0006\u0010\u001a\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020\u0010J\u0006\u0010$\u001a\u00020\u0012J\u0006\u0010(\u001a\u00020\u0010J\u0006\u0010)\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR$\u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR$\u0010%\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000e¨\u0006+"}, d2 = {"Ladn/analytics/AttributionKt$Dsl;", "", "_builder", "Ladn/analytics/Analytics$Attribution$Builder;", "<init>", "(Ladn/analytics/Analytics$Attribution$Builder;)V", "_build", "Ladn/analytics/Analytics$Attribution;", "value", "", "network", "getNetwork", "()Ljava/lang/String;", "setNetwork", "(Ljava/lang/String;)V", "clearNetwork", "", "hasNetwork", "", "", "costAmount", "getCostAmount", "()D", "setCostAmount", "(D)V", "clearCostAmount", "hasCostAmount", "campaign", "getCampaign", "setCampaign", "clearCampaign", "hasCampaign", "costType", "getCostType", "setCostType", "clearCostType", "hasCostType", "costCurrency", "getCostCurrency", "setCostCurrency", "clearCostCurrency", "hasCostCurrency", "Companion", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Analytics.Attribution.Builder _builder;

        public /* synthetic */ Dsl(Analytics.Attribution.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(Analytics.Attribution.Builder builder) {
            this._builder = builder;
        }

        /* compiled from: AttributionKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¨\u0006\b"}, d2 = {"Ladn/analytics/AttributionKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Ladn/analytics/AttributionKt$Dsl;", "builder", "Ladn/analytics/Analytics$Attribution$Builder;", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(Analytics.Attribution.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ Analytics.Attribution _build() {
            Analytics.Attribution build = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }

        public final String getNetwork() {
            String network = this._builder.getNetwork();
            Intrinsics.checkNotNullExpressionValue(network, "getNetwork(...)");
            return network;
        }

        public final void setNetwork(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setNetwork(value);
        }

        public final void clearNetwork() {
            this._builder.clearNetwork();
        }

        public final boolean hasNetwork() {
            return this._builder.hasNetwork();
        }

        public final double getCostAmount() {
            return this._builder.getCostAmount();
        }

        public final void setCostAmount(double d) {
            this._builder.setCostAmount(d);
        }

        public final void clearCostAmount() {
            this._builder.clearCostAmount();
        }

        public final boolean hasCostAmount() {
            return this._builder.hasCostAmount();
        }

        public final String getCampaign() {
            String campaign = this._builder.getCampaign();
            Intrinsics.checkNotNullExpressionValue(campaign, "getCampaign(...)");
            return campaign;
        }

        public final void setCampaign(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCampaign(value);
        }

        public final void clearCampaign() {
            this._builder.clearCampaign();
        }

        public final boolean hasCampaign() {
            return this._builder.hasCampaign();
        }

        public final String getCostType() {
            String costType = this._builder.getCostType();
            Intrinsics.checkNotNullExpressionValue(costType, "getCostType(...)");
            return costType;
        }

        public final void setCostType(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCostType(value);
        }

        public final void clearCostType() {
            this._builder.clearCostType();
        }

        public final boolean hasCostType() {
            return this._builder.hasCostType();
        }

        public final String getCostCurrency() {
            String costCurrency = this._builder.getCostCurrency();
            Intrinsics.checkNotNullExpressionValue(costCurrency, "getCostCurrency(...)");
            return costCurrency;
        }

        public final void setCostCurrency(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCostCurrency(value);
        }

        public final void clearCostCurrency() {
            this._builder.clearCostCurrency();
        }

        public final boolean hasCostCurrency() {
            return this._builder.hasCostCurrency();
        }
    }
}
