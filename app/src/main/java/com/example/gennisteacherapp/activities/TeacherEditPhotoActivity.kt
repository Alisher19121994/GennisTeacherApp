package com.example.gennisteacherapp.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.gennisteacherapp.R
import com.example.gennisteacherapp.model.login.LoginResponse
import com.example.gennisteacherapp.network.retrofit.RetrofitHttp
import com.sangcomz.fishbun.FishBun
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter
import kotlinx.android.synthetic.main.activity_teacher_edit_photo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeacherEditPhotoActivity : BaseActivity() {

    private var pickedPhoto: Uri? = null
    private var allPhotos = ArrayList<Uri>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_edit_photo)

        initViews()
    }

    private fun initViews() {
        edit_profile_image_id.setOnClickListener {
            pickFishBunPhoto()
        }
//        save_textview_id.setOnClickListener {
//            uploadPhoto()
//        }
    }

    /**
     * Picking a photo by using FishBun Liberary
     */
    private fun pickFishBunPhoto() {
        allPhotos.clear()
        FishBun.with(this)
            .setImageAdapter(GlideAdapter())
            .setMaxCount(1)
            .setMinCount(1)
            .setSelectedImages(allPhotos)
            .startAlbumWithActivityResultCallback(photoLauncher)
    }

    private var photoLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                allPhotos =
                    result.data!!.getParcelableArrayListExtra(FishBun.INTENT_PATH) ?: arrayListOf()
                pickedPhoto = allPhotos[0]
            }
        }
    private fun uploadPhoto(){
        progressBar_photo.visibility = View.VISIBLE
        RetrofitHttp.retrofitService().editProfilePhoto(allPhotos).enqueue(object :Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                progressBar_photo.visibility = View.GONE
                openProfileActivity(context)

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                progressBar_photo.visibility = View.GONE
            }
        })
    }
}