package edu.mirea.alexbulan.countpressing.ui.viewModule;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel {
    private int pressCount;
    private final MutableLiveData<Integer> observableContainer = new MutableLiveData<>();

    public int getPressCountValue() {
        return pressCount;
    }

    public MutableLiveData<Integer> getPressCountContainer(){
        return observableContainer;
    }
    public void increasePressCount(){
        pressCount++;
        observableContainer.setValue(pressCount);
    }
}
