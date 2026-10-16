package com.sourcepoint.cmplibrary.data.network;

import com.ironsource.D5;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PostChoiceParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PvDataParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PvDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.GetChoiceParamReq;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import com.sourcepoint.cmplibrary.model.CustomConsentReq;
import com.sourcepoint.cmplibrary.model.CustomConsentResp;
import kotlin.Metadata;

/* compiled from: NetworkClient.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000b\u001a\u00020\u000fH&J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u000b\u001a\u00020\u0012H&J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u0006\u0010\u000b\u001a\u00020\u0015H&J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u000b\u001a\u00020\u0018H&J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\u0006\u0010\u000b\u001a\u00020\u001cH&J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u000b\u001a\u00020\u001cH&J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\u0006\u0010\u000b\u001a\u00020\u001cH&¨\u0006!"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/NetworkClient;", "", "deleteCustomConsentTo", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lcom/sourcepoint/cmplibrary/model/CustomConsentResp;", "customConsentReq", "Lcom/sourcepoint/cmplibrary/model/CustomConsentReq;", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "getChoice", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "param", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/GetChoiceParamReq;", "getConsentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusParamReq;", "getMessages", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;", "getMetaData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataParamReq;", "postPvData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataParamReq;", "sendCustomConsent", "storeCcpaChoice", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PostChoiceParamReq;", "storeGdprChoice", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "storeUsNatChoice", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface NetworkClient {
    Either<CustomConsentResp> deleteCustomConsentTo(CustomConsentReq customConsentReq, Env env);

    Either<ChoiceResp> getChoice(GetChoiceParamReq param);

    Either<ConsentStatusResp> getConsentStatus(ConsentStatusParamReq param);

    Either<MessagesResp> getMessages(MessagesParamReq param);

    Either<MetaDataResp> getMetaData(MetaDataParamReq param);

    Either<PvDataResp> postPvData(PvDataParamReq param);

    Either<CustomConsentResp> sendCustomConsent(CustomConsentReq customConsentReq, Env env);

    Either<CcpaCS> storeCcpaChoice(PostChoiceParamReq param);

    Either<GdprCS> storeGdprChoice(PostChoiceParamReq param);

    Either<USNatConsentData> storeUsNatChoice(PostChoiceParamReq param);
}
