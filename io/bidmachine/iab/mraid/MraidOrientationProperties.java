package io.bidmachine.iab.mraid;

import android.content.Context;
import com.ironsource.C3040d4;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public final class MraidOrientationProperties {
    public static final int FORCE_ORIENTATION_LANDSCAPE = 1;
    public static final int FORCE_ORIENTATION_NONE = 2;
    public static final int FORCE_ORIENTATION_PORTRAIT = 0;
    public boolean allowOrientationChange;
    public int forceOrientation;

    public MraidOrientationProperties(boolean allowOrientationChange, int forceOrientation) {
        this.allowOrientationChange = allowOrientationChange;
        this.forceOrientation = forceOrientation;
    }

    public static int forceOrientationFromString(String name) {
        int indexOf = Arrays.asList(C3040d4.h.D, C3040d4.h.C, "none").indexOf(name);
        if (indexOf != -1) {
            return indexOf;
        }
        return 2;
    }

    public String forceOrientationString() {
        int i = this.forceOrientation;
        return i != 0 ? i != 1 ? i != 2 ? "error" : "none" : C3040d4.h.C : C3040d4.h.D;
    }

    public int obtainTargetActivityOrientation(Context context) {
        int i = context.getResources().getConfiguration().orientation == 1 ? 1 : 0;
        int i2 = this.forceOrientation;
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 0;
        }
        if (this.allowOrientationChange) {
            return -1;
        }
        return i;
    }

    public String toString() {
        return "MRAIDOrientationProperties{allowOrientationChange=" + this.allowOrientationChange + ", forceOrientation=" + forceOrientationString() + AbstractJsonLexerKt.END_OBJ;
    }
}
