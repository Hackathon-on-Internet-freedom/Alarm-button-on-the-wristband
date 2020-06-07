package com.alarmer.braceletbutton.ui.devices;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DevicesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DevicesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() { return mText; }

    public void setText(String Text) { mText.setValue(Text); }
}