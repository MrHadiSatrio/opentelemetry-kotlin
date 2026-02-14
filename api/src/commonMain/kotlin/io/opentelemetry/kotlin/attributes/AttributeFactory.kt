package io.opentelemetry.kotlin.attributes

import io.opentelemetry.kotlin.ExperimentalApi

/**
 * Implementations of this interface are responsible for collecting specific types of contextual
 * information (such as device info, network state, location, etc.) and adding them to a
 * [MutableAttributeContainer] that can be attached to telemetry signals like traces, metrics, or
 *
 * https://opentelemetry.io/docs/specs/otel/common/#attribute
 */
@ExperimentalApi
public fun interface AttributeFactory {

  /**
   * Adds attributes to the given container.
   *
   * @param container The [MutableAttributeContainer] to add attributes to.
   */
  public fun addTo(container: MutableAttributeContainer)
}
