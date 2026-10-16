package io.adn.sdk.internal.domain.model.ad;

import io.bidmachine.iab.vast.tags.VastTagName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LoadedFile.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/FileContentType;", "", "<init>", "(Ljava/lang/String;I)V", VastTagName.VIDEO, "Image", "Html", "Js", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FileContentType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FileContentType[] $VALUES;
    public static final FileContentType Video = new FileContentType(VastTagName.VIDEO, 0);
    public static final FileContentType Image = new FileContentType("Image", 1);
    public static final FileContentType Html = new FileContentType("Html", 2);
    public static final FileContentType Js = new FileContentType("Js", 3);

    private static final /* synthetic */ FileContentType[] $values() {
        return new FileContentType[]{Video, Image, Html, Js};
    }

    public static EnumEntries<FileContentType> getEntries() {
        return $ENTRIES;
    }

    static {
        FileContentType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private FileContentType(String str, int i) {
    }

    public static FileContentType valueOf(String str) {
        return (FileContentType) Enum.valueOf(FileContentType.class, str);
    }

    public static FileContentType[] values() {
        return (FileContentType[]) $VALUES.clone();
    }
}
