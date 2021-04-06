package kr.ac.smu.smart0356.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView mTxtSensors;
    SensorManager sensorManager;
    List<Sensor> sensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtSensors = findViewById(R.id.txtSensors);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensorList = sensorManager.getSensorList((Sensor.TYPE_ALL));

        mTxtSensors.append("(# Sensors:" + sensorList.size() + ")\n\n");
        for(Sensor sensor : sensorList) {
            mTxtSensors.append("Sensor name: " + sensor.getName() + "\n");
            mTxtSensors.append("Sensor type: " + sensor.getType() + "\n");
        }
    }
}