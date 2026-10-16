package com.adjust.sdk;

import com.inmobi.sdk.InMobiSdk;
import com.ironsource.C3057e4;

/* loaded from: classes2.dex */
public enum ActivityKind {
    UNKNOWN,
    SESSION,
    EVENT,
    CLICK,
    ATTRIBUTION,
    REVENUE,
    REATTRIBUTION,
    INFO,
    GDPR,
    AD_REVENUE,
    DISABLE_THIRD_PARTY_SHARING,
    SUBSCRIPTION,
    THIRD_PARTY_SHARING,
    MEASUREMENT_CONSENT,
    PURCHASE_VERIFICATION;

    /* renamed from: com.adjust.sdk.ActivityKind$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f144a;

        static {
            int[] iArr = new int[ActivityKind.values().length];
            f144a = iArr;
            try {
                iArr[ActivityKind.SESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f144a[ActivityKind.EVENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f144a[ActivityKind.CLICK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f144a[ActivityKind.ATTRIBUTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f144a[ActivityKind.INFO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f144a[ActivityKind.GDPR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f144a[ActivityKind.AD_REVENUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f144a[ActivityKind.SUBSCRIPTION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f144a[ActivityKind.THIRD_PARTY_SHARING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f144a[ActivityKind.MEASUREMENT_CONSENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f144a[ActivityKind.PURCHASE_VERIFICATION.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static ActivityKind fromString(String str) {
        return "session".equals(str) ? SESSION : "event".equals(str) ? EVENT : "click".equals(str) ? CLICK : C3057e4.c.equals(str) ? ATTRIBUTION : "info".equals(str) ? INFO : InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES.equals(str) ? GDPR : "ad_revenue".equals(str) ? AD_REVENUE : "subscription".equals(str) ? SUBSCRIPTION : "third_party_sharing".equals(str) ? THIRD_PARTY_SHARING : "measurement_consent".equals(str) ? MEASUREMENT_CONSENT : "purchase_verification".equals(str) ? PURCHASE_VERIFICATION : UNKNOWN;
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (AnonymousClass1.f144a[ordinal()]) {
            case 1:
                return "session";
            case 2:
                return "event";
            case 3:
                return "click";
            case 4:
                return C3057e4.c;
            case 5:
                return "info";
            case 6:
                return InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES;
            case 7:
                return "ad_revenue";
            case 8:
                return "subscription";
            case 9:
                return "third_party_sharing";
            case 10:
                return "measurement_consent";
            case 11:
                return "purchase_verification";
            default:
                return "unknown";
        }
    }
}
