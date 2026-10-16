package com.sourcepoint.cmplibrary.model.exposed;

import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GoogleConsentMode;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;
import org.json.JSONObject;

/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0014HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006HÆ\u0003J\u0015\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J£\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u0010>\u001a\u00020\r2\b\u0010?\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\"R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006C"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/GDPRConsentInternal;", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRConsent;", "euconsent", "", "uuid", "tcData", "", "", "grants", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRPurposeGrants;", "acceptedCategories", "", "applies", "", "consentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "googleConsentMode", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;", "childPmId", "thisContent", "Lorg/json/JSONObject;", "webConsentPayload", "Lkotlinx/serialization/json/JsonObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;ZLcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;Ljava/lang/String;Lorg/json/JSONObject;Lkotlinx/serialization/json/JsonObject;)V", "getAcceptedCategories", "()Ljava/util/List;", "getApplies", "()Z", "getChildPmId", "()Ljava/lang/String;", "getConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "getEuconsent", "setEuconsent", "(Ljava/lang/String;)V", "getGoogleConsentMode", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;", "setGoogleConsentMode", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;)V", "getGrants", "()Ljava/util/Map;", "setGrants", "(Ljava/util/Map;)V", "getTcData", "setTcData", "getThisContent", "()Lorg/json/JSONObject;", "getUuid", "getWebConsentPayload", "()Lkotlinx/serialization/json/JsonObject;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GDPRConsentInternal implements GDPRConsent {
    private final List<String> acceptedCategories;
    private final boolean applies;
    private final String childPmId;
    private final ConsentStatus consentStatus;
    private String euconsent;
    private GoogleConsentMode googleConsentMode;
    private Map<String, GDPRPurposeGrants> grants;
    private Map<String, ? extends Object> tcData;
    private final JSONObject thisContent;
    private final String uuid;
    private final JsonObject webConsentPayload;

    public GDPRConsentInternal() {
        this(null, null, null, null, null, false, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ GDPRConsentInternal copy$default(GDPRConsentInternal gDPRConsentInternal, String str, String str2, Map map, Map map2, List list, boolean z, ConsentStatus consentStatus, GoogleConsentMode googleConsentMode, String str3, JSONObject jSONObject, JsonObject jsonObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gDPRConsentInternal.euconsent;
        }
        if ((i & 2) != 0) {
            str2 = gDPRConsentInternal.uuid;
        }
        if ((i & 4) != 0) {
            map = gDPRConsentInternal.tcData;
        }
        if ((i & 8) != 0) {
            map2 = gDPRConsentInternal.grants;
        }
        if ((i & 16) != 0) {
            list = gDPRConsentInternal.acceptedCategories;
        }
        if ((i & 32) != 0) {
            z = gDPRConsentInternal.applies;
        }
        if ((i & 64) != 0) {
            consentStatus = gDPRConsentInternal.consentStatus;
        }
        if ((i & 128) != 0) {
            googleConsentMode = gDPRConsentInternal.googleConsentMode;
        }
        if ((i & 256) != 0) {
            str3 = gDPRConsentInternal.childPmId;
        }
        if ((i & 512) != 0) {
            jSONObject = gDPRConsentInternal.thisContent;
        }
        if ((i & 1024) != 0) {
            jsonObject = gDPRConsentInternal.webConsentPayload;
        }
        JSONObject jSONObject2 = jSONObject;
        JsonObject jsonObject2 = jsonObject;
        GoogleConsentMode googleConsentMode2 = googleConsentMode;
        String str4 = str3;
        boolean z2 = z;
        ConsentStatus consentStatus2 = consentStatus;
        List list2 = list;
        Map map3 = map;
        return gDPRConsentInternal.copy(str, str2, map3, map2, list2, z2, consentStatus2, googleConsentMode2, str4, jSONObject2, jsonObject2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEuconsent() {
        return this.euconsent;
    }

    /* renamed from: component10, reason: from getter */
    public final JSONObject getThisContent() {
        return this.thisContent;
    }

    /* renamed from: component11, reason: from getter */
    public final JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    public final Map<String, Object> component3() {
        return this.tcData;
    }

    public final Map<String, GDPRPurposeGrants> component4() {
        return this.grants;
    }

    public final List<String> component5() {
        return this.acceptedCategories;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getApplies() {
        return this.applies;
    }

    /* renamed from: component7, reason: from getter */
    public final ConsentStatus getConsentStatus() {
        return this.consentStatus;
    }

    /* renamed from: component8, reason: from getter */
    public final GoogleConsentMode getGoogleConsentMode() {
        return this.googleConsentMode;
    }

    /* renamed from: component9, reason: from getter */
    public final String getChildPmId() {
        return this.childPmId;
    }

    public final GDPRConsentInternal copy(String euconsent, String uuid, Map<String, ? extends Object> tcData, Map<String, GDPRPurposeGrants> grants, List<String> acceptedCategories, boolean applies, ConsentStatus consentStatus, GoogleConsentMode googleConsentMode, String childPmId, JSONObject thisContent, JsonObject webConsentPayload) {
        Intrinsics.checkNotNullParameter(euconsent, "euconsent");
        Intrinsics.checkNotNullParameter(tcData, "tcData");
        Intrinsics.checkNotNullParameter(grants, "grants");
        Intrinsics.checkNotNullParameter(thisContent, "thisContent");
        return new GDPRConsentInternal(euconsent, uuid, tcData, grants, acceptedCategories, applies, consentStatus, googleConsentMode, childPmId, thisContent, webConsentPayload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GDPRConsentInternal)) {
            return false;
        }
        GDPRConsentInternal gDPRConsentInternal = (GDPRConsentInternal) other;
        return Intrinsics.areEqual(this.euconsent, gDPRConsentInternal.euconsent) && Intrinsics.areEqual(this.uuid, gDPRConsentInternal.uuid) && Intrinsics.areEqual(this.tcData, gDPRConsentInternal.tcData) && Intrinsics.areEqual(this.grants, gDPRConsentInternal.grants) && Intrinsics.areEqual(this.acceptedCategories, gDPRConsentInternal.acceptedCategories) && this.applies == gDPRConsentInternal.applies && Intrinsics.areEqual(this.consentStatus, gDPRConsentInternal.consentStatus) && Intrinsics.areEqual(this.googleConsentMode, gDPRConsentInternal.googleConsentMode) && Intrinsics.areEqual(this.childPmId, gDPRConsentInternal.childPmId) && Intrinsics.areEqual(this.thisContent, gDPRConsentInternal.thisContent) && Intrinsics.areEqual(this.webConsentPayload, gDPRConsentInternal.webConsentPayload);
    }

    public int hashCode() {
        int hashCode = this.euconsent.hashCode() * 31;
        String str = this.uuid;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.tcData.hashCode()) * 31) + this.grants.hashCode()) * 31;
        List<String> list = this.acceptedCategories;
        int hashCode3 = (((hashCode2 + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.applies)) * 31;
        ConsentStatus consentStatus = this.consentStatus;
        int hashCode4 = (hashCode3 + (consentStatus == null ? 0 : consentStatus.hashCode())) * 31;
        GoogleConsentMode googleConsentMode = this.googleConsentMode;
        int hashCode5 = (hashCode4 + (googleConsentMode == null ? 0 : googleConsentMode.hashCode())) * 31;
        String str2 = this.childPmId;
        int hashCode6 = (((hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.thisContent.hashCode()) * 31;
        JsonObject jsonObject = this.webConsentPayload;
        return hashCode6 + (jsonObject != null ? jsonObject.hashCode() : 0);
    }

    public String toString() {
        return "GDPRConsentInternal(euconsent=" + this.euconsent + ", uuid=" + this.uuid + ", tcData=" + this.tcData + ", grants=" + this.grants + ", acceptedCategories=" + this.acceptedCategories + ", applies=" + this.applies + ", consentStatus=" + this.consentStatus + ", googleConsentMode=" + this.googleConsentMode + ", childPmId=" + this.childPmId + ", thisContent=" + this.thisContent + ", webConsentPayload=" + this.webConsentPayload + ")";
    }

    public GDPRConsentInternal(String euconsent, String str, Map<String, ? extends Object> tcData, Map<String, GDPRPurposeGrants> grants, List<String> list, boolean z, ConsentStatus consentStatus, GoogleConsentMode googleConsentMode, String str2, JSONObject thisContent, JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(euconsent, "euconsent");
        Intrinsics.checkNotNullParameter(tcData, "tcData");
        Intrinsics.checkNotNullParameter(grants, "grants");
        Intrinsics.checkNotNullParameter(thisContent, "thisContent");
        this.euconsent = euconsent;
        this.uuid = str;
        this.tcData = tcData;
        this.grants = grants;
        this.acceptedCategories = list;
        this.applies = z;
        this.consentStatus = consentStatus;
        this.googleConsentMode = googleConsentMode;
        this.childPmId = str2;
        this.thisContent = thisContent;
        this.webConsentPayload = jsonObject;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ GDPRConsentInternal(java.lang.String r2, java.lang.String r3, java.util.Map r4, java.util.Map r5, java.util.List r6, boolean r7, com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus r8, com.sourcepoint.cmplibrary.data.network.model.optimized.GoogleConsentMode r9, java.lang.String r10, org.json.JSONObject r11, kotlinx.serialization.json.JsonObject r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r1 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto Lc
            r3 = r0
        Lc:
            r14 = r13 & 4
            if (r14 == 0) goto L14
            java.util.Map r4 = kotlin.collections.MapsKt.emptyMap()
        L14:
            r14 = r13 & 8
            if (r14 == 0) goto L1c
            java.util.Map r5 = kotlin.collections.MapsKt.emptyMap()
        L1c:
            r14 = r13 & 16
            if (r14 == 0) goto L21
            r6 = r0
        L21:
            r14 = r13 & 32
            if (r14 == 0) goto L26
            r7 = 0
        L26:
            r14 = r13 & 64
            if (r14 == 0) goto L2b
            r8 = r0
        L2b:
            r14 = r13 & 128(0x80, float:1.8E-43)
            if (r14 == 0) goto L30
            r9 = r0
        L30:
            r14 = r13 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L35
            r10 = r0
        L35:
            r14 = r13 & 512(0x200, float:7.17E-43)
            if (r14 == 0) goto L3e
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>()
        L3e:
            r13 = r13 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L4f
            r14 = r0
            r12 = r10
            r13 = r11
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L5b
        L4f:
            r14 = r12
            r13 = r11
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L5b:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sourcepoint.cmplibrary.model.exposed.GDPRConsentInternal.<init>(java.lang.String, java.lang.String, java.util.Map, java.util.Map, java.util.List, boolean, com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus, com.sourcepoint.cmplibrary.data.network.model.optimized.GoogleConsentMode, java.lang.String, org.json.JSONObject, kotlinx.serialization.json.JsonObject, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public String getEuconsent() {
        return this.euconsent;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public void setEuconsent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.euconsent = str;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public String getUuid() {
        return this.uuid;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public Map<String, Object> getTcData() {
        return this.tcData;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public void setTcData(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.tcData = map;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public Map<String, GDPRPurposeGrants> getGrants() {
        return this.grants;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public void setGrants(Map<String, GDPRPurposeGrants> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.grants = map;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public List<String> getAcceptedCategories() {
        return this.acceptedCategories;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public boolean getApplies() {
        return this.applies;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public ConsentStatus getConsentStatus() {
        return this.consentStatus;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public GoogleConsentMode getGoogleConsentMode() {
        return this.googleConsentMode;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public void setGoogleConsentMode(GoogleConsentMode googleConsentMode) {
        this.googleConsentMode = googleConsentMode;
    }

    public final String getChildPmId() {
        return this.childPmId;
    }

    public final JSONObject getThisContent() {
        return this.thisContent;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.GDPRConsent
    public JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }
}
