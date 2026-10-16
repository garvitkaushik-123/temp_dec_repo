package com.moloco.sdk.publisher.privacy;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.moloco.sdk.publisher.privacy.MolocoPrivacy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/moloco/sdk/publisher/privacy/InternalMolocoPrivacySettingsImpl;", "Lcom/moloco/sdk/publisher/privacy/InternalMolocoPrivacySettings;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getUpdatedPrivacySettings", "Lcom/moloco/sdk/publisher/privacy/MolocoPrivacy$PrivacySettings;", "privacySettings", "getTCFConsent", "", "gdprApplies", "", "(Landroid/content/Context;)Ljava/lang/Boolean;", "getUSPrivacyConsentString", "userSetUsPrivacy", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InternalMolocoPrivacySettingsImpl implements InternalMolocoPrivacySettings {
    public static final int $stable = 8;
    private final Context context;

    public InternalMolocoPrivacySettingsImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final Boolean gdprApplies(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (!defaultSharedPreferences.contains("IABTCF_gdprApplies")) {
            return null;
        }
        try {
            int i = defaultSharedPreferences.getInt("IABTCF_gdprApplies", 0);
            if (i == 0) {
                return Boolean.FALSE;
            }
            if (i != 1) {
                return null;
            }
            return Boolean.TRUE;
        } catch (ClassCastException unused) {
            return Boolean.valueOf(defaultSharedPreferences.getBoolean("IABTCF_gdprApplies", false));
        }
    }

    private final String getTCFConsent(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("IABTCF_TCString", null);
        if (string == null || StringsKt.isBlank(string)) {
            return null;
        }
        return string;
    }

    private final String getUSPrivacyConsentString(Context context, String userSetUsPrivacy) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("IABUSPrivacy_String", null);
        return (string == null || StringsKt.isBlank(string)) ? userSetUsPrivacy : string;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.moloco.sdk.publisher.privacy.InternalMolocoPrivacySettings
    public MolocoPrivacy.PrivacySettings getUpdatedPrivacySettings(MolocoPrivacy.PrivacySettings privacySettings) {
        Intrinsics.checkNotNullParameter(privacySettings, "privacySettings");
        Boolean gdprApplies = gdprApplies(this.context);
        if (gdprApplies == null) {
            gdprApplies = privacySettings.getIsUserConsent();
        }
        return new MolocoPrivacy.PrivacySettings(gdprApplies, privacySettings.getIsAgeRestrictedUser(), privacySettings.getIsDoNotSell(), getTCFConsent(this.context), getUSPrivacyConsentString(this.context, privacySettings.get_usPrivacy()));
    }
}
