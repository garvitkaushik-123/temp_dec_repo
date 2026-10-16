package io.bidmachine.iab.mraid;

import java.util.Date;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class MraidCalendarEvent {

    /* renamed from: a, reason: collision with root package name */
    private final String f6808a;
    private final Date b;
    private String c;
    private String d;
    private Date e;
    private String f;
    private String g;
    private String h;

    MraidCalendarEvent(String description, Date start) {
        this.f6808a = description;
        this.b = start;
    }

    void a(String location) {
        this.c = location;
    }

    void b(String recurrence) {
        this.h = recurrence;
    }

    void c(String status) {
        this.f = status;
    }

    void d(String summary) {
        this.d = summary;
    }

    void e(String transparency) {
        this.g = transparency;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MraidCalendarEvent)) {
            return false;
        }
        MraidCalendarEvent mraidCalendarEvent = (MraidCalendarEvent) o;
        return Objects.equals(this.f6808a, mraidCalendarEvent.f6808a) && Objects.equals(this.b, mraidCalendarEvent.b) && Objects.equals(this.c, mraidCalendarEvent.c) && Objects.equals(this.d, mraidCalendarEvent.d) && Objects.equals(this.e, mraidCalendarEvent.e) && Objects.equals(this.f, mraidCalendarEvent.f) && Objects.equals(this.g, mraidCalendarEvent.g) && Objects.equals(this.h, mraidCalendarEvent.h);
    }

    public String getDescription() {
        return this.f6808a;
    }

    public Date getEnd() {
        return this.e;
    }

    public String getLocation() {
        return this.c;
    }

    public String getRecurrence() {
        return this.h;
    }

    public Date getStart() {
        return this.b;
    }

    public String getStatus() {
        return this.f;
    }

    public String getSummary() {
        return this.d;
    }

    public String getTransparency() {
        return this.g;
    }

    public int hashCode() {
        return Objects.hash(this.f6808a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public String toString() {
        return "MraidCalendarEvent{description='" + this.f6808a + "', start=" + this.b + ", location='" + this.c + "', summary='" + this.d + "', end=" + this.e + ", status='" + this.f + "', transparency='" + this.g + "', recurrence='" + this.h + "'}";
    }

    void a(Date end) {
        this.e = end;
    }
}
