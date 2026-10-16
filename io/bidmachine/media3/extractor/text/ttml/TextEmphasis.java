package io.bidmachine.media3.extractor.text.ttml;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
final class TextEmphasis {
    public static final int MARK_SHAPE_AUTO = -1;
    public static final int POSITION_OUTSIDE = -2;
    public final int markFill;
    public final int markShape;
    public final int position;
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
    private static final ImmutableSet<String> SINGLE_STYLE_VALUES = ImmutableSet.of("auto", "none");
    private static final ImmutableSet<String> MARK_SHAPE_VALUES = ImmutableSet.of("dot", "sesame", "circle");
    private static final ImmutableSet<String> MARK_FILL_VALUES = ImmutableSet.of("filled", "open");
    private static final ImmutableSet<String> POSITION_VALUES = ImmutableSet.of("after", "before", "outside");

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    private TextEmphasis(int i, int i2, int i3) {
        this.markShape = i;
        this.markFill = i2;
        this.position = i3;
    }

    public static TextEmphasis parse(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = Ascii.toLowerCase(str.trim());
        if (lowerCase.isEmpty()) {
            return null;
        }
        return parseWords(ImmutableSet.copyOf(TextUtils.split(lowerCase, WHITESPACE_PATTERN)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ed, code lost:
    
        if (r9.equals("dot") != false) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TextEmphasis parseWords(ImmutableSet<String> immutableSet) {
        boolean z;
        int i;
        int hashCode;
        String str = (String) Iterables.getFirst(Sets.intersection(POSITION_VALUES, immutableSet), "outside");
        int hashCode2 = str.hashCode();
        boolean z2 = false;
        int i2 = -1;
        if (hashCode2 == -1392885889) {
            if (str.equals("before")) {
                z = 2;
            }
            z = -1;
        } else if (hashCode2 != -1106037339) {
            if (hashCode2 == 92734940 && str.equals("after")) {
                z = false;
            }
            z = -1;
        } else {
            if (str.equals("outside")) {
                z = true;
            }
            z = -1;
        }
        int i3 = z ? !z ? 1 : -2 : 2;
        Sets.SetView intersection = Sets.intersection(SINGLE_STYLE_VALUES, immutableSet);
        if (!intersection.isEmpty()) {
            String str2 = (String) intersection.iterator().next();
            int hashCode3 = str2.hashCode();
            if (hashCode3 == 3005871) {
                str2.equals("auto");
            } else if (hashCode3 == 3387192 && str2.equals("none")) {
                i2 = 0;
            }
            return new TextEmphasis(i2, 0, i3);
        }
        Sets.SetView intersection2 = Sets.intersection(MARK_FILL_VALUES, immutableSet);
        Sets.SetView intersection3 = Sets.intersection(MARK_SHAPE_VALUES, immutableSet);
        if (intersection2.isEmpty() && intersection3.isEmpty()) {
            return new TextEmphasis(-1, 0, i3);
        }
        String str3 = (String) Iterables.getFirst(intersection2, "filled");
        int hashCode4 = str3.hashCode();
        if (hashCode4 == -1274499742) {
            str3.equals("filled");
        } else if (hashCode4 == 3417674 && str3.equals("open")) {
            i = 2;
            String str4 = (String) Iterables.getFirst(intersection3, "circle");
            hashCode = str4.hashCode();
            if (hashCode != -1360216880) {
                if (str4.equals("circle")) {
                    z2 = 2;
                }
                z2 = -1;
            } else if (hashCode != -905816648) {
                if (hashCode == 99657) {
                }
                z2 = -1;
            } else {
                if (str4.equals("sesame")) {
                    z2 = true;
                }
                z2 = -1;
            }
            return new TextEmphasis(z2 ? !z2 ? 1 : 3 : 2, i, i3);
        }
        i = 1;
        String str42 = (String) Iterables.getFirst(intersection3, "circle");
        hashCode = str42.hashCode();
        if (hashCode != -1360216880) {
        }
        return new TextEmphasis(z2 ? !z2 ? 1 : 3 : 2, i, i3);
    }
}
