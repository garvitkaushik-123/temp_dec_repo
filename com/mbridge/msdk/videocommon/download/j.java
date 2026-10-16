package com.mbridge.msdk.videocommon.download;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.r0;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RewardVideoRefactorManager.java */
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f5277a;
    private AtomicBoolean b;

    /* compiled from: RewardVideoRefactorManager.java */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final j f5278a = new j();
    }

    public static j a() {
        return b.f5278a;
    }

    public boolean b(int i) {
        if (MBridgeConstans.DEBUG) {
            p0.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i + ", key: REWARD_VIDEO_REFACTOR_FOR_LOAD");
        }
        if (i != 94 && i != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.f5277a;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.f5277a = new AtomicBoolean(r0.a().a("r_v_r_f_l", false));
        } catch (Exception e) {
            this.f5277a = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e.getMessage());
            }
        }
        return this.f5277a.get();
    }

    private j() {
    }

    public boolean a(int i) {
        if (MBridgeConstans.DEBUG) {
            p0.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i + ", key: REWARD_VIDEO_REFACTOR_FOR_CAMPAIGN_REQUEST");
        }
        if (i != 94 && i != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.b;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.b = new AtomicBoolean(r0.a().a("r_v_r_f_c_r", false));
        } catch (Exception e) {
            this.b = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e.getMessage());
            }
        }
        return this.b.get();
    }
}
