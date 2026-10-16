package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "KeepAll", "OnlyClick", "DisableAll", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class RedirectionStrategy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RedirectionStrategy[] $VALUES;
    public static final RedirectionStrategy KeepAll = new RedirectionStrategy("KeepAll", 0);
    public static final RedirectionStrategy OnlyClick = new RedirectionStrategy("OnlyClick", 1);
    public static final RedirectionStrategy DisableAll = new RedirectionStrategy("DisableAll", 2);

    private static final /* synthetic */ RedirectionStrategy[] $values() {
        return new RedirectionStrategy[]{KeepAll, OnlyClick, DisableAll};
    }

    public static EnumEntries<RedirectionStrategy> getEntries() {
        return $ENTRIES;
    }

    private RedirectionStrategy(String str, int i) {
    }

    static {
        RedirectionStrategy[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static RedirectionStrategy valueOf(String str) {
        return (RedirectionStrategy) Enum.valueOf(RedirectionStrategy.class, str);
    }

    public static RedirectionStrategy[] values() {
        return (RedirectionStrategy[]) $VALUES.clone();
    }
}
