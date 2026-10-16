package io.adn.sdk.internal.domain.model.ad;

import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.model.ad.AdLink;
import io.adn.sdk.internal.domain.model.ad.NativeAdAsset;
import io.adn.sdk.internal.thirdparty.omsdk.model.AdMeasurementVerificationResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdEntity.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BA\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003JM\u00102\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÇ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u00106\u001a\u000207H×\u0001J\t\u00108\u001a\u00020\bH×\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0013\u0010)\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0013\u0010+\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&¨\u00069"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "", "assets", "", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset;", "link", "Lio/adn/sdk/internal/domain/model/ad/AdLink$Native;", "impressionTrackers", "", "extra", "Lio/adn/sdk/internal/domain/model/ad/BidExtra;", "adMeasurementVerificationResources", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementVerificationResource;", "<init>", "(Ljava/util/List;Lio/adn/sdk/internal/domain/model/ad/AdLink$Native;Ljava/util/List;Lio/adn/sdk/internal/domain/model/ad/BidExtra;Ljava/util/List;)V", "getAssets", "()Ljava/util/List;", "getLink", "()Lio/adn/sdk/internal/domain/model/ad/AdLink$Native;", "getImpressionTrackers", "getExtra", "()Lio/adn/sdk/internal/domain/model/ad/BidExtra;", "getAdMeasurementVerificationResources", "mainMedia", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media;", "getMainMedia", "()Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media;", "title", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Title;", "getTitle", "()Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Title;", "icon", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Image;", "getIcon", "()Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Image;", "body", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Data;", "getBody", "()Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Data;", "cta", "getCta", "privacy", "getPrivacy", C3040d4.h.F0, "getAdvertiser", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class NativeAdEntity {
    public static final int $stable = 8;
    private final List<AdMeasurementVerificationResource> adMeasurementVerificationResources;
    private final NativeAdAsset.Data advertiser;
    private final List<NativeAdAsset> assets;
    private final NativeAdAsset.Data body;
    private final NativeAdAsset.Data cta;
    private final BidExtra extra;
    private final NativeAdAsset.Media.Image icon;
    private final List<String> impressionTrackers;
    private final AdLink.Native link;
    private final NativeAdAsset.Media mainMedia;
    private final NativeAdAsset.Data privacy;
    private final NativeAdAsset.Title title;

    public static /* synthetic */ NativeAdEntity copy$default(NativeAdEntity nativeAdEntity, List list, AdLink.Native r2, List list2, BidExtra bidExtra, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = nativeAdEntity.assets;
        }
        if ((i & 2) != 0) {
            r2 = nativeAdEntity.link;
        }
        if ((i & 4) != 0) {
            list2 = nativeAdEntity.impressionTrackers;
        }
        if ((i & 8) != 0) {
            bidExtra = nativeAdEntity.extra;
        }
        if ((i & 16) != 0) {
            list3 = nativeAdEntity.adMeasurementVerificationResources;
        }
        List list4 = list3;
        List list5 = list2;
        return nativeAdEntity.copy(list, r2, list5, bidExtra, list4);
    }

    public final List<NativeAdAsset> component1() {
        return this.assets;
    }

    /* renamed from: component2, reason: from getter */
    public final AdLink.Native getLink() {
        return this.link;
    }

    public final List<String> component3() {
        return this.impressionTrackers;
    }

    /* renamed from: component4, reason: from getter */
    public final BidExtra getExtra() {
        return this.extra;
    }

    public final List<AdMeasurementVerificationResource> component5() {
        return this.adMeasurementVerificationResources;
    }

    public final NativeAdEntity copy(List<? extends NativeAdAsset> assets, AdLink.Native link, List<String> impressionTrackers, BidExtra extra, List<AdMeasurementVerificationResource> adMeasurementVerificationResources) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(impressionTrackers, "impressionTrackers");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(adMeasurementVerificationResources, "adMeasurementVerificationResources");
        return new NativeAdEntity(assets, link, impressionTrackers, extra, adMeasurementVerificationResources);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeAdEntity)) {
            return false;
        }
        NativeAdEntity nativeAdEntity = (NativeAdEntity) other;
        return Intrinsics.areEqual(this.assets, nativeAdEntity.assets) && Intrinsics.areEqual(this.link, nativeAdEntity.link) && Intrinsics.areEqual(this.impressionTrackers, nativeAdEntity.impressionTrackers) && Intrinsics.areEqual(this.extra, nativeAdEntity.extra) && Intrinsics.areEqual(this.adMeasurementVerificationResources, nativeAdEntity.adMeasurementVerificationResources);
    }

    public int hashCode() {
        return (((((((this.assets.hashCode() * 31) + this.link.hashCode()) * 31) + this.impressionTrackers.hashCode()) * 31) + this.extra.hashCode()) * 31) + this.adMeasurementVerificationResources.hashCode();
    }

    public String toString() {
        return "NativeAdEntity(assets=" + this.assets + ", link=" + this.link + ", impressionTrackers=" + this.impressionTrackers + ", extra=" + this.extra + ", adMeasurementVerificationResources=" + this.adMeasurementVerificationResources + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NativeAdEntity(List<? extends NativeAdAsset> assets, AdLink.Native link, List<String> impressionTrackers, BidExtra extra, List<AdMeasurementVerificationResource> adMeasurementVerificationResources) {
        Object obj;
        Object obj2;
        Object obj3;
        NativeAdAsset.Media.Video video;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(impressionTrackers, "impressionTrackers");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(adMeasurementVerificationResources, "adMeasurementVerificationResources");
        this.assets = assets;
        this.link = link;
        this.impressionTrackers = impressionTrackers;
        this.extra = extra;
        this.adMeasurementVerificationResources = adMeasurementVerificationResources;
        List<NativeAdAsset> assets2 = getAssets();
        ArrayList arrayList = new ArrayList();
        for (Object obj9 : assets2) {
            if (obj9 instanceof NativeAdAsset.Media.Video) {
                arrayList.add(obj9);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (((NativeAdAsset) obj2).getId() == 5) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        NativeAdAsset.Media.Video video2 = (NativeAdAsset.Media.Video) ((NativeAdAsset) obj2);
        if (video2 != null) {
            video = video2;
        } else {
            List<NativeAdAsset> assets3 = getAssets();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj10 : assets3) {
                if (obj10 instanceof NativeAdAsset.Media.Image) {
                    arrayList2.add(obj10);
                }
            }
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj3 = it2.next();
                    if (((NativeAdAsset) obj3).getId() == 4) {
                        break;
                    }
                } else {
                    obj3 = null;
                    break;
                }
            }
            video = (NativeAdAsset.Media) ((NativeAdAsset) obj3);
        }
        this.mainMedia = video;
        List<NativeAdAsset> assets4 = getAssets();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj11 : assets4) {
            if (obj11 instanceof NativeAdAsset.Title) {
                arrayList3.add(obj11);
            }
        }
        Iterator it3 = arrayList3.iterator();
        while (true) {
            if (it3.hasNext()) {
                obj4 = it3.next();
                if (((NativeAdAsset) obj4).getId() == 1) {
                    break;
                }
            } else {
                obj4 = null;
                break;
            }
        }
        this.title = (NativeAdAsset.Title) ((NativeAdAsset) obj4);
        List<NativeAdAsset> assets5 = getAssets();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj12 : assets5) {
            if (obj12 instanceof NativeAdAsset.Media.Image) {
                arrayList4.add(obj12);
            }
        }
        Iterator it4 = arrayList4.iterator();
        while (true) {
            if (it4.hasNext()) {
                obj5 = it4.next();
                if (((NativeAdAsset) obj5).getId() == 2) {
                    break;
                }
            } else {
                obj5 = null;
                break;
            }
        }
        this.icon = (NativeAdAsset.Media.Image) ((NativeAdAsset) obj5);
        List<NativeAdAsset> assets6 = getAssets();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj13 : assets6) {
            if (obj13 instanceof NativeAdAsset.Data) {
                arrayList5.add(obj13);
            }
        }
        Iterator it5 = arrayList5.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj6 = it5.next();
                if (((NativeAdAsset) obj6).getId() == 3) {
                    break;
                }
            } else {
                obj6 = null;
                break;
            }
        }
        this.body = (NativeAdAsset.Data) ((NativeAdAsset) obj6);
        List<NativeAdAsset> assets7 = getAssets();
        ArrayList arrayList6 = new ArrayList();
        for (Object obj14 : assets7) {
            if (obj14 instanceof NativeAdAsset.Data) {
                arrayList6.add(obj14);
            }
        }
        Iterator it6 = arrayList6.iterator();
        while (true) {
            if (it6.hasNext()) {
                obj7 = it6.next();
                if (((NativeAdAsset) obj7).getId() == 6) {
                    break;
                }
            } else {
                obj7 = null;
                break;
            }
        }
        this.cta = (NativeAdAsset.Data) ((NativeAdAsset) obj7);
        List<NativeAdAsset> assets8 = getAssets();
        ArrayList arrayList7 = new ArrayList();
        for (Object obj15 : assets8) {
            if (obj15 instanceof NativeAdAsset.Data) {
                arrayList7.add(obj15);
            }
        }
        Iterator it7 = arrayList7.iterator();
        while (true) {
            if (it7.hasNext()) {
                obj8 = it7.next();
                if (((NativeAdAsset) obj8).getId() == 9) {
                    break;
                }
            } else {
                obj8 = null;
                break;
            }
        }
        this.privacy = (NativeAdAsset.Data) ((NativeAdAsset) obj8);
        List<NativeAdAsset> assets9 = getAssets();
        ArrayList arrayList8 = new ArrayList();
        for (Object obj16 : assets9) {
            if (obj16 instanceof NativeAdAsset.Data) {
                arrayList8.add(obj16);
            }
        }
        Iterator it8 = arrayList8.iterator();
        while (true) {
            if (!it8.hasNext()) {
                break;
            }
            Object next = it8.next();
            if (((NativeAdAsset) next).getId() == 7) {
                obj = next;
                break;
            }
        }
        this.advertiser = (NativeAdAsset.Data) ((NativeAdAsset) obj);
    }

    public final List<NativeAdAsset> getAssets() {
        return this.assets;
    }

    public final AdLink.Native getLink() {
        return this.link;
    }

    public final List<String> getImpressionTrackers() {
        return this.impressionTrackers;
    }

    public final BidExtra getExtra() {
        return this.extra;
    }

    public final List<AdMeasurementVerificationResource> getAdMeasurementVerificationResources() {
        return this.adMeasurementVerificationResources;
    }

    public final NativeAdAsset.Media getMainMedia() {
        return this.mainMedia;
    }

    public final NativeAdAsset.Title getTitle() {
        return this.title;
    }

    public final NativeAdAsset.Media.Image getIcon() {
        return this.icon;
    }

    public final NativeAdAsset.Data getBody() {
        return this.body;
    }

    public final NativeAdAsset.Data getCta() {
        return this.cta;
    }

    public final NativeAdAsset.Data getPrivacy() {
        return this.privacy;
    }

    public final NativeAdAsset.Data getAdvertiser() {
        return this.advertiser;
    }
}
