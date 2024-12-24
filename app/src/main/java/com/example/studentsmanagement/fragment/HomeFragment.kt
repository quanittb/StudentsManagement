package com.example.studentsmanagement.fragment

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsmanagement.adapter.ImageAdapter
import com.example.studentsmanagement.adapter.OnClickListener
import com.example.studentsmanagement.base.BaseFragment
import com.example.studentsmanagement.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    companion object {
        fun instance(): HomeFragment {
            return newInstance(HomeFragment::class.java)
        }
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        setListener()
        binding.ivNews.setOnClickListener {
            addFragment(NewFragment.instance())
        }
        var imgAdapter = ImageAdapter(requireContext(), object : OnClickListener{
            override fun onClickDetail() {
                addFragment(NewsDetailFragment.instance())
            }
        })
        var listImg: ArrayList<String> = arrayListOf()
        listImg.add("a")
        listImg.add("b")
        listImg.add("c")
        listImg.add("d")
        imgAdapter.setItems(listImg)
        binding.rcvImg.adapter = imgAdapter
        val space = 16 // Khoảng cách giữa các item (px)

        binding.rcvImg.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
            ) {
                val position = parent.getChildAdapterPosition(view)
                if (position == 0) {
                    outRect.left = space // Thêm padding cho item đầu tiên
                }
                outRect.right = space
            }
        })

    }


    private fun setListener() {
        binding.btnTkb.setOnClickListener {
            addFragment(TKBFragment.instance())
        }
        binding.btnLichthi.setOnClickListener {
            addFragment(LichThiFragment.instance())
        }
        binding.btnNghiphep.setOnClickListener {
            addFragment(NghiPhepFragment.instance())
        }
        binding.btnHocthem.setOnClickListener {
            addFragment(HocThemFragment.instance())
        }
        binding.btnHocphi.setOnClickListener {
            addFragment(HocPhiFragment.instance())
        }
    }
    override fun handlerBackPressed() {
        super.handlerBackPressed()
        requireActivity().run {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStackImmediate();
            }

            if (supportFragmentManager.backStackEntryCount == 0) {
                finish()
            }
        }
    }


}