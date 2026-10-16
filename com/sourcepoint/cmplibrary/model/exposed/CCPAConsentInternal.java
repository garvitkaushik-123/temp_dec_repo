package com.sourcepoint.cmplibrary.model.exposed;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010.\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0017\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00105\u001a\u00020\u000fHÆ\u0003J\t\u00106\u001a\u00020\u0011HÆ\u0003J \u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u000f2\b\u0010:\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006>"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/CCPAConsentInternal;", "Lcom/sourcepoint/cmplibrary/model/exposed/CCPAConsent;", "uuid", "", "gppData", "", "", "rejectedCategories", "", "rejectedVendors", "status", "Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;", "uspstring", "childPmId", "applies", "", "thisContent", "Lorg/json/JSONObject;", "signedLspa", "webConsentPayload", "Lkotlinx/serialization/json/JsonObject;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;Ljava/lang/String;Ljava/lang/String;ZLorg/json/JSONObject;Ljava/lang/Boolean;Lkotlinx/serialization/json/JsonObject;)V", "getApplies", "()Z", "getChildPmId", "()Ljava/lang/String;", "getGppData", "()Ljava/util/Map;", "setGppData", "(Ljava/util/Map;)V", "getRejectedCategories", "()Ljava/util/List;", "getRejectedVendors", "getSignedLspa", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStatus", "()Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;", "getThisContent", "()Lorg/json/JSONObject;", "getUspstring", "getUuid", "getWebConsentPayload", "()Lkotlinx/serialization/json/JsonObject;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;Ljava/lang/String;Ljava/lang/String;ZLorg/json/JSONObject;Ljava/lang/Boolean;Lkotlinx/serialization/json/JsonObject;)Lcom/sourcepoint/cmplibrary/model/exposed/CCPAConsentInternal;", "equals", "other", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CCPAConsentInternal implements CCPAConsent {
    private final boolean applies;
    private final String childPmId;
    private Map<String, ? extends Object> gppData;
    private final List<String> rejectedCategories;
    private final List<String> rejectedVendors;
    private final Boolean signedLspa;
    private final CcpaStatus status;
    private final JSONObject thisContent;
    private final String uspstring;
    private final String uuid;
    private final JsonObject webConsentPayload;

    public CCPAConsentInternal() {
        this(null, null, null, null, null, null, null, false, null, null, null, 2047, null);
    }

    public static /* synthetic */ CCPAConsentInternal copy$default(CCPAConsentInternal cCPAConsentInternal, String str, Map map, List list, List list2, CcpaStatus ccpaStatus, String str2, String str3, boolean z, JSONObject jSONObject, Boolean bool, JsonObject jsonObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cCPAConsentInternal.uuid;
        }
        if ((i & 2) != 0) {
            map = cCPAConsentInternal.gppData;
        }
        if ((i & 4) != 0) {
            list = cCPAConsentInternal.rejectedCategories;
        }
        if ((i & 8) != 0) {
            list2 = cCPAConsentInternal.rejectedVendors;
        }
        if ((i & 16) != 0) {
            ccpaStatus = cCPAConsentInternal.status;
        }
        if ((i & 32) != 0) {
            str2 = cCPAConsentInternal.uspstring;
        }
        if ((i & 64) != 0) {
            str3 = cCPAConsentInternal.childPmId;
        }
        if ((i & 128) != 0) {
            z = cCPAConsentInternal.applies;
        }
        if ((i & 256) != 0) {
            jSONObject = cCPAConsentInternal.thisContent;
        }
        if ((i & 512) != 0) {
            bool = cCPAConsentInternal.signedLspa;
        }
        if ((i & 1024) != 0) {
            jsonObject = cCPAConsentInternal.webConsentPayload;
        }
        Boolean bool2 = bool;
        JsonObject jsonObject2 = jsonObject;
        boolean z2 = z;
        JSONObject jSONObject2 = jSONObject;
        String str4 = str2;
        String str5 = str3;
        CcpaStatus ccpaStatus2 = ccpaStatus;
        List list3 = list;
        return cCPAConsentInternal.copy(str, map, list3, list2, ccpaStatus2, str4, str5, z2, jSONObject2, bool2, jsonObject2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component10, reason: from getter */
    public final Boolean getSignedLspa() {
        return this.signedLspa;
    }

    /* renamed from: component11, reason: from getter */
    public final JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    public final Map<String, Object> component2() {
        return this.gppData;
    }

    public final List<String> component3() {
        return this.rejectedCategories;
    }

    public final List<String> component4() {
        return this.rejectedVendors;
    }

    /* renamed from: component5, reason: from getter */
    public final CcpaStatus getStatus() {
        return this.status;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUspstring() {
        return this.uspstring;
    }

    /* renamed from: component7, reason: from getter */
    public final String getChildPmId() {
        return this.childPmId;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getApplies() {
        return this.applies;
    }

    /* renamed from: component9, reason: from getter */
    public final JSONObject getThisContent() {
        return this.thisContent;
    }

    public final CCPAConsentInternal copy(String uuid, Map<String, ? extends Object> gppData, List<String> rejectedCategories, List<String> rejectedVendors, CcpaStatus status, String uspstring, String childPmId, boolean applies, JSONObject thisContent, Boolean signedLspa, JsonObject webConsentPayload) {
        Intrinsics.checkNotNullParameter(gppData, "gppData");
        Intrinsics.checkNotNullParameter(rejectedCategories, "rejectedCategories");
        Intrinsics.checkNotNullParameter(rejectedVendors, "rejectedVendors");
        Intrinsics.checkNotNullParameter(uspstring, "uspstring");
        Intrinsics.checkNotNullParameter(thisContent, "thisContent");
        return new CCPAConsentInternal(uuid, gppData, rejectedCategories, rejectedVendors, status, uspstring, childPmId, applies, thisContent, signedLspa, webConsentPayload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CCPAConsentInternal)) {
            return false;
        }
        CCPAConsentInternal cCPAConsentInternal = (CCPAConsentInternal) other;
        return Intrinsics.areEqual(this.uuid, cCPAConsentInternal.uuid) && Intrinsics.areEqual(this.gppData, cCPAConsentInternal.gppData) && Intrinsics.areEqual(this.rejectedCategories, cCPAConsentInternal.rejectedCategories) && Intrinsics.areEqual(this.rejectedVendors, cCPAConsentInternal.rejectedVendors) && this.status == cCPAConsentInternal.status && Intrinsics.areEqual(this.uspstring, cCPAConsentInternal.uspstring) && Intrinsics.areEqual(this.childPmId, cCPAConsentInternal.childPmId) && this.applies == cCPAConsentInternal.applies && Intrinsics.areEqual(this.thisContent, cCPAConsentInternal.thisContent) && Intrinsics.areEqual(this.signedLspa, cCPAConsentInternal.signedLspa) && Intrinsics.areEqual(this.webConsentPayload, cCPAConsentInternal.webConsentPayload);
    }

    public int hashCode() {
        String str = this.uuid;
        int hashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.gppData.hashCode()) * 31) + this.rejectedCategories.hashCode()) * 31) + this.rejectedVendors.hashCode()) * 31;
        CcpaStatus ccpaStatus = this.status;
        int hashCode2 = (((hashCode + (ccpaStatus == null ? 0 : ccpaStatus.hashCode())) * 31) + this.uspstring.hashCode()) * 31;
        String str2 = this.childPmId;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.applies)) * 31) + this.thisContent.hashCode()) * 31;
        Boolean bool = this.signedLspa;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        JsonObject jsonObject = this.webConsentPayload;
        return hashCode4 + (jsonObject != null ? jsonObject.hashCode() : 0);
    }

    public String toString() {
        return "CCPAConsentInternal(uuid=" + this.uuid + ", gppData=" + this.gppData + ", rejectedCategories=" + this.rejectedCategories + ", rejectedVendors=" + this.rejectedVendors + ", status=" + this.status + ", uspstring=" + this.uspstring + ", childPmId=" + this.childPmId + ", applies=" + this.applies + ", thisContent=" + this.thisContent + ", signedLspa=" + this.signedLspa + ", webConsentPayload=" + this.webConsentPayload + ")";
    }

    public CCPAConsentInternal(String str, Map<String, ? extends Object> gppData, List<String> rejectedCategories, List<String> rejectedVendors, CcpaStatus ccpaStatus, String uspstring, String str2, boolean z, JSONObject thisContent, Boolean bool, JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(gppData, "gppData");
        Intrinsics.checkNotNullParameter(rejectedCategories, "rejectedCategories");
        Intrinsics.checkNotNullParameter(rejectedVendors, "rejectedVendors");
        Intrinsics.checkNotNullParameter(uspstring, "uspstring");
        Intrinsics.checkNotNullParameter(thisContent, "thisContent");
        this.uuid = str;
        this.gppData = gppData;
        this.rejectedCategories = rejectedCategories;
        this.rejectedVendors = rejectedVendors;
        this.status = ccpaStatus;
        this.uspstring = uspstring;
        this.childPmId = str2;
        this.applies = z;
        this.thisContent = thisContent;
        this.signedLspa = bool;
        this.webConsentPayload = jsonObject;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.CCPAConsent
    public String getUuid() {
        return this.uuid;
    }

    public /* synthetic */ CCPAConsentInternal(String str, Map map, List list, List list2, CcpaStatus ccpaStatus, String str2, String str3, boolean z, JSONObject jSONObject, Boolean bool, JsonObject jsonObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? CollectionsKt.emptyList() : list2, (i & 16) != 0 ? null : ccpaStatus, (i & 32) != 0 ? "1YNN" : str2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? false : z, (i & 256) != 0 ? new JSONObject() : jSONObject, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : jsonObject);
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.CCPAConsent
    public Map<String, Object> getGppData() {
        return this.gppData;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.CCPAConsent
    public void setGppData(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.gppData = map;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.CCPAConsent
    public List<String> getRejectedCategories() {
        return this.rejectedCategories;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.CCPAConsent
    public List<String> getRejectedVendors() {
        return this.rejectedVendors;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.CCPAConsent
    public CcpaStatus getStatus() {
        return this.status;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.CCPAConsent
    public String getUspstring() {
        return this.uspstring;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.CCPAConsent
    public String getChildPmId() {
        return this.childPmId;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.CCPAConsent
    public boolean getApplies() {
        return this.applies;
    }

    public final JSONObject getThisContent() {
        return this.thisContent;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.CCPAConsent
    public Boolean getSignedLspa() {
        return this.signedLspa;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.CCPAConsent
    public JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }
}
