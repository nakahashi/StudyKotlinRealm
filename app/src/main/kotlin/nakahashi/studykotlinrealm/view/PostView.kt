package nakahashi.studykotlinrealm.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import nakahashi.studykotlinrealm.R
import nakahashi.studykotlinrealm.bindView
import nakahashi.studykotlinrealm.model.Post

class PostView : FrameLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?,
                attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?,
                attrs: AttributeSet?,
                defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?,
                attrs: AttributeSet?,
                defStyleAttr: Int,
                defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    val titleTextView: TextView by bindView<TextView>(R.id.title_text_view)
    val userNameTextView: TextView by bindView<TextView>(R.id.user_name_text_view)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_post, this)
    }

    fun setPost(Post: Post) {
        titleTextView.text = Post.title
        userNameTextView.text = ""
    }
}
