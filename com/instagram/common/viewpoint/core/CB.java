package com.instagram.common.viewpoint.core;

import com.google.common.base.ElementTypesAreNonnullByDefault;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: assets/audience_network/classes2.dex */
public abstract class CB extends AbstractC2136kK {
    public static int A00(@CheckForNull Object... objects) {
        return Arrays.hashCode(objects);
    }

    public static boolean A01(@CheckForNull Object a2, @CheckForNull Object b) {
        return a2 == b || (a2 != null && a2.equals(b));
    }
}
