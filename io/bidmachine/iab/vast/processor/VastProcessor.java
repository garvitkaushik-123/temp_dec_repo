package io.bidmachine.iab.vast.processor;

import android.text.TextUtils;
import android.util.Pair;
import io.bidmachine.iab.vast.TrackingEvent;
import io.bidmachine.iab.vast.VastLog;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VastSpecError;
import io.bidmachine.iab.vast.tags.AdContentTag;
import io.bidmachine.iab.vast.tags.AdTag;
import io.bidmachine.iab.vast.tags.AdVerificationsExtensionTag;
import io.bidmachine.iab.vast.tags.AppodealExtensionTag;
import io.bidmachine.iab.vast.tags.CompanionAdsCreativeTag;
import io.bidmachine.iab.vast.tags.CompanionTag;
import io.bidmachine.iab.vast.tags.CreativeContentTag;
import io.bidmachine.iab.vast.tags.CreativeTag;
import io.bidmachine.iab.vast.tags.ExtensionTag;
import io.bidmachine.iab.vast.tags.InLineAdTag;
import io.bidmachine.iab.vast.tags.LinearCreativeTag;
import io.bidmachine.iab.vast.tags.MediaFileTag;
import io.bidmachine.iab.vast.tags.VastParser;
import io.bidmachine.iab.vast.tags.VastTag;
import io.bidmachine.iab.vast.tags.VideoClicksTag;
import io.bidmachine.iab.vast.tags.WrapperAdTag;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes7.dex */
public class VastProcessor {

    /* renamed from: a, reason: collision with root package name */
    private final VastRequest f6922a;
    private final VastMediaPicker<MediaFileTag> b;
    final int c;
    final Stack<AdContentTag> d;
    private int e;

    public VastProcessor(VastRequest vastRequest, VastMediaPicker<MediaFileTag> mediaPicker) {
        this(vastRequest, mediaPicker, 5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b8, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private VastProcessorResult a(AdContentTag parentAdContent, VastTag vastTag, a wrapperAttributes) {
        VastProcessorResult vastProcessorResult = new VastProcessorResult();
        int i = 0;
        while (true) {
            if (i < vastTag.getAdTagList().size()) {
                AdTag adTag = vastTag.getAdTagList().get(i);
                if (adTag != null && adTag.getAdContentTag() != null) {
                    AdContentTag adContentTag = adTag.getAdContentTag();
                    if (!(adContentTag instanceof InLineAdTag)) {
                        if ((adContentTag instanceof WrapperAdTag) && wrapperAttributes.c()) {
                            VastProcessorResult a2 = a((WrapperAdTag) adContentTag);
                            if (!a2.hasVastAd()) {
                                a(a2.a());
                                if (parentAdContent == null) {
                                    vastProcessorResult.a(VastSpecError.WRAPPER_RESPONSE_NO_AD);
                                } else if (a2.b()) {
                                    VastSpecError vastSpecError = a2.getVastSpecError();
                                    if (vastSpecError == null) {
                                        vastSpecError = VastSpecError.UNKNOWN;
                                    }
                                    vastProcessorResult.a(parentAdContent, vastSpecError);
                                } else {
                                    vastProcessorResult.a(parentAdContent, VastSpecError.WRAPPER_RESPONSE_NO_AD);
                                }
                                if (i == 0 && !wrapperAttributes.b()) {
                                    break;
                                }
                            } else {
                                return a2;
                            }
                        }
                    } else {
                        VastProcessorResult b = b((InLineAdTag) adContentTag);
                        if (b.hasVastAd()) {
                            return b;
                        }
                        a(b.a());
                        if (parentAdContent == null) {
                            vastProcessorResult.a(b.getVastSpecError());
                        } else if (b.b()) {
                            VastSpecError vastSpecError2 = b.getVastSpecError();
                            if (vastSpecError2 == null) {
                                vastSpecError2 = VastSpecError.UNKNOWN;
                            }
                            vastProcessorResult.a(parentAdContent, vastSpecError2);
                        }
                    }
                    b(adContentTag);
                }
                i++;
            } else if (vastProcessorResult.getVastSpecError() == null && parentAdContent != null) {
                vastProcessorResult.a(parentAdContent, VastSpecError.WRAPPER_RESPONSE_NO_AD);
            }
        }
    }

    private VastProcessorResult b(InLineAdTag inLineAd) {
        this.d.push(inLineAd);
        VastProcessorResult vastProcessorResult = new VastProcessorResult();
        Pair<LinearCreativeTag, MediaFileTag> a2 = a(inLineAd);
        if (a2 == null) {
            vastProcessorResult.a(inLineAd, VastSpecError.XML_VALIDATE);
            return vastProcessorResult;
        }
        if (a2.first == null && a2.second == null) {
            vastProcessorResult.a(inLineAd, VastSpecError.BAD_FILE);
            return vastProcessorResult;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        EnumMap<TrackingEvent, List<String>> enumMap = new EnumMap<>((Class<TrackingEvent>) TrackingEvent.class);
        ArrayList arrayList4 = new ArrayList();
        AppodealExtensionTag appodealExtensionTag = null;
        if (!this.d.empty()) {
            Iterator<AdContentTag> it = this.d.iterator();
            while (it.hasNext()) {
                AdContentTag next = it.next();
                if (next != null) {
                    if (next.getImpressionUrlList() != null) {
                        arrayList.addAll(next.getImpressionUrlList());
                    }
                    List<CreativeTag> creativeTagList = next.getCreativeTagList();
                    if (creativeTagList != null) {
                        for (CreativeTag creativeTag : creativeTagList) {
                            if (creativeTag != null) {
                                CreativeContentTag creativeContentTag = creativeTag.getCreativeContentTag();
                                if (creativeContentTag instanceof LinearCreativeTag) {
                                    LinearCreativeTag linearCreativeTag = (LinearCreativeTag) creativeContentTag;
                                    VideoClicksTag videoClicksTag = linearCreativeTag.getVideoClicksTag();
                                    if (videoClicksTag != null && videoClicksTag.getClickTrackingUrlList() != null) {
                                        arrayList2.addAll(videoClicksTag.getClickTrackingUrlList());
                                    }
                                    a(enumMap, linearCreativeTag.getTrackingEventListMap());
                                } else if (creativeContentTag instanceof CompanionAdsCreativeTag) {
                                    a(arrayList3, (CompanionAdsCreativeTag) creativeContentTag);
                                }
                            }
                        }
                    }
                    List<ExtensionTag> extensionTagList = next.getExtensionTagList();
                    if (extensionTagList != null) {
                        for (ExtensionTag extensionTag : extensionTagList) {
                            if (extensionTag instanceof AppodealExtensionTag) {
                                if (appodealExtensionTag == null) {
                                    appodealExtensionTag = (AppodealExtensionTag) extensionTag;
                                }
                            } else if (extensionTag instanceof AdVerificationsExtensionTag) {
                                arrayList4.add((AdVerificationsExtensionTag) extensionTag);
                            }
                        }
                    }
                }
            }
        }
        VastAd vastAd = new VastAd((LinearCreativeTag) a2.first, (MediaFileTag) a2.second);
        vastAd.d(arrayList);
        vastAd.c(a());
        vastAd.a(arrayList2);
        vastAd.setWrapperCompanionClickTrackingUrlList(arrayList3);
        vastAd.a(enumMap);
        vastAd.b(a((AdContentTag) inLineAd));
        vastAd.a(appodealExtensionTag);
        vastAd.setAdVerificationsExtensionList(arrayList4);
        vastProcessorResult.a(vastAd);
        return vastProcessorResult;
    }

    public VastProcessorResult process(String xmlData) {
        VastLog.d("VastProcessor", "process", new Object[0]);
        VastProcessorResult vastProcessorResult = new VastProcessorResult();
        try {
            VastTag parseVast = VastParser.parseVast(xmlData);
            if (parseVast != null && parseVast.hasAd()) {
                return a(null, parseVast, new a());
            }
            vastProcessorResult.a(VastSpecError.XML_VALIDATE);
            return vastProcessorResult;
        } catch (Exception unused) {
            vastProcessorResult.a(VastSpecError.XML_PARSING);
            return vastProcessorResult;
        }
    }

    VastProcessor(VastRequest vastRequest, VastMediaPicker<MediaFileTag> mediaPicker, int maxProcessingWrapper) {
        this.e = 0;
        this.f6922a = vastRequest;
        this.b = mediaPicker;
        this.c = maxProcessingWrapper;
        this.d = new Stack<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    VastProcessorResult a(WrapperAdTag wrapperAd) {
        URLConnection openConnection;
        int responseCode;
        VastProcessorResult vastProcessorResult = new VastProcessorResult();
        if (b()) {
            VastLog.e("VastProcessor", "VAST wrapping exceeded max limit of %d", Integer.valueOf(this.c));
            vastProcessorResult.a(wrapperAd, VastSpecError.EXCEEDED_WRAPPER_LIMIT);
            return vastProcessorResult;
        }
        this.e++;
        this.d.push(wrapperAd);
        if (TextUtils.isEmpty(wrapperAd.getVastAdTagUri())) {
            VastLog.e("VastProcessor", "VASTAdTagURI is null or empty", new Object[0]);
            vastProcessorResult.a(wrapperAd, VastSpecError.BAD_URI);
            return vastProcessorResult;
        }
        a aVar = new a(wrapperAd);
        InputStream inputStream = null;
        try {
            try {
                try {
                    try {
                        openConnection = new URL(wrapperAd.getVastAdTagUri()).openConnection();
                        responseCode = ((HttpURLConnection) openConnection).getResponseCode();
                    } catch (Throwable th) {
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Exception e) {
                                VastLog.e("VastProcessor", e);
                            }
                        }
                        throw th;
                    }
                } catch (UnknownHostException e2) {
                    e = e2;
                    VastLog.e("VastProcessor", e);
                    vastProcessorResult.a(wrapperAd, VastSpecError.BAD_URI);
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                            VastLog.e("VastProcessor", e3);
                        }
                    }
                } catch (Exception e4) {
                    VastLog.e("VastProcessor", e4);
                    vastProcessorResult.a(wrapperAd, VastSpecError.XML_PARSING);
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                            VastLog.e("VastProcessor", e5);
                        }
                    }
                }
            } catch (ConnectTimeoutException e6) {
                e = e6;
                VastLog.e("VastProcessor", e);
                vastProcessorResult.a(wrapperAd, VastSpecError.BAD_URI);
                if (0 != 0) {
                }
            } catch (IOException e7) {
                VastLog.e("VastProcessor", e7);
                vastProcessorResult.a(wrapperAd, VastSpecError.BAD_URI);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e8) {
                        VastLog.e("VastProcessor", e8);
                    }
                }
            }
        } catch (MalformedURLException e9) {
            VastLog.e("VastProcessor", e9);
            vastProcessorResult.a(wrapperAd, VastSpecError.BAD_URI);
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Exception e10) {
                    VastLog.e("VastProcessor", e10);
                }
            }
        } catch (SocketTimeoutException e11) {
            e = e11;
            VastLog.e("VastProcessor", e);
            vastProcessorResult.a(wrapperAd, VastSpecError.BAD_URI);
            if (0 != 0) {
            }
        } catch (SSLException e12) {
            e = e12;
            VastLog.e("VastProcessor", e);
            vastProcessorResult.a(wrapperAd, VastSpecError.BAD_URI);
            if (0 != 0) {
            }
        }
        if (responseCode != 200) {
            if (responseCode != 204) {
                vastProcessorResult.a(wrapperAd, VastSpecError.BAD_URI);
                return vastProcessorResult;
            }
            VastLog.e("VastProcessor", "Wrapper response code: 204", new Object[0]);
            vastProcessorResult.a(wrapperAd, VastSpecError.WRAPPER_RESPONSE_NO_AD);
            return vastProcessorResult;
        }
        InputStream inputStream2 = openConnection.getInputStream();
        VastTag parseVast = VastParser.parseVast(inputStream2);
        if (parseVast == null) {
            VastLog.e("VastProcessor", "Invalid Vast", new Object[0]);
            vastProcessorResult.a(wrapperAd, VastSpecError.XML_VALIDATE);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                    return vastProcessorResult;
                } catch (Exception e13) {
                    VastLog.e("VastProcessor", e13);
                }
            }
        } else if (!parseVast.hasAd()) {
            VastLog.e("VastProcessor", "Vast has no ad", new Object[0]);
            vastProcessorResult.a(wrapperAd, VastSpecError.WRAPPER_RESPONSE_NO_AD);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                    return vastProcessorResult;
                } catch (Exception e14) {
                    VastLog.e("VastProcessor", e14);
                }
            }
        } else if (parseVast.getAdTagList().size() > 1 && !aVar.a()) {
            vastProcessorResult.a(wrapperAd, VastSpecError.GENERAL_WRAPPER);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                    return vastProcessorResult;
                } catch (Exception e15) {
                    VastLog.e("VastProcessor", e15);
                }
            }
        } else {
            VastProcessorResult a2 = a(wrapperAd, parseVast, aVar);
            a2.a(false);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                    return a2;
                } catch (Exception e16) {
                    VastLog.e("VastProcessor", e16);
                }
            }
            return a2;
        }
        return vastProcessorResult;
    }

    private boolean b() {
        return this.e >= this.c;
    }

    void b(AdContentTag adContentTag) {
        if (this.d.empty()) {
            return;
        }
        int search = this.d.search(adContentTag);
        for (int i = 0; i < search; i++) {
            this.d.pop();
        }
    }

    private ArrayList<CompanionTag> a(AdContentTag adContentTag) {
        ArrayList<CompanionTag> arrayList = new ArrayList<>();
        List<CreativeTag> creativeTagList = adContentTag.getCreativeTagList();
        if (creativeTagList != null) {
            for (CreativeTag creativeTag : creativeTagList) {
                if (creativeTag != null) {
                    CreativeContentTag creativeContentTag = creativeTag.getCreativeContentTag();
                    if (creativeContentTag instanceof CompanionAdsCreativeTag) {
                        arrayList.addAll(((CompanionAdsCreativeTag) creativeContentTag).getCompanionTagList());
                    }
                }
            }
        }
        return arrayList;
    }

    private ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!this.d.empty()) {
            Iterator<AdContentTag> it = this.d.iterator();
            while (it.hasNext()) {
                AdContentTag next = it.next();
                if (next != null && next.getErrorUrlList() != null) {
                    arrayList.addAll(next.getErrorUrlList());
                }
            }
        }
        return arrayList;
    }

    private Pair<LinearCreativeTag, MediaFileTag> a(InLineAdTag inLineAd) {
        LinearCreativeTag linearCreativeTag;
        List<MediaFileTag> mediaFileTagList;
        List<CreativeTag> creativeTagList = inLineAd.getCreativeTagList();
        if (creativeTagList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CreativeTag creativeTag : creativeTagList) {
            if (creativeTag != null) {
                CreativeContentTag creativeContentTag = creativeTag.getCreativeContentTag();
                if ((creativeContentTag instanceof LinearCreativeTag) && (mediaFileTagList = (linearCreativeTag = (LinearCreativeTag) creativeContentTag).getMediaFileTagList()) != null && !mediaFileTagList.isEmpty()) {
                    Iterator<MediaFileTag> it = mediaFileTagList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new Pair(linearCreativeTag, it.next()));
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Pair<LinearCreativeTag, MediaFileTag> pickVideo = this.b.pickVideo(arrayList);
        return pickVideo != null ? pickVideo : new Pair<>(null, null);
    }

    private void a(Map<TrackingEvent, List<String>> mutableTrackingEventMap, Map<TrackingEvent, List<String>> trackingEventMap) {
        if (trackingEventMap == null || trackingEventMap.isEmpty()) {
            return;
        }
        for (Map.Entry<TrackingEvent, List<String>> entry : trackingEventMap.entrySet()) {
            TrackingEvent key = entry.getKey();
            List<String> list = mutableTrackingEventMap.get(key);
            if (list == null) {
                list = new ArrayList<>();
                mutableTrackingEventMap.put(key, list);
            }
            list.addAll(entry.getValue());
        }
    }

    private void a(List<String> wrapperClickTrackingUrlList, CompanionAdsCreativeTag companionAdsCreativeTag) {
        List<String> companionClickTrackingList;
        for (CompanionTag companionTag : companionAdsCreativeTag.getCompanionTagList()) {
            if (!companionTag.hasCreative() && (companionClickTrackingList = companionTag.getCompanionClickTrackingList()) != null) {
                wrapperClickTrackingUrlList.addAll(companionClickTrackingList);
            }
        }
    }

    void a(List<String> errorUrlList) {
        this.f6922a.fireErrorUrls(errorUrlList, null);
    }
}
