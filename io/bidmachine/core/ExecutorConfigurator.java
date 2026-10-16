package io.bidmachine.core;

/* loaded from: classes7.dex */
class ExecutorConfigurator {
    public static final float DEFAULT_CPU_USAGE_FRACTION = 0.25f;
    public static final float DEFAULT_SERVICE_TIME_RATIO = 0.100000024f;
    public static final float DEFAULT_WAIT_TIME_RATIO = 0.9f;
    public static final float MIN_CPU_USAGE_FRACTION = 1.0E-4f;
    private final int corePoolSize;
    private final int maximumPoolSize;

    public ExecutorConfigurator() {
        this(0.25f, 0.9f);
    }

    public ExecutorConfigurator(float cpuUsageFraction) {
        this(cpuUsageFraction, 0.9f);
    }

    public ExecutorConfigurator(float cpuUsageFraction, float waitTimeRatio) {
        float ensureMinimumCpuUsage = ensureMinimumCpuUsage(cpuUsageFraction);
        float ensureValidWaitTimeRatio = ensureValidWaitTimeRatio(waitTimeRatio);
        int calculateCorePoolSize = calculateCorePoolSize(availableProcessors(), ensureMinimumCpuUsage);
        this.corePoolSize = calculateCorePoolSize;
        this.maximumPoolSize = calculateMaximumPoolSize(calculateCorePoolSize, 1.0f - ensureValidWaitTimeRatio, ensureValidWaitTimeRatio);
    }

    public int getCorePoolSize() {
        return this.corePoolSize;
    }

    public int getMaximumPoolSize() {
        return this.maximumPoolSize;
    }

    int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    static float ensureMinimumCpuUsage(float cpuUsageFraction) {
        return Math.max(cpuUsageFraction, 1.0E-4f);
    }

    static float ensureValidWaitTimeRatio(float waitTimeRatio) {
        return Math.max(0.0f, Math.min(1.0f, waitTimeRatio));
    }

    static int calculateCorePoolSize(int availableProcessors, float cpuUsageFraction) {
        return Math.max(1, Math.round(availableProcessors * cpuUsageFraction));
    }

    static int calculateMaximumPoolSize(int corePoolSize, float serviceTimeRatio, float waitTimeRatio) {
        if (serviceTimeRatio <= 0.0f) {
            return Integer.MAX_VALUE;
        }
        return Math.round(corePoolSize * ((waitTimeRatio / serviceTimeRatio) + 1.0f));
    }
}
