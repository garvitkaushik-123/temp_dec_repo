package adn.analytics;

import adn.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PurchaseKt.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ladn/analytics/PurchaseKt;", "", "<init>", "()V", "Dsl", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PurchaseKt {
    public static final PurchaseKt INSTANCE = new PurchaseKt();

    private PurchaseKt() {
    }

    /* compiled from: PurchaseKt.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000e\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020\u0010J\u0006\u0010$\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000e¨\u0006&"}, d2 = {"Ladn/analytics/PurchaseKt$Dsl;", "", "_builder", "Ladn/analytics/Analytics$Purchase$Builder;", "<init>", "(Ladn/analytics/Analytics$Purchase$Builder;)V", "_build", "Ladn/analytics/Analytics$Purchase;", "value", "", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "clearId", "", "hasId", "", "type", "getType", "setType", "clearType", "hasType", "", "price", "getPrice", "()D", "setPrice", "(D)V", "clearPrice", "hasPrice", "currency", "getCurrency", "setCurrency", "clearCurrency", "hasCurrency", "Companion", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Analytics.Purchase.Builder _builder;

        public /* synthetic */ Dsl(Analytics.Purchase.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(Analytics.Purchase.Builder builder) {
            this._builder = builder;
        }

        /* compiled from: PurchaseKt.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¨\u0006\b"}, d2 = {"Ladn/analytics/PurchaseKt$Dsl$Companion;", "", "<init>", "()V", "_create", "Ladn/analytics/PurchaseKt$Dsl;", "builder", "Ladn/analytics/Analytics$Purchase$Builder;", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Dsl _create(Analytics.Purchase.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public final /* synthetic */ Analytics.Purchase _build() {
            Analytics.Purchase build = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }

        public final String getId() {
            String id = this._builder.getId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            return id;
        }

        public final void setId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setId(value);
        }

        public final void clearId() {
            this._builder.clearId();
        }

        public final boolean hasId() {
            return this._builder.hasId();
        }

        public final String getType() {
            String type = this._builder.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            return type;
        }

        public final void setType(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setType(value);
        }

        public final void clearType() {
            this._builder.clearType();
        }

        public final boolean hasType() {
            return this._builder.hasType();
        }

        public final double getPrice() {
            return this._builder.getPrice();
        }

        public final void setPrice(double d) {
            this._builder.setPrice(d);
        }

        public final void clearPrice() {
            this._builder.clearPrice();
        }

        public final boolean hasPrice() {
            return this._builder.hasPrice();
        }

        public final String getCurrency() {
            String currency = this._builder.getCurrency();
            Intrinsics.checkNotNullExpressionValue(currency, "getCurrency(...)");
            return currency;
        }

        public final void setCurrency(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCurrency(value);
        }

        public final void clearCurrency() {
            this._builder.clearCurrency();
        }

        public final boolean hasCurrency() {
            return this._builder.hasCurrency();
        }
    }
}
