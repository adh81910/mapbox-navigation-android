package com.mapbox.services.android.navigation.ui.v5;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.BottomSheetBehavior;

public class InstanceState implements Parcelable {
  public int bottomSheetBehaviorState;
  public int recenterButtonVisibility;
  public boolean navigationRunning;
  public boolean instructionViewVisible;

  public InstanceState(BottomSheetBehavior bottomSheetBehavior, int recenterButtonVisibility,
                       boolean navigationRunning, boolean instructionViewVisible) {
    this.bottomSheetBehaviorState = bottomSheetBehavior.getState();
    this.recenterButtonVisibility = recenterButtonVisibility;
    this.navigationRunning = navigationRunning;
    this.instructionViewVisible = instructionViewVisible;
  }

  public InstanceState(Parcel parcel) {
    bottomSheetBehaviorState = parcel.readInt();
    recenterButtonVisibility = parcel.readInt();
    navigationRunning = parcel.readByte() != 0x00;
    instructionViewVisible = parcel.readByte() != 0x00;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(bottomSheetBehaviorState);
    dest.writeInt(recenterButtonVisibility);
    dest.writeByte((byte) (navigationRunning ? 0x01 : 0x00));
    dest.writeByte((byte) (instructionViewVisible ? 0x01 : 0x00));
  }

  public static final Parcelable.Creator<InstanceState> CREATOR = new Parcelable.Creator<InstanceState>() {

    @Override
    public InstanceState createFromParcel(Parcel source) {
      return new InstanceState(source);
    }

    @Override
    public InstanceState[] newArray(int size) {
      return new InstanceState[size];
    }
  };
}
