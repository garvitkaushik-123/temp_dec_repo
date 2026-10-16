package io.bidmachine.utils.time;

import java.util.TimeZone;

/* loaded from: classes8.dex */
public final class SystemTimeManagerInstance implements TimeManagerInstance {
    @Override // io.bidmachine.utils.time.TimeManagerInstance
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // io.bidmachine.utils.time.TimeManagerInstance
    public String getTimeZoneId() {
        return TimeZone.getDefault().getID();
    }
}
