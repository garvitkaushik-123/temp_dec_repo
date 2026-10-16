package com.sourcepoint.cmplibrary.exception;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ApiRequestPostfix.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/sourcepoint/cmplibrary/exception/ApiRequestPostfix;", "", "apiPostfix", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getApiPostfix", "()Ljava/lang/String;", "META_DATA", "CONSENT_STATUS", "MESSAGES", "PV_DATA", "GET_CHOICE", "POST_CHOICE_GDPR", "POST_CHOICE_CCPA", "POST_CHOICE_USNAT", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApiRequestPostfix {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ApiRequestPostfix[] $VALUES;
    private final String apiPostfix;
    public static final ApiRequestPostfix META_DATA = new ApiRequestPostfix("META_DATA", 0, "_meta-data");
    public static final ApiRequestPostfix CONSENT_STATUS = new ApiRequestPostfix("CONSENT_STATUS", 1, "_consent-status");
    public static final ApiRequestPostfix MESSAGES = new ApiRequestPostfix("MESSAGES", 2, "_messages");
    public static final ApiRequestPostfix PV_DATA = new ApiRequestPostfix("PV_DATA", 3, "_pv-data");
    public static final ApiRequestPostfix GET_CHOICE = new ApiRequestPostfix("GET_CHOICE", 4, "_get-choice");
    public static final ApiRequestPostfix POST_CHOICE_GDPR = new ApiRequestPostfix("POST_CHOICE_GDPR", 5, "_post-choice_gdpr");
    public static final ApiRequestPostfix POST_CHOICE_CCPA = new ApiRequestPostfix("POST_CHOICE_CCPA", 6, "_post-choice_ccpa");
    public static final ApiRequestPostfix POST_CHOICE_USNAT = new ApiRequestPostfix("POST_CHOICE_USNAT", 7, "_post-choice_usnat");

    private static final /* synthetic */ ApiRequestPostfix[] $values() {
        return new ApiRequestPostfix[]{META_DATA, CONSENT_STATUS, MESSAGES, PV_DATA, GET_CHOICE, POST_CHOICE_GDPR, POST_CHOICE_CCPA, POST_CHOICE_USNAT};
    }

    public static EnumEntries<ApiRequestPostfix> getEntries() {
        return $ENTRIES;
    }

    public static ApiRequestPostfix valueOf(String str) {
        return (ApiRequestPostfix) Enum.valueOf(ApiRequestPostfix.class, str);
    }

    public static ApiRequestPostfix[] values() {
        return (ApiRequestPostfix[]) $VALUES.clone();
    }

    private ApiRequestPostfix(String str, int i, String str2) {
        this.apiPostfix = str2;
    }

    public final String getApiPostfix() {
        return this.apiPostfix;
    }

    static {
        ApiRequestPostfix[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
