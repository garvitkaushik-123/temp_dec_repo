package com.sourcepoint.cmplibrary.model.exposed;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.json.JsonObject;

/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 %2\u00020\u0001:\u0001%R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR&\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\tR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\tR\u0014\u0010!\u001a\u0004\u0018\u00010\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/CCPAConsent;", "", "applies", "", "getApplies", "()Z", "childPmId", "", "getChildPmId", "()Ljava/lang/String;", "gppData", "", "getGppData", "()Ljava/util/Map;", "setGppData", "(Ljava/util/Map;)V", "rejectedCategories", "", "getRejectedCategories", "()Ljava/util/List;", "rejectedVendors", "getRejectedVendors", "signedLspa", "getSignedLspa", "()Ljava/lang/Boolean;", "status", "Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;", "getStatus", "()Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;", "uspstring", "getUspstring", "uuid", "getUuid", "webConsentPayload", "Lkotlinx/serialization/json/JsonObject;", "getWebConsentPayload", "()Lkotlinx/serialization/json/JsonObject;", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CCPAConsent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String DEFAULT_USPSTRING = "1YNN";

    boolean getApplies();

    String getChildPmId();

    Map<String, Object> getGppData();

    List<String> getRejectedCategories();

    List<String> getRejectedVendors();

    Boolean getSignedLspa();

    CcpaStatus getStatus();

    String getUspstring();

    String getUuid();

    JsonObject getWebConsentPayload();

    void setGppData(Map<String, ? extends Object> map);

    /* compiled from: SPConsents.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/CCPAConsent$Companion;", "", "()V", "DEFAULT_USPSTRING", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String DEFAULT_USPSTRING = "1YNN";

        private Companion() {
        }
    }
}
