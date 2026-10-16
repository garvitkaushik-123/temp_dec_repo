package com.sourcepoint.cmplibrary.campaign;

import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessageMetaData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesParamReq;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentStatus;
import com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceResp;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.CampaignReq;
import com.sourcepoint.cmplibrary.model.CampaignTemplate;
import com.sourcepoint.cmplibrary.model.MessageLanguage;
import com.sourcepoint.cmplibrary.model.PMTab;
import com.sourcepoint.cmplibrary.model.PmUrlConfig;
import com.sourcepoint.cmplibrary.model.exposed.MessageSubCategory;
import com.sourcepoint.cmplibrary.model.exposed.SpConfig;
import java.time.Instant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* compiled from: CampaignManager.kt */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 ¤\u00012\u00020\u0001:\u0002¤\u0001J\u0018\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020yH&J\b\u0010z\u001a\u00020uH&J\u0012\u0010{\u001a\u00020u2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010|\u001a\u00020uH&J\u001a\u0010}\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020y0\u007f0~H&J\u0017\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020y0~2\u0006\u0010v\u001a\u00020wH&J\u0014\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H&J\u0014\u0010\u0085\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H&J\u0013\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00032\u0006\u0010v\u001a\u00020wH&J \u0010\u0087\u0001\u001a\u00030\u0084\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H&J/\u0010\u008a\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010~2\u0006\u0010v\u001a\u00020w2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00032\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H&JC\u0010\u008a\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010~2\u0006\u0010v\u001a\u00020w2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00032\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020E2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\u0091\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H&J\u001d\u0010\u0092\u0001\u001a\u00020u2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00032\u0007\u0010\u0094\u0001\u001a\u00020_H&J\u0014\u0010\u0095\u0001\u001a\u00020u2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010VH&J\t\u0010\u0097\u0001\u001a\u00020uH&J\u0014\u0010\u0098\u0001\u001a\u00020E2\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\u009a\u0001\u001a\u00020E2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\u009c\u0001\u001a\u00020E2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010VH&J\"\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u00012\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010 \u0001\u001a\u0004\u0018\u00010\u0003H&J\u0017\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0003H&J\u0013\u0010£\u0001\u001a\u00020E2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0005\"\u0004\b\u0015\u0010\u0007R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u0017X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u001a\u0010#\u001a\u0004\u0018\u00010$X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u0004\u0018\u00010*X¦\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u0010/\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u001a\u00101\u001a\u0004\u0018\u000102X¦\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b8\u0010\u0005\"\u0004\b9\u0010\u0007R\u0014\u0010:\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0005R\u001a\u0010<\u001a\u0004\u0018\u00010\u0017X¦\u000e¢\u0006\f\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001bR\u0012\u0010?\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u001fR\u001a\u0010A\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\bB\u0010\u0005\"\u0004\bC\u0010\u0007R\u0012\u0010D\u001a\u00020EX¦\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0012\u0010H\u001a\u00020EX¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010GR\u0012\u0010I\u001a\u00020EX¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010GR\u0012\u0010J\u001a\u00020EX¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010GR\u0012\u0010K\u001a\u00020LX¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u001a\u0010O\u001a\u0004\u0018\u00010PX¦\u000e¢\u0006\f\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u0004\u0018\u00010VX¦\u000e¢\u0006\f\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\u0004\u0018\u00010PX¦\u000e¢\u0006\f\u001a\u0004\b\\\u0010R\"\u0004\b]\u0010TR\u0018\u0010^\u001a\u00020_X¦\u000e¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0012\u0010d\u001a\u00020EX¦\u0004¢\u0006\u0006\u001a\u0004\be\u0010GR\u0012\u0010f\u001a\u00020gX¦\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0012\u0010j\u001a\u00020$X¦\u0004¢\u0006\u0006\u001a\u0004\bk\u0010&R\u001a\u0010l\u001a\u0004\u0018\u00010mX¦\u000e¢\u0006\f\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0014\u0010r\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bs\u0010\u0005¨\u0006¥\u0001"}, d2 = {"Lcom/sourcepoint/cmplibrary/campaign/CampaignManager;", "", "authId", "", "getAuthId", "()Ljava/lang/String;", "setAuthId", "(Ljava/lang/String;)V", "campaigns4Config", "", "Lcom/sourcepoint/cmplibrary/model/CampaignReq;", "getCampaigns4Config", "()Ljava/util/List;", "ccpaConsentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "getCcpaConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "setCcpaConsentStatus", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;)V", "ccpaDateCreated", "getCcpaDateCreated", "setCcpaDateCreated", "ccpaMessageMetaData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "getCcpaMessageMetaData", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "setCcpaMessageMetaData", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;)V", "ccpaMessageSubCategory", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "getCcpaMessageSubCategory", "()Lcom/sourcepoint/cmplibrary/model/exposed/MessageSubCategory;", "ccpaUuid", "getCcpaUuid", "setCcpaUuid", "choiceResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "getChoiceResp", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "setChoiceResp", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;)V", "dataRecordedConsent", "Ljava/time/Instant;", "getDataRecordedConsent", "()Ljava/time/Instant;", "setDataRecordedConsent", "(Ljava/time/Instant;)V", "gdprAdditionsChangeDate", "getGdprAdditionsChangeDate", C3040d4.i.a0, "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "getGdprConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "setGdprConsentStatus", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;)V", "gdprDateCreated", "getGdprDateCreated", "setGdprDateCreated", "gdprLegalBasisChangeDate", "getGdprLegalBasisChangeDate", "gdprMessageMetaData", "getGdprMessageMetaData", "setGdprMessageMetaData", "gdprMessageSubCategory", "getGdprMessageSubCategory", "gdprUuid", "getGdprUuid", "setGdprUuid", "hasLocalData", "", "getHasLocalData", "()Z", "isCcpaExpired", "isGdprExpired", "isUsnatExpired", "messageLanguage", "Lcom/sourcepoint/cmplibrary/model/MessageLanguage;", "getMessageLanguage", "()Lcom/sourcepoint/cmplibrary/model/MessageLanguage;", "messagesOptimizedLocalState", "Lkotlinx/serialization/json/JsonElement;", "getMessagesOptimizedLocalState", "()Lkotlinx/serialization/json/JsonElement;", "setMessagesOptimizedLocalState", "(Lkotlinx/serialization/json/JsonElement;)V", "metaDataResp", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "getMetaDataResp", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "setMetaDataResp", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;)V", "nonKeyedLocalState", "getNonKeyedLocalState", "setNonKeyedLocalState", "propertyId", "", "getPropertyId", "()I", "setPropertyId", "(I)V", "shouldCallMessages", "getShouldCallMessages", "spConfig", "Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "getSpConfig", "()Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "storeChoiceResp", "getStoreChoiceResp", "usNatConsentData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "getUsNatConsentData", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "setUsNatConsentData", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;)V", "usnatAdditionsChangeDate", "getUsnatAdditionsChangeDate", "addCampaign", "", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "campaign", "Lcom/sourcepoint/cmplibrary/model/CampaignTemplate;", "clearConsents", "consentStatusLog", "deleteExpiredConsents", "getAppliedCampaign", "Lcom/sourcepoint/cmplibrary/core/Either;", "Lkotlin/Pair;", "getCampaignTemplate", "getCcpaPvDataBody", "Lkotlinx/serialization/json/JsonObject;", "messageReq", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;", "getGdprPvDataBody", "getGroupId", "getMessageOptimizedReq", "pubData", "Lorg/json/JSONObject;", "getPmConfig", "Lcom/sourcepoint/cmplibrary/model/PmUrlConfig;", "pmId", "pmTab", "Lcom/sourcepoint/cmplibrary/model/PMTab;", "useGroupPmIfAvailable", "groupPmId", "getUsNatPvDataBody", "handleAuthIdOrPropertyIdChange", "newAuthId", "newPropertyId", "handleMetaDataResponse", C3337ue.n, "handleOldLocalData", "hasGdprVendorListIdChanged", "gdprVendorListId", "hasUsNatVendorListIdChanged", "usNatVendorListId", "hasUsnatApplicableSectionsChanged", "reConsentGdpr", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "additionsChangeDate", "legalBasisChangeDate", "reConsentUsnat", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "shouldCallConsentStatus", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface CampaignManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String SIMPLE_DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    void addCampaign(CampaignType campaignType, CampaignTemplate campaign);

    void clearConsents();

    void consentStatusLog(String authId);

    void deleteExpiredConsents();

    Either<Pair<CampaignType, CampaignTemplate>> getAppliedCampaign();

    String getAuthId();

    Either<CampaignTemplate> getCampaignTemplate(CampaignType campaignType);

    List<CampaignReq> getCampaigns4Config();

    CcpaCS getCcpaConsentStatus();

    String getCcpaDateCreated();

    MessageMetaData getCcpaMessageMetaData();

    MessageSubCategory getCcpaMessageSubCategory();

    JsonObject getCcpaPvDataBody(MessagesParamReq messageReq);

    String getCcpaUuid();

    ChoiceResp getChoiceResp();

    Instant getDataRecordedConsent();

    String getGdprAdditionsChangeDate();

    GdprCS getGdprConsentStatus();

    String getGdprDateCreated();

    String getGdprLegalBasisChangeDate();

    MessageMetaData getGdprMessageMetaData();

    MessageSubCategory getGdprMessageSubCategory();

    JsonObject getGdprPvDataBody(MessagesParamReq messageReq);

    String getGdprUuid();

    String getGroupId(CampaignType campaignType);

    boolean getHasLocalData();

    MessageLanguage getMessageLanguage();

    MessagesParamReq getMessageOptimizedReq(String authId, JSONObject pubData);

    JsonElement getMessagesOptimizedLocalState();

    MetaDataResp getMetaDataResp();

    JsonElement getNonKeyedLocalState();

    Either<PmUrlConfig> getPmConfig(CampaignType campaignType, String pmId, PMTab pmTab);

    Either<PmUrlConfig> getPmConfig(CampaignType campaignType, String pmId, PMTab pmTab, boolean useGroupPmIfAvailable, String groupPmId);

    int getPropertyId();

    boolean getShouldCallMessages();

    SpConfig getSpConfig();

    ChoiceResp getStoreChoiceResp();

    USNatConsentData getUsNatConsentData();

    JsonObject getUsNatPvDataBody(MessagesParamReq messageReq);

    String getUsnatAdditionsChangeDate();

    void handleAuthIdOrPropertyIdChange(String newAuthId, int newPropertyId);

    void handleMetaDataResponse(MetaDataResp response);

    void handleOldLocalData();

    boolean hasGdprVendorListIdChanged(String gdprVendorListId);

    boolean hasUsNatVendorListIdChanged(String usNatVendorListId);

    boolean hasUsnatApplicableSectionsChanged(MetaDataResp response);

    boolean isCcpaExpired();

    boolean isGdprExpired();

    boolean isUsnatExpired();

    ConsentStatus reConsentGdpr(String additionsChangeDate, String legalBasisChangeDate);

    USNatConsentStatus reConsentUsnat(String additionsChangeDate);

    void setAuthId(String str);

    void setCcpaConsentStatus(CcpaCS ccpaCS);

    void setCcpaDateCreated(String str);

    void setCcpaMessageMetaData(MessageMetaData messageMetaData);

    void setCcpaUuid(String str);

    void setChoiceResp(ChoiceResp choiceResp);

    void setDataRecordedConsent(Instant instant);

    void setGdprConsentStatus(GdprCS gdprCS);

    void setGdprDateCreated(String str);

    void setGdprMessageMetaData(MessageMetaData messageMetaData);

    void setGdprUuid(String str);

    void setMessagesOptimizedLocalState(JsonElement jsonElement);

    void setMetaDataResp(MetaDataResp metaDataResp);

    void setNonKeyedLocalState(JsonElement jsonElement);

    void setPropertyId(int i);

    void setUsNatConsentData(USNatConsentData uSNatConsentData);

    boolean shouldCallConsentStatus(String authId);

    /* compiled from: CampaignManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/sourcepoint/cmplibrary/campaign/CampaignManager$Companion;", "", "()V", "SIMPLE_DATE_FORMAT_PATTERN", "", "selectPmId", "userPmId", "childPmId", "useGroupPmIfAvailable", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String SIMPLE_DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

        private Companion() {
        }

        public final String selectPmId(String userPmId, String childPmId, boolean useGroupPmIfAvailable) {
            String str;
            return (!useGroupPmIfAvailable || (str = childPmId) == null || str.length() == 0 || StringsKt.isBlank(str)) ? userPmId == null ? "" : userPmId : childPmId;
        }
    }
}
