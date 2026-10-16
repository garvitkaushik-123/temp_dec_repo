package com.mbridge.msdk.foundation.same.report;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class BatchReportMessage implements Parcelable {
    public static final Parcelable.Creator<BatchReportMessage> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f4309a;
    private long b;
    private String c;

    class a implements Parcelable.Creator<BatchReportMessage> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BatchReportMessage createFromParcel(Parcel parcel) {
            return new BatchReportMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BatchReportMessage[] newArray(int i) {
            return new BatchReportMessage[i];
        }
    }

    public BatchReportMessage(String str, String str2, long j) {
        this.c = str;
        this.f4309a = str2;
        this.b = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getReportMessage() {
        return this.f4309a;
    }

    public long getTimestamp() {
        return this.b;
    }

    public String getUuid() {
        return this.c;
    }

    public void setReportMessage(String str) {
        this.f4309a = str;
    }

    public void setTimestamp(long j) {
        this.b = j;
    }

    public void setUuid(String str) {
        this.c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.f4309a);
        parcel.writeLong(this.b);
    }

    protected BatchReportMessage(Parcel parcel) {
        this.c = parcel.readString();
        this.f4309a = parcel.readString();
        this.b = parcel.readLong();
    }
}
