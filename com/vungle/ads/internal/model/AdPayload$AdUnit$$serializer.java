package com.vungle.ads.internal.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.AdPayload;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdPayload.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/AdPayload.AdUnit.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/AdPayload$AdUnit;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes7.dex */
public final class AdPayload$AdUnit$$serializer implements GeneratedSerializer<AdPayload.AdUnit> {
    public static final AdPayload$AdUnit$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AdPayload$AdUnit$$serializer adPayload$AdUnit$$serializer = new AdPayload$AdUnit$$serializer();
        INSTANCE = adPayload$AdUnit$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload.AdUnit", adPayload$AdUnit$$serializer, 29);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("ad_type", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.AD_SOURCE, true);
        pluginGeneratedSerialDescriptor.addElement("expiry", true);
        pluginGeneratedSerialDescriptor.addElement("deeplink_url", true);
        pluginGeneratedSerialDescriptor.addElement("click_coordinates_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("ad_load_optimization", true);
        pluginGeneratedSerialDescriptor.addElement("template_heartbeat_check", true);
        pluginGeneratedSerialDescriptor.addElement("mediation_name", true);
        pluginGeneratedSerialDescriptor.addElement("info", true);
        pluginGeneratedSerialDescriptor.addElement("sleep", true);
        pluginGeneratedSerialDescriptor.addElement(AndroidBridgeConstants.ERROR_CODE, true);
        pluginGeneratedSerialDescriptor.addElement("tpat", true);
        pluginGeneratedSerialDescriptor.addElement("vm_url", true);
        pluginGeneratedSerialDescriptor.addElement("vm_version", true);
        pluginGeneratedSerialDescriptor.addElement("ad_market_id", true);
        pluginGeneratedSerialDescriptor.addElement("notification", true);
        pluginGeneratedSerialDescriptor.addElement(Constants.LOAD_AD, true);
        pluginGeneratedSerialDescriptor.addElement("viewability", true);
        pluginGeneratedSerialDescriptor.addElement("template_url", true);
        pluginGeneratedSerialDescriptor.addElement("template_type", true);
        pluginGeneratedSerialDescriptor.addElement("template_settings", true);
        pluginGeneratedSerialDescriptor.addElement(CampaignEx.JSON_KEY_CREATIVE_ID, true);
        pluginGeneratedSerialDescriptor.addElement(MBridgeConstans.APP_ID, true);
        pluginGeneratedSerialDescriptor.addElement("show_close", true);
        pluginGeneratedSerialDescriptor.addElement("show_close_incentivized", true);
        pluginGeneratedSerialDescriptor.addElement("ad_size", true);
        pluginGeneratedSerialDescriptor.addElement("cacheable_assets_required", true);
        pluginGeneratedSerialDescriptor.addElement("webview_settings", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdPayload$AdUnit$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdPayload.TpatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE)), BuiltinSerializersKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE)), BuiltinSerializersKt.getNullable(AdPayload$ViewAbility$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdPayload$TemplateSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdPayload$AdSizeInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdPayload$WebViewSettings$$serializer.INSTANCE)};
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // kotlinx.serialization.DeserializationStrategy
    public com.vungle.ads.internal.model.AdPayload.AdUnit deserialize(kotlinx.serialization.encoding.Decoder r84) {
        /*
            Method dump skipped, instructions count: 2374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.model.AdPayload$AdUnit$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.vungle.ads.internal.model.AdPayload$AdUnit");
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, AdPayload.AdUnit value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AdPayload.AdUnit.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
