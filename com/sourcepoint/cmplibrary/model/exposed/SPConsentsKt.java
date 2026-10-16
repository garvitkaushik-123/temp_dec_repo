package com.sourcepoint.cmplibrary.model.exposed;

import com.inmobi.sdk.InMobiSdk;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GCMStatus;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GoogleConsentMode;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GranularState;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.model.JsonToMapExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\bH\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\rH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u000eH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u000fH\u0000\u001a\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011*\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0000\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\u000e¨\u0006\u0015"}, d2 = {"isWebConsentEligible", "", "Lcom/sourcepoint/cmplibrary/model/exposed/CCPAConsent;", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRConsent;", "Lcom/sourcepoint/cmplibrary/model/exposed/UsNatConsent;", "toJSONObj", "", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;", "toJsonObject", "Lorg/json/JSONObject;", "Lcom/sourcepoint/cmplibrary/model/exposed/CCPAConsentInternal;", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRConsentInternal;", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "Lcom/sourcepoint/cmplibrary/model/exposed/UsNatConsentInternal;", "toJsonObjectList", "", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$ConsentString;", "toWebViewConsentsJsonObject", "Lkotlinx/serialization/json/JsonObject;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SPConsentsKt {
    public static final boolean isWebConsentEligible(GDPRConsent gDPRConsent) {
        JsonObject webConsentPayload;
        Intrinsics.checkNotNullParameter(gDPRConsent, "<this>");
        String uuid = gDPRConsent.getUuid();
        return (uuid == null || uuid.length() == 0 || (webConsentPayload = gDPRConsent.getWebConsentPayload()) == null || webConsentPayload.isEmpty()) ? false : true;
    }

    public static final boolean isWebConsentEligible(CCPAConsent cCPAConsent) {
        JsonObject webConsentPayload;
        Intrinsics.checkNotNullParameter(cCPAConsent, "<this>");
        String uuid = cCPAConsent.getUuid();
        return (uuid == null || uuid.length() == 0 || (webConsentPayload = cCPAConsent.getWebConsentPayload()) == null || webConsentPayload.isEmpty()) ? false : true;
    }

    public static final boolean isWebConsentEligible(UsNatConsent usNatConsent) {
        JsonObject webConsentPayload;
        Intrinsics.checkNotNullParameter(usNatConsent, "<this>");
        String uuid = usNatConsent.getUuid();
        return (uuid == null || uuid.length() == 0 || (webConsentPayload = usNatConsent.getWebConsentPayload()) == null || webConsentPayload.isEmpty()) ? false : true;
    }

    public static final JSONObject toJsonObject(GDPRConsentInternal gDPRConsentInternal) {
        Intrinsics.checkNotNullParameter(gDPRConsentInternal, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uuid", gDPRConsentInternal.getUuid());
        jSONObject.put("tcData", JsonToMapExtKt.toConsentJSONObj(gDPRConsentInternal.getTcData()));
        jSONObject.put("grants", JsonToMapExtKt.toJSONObjGrant(gDPRConsentInternal.getGrants()));
        jSONObject.put("euconsent", gDPRConsentInternal.getEuconsent());
        jSONObject.put("apply", gDPRConsentInternal.getApplies());
        jSONObject.put("acceptedCategories", new JSONArray((Collection) gDPRConsentInternal.getAcceptedCategories()));
        ConsentStatus consentStatus = gDPRConsentInternal.getConsentStatus();
        jSONObject.put("consentStatus", consentStatus != null ? toJSONObj(consentStatus) : null);
        GoogleConsentMode googleConsentMode = gDPRConsentInternal.getGoogleConsentMode();
        jSONObject.put("googleConsentMode", googleConsentMode != null ? toJSONObj(googleConsentMode) : null);
        return jSONObject;
    }

    public static final Object toJSONObj(GoogleConsentMode googleConsentMode) {
        Intrinsics.checkNotNullParameter(googleConsentMode, "<this>");
        JSONObject jSONObject = new JSONObject();
        GCMStatus adUserData = googleConsentMode.getAdUserData();
        jSONObject.put("ad_user_data", adUserData != null ? adUserData.getStatus() : null);
        GCMStatus adPersonalization = googleConsentMode.getAdPersonalization();
        jSONObject.put("ad_personalization", adPersonalization != null ? adPersonalization.getStatus() : null);
        GCMStatus analyticsStorage = googleConsentMode.getAnalyticsStorage();
        jSONObject.put("analytics_storage", analyticsStorage != null ? analyticsStorage.getStatus() : null);
        GCMStatus adStorage = googleConsentMode.getAdStorage();
        jSONObject.put("ad_storage", adStorage != null ? adStorage.getStatus() : null);
        return jSONObject;
    }

    public static final Object toJSONObj(ConsentStatus consentStatus) {
        Intrinsics.checkNotNullParameter(consentStatus, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("consentedAll", consentStatus.getConsentedAll());
        jSONObject.put("consentedToAny", consentStatus.getConsentedToAny());
        jSONObject.put("hasConsentData", consentStatus.getHasConsentData());
        jSONObject.put("rejectedAny", consentStatus.getRejectedAny());
        jSONObject.put("rejectedLI", consentStatus.getRejectedLI());
        jSONObject.put("legalBasisChanges", consentStatus.getLegalBasisChanges());
        jSONObject.put("vendorListAdditions", consentStatus.getVendorListAdditions());
        ConsentStatus.GranularStatus granularStatus = consentStatus.getGranularStatus();
        jSONObject.put("granularStatus", granularStatus != null ? toJSONObj(granularStatus) : null);
        return jSONObject;
    }

    public static final Object toJSONObj(ConsentStatus.GranularStatus granularStatus) {
        Intrinsics.checkNotNullParameter(granularStatus, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("defaultConsent", granularStatus.getDefaultConsent());
        jSONObject.put("previousOptInAll", granularStatus.getPreviousOptInAll());
        GranularState purposeConsent = granularStatus.getPurposeConsent();
        jSONObject.put("purposeConsent", purposeConsent != null ? purposeConsent.name() : null);
        GranularState purposeLegInt = granularStatus.getPurposeLegInt();
        jSONObject.put("purposeLegInt", purposeLegInt != null ? purposeLegInt.name() : null);
        GranularState vendorConsent = granularStatus.getVendorConsent();
        jSONObject.put("vendorConsent", vendorConsent != null ? vendorConsent.name() : null);
        GranularState vendorLegInt = granularStatus.getVendorLegInt();
        jSONObject.put("vendorLegInt", vendorLegInt != null ? vendorLegInt.name() : null);
        return jSONObject;
    }

    public static final JSONObject toJsonObject(CCPAConsentInternal cCPAConsentInternal) {
        Intrinsics.checkNotNullParameter(cCPAConsentInternal, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uuid", cCPAConsentInternal.getUuid());
        jSONObject.put("gppData", JsonToMapExtKt.toConsentJSONObj(cCPAConsentInternal.getGppData()));
        jSONObject.put("status", cCPAConsentInternal.getStatus());
        jSONObject.put("uspstring", cCPAConsentInternal.getUspstring());
        jSONObject.put("rejectedCategories", new JSONArray((Collection) cCPAConsentInternal.getRejectedCategories()));
        jSONObject.put("apply", cCPAConsentInternal.getApplies());
        jSONObject.put("rejectedVendors", new JSONArray((Collection) cCPAConsentInternal.getRejectedVendors()));
        return jSONObject;
    }

    public static final JSONObject toJsonObject(UsNatConsentInternal usNatConsentInternal) {
        Intrinsics.checkNotNullParameter(usNatConsentInternal, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("applies", usNatConsentInternal.getApplies());
        jSONObject.put("gppData", JsonToMapExtKt.toConsentJSONObj(usNatConsentInternal.getGppData()));
        jSONObject.put("statuses", usNatConsentInternal.getStatuses().toJsonObject());
        jSONObject.put("consentStrings", toJsonObjectList(usNatConsentInternal.getConsentStrings()));
        jSONObject.put("dateCreated", usNatConsentInternal.getDateCreated());
        List<ConsentableImpl> vendors = usNatConsentInternal.getVendors();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(vendors, 10));
        Iterator<T> it = vendors.iterator();
        while (it.hasNext()) {
            arrayList.add(((ConsentableImpl) it.next()).toJsonObject());
        }
        jSONObject.put("vendors", arrayList);
        List<ConsentableImpl> categories = usNatConsentInternal.getCategories();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(categories, 10));
        Iterator<T> it2 = categories.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((ConsentableImpl) it2.next()).toJsonObject());
        }
        jSONObject.put("categories", arrayList2);
        jSONObject.put("uuid", usNatConsentInternal.getUuid());
        return jSONObject;
    }

    public static final JSONObject toJsonObject(SPConsents sPConsents) {
        Intrinsics.checkNotNullParameter(sPConsents, "<this>");
        JSONObject jSONObject = new JSONObject();
        SPGDPRConsent gdpr = sPConsents.getGdpr();
        GDPRConsent consent = gdpr != null ? gdpr.getConsent() : null;
        GDPRConsentInternal gDPRConsentInternal = consent instanceof GDPRConsentInternal ? (GDPRConsentInternal) consent : null;
        jSONObject.put(InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, gDPRConsentInternal != null ? toJsonObject(gDPRConsentInternal) : null);
        SPCCPAConsent ccpa = sPConsents.getCcpa();
        CCPAConsent consent2 = ccpa != null ? ccpa.getConsent() : null;
        CCPAConsentInternal cCPAConsentInternal = consent2 instanceof CCPAConsentInternal ? (CCPAConsentInternal) consent2 : null;
        jSONObject.put("ccpa", cCPAConsentInternal != null ? toJsonObject(cCPAConsentInternal) : null);
        SpUsNatConsent usNat = sPConsents.getUsNat();
        UsNatConsent consent3 = usNat != null ? usNat.getConsent() : null;
        UsNatConsentInternal usNatConsentInternal = consent3 instanceof UsNatConsentInternal ? (UsNatConsentInternal) consent3 : null;
        jSONObject.put("usnat", usNatConsentInternal != null ? toJsonObject(usNatConsentInternal) : null);
        return jSONObject;
    }

    public static final List<JSONObject> toJsonObjectList(List<USNatConsentData.ConsentString> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<USNatConsentData.ConsentString> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (USNatConsentData.ConsentString consentString : list2) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sectionId", consentString.getSectionId());
            jSONObject.put("sectionName", consentString.getSectionName());
            jSONObject.put("consentString", consentString.getConsentString());
            arrayList.add(jSONObject);
        }
        return arrayList;
    }

    public static final JsonObject toWebViewConsentsJsonObject(SPConsents sPConsents) {
        final UsNatConsent consent;
        final GDPRConsent consent2;
        final CCPAConsent consent3;
        Intrinsics.checkNotNullParameter(sPConsents, "<this>");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        SPCCPAConsent ccpa = sPConsents.getCcpa();
        if (ccpa != null && (consent3 = ccpa.getConsent()) != null && isWebConsentEligible(consent3)) {
            JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, "ccpa", new Function1<JsonObjectBuilder, Unit>() { // from class: com.sourcepoint.cmplibrary.model.exposed.SPConsentsKt$toWebViewConsentsJsonObject$1$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                    invoke2(jsonObjectBuilder2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JsonObjectBuilder putJsonObject) {
                    Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                    putJsonObject.put("uuid", JsonElementKt.JsonPrimitive(CCPAConsent.this.getUuid()));
                    putJsonObject.put("webConsentPayload", JsonElementKt.JsonPrimitive(String.valueOf(CCPAConsent.this.getWebConsentPayload())));
                }
            });
        }
        SPGDPRConsent gdpr = sPConsents.getGdpr();
        if (gdpr != null && (consent2 = gdpr.getConsent()) != null && isWebConsentEligible(consent2)) {
            JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, new Function1<JsonObjectBuilder, Unit>() { // from class: com.sourcepoint.cmplibrary.model.exposed.SPConsentsKt$toWebViewConsentsJsonObject$1$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                    invoke2(jsonObjectBuilder2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JsonObjectBuilder putJsonObject) {
                    Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                    putJsonObject.put("uuid", JsonElementKt.JsonPrimitive(GDPRConsent.this.getUuid()));
                    putJsonObject.put("webConsentPayload", JsonElementKt.JsonPrimitive(String.valueOf(GDPRConsent.this.getWebConsentPayload())));
                }
            });
        }
        SpUsNatConsent usNat = sPConsents.getUsNat();
        if (usNat != null && (consent = usNat.getConsent()) != null && isWebConsentEligible(consent)) {
            JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, "usnat", new Function1<JsonObjectBuilder, Unit>() { // from class: com.sourcepoint.cmplibrary.model.exposed.SPConsentsKt$toWebViewConsentsJsonObject$1$3$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                    invoke2(jsonObjectBuilder2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JsonObjectBuilder putJsonObject) {
                    Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                    putJsonObject.put("uuid", JsonElementKt.JsonPrimitive(UsNatConsent.this.getUuid()));
                    putJsonObject.put("webConsentPayload", JsonElementKt.JsonPrimitive(String.valueOf(UsNatConsent.this.getWebConsentPayload())));
                }
            });
        }
        return jsonObjectBuilder.build();
    }
}
