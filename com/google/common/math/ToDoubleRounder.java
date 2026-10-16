package com.google.common.math;

import com.google.common.base.Preconditions;
import com.ironsource.C3040d4;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.Comparable;
import java.lang.Number;
import java.math.RoundingMode;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
abstract class ToDoubleRounder<X extends Number & Comparable<X>> {
    abstract X minus(X a2, X b);

    abstract double roundToDoubleArbitrarily(X x);

    abstract int sign(X x);

    abstract X toX(double d, RoundingMode mode);

    ToDoubleRounder() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final double roundToDouble(X x, RoundingMode mode) {
        X x2;
        double d;
        int compareTo;
        Preconditions.checkNotNull(x, VastAttributes.HORIZONTAL_POSITION);
        Preconditions.checkNotNull(mode, C3040d4.a.t);
        double roundToDoubleArbitrarily = roundToDoubleArbitrarily(x);
        if (Double.isInfinite(roundToDoubleArbitrarily)) {
            switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return sign(x) * Double.MAX_VALUE;
                case 5:
                    return roundToDoubleArbitrarily == Double.POSITIVE_INFINITY ? Double.MAX_VALUE : Double.NEGATIVE_INFINITY;
                case 6:
                    return roundToDoubleArbitrarily == Double.POSITIVE_INFINITY ? Double.POSITIVE_INFINITY : -1.7976931348623157E308d;
                case 7:
                    return roundToDoubleArbitrarily;
                case 8:
                    throw new ArithmeticException(x + " cannot be represented precisely as a double");
            }
        }
        X x3 = toX(roundToDoubleArbitrarily, RoundingMode.UNNECESSARY);
        int compareTo2 = ((Comparable) x).compareTo(x3);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case 1:
                if (sign(x) >= 0) {
                    if (compareTo2 < 0) {
                        return DoubleUtils.nextDown(roundToDoubleArbitrarily);
                    }
                } else if (compareTo2 > 0) {
                    return Math.nextUp(roundToDoubleArbitrarily);
                }
                return roundToDoubleArbitrarily;
            case 2:
            case 3:
            case 4:
                if (compareTo2 >= 0) {
                    d = Math.nextUp(roundToDoubleArbitrarily);
                    if (d != Double.POSITIVE_INFINITY) {
                        x2 = toX(d, RoundingMode.CEILING);
                        compareTo = ((Comparable) minus(x, x3)).compareTo(minus(x2, x));
                        if (compareTo >= 0) {
                            if (compareTo <= 0) {
                                int i = AnonymousClass1.$SwitchMap$java$math$RoundingMode[mode.ordinal()];
                                if (i != 2) {
                                    if (i != 3) {
                                        if (i == 4) {
                                            if (sign(x) >= 0) {
                                            }
                                        } else {
                                            throw new AssertionError("impossible");
                                        }
                                    } else if (sign(x) >= 0) {
                                    }
                                } else if ((Double.doubleToRawLongBits(roundToDoubleArbitrarily) & 1) == 0) {
                                }
                            }
                            return d;
                        }
                        return roundToDoubleArbitrarily;
                    }
                    return roundToDoubleArbitrarily;
                }
                double nextDown = DoubleUtils.nextDown(roundToDoubleArbitrarily);
                if (nextDown != Double.NEGATIVE_INFINITY) {
                    X x4 = toX(nextDown, RoundingMode.FLOOR);
                    x2 = x3;
                    x3 = x4;
                    d = roundToDoubleArbitrarily;
                    roundToDoubleArbitrarily = nextDown;
                    compareTo = ((Comparable) minus(x, x3)).compareTo(minus(x2, x));
                    if (compareTo >= 0) {
                    }
                    return roundToDoubleArbitrarily;
                }
                return roundToDoubleArbitrarily;
            case 5:
                if (compareTo2 < 0) {
                    return DoubleUtils.nextDown(roundToDoubleArbitrarily);
                }
                return roundToDoubleArbitrarily;
            case 6:
                if (compareTo2 > 0) {
                    return Math.nextUp(roundToDoubleArbitrarily);
                }
                return roundToDoubleArbitrarily;
            case 7:
                if (sign(x) >= 0) {
                    if (compareTo2 > 0) {
                        return Math.nextUp(roundToDoubleArbitrarily);
                    }
                } else if (compareTo2 < 0) {
                    return DoubleUtils.nextDown(roundToDoubleArbitrarily);
                }
                return roundToDoubleArbitrarily;
            case 8:
                MathPreconditions.checkRoundingUnnecessary(compareTo2 == 0);
                return roundToDoubleArbitrarily;
            default:
                throw new AssertionError("impossible");
        }
    }

    /* renamed from: com.google.common.math.ToDoubleRounder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }
}
