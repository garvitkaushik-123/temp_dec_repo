package com.tiktok.appevents;

import com.tiktok.TikTokBusinessSdk;
import com.tiktok.util.TTConst;
import com.tiktok.util.TTKeyValueStore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
class TTAutoEventsManager {
    private static final String TAG = "com.tiktok.appevents.TTAutoEventsManager";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
    private final TTAppEventLogger appEventLogger;
    private final TTKeyValueStore store = new TTKeyValueStore(TikTokBusinessSdk.getApplicationContext());

    public TTAutoEventsManager(TTAppEventLogger appEventLogger) {
        this.appEventLogger = appEventLogger;
    }

    Boolean shouldTrackAppLifecycleEvents(TTConst.AutoEvents event) {
        return Boolean.valueOf(this.appEventLogger.lifecycleTrackEnable && !this.appEventLogger.disabledEvents.contains(event));
    }

    public void trackOnAppOpenEvents() {
        trackFirstInstallEvent();
        track2DayRetentionEvent();
        trackLaunchEvent();
    }

    private void trackFirstInstallEvent() {
        if (this.store.get(TTConst.TTSDK_APP_FIRST_INSTALL) != null) {
            return;
        }
        Date date = new Date();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TTConst.TTSDK_APP_FIRST_INSTALL, timeFormat.format(date));
        if (shouldTrackAppLifecycleEvents(TTConst.AutoEvents.InstallApp).booleanValue()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("type", "auto");
                this.appEventLogger.track(TTConst.AutoEvents.InstallApp.name, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.store.set(hashMap);
    }

    void track2DayRetentionEvent() {
        String str;
        if (this.store.get(TTConst.TTSDK_APP_2DR_TIME) == null && (str = this.store.get(TTConst.TTSDK_APP_FIRST_INSTALL)) != null) {
            try {
                Date parse = timeFormat.parse(str);
                Date date = new Date();
                if (shouldTrackAppLifecycleEvents(TTConst.AutoEvents.SecondDayRetention).booleanValue() && isSatisfyRetention(parse, date) && TTAppEventLogger.autoTrackRetentionEnable) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt("type", "auto");
                        this.appEventLogger.track(TTConst.AutoEvents.SecondDayRetention.name, jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    this.store.set(TTConst.TTSDK_APP_2DR_TIME, timeFormat.format(date));
                }
            } catch (ParseException unused) {
            }
        }
    }

    private void trackLaunchEvent() {
        if (shouldTrackAppLifecycleEvents(TTConst.AutoEvents.LaunchAPP).booleanValue()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("type", "auto");
                this.appEventLogger.track(TTConst.AutoEvents.LaunchAPP.name, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.store.set(TTConst.TTSDK_APP_LAST_LAUNCH, timeFormat.format(new Date()));
        }
    }

    private boolean isSatisfyRetention(Date firstLaunch, Date now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstLaunch);
        calendar.add(5, 1);
        SimpleDateFormat simpleDateFormat = dateFormat;
        return simpleDateFormat.format(calendar.getTime()).equals(simpleDateFormat.format(now));
    }
}
