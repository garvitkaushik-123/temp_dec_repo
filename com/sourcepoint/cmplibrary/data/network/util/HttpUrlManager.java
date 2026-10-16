package com.sourcepoint.cmplibrary.data.network.util;

import com.ironsource.D5;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.PostChoiceParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.GetChoiceParamReq;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.CustomConsentReq;
import com.sourcepoint.cmplibrary.model.PmUrlConfig;
import com.sourcepoint.cmplibrary.model.exposed.MessageType;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* compiled from: HttpUrlManager.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J(\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006!"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/util/HttpUrlManager;", "", "deleteCustomConsentToUrl", "Lokhttp3/HttpUrl;", "host", "", "params", "Lcom/sourcepoint/cmplibrary/model/CustomConsentReq;", "getCcpaChoiceUrl", "param", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PostChoiceParamReq;", "getChoiceUrl", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/GetChoiceParamReq;", "getConsentStatusUrl", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusParamReq;", "getGdprChoiceUrl", "getMessagesUrl", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;", "getMetaDataUrl", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataParamReq;", "getPvDataUrl", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "inAppMessageUrl", "pmUrl", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "pmConfig", "Lcom/sourcepoint/cmplibrary/model/PmUrlConfig;", "messageType", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;", "postUsNatChoiceUrl", "sendCustomConsentUrl", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface HttpUrlManager {
    HttpUrl deleteCustomConsentToUrl(String host, CustomConsentReq params);

    HttpUrl getCcpaChoiceUrl(PostChoiceParamReq param);

    HttpUrl getChoiceUrl(GetChoiceParamReq param);

    HttpUrl getConsentStatusUrl(ConsentStatusParamReq param);

    HttpUrl getGdprChoiceUrl(PostChoiceParamReq param);

    HttpUrl getMessagesUrl(MessagesParamReq param);

    HttpUrl getMetaDataUrl(MetaDataParamReq param);

    HttpUrl getPvDataUrl(Env env);

    HttpUrl inAppMessageUrl(Env env);

    HttpUrl pmUrl(Env env, CampaignType campaignType, PmUrlConfig pmConfig, MessageType messageType);

    HttpUrl postUsNatChoiceUrl(PostChoiceParamReq param);

    HttpUrl sendCustomConsentUrl(Env env);
}
