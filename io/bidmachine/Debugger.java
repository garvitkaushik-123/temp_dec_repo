package io.bidmachine;

import android.content.Context;
import android.util.Log;
import com.ironsource.C3040d4;
import io.bidmachine.util.Utils;
import io.bidmachine.util.file.FileUtilsKt;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: Debugger.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001J\u0017\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\b\u001eJ@\u0010\u001f\u001a\u00020\u0019*\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00042!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00190$H\u0082\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u00138@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0012\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00138@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0016\u0010\u0015¨\u0006("}, d2 = {"Lio/bidmachine/Debugger;", "", "()V", "DIR_NAME", "", "FILE_NAME", "LOGGING_LOCK", "Ljava/util/concurrent/atomic/AtomicBoolean;", "PARAMETER_CONSENT", "PARAMETER_COPPA", "PARAMETER_ENDPOINT", "PARAMETER_GDPR_STRING", "PARAMETER_LOGGING_ENABLED", "PARAMETER_SUBJECT_TO_GDPR", "PARAMETER_TEST_MODE", "PARAMETER_US_PRIVACY_STRING", "TAG", "TEST_MODE_LOCK", "isLoggingLock", "", "isLoggingLock$annotations", "()Z", "isTestModeLock", "isTestModeLock$annotations", "setup", "", "context", "Landroid/content/Context;", "setupFromJson", "json", "setupFromJson$bidmachine_android_sdk_bh_3_4_0", "applyAndLockIfExists", "jsonObject", "Lorg/json/JSONObject;", C3040d4.h.W, "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class Debugger {
    private static final String DIR_NAME = "features";
    private static final String FILE_NAME = "DebugParameters.json";
    private static final String PARAMETER_CONSENT = "consent";
    private static final String PARAMETER_COPPA = "coppa";
    private static final String PARAMETER_ENDPOINT = "endpoint";
    private static final String PARAMETER_GDPR_STRING = "GDPRString";
    private static final String PARAMETER_LOGGING_ENABLED = "loggingEnabled";
    private static final String PARAMETER_SUBJECT_TO_GDPR = "subjectToGDPR";
    private static final String PARAMETER_TEST_MODE = "testMode";
    private static final String PARAMETER_US_PRIVACY_STRING = "usPrivacyString";
    private static final String TAG = "Debugger";
    public static final Debugger INSTANCE = new Debugger();
    private static final AtomicBoolean LOGGING_LOCK = new AtomicBoolean(false);
    private static final AtomicBoolean TEST_MODE_LOCK = new AtomicBoolean(false);

    @JvmStatic
    public static /* synthetic */ void isLoggingLock$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isTestModeLock$annotations() {
    }

    private Debugger() {
    }

    public static final boolean isLoggingLock() {
        return LOGGING_LOCK.get();
    }

    public static final boolean isTestModeLock() {
        return TEST_MODE_LOCK.get();
    }

    @JvmStatic
    public static final void setup(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File externalDirDirty = FileUtilsKt.getExternalDirDirty(context);
            if (externalDirDirty == null) {
                return;
            }
            File file = new File(externalDirDirty, "features/DebugParameters.json");
            if (file.exists()) {
                Log.d(TAG, "Debug file found");
                INSTANCE.setupFromJson$bidmachine_android_sdk_bh_3_4_0(FileUtilsKt.readSafely(file));
            }
        } catch (Throwable th) {
            Log.w(TAG, th);
        }
    }

    public final void setupFromJson$bidmachine_android_sdk_bh_3_4_0(String json) {
        String str = json;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(json);
        AtomicBoolean atomicBoolean = LOGGING_LOCK;
        if (jSONObject.has(PARAMETER_LOGGING_ENABLED)) {
            BidMachine.setLoggingEnabled(jSONObject.optBoolean(PARAMETER_LOGGING_ENABLED));
            atomicBoolean.set(true);
        }
        AtomicBoolean atomicBoolean2 = TEST_MODE_LOCK;
        if (jSONObject.has(PARAMETER_TEST_MODE)) {
            BidMachine.setTestMode(jSONObject.optBoolean(PARAMETER_TEST_MODE));
            atomicBoolean2.set(true);
        }
        if (jSONObject.has("endpoint")) {
            String optString = jSONObject.optString("endpoint");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(PARAMETER_ENDPOINT)");
            String obj = StringsKt.trim((CharSequence) optString).toString();
            if (obj.length() > 0 && Utils.isHttpUrl(obj)) {
                BidMachine.setEndpoint(obj);
            }
        }
        if (jSONObject.has(PARAMETER_COPPA)) {
            BidMachine.setCoppa(Boolean.valueOf(jSONObject.optBoolean(PARAMETER_COPPA)));
        }
        if (jSONObject.has(PARAMETER_US_PRIVACY_STRING)) {
            BidMachine.setUSPrivacyString(jSONObject.optString(PARAMETER_US_PRIVACY_STRING));
        }
        if (jSONObject.has(PARAMETER_SUBJECT_TO_GDPR)) {
            BidMachine.setSubjectToGDPR(Boolean.valueOf(jSONObject.optBoolean(PARAMETER_SUBJECT_TO_GDPR)));
        }
        if (jSONObject.has("consent")) {
            BidMachine.setConsentConfig(jSONObject.optBoolean("consent"), jSONObject.has(PARAMETER_GDPR_STRING) ? jSONObject.optString(PARAMETER_GDPR_STRING) : null);
        }
    }

    private final void applyAndLockIfExists(AtomicBoolean atomicBoolean, JSONObject jSONObject, String str, Function1<? super Boolean, Unit> function1) {
        if (jSONObject.has(str)) {
            function1.invoke(Boolean.valueOf(jSONObject.optBoolean(str)));
            atomicBoolean.set(true);
        }
    }
}
