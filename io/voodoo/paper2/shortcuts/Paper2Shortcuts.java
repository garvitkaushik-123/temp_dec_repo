package io.voodoo.paper2.shortcuts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Paper2Shortcuts.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/voodoo/paper2/shortcuts/Paper2Shortcuts;", "", "()V", "ACTION_KIND_DEEPLINK", "", "TAG", "currentUnityActivity", "Landroid/app/Activity;", "iconForKey", "Landroidx/core/graphics/drawable/IconCompat;", "activity", "iconKey", "setDynamicShortcuts", "", "payloadJson", "paper2shortcuts.androidlib_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Paper2Shortcuts {
    private static final String ACTION_KIND_DEEPLINK = "deeplink";
    public static final Paper2Shortcuts INSTANCE = new Paper2Shortcuts();
    private static final String TAG = "Paper2Shortcuts";

    private Paper2Shortcuts() {
    }

    @JvmStatic
    public static final void setDynamicShortcuts(String payloadJson) {
        Intrinsics.checkNotNullParameter(payloadJson, "payloadJson");
        try {
            Activity currentUnityActivity = INSTANCE.currentUnityActivity();
            if (currentUnityActivity == null) {
                Log.w(TAG, "setDynamicShortcuts: UnityPlayer.currentActivity is null");
                return;
            }
            JSONArray jSONArray = new JSONObject(payloadJson).getJSONArray("shortcuts");
            int maxShortcutCountPerActivity = ShortcutManagerCompat.getMaxShortcutCountPerActivity(currentUnityActivity);
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length && (maxShortcutCountPerActivity <= 0 || arrayList.size() < maxShortcutCountPerActivity); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString("id");
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("uri");
                String optString4 = jSONObject.optString("actionKind");
                String optString5 = jSONObject.optString("shortLabel");
                String optString6 = jSONObject.optString("iconKey");
                Intrinsics.checkNotNull(optString);
                if (optString.length() != 0) {
                    Intrinsics.checkNotNull(optString2);
                    if (optString2.length() != 0) {
                        Intrinsics.checkNotNull(optString3);
                        if (optString3.length() != 0) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString3));
                            intent.addFlags(335544320);
                            if (Intrinsics.areEqual(optString4, "deeplink")) {
                                intent.setPackage(currentUnityActivity.getPackageName());
                            }
                            Intrinsics.checkNotNull(optString5);
                            if (optString5.length() <= 0) {
                                optString5 = optString2;
                            }
                            ShortcutInfoCompat.Builder longLabel = new ShortcutInfoCompat.Builder(currentUnityActivity, optString).setShortLabel(optString5).setLongLabel(optString2);
                            Paper2Shortcuts paper2Shortcuts = INSTANCE;
                            Intrinsics.checkNotNull(optString6);
                            ShortcutInfoCompat build = longLabel.setIcon(paper2Shortcuts.iconForKey(currentUnityActivity, optString6)).setIntent(intent).build();
                            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                            arrayList.add(build);
                        }
                    }
                }
            }
            Log.i(TAG, "setDynamicShortcuts: published=" + arrayList.size() + " ok=" + ShortcutManagerCompat.setDynamicShortcuts(currentUnityActivity, arrayList) + " max=" + maxShortcutCountPerActivity);
        } catch (Throwable th) {
            Log.w(TAG, "setDynamicShortcuts failed", th);
        }
    }

    private final Activity currentUnityActivity() {
        try {
            Object obj = Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME).getDeclaredField("currentActivity").get(null);
            if (obj instanceof Activity) {
                return (Activity) obj;
            }
            return null;
        } catch (Throwable th) {
            Log.w(TAG, "Failed to resolve UnityPlayer.currentActivity", th);
            return null;
        }
    }

    private final IconCompat iconForKey(Activity activity, String iconKey) {
        int i;
        int hashCode = iconKey.hashCode();
        if (hashCode == 110873) {
            if (iconKey.equals("pen")) {
                i = R.mipmap.ic_shortcut_pen_adaptive;
            }
            i = android.R.drawable.ic_menu_info_details;
        } else if (hashCode != 3172656) {
            if (hashCode == 95011556 && iconKey.equals("cubey")) {
                i = R.mipmap.ic_shortcut_cubey_adaptive;
            }
            i = android.R.drawable.ic_menu_info_details;
        } else {
            if (iconKey.equals("gift")) {
                i = R.mipmap.ic_shortcut_gift_adaptive;
            }
            i = android.R.drawable.ic_menu_info_details;
        }
        IconCompat createWithResource = IconCompat.createWithResource(activity, i);
        Intrinsics.checkNotNullExpressionValue(createWithResource, "createWithResource(...)");
        return createWithResource;
    }
}
