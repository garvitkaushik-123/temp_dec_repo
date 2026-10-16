package com.moloco.sdk.publisher.privacy;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/moloco/sdk/publisher/privacy/MolocoPrivacy;", "", "<init>", "()V", "privacySettings", "Lcom/moloco/sdk/publisher/privacy/MolocoPrivacy$PrivacySettings;", "getPrivacySettings", "()Lcom/moloco/sdk/publisher/privacy/MolocoPrivacy$PrivacySettings;", "setPrivacySettings", "(Lcom/moloco/sdk/publisher/privacy/MolocoPrivacy$PrivacySettings;)V", "setPrivacy", "", "PrivacySettings", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MolocoPrivacy {
    public static final MolocoPrivacy INSTANCE = new MolocoPrivacy();
    private static PrivacySettings privacySettings = new PrivacySettings((Boolean) null, (Boolean) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B;\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0017\u0010\u0018\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010\u0019R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0002\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0004\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0005\u0010\fR\"\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/moloco/sdk/publisher/privacy/MolocoPrivacy$PrivacySettings;", "", "isUserConsent", "", "isAgeRestrictedUser", "isDoNotSell", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "tcfConsent", "", "usPrivacy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "value", "TCFConsent", "getTCFConsent", "()Ljava/lang/String;", "_usPrivacy", "getUsPrivacy", "equals", "other", "hashCode", "", "getUSPrivacy", "(Ljava/lang/Boolean;)Ljava/lang/String;", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PrivacySettings {
        public static final int $stable = 8;
        private String TCFConsent;
        private String _usPrivacy;
        private final Boolean isAgeRestrictedUser;
        private final Boolean isDoNotSell;
        private final Boolean isUserConsent;

        public PrivacySettings() {
            this((Boolean) null, (Boolean) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
        }

        private final String getUSPrivacy(Boolean isDoNotSell) {
            return isDoNotSell == null ? "1---" : Intrinsics.areEqual(isDoNotSell, Boolean.TRUE) ? "1-Y-" : "1-N-";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PrivacySettings)) {
                return false;
            }
            PrivacySettings privacySettings = (PrivacySettings) other;
            return Intrinsics.areEqual(this.isUserConsent, privacySettings.isUserConsent) && Intrinsics.areEqual(this.isAgeRestrictedUser, privacySettings.isAgeRestrictedUser) && Intrinsics.areEqual(this.isDoNotSell, privacySettings.isDoNotSell) && Intrinsics.areEqual(this.TCFConsent, privacySettings.TCFConsent);
        }

        public final String getTCFConsent() {
            return this.TCFConsent;
        }

        /* renamed from: getUsPrivacy, reason: from getter */
        public final String get_usPrivacy() {
            return this._usPrivacy;
        }

        public int hashCode() {
            Boolean bool = this.isUserConsent;
            int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
            Boolean bool2 = this.isAgeRestrictedUser;
            int hashCode2 = (hashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            Boolean bool3 = this.isDoNotSell;
            int hashCode3 = (hashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
            String str = this.TCFConsent;
            return hashCode3 + (str != null ? str.hashCode() : 0);
        }

        /* renamed from: isAgeRestrictedUser, reason: from getter */
        public final Boolean getIsAgeRestrictedUser() {
            return this.isAgeRestrictedUser;
        }

        /* renamed from: isDoNotSell, reason: from getter */
        public final Boolean getIsDoNotSell() {
            return this.isDoNotSell;
        }

        /* renamed from: isUserConsent, reason: from getter */
        public final Boolean getIsUserConsent() {
            return this.isUserConsent;
        }

        public PrivacySettings(Boolean bool, Boolean bool2, Boolean bool3) {
            this.isUserConsent = bool;
            this.isAgeRestrictedUser = bool2;
            this.isDoNotSell = bool3;
            this._usPrivacy = getUSPrivacy(bool3);
        }

        public /* synthetic */ PrivacySettings(Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3);
        }

        public PrivacySettings(Boolean bool, Boolean bool2, Boolean bool3, String str, String str2) {
            this(bool, bool2, bool3);
            this.TCFConsent = str;
            if (str2 != null) {
                this._usPrivacy = str2;
            }
        }
    }

    private MolocoPrivacy() {
    }

    @JvmStatic
    public static final void setPrivacy(PrivacySettings privacySettings2) {
        Intrinsics.checkNotNullParameter(privacySettings2, "privacySettings");
        privacySettings = privacySettings2;
    }

    public final PrivacySettings getPrivacySettings() {
        return privacySettings;
    }

    public final void setPrivacySettings(PrivacySettings privacySettings2) {
        Intrinsics.checkNotNullParameter(privacySettings2, "<set-?>");
        privacySettings = privacySettings2;
    }
}
