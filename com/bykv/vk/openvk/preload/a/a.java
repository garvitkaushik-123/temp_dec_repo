package com.bykv.vk.openvk.preload.a;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: DefaultDateTypeAdapter.java */
/* loaded from: classes3.dex */
final class a extends r<Date> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<? extends Date> f853a;
    private final List<DateFormat> b;

    @Override // com.bykv.vk.openvk.preload.a.r
    public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Date date) throws IOException {
        Date date2 = date;
        if (date2 == null) {
            cVar.h();
            return;
        }
        synchronized (this.b) {
            cVar.b(this.b.get(0).format(date2));
        }
    }

    a(Class<? extends Date> cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.f853a = a(cls);
        arrayList.add(new SimpleDateFormat(str, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    public a(Class<? extends Date> cls, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.f853a = a(cls);
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (com.bykv.vk.openvk.preload.a.b.d.b()) {
            arrayList.add(com.bykv.vk.openvk.preload.falconx.a.a.a(i, i2));
        }
    }

    private static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    private Date a(String str) {
        synchronized (this.b) {
            Iterator<DateFormat> it = this.b.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(str);
                } catch (ParseException unused) {
                }
            }
            try {
                return com.bykv.vk.openvk.preload.a.b.a.a.a.a(str, new ParsePosition(0));
            } catch (ParseException e) {
                throw new p(str, e);
            }
        }
    }

    public final String toString() {
        DateFormat dateFormat = this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final /* synthetic */ Date a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
            aVar.j();
            return null;
        }
        Date a2 = a(aVar.h());
        Class<? extends Date> cls = this.f853a;
        if (cls == Date.class) {
            return a2;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(a2.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(a2.getTime());
        }
        throw new AssertionError();
    }
}
