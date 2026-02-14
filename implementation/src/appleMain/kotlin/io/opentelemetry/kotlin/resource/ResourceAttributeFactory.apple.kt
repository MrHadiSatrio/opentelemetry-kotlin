package io.opentelemetry.kotlin.resource

import io.opentelemetry.kotlin.ExperimentalApi
import io.opentelemetry.kotlin.attributes.AttributeFactory
import io.opentelemetry.kotlin.semconv.IncubatingApi
import kotlin.experimental.ExperimentalNativeApi
import kotlinx.cinterop.ExperimentalForeignApi

@ExperimentalApi
@OptIn(IncubatingApi::class, ExperimentalNativeApi::class, ExperimentalForeignApi::class)
internal actual fun buildResourceAttributeFactory(): AttributeFactory {
  return AttributeFactory {}
}
