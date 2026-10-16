package io.adn.sdk.internal.ui.common.mraid;

import com.google.firebase.messaging.Constants;
import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MraidOrientation.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "Portrait", "Landscape", "None", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MraidOrientation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MraidOrientation[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final MraidOrientation Portrait = new MraidOrientation("Portrait", 0);
    public static final MraidOrientation Landscape = new MraidOrientation("Landscape", 1);
    public static final MraidOrientation None = new MraidOrientation("None", 2);

    private static final /* synthetic */ MraidOrientation[] $values() {
        return new MraidOrientation[]{Portrait, Landscape, None};
    }

    public static EnumEntries<MraidOrientation> getEntries() {
        return $ENTRIES;
    }

    private MraidOrientation(String str, int i) {
    }

    static {
        MraidOrientation[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: MraidOrientation.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidOrientation$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Lio/adn/sdk/internal/ui/common/mraid/MraidOrientation;", "string", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MraidOrientation from(String string) {
            if (string == null) {
                return null;
            }
            int hashCode = string.hashCode();
            if (hashCode == 3387192) {
                if (string.equals("none")) {
                    return MraidOrientation.None;
                }
                return null;
            }
            if (hashCode == 729267099) {
                if (string.equals(C3040d4.h.D)) {
                    return MraidOrientation.Portrait;
                }
                return null;
            }
            if (hashCode == 1430647483 && string.equals(C3040d4.h.C)) {
                return MraidOrientation.Landscape;
            }
            return null;
        }
    }

    public static MraidOrientation valueOf(String str) {
        return (MraidOrientation) Enum.valueOf(MraidOrientation.class, str);
    }

    public static MraidOrientation[] values() {
        return (MraidOrientation[]) $VALUES.clone();
    }
}
