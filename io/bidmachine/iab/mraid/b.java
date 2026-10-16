package io.bidmachine.iab.mraid;

import android.net.Uri;

/* loaded from: classes7.dex */
final class b {
    b() {
    }

    String a(String eventJson) {
        try {
            return new Uri.Builder().scheme("calendar").authority("mraid").appendQueryParameter("eventJson", eventJson).build().toString();
        } catch (Exception e) {
            MraidLog.e("MraidNativeFeatureUrlFactory", e);
            return null;
        }
    }

    String b(String url) {
        try {
            return new Uri.Builder().scheme("storePicture").authority("mraid").appendQueryParameter("url", url).build().toString();
        } catch (Exception e) {
            MraidLog.e("MraidNativeFeatureUrlFactory", e);
            return null;
        }
    }
}
