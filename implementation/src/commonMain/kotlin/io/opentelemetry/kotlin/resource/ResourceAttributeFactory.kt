package io.opentelemetry.kotlin.resource

import io.opentelemetry.kotlin.ExperimentalApi
import io.opentelemetry.kotlin.attributes.AttributeFactory

@ExperimentalApi
internal expect fun buildResourceAttributeFactory(): AttributeFactory
