package io.bidmachine.iab.vast.processor;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.vast.TrackingEvent;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VastSpecError;
import io.bidmachine.iab.vast.tags.AdVerificationsExtensionTag;
import io.bidmachine.iab.vast.tags.AppodealExtensionTag;
import io.bidmachine.iab.vast.tags.CompanionTag;
import io.bidmachine.iab.vast.tags.LinearCreativeTag;
import io.bidmachine.iab.vast.tags.MediaFileTag;
import io.bidmachine.iab.vast.tags.VideoClicksTag;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public class VastAd implements Parcelable {
    public static final Parcelable.Creator<VastAd> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final LinearCreativeTag f6921a;
    private final MediaFileTag b;
    private VastRequest c;
    private ArrayList<CompanionTag> d;
    private ArrayList<String> e;
    private ArrayList<String> f;
    private ArrayList<String> g;
    private ArrayList<String> h;
    private EnumMap<TrackingEvent, List<String>> i;
    private AppodealExtensionTag j;
    private List<AdVerificationsExtensionTag> k = new ArrayList();

    class a implements Parcelable.Creator<VastAd> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VastAd createFromParcel(Parcel in) {
            return new VastAd(in);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VastAd[] newArray(int size) {
            return new VastAd[size];
        }
    }

    VastAd(LinearCreativeTag linearCreativeTag, MediaFileTag pickedMediaFileTag) {
        this.f6921a = linearCreativeTag;
        this.b = pickedMediaFileTag;
    }

    void a(ArrayList<String> clickTrackingUrlList) {
        this.g = clickTrackingUrlList;
    }

    void b(ArrayList<CompanionTag> companionTagList) {
        this.d = companionTagList;
    }

    void c(ArrayList<String> errorUrlList) {
        this.f = errorUrlList;
    }

    void d(ArrayList<String> impressionUrlList) {
        this.e = impressionUrlList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdParameters() {
        return this.f6921a.getAdParameters();
    }

    public List<AdVerificationsExtensionTag> getAdVerificationsExtensionList() {
        return this.k;
    }

    public AppodealExtensionTag getAppodealExtension() {
        return this.j;
    }

    public CompanionTag getBanner(Context context) {
        ArrayList<CompanionTag> arrayList = this.d;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<CompanionTag> it = this.d.iterator();
            while (it.hasNext()) {
                CompanionTag next = it.next();
                int width = next.getWidth();
                int height = next.getHeight();
                if (width > -1 && height > -1 && ((Utils.isTablet(context) && width == 728 && height == 90) || (!Utils.isTablet(context) && width == 320 && height == 50))) {
                    return next;
                }
            }
        }
        return null;
    }

    public String getClickThroughUrl() {
        VideoClicksTag videoClicksTag = this.f6921a.getVideoClicksTag();
        if (videoClicksTag != null) {
            return videoClicksTag.getClickThroughUrl();
        }
        return null;
    }

    public List<String> getClickTrackingUrlList() {
        return this.g;
    }

    public CompanionTag getCompanion(int targetWidth, int targetHeight) {
        ArrayList<CompanionTag> arrayList = this.d;
        if (arrayList != null && !arrayList.isEmpty()) {
            HashMap hashMap = new HashMap();
            Iterator<CompanionTag> it = this.d.iterator();
            while (it.hasNext()) {
                CompanionTag next = it.next();
                int width = next.getWidth();
                int height = next.getHeight();
                if (width > -1 && height > -1) {
                    float max = Math.max(width, height) / Math.min(width, height);
                    if (Math.min(width, height) >= 250 && max <= 2.5d && next.hasCreative()) {
                        hashMap.put(Float.valueOf(width / height), next);
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                float f = targetWidth / targetHeight;
                Set keySet = hashMap.keySet();
                float floatValue = ((Float) keySet.iterator().next()).floatValue();
                Iterator it2 = keySet.iterator();
                while (it2.hasNext()) {
                    float floatValue2 = ((Float) it2.next()).floatValue();
                    if (Math.abs(floatValue - f) > Math.abs(floatValue2 - f)) {
                        floatValue = floatValue2;
                    }
                }
                return (CompanionTag) hashMap.get(Float.valueOf(floatValue));
            }
            a(VastSpecError.GENERAL_COMPANION);
        }
        return null;
    }

    public Float getDurationSec() {
        return this.f6921a.getDurationSec();
    }

    public List<String> getErrorUrlList() {
        return this.f;
    }

    public List<String> getImpressionUrlList() {
        return this.e;
    }

    public MediaFileTag getPickedMediaFileTag() {
        return this.b;
    }

    public int getSkipOffsetSec() {
        return this.f6921a.getSkipOffsetSec();
    }

    public Map<TrackingEvent, List<String>> getTrackingEventListMap() {
        return this.i;
    }

    public ArrayList<String> getWrapperCompanionClickTrackingUrlList() {
        return this.h;
    }

    public void setAdVerificationsExtensionList(List<AdVerificationsExtensionTag> adVerificationsExtensionTagList) {
        this.k = adVerificationsExtensionTagList;
    }

    public void setVastRequest(VastRequest vastRequest) {
        this.c = vastRequest;
    }

    public void setWrapperCompanionClickTrackingUrlList(ArrayList<String> wrapperCompanionClickTrackingUrlList) {
        this.h = wrapperCompanionClickTrackingUrlList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.f6921a);
        dest.writeSerializable(this.b);
        dest.writeSerializable(this.d);
        dest.writeStringList(this.e);
        dest.writeStringList(this.f);
        dest.writeStringList(this.g);
        dest.writeStringList(this.h);
        dest.writeSerializable(this.i);
        dest.writeSerializable(this.j);
        dest.writeList(this.k);
    }

    void a(EnumMap<TrackingEvent, List<String>> trackingEventListMap) {
        this.i = trackingEventListMap;
    }

    void a(AppodealExtensionTag appodealExtension) {
        this.j = appodealExtension;
    }

    void a(VastSpecError vastSpecError) {
        VastRequest vastRequest = this.c;
        if (vastRequest != null) {
            vastRequest.sendVastSpecError(vastSpecError);
        }
    }

    protected VastAd(Parcel in) {
        this.f6921a = (LinearCreativeTag) in.readSerializable();
        this.b = (MediaFileTag) in.readSerializable();
        this.d = (ArrayList) in.readSerializable();
        this.e = in.createStringArrayList();
        this.f = in.createStringArrayList();
        this.g = in.createStringArrayList();
        this.h = in.createStringArrayList();
        this.i = (EnumMap) in.readSerializable();
        this.j = (AppodealExtensionTag) in.readSerializable();
        in.readList(this.k, AdVerificationsExtensionTag.class.getClassLoader());
    }
}
