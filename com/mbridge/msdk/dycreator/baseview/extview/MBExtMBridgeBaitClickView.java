package com.mbridge.msdk.dycreator.baseview.extview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.engine.b;
import com.mbridge.msdk.dycreator.engine.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class MBExtMBridgeBaitClickView extends MBridgeBaitClickView implements InterBase {
    private Map<String, String> m;

    /* renamed from: com.mbridge.msdk.dycreator.baseview.extview.MBExtMBridgeBaitClickView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4117a;

        static {
            int[] iArr = new int[c.values().length];
            f4117a = iArr;
            try {
                iArr[c.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4117a[c.background.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4117a[c.padding.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4117a[c.gravity.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4117a[c.visibility.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4117a[c.layout_width.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4117a[c.layout_height.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4117a[c.layout_centerHorizontal.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4117a[c.layout_alignParentBottom.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4117a[c.layout_alignParentTop.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4117a[c.layout_centerVertical.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4117a[c.layout_below.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4117a[c.layout_above.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4117a[c.layout_toLeftOf.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f4117a[c.layout_toRightOf.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f4117a[c.layout_toEndOf.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f4117a[c.layout_margin.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f4117a[c.layout_marginLeft.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f4117a[c.layout_marginRight.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f4117a[c.layout_marginTop.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f4117a[c.layout_marginBottom.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f4117a[c.layout_alignParentRight.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f4117a[c.layout_alignParentLeft.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f4117a[c.layout_alignTop.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f4117a[c.layout_alignLeft.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f4117a[c.layout_alignRight.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f4117a[c.layout_alignBottom.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f4117a[c.layout_centerInParent.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f4117a[c.layout_alignParentEnd.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
        }
    }

    public MBExtMBridgeBaitClickView(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.m;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.m.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.m;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.m.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.m;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.m.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.m;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.m.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.m;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.m.get("mbridgeStrategy");
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        String[] strArr;
        HashMap<String, c> c = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            c cVar = c.get(attributeSet.getAttributeName(i));
            if (cVar != null) {
                int i2 = AnonymousClass1.f4117a[cVar.ordinal()];
                if (i2 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (attributeValue.startsWith("@+id/")) {
                        setId(attributeValue.substring(5).hashCode());
                    }
                } else if (i2 == 2) {
                    Log.i("litongtest", "设置背景颜色");
                    String attributeValue2 = attributeSet.getAttributeValue(i);
                    if (attributeValue2.startsWith("#")) {
                        try {
                            strArr = attributeValue2.split("-");
                        } catch (Exception unused) {
                            strArr = null;
                        }
                        if (strArr != null && strArr.length <= 2) {
                            setBackgroundColor(b.a().d(attributeSet.getAttributeValue(i)));
                        } else if (strArr == null || strArr.length != 3) {
                            setBackgroundColor(b.a().d(attributeSet.getAttributeValue(i)));
                        } else {
                            try {
                                GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArr[2]), new int[]{Color.parseColor(strArr[0]), Color.parseColor(strArr[1])});
                                gradientDrawable.setGradientType(0);
                                setBackground(gradientDrawable);
                            } catch (Exception unused2) {
                                setBackgroundColor(b.a().d(attributeSet.getAttributeValue(i)));
                            }
                        }
                    } else {
                        if (attributeValue2.startsWith("@drawable/")) {
                            attributeValue2 = attributeValue2.substring(10);
                        }
                        setBackgroundResource(h0.a(com.mbridge.msdk.foundation.controller.c.m().d(), attributeValue2, "drawable"));
                    }
                } else if (i2 == 3) {
                    int a2 = b.a().a(attributeSet.getAttributeValue(i));
                    setPadding(a2, a2, a2, a2);
                } else if (i2 == 4) {
                    setGravity(b.a().b(attributeSet.getAttributeValue(i)));
                } else if (i2 == 5) {
                    String attributeValue3 = attributeSet.getAttributeValue(i);
                    if (!TextUtils.isEmpty(attributeValue3)) {
                        if (attributeValue3.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue3.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                }
            }
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
    }

    public MBExtMBridgeBaitClickView(Context context, AttributeSet attributeSet) {
        super(context);
        try {
            this.m = com.mbridge.msdk.dycreator.utils.c.a(context, attributeSet);
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            com.mbridge.msdk.dycreator.utils.c.a(this.m, this);
        } catch (Exception e) {
            p0.b("MBExtMBridgeBaitClickView", e.getMessage());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        HashMap b = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            c cVar = (c) b.get(attributeSet.getAttributeName(i));
            if (cVar != null) {
                switch (AnonymousClass1.f4117a[cVar.ordinal()]) {
                    case 6:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        if (!attributeValue.startsWith(VastAttributes.FILL_COLOR) && !attributeValue.startsWith("match")) {
                            if (attributeValue.startsWith("w")) {
                                layoutParams.width = -2;
                                break;
                            } else {
                                layoutParams.width = b.a().a(attributeValue);
                                break;
                            }
                        } else {
                            layoutParams.width = -1;
                            break;
                        }
                        break;
                    case 7:
                        String attributeValue2 = attributeSet.getAttributeValue(i);
                        if (!attributeValue2.startsWith(VastAttributes.FILL_COLOR) && !attributeValue2.startsWith("match")) {
                            if (attributeValue2.startsWith("wrap")) {
                                layoutParams.height = -2;
                                break;
                            } else {
                                layoutParams.height = b.a().a(attributeValue2);
                                break;
                            }
                        } else {
                            layoutParams.height = -1;
                            break;
                        }
                        break;
                    case 8:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(14, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(12, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(10, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(15, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        String attributeValue3 = attributeSet.getAttributeValue(i);
                        if (attributeValue3.startsWith("@+id")) {
                            layoutParams.addRule(3, attributeValue3.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        String attributeValue4 = attributeSet.getAttributeValue(i);
                        if (attributeValue4.startsWith("@+id")) {
                            layoutParams.addRule(2, attributeValue4.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        String attributeValue5 = attributeSet.getAttributeValue(i);
                        if (attributeValue5.startsWith("@+id")) {
                            layoutParams.addRule(0, attributeValue5.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        String attributeValue6 = attributeSet.getAttributeValue(i);
                        if (attributeValue6.startsWith("@+id")) {
                            layoutParams.addRule(1, attributeValue6.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        String attributeValue7 = attributeSet.getAttributeValue(i);
                        if (attributeValue7.startsWith("@+id")) {
                            layoutParams.addRule(17, attributeValue7.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int a2 = b.a().a(attributeSet.getAttributeValue(i));
                        layoutParams.setMargins(a2, a2, a2, a2);
                        break;
                    case 18:
                        layoutParams.leftMargin = b.a().a(attributeSet.getAttributeValue(i));
                        break;
                    case 19:
                        layoutParams.rightMargin = b.a().a(attributeSet.getAttributeValue(i));
                        break;
                    case 20:
                        layoutParams.topMargin = b.a().a(attributeSet.getAttributeValue(i));
                        break;
                    case 21:
                        layoutParams.bottomMargin = b.a().a(attributeSet.getAttributeValue(i));
                        break;
                    case 22:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(11, -1);
                            break;
                        } else {
                            break;
                        }
                    case 23:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(9, -1);
                            break;
                        } else {
                            break;
                        }
                    case 24:
                        String attributeValue8 = attributeSet.getAttributeValue(i);
                        if (attributeValue8.startsWith("@+id")) {
                            layoutParams.addRule(6, attributeValue8.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 25:
                        String attributeValue9 = attributeSet.getAttributeValue(i);
                        if (attributeValue9.startsWith("@+id")) {
                            layoutParams.addRule(5, attributeValue9.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 26:
                        String attributeValue10 = attributeSet.getAttributeValue(i);
                        if (attributeValue10.startsWith("@+id")) {
                            layoutParams.addRule(7, attributeValue10.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 27:
                        String attributeValue11 = attributeSet.getAttributeValue(i);
                        if (attributeValue11.startsWith("@+id")) {
                            layoutParams.addRule(8, attributeValue11.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 28:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(13, -1);
                            break;
                        } else {
                            break;
                        }
                    case 29:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(21, -1);
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return layoutParams;
    }

    public MBExtMBridgeBaitClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
