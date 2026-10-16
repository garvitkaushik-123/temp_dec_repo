package io.adn.sdk.internal.domain.model.metrics;

import com.ironsource.Z3;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ConnectionType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lio/adn/sdk/internal/domain/model/metrics/ConnectionType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Mobile2g", "Mobile3g", "Mobile4g", "Mobile5g", "MobileUnknown", "WIFI", "Ethernet", "Unknown", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ConnectionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConnectionType[] $VALUES;
    private final String value;
    public static final ConnectionType Mobile2g = new ConnectionType("Mobile2g", 0, "2g");
    public static final ConnectionType Mobile3g = new ConnectionType("Mobile3g", 1, Z3.f3155a);
    public static final ConnectionType Mobile4g = new ConnectionType("Mobile4g", 2, "4g");
    public static final ConnectionType Mobile5g = new ConnectionType("Mobile5g", 3, "5g");
    public static final ConnectionType MobileUnknown = new ConnectionType("MobileUnknown", 4, "cellularUnknown");
    public static final ConnectionType WIFI = new ConnectionType("WIFI", 5, Z3.b);
    public static final ConnectionType Ethernet = new ConnectionType("Ethernet", 6, Z3.e);
    public static final ConnectionType Unknown = new ConnectionType("Unknown", 7, "unknown");

    private static final /* synthetic */ ConnectionType[] $values() {
        return new ConnectionType[]{Mobile2g, Mobile3g, Mobile4g, Mobile5g, MobileUnknown, WIFI, Ethernet, Unknown};
    }

    public static EnumEntries<ConnectionType> getEntries() {
        return $ENTRIES;
    }

    private ConnectionType(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        ConnectionType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ConnectionType valueOf(String str) {
        return (ConnectionType) Enum.valueOf(ConnectionType.class, str);
    }

    public static ConnectionType[] values() {
        return (ConnectionType[]) $VALUES.clone();
    }
}
