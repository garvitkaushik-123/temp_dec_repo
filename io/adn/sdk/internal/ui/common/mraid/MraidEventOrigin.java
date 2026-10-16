package io.adn.sdk.internal.ui.common.mraid;

import android.net.Uri;
import com.google.firebase.messaging.Constants;
import io.adn.sdk.internal.common.utils.UriKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MraidWebViewEvent.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "", "<init>", "(Ljava/lang/String;I)V", "EXTERNAL_REDIRECTION", "MRAID", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MraidEventOrigin {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MraidEventOrigin[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final MraidEventOrigin EXTERNAL_REDIRECTION = new MraidEventOrigin("EXTERNAL_REDIRECTION", 0);
    public static final MraidEventOrigin MRAID = new MraidEventOrigin("MRAID", 1);

    private static final /* synthetic */ MraidEventOrigin[] $values() {
        return new MraidEventOrigin[]{EXTERNAL_REDIRECTION, MRAID};
    }

    public static EnumEntries<MraidEventOrigin> getEntries() {
        return $ENTRIES;
    }

    private MraidEventOrigin(String str, int i) {
    }

    static {
        MraidEventOrigin[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: MraidWebViewEvent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Lio/adn/sdk/internal/ui/common/mraid/MraidEventOrigin;", "uri", "Landroid/net/Uri;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MraidEventOrigin from(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            if (UriKt.isExternalUrl(uri)) {
                return MraidEventOrigin.EXTERNAL_REDIRECTION;
            }
            if (UriKt.isMraid(uri)) {
                return MraidEventOrigin.MRAID;
            }
            return null;
        }
    }

    public static MraidEventOrigin valueOf(String str) {
        return (MraidEventOrigin) Enum.valueOf(MraidEventOrigin.class, str);
    }

    public static MraidEventOrigin[] values() {
        return (MraidEventOrigin[]) $VALUES.clone();
    }
}
