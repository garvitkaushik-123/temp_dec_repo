package io.adn.sdk.internal.domain.model.analytics;

import com.pgl.ssdk.ces.out.PglSSManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DiagnosticEvent.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEventType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AdTokenGeneration", "AdLoading", "AdRequest", "AdClick", PglSSManager.REPORT_SCENE_ADSHOW, "AdDestroyed", "AdReadyForInteraction", "SceneLoading", "SceneShow", "SceneSkipped", "OmidInit", "OmidScriptDownload", "OmidSession", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DiagnosticEventType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DiagnosticEventType[] $VALUES;
    private final String value;
    public static final DiagnosticEventType AdTokenGeneration = new DiagnosticEventType("AdTokenGeneration", 0, "ad_token_generation");
    public static final DiagnosticEventType AdLoading = new DiagnosticEventType("AdLoading", 1, "ad_loading");
    public static final DiagnosticEventType AdRequest = new DiagnosticEventType("AdRequest", 2, "ad_request");
    public static final DiagnosticEventType AdClick = new DiagnosticEventType("AdClick", 3, "ad_click");
    public static final DiagnosticEventType AdShow = new DiagnosticEventType(PglSSManager.REPORT_SCENE_ADSHOW, 4, "ad_show");
    public static final DiagnosticEventType AdDestroyed = new DiagnosticEventType("AdDestroyed", 5, "ad_destroyed");
    public static final DiagnosticEventType AdReadyForInteraction = new DiagnosticEventType("AdReadyForInteraction", 6, "ad_ready_for_interaction");
    public static final DiagnosticEventType SceneLoading = new DiagnosticEventType("SceneLoading", 7, "scene_loading");
    public static final DiagnosticEventType SceneShow = new DiagnosticEventType("SceneShow", 8, "scene_show");
    public static final DiagnosticEventType SceneSkipped = new DiagnosticEventType("SceneSkipped", 9, "scene_skipped");
    public static final DiagnosticEventType OmidInit = new DiagnosticEventType("OmidInit", 10, "omid_initializer");
    public static final DiagnosticEventType OmidScriptDownload = new DiagnosticEventType("OmidScriptDownload", 11, "omid_script_download");
    public static final DiagnosticEventType OmidSession = new DiagnosticEventType("OmidSession", 12, "omid_session");

    private static final /* synthetic */ DiagnosticEventType[] $values() {
        return new DiagnosticEventType[]{AdTokenGeneration, AdLoading, AdRequest, AdClick, AdShow, AdDestroyed, AdReadyForInteraction, SceneLoading, SceneShow, SceneSkipped, OmidInit, OmidScriptDownload, OmidSession};
    }

    public static EnumEntries<DiagnosticEventType> getEntries() {
        return $ENTRIES;
    }

    private DiagnosticEventType(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        DiagnosticEventType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DiagnosticEventType valueOf(String str) {
        return (DiagnosticEventType) Enum.valueOf(DiagnosticEventType.class, str);
    }

    public static DiagnosticEventType[] values() {
        return (DiagnosticEventType[]) $VALUES.clone();
    }
}
