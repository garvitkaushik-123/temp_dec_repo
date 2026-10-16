package io.bidmachine.analytics.internal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes7.dex */
public final class N {

    /* renamed from: a, reason: collision with root package name */
    private final SimpleDateFormat f6664a = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss.SSS", Locale.getDefault());

    public final Long a(String str) {
        Date parse = this.f6664a.parse(Calendar.getInstance().get(1) + '-' + str);
        if (parse != null) {
            return Long.valueOf(parse.getTime());
        }
        return null;
    }
}
