package io.bidmachine.iab.vast.tags;

import io.bidmachine.iab.vast.TrackingEvent;
import io.bidmachine.iab.vast.VastLog;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class LinearCreativeTag extends CreativeContentTag {
    private static final String[] i = {VastAttributes.SKIP_OFFSET};
    private Float c;
    private List<MediaFileTag> d;
    private VideoClicksTag e;
    private String f;
    private EnumMap<TrackingEvent, List<String>> g;
    private int h;

    LinearCreativeTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
        this.h = -1;
        xmlPullParser.require(2, null, "Linear");
        int e = VastXmlTag.e(a(VastAttributes.SKIP_OFFSET));
        if (e > -1) {
            a(e);
        }
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, "Duration")) {
                    float e2 = VastXmlTag.e(VastXmlTag.c(xmlPullParser));
                    if (e2 > -1.0f) {
                        setDurationSec(Float.valueOf(e2));
                    }
                } else if (VastXmlTag.a(name, "MediaFiles")) {
                    a(e(xmlPullParser));
                } else if (VastXmlTag.a(name, "VideoClicks")) {
                    a(new VideoClicksTag(xmlPullParser));
                } else if (VastXmlTag.a(name, "AdParameters")) {
                    setAdParameters(VastXmlTag.c(xmlPullParser));
                } else if (VastXmlTag.a(name, "TrackingEvents")) {
                    a(new TrackingEventsTag(xmlPullParser).a());
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "Linear");
    }

    private void a(List<MediaFileTag> mediaFileTagList) {
        this.d = mediaFileTagList;
    }

    private static List<MediaFileTag> e(XmlPullParser xmlPullParser) {
        xmlPullParser.require(2, null, "MediaFiles");
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (VastXmlTag.a(xmlPullParser.getName(), "MediaFile")) {
                    MediaFileTag mediaFileTag = new MediaFileTag(xmlPullParser);
                    if (mediaFileTag.isValidTag()) {
                        arrayList.add(mediaFileTag);
                    } else {
                        VastLog.d("VastXmlTag", "MediaFile: is not valid. Skipping it.", new Object[0]);
                        VastXmlTag.d(xmlPullParser);
                    }
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "MediaFiles");
        return arrayList;
    }

    public String getAdParameters() {
        return this.f;
    }

    public Float getDurationSec() {
        return this.c;
    }

    public List<MediaFileTag> getMediaFileTagList() {
        return this.d;
    }

    public int getSkipOffsetSec() {
        return this.h;
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return i;
    }

    public Map<TrackingEvent, List<String>> getTrackingEventListMap() {
        return this.g;
    }

    public VideoClicksTag getVideoClicksTag() {
        return this.e;
    }

    public void setAdParameters(String adParameters) {
        this.f = adParameters;
    }

    public void setDurationSec(Float durationSec) {
        this.c = durationSec;
    }

    private void a(VideoClicksTag videoClicksTag) {
        this.e = videoClicksTag;
    }

    private void a(EnumMap<TrackingEvent, List<String>> trackingEventListMap) {
        this.g = trackingEventListMap;
    }

    private void a(int skipOffsetSec) {
        this.h = skipOffsetSec;
    }
}
