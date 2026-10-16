package com.sourcepoint.cmplibrary.model.exposed;

import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentStatus;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlinx.serialization.json.JsonObject;

/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\f8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0017R\u001a\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\nR\u0014\u0010&\u001a\u0004\u0018\u00010'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/UsNatConsent;", "", "applies", "", "getApplies", "()Z", "categories", "", "Lcom/sourcepoint/cmplibrary/model/exposed/Consentable;", "getCategories", "()Ljava/util/List;", "consentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "getConsentStatus$annotations", "()V", "getConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "consentStrings", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$ConsentString;", "getConsentStrings", "dateCreated", "", "getDateCreated", "()Ljava/lang/String;", "gppData", "", "getGppData", "()Ljava/util/Map;", "setGppData", "(Ljava/util/Map;)V", "statuses", "Lcom/sourcepoint/cmplibrary/model/exposed/UsNatStatuses;", "getStatuses", "()Lcom/sourcepoint/cmplibrary/model/exposed/UsNatStatuses;", "uuid", "getUuid", "vendors", "getVendors", "webConsentPayload", "Lkotlinx/serialization/json/JsonObject;", "getWebConsentPayload", "()Lkotlinx/serialization/json/JsonObject;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface UsNatConsent {

    /* compiled from: SPConsents.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(message = "`consentStatus` is deprecated and will be renamed to `statuses` in the next release.", replaceWith = @ReplaceWith(expression = "statuses", imports = {}))
        public static /* synthetic */ void getConsentStatus$annotations() {
        }
    }

    boolean getApplies();

    List<Consentable> getCategories();

    USNatConsentStatus getConsentStatus();

    List<USNatConsentData.ConsentString> getConsentStrings();

    String getDateCreated();

    Map<String, Object> getGppData();

    UsNatStatuses getStatuses();

    String getUuid();

    List<Consentable> getVendors();

    JsonObject getWebConsentPayload();

    void setGppData(Map<String, ? extends Object> map);
}
