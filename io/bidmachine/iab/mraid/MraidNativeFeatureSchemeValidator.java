package io.bidmachine.iab.mraid;

/* loaded from: classes7.dex */
public final class MraidNativeFeatureSchemeValidator {
    public static final String SCHEME_CALENDAR = "calendar";
    public static final String SCHEME_SMS = "sms";
    public static final String SCHEME_STORE_PICTURE = "storePicture";
    public static final String SCHEME_TEL = "tel";

    /* renamed from: a, reason: collision with root package name */
    private final MraidNativeFeatureManager f6815a;

    MraidNativeFeatureSchemeValidator(MraidNativeFeatureManager featureManager) {
        this.f6815a = featureManager;
    }

    boolean a(String url) {
        if (url == null) {
            return true;
        }
        if (url.startsWith("sms")) {
            return this.f6815a.isSmsFeatureAvailable();
        }
        if (url.startsWith("tel")) {
            return this.f6815a.isTelFeatureAvailable();
        }
        if (url.startsWith("calendar")) {
            return this.f6815a.isCalendarFeatureAvailable();
        }
        if (url.startsWith("storePicture")) {
            return this.f6815a.isStorePictureFeatureAvailable();
        }
        return true;
    }
}
