package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.model.exposed.CCPAConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.CcpaStatus;
import com.sourcepoint.cmplibrary.model.exposed.ConsentableImpl;
import com.sourcepoint.cmplibrary.model.exposed.GDPRConsentInternal;
import com.sourcepoint.cmplibrary.model.exposed.GDPRPurposeGrants;
import com.sourcepoint.cmplibrary.model.exposed.UsNatConsentInternal;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import com.sourcepoint.cmplibrary.util.extensions.MapExtKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* compiled from: ConsentStatusApiModelExt.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0002H\u0000¨\u0006\u000b"}, d2 = {"stringify", "", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "toCCPAConsentInternal", "Lcom/sourcepoint/cmplibrary/model/exposed/CCPAConsentInternal;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "toGDPRUserConsent", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRConsentInternal;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "toUsNatConsentInternal", "Lcom/sourcepoint/cmplibrary/model/exposed/UsNatConsentInternal;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsentStatusApiModelExtKt {
    public static final GDPRConsentInternal toGDPRUserConsent(GdprCS gdprCS) {
        Map<String, Object> emptyMap;
        Intrinsics.checkNotNullParameter(gdprCS, "<this>");
        String uuid = gdprCS.getUuid();
        Boolean applies = gdprCS.getApplies();
        boolean booleanValue = applies != null ? applies.booleanValue() : false;
        Map<String, JsonElement> tCData = gdprCS.getTCData();
        if (tCData == null || (emptyMap = MapExtKt.toMapOfAny(tCData)) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        Map<String, Object> map = emptyMap;
        Map<String, GDPRPurposeGrants> grants = gdprCS.getGrants();
        if (grants == null) {
            grants = MapsKt.emptyMap();
        }
        Map<String, GDPRPurposeGrants> map2 = grants;
        String euconsent = gdprCS.getEuconsent();
        if (euconsent == null) {
            euconsent = "";
        }
        return new GDPRConsentInternal(euconsent, uuid, map, map2, gdprCS.getCategories(), booleanValue, gdprCS.getConsentStatus(), gdprCS.getGoogleConsentMode(), null, new JSONObject(), gdprCS.getWebConsentPayload());
    }

    public static final CCPAConsentInternal toCCPAConsentInternal(CcpaCS ccpaCS) {
        Map<String, Object> emptyMap;
        Intrinsics.checkNotNullParameter(ccpaCS, "<this>");
        String uuid = ccpaCS.getUuid();
        Boolean applies = ccpaCS.getApplies();
        boolean booleanValue = applies != null ? applies.booleanValue() : false;
        Map<String, JsonElement> gppData = ccpaCS.getGppData();
        if (gppData == null || (emptyMap = MapExtKt.toMapOfAny(gppData)) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        Map<String, Object> map = emptyMap;
        CcpaStatus status = ccpaCS.getStatus();
        List<String> rejectedVendors = ccpaCS.getRejectedVendors();
        if (rejectedVendors == null) {
            rejectedVendors = CollectionsKt.emptyList();
        }
        List<String> list = rejectedVendors;
        List<String> rejectedCategories = ccpaCS.getRejectedCategories();
        if (rejectedCategories == null) {
            rejectedCategories = CollectionsKt.emptyList();
        }
        List<String> list2 = rejectedCategories;
        JSONObject jSONObject = new JSONObject();
        Boolean signedLspa = ccpaCS.getSignedLspa();
        JsonObject webConsentPayload = ccpaCS.getWebConsentPayload();
        String uspstring = ccpaCS.getUspstring();
        if (uspstring == null) {
            uspstring = "1YNN";
        }
        return new CCPAConsentInternal(uuid, map, list2, list, status, uspstring, null, booleanValue, jSONObject, signedLspa, webConsentPayload);
    }

    public static final UsNatConsentInternal toUsNatConsentInternal(USNatConsentData uSNatConsentData) {
        Map<String, Object> emptyMap;
        Intrinsics.checkNotNullParameter(uSNatConsentData, "<this>");
        Boolean applies = uSNatConsentData.getApplies();
        boolean booleanValue = applies != null ? applies.booleanValue() : false;
        Map<String, JsonElement> gppData = uSNatConsentData.getGppData();
        if (gppData == null || (emptyMap = MapExtKt.toMapOfAny(gppData)) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        Map<String, Object> map = emptyMap;
        USNatConsentStatus consentStatus = uSNatConsentData.getConsentStatus();
        List<ConsentableImpl> vendors = uSNatConsentData.getVendors();
        List<ConsentableImpl> categories = uSNatConsentData.getCategories();
        List<USNatConsentData.ConsentString> consentStrings = uSNatConsentData.getConsentStrings();
        if (consentStrings == null) {
            consentStrings = CollectionsKt.emptyList();
        }
        return new UsNatConsentInternal(map, booleanValue, consentStrings, uSNatConsentData.getDateCreated(), vendors, categories, uSNatConsentData.getUuid(), uSNatConsentData.getWebConsentPayload(), consentStatus, uSNatConsentData.getUrl());
    }

    public static final String stringify(final USNatConsentData uSNatConsentData) {
        Object obj;
        Intrinsics.checkNotNullParameter(uSNatConsentData, "<this>");
        Either check = FunctionalUtilsKt.check(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusApiModelExtKt$stringify$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                USNatConsentData uSNatConsentData2 = USNatConsentData.this;
                converter.getSerializersModule();
                return converter.encodeToString(USNatConsentData.INSTANCE.serializer(), uSNatConsentData2);
            }
        });
        if (check instanceof Either.Right) {
            obj = ((Either.Right) check).getR();
        } else {
            if (!(check instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            obj = null;
        }
        return (String) obj;
    }
}
