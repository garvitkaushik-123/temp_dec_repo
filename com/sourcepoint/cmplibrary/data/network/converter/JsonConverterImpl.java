package com.sourcepoint.cmplibrary.data.network.converter;

import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.core.layout.model.NativeMessageDto;
import com.sourcepoint.cmplibrary.core.layout.model.NativeMessageDtoExtKt;
import com.sourcepoint.cmplibrary.data.network.model.ConsentRespExtKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PvDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceResp;
import com.sourcepoint.cmplibrary.exception.ApiRequestPostfix;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.ConsentActionImpl;
import com.sourcepoint.cmplibrary.model.ConsentResp;
import com.sourcepoint.cmplibrary.model.CustomConsentResp;
import com.sourcepoint.cmplibrary.model.JsonToMapExtKt;
import com.sourcepoint.cmplibrary.model.NativeMessageRespK;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import org.json.JSONObject;

/* compiled from: JsonConverterImpl.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\""}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverterImpl;", "Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter;", "()V", "toCcpaPostChoiceResp", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "body", "", "toChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "toConsentAction", "Lcom/sourcepoint/cmplibrary/model/ConsentActionImpl;", "toConsentResp", "Lcom/sourcepoint/cmplibrary/model/ConsentResp;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "toConsentStatusResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp;", "toCustomConsentResp", "Lcom/sourcepoint/cmplibrary/model/CustomConsentResp;", "toGdprPostChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "toMessagesResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "toMetaDataRespResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "toNativeMessageDto", "Lcom/sourcepoint/cmplibrary/core/layout/model/NativeMessageDto;", "toNativeMessageRespK", "Lcom/sourcepoint/cmplibrary/model/NativeMessageRespK;", "toPvDataResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp;", "toUsNatPostChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class JsonConverterImpl implements JsonConverter {
    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<ConsentActionImpl> toConsentAction(final String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return FunctionalUtilsKt.check(new Function0<ConsentActionImpl>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toConsentAction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConsentActionImpl invoke() {
                return ConsentRespExtKt.toConsentAction(body);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<NativeMessageRespK> toNativeMessageRespK(final String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return FunctionalUtilsKt.check(new Function0<NativeMessageRespK>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toNativeMessageRespK$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NativeMessageRespK invoke() {
                Map<String, Object> map = JsonToMapExtKt.getMap(JsonToMapExtKt.toTreeMap(new JSONObject(body)), "msgJSON");
                Intrinsics.checkNotNull(map);
                return new NativeMessageRespK(NativeMessageDtoExtKt.toNativeMessageDto(map));
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<ConsentResp> toConsentResp(final String body, final CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return FunctionalUtilsKt.check(new Function0<ConsentResp>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toConsentResp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConsentResp invoke() {
                JSONObject jSONObject;
                JSONObject jSONObject2 = new JSONObject(body);
                Map<String, Object> treeMap = JsonToMapExtKt.toTreeMap(new JSONObject(body));
                Map<String, Object> map = JsonToMapExtKt.getMap(treeMap, "localState");
                if (map == null || (jSONObject = JsonToMapExtKt.toJSONObj(map)) == null) {
                    jSONObject = new JSONObject();
                }
                String str = (String) JsonToMapExtKt.getFieldValue(treeMap, "uuid");
                if (str == null) {
                    str = "invalid";
                }
                jSONObject2.get("userConsent");
                JSONObject jSONObject3 = new JSONObject(body);
                String jSONObject4 = jSONObject.toString();
                String obj = jSONObject2.get("userConsent").toString();
                Intrinsics.checkNotNull(jSONObject4);
                return new ConsentResp(jSONObject3, obj, str, jSONObject4, campaignType);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<CustomConsentResp> toCustomConsentResp(final String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return FunctionalUtilsKt.check(new Function0<CustomConsentResp>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toCustomConsentResp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CustomConsentResp invoke() {
                return new CustomConsentResp(new JSONObject(body));
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<NativeMessageDto> toNativeMessageDto(final String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return FunctionalUtilsKt.check(new Function0<NativeMessageDto>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toNativeMessageDto$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NativeMessageDto invoke() {
                return NativeMessageDtoExtKt.toNativeMessageDto(JsonToMapExtKt.toTreeMap(new JSONObject(body)));
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<MetaDataResp> toMetaDataRespResp(final String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return FunctionalUtilsKt.check(ApiRequestPostfix.META_DATA, new Function0<MetaDataResp>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toMetaDataRespResp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MetaDataResp invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                String str = body;
                converter.getSerializersModule();
                return (MetaDataResp) converter.decodeFromString(MetaDataResp.INSTANCE.serializer(), str);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<ConsentStatusResp> toConsentStatusResp(final String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return FunctionalUtilsKt.check(ApiRequestPostfix.CONSENT_STATUS, new Function0<ConsentStatusResp>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toConsentStatusResp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConsentStatusResp invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                String str = body;
                converter.getSerializersModule();
                return (ConsentStatusResp) converter.decodeFromString(ConsentStatusResp.INSTANCE.serializer(), str);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<ChoiceResp> toChoiceResp(final String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return FunctionalUtilsKt.check(ApiRequestPostfix.GET_CHOICE, new Function0<ChoiceResp>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toChoiceResp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ChoiceResp invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                String str = body;
                converter.getSerializersModule();
                return (ChoiceResp) converter.decodeFromString(ChoiceResp.INSTANCE.serializer(), str);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<GdprCS> toGdprPostChoiceResp(final String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return FunctionalUtilsKt.check(ApiRequestPostfix.POST_CHOICE_GDPR, new Function0<GdprCS>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toGdprPostChoiceResp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GdprCS invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                String str = body;
                converter.getSerializersModule();
                return (GdprCS) converter.decodeFromString(GdprCS.INSTANCE.serializer(), str);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<CcpaCS> toCcpaPostChoiceResp(final String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return FunctionalUtilsKt.check(ApiRequestPostfix.POST_CHOICE_CCPA, new Function0<CcpaCS>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toCcpaPostChoiceResp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CcpaCS invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                String str = body;
                converter.getSerializersModule();
                return (CcpaCS) converter.decodeFromString(CcpaCS.INSTANCE.serializer(), str);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<USNatConsentData> toUsNatPostChoiceResp(final String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return FunctionalUtilsKt.check(ApiRequestPostfix.POST_CHOICE_USNAT, new Function0<USNatConsentData>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toUsNatPostChoiceResp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final USNatConsentData invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                String str = body;
                converter.getSerializersModule();
                return (USNatConsentData) converter.decodeFromString(USNatConsentData.INSTANCE.serializer(), str);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<PvDataResp> toPvDataResp(final String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return FunctionalUtilsKt.check(ApiRequestPostfix.PV_DATA, new Function0<PvDataResp>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toPvDataResp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PvDataResp invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                String str = body;
                converter.getSerializersModule();
                return (PvDataResp) converter.decodeFromString(PvDataResp.INSTANCE.serializer(), str);
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.data.network.converter.JsonConverter
    public Either<MessagesResp> toMessagesResp(final String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return FunctionalUtilsKt.check(ApiRequestPostfix.MESSAGES, new Function0<MessagesResp>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImpl$toMessagesResp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MessagesResp invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                String str = body;
                converter.getSerializersModule();
                return (MessagesResp) converter.decodeFromString(MessagesResp.INSTANCE.serializer(), str);
            }
        });
    }
}
