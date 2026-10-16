package com.inmobi.sdk;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import androidx.autofill.HintConstants;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import com.inmobi.media.AbstractC2564ab;
import com.inmobi.media.AbstractC2680h7;
import com.inmobi.media.AbstractC2800oe;
import com.inmobi.media.AbstractC2920w5;
import com.inmobi.media.AbstractC2925wa;
import com.inmobi.media.B6;
import com.inmobi.media.C2881te;
import com.inmobi.media.C6;
import com.inmobi.media.De;
import com.inmobi.media.G4;
import com.inmobi.media.Gd;
import com.inmobi.media.H6;
import com.inmobi.media.I5;
import com.inmobi.media.I7;
import com.inmobi.media.J5;
import com.inmobi.media.L3;
import com.inmobi.media.M2;
import com.inmobi.media.Md;
import com.inmobi.media.O2;
import com.inmobi.media.Pd;
import com.inmobi.media.S5;
import com.inmobi.media.Td;
import com.inmobi.media.Uc;
import com.inmobi.media.Ya;
import com.inmobi.unifiedId.InMobiUnifiedIdService;
import com.ironsource.C3040d4;
import com.ironsource.adapters.inmobi.InMobiAdapter;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005PQRSTJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\"\u0010\u0016J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b+\u0010)J-\u0010/\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010.\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u001dH\u0007¢\u0006\u0004\b2\u0010 J\u0017\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u000203H\u0007¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H\u0007¢\u0006\u0004\b9\u0010:J\u0019\u0010<\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b<\u0010)J\u0019\u0010>\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b>\u0010)J\u0019\u0010A\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?H\u0007¢\u0006\u0004\bA\u0010BJ\u0011\u0010C\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\bC\u0010\u0018J1\u0010C\u001a\u0004\u0018\u00010\u00042\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010D2\b\u0010F\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\bC\u0010GJ\u0019\u0010I\u001a\u00020\u00062\b\u0010H\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\bI\u0010\u0011J\u000f\u0010J\u001a\u00020\u0013H\u0007¢\u0006\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010N\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0006\n\u0004\bN\u0010MR\u0014\u0010O\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0006\n\u0004\bO\u0010M¨\u0006U"}, d2 = {"Lcom/inmobi/sdk/InMobiSdk;", "", "Lcom/inmobi/sdk/SdkInitializationListener;", "sdkInitializationListener", "", PglCryptUtils.KEY_MESSAGE, "", "a", "(Lcom/inmobi/sdk/SdkInitializationListener;Ljava/lang/String;)V", "Landroid/content/Context;", "context", InMobiAdapter.ACCOUNT_ID, "Lorg/json/JSONObject;", "consentObject", C3040d4.a.f, "(Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Lcom/inmobi/sdk/SdkInitializationListener;)V", "updateGDPRConsent", "(Lorg/json/JSONObject;)V", "setPartnerGDPRConsent", "", "muted", "setApplicationMuted", "(Z)V", "getVersion", "()Ljava/lang/String;", "Lcom/inmobi/sdk/InMobiSdk$LogLevel;", "logLevel", "setLogLevel", "(Lcom/inmobi/sdk/InMobiSdk$LogLevel;)V", "", "age", "setAge", "(I)V", "isAgeRestricted", "setIsAgeRestricted", "Lcom/inmobi/sdk/InMobiSdk$AgeGroup;", "group", "setAgeGroup", "(Lcom/inmobi/sdk/InMobiSdk$AgeGroup;)V", "areaCode", "setAreaCode", "(Ljava/lang/String;)V", HintConstants.AUTOFILL_HINT_POSTAL_CODE, "setPostalCode", "city", "state", "country", "setLocationWithCityStateCountry", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "yearOfBirth", "setYearOfBirth", "Lcom/inmobi/sdk/InMobiSdk$Gender;", "gender", "setGender", "(Lcom/inmobi/sdk/InMobiSdk$Gender;)V", "Lcom/inmobi/sdk/InMobiSdk$Education;", "education", "setEducation", "(Lcom/inmobi/sdk/InMobiSdk$Education;)V", "language", "setLanguage", "interests", "setInterests", "Landroid/location/Location;", FirebaseAnalytics.Param.LOCATION, "setLocation", "(Landroid/location/Location;)V", "getToken", "", "extras", "keywords", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "jsonObject", "setPublisherProvidedUnifiedId", "isSDKInitialized", "()Z", "IM_GDPR_CONSENT_AVAILABLE", "Ljava/lang/String;", "IM_GDPR_CONSENT_IAB", "IM_GDPR_CONSENT_GDPR_APPLIES", "AgeGroup", "Education", "Gender", "LogLevel", "PublisherSignals", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InMobiSdk {
    public static final String IM_GDPR_CONSENT_AVAILABLE = "gdpr_consent_available";
    public static final String IM_GDPR_CONSENT_GDPR_APPLIES = "gdpr";
    public static final String IM_GDPR_CONSENT_IAB = "gdpr_consent";
    public static final InMobiSdk INSTANCE = new InMobiSdk();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/inmobi/sdk/InMobiSdk$AgeGroup;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "BELOW_18", "BETWEEN_18_AND_24", "BETWEEN_25_AND_29", "BETWEEN_30_AND_34", "BETWEEN_35_AND_44", "BETWEEN_45_AND_54", "BETWEEN_55_AND_65", "ABOVE_65", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AgeGroup {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AgeGroup[] $VALUES;
        private final String value;
        public static final AgeGroup BELOW_18 = new AgeGroup("BELOW_18", 0, "below18");
        public static final AgeGroup BETWEEN_18_AND_24 = new AgeGroup("BETWEEN_18_AND_24", 1, "between18and24");
        public static final AgeGroup BETWEEN_25_AND_29 = new AgeGroup("BETWEEN_25_AND_29", 2, "between25and29");
        public static final AgeGroup BETWEEN_30_AND_34 = new AgeGroup("BETWEEN_30_AND_34", 3, "between30and34");
        public static final AgeGroup BETWEEN_35_AND_44 = new AgeGroup("BETWEEN_35_AND_44", 4, "between35and44");
        public static final AgeGroup BETWEEN_45_AND_54 = new AgeGroup("BETWEEN_45_AND_54", 5, "between45and54");
        public static final AgeGroup BETWEEN_55_AND_65 = new AgeGroup("BETWEEN_55_AND_65", 6, "between55and65");
        public static final AgeGroup ABOVE_65 = new AgeGroup("ABOVE_65", 7, "above65");

        private static final /* synthetic */ AgeGroup[] $values() {
            return new AgeGroup[]{BELOW_18, BETWEEN_18_AND_24, BETWEEN_25_AND_29, BETWEEN_30_AND_34, BETWEEN_35_AND_44, BETWEEN_45_AND_54, BETWEEN_55_AND_65, ABOVE_65};
        }

        static {
            AgeGroup[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private AgeGroup(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<AgeGroup> getEntries() {
            return $ENTRIES;
        }

        public static AgeGroup valueOf(String str) {
            return (AgeGroup) Enum.valueOf(AgeGroup.class, str);
        }

        public static AgeGroup[] values() {
            return (AgeGroup[]) $VALUES.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/inmobi/sdk/InMobiSdk$Education;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "HIGH_SCHOOL_OR_LESS", "COLLEGE_OR_GRADUATE", "POST_GRADUATE_OR_ABOVE", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Education {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Education[] $VALUES;
        private final String value;
        public static final Education HIGH_SCHOOL_OR_LESS = new Education("HIGH_SCHOOL_OR_LESS", 0, "highschoolorless");
        public static final Education COLLEGE_OR_GRADUATE = new Education("COLLEGE_OR_GRADUATE", 1, "collegeorgraduate");
        public static final Education POST_GRADUATE_OR_ABOVE = new Education("POST_GRADUATE_OR_ABOVE", 2, "postgraduateorabove");

        private static final /* synthetic */ Education[] $values() {
            return new Education[]{HIGH_SCHOOL_OR_LESS, COLLEGE_OR_GRADUATE, POST_GRADUATE_OR_ABOVE};
        }

        static {
            Education[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Education(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<Education> getEntries() {
            return $ENTRIES;
        }

        public static Education valueOf(String str) {
            return (Education) Enum.valueOf(Education.class, str);
        }

        public static Education[] values() {
            return (Education[]) $VALUES.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/inmobi/sdk/InMobiSdk$Gender;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "FEMALE", "MALE", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Gender {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Gender[] $VALUES;
        public static final Gender FEMALE = new Gender("FEMALE", 0, InneractiveMediationDefs.GENDER_FEMALE);
        public static final Gender MALE = new Gender("MALE", 1, "m");
        private final String value;

        private static final /* synthetic */ Gender[] $values() {
            return new Gender[]{FEMALE, MALE};
        }

        static {
            Gender[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Gender(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<Gender> getEntries() {
            return $ENTRIES;
        }

        public static Gender valueOf(String str) {
            return (Gender) Enum.valueOf(Gender.class, str);
        }

        public static Gender[] values() {
            return (Gender[]) $VALUES.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/inmobi/sdk/InMobiSdk$LogLevel;", "", "(Ljava/lang/String;I)V", "NONE", "ERROR", "DEBUG", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LogLevel {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LogLevel[] $VALUES;
        public static final LogLevel NONE = new LogLevel("NONE", 0);
        public static final LogLevel ERROR = new LogLevel("ERROR", 1);
        public static final LogLevel DEBUG = new LogLevel("DEBUG", 2);

        private static final /* synthetic */ LogLevel[] $values() {
            return new LogLevel[]{NONE, ERROR, DEBUG};
        }

        static {
            LogLevel[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private LogLevel(String str, int i) {
        }

        public static EnumEntries<LogLevel> getEntries() {
            return $ENTRIES;
        }

        public static LogLevel valueOf(String str) {
            return (LogLevel) Enum.valueOf(LogLevel.class, str);
        }

        public static LogLevel[] values() {
            return (LogLevel[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/inmobi/sdk/InMobiSdk$PublisherSignals;", "", "", "", "signals", "", "putPublisherSignals", "(Ljava/util/Map;)V", "getPublisherSignals", "()Ljava/util/Map;", "resetPublisherSignals", "()V", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PublisherSignals {
        public static final PublisherSignals INSTANCE = new PublisherSignals();

        public final Map<String, Object> getPublisherSignals() {
            if (!InMobiSdk.isSDKInitialized()) {
                String access$getTAG$p = InMobiSdk.access$getTAG$p();
                Intrinsics.checkNotNullExpressionValue(access$getTAG$p, "access$getTAG$p(...)");
                AbstractC2680h7.a((byte) 1, access$getTAG$p, "SDK not initialized. Cannot get publisher signals.");
                return null;
            }
            Ya ya = Ya.f2496a;
            ya.getClass();
            try {
                LinkedHashMap linkedHashMap = O2.f2380a;
                Config a2 = M2.a("signals", Uc.b(), null);
                Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
                SignalsConfig.PublisherConfig publisher = ((SignalsConfig) a2).getPublisher();
                if (!publisher.getEnableMCO() && !publisher.getEnableAB()) {
                    return MapsKt.emptyMap();
                }
                return ya.a();
            } catch (Exception e) {
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
                AbstractC2680h7.a((byte) 1, "PubSignalsStore", "Publisher signals could not be retrieved.");
                return MapsKt.emptyMap();
            }
        }

        public final void putPublisherSignals(Map<String, ? extends Object> signals) {
            if (!InMobiSdk.isSDKInitialized()) {
                String access$getTAG$p = InMobiSdk.access$getTAG$p();
                Intrinsics.checkNotNullExpressionValue(access$getTAG$p, "access$getTAG$p(...)");
                AbstractC2680h7.a((byte) 1, access$getTAG$p, "SDK not initialized. Cannot set publisher signals.");
                return;
            }
            if (signals != null) {
                Ya ya = Ya.f2496a;
                ya.getClass();
                Intrinsics.checkNotNullParameter(signals, "signals");
                try {
                    LinkedHashMap linkedHashMap = O2.f2380a;
                    Config a2 = M2.a("signals", Uc.b(), null);
                    Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
                    SignalsConfig.PublisherConfig publisher = ((SignalsConfig) a2).getPublisher();
                    if (!publisher.getEnableMCO() && !publisher.getEnableAB()) {
                        AbstractC2680h7.a((byte) 1, "PubSignalsStore", "Publisher signals are disabled from InMobi");
                        return;
                    }
                    LinkedHashMap a3 = ya.a();
                    Intrinsics.checkNotNullParameter(a3, "<this>");
                    Intrinsics.checkNotNullParameter(signals, "map");
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.putAll(a3);
                    linkedHashMap2.putAll(signals);
                    JSONObject a4 = Ya.a(Ya.a(Ya.a(linkedHashMap2, publisher)), publisher);
                    if (a4 != null) {
                        Ya.a(a4);
                    }
                } catch (Exception e) {
                    S5 s5 = S5.f2425a;
                    S5.d.a(AbstractC2920w5.a(e, "event"));
                    AbstractC2680h7.a((byte) 1, "PubSignalsStore", "Publisher signals could not be saved.");
                }
            }
        }

        public final void resetPublisherSignals() {
            if (InMobiSdk.isSDKInitialized()) {
                Ya.f2496a.getClass();
                Ya.b();
            } else {
                String access$getTAG$p = InMobiSdk.access$getTAG$p();
                Intrinsics.checkNotNullExpressionValue(access$getTAG$p, "access$getTAG$p(...)");
                AbstractC2680h7.a((byte) 1, access$getTAG$p, "SDK not initialized. Cannot reset publisher signals.");
            }
        }
    }

    public static void a(final Context context, final String str, final JSONObject jSONObject, final SdkInitializationListener sdkInitializationListener) {
        Md.a(new Runnable() { // from class: com.inmobi.sdk.InMobiSdk$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InMobiSdk.a(context, sdkInitializationListener, str, jSONObject);
            }
        });
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return "InMobiSdk";
    }

    public static void b(final SdkInitializationListener sdkInitializationListener, final String str) {
        if (sdkInitializationListener != null) {
            Md.a(new Runnable() { // from class: com.inmobi.sdk.InMobiSdk$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    InMobiSdk.c(SdkInitializationListener.this, str);
                }
            });
        }
        if (str == null) {
            AbstractC2680h7.a((byte) 2, "InMobiSdk", H6.a("InMobiSdk", "TAG", "InMobi SDK initialized with account id: ").append(Uc.b()).toString());
        } else {
            Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
            AbstractC2680h7.a((byte) 1, "InMobiSdk", str);
        }
    }

    public static final void c(SdkInitializationListener sdkInitializationListener, String str) {
        INSTANCE.a(sdkInitializationListener, str);
    }

    @JvmStatic
    public static final String getToken() {
        return getToken(null, null);
    }

    @JvmStatic
    public static final String getVersion() {
        return "10.8.7";
    }

    @JvmStatic
    public static final void init(Context context, String accountId, JSONObject consentObject, SdkInitializationListener sdkInitializationListener) {
        InMobiSdk inMobiSdk = INSTANCE;
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        inMobiSdk.getClass();
        a(applicationContext, accountId, consentObject, sdkInitializationListener);
    }

    @JvmStatic
    public static final boolean isSDKInitialized() {
        return Uc.q();
    }

    @JvmStatic
    public static final void setAge(int age) {
        Context d = Uc.d();
        if (age != Integer.MIN_VALUE) {
            AbstractC2564ab.f2520a = age;
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6.a(B6.a(d, "user_info_store"), "user_age", age, false, 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void setAgeGroup(AgeGroup group) {
        Intrinsics.checkNotNullParameter(group, "group");
        String ageGroup = group.toString();
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = ageGroup.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        Context d = Uc.d();
        if (lowerCase != null) {
            AbstractC2564ab.c = lowerCase;
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6.a(B6.a(d, "user_info_store"), "user_age_group", lowerCase, false, 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void setApplicationMuted(boolean muted) {
        Uc.b(muted);
    }

    @JvmStatic
    public static final void setAreaCode(String areaCode) {
        Context d = Uc.d();
        AbstractC2564ab.d = areaCode;
        if (d == null || areaCode == null) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = C6.b;
        C6.a(B6.a(d, "user_info_store"), "user_area_code", areaCode, false, 4, (Object) null);
    }

    @JvmStatic
    public static final void setEducation(Education education) {
        Intrinsics.checkNotNullParameter(education, "education");
        String education2 = education.toString();
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = education2.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        Context d = Uc.d();
        if (lowerCase != null) {
            AbstractC2564ab.k = lowerCase;
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6.a(B6.a(d, "user_info_store"), "user_education", lowerCase, false, 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void setGender(Gender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        String gender2 = gender.toString();
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = gender2.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        Context d = Uc.d();
        if (lowerCase != null) {
            AbstractC2564ab.j = lowerCase;
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6.a(B6.a(d, "user_info_store"), "user_gender", lowerCase, false, 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void setInterests(String interests) {
        Context d = Uc.d();
        if (interests != null) {
            AbstractC2564ab.m = interests;
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6.a(B6.a(d, "user_info_store"), "user_interest", interests, false, 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void setIsAgeRestricted(boolean isAgeRestricted) {
        AbstractC2564ab.a(isAgeRestricted);
        C2881te.f2715a.a(isAgeRestricted);
        if (isAgeRestricted) {
            InMobiUnifiedIdService.reset();
            I5.a();
        }
    }

    @JvmStatic
    public static final void setLanguage(String language) {
        Context d = Uc.d();
        if (language != null) {
            AbstractC2564ab.l = language;
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6.a(B6.a(d, "user_info_store"), "user_language", language, false, 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void setLocation(Location location) {
        Context d = Uc.d();
        if (location != null) {
            AbstractC2564ab.n = location;
            if (d != null) {
                String sb = new StringBuilder().append(location.getLatitude()).append(AbstractJsonLexerKt.COMMA).append(location.getLongitude()).append(AbstractJsonLexerKt.COMMA).append((int) location.getAccuracy()).append(AbstractJsonLexerKt.COMMA).append(location.getTime()).toString();
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6.a(B6.a(d, "user_info_store"), "user_location", sb, false, 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void setLocationWithCityStateCountry(String city, String state, String country) {
        Context d = Uc.d();
        if (city != null) {
            AbstractC2564ab.f = city;
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6.a(B6.a(d, "user_info_store"), "user_city_code", city, false, 4, (Object) null);
            }
        }
        Context d2 = Uc.d();
        if (state != null) {
            AbstractC2564ab.g = state;
            if (d2 != null) {
                ConcurrentHashMap concurrentHashMap2 = C6.b;
                C6.a(B6.a(d2, "user_info_store"), "user_state_code", state, false, 4, (Object) null);
            }
        }
        Context d3 = Uc.d();
        if (country != null) {
            AbstractC2564ab.h = country;
            if (d3 != null) {
                ConcurrentHashMap concurrentHashMap3 = C6.b;
                C6.a(B6.a(d3, "user_info_store"), "user_country_code", country, false, 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void setLogLevel(LogLevel logLevel) {
        int i = logLevel == null ? -1 : a.f2778a[logLevel.ordinal()];
        if (i == 1) {
            AbstractC2680h7.a((byte) 0);
            return;
        }
        if (i == 2) {
            AbstractC2680h7.a((byte) 1);
        } else if (i != 3) {
            AbstractC2680h7.a((byte) 2);
        } else {
            AbstractC2680h7.a((byte) 2);
        }
    }

    @JvmStatic
    public static final void setPartnerGDPRConsent(JSONObject consentObject) {
        G4.c(consentObject);
    }

    @JvmStatic
    public static final void setPostalCode(String postalCode) {
        Context d = Uc.d();
        if (postalCode != null) {
            AbstractC2564ab.e = postalCode;
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6.a(B6.a(d, "user_info_store"), "user_post_code", postalCode, false, 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void setPublisherProvidedUnifiedId(JSONObject jsonObject) {
        Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
        Objects.toString(jsonObject);
        Uc.a(new J5(jsonObject));
    }

    @JvmStatic
    public static final void setYearOfBirth(int yearOfBirth) {
        Context d = Uc.d();
        if (yearOfBirth != Integer.MIN_VALUE) {
            AbstractC2564ab.i = yearOfBirth;
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6.a(B6.a(d, "user_info_store"), "user_yob", yearOfBirth, false, 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void updateGDPRConsent(JSONObject consentObject) {
        G4.b(consentObject);
    }

    public static final void a(final Context context, SdkInitializationListener sdkInitializationListener, String str, JSONObject jSONObject) {
        final SdkInitializationListener sdkInitializationListener2;
        if (context == null) {
            INSTANCE.getClass();
            b(sdkInitializationListener, SdkInitializationListener.MISSING_CONTEXT);
            return;
        }
        if (str == null) {
            INSTANCE.getClass();
            b(sdkInitializationListener, "Account id cannot be empty. Please provide a valid account id.");
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        Gd.f2298a.a();
        if (De.f2267a.c()) {
            INSTANCE.getClass();
            b(sdkInitializationListener, "SDK could not be initialized; Required dependency could not be found. Please check out documentation and include the required dependency.");
            return;
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        final String a2 = I7.a(length, 1, str, i);
        try {
            G4.b(jSONObject);
            if (a2.length() == 0) {
                INSTANCE.getClass();
                b(sdkInitializationListener, "Account id cannot be empty. Please provide a valid account id.");
                return;
            }
            if (!AbstractC2925wa.a(context, "android.permission.ACCESS_COARSE_LOCATION") && !AbstractC2925wa.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
                Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
                AbstractC2680h7.a((byte) 1, "InMobiSdk", "Please grant the location permissions (ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION, or both) for better ad targeting.");
            }
            if (Uc.q()) {
                Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
                INSTANCE.getClass();
                b(sdkInitializationListener, null);
                return;
            }
            Uc uc = Uc.f2453a;
            if (uc.i() == 1) {
                Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
                return;
            }
            if (!Uc.b(context, a2)) {
                Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
                uc.s();
                INSTANCE.getClass();
                b(sdkInitializationListener, SdkInitializationListener.MISSING_WEBVIEW_DEPENDENCY);
                return;
            }
            De.f2267a.e(context);
            INSTANCE.getClass();
            a();
            sdkInitializationListener2 = sdkInitializationListener;
            try {
                Uc.a(new Runnable() { // from class: com.inmobi.sdk.InMobiSdk$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        InMobiSdk.a(context, a2, sdkInitializationListener2, elapsedRealtime);
                    }
                });
            } catch (Exception unused) {
                Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
                Uc.f2453a.s();
                INSTANCE.getClass();
                b(sdkInitializationListener2, "SDK could not be initialized; an unexpected error was encountered.");
            }
        } catch (Exception unused2) {
            sdkInitializationListener2 = sdkInitializationListener;
        }
    }

    @JvmStatic
    public static final String getToken(Map<String, String> extras, String keywords) {
        return AbstractC2800oe.a(extras, keywords);
    }

    public static final void b() {
        String[] strArr = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE"};
        StringBuilder sb = new StringBuilder("Permissions granted to SDK are :\nandroid.permission.INTERNET\nandroid.permission.ACCESS_NETWORK_STATE");
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (AbstractC2925wa.a(Uc.d(), str)) {
                sb.append("\n").append(str);
            }
        }
        Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
        AbstractC2680h7.a((byte) 2, "InMobiSdk", sb.toString());
    }

    public static final void a(Context context, String str, SdkInitializationListener sdkInitializationListener, long j) {
        try {
            De de = De.f2267a;
            de.a(context);
            Uc uc = Uc.f2453a;
            uc.a();
            uc.b(str);
            de.c(context);
            uc.t();
            INSTANCE.getClass();
            b(sdkInitializationListener, null);
            LinkedHashMap a2 = a(j);
            Pd pd = Pd.f2401a;
            Pd.b("SdkInitialized", a2, Td.f2443a);
            InMobiUnifiedIdService.push(null);
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
            Uc.f2453a.s();
            INSTANCE.getClass();
            b(sdkInitializationListener, "SDK could not be initialized; an unexpected error was encountered.");
        }
    }

    public final void a(SdkInitializationListener sdkInitializationListener, String message) {
        sdkInitializationListener.onInitializationComplete(message == null ? null : new Error(message));
    }

    public static LinkedHashMap a(long j) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        Intrinsics.checkNotNullExpressionValue("InMobiSdk", "TAG");
        Objects.toString(linkedHashMap.get("latency"));
        linkedHashMap.put("networkType", L3.q());
        linkedHashMap.put("integrationType", "InMobi");
        return linkedHashMap;
    }

    public static void a() {
        Uc.a(new Runnable() { // from class: com.inmobi.sdk.InMobiSdk$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                InMobiSdk.b();
            }
        });
    }
}
