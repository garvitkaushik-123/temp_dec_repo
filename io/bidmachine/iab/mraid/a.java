package io.bidmachine.iab.mraid;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    static final DateFormat f6839a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ", Locale.US);
    static final String[] b = {"SU", "MO", "TU", "WE", "TH", "FR", "SA"};

    a() {
    }

    MraidCalendarEvent a(String jsonString) {
        return b(new JSONObject(jsonString));
    }

    MraidCalendarEvent b(JSONObject jsonObject) {
        String str = (String) Objects.requireNonNull(jsonObject.getString("description"));
        DateFormat dateFormat = f6839a;
        MraidCalendarEvent mraidCalendarEvent = new MraidCalendarEvent(str, (Date) Objects.requireNonNull(dateFormat.parse(jsonObject.getString("start"))));
        if (jsonObject.has(FirebaseAnalytics.Param.LOCATION)) {
            mraidCalendarEvent.a(jsonObject.getString(FirebaseAnalytics.Param.LOCATION));
        }
        if (jsonObject.has("summary")) {
            mraidCalendarEvent.d(jsonObject.getString("summary"));
        }
        if (jsonObject.has("end")) {
            mraidCalendarEvent.a(dateFormat.parse(jsonObject.getString("end")));
        }
        if (jsonObject.has("status")) {
            mraidCalendarEvent.c(jsonObject.getString("status"));
        }
        if (jsonObject.has("transparency")) {
            mraidCalendarEvent.e(jsonObject.getString("transparency"));
        }
        if (jsonObject.has("recurrence")) {
            mraidCalendarEvent.b(a(jsonObject.getJSONObject("recurrence")));
        }
        return mraidCalendarEvent;
    }

    void c(JSONObject jsonObject, StringBuilder sb) {
        if (jsonObject.isNull("interval")) {
            return;
        }
        try {
            sb.append("INTERVAL=").append(jsonObject.getInt("interval")).append(";");
        } catch (Exception unused) {
        }
    }

    void d(JSONObject jsonObject, StringBuilder sb) {
        try {
            if (jsonObject.isNull("frequency") || !"monthly".equalsIgnoreCase(jsonObject.getString("frequency"))) {
                return;
            }
            if (!jsonObject.isNull("daysInMonth")) {
                JSONArray jSONArray = jsonObject.getJSONArray("daysInMonth");
                if (jSONArray.length() > 0) {
                    sb.append("BYMONTHDAY=").append(b(jSONArray)).append(";");
                }
            }
            if (jsonObject.isNull("weeksInMonth")) {
                return;
            }
            JSONArray jSONArray2 = jsonObject.getJSONArray("weeksInMonth");
            if (jSONArray2.length() > 0) {
                sb.append("BYWEEKNO=").append(b(jSONArray2)).append(";");
            }
        } catch (Exception unused) {
        }
    }

    void e(JSONObject jsonObject, StringBuilder sb) {
        try {
            if (jsonObject.isNull("frequency") || !"weekly".equalsIgnoreCase(jsonObject.getString("frequency")) || jsonObject.isNull("daysInWeek")) {
                return;
            }
            JSONArray jSONArray = jsonObject.getJSONArray("daysInWeek");
            if (jSONArray.length() > 0) {
                sb.append("BYDAY=").append(a(jSONArray)).append(";");
            }
        } catch (Exception unused) {
        }
    }

    void f(JSONObject jsonObject, StringBuilder sb) {
        try {
            if (jsonObject.isNull("frequency") || !"yearly".equalsIgnoreCase(jsonObject.getString("frequency"))) {
                return;
            }
            if (!jsonObject.isNull("monthsInYear")) {
                JSONArray jSONArray = jsonObject.getJSONArray("monthsInYear");
                if (jSONArray.length() > 0) {
                    sb.append("BYMONTH=").append(b(jSONArray)).append(";");
                }
            }
            if (jsonObject.isNull("daysInYear")) {
                return;
            }
            JSONArray jSONArray2 = jsonObject.getJSONArray("daysInYear");
            if (jSONArray2.length() > 0) {
                sb.append("BYYEARDAY=").append(b(jSONArray2)).append(";");
            }
        } catch (Exception unused) {
        }
    }

    String a(JSONObject jsonObject) {
        StringBuilder sb = new StringBuilder();
        b(jsonObject, sb);
        c(jsonObject, sb);
        a(jsonObject, sb);
        e(jsonObject, sb);
        d(jsonObject, sb);
        f(jsonObject, sb);
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    void a(JSONObject jsonObject, StringBuilder sb) {
        if (jsonObject.isNull("expires")) {
            return;
        }
        try {
            sb.append("UNTIL=").append(f6839a.parse(jsonObject.getString("expires"))).append(";");
        } catch (Exception unused) {
        }
    }

    String a(JSONArray jsonArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jsonArray.length(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            int i2 = jsonArray.getInt(i);
            if (i2 >= 0 && i2 <= 6) {
                sb.append(b[i2]);
            }
        }
        return sb.toString();
    }

    void b(JSONObject jsonObject, StringBuilder sb) {
        if (jsonObject.isNull("frequency")) {
            return;
        }
        try {
            sb.append("FREQ=").append(jsonObject.getString("frequency")).append(";");
        } catch (Exception unused) {
        }
    }

    String b(JSONArray jsonArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jsonArray.length(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(jsonArray.get(i).toString());
        }
        return sb.toString();
    }
}
