package io.bidmachine.iab.mraid;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public final class MraidNativeFeature {
    public static final String FEATURE_CALENDAR = "calendar";
    public static final String FEATURE_SMS = "sms";
    public static final String FEATURE_STORE_PICTURE = "storePicture";
    public static final String FEATURE_TEL = "tel";
    public static final String FEATURE_INLINE_VIDEO = "inlineVideo";

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f6813a = {"sms", "tel", FEATURE_INLINE_VIDEO, "calendar", "storePicture"};

    private MraidNativeFeature() {
    }

    private static ArrayList<String> a(MraidNativeFeatureManager featureManager) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (featureManager.isTelFeatureAvailable()) {
            arrayList.add("tel");
        }
        if (featureManager.isSmsFeatureAvailable()) {
            arrayList.add("sms");
        }
        if (featureManager.isInlineVideoFeatureAvailable()) {
            arrayList.add(FEATURE_INLINE_VIDEO);
        }
        if (featureManager.isCalendarFeatureAvailable()) {
            arrayList.add("calendar");
        }
        if (featureManager.isStorePictureFeatureAvailable()) {
            arrayList.add("storePicture");
        }
        return arrayList;
    }

    public static String[] getSupportedFeatures(Context context) {
        return (String[]) a(new MraidNativeFeatureManager(context, f6813a)).toArray(new String[0]);
    }
}
