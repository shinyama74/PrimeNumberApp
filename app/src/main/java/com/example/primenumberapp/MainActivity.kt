package com.example.primenumberapp

import android.graphics.Color.BLACK
import android.graphics.Color.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    companion object {
        private const val QUESTION_COUNT: Int = 10
    }

    var random: Random = Random()
    var questions: IntArray = IntArray(QUESTION_COUNT)
    var point: Int = 0
    var answerCount: Int = 0
    var trueAnswers: Array<String?> = arrayOfNulls(QUESTION_COUNT)
    var yourAnswers: Array<String?> = arrayOfNulls(QUESTION_COUNT)
    var judgements: Array<String?> = arrayOfNulls(QUESTION_COUNT)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tableLayout.isVisible=false

        ranNumber()
        point = 0
        answerCount = 0
        numberText.text = questions[answerCount].toString() + ""
        numberText.setTextColor(BLACK)
    }

    fun ranNumber() {
        for (i in 0 until QUESTION_COUNT) {
            val number = random.nextInt(1000)
            Log.d("Number", "Question" + number.toString())
            questions[i] = number
        }
    }

    fun processing(answer: Boolean, number: Int) {
        //判定描写
        if (answer) {
            Toast.makeText(this, "正解", Toast.LENGTH_SHORT).show()
            judgements[answerCount]="正"

        } else {
            Toast.makeText(this, "不正解", Toast.LENGTH_SHORT).show()
            judgements[answerCount]="不"

        }

        //log記入
        if (answer) {
            point++
            Log.d("maru", "正解" + point.toString())
        } else {
            Log.d("batsu", "不正解")
        }

        answerCount++

        if (answerCount == QUESTION_COUNT) {
            tableLayout.isVisible=true
            numberText.text = point.toString() + "点"
            numberText.setTextColor(RED)

            resultPrint()

            point = 0
            answerCount = 0
            ranNumber()
        } else {
            numberText.text = questions[answerCount].toString() + ""
            numberText.setTextColor(BLACK)
        }

    }

    fun maru(view: View) {
        tableLayout.isVisible=false
        var answer = true
        val number = questions[answerCount]
        trueAnswers[answerCount]="素"
        yourAnswers[answerCount]="〇"

        //素数かどうかの判定
        for (i in 2 until number) {
            if (number % i == 0) {
                answer = false
                Log.d("divisor", number.toString() + "の約数: " + i.toString())
                trueAnswers[answerCount]="--"
                //break
            }
        }
        processing(answer, number)

    }

    fun batsu(view: View) {
        tableLayout.isVisible=false
        var answer = false
        val number = questions[answerCount]
        trueAnswers[answerCount]="素"
        yourAnswers[answerCount]="×"

        //素数かどうかの判定
        for (i in 2 until number) {
            if (number % i == 0) {
                answer = true
                Log.d("divisor", number.toString() + "の約数: " + i.toString())
                trueAnswers[answerCount]="--"
                //break
            }
        }
        processing(answer, number)

    }

    fun resultPrint(){
        mondai1.text=questions[0].toString()
        mondai2.text=questions[1].toString()
        mondai3.text=questions[2].toString()
        mondai4.text=questions[3].toString()
        mondai5.text=questions[4].toString()
        mondai6.text=questions[5].toString()
        mondai7.text=questions[6].toString()
        mondai8.text=questions[7].toString()
        mondai9.text=questions[8].toString()
        mondai10.text=questions[9].toString()

        kaito1.text=trueAnswers[0]
        kaito2.text=trueAnswers[1]
        kaito3.text=trueAnswers[2]
        kaito4.text=trueAnswers[3]
        kaito5.text=trueAnswers[4]
        kaito6.text=trueAnswers[5]
        kaito7.text=trueAnswers[6]
        kaito8.text=trueAnswers[7]
        kaito9.text=trueAnswers[8]
        kaito10.text=trueAnswers[9]

        yourAnswer1.text=yourAnswers[0]
        yourAnswer2.text=yourAnswers[1]
        yourAnswer3.text=yourAnswers[2]
        yourAnswer4.text=yourAnswers[3]
        yourAnswer5.text=yourAnswers[4]
        yourAnswer6.text=yourAnswers[5]
        yourAnswer7.text=yourAnswers[6]
        yourAnswer8.text=yourAnswers[7]
        yourAnswer9.text=yourAnswers[8]
        yourAnswer10.text=yourAnswers[9]

        hantei1.text=judgements[0]
        hantei2.text=judgements[1]
        hantei3.text=judgements[2]
        hantei4.text=judgements[3]
        hantei5.text=judgements[4]
        hantei6.text=judgements[5]
        hantei7.text=judgements[6]
        hantei8.text=judgements[7]
        hantei9.text=judgements[8]
        hantei10.text=judgements[9]


    }
}
