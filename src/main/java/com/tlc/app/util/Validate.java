package com.tlc.app.util;

import com.tlc.app.model.ReadTripRecordModel;
import javafx.css.PseudoClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Validate {
    public static boolean validateRow(ReadTripRecordModel tripRecord) {
        List<ReadTripRecordModel> tripRecordListWithErrors = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        boolean isValid = false;
        try {
            Date startDateAndTime = simpleDateFormat.parse(tripRecord.getTimePickedUp());
            Date endDateAndTime = simpleDateFormat.parse(tripRecord.getTimeCompleted());
            isValid =  startDateAndTime.equals(endDateAndTime) || !Objects.equals(tripRecord.getDispatchingBaseNumber(),
                    tripRecord.getAffiliatedBaseNumber()) || tripRecord.getPickup().isEmpty() ||
                    tripRecord.getDestination().isEmpty() ||
                    tripRecord.getPickupLatitude().isEmpty() || tripRecord.getPickupLongitude().isEmpty() ||
                    tripRecord.getDestinationLatitude().isEmpty() || tripRecord.getDestinationLongitude().isEmpty() ||
                    tripRecord.getTLCDriverLicenseNumber().isEmpty() || tripRecord.getDriver().isEmpty();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
