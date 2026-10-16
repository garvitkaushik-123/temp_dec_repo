package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/LoadingStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "DownloadOnly", "DownloadAndPreload", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LoadingStrategy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LoadingStrategy[] $VALUES;
    public static final LoadingStrategy DownloadOnly = new LoadingStrategy("DownloadOnly", 0);
    public static final LoadingStrategy DownloadAndPreload = new LoadingStrategy("DownloadAndPreload", 1);

    private static final /* synthetic */ LoadingStrategy[] $values() {
        return new LoadingStrategy[]{DownloadOnly, DownloadAndPreload};
    }

    public static EnumEntries<LoadingStrategy> getEntries() {
        return $ENTRIES;
    }

    private LoadingStrategy(String str, int i) {
    }

    static {
        LoadingStrategy[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static LoadingStrategy valueOf(String str) {
        return (LoadingStrategy) Enum.valueOf(LoadingStrategy.class, str);
    }

    public static LoadingStrategy[] values() {
        return (LoadingStrategy[]) $VALUES.clone();
    }
}
