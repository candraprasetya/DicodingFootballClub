package com.kardusinfo.footballclub

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class InfoActivity : AppCompatActivity() {

    private var name: String = ""
    private lateinit var nameTextView: TextView
    private lateinit var infoTextView: TextView
    private lateinit var v_img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        relativeLayout{
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimaryBackgound)

            verticalLayout {
                padding = dip(16)
                linearLayout {
                    v_img = imageView {
                    }.lparams {
                        width = dip(90)
                        height = dip(90)
                    }
                    imageView(R.drawable.garis) {
                        leftPadding = dip(10)
                    }.lparams(width = wrapContent, height = wrapContent) {}

                    nameTextView = textView {
                        leftPadding = dip(20)
                        textSize = 28F
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryText)
                        gravity = Gravity.CENTER_VERTICAL
                    }
                }

                infoTextView = textView {
                    topPadding = dip(30)
                    textSize = 20F
                    textAlignment = View.TEXT_ALIGNMENT_CENTER //CENTER can be INHERIT GRAVITY TEXT_START TEXT_END VIEW_START VIEW_END
                }
            }

            imageButton{
                imageResource = R.drawable.clickk
                backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimaryBackgound)
            }.lparams {
                //setting button to bottom right of the screen
                bottomMargin = dip(10)
                alignParentBottom()
                alignParentEnd()
                alignParentRight()
                gravity = Gravity.BOTTOM or Gravity.END
            }

            textView {
                leftPadding = dip(10)
                textSize = 20F
                text="@candraaprasetya"
            }.lparams {
                //setting button to bottom right of the screen
                bottomMargin = dip(10)
                alignParentBottom()
                alignParentStart()
                alignParentLeft()
                gravity = Gravity.BOTTOM or Gravity.START
            }

        }

        val intent = intent
        name = intent.getStringExtra("nama")
        val infonya = intent.getStringExtra("info")
        val gambarnya = intent.getIntExtra("gambar",0)

        Glide.with(this).load(gambarnya).into(v_img)

        nameTextView.text = name
        infoTextView.text = infonya

    }
}
