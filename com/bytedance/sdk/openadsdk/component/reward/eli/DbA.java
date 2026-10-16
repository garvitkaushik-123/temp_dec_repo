package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.Ue;
import com.bytedance.sdk.openadsdk.core.model.ev;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private static final SparseArray<WeakReference<ev>> eli = new SparseArray<>();

    public static void eli(eli eliVar, Intent intent, Bundle bundle) {
        eli(intent, eliVar);
        eli(bundle, eliVar);
    }

    public static ev eli(Intent intent, Bundle bundle, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA) {
        if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            com.bytedance.sdk.openadsdk.core.model.eli DbA = Ue.eli().DbA(Ue.eli(intent));
            r3 = DbA != null ? DbA.du() : null;
            if (dbA != null) {
                dbA.eli(bundle);
            }
            Ue.eli().ui();
        } else if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_AD_INFO);
                if (stringExtra != null) {
                    r3 = com.bytedance.sdk.openadsdk.core.model.eli.DbA(new JSONObject(stringExtra)).du();
                }
            } catch (Exception e) {
                Xb.eli("TTAD.RFDM", "", e);
            }
        }
        if (bundle != null) {
            try {
                WeakReference<ev> weakReference = eli.get(bundle.getInt("meta_tmp"));
                if (weakReference != null) {
                    r3 = weakReference.get();
                }
            } catch (Throwable th) {
                Xb.eli("TTAD.RFDM", "", th);
            }
        }
        if (r3 != null) {
            r3.eli(r3.oc(), 7);
        }
        return r3;
    }

    public static void eli(Intent intent, eli eliVar) {
        if (intent == null) {
            return;
        }
        eliVar.ev.Os(intent.getBooleanExtra("video_is_cached", false));
        eliVar.ikX = intent.getStringExtra("multi_process_listener_key");
        eliVar.Yw = intent.getIntExtra("orientation_angle", 0) == 3;
    }

    public static void eli(Bundle bundle, eli eliVar) {
        if (bundle == null) {
            return;
        }
        eliVar.ikX = bundle.getString("multi_process_listener_key");
        eliVar.ev.Os(bundle.getBoolean("video_is_cached", false));
        eliVar.tGZ = bundle.getBoolean("is_mute");
        if (bundle.getLong("video_current") > 0) {
            eliVar.ev.DbA(bundle.getLong("video_current", 0L));
        }
        eliVar.eli(bundle.getBoolean("has_show_skip_btn"));
    }

    public static void eli(eli eliVar, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            ev evVar = eliVar.DbA;
            eli.append(evVar.hashCode(), new WeakReference<>(evVar));
            bundle.putInt("meta_tmp", evVar.hashCode());
            bundle.putString("multi_process_listener_key", eliVar.ikX);
            bundle.putBoolean("video_is_cached", eliVar.ev.oWW());
            bundle.putLong("video_current", eliVar.ev.nlS());
            bundle.putBoolean("is_mute", eliVar.tGZ);
            bundle.putBoolean("has_show_skip_btn", eliVar.qyC);
        } catch (Throwable th) {
            Xb.eli("TTAD.RFDM", "onSaveInstanceState: ", th);
        }
    }

    public static void eli(ev evVar, Intent intent, Bundle bundle) {
        if (bundle == null || evVar == null) {
            return;
        }
        try {
            eli.append(evVar.hashCode(), new WeakReference<>(evVar));
            bundle.putInt("meta_tmp", evVar.hashCode());
            if (intent != null) {
                bundle.putString("multi_process_listener_key", intent.getStringExtra("multi_process_listener_key"));
                bundle.putBoolean("video_is_cached", intent.getBooleanExtra("video_is_cached", false));
            }
        } catch (Throwable th) {
            Xb.eli("TTAD.RFDM", "onSaveInstanceState: ", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void eli(Intent intent, Activity activity, boolean z, com.bytedance.sdk.openadsdk.core.model.eli eliVar, String str) {
        int rotation;
        if (activity == null) {
            intent.addFlags(268435456);
        } else {
            try {
                rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            } catch (Exception e) {
                Xb.eli("TTAD.RFDM", "", e);
            }
            intent.putExtra("orientation_angle", rotation);
            intent.putExtra("video_is_cached", z);
            if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                JSONObject NU = eliVar.NU();
                if (NU == null) {
                    return;
                }
                intent.putExtra(TTAdConstant.MULTI_PROCESS_AD_INFO, NU.toString());
                intent.putExtra("multi_process_listener_key", str);
                return;
            }
            Ue.eli().ui();
            intent.putExtra("meta_index", Ue.eli().eli(eliVar));
            return;
        }
        rotation = 0;
        intent.putExtra("orientation_angle", rotation);
        intent.putExtra("video_is_cached", z);
        if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
        }
    }
}
