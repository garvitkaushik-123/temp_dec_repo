package com.sourcepoint.cmplibrary.model.exposed;

import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GoogleConsentMode;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.json.JsonObject;

/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c0\u001bX¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bX¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u0014\u0010$\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0011R\u0014\u0010&\u001a\u0004\u0018\u00010'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/GDPRConsent;", "", "acceptedCategories", "", "", "getAcceptedCategories", "()Ljava/util/List;", "applies", "", "getApplies", "()Z", "consentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "getConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "euconsent", "getEuconsent", "()Ljava/lang/String;", "setEuconsent", "(Ljava/lang/String;)V", "googleConsentMode", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;", "getGoogleConsentMode", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;", "setGoogleConsentMode", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;)V", "grants", "", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRPurposeGrants;", "getGrants", "()Ljava/util/Map;", "setGrants", "(Ljava/util/Map;)V", "tcData", "getTcData", "setTcData", "uuid", "getUuid", "webConsentPayload", "Lkotlinx/serialization/json/JsonObject;", "getWebConsentPayload", "()Lkotlinx/serialization/json/JsonObject;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface GDPRConsent {
    List<String> getAcceptedCategories();

    boolean getApplies();

    ConsentStatus getConsentStatus();

    String getEuconsent();

    GoogleConsentMode getGoogleConsentMode();

    Map<String, GDPRPurposeGrants> getGrants();

    Map<String, Object> getTcData();

    String getUuid();

    JsonObject getWebConsentPayload();

    void setEuconsent(String str);

    void setGoogleConsentMode(GoogleConsentMode googleConsentMode);

    void setGrants(Map<String, GDPRPurposeGrants> map);

    void setTcData(Map<String, ? extends Object> map);
}
