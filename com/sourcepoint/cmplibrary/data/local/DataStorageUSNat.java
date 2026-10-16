package com.sourcepoint.cmplibrary.data.local;

import android.content.SharedPreferences;
import kotlin.Metadata;

/* compiled from: DataStorageUSNat.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dJ\b\u0010\u001b\u001a\u00020\u001cH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0018\u0010\u000f\u001a\u00020\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u0016X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/local/DataStorageUSNat;", "", "preference", "Landroid/content/SharedPreferences;", "getPreference", "()Landroid/content/SharedPreferences;", "usNatConsentData", "", "getUsNatConsentData", "()Ljava/lang/String;", "setUsNatConsentData", "(Ljava/lang/String;)V", "usnatChildPmId", "getUsnatChildPmId", "setUsnatChildPmId", "usnatSampleRate", "", "getUsnatSampleRate", "()D", "setUsnatSampleRate", "(D)V", "usnatSampled", "", "getUsnatSampled", "()Ljava/lang/Boolean;", "setUsnatSampled", "(Ljava/lang/Boolean;)V", "deleteUsNatConsent", "", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DataStorageUSNat {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String KEY_USNAT_CHILD_PM_ID = "sp.usnat.key.childPmId";
    public static final String USNAT_CONSENT_STATUS = "sp.usnat.key.consent.status";
    public static final String USNAT_SAMPLING_RESULT = "sp.usnat.key.sampling.result";
    public static final String USNAT_SAMPLING_VALUE = "sp.usnat.key.sampling";

    void deleteUsNatConsent();

    SharedPreferences getPreference();

    String getUsNatConsentData();

    String getUsnatChildPmId();

    double getUsnatSampleRate();

    Boolean getUsnatSampled();

    void setUsNatConsentData(String str);

    void setUsnatChildPmId(String str);

    void setUsnatSampleRate(double d);

    void setUsnatSampled(Boolean bool);

    /* compiled from: DataStorageUSNat.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/local/DataStorageUSNat$Companion;", "", "()V", "KEY_USNAT_CHILD_PM_ID", "", "USNAT_CONSENT_STATUS", "USNAT_SAMPLING_RESULT", "USNAT_SAMPLING_VALUE", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String KEY_USNAT_CHILD_PM_ID = "sp.usnat.key.childPmId";
        public static final String USNAT_CONSENT_STATUS = "sp.usnat.key.consent.status";
        public static final String USNAT_SAMPLING_RESULT = "sp.usnat.key.sampling.result";
        public static final String USNAT_SAMPLING_VALUE = "sp.usnat.key.sampling";

        private Companion() {
        }
    }
}
