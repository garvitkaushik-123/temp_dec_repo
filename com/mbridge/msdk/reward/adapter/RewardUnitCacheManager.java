package com.mbridge.msdk.reward.adapter;

import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.system.NoProGuard;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public final class RewardUnitCacheManager implements NoProGuard {
    private static final String TAG = "RewardUnitCacheManager";
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.setting.c> rewardUnitSettings;

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final RewardUnitCacheManager f4623a = new RewardUnitCacheManager();
    }

    public static RewardUnitCacheManager getInstance() {
        return b.f4623a;
    }

    public void add(String str, String str2, com.mbridge.msdk.videocommon.setting.c cVar) {
        try {
            String str3 = str + "_" + str2;
            if (cVar != null && this.rewardUnitSettings.containsKey(str3)) {
                this.rewardUnitSettings.remove(str3);
            }
            this.rewardUnitSettings.put(str3, cVar);
        } catch (Exception e) {
            p0.b(TAG, e.getMessage());
        }
    }

    public com.mbridge.msdk.videocommon.setting.c get(String str, String str2) {
        try {
            try {
                return this.rewardUnitSettings.remove(str + "_" + str2);
            } catch (Exception e) {
                p0.b(TAG, e.getMessage());
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private RewardUnitCacheManager() {
        this.rewardUnitSettings = new ConcurrentHashMap<>();
    }
}
