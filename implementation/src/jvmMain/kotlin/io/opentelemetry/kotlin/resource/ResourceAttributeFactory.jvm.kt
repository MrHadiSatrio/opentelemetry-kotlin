package io.opentelemetry.kotlin.resource

import io.opentelemetry.kotlin.ExperimentalApi
import io.opentelemetry.kotlin.attributes.AttributeFactory

@ExperimentalApi
internal actual fun buildResourceAttributeFactory(): AttributeFactory {
  return AttributeFactory {}
}
