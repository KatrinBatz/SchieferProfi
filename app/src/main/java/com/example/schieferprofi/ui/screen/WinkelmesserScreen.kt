package com.example.schieferprofi.ui.screen

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.schieferprofi.R
import com.example.schieferprofi.ui.components.Background
import com.example.schieferprofi.ui.components.SpiritLibelle
import com.example.schieferprofi.util.Orientation

@Composable
fun WinkelmesserScreen() {
    val context = LocalContext.current
    val sensorManager = remember {
        context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    var tiltX by remember { mutableStateOf(0f) }
    var tiltY by remember { mutableStateOf(0f) }
    var calibratedX by remember { mutableStateOf(0f) }
    var calibratedY by remember { mutableStateOf(0f) }

    var isHold by remember { mutableStateOf(false) }
    var heldX by remember { mutableStateOf(0f) }
    var heldY by remember { mutableStateOf(0f) }

    DisposableEffect(Unit) {
        val rotationVectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                if (event != null && !isHold) {
                    val rotationMatrix = FloatArray(9)
                    SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values)

                    val orientationAngles = FloatArray(3)
                    SensorManager.getOrientation(rotationMatrix, orientationAngles)

                    val pitch = Math.toDegrees(orientationAngles[1].toDouble())
                    val roll = Math.toDegrees(orientationAngles[2].toDouble())

                    tiltX = roll.toFloat()
                    tiltY = pitch.toFloat()
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }

        sensorManager.registerListener(
            listener,
            rotationVectorSensor,
            SensorManager.SENSOR_DELAY_UI
        )

        onDispose {
            sensorManager.unregisterListener(listener)
        }
    }

    val displayX = if (isHold) heldX else tiltX - calibratedX
    val displayY = if (isHold) heldY else tiltY - calibratedY

    Box(modifier = Modifier.fillMaxSize()) {
        Background()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Winkelmesser",
                color = colorResource(R.color.hellgrau),
                fontFamily = FontFamily(Font(R.font.ptserif_bolditalic)),
                fontSize = 40.sp,
                textDecoration = TextDecoration.Underline)

            SpiritLibelle(
                angle = displayX,
                orientation = Orientation.Horizontal
            )

            SpiritLibelle(
                angle = displayY,
                orientation = Orientation.Vertical
            )

            Row(
                modifier = Modifier.padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = {
                        calibratedX = tiltX
                        calibratedY = tiltY
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.moosgruen)
                    )
                ) {
                    Text("Set")
                }

                Button(
                    onClick = {
                        isHold = !isHold
                        if (isHold) {
                            heldX = tiltX - calibratedX
                            heldY = tiltY - calibratedY
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isHold) colorResource(R.color.ziegelrot) else colorResource(R.color.moosgruen)
                    )
                ) {
                    Text(if (isHold) "Hold ✔️" else "Hold")
                }
            }
        }
    }
}