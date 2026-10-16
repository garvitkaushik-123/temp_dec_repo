package com.sourcepoint.cmplibrary.data.network.model.optimized;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ConsentStatusApiModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GCMStatus;", "", "status", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "GRANTED", "DENIED", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GCMStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GCMStatus[] $VALUES;
    private final String status;
    public static final GCMStatus GRANTED = new GCMStatus("GRANTED", 0, "granted");
    public static final GCMStatus DENIED = new GCMStatus("DENIED", 1, "denied");

    private static final /* synthetic */ GCMStatus[] $values() {
        return new GCMStatus[]{GRANTED, DENIED};
    }

    public static EnumEntries<GCMStatus> getEntries() {
        return $ENTRIES;
    }

    public static GCMStatus valueOf(String str) {
        return (GCMStatus) Enum.valueOf(GCMStatus.class, str);
    }

    public static GCMStatus[] values() {
        return (GCMStatus[]) $VALUES.clone();
    }

    private GCMStatus(String str, int i, String str2) {
        this.status = str2;
    }

    public final String getStatus() {
        return this.status;
    }

    static {
        GCMStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
