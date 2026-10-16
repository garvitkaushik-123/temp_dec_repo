package com.tiktok.appevents;

import com.tiktok.TikTokBusinessSdk;
import com.tiktok.util.TTLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public class TTAppEvent implements Serializable {
    private static final long serialVersionUID = 2;
    private String eventId;
    private String eventName;
    private String propertiesJson;
    private List<String> tiktokAppIds;
    private Date timeStamp;
    private TTAppEventType type;
    private Long uniqueId;
    private TTUserInfo userInfo;
    private static AtomicLong counter = new AtomicLong(new Date().getTime());
    private static String TAG = TTAppEventsQueue.class.getCanonicalName();
    private static TTLogger logger = new TTLogger(TAG, TikTokBusinessSdk.getLogLevel());

    public enum TTAppEventType {
        track,
        identify
    }

    TTAppEvent(TTAppEventType type, String eventName, String propertiesJson, String eventId, String[] ttAppId) {
        this(type, eventName, new Date(), propertiesJson, eventId, ttAppId);
    }

    TTAppEvent(TTAppEventType type, String eventName, Date timeStamp, String propertiesJson, String eventId, String[] ttAppId) {
        this.tiktokAppIds = new ArrayList();
        this.type = type;
        this.eventName = eventName;
        this.timeStamp = timeStamp;
        this.propertiesJson = propertiesJson;
        this.eventId = eventId;
        this.uniqueId = Long.valueOf(counter.getAndIncrement());
        this.userInfo = TTUserInfo.sharedInstance.m9167clone();
        if (ttAppId == null || ttAppId.length <= 0) {
            return;
        }
        for (String str : ttAppId) {
            this.tiktokAppIds.add(str);
        }
    }

    public TTUserInfo getUserInfo() {
        return this.userInfo;
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getType() {
        return this.type.name();
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getEventId() {
        return this.eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getPropertiesJson() {
        return this.propertiesJson;
    }

    public void setPropertiesJson(String propertiesJson) {
        this.propertiesJson = propertiesJson;
    }

    public Long getUniqueId() {
        return this.uniqueId;
    }

    public List<String> getTiktokAppIds() {
        return this.tiktokAppIds;
    }

    public void setTiktokAppIds(List<String> tiktokAppIds) {
        this.tiktokAppIds = tiktokAppIds;
    }

    public String toString() {
        return "TTAppEvent{eventName='" + this.eventName + "', timeStamp=" + this.timeStamp + ", propertiesJson='" + this.propertiesJson + "', eventId='" + this.eventId + "', uniqueId=" + this.uniqueId + ", tiktokAppIds=" + this.tiktokAppIds + AbstractJsonLexerKt.END_OBJ;
    }
}
