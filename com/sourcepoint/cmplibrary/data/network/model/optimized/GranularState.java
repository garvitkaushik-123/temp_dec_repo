package com.sourcepoint.cmplibrary.data.network.model.optimized;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ConsentStatusApiModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;", "", "(Ljava/lang/String;I)V", "ALL", "SOME", "NONE", "EMPTY_VL", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GranularState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GranularState[] $VALUES;
    public static final GranularState ALL = new GranularState("ALL", 0);
    public static final GranularState SOME = new GranularState("SOME", 1);
    public static final GranularState NONE = new GranularState("NONE", 2);
    public static final GranularState EMPTY_VL = new GranularState("EMPTY_VL", 3);

    private static final /* synthetic */ GranularState[] $values() {
        return new GranularState[]{ALL, SOME, NONE, EMPTY_VL};
    }

    public static EnumEntries<GranularState> getEntries() {
        return $ENTRIES;
    }

    public static GranularState valueOf(String str) {
        return (GranularState) Enum.valueOf(GranularState.class, str);
    }

    public static GranularState[] values() {
        return (GranularState[]) $VALUES.clone();
    }

    private GranularState(String str, int i) {
    }

    static {
        GranularState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
