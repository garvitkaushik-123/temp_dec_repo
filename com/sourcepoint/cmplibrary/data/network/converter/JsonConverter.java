package com.sourcepoint.cmplibrary.data.network.converter;

import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.core.layout.model.NativeMessageDto;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PvDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceResp;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.ConsentActionImpl;
import com.sourcepoint.cmplibrary.model.ConsentResp;
import com.sourcepoint.cmplibrary.model.CustomConsentResp;
import com.sourcepoint.cmplibrary.model.NativeMessageRespK;
import kotlin.Metadata;

/* compiled from: JsonConverter.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 !2\u00020\u0001:\u0001!J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\""}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter;", "", "toCcpaPostChoiceResp", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "body", "", "toChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "toConsentAction", "Lcom/sourcepoint/cmplibrary/model/ConsentActionImpl;", "toConsentResp", "Lcom/sourcepoint/cmplibrary/model/ConsentResp;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "toConsentStatusResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp;", "toCustomConsentResp", "Lcom/sourcepoint/cmplibrary/model/CustomConsentResp;", "toGdprPostChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "toMessagesResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "toMetaDataRespResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "toNativeMessageDto", "Lcom/sourcepoint/cmplibrary/core/layout/model/NativeMessageDto;", "toNativeMessageRespK", "Lcom/sourcepoint/cmplibrary/model/NativeMessageRespK;", "toPvDataResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp;", "toUsNatPostChoiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface JsonConverter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Either<CcpaCS> toCcpaPostChoiceResp(String body);

    Either<ChoiceResp> toChoiceResp(String body);

    Either<ConsentActionImpl> toConsentAction(String body);

    Either<ConsentResp> toConsentResp(String body, CampaignType campaignType);

    Either<ConsentStatusResp> toConsentStatusResp(String body);

    Either<CustomConsentResp> toCustomConsentResp(String body);

    Either<GdprCS> toGdprPostChoiceResp(String body);

    Either<MessagesResp> toMessagesResp(String body);

    Either<MetaDataResp> toMetaDataRespResp(String body);

    Either<NativeMessageDto> toNativeMessageDto(String body);

    Either<NativeMessageRespK> toNativeMessageRespK(String body);

    Either<PvDataResp> toPvDataResp(String body);

    Either<USNatConsentData> toUsNatPostChoiceResp(String body);

    /* compiled from: JsonConverter.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter$Companion;", "", "()V", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
