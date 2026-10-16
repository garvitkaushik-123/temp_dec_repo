package com.bytedance.sdk.component.adexpress.dynamic.aGH;

import java.util.Arrays;

/* loaded from: classes3.dex */
public class FC {
    public float DbA;
    public float eli;

    public FC(float f, float f2) {
        this.eli = f;
        this.DbA = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            FC fc = (FC) obj;
            if (Float.compare(fc.eli, this.eli) == 0 && Float.compare(fc.DbA, this.DbA) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.eli), Float.valueOf(this.DbA)});
    }
}
