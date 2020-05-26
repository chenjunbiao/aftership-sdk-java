package com.aftership.sdk.model.courier;

import com.aftership.sdk.error.AftershipException;
import com.aftership.sdk.error.ErrorMessage;
import com.aftership.sdk.utils.StrUtils;
import lombok.Value;

/** The request object of couriers detect */
@Value
public class CourierDetectRequest {
  /** Tracking Object. */
  CourierDetectTracking tracking;

  /**
   * CourierDetectRequest constructor
   *
   * @param tracking tracking object, the tracking_number field is required.
   */
  public CourierDetectRequest(CourierDetectTracking tracking) {
    if (tracking == null || StrUtils.isBlank(tracking.getTrackingNumber())) {
      throw new AftershipException(ErrorMessage.CONSTRUCTOR_INVALID_TRACKING_NUMBER);
    }
    this.tracking = tracking;
  }
}
