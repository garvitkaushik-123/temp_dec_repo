package com.bytedance.adsdk.ugeno.eli;

import io.bidmachine.iab.vast.tags.VastAttributes;

/* loaded from: classes3.dex */
public enum ui {
    TRANSLATE("translate", "translation", "point"),
    TRANSLATE_X("translateX", "translationX", "float"),
    TRANSLATE_Y("translateY", "translationY", "float"),
    ROTATE_X("rotateX", "rotationX", "float"),
    ROTATE_Y("rotateY", "rotationY", "float"),
    ROTATE_Z("rotateZ", "rotation", "float"),
    SCALE("scale", "scale", "point"),
    SCALE_X("scaleX", "scaleX", "float"),
    SCALE_Y("scaleY", "scaleY", "float"),
    ALPHA(VastAttributes.OPACITY, "alpha", "float"),
    BACKGROUND_COLOR("backgroundColor", "backgroundColor", "int"),
    BORDER_RADIUS("borderRadius", "borderRadius", "float"),
    RIPPLE("ripple", "ripple", "float"),
    SHINE("shine", "shine", "float");

    private final String Dfc;
    private final String aqO;
    private final String dV;

    ui(String str, String str2, String str3) {
        this.Dfc = str;
        this.aqO = str2;
        this.dV = str3;
    }

    public String eli() {
        return this.Dfc;
    }

    public String DbA() {
        return this.aqO;
    }

    public String Os() {
        return this.dV;
    }

    public static ui eli(String str) {
        str.hashCode();
        switch (str) {
            case "translateX":
                return TRANSLATE_X;
            case "translateY":
                return TRANSLATE_Y;
            case "opacity":
                return ALPHA;
            case "ripple":
                return RIPPLE;
            case "scaleX":
                return SCALE_X;
            case "scaleY":
                return SCALE_Y;
            case "scale":
                return SCALE;
            case "translate":
                return TRANSLATE;
            case "backgroundColor":
                return BACKGROUND_COLOR;
            case "borderRadius":
                return BORDER_RADIUS;
            case "rotateX":
                return ROTATE_X;
            case "rotateY":
                return ROTATE_Y;
            case "rotateZ":
                return ROTATE_Z;
            default:
                return TRANSLATE_X;
        }
    }
}
