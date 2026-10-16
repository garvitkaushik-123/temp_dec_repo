package com.sourcepoint.cmplibrary.data.network.util;

import com.ironsource.C3040d4;
import com.ironsource.D5;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HttpUrlManager.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;", "", D5.o, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEnv", "()Ljava/lang/String;", "STAGE", "PUBLIC", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CampaignsEnv {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CampaignsEnv[] $VALUES;
    private final String env;
    public static final CampaignsEnv STAGE = new CampaignsEnv("STAGE", 0, C3040d4.h.q);
    public static final CampaignsEnv PUBLIC = new CampaignsEnv("PUBLIC", 1, "prod");

    private static final /* synthetic */ CampaignsEnv[] $values() {
        return new CampaignsEnv[]{STAGE, PUBLIC};
    }

    public static EnumEntries<CampaignsEnv> getEntries() {
        return $ENTRIES;
    }

    public static CampaignsEnv valueOf(String str) {
        return (CampaignsEnv) Enum.valueOf(CampaignsEnv.class, str);
    }

    public static CampaignsEnv[] values() {
        return (CampaignsEnv[]) $VALUES.clone();
    }

    private CampaignsEnv(String str, int i, String str2) {
        this.env = str2;
    }

    public final String getEnv() {
        return this.env;
    }

    static {
        CampaignsEnv[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
