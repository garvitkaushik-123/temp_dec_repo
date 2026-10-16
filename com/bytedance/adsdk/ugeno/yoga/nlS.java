package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: classes3.dex */
public class nlS extends YogaNodeJNIBase {
    protected void finalize() throws Throwable {
        try {
            NU();
        } finally {
            super.finalize();
        }
    }

    public void NU() {
        if (this.eli != 0) {
            long j = this.eli;
            this.eli = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j);
        }
    }
}
