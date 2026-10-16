package com.ironsource.mediationsdk;

import com.ironsource.C3260q4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated(message = "This class is deprecated and will be removed in version 9.0.0.")
/* loaded from: classes6.dex */
public final class WaterfallConfiguration {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final Double f3488a;
    private final Double b;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final WaterfallConfigurationBuilder builder() {
            return new WaterfallConfigurationBuilder();
        }

        @JvmStatic
        public final WaterfallConfiguration empty() {
            return builder().build();
        }

        private Companion() {
        }
    }

    @Deprecated(message = "This class is deprecated and will be removed in version 9.0.0.")
    public static final class WaterfallConfigurationBuilder {

        /* renamed from: a, reason: collision with root package name */
        private Double f3489a;
        private Double b;

        public final WaterfallConfiguration build() {
            return new WaterfallConfiguration(this, null);
        }

        public final Double getCeiling$mediationsdk_release() {
            return this.b;
        }

        public final Double getFloor$mediationsdk_release() {
            return this.f3489a;
        }

        public final WaterfallConfigurationBuilder setCeiling(double d) {
            this.b = Double.valueOf(d);
            return this;
        }

        public final void setCeiling$mediationsdk_release(Double d) {
            this.b = d;
        }

        public final WaterfallConfigurationBuilder setFloor(double d) {
            this.f3489a = Double.valueOf(d);
            return this;
        }

        public final void setFloor$mediationsdk_release(Double d) {
            this.f3489a = d;
        }
    }

    public /* synthetic */ WaterfallConfiguration(WaterfallConfigurationBuilder waterfallConfigurationBuilder, DefaultConstructorMarker defaultConstructorMarker) {
        this(waterfallConfigurationBuilder);
    }

    @JvmStatic
    public static final WaterfallConfigurationBuilder builder() {
        return Companion.builder();
    }

    @JvmStatic
    public static final WaterfallConfiguration empty() {
        return Companion.empty();
    }

    public final Double getCeiling() {
        return this.b;
    }

    public final Double getFloor() {
        return this.f3488a;
    }

    public final String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AndroidBridgeConstants.WATERFALL_CONFIG_CEILING_KEY, this.b);
            jSONObject.put(AndroidBridgeConstants.WATERFALL_CONFIG_FLOOR_KEY, this.f3488a);
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.getMessage());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    public String toString() {
        return "WaterfallConfiguration" + toJsonString();
    }

    private WaterfallConfiguration(WaterfallConfigurationBuilder waterfallConfigurationBuilder) {
        this.f3488a = waterfallConfigurationBuilder.getFloor$mediationsdk_release();
        this.b = waterfallConfigurationBuilder.getCeiling$mediationsdk_release();
    }
}
