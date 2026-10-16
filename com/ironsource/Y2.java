package com.ironsource;

/* loaded from: classes6.dex */
public interface Y2 extends InterfaceC3317tb<Integer, Integer> {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3136a = new a();
        public static final int b = 3009;
        public static final int c = 3008;

        private a() {
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3137a = new b();
        public static final int b = 3002;
        public static final int c = 3005;
        public static final int d = 3300;
        public static final int e = 3503;
        public static final int f = 3504;

        private b() {
        }
    }

    public static final class c implements Y2 {
        @Override // com.ironsource.InterfaceC3317tb
        public /* bridge */ /* synthetic */ Integer a(Integer num) {
            return a(num.intValue());
        }

        public Integer a(int i) throws IllegalArgumentException {
            int i2;
            if (i == 206) {
                i2 = b.e;
            } else if (i == 207) {
                i2 = b.f;
            } else if (i == 405) {
                i2 = 3009;
            } else if (i != 406) {
                switch (i) {
                    case 101:
                        i2 = 83500;
                        break;
                    case 102:
                        i2 = 83510;
                        break;
                    case 103:
                        i2 = d.h;
                        break;
                    case 104:
                        i2 = 83300;
                        break;
                    default:
                        switch (i) {
                            case 109:
                                i2 = 88002;
                                break;
                            case 110:
                                i2 = 83004;
                                break;
                            case 111:
                                break;
                            case 112:
                                i2 = 3305;
                                break;
                            default:
                                switch (i) {
                                    case 201:
                                        i2 = 3002;
                                        break;
                                    case 202:
                                        i2 = 3005;
                                        break;
                                    case 203:
                                        i2 = 3300;
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Unknown event code: " + i);
                                }
                        }
                    case 105:
                        i2 = 83302;
                        break;
                }
            } else {
                i2 = 3008;
            }
            return Integer.valueOf(i2);
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final d f3138a = new d();
        public static final int b = 83500;
        public static final int c = 83510;
        public static final int d = 83300;
        public static final int e = 83302;
        public static final int f = 83004;
        public static final int g = 88002;
        public static final int h = 83301;
        public static final int i = 83302;
        public static final int j = 3305;

        private d() {
        }
    }
}
