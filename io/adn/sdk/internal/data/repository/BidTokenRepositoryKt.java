package io.adn.sdk.internal.data.repository;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.Metadata;

/* compiled from: BidTokenRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"ADS_CONSENT_GIVEN", "", "AIRPLANE_MODE_ENABLE", "APPSET_ID", "APP_VERSION", "AVAILABLE_DISK_SPACE", "BATTERY", "BATTERY_SAVER_ENABLE", "BATT_CHARGE", "BLUETOOTH", "DARK_MODE_ENABLE", "DEVICE_MANUFACTURER", "DEVICE_MODEL", "DO_NOT_DIST", "DO_NOT_SELL", IronSourceConstants.TYPE_GAID, "HEADSET", "IS_WALKING", "LOCAL_DATE", "ORIENTATION", "PPI", "SDK_VERSION", "SOUND_ENABLE", "TEST_MODE", "TOKEN_INDEX", "TOTAL_DISK_SPACE", "UTC_DATE", "APPSET_ID_SCOPE", "BOOT_TIME", "CONNECTIVITY", "GLOBAL_TOKEN_INDEX", "KEYBOARD_LANG", "LIMIT_AD_TRACKING", "IDFA_AUTHORIZATION_STATUS", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class BidTokenRepositoryKt {
    public static final String ADS_CONSENT_GIVEN = "ads_consent_given";
    public static final String AIRPLANE_MODE_ENABLE = "airplane_mode_enable";
    public static final String APPSET_ID = "appset_id";
    private static final String APPSET_ID_SCOPE = "appset_id_scope";
    public static final String APP_VERSION = "app_version";
    public static final String AVAILABLE_DISK_SPACE = "available_disk_space";
    public static final String BATTERY = "battery";
    public static final String BATTERY_SAVER_ENABLE = "battery_saver_enable";
    public static final String BATT_CHARGE = "batt_charge";
    public static final String BLUETOOTH = "bluetooth";
    private static final String BOOT_TIME = "boot_time";
    private static final String CONNECTIVITY = "connectivity";
    public static final String DARK_MODE_ENABLE = "dark_mode_enable";
    public static final String DEVICE_MANUFACTURER = "device_manufacturer";
    public static final String DEVICE_MODEL = "device_model";
    public static final String DO_NOT_DIST = "do_not_dist";
    public static final String DO_NOT_SELL = "do_not_sell";
    public static final String GAID = "gaid";
    private static final String GLOBAL_TOKEN_INDEX = "global_token_index";
    public static final String HEADSET = "headset";
    private static final String IDFA_AUTHORIZATION_STATUS = "idfa_authorization_status";
    public static final String IS_WALKING = "is_walking";
    private static final String KEYBOARD_LANG = "keyboard_lang";
    private static final String LIMIT_AD_TRACKING = "limit_ad_tracking";
    public static final String LOCAL_DATE = "local_date";
    public static final String ORIENTATION = "orientation";
    public static final String PPI = "ppi";
    public static final String SDK_VERSION = "sdk_version";
    public static final String SOUND_ENABLE = "sound_enable";
    public static final String TEST_MODE = "test_mode";
    public static final String TOKEN_INDEX = "token_index";
    public static final String TOTAL_DISK_SPACE = "total_disk_space";
    public static final String UTC_DATE = "utc_date";
}
