package seopftware.fundmytravel.maps2.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.Observable;

/**
 * Created by MSI on 2018-01-31.
 */

public class accelerometer  extends Observable implements SensorEventListener,Isensor {

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;

    private SensorEvent event;

    public accelerometer(Context context){
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public boolean isSupport(){
        if (accelerometerSensor == null)
            return false;

        return true;
    }

    @Override
    public void on(int speed){
        switch (speed) {
            case 0:
                sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
                break;

            case 1:
                sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_UI);
                break;

            case 2:
                sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_GAME);
                break;

            case 3:
                sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_FASTEST);
                break;

            default:
                sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
                break;
        }
    }

    @Override
    public void off(){
        sensorManager.unregisterListener(this, accelerometerSensor);
    }

    @Override
    public float getMaximumRange()
    {
        return accelerometerSensor.getMaximumRange();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        event = sensorEvent;

        setChanged();
        notifyObservers();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public SensorEvent getEvent(){
        return event;
    }

}

