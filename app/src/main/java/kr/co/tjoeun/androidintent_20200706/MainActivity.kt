package kr.co.tjoeun.androidintent_20200706

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialBtn.setOnClickListener {

//            입력한 휴대폰 번호 받아오기
            val inputPhoneNum = phoneNumEdt.text.toString()

//            정보 저장 변수 => URL. 어디로 전화를 걸지 정보를 저장함
            val myUri = Uri.parse("tel:${inputPhoneNum}")

//            실제 전화 화면으로 이동시켜줄 Intent
//            어떤 행동을 할지 종류와 세부정보를 입력한다. (종류 -> Dial)
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

//            액티비티 실행
            startActivity(myIntent)

        }

        callBtn.setOnClickListener {

            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)

        }

        smsBtn.setOnClickListener {

            val inputPhoneNum = phoneNumEdt.text.toString()
            val inputContent = smsContentEdt.text.toString()

            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
//            입력한 내용을 putExtra 로 파라미터 전달 -> 문자 내용id는 sms_body. 내부적으로 설정된 명
            myIntent.putExtra("sms_body", inputContent)
            startActivity(myIntent)

        }
    }
}