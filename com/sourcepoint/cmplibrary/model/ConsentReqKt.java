package com.sourcepoint.cmplibrary.model;

import com.sourcepoint.cmplibrary.model.exposed.SPCustomConsents;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ConsentReq.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"toBodyRequest", "", "Lcom/sourcepoint/cmplibrary/model/CustomConsentReq;", "toBodyRequestDeleteCustomConsentTo", "toSpCustomConsent", "Lcom/sourcepoint/cmplibrary/model/exposed/SPCustomConsents;", "Lcom/sourcepoint/cmplibrary/model/CustomConsentResp;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsentReqKt {
    public static final String toBodyRequest(CustomConsentReq customConsentReq) {
        Intrinsics.checkNotNullParameter(customConsentReq, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("consentUUID", customConsentReq.getConsentUUID());
        jSONObject.put("propertyId", customConsentReq.getPropertyId());
        jSONObject.put("vendors", new JSONArray((Collection) customConsentReq.getVendors()));
        jSONObject.put("categories", new JSONArray((Collection) customConsentReq.getCategories()));
        jSONObject.put("legIntCategories", new JSONArray((Collection) customConsentReq.getLegIntCategories()));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        return jSONObject2;
    }

    public static final String toBodyRequestDeleteCustomConsentTo(CustomConsentReq customConsentReq) {
        Intrinsics.checkNotNullParameter(customConsentReq, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("vendors", new JSONArray((Collection) customConsentReq.getVendors()));
        jSONObject.put("categories", new JSONArray((Collection) customConsentReq.getCategories()));
        jSONObject.put("legIntCategories", new JSONArray((Collection) customConsentReq.getLegIntCategories()));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        return jSONObject2;
    }

    public static final SPCustomConsents toSpCustomConsent(CustomConsentResp customConsentResp) {
        Intrinsics.checkNotNullParameter(customConsentResp, "<this>");
        return new SPCustomConsents(customConsentResp.getContent());
    }
}
