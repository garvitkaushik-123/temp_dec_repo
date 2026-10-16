package com.fyber.inneractive.sdk.config.global;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.IAlog;
import org.slf4j.Marker;

/* loaded from: classes4.dex */
public final class j implements d {

    /* renamed from: a, reason: collision with root package name */
    public final String f1093a;
    public final boolean b;

    public j(boolean z, String str) {
        this.f1093a = str;
        this.b = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0100  */
    @Override // com.fyber.inneractive.sdk.config.global.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(e eVar) {
        boolean z;
        boolean z2;
        if (!TextUtils.isEmpty(this.f1093a)) {
            String version = InneractiveAdManager.getVersion();
            IAlog.a("%s: shouldApply - running version: %s", com.mbridge.msdk.foundation.same.report.j.b, version);
            IAlog.a("%s: shouldApply - filter version: %s", com.mbridge.msdk.foundation.same.report.j.b, this.f1093a);
            String[] split = version.split("\\.", 4);
            String[] split2 = this.f1093a.split("\\.", 4);
            String str = split2[split2.length - 1];
            if (str.equals("*")) {
                for (int i = 0; i < split2.length - 1; i++) {
                    if (split.length < i) {
                        IAlog.a("%s: shouldApplyByAsterix - running version is shorter than filter. applying", com.mbridge.msdk.foundation.same.report.j.b);
                    } else if (!split[i].equals(split2[i])) {
                        IAlog.a("%s: shouldApplyByAsterix - running version does not comply with filter. applying", com.mbridge.msdk.foundation.same.report.j.b);
                    }
                    z2 = true;
                }
                IAlog.a("%s: shouldApplyByAsterix - version aligned with filter. do not apply", com.mbridge.msdk.foundation.same.report.j.b);
                z2 = false;
                IAlog.a("%s: shouldApply - * version match: %b", com.mbridge.msdk.foundation.same.report.j.b, Boolean.valueOf(!z2));
                return z2 ? this.b : !this.b;
            }
            if (str.equals(Marker.ANY_NON_NULL_MARKER)) {
                int i2 = 0;
                while (true) {
                    if (i2 >= split2.length - 1) {
                        IAlog.a("%s: shouldApplyByAsterix - version aligned with filter. do not apply", com.mbridge.msdk.foundation.same.report.j.b);
                        break;
                    }
                    if (split.length < i2) {
                        IAlog.a("%s: shouldApplyByPlus - running version is shorter than filter. applying", com.mbridge.msdk.foundation.same.report.j.b);
                        break;
                    }
                    try {
                        int intValue = Integer.valueOf(split2[i2]).intValue();
                        int intValue2 = Integer.valueOf(split[i2]).intValue();
                        if (intValue2 > intValue) {
                            IAlog.a("%s: shouldApplyByPlus - running version is greater than the filter's version. no filter needed", com.mbridge.msdk.foundation.same.report.j.b);
                            break;
                        }
                        if (intValue2 < intValue) {
                            IAlog.a("%s: shouldApplyByPlus - running version is lower than the filter's version. applying filter ", com.mbridge.msdk.foundation.same.report.j.b);
                            break;
                        }
                        i2++;
                    } catch (NumberFormatException e) {
                        IAlog.a("%s: shouldApplyByPlus - Error in version string! Not a number. %s", com.mbridge.msdk.foundation.same.report.j.b, e.getMessage());
                    }
                }
                z = false;
                IAlog.a("%s: shouldApply - + version match: %b", com.mbridge.msdk.foundation.same.report.j.b, Boolean.valueOf(!z));
                return !z ? this.b : !this.b;
            }
            boolean equalsIgnoreCase = this.f1093a.equalsIgnoreCase(version);
            IAlog.a("%s: shouldApply - exact version match: %b", com.mbridge.msdk.foundation.same.report.j.b, Boolean.valueOf(equalsIgnoreCase));
            if (!equalsIgnoreCase) {
                return this.b;
            }
            if (!this.b) {
                return true;
            }
        }
        return false;
        z = true;
        IAlog.a("%s: shouldApply - + version match: %b", com.mbridge.msdk.foundation.same.report.j.b, Boolean.valueOf(!z));
        if (!z) {
        }
    }

    public final String toString() {
        return "sdk - " + this.f1093a + " include: " + this.b;
    }
}
