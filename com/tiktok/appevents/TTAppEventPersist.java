package com.tiktok.appevents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
class TTAppEventPersist implements Serializable {
    public static final long serialVersionUID = 1;
    private List<TTAppEvent> appEvents = new ArrayList();

    TTAppEventPersist() {
    }

    public void addEvents(List<TTAppEvent> appEventList) {
        if (appEventList == null || appEventList.isEmpty()) {
            return;
        }
        this.appEvents.addAll(appEventList);
    }

    public List<TTAppEvent> getAppEvents() {
        return this.appEvents;
    }

    public void setAppEvents(List<TTAppEvent> appEvents) {
        this.appEvents = appEvents;
    }

    public boolean isEmpty() {
        return this.appEvents.isEmpty();
    }

    public String toString() {
        return "TTAppEventPersist{appEvents=" + this.appEvents + AbstractJsonLexerKt.END_OBJ;
    }
}
