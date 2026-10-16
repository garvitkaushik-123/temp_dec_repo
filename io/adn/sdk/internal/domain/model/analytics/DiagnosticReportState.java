package io.adn.sdk.internal.domain.model.analytics;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DiagnosticEventBuilder.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticReportState;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Start", "End", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DiagnosticReportState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DiagnosticReportState[] $VALUES;
    public static final DiagnosticReportState None = new DiagnosticReportState("None", 0);
    public static final DiagnosticReportState Start = new DiagnosticReportState("Start", 1);
    public static final DiagnosticReportState End = new DiagnosticReportState("End", 2);

    private static final /* synthetic */ DiagnosticReportState[] $values() {
        return new DiagnosticReportState[]{None, Start, End};
    }

    public static EnumEntries<DiagnosticReportState> getEntries() {
        return $ENTRIES;
    }

    static {
        DiagnosticReportState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private DiagnosticReportState(String str, int i) {
    }

    public static DiagnosticReportState valueOf(String str) {
        return (DiagnosticReportState) Enum.valueOf(DiagnosticReportState.class, str);
    }

    public static DiagnosticReportState[] values() {
        return (DiagnosticReportState[]) $VALUES.clone();
    }
}
