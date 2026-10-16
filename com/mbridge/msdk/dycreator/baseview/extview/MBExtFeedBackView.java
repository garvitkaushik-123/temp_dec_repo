package com.mbridge.msdk.dycreator.baseview.extview;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.engine.b;
import com.mbridge.msdk.dycreator.engine.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class MBExtFeedBackView extends FeedBackButton implements InterBase {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f4113a;
    private Map<String, Boolean> b;
    private String c;

    /* renamed from: com.mbridge.msdk.dycreator.baseview.extview.MBExtFeedBackView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4114a;

        static {
            int[] iArr = new int[c.values().length];
            f4114a = iArr;
            try {
                iArr[c.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4114a[c.text.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4114a[c.ellipsize.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4114a[c.singleLine.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4114a[c.lines.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4114a[c.drawableLeft.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4114a[c.drawablePadding.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4114a[c.fadingEdge.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4114a[c.scrollHorizontally.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4114a[c.textColor.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4114a[c.textSize.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4114a[c.visibility.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4114a[c.background.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4114a[c.textStyle.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f4114a[c.style.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f4114a[c.contentDescription.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f4114a[c.tag.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f4114a[c.gravity.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f4114a[c.padding.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f4114a[c.paddingTop.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f4114a[c.paddingBottom.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f4114a[c.paddingLeft.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f4114a[c.paddingRight.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f4114a[c.paddingStart.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f4114a[c.paddingEnd.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f4114a[c.layout_width.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f4114a[c.layout_height.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    public MBExtFeedBackView(Context context) {
        super(context);
        this.c = "";
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        HashMap b = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            c cVar = (c) b.get(attributeSet.getAttributeName(i));
            if (cVar != null) {
                int i2 = AnonymousClass1.f4114a[cVar.ordinal()];
                if (i2 == 26) {
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (attributeValue.startsWith(InneractiveMediationDefs.GENDER_FEMALE) || attributeValue.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue.startsWith("wrap")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().a(attributeValue);
                    }
                } else if (i2 == 27) {
                    String attributeValue2 = attributeSet.getAttributeValue(i);
                    if (attributeValue2.startsWith(InneractiveMediationDefs.GENDER_FEMALE) || attributeValue2.startsWith("m")) {
                        layoutParams.height = -1;
                    } else if (attributeValue2.startsWith("wrap")) {
                        layoutParams.height = -2;
                    } else {
                        layoutParams.height = b.a().a(attributeValue2);
                    }
                }
            }
        }
        return layoutParams;
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.f4113a;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.f4113a.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.f4113a;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.f4113a.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.f4113a;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.f4113a.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.f4113a;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.f4113a.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.f4113a;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.f4113a.get("mbridgeStrategy");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.b;
        if (map != null && map.containsKey("mbridgeAttached") && this.b.get("mbridgeAttached").booleanValue()) {
            new l.b("mbridgeAttached").a().b(this.c);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.b;
        if (map != null && map.containsKey("mbridgeDetached") && this.b.get("mbridgeDetached").booleanValue()) {
            new l.b("mbridgeDetached").a().b(this.c);
        }
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        HashMap<String, c> c = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < attributeCount; i5++) {
            c cVar = c.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                Log.d("setupview", cVar.toString());
                switch (AnonymousClass1.f4114a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i5);
                        if (attributeValue.startsWith("@+id/")) {
                            setId(attributeValue.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        String attributeValue2 = attributeSet.getAttributeValue(i5);
                        if (TextUtils.isEmpty(attributeValue2)) {
                            break;
                        } else if (attributeValue2.startsWith("@string/")) {
                            setText(b.a().f(attributeSet.getAttributeValue(i5)));
                            break;
                        } else {
                            setText(attributeValue2);
                            break;
                        }
                    case 3:
                        String attributeValue3 = attributeSet.getAttributeValue(i5);
                        if (TextUtils.isEmpty(attributeValue3)) {
                            break;
                        } else {
                            if (attributeValue3.equals("end")) {
                                setEllipsize(TextUtils.TruncateAt.END);
                            }
                            if (attributeValue3.equals("start")) {
                                setEllipsize(TextUtils.TruncateAt.START);
                            }
                            if (attributeValue3.equals("middle")) {
                                setEllipsize(TextUtils.TruncateAt.MIDDLE);
                            }
                            if (attributeValue3.equals("marquee")) {
                                setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                break;
                            } else {
                                break;
                            }
                        }
                    case 4:
                        setSingleLine(attributeSet.getAttributeBooleanValue(i5, false));
                        break;
                    case 5:
                        setLines(attributeSet.getAttributeIntValue(i5, 1));
                        break;
                    case 6:
                        String attributeValue4 = attributeSet.getAttributeValue(i5);
                        String substring = attributeValue4.startsWith("@drawable/") ? attributeValue4.substring(10) : "";
                        if (TextUtils.isEmpty(substring)) {
                            break;
                        } else {
                            Drawable drawable = getResources().getDrawable(h0.a(com.mbridge.msdk.foundation.controller.c.m().d(), substring, "drawable"));
                            drawable.setBounds(0, 0, u0.a(getContext(), 14.0f), u0.a(getContext(), 14.0f));
                            setCompoundDrawables(drawable, null, null, null);
                            break;
                        }
                    case 7:
                        setCompoundDrawablePadding(b.a().a(attributeSet.getAttributeValue(i5)));
                        break;
                    case 8:
                        setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i5, false));
                        break;
                    case 9:
                        setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i5, false));
                        break;
                    case 10:
                        setTextColor(b.a().d(attributeSet.getAttributeValue(i5)));
                        break;
                    case 11:
                        if (TextUtils.isEmpty(attributeSet.getAttributeValue(i5))) {
                            break;
                        } else {
                            setTextSize(b.a().a(r8));
                            break;
                        }
                    case 12:
                        String attributeValue5 = attributeSet.getAttributeValue(i5);
                        if (TextUtils.isEmpty(attributeValue5)) {
                            break;
                        } else if (attributeValue5.equals("invisible")) {
                            setVisibility(4);
                            break;
                        } else if (attributeValue5.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        String attributeValue6 = attributeSet.getAttributeValue(i5);
                        if (attributeValue6.startsWith("#")) {
                            setBackgroundColor(b.a().d(attributeSet.getAttributeValue(i5)));
                            break;
                        } else {
                            if (attributeValue6.startsWith("@drawable/")) {
                                attributeValue6 = attributeValue6.substring(10);
                            }
                            setBackgroundResource(getResources().getIdentifier(attributeValue6, "drawable", getContext().getPackageName()));
                            break;
                        }
                    case 14:
                        if ("bold".equalsIgnoreCase(attributeSet.getAttributeValue(i5))) {
                            setTypeface(Typeface.defaultFromStyle(1));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        String attributeValue7 = attributeSet.getAttributeValue(i5);
                        setTextAppearance(getContext(), b.a().c("R.style." + attributeValue7.substring(attributeValue7.indexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1)));
                        break;
                    case 16:
                        String attributeValue8 = attributeSet.getAttributeValue(i5);
                        if (TextUtils.isEmpty(attributeValue8)) {
                            break;
                        } else {
                            CharSequence charSequence = (String) com.mbridge.msdk.dycreator.utils.b.f4177a.get(attributeValue8.substring(8));
                            if (TextUtils.isEmpty(charSequence)) {
                                break;
                            } else {
                                setContentDescription(charSequence);
                                break;
                            }
                        }
                    case 17:
                        String attributeValue9 = attributeSet.getAttributeValue(i5);
                        if (TextUtils.isEmpty(attributeValue9)) {
                            break;
                        } else {
                            String str = com.mbridge.msdk.dycreator.utils.b.f4177a.get(attributeValue9.substring(8));
                            if (TextUtils.isEmpty(str)) {
                                break;
                            } else {
                                setTag(str);
                                break;
                            }
                        }
                    case 18:
                        setGravity(b.a().b(attributeSet.getAttributeValue(i5)));
                        break;
                    case 19:
                        int a2 = b.a().a(attributeSet.getAttributeValue(i5));
                        setPadding(a2, a2, a2, a2);
                        break;
                    case 20:
                        i4 = b.a().a(attributeSet.getAttributeValue(i5));
                        setPadding(i, i4, i2, i3);
                        break;
                    case 21:
                        i3 = b.a().a(attributeSet.getAttributeValue(i5));
                        setPadding(i, i4, i2, i3);
                        break;
                    case 22:
                        i = b.a().a(attributeSet.getAttributeValue(i5));
                        setPadding(i, i4, i2, i3);
                        break;
                    case 23:
                        i2 = b.a().a(attributeSet.getAttributeValue(i5));
                        setPadding(i, i4, i2, i3);
                        break;
                    case 24:
                        setPadding(b.a().a(attributeSet.getAttributeValue(i5)), i4, i2, i3);
                        break;
                    case 25:
                        setPadding(i, i4, b.a().a(attributeSet.getAttributeValue(i5)), i3);
                        break;
                }
            }
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.b = com.mbridge.msdk.dycreator.utils.c.a(str);
        if (campaignEx != null) {
            this.c = campaignEx.getCampaignUnitId();
        }
    }

    public MBExtFeedBackView(Context context, AttributeSet attributeSet) {
        super(context);
        this.c = "";
        try {
            this.f4113a = com.mbridge.msdk.dycreator.utils.c.a(context, attributeSet);
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            com.mbridge.msdk.dycreator.utils.c.a(this.f4113a, this);
        } catch (Exception e) {
            p0.b("MBExtFeedBackView", e.getMessage());
        }
    }

    public MBExtFeedBackView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = "";
    }
}
