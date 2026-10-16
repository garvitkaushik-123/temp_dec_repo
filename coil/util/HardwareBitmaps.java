package coil.util;

import kotlin.Metadata;

/* compiled from: HardwareBitmaps.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"IS_DEVICE_BLOCKED", "", "HardwareBitmapService", "Lcoil/util/HardwareBitmapService;", "logger", "Lcoil/util/Logger;", "coil-base_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* renamed from: coil.util.-HardwareBitmaps, reason: invalid class name */
/* loaded from: classes2.dex */
public final class HardwareBitmaps {
    private static final boolean IS_DEVICE_BLOCKED = false;

    public static final HardwareBitmapService HardwareBitmapService(Logger logger) {
        return IS_DEVICE_BLOCKED ? new ImmutableHardwareBitmapService(false) : new ImmutableHardwareBitmapService(true);
    }
}
