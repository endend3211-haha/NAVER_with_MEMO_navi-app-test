package com.example.naviparsertest

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 복잡한 화면 파일 없이 코드로 간단히 버튼 하나만 만듭니다.
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(50, 50, 50, 50)
        }

        val guideText = TextView(this).apply {
            text = "1. 아래 버튼을 눌러 권한 설정 화면으로 이동하세요.\n\n" +
                   "2. 목록에서 '네이버길안내테스트'를 찾아 스위치를 켜주세요.\n\n" +
                   "3. 네이버 지도에서 길안내(또는 모의주행)를 시작하면 컴퓨터 화면(Logcat)에 글자가 찍힙니다."
            textSize = 16f
            setPadding(0, 0, 0, 50)
        }

        val permissionButton = Button(this).apply {
            text = "알림 읽기 권한 켜러 가기"
            textSize = 18f
            setOnClickListener {
                // 휴대폰의 '알림 접근 허용' 설정 창을 바로 열어줍니다.
                startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
            }
        }

        layout.addView(guideText)
        layout.addView(permissionButton)
        setContentView(layout)
    }
}
