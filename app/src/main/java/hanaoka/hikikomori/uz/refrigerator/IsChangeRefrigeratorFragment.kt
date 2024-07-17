package hanaoka.hikikomori.uz.refrigerator

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import hanaoka.hikikomori.uz.BottomControllable
import hanaoka.hikikomori.uz.MenuItemFoodAdapter
import hanaoka.hikikomori.uz.R
import hanaoka.hikikomori.uz.databinding.FragmentIsChangeRefrigeratorBinding


class IsChangeRefrigeratorFragment : Fragment() {
    private val TAG = "IsChangeRefrigeratorFragment"
    private val REQUEST_IMAGE_CAPTURE = 101
    private val CAMERA_PERMISSION_CODE = 102

    private val foodList : List<String> = listOf()

    private val viewModel by activityViewModels<RefrigeratorViewModel>()
    private var _binding : FragmentIsChangeRefrigeratorBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        (requireActivity() as BottomControllable).setBottomNavVisibility(false)
        _binding = FragmentIsChangeRefrigeratorBinding.inflate(inflater, container, false)
        binding.selectNewButton.setOnClickListener {
            checkCameraPermission()
        }
        binding.selectNowButton.setOnClickListener {
            if(foodList.isEmpty()){
                Toast.makeText(requireContext(), "저장된 냉장고가 없습니다.", Toast.LENGTH_SHORT).show()
            }
            else{
                viewModel.itemData.value = foodList
                findNavController().navigate(R.id.action_isChangeRefrigeratorFragment2_to_lodingFragment)
            }
        }

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView(){
        val foodAdapter = MenuItemFoodAdapter(
            itemList =  foodList,
            changeData =  { view, pos ->
                val pop = PopupMenu(requireContext(), view)

                pop.menuInflater.inflate(R.menu.food_vertac_menu, pop.menu)

                pop.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.modify ->
                            Log.d(TAG,"modify")
                        R.id.delet ->
                            Log.d(TAG,"delet")
                    }
                    false
                }
                pop.show()
            })
        foodAdapter.notifyItemRemoved(0)
        binding.itemRecyclerView.adapter = foodAdapter
    }


    private fun checkCameraPermission() {
        Log.d("TAG", "testesstesstsetest")
        // 카메라 권한이 부여되었는지 확인
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Log.d("TAG", "testesstesstsetest")
            // 권한이 없다면 권한 요청
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.CAMERA),
                CAMERA_PERMISSION_CODE
            )
        } else {
            Log.d("TAG", "testesstesstsetest11111111")
            // 권한이 이미 허용되었다면 사진 촬영 진행
            dispatchTakePictureIntent()
        }
    }

    private fun dispatchTakePictureIntent() {
        // 카메라 앱을 실행하기 위한 Intent 생성
        Log.d("TAG", "testesstesstsetest")
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 권한이 허용되면 사진 촬영 진행
                dispatchTakePictureIntent()
            } else {
                Log.d("TAG", "testesstesstsetest1343151152ㄹㅇㄴㄹㄴㅇ")
                // 권한이 거부되었을 때 처리
                // (예: 사용자에게 권한이 필요하다는 메시지 표시)
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // 사진 찍기 완료 후 결과 이미지를 ImageView에 설정
            val imageBitmap = data?.extras?.get("data") as Bitmap
            viewModel.imageBitmap.value = imageBitmap
            findNavController().navigate(R.id.action_isChangeRefrigeratorFragment2_to_nextFragment2)
        }
    }




}