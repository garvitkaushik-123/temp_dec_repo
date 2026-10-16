package com.sourcepoint.cmplibrary.model;

import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.ActionType;
import kotlin.Metadata;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* compiled from: ConsentActionImpl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0017¨\u0006\""}, d2 = {"Lcom/sourcepoint/cmplibrary/model/ConsentAction;", "", "actionType", "Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;", "getActionType", "()Lcom/sourcepoint/cmplibrary/model/exposed/ActionType;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getCampaignType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "choiceId", "", "getChoiceId", "()Ljava/lang/String;", "consentLanguage", "getConsentLanguage", "customActionId", "getCustomActionId", "privacyManagerId", "getPrivacyManagerId", "pubData", "Lorg/json/JSONObject;", "getPubData", "()Lorg/json/JSONObject;", "pubData2", "Lkotlinx/serialization/json/JsonObject;", "getPubData2", "()Lkotlinx/serialization/json/JsonObject;", "requestFromPm", "", "getRequestFromPm", "()Z", "saveAndExitVariables", "getSaveAndExitVariables", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ConsentAction {
    ActionType getActionType();

    CampaignType getCampaignType();

    String getChoiceId();

    String getConsentLanguage();

    String getCustomActionId();

    String getPrivacyManagerId();

    JSONObject getPubData();

    JsonObject getPubData2();

    boolean getRequestFromPm();

    JSONObject getSaveAndExitVariables();
}
