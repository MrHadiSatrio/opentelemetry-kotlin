package io.opentelemetry.kotlin

import io.opentelemetry.kotlin.factory.SdkFactory
import io.opentelemetry.kotlin.factory.createSdkFactory
import io.opentelemetry.kotlin.init.OpenTelemetryConfigDsl
import io.opentelemetry.kotlin.init.OpenTelemetryConfigImpl
import io.opentelemetry.kotlin.logging.LoggerProviderImpl
import io.opentelemetry.kotlin.resource.buildResourceAttributeFactory
import io.opentelemetry.kotlin.tracing.TracerProviderImpl

/**
 * Constructs an [OpenTelemetry] instance that uses the opentelemetry-kotlin implementation.
 */
@ExperimentalApi
public fun createOpenTelemetry(config: OpenTelemetryConfigDsl.() -> Unit = {}): OpenTelemetry {
    return createOpenTelemetryImpl(
        config,
        createSdkFactory(),
    )
}

/**
 * Internal implementation of [createOpenTelemetry]. This is not publicly visible as
 * we don't want to allow users to supply a custom [SdkFactory].
 */
@ExperimentalApi
internal fun createOpenTelemetryImpl(
    config: OpenTelemetryConfigDsl.() -> Unit,
    sdkFactory: SdkFactory,
): OpenTelemetry {
    val cfg = OpenTelemetryConfigImpl().apply(config)
    val clock = cfg.clock

    cfg.tracingConfig.resource(null) { buildResourceAttributeFactory().addTo(this) }
    val tracingConfig = cfg.tracingConfig.generateTracingConfig()

    cfg.loggingConfig.resource(null)  { buildResourceAttributeFactory().addTo(this) }
    val loggingConfig = cfg.loggingConfig.generateLoggingConfig()

    return CloseableOpenTelemetryImpl(
        tracerProvider = TracerProviderImpl(clock, tracingConfig, sdkFactory),
        loggerProvider = LoggerProviderImpl(clock, loggingConfig, sdkFactory),
        clock = clock,
        sdkFactory = sdkFactory
    )
}
