package com.example.biometria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(BiometriaHelper.isBiometricAvailable(this)) {

            val execute = ContextCompat.getMainExecutor(this)

            val bio = BiometricPrompt(this, execute, object : BiometricPrompt.AuthenticationCallback(){
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    val test = "Test"
                    super.onAuthenticationSucceeded(result)
                }
            })

            val info = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Title")
                .setSubtitle("Subtitle")
                .setDescription("Description")
                .setNegativeButtonText("Cancel")
                .build()

            bio.authenticate(info)
        }
    }
}