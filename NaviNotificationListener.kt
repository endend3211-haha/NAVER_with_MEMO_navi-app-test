package com.example.naviparsertest

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class NaviNotificationListener : NotificationListenerService() {

    // 상단바에 새로운 알림이 뜰 때마다 자동으로 실행되는 부분입니다.
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)

        // 어떤 앱이 보낸 알림인지 이름을 확인합니다.
        val packageName = sbn?.packageName ?: return

        // 네이버 지도(com.nhn.android.nmap)가 보낸 알림일 때만 작동합니다.
        if (packageName == "com.nhn.android.nmap") {
            
            // 알림 안에 들어있는 데이터 꾸러미(extras)를 꺼냅니다.
            val extras = sbn.notification?.extras ?: return

            Log.d("NAVER_NAVI", "================ [네이버 길안내 알림 도착] ================")

            // 꾸러미 안에 들어있는 모든 항목(이름표와 실제 글자)을 하나씩 전부 출력합니다.
            for (key in extras.keySet()) {
                val value = extras.get(key)
                
                // 들어있는 값이 여러 개 묶음(배열)인지 일반 글자인지 구분해서 보기 좋게 만듭니다.
                val textValue = when (value) {
                    is Array<*> -> value.contentToString()
                    else -> value.toString()
                }

                // 컴퓨터의 Logcat 창에 결과를 찍어줍니다.
                Log.d("NAVER_NAVI", "항목이름: $key  ===>  내용: $textValue")
            }

            Log.d("NAVER_NAVI", "==========================================================")
        }
    }
}
